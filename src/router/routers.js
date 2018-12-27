import Main from '@/components/main'
import parentView from '@/components/parent-view'

/**
 * iview-admin中meta除了原生参数外可配置的参数:
 * meta: {
 *  title: { String|Number|Function }
 *         显示在侧边栏、面包屑和标签栏的文字
 *         使用'{{ 多语言字段 }}'形式结合多语言使用，例子看多语言的路由配置;
 *         可以传入一个回调函数，参数是当前路由对象，例子看动态路由和带参路由
 *  hideInBread: (false) 设为true后此级路由将不会出现在面包屑中，示例看QQ群路由配置
 *  hideInMenu: (false) 设为true后在左侧菜单不会显示该页面选项
 *  notCache: (false) 设为true后页面在切换标签后不会缓存，如果需要缓存，无需设置这个字段，而且需要设置页面组件name属性和路由配置的name一致
 *  access: (null) 可访问该页面的权限数组，当前路由设置的权限会影响子路由
 *  icon: (-) 该页面在左侧菜单、面包屑和标签导航处显示的图标，如果是自定义图标，需要在图标名称前加下划线'_'
 *  beforeCloseName: (-) 设置该字段，则在关闭当前tab页时会去'@/router/before-close.js'里寻找该字段名对应的方法，作为关闭前的钩子函数
 * }
 */

export default [{
  path: '/login',
  name: 'login',
  meta: {
    title: 'Login - 登录',
    hideInMenu: true
  },
  component: () => import('@/view/login/login.vue')
},
{
  path: '/regist',
  name: 'regist',
  meta: {
    title: 'Regist - 注册',
    hideInMenu: true
  },
  component: () => import('@/view/login/regist.vue')
},
{
  path: '/face',
  name: 'face',
  meta: {
    title: 'Face - 人脸认证',
    hideInMenu: true
  },
  component: () => import('@/view/login/face.vue')
},
{
  path: '/forget',
  name: 'forget',
  props: (route) => ({
    pass: route.query.pass
  }),
  meta: {
    title: '密码找回',
    hideInMenu: true
  },
  component: () => import('@/view/login/forget.vue')
},
{
  path: '/',
  name: '_home',
  redirect: '/home',
  component: Main,
  meta: {
    hideInMenu: false,
    title: '首页',
    notCache: true
  },
  children: [{
    path: '/home',
    name: 'home',
    meta: {
      hideInMenu: false,
      title: '首页',
      notCache: true,
      icon: 'md-home'
    },
    component: () => import('@/view/single-page/home')
  }]
},
{
  path: '/message',
  name: 'message',
  component: Main,
  meta: {
    hideInBread: true,
    hideInMenu: true,
    title: '消息中心'
  },
  children: [{
    path: 'message_page',
    name: 'message_page',
    meta: {
      icon: 'md-notifications',
      title: '消息中心'
    },
    component: () => import('@/view/single-page/message/index.vue')
  }]
},
{
  path: '/grade',
  name: 'grade',
  meta: {
    icon: 'logo-buffer',
    title: '成绩'
  },
  component: Main,
  children: [{
    path: 'distribution',
    name: 'gradedistribution',
    meta: {
      icon: 'md-trending-up',
      title: '成绩分布'
    },
    component: () => import('@/view/components/grade/distribution.vue')
  },
  {
    path: 'analyze',
    name: 'gradeanalyze',
    meta: {
      icon: 'ios-ionitron-outline',
      title: '成绩分析'
    },
    component: () => import('@/view/components/grade/analyze.vue')
  }
  ]
},
{
  path: '/update',
  name: 'update',
  meta: {
    icon: 'md-person',
    title: '个人中心'
  },
  component: Main,
  children: [{
    path: 'update_information',
    name: 'update_information',
    meta: {
      icon: 'ios-document',
      title: '个人信息'
    },
    component: () => import('@/view/update/update-information.vue')
  },
  {
    path: 'update_password',
    name: 'update_password',
    meta: {
      icon: 'ios-lock-outline',
      title: '修改密码'
    },
    component: () => import('@/view/update/update-password.vue')
  },
  {
    path: 'add_face',
    name: 'add_face',
    meta: {
      icon: 'ios-happy-outline',
      title: '修改人脸'
    },
    component: () => import('@/view/update/update-face.vue')
  }
  ]
},
{
  path: '/forum',
  name: 'forum',
  meta: {
    icon: 'md-menu',
    title: '论坛'
  },
  component: Main,
  children: [{
    path: 'recruithome',
    name: 'recruithome',
    props: {
      typeName: '招聘信息'
    },
    meta: {
      icon: 'md-funnel',
      title: '招聘首页'
    },
    component: () => import('@/view/forum/forumhome.vue')
  },
  {
    path: 'jobhome',
    name: 'jobhome',
    props: {
      typeName: '兼职信息'
    },
    meta: {
      icon: 'md-funnel',
      title: '兼职首页'
    },
    component: () => import('@/view/forum/forumhome.vue')
  },
  {
    path: 'matchhome',
    name: 'matchhome',
    props: {
      typeName: '比赛信息'
    },
    meta: {
      icon: 'md-funnel',
      title: '比赛首页'
    },
    component: () => import('@/view/forum/forumhome.vue')
  },
  {
    path: 'content/:type/:id',
    name: '内容页',
    props: true,
    meta: {
      hideInMenu: true,
      notCache: true,
      title: (route) => `${route.params.type}-${route.params.id}`
    },
    component: () => import('@/view/forum/content.vue')
  }
  ]
},

{
  path: '*',
  name: 'error_404',
  meta: {
    hideInMenu: true
  },
  component: () => import('@/view/error-page/404.vue')
}
]
