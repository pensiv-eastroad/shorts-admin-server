import React from 'react';

import Grid from '@mui/material/Grid';
import { styled } from '@mui/material/styles';
import Header from './Header';
import Footer from './Footer';

const useStyles = styled(theme => ({
    root: {
        flexGrow: 1
    },
    content: {
        flexGrow: 1,
        transition: theme.transitions.create(['margin', 'width'], {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
        }),
    },
    mainContainer: {
        flexGrow: 1,
        width: '100%',
        height: '100%',
        paddingTop: theme.spacing(8),
    }
}));

export default function Layout(props) {
    const classes = useStyles();
    const { children } = props;
    console.log(props);
    return (
        <div>
            <Grid className={classes.content}>
                <Header />
                <Grid className={classes.mainContainer} >
                    {children}
                </Grid>
                <Footer />
            </Grid>
        </div>
    );
}