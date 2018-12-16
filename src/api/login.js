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

export const regist = ({ userEmail, userPass, userName, userPhone, educationalNum, educationalPass }) => {
  let data = {
    userEmail,
    userPass,
    userName,
    userPhone,
    educationalNum,
    educationalPass
  }
  return axios.request({
    url: 'api/user/regist',
    data,
    method: 'post'
  })
}
