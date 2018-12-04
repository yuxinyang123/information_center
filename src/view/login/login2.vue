<style lang="less">
  @import './login.less';
</style>

<template>
  <div class="login">
    <div class="login-con">
      <Card icon="log-in" title="注册" :bordered="false">
        <div class="form-con">
          <Form >
              <FormItem >
                <Input  placeholder="请输入用户名">
                  <span >
                    <Icon :size="16" type="ios-person"></Icon>
                  </span>
                </Input>
              </FormItem>
              <FormItem >
                <Input type="password" placeholder="请输入密码">
                  <span >
                    <Icon :size="14" type="md-lock"></Icon>
                  </span>
                </Input>
              </FormItem>
              <FormItem >
                <Input type="text" placeholder="请输入邮箱">
                  <span >
                    <Icon :size="14" type="md-lock"></Icon>
                  </span>
                </Input>
              </FormItem>
              <FormItem>
              
                    <Button type="primary" long>注册</Button>
               
              </FormItem>
          </Form>

           <!--    <form style="margin:0">
              <table width="0" border="0" cellspacing="0" cellpadding="0">
              <tr>
              <td>用户名：</td>
              <td><input type="text" name="username"/></td>
              </tr>
              <tr>
              <td>密码： </td>
              <td><input type="password" name="password"/></td>
              </tr>
              <tr>
              <td>电子邮箱：</td>
              <td><input type="text" name="Email"/></td>
              </tr>

              <tr>
              <td>性别：</td>
              <td><input type="radio" name="gender" value="1" checked/>男<input type="radio" name="gender" value="0"/>女</td>
              </tr>    
              </tr>
              <tr>
              <td colspan="2">
              <Button type="primary" long>注册</Button>
              </td>
              </tr>
              </table>
              </form>
          <p class="login-tip">输入用户名和密码</p> -->
        </div>
      </Card>
    </div>
  </div>
</template>

<script>
//import LoginForm2 from '../../../components/login-form/login-form2'
import { mapActions } from 'vuex'
export default {

  
}
</script>

