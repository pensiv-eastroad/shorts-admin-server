import React from 'react';

import { styled } from '@mui/material/styles';
import { AppBar, Toolbar, Box, Typography } from '@mui/material'

const useStyles = styled(theme => ({
    root: {
        flexGrow: 1,
    },
    title: {
        flexGrow: 1,
    },
    appbar: {
        backgroundColor: 'rgba(0, 0, 0, 0)',
    },
    toolbar: {
        backgroundColor: 'rgb(25, 118, 210, 1.0)',
    },
    buttonLabel: {
        textTransform: 'capitalize',
    },
    icon: {
        border: '0',
        marginRight: '0.2rem',
    },
    titleButtonRoot: {
        border: 0,
        fontSize: '0.8em',
        color: '#ffffff',
    }
}));

export default function Header(props) {

    const classes = useStyles();

    return (
        <div className={classes.root}>
            <AppBar position="fixed">
                <Toolbar className={classes.toolbar}>
                    <Box>
                        {/* <img className={classes.icon} src="/logo.png"></img> */}
                    </Box>
                    <Typography align="left" variant="h5" className={classes.title}>
                        
                    </Typography>
                    
                </Toolbar>
            </AppBar>
        </div>
    );
}