import React, { useState, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';

import { styled } from '@mui/material/styles';
import { Box, Paper, Stack, Grid, Container} from '@mui/material';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DesktopDatePicker } from '@mui/x-date-pickers/DesktopDatePicker';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';

import BaseTable from '../components/common/BaseTable';

import { fileList } from '../services/state/reducers/fileApiReducer';

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.text.secondary,
}));

export default function Home() {
    
    const dispatch = useDispatch()
    const columns = [
        { id: 'date', label: 'date' },
        { id: 'fileName', label: 'Name' },
        { id: 'path', label: 'Path' },
        { id: 'size', label: 'Size(MB)' }
    ]
    const fileSelector = useSelector(state => state.fileReducer.data)
    const [ files, setFiles ] = useState([])
    const [ selectedFiles, setSelectedFiles ] = useState([])
    const [ selectedDate, setSelectedDate ] = useState(new Date());

    useEffect(() => {
        fileList(dispatch, selectedDate)
    }, [])

    useEffect(() => {
        if (fileSelector && fileSelector.list) {
            let list = fileSelector.list
            setFiles(list)
        }
    }, [fileSelector])
    
    const handleClickReadFiles = () => {
        fileList(dispatch, selectedDate)
    }
    const handleClickInferenceFiles = () => {
        console.log(selectedFiles);
    }
    const handleChangeDate = (newDate) => {
        setSelectedDate(newDate);
        fileList(dispatch, newDate)
    }

    return (
        <Container maxWidth="md">
            <Box sx={{ width: '100%', paddingTop: '100px' }}>
                <Stack spacing={2}>
                    <Item>
                        <Typography variant="h4" gutterBottom component="div">
                            Shorts Modeling Test Page
                        </Typography>
                    </Item>
                    <Item>
                        <Grid container spacing={2}>
                            <Grid item xs={4} justifyContent="center">
                                <Button variant="contained" onClick={handleClickReadFiles}>
                                    File Read
                                </Button>
                            </Grid>
                            <Grid item xs={4} justifyContent="center">
                                <LocalizationProvider dateAdapter={AdapterDateFns}>
                                    <DesktopDatePicker
                                        value={selectedDate}
                                        minDate={new Date('1987-01-01')}
                                        onChange={(newValue) => handleChangeDate(newValue) }
                                        renderInput={(params) => <TextField {...params} />}
                                        />
                                </LocalizationProvider>
                            </Grid>
                            <Grid item xs={4} justifyContent="center">
                                <Button variant="contained" color='success' onClick={handleClickInferenceFiles}>
                                    Inference
                                </Button>
                            </Grid>
                        </Grid>
                    </Item>
                    <Item>
                        <BaseTable title={""} columns={columns} rows={files} selectedRows={setSelectedFiles}/>
                    </Item>
                </Stack>
            </Box>
        </Container>
    );
}