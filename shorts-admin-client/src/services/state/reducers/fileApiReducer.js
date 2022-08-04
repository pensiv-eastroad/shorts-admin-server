import axios from 'axios';
import { PAGE, LIST } from '../actions/fileApiAction';
import { page, list } from '../actions/fileApiAction';

export function filePages(dispatch, searchOptions = { keyword: '', page: '', size: '', sort: '', direction: '' }, clear) {
    if (clear) {
        dispatch(page({ status: 'init' }));
        return;
    }
    dispatch(page({ status: 'loading' }));
    
    axios.get(`/api/v1/video/files?keyword=${searchOptions.keyword}&page=${searchOptions.page}&size=${searchOptions.size}&sort=${searchOptions.sort}&direction=${searchOptions.direction}`)
        .then(response => dispatch(page({ status:'complete', statusCode: response.status }, [...response.data])))
        .catch(error => dispatch(page({ status:'error', error: error.response }, [])))
}

export function fileList(dispatch, date, clear) {
    if (clear) {
        dispatch(list({ status: 'init' }));
        return;
    }
    dispatch(list({ status: 'loading' }));
    
    var yyyyMMdd = ""
    if (date) {
        let yyyy = date.getFullYear();
        let mm = String(date.getMonth() + 1).padStart(2, '0'); //January is 0!
        let dd = String(date.getDate()).padStart(2, '0');
        yyyyMMdd = yyyy + mm + dd
    }
    axios.get(`/api/v1/video/files/${yyyyMMdd}`)
        .then(response => dispatch(list({ status:'complete', statusCode: response.status }, [...response.data])))
        .catch(error => dispatch(list({ status:'error', error: error.response }, [])))
}


export default function fileReducer(state = { header: { status: 'init'} }, action) {
    switch (action.type) {
        case PAGE:
            return { ...state, data: { page: action.data }, header: action.header };
        case LIST:
            return { ...state, data: { list: action.data }, header: action.header };
        default:
            return state;
    }
}