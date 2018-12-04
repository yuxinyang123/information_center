<style lang="less">
  @import './login.less';
</style>

<template>
  <div class="login">
    <div class="login-con">
      <Card icon="log-in" title="注册" :bordered="false">
        <div class="form-con">
          <login-form @on-success-valid="handleSubmit"></login-form>
        </div>
      </Card>
    </div>
  </div>
</template>

<script>
import LoginForm2 from '_c/login-form/login-form2'
import { mapActions } from 'vuex'
export default {
   components: {
    LoginForm2
  },
}
</script>

