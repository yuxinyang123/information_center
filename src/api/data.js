import axios from '@/libs/api.request'

export const getTableData = () => {
  return axios.request({
    url: 'get_table_data',
    method: 'get'
  })
}

export const getDragList = () => {
  return axios.request({
    url: 'get_drag_list',
    method: 'get'
  })
}

export const errorReq = () => {
  return axios.request({
    url: 'error_url',
    method: 'post'
  })
}

export const saveErrorLogger = info => {
  return axios.request({
    url: 'save_error_logger',
    data: info,
    method: 'post'
  })
}

export const uploadImg = formData => {
  return axios.request({
    url: 'image/upload',
    data: formData
  })
}
export const getWhetherData = () => {
  return axios.request({
    url: '/api/center/weather',
    method: 'get'
  })
}
export const getNews = (pageNum, pageSize) => {
  return axios.request({
    url: '/api/center/hotpot',
    params: {
      pageNum: pageNum,
      pageSize: pageSize
    },
    method: 'get'
  })
}
export const updateWeatherInfo = (cityname) => {
  return axios.request({
    url: 'api/center/weather',
    data: {
      cityname
    },
    method: 'put'
  })
}
export const getStudentCourse = (userKey) => {
  let params = {
    userkey: userKey
  }
  return axios.request({
    url: '/api/center/curriculum',
    params,
    method: 'get'
  })
}

export const get4Tag = () => {
  return axios.request({
    url: '/api/center/fourtag',
    method: 'get'
  })
}
