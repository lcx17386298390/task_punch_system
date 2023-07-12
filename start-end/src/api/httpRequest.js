import axios from "axios"

axios.defaults.timeout=50000

function doGet(url,params){
    return axios({
        url:url,
        method: 'get',
        params : params
    });
}

function doPostJson(url,params){
    return axios({
        url:url,
        method: 'post',
        data : params
    });
}

export  {doGet,doPostJson}