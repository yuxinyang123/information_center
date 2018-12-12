import axios from '@/libs/api.request'

export const getVerifyCode = () => {
    return axios.request({
        responseType: "arraybuffer",
        url: "http://127.0.0.1:8088/api/access/verifycode",
        method: "get",
    })
}

export const verifyCode = (res) =>{
    let data = {
        verifycode: res,
    }
    return axios.request({
        url: "http://127.0.0.1:8088/api/access/verifycode",
        data,
        method: "post"
    })
}