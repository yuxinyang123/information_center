import axios from '@/libs/api.request'
import config from '@/config'
export const getVerifyCode = () => {
  return axios.request({
    responseType: 'arraybuffer',
    url: config.localTestUrl + 'api/access/verifycode',
    method: 'get'
  })
}

export const verifyCode = (res) => {
  let data = {
    verifycode: res
  }
  return axios.request({
    url: config.localTestUrl + 'api/access/verifycode',
    data,
    method: 'post'
  })
}

export const putregist = (resemail, respass, resname, resphone, resedunum, resedupass) => {
  let data = {
    userEmail: resemail,
    userPass: respass,
    userName: resname,
    userPhone: resphone,
    educationalNum: resedunum,
    educationalPass: resedupass

  }
  return axios.request({
    url: '/api/user/regist',
    data,
    method: 'post'
  })
}

export const runSpider = () => {
  return axios.request({
    url: '/api/center/spider',
    method: 'get'
  })
}

export const authFace = ({ pic, userEmail }) => {
  let data = {
    pic, userEmail
  }
  return axios.request({
    url: '/api/access/face',
    method: 'post',
    data
  })
}
