import React from 'react';
import { Container, Typography } from '@mui/material';

export default function Footer(props) {

    return (
        <div className="footer">
            <Container maxWidth="lg">
                <Typography variant="caption">
                    Copyright © 2022 Pensiv Co., Ltd. All Rights Reserved
                </Typography>
            </Container>
        </div>
    );
}