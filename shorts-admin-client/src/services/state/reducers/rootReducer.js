import { combineReducers } from 'redux';

import fileReducer from './fileApiReducer';

const rootReducer = combineReducers({
    fileReducer
});

export default rootReducer;