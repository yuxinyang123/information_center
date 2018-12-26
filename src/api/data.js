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

// export const getUser = () => {
//   return axios.request({
//     url: '/api/user/info',
//     method: 'get'
//   })
// }
export const selectGrade = (pageNum, pageSize) => {
  return axios.request({
    url: '/api/center/grade',
    params: {
      pageNum: pageNum,
      pageSize: pageSize
    },
    method: 'get'
  })
}
export const forcastGrade = (studentID, courseType, testType, gainCredit) => {
  return axios.request({
    url: '/api/center/grade',
    data: {
      studentID,
      courseType,
      testType,
      gainCredit

    },
    method: 'post'
  })
}
export const updatepassword = (newpass) => {
  return axios.request({
    url: '/api/user/pass',
    data: {
      newpass
    },
    method: 'put'

  })
}
export const getLists = (type) => {
  return axios.request({
    url: '/api/res/lists',
    params: {
      type: type
    },
    method: 'get'
  })
}
export const getAverage = () => {
  return axios.request({
    url: '/api/center/semester',
    method: 'get'
  })
}
export const getEssay = (id) => {
  return axios.request({
    url: `/api/res/${id}`,
    method: 'get'
  })
}
export const getComment = (pageNum, pageSize, essayId) => {
  return axios.request({
    url: `/api/res/${essayId}/comment`,
    params: {
      pageNum: pageNum,
      pageSize: pageSize,
      essayId: essayId
    },
    method: 'get'
  })
}
export const addComment = (comment, context, id) => {
  return axios.request({
    url: `api/res/${id}/comment`,
    data: {
      comment,
      context,
      id
    },
    method: 'post'
  })
}
