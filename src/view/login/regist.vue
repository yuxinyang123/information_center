<style lang="less">
  @import './login.less';
</style>

<template>
  <div class="login">
    <div class="login-con">
      <Card icon="log-in" title="注册" :bordered="false">
        <div class="form-con">
          <regist-form @on-success-valid="handleSubmit"></regist-form>
        </div>
      </Card>
    </div>
  </div>
</template>

<script>
import RegistForm from '_c/regist-form'
import { mapActions } from 'vuex'
export default {
   components: {
    RegistForm
  },
}
</script>

