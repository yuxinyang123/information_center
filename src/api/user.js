import axios from '@/libs/api.request'

export const login = ({ userName, password, code }) => {
  const data = {
    email: userName,
    password: password,
    verifyCode: code
  }
  return axios.request({
    url: 'api/access/user',
    data,
    method: 'post'
  })
}

export const getUserInfo = (token) => {
  return axios.request({
    url: 'api/user/info',
    params: {
      token: token
    },
    method: 'get'
  })
}

export const updateUserInfo = (num, password, signature, major, Class, academy, sex, age, location) => {
  return axios.request({
    url: '/api/user/info',
    params: {
      num,
      password,
      signature,
      major,
      class: Class,
      academy,
      sex,
      age,
      location
    },
    method: 'put'
  })
}

export const logout = (token) => {
  return axios.request({
    url: 'logout',
    method: 'post'
  })
}

export const getUnreadCount = () => {
  return axios.request({
    url: 'message/count',
    method: 'get'
  })
}

export const getMessage = () => {
  return axios.request({
    url: 'message/init',
    method: 'get'
  })
}

export const getContentByMsgId = msg_id => {
  return axios.request({
    url: 'message/content',
    method: 'get',
    params: {
      msg_id
    }
  })
}

export const hasRead = msg_id => {
  return axios.request({
    url: 'message/has_read',
    method: 'post',
    data: {
      msg_id
    }
  })
}

export const removeReaded = msg_id => {
  return axios.request({
    url: 'message/remove_readed',
    method: 'post',
    data: {
      msg_id
    }
  })
}

export const restoreTrash = msg_id => {
  return axios.request({
    url: 'message/restore',
    method: 'post',
    data: {
      msg_id
    }
  })
}

export const addUserFace = base64 => {
  return axios.request({
    url: '/api/user/face',
    method: 'put',
    data: {
      base64
    }
  })
}
