<style lang="less">
@import "./login.less";
</style>

<template>
  <div class="login">
    <face-auth @handleAuth="handleAuth" :flag="flag"></face-auth>
  </div>
</template>
<script>
import { authFace } from "@/api/login";
import FaceAuth from "_c/face-auth/";
import { mapActions } from "vuex";
export default {
  components: {
    FaceAuth
  },
  data() {
    return {
      flag: false
    };
  },
  methods: {
    ...mapActions(["handleFaceLogin", "getUserInfo"]),
    handleAuth(form) {
      this.$Message.info("正在登录");
      this.handleFaceLogin(form)
        .then(res => {
          this.flag = true;
          this.getUserInfo().then(res => {
            this.$Message.success("登录成功");
            this.$router.push({
              name: this.$config.homeName
            });
          });
        })
        .catch(error => {
          this.flag = false;
          if (error == 404) {
            this.$Message.error("邮箱不正确或人脸未匹配");
          } else {
            this.$Message.error("网络问题");  
          }
        });
    }
  }
};
</script>

