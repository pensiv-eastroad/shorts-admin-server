export const PAGE = "FILE_API_PAGE";
export const LIST = "FILE_API_LIST";

export function page(header, data){
    return {
        type: PAGE,
        header,
        data
    }
}

export function list(header, data) {
    return {
        type: LIST,
        header,
        data
    }
}
