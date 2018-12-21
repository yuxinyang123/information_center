<style lang="less">
@import "./login.less";
</style>

<template>
  <div class="login">
    <forget-form v-show="!flag" :pass="pass"></forget-form>
    <newpass-form v-show="flag" :pass="pass" @changeFlag="changeFlag()" ></newpass-form>
  </div>
</template>

<script>
import ForgetForm from "_c/forget-form";
import NewpassForm from "_c/newpass-form";
import { sendForgetEmail } from "@/api/login";
export default {
  components: {
    ForgetForm,
    NewpassForm
  },
  props: {
    pass: String
  },
  data() {
    return {
      flag: false
    };
  },
  methods: {
    changeFlag(){
      this.flag = !this.flag;
    }
  },
  created() {
    if (this.pass != null) {
      this.flag = true;
    }
  }
};
</script>

