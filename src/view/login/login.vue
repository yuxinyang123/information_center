<style lang="less">
@import "./login.less";
</style>

<template>
  <div class="login">
    <div class="login-con">
      <Card icon="log-in" title="欢迎登录" :bordered="false">
        <div class="form-con">
          <login-form @on-success-valid="handleSubmit"></login-form>
          <p class="login-tip">输入邮箱和密码，没有账户请先注册</p>
        </div>
      </Card>
    </div>
  </div>
</template>

<script>
import LoginForm from "_c/login-form";
import { mapActions } from "vuex";
import getVerifyCode from "@/api/login";
export default {
  components: {
    LoginForm
  },
  methods: {
    ...mapActions(["handleLogin", "getUserInfo"]),
    handleSubmit({ userName, password, code }) {
      this.handleLogin({ userName, password, code }).then(res => {
        console.log("handlelogin")
        this.getUserInfo().then(res => {
          console.log("getuserinfo:"+res)
          this.$Message.success("登录成功");
          this.$router.push({
            name: this.$config.homeName
          });
        });
      });
    }
  }
};
</script>

