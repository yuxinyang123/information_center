# 一校通——校园信息平台
## GitHub地址
* <a>https://github.com/yuxinyang123/information_center/</a>
* <b>注意</b>：tag中有两个版本对应不同的平台
* feature-frontend分支为前端分支
* 其余为后台分支，master为稳定版本，feature为开发版本
## 部署说明
* 仓库配置
    * 务必在本地克隆两个仓库，分别checkout到前端与后台两个分支
* 数据库配置
  1. 后台yml文件中修改相应配置
  2. 创建相应数据库
  3. 运行resource中的sql脚本
* 部署开发环境(windows)
  * 前端
    1. 配置nodejs环境，安装npm(cnpm)
    2. 输入命令
        * npm install
        * npm run dev(默认8080端口)
  * 后台
    1. 使用任意一款ide
    2. 载入maven依赖
    3. 直接运行启动类(内置tomcat，8088端口)
* 部署生产环境(linux)
  * 前端
    1. 依旧需要node环境
    2. 输入命令
        * npm install
        * npm run build(注意，生产环境api访问8090端口)
    3. 在项目的根目录生成dist文件夹，必须挂在到服务器上才可使用
        * serve
        * nginx
        * httpd
        * ……
  * 后台
    1. mvn install
    2. 将jar包上传到服务器
    3. 运行jar包，保持后台
    4. nginx 载入 information_center.conf配置
    5. enjoy