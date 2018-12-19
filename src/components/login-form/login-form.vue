<template>
  <Form ref="loginForm" :model="form" :rules="rules" @keydown.enter.native="handleSubmit">
    <FormItem prop="userName">
      <Input v-model="form.userName" placeholder="请输入登录邮箱">
      <span slot="prepend">
        <Icon :size="16" type="ios-person"></Icon>
      </span>
      </Input>
    </FormItem>
    <FormItem prop="password">
      <Input type="password" v-model="form.password" placeholder="请输入密码">
      <span slot="prepend">
        <Icon :size="14" type="md-lock"></Icon>
      </span>
      </Input>
    </FormItem>
    <FormItem prop="code">
      <Row :gutter="8" type="flex" justify="center" align="top">
        <Col span="12">
        <Input v-model="form.code" @on-change="handleCode" placeholder="请输入验证码">
        <span slot="prepend">
          <Icon :size="14" type="md-checkmark" />
        </span>
        </Input>
        </Col>
        <Col span="2">
        <Icon v-show="flag" :size="20" type="md-checkmark" color="#19be6b" />
        </Col>
        <Col span="10">
        <img @click="getCode" :src="verifyImgSrc" width="110" height="50">
        </Col>
      </Row>
    </FormItem>
    <FormItem>
      <Row :gutter="12">
        <Col span="12">
        <Button @click="handleSubmit" type="primary" long>登录</Button>
        </Col>
        <Col span="12">
        <router-link to="/regist">
          <Button type="primary" long>注册</Button>
        </router-link>
        </Col>
      </Row>
      <Row>
        <Col span="24">
        <a href="http://www.baidu.com">忘记密码</a>
        </Col>
      </Row>
    </FormItem>
  </Form>
</template>
<script>
  import {
    getVerifyCode,
    verifyCode
  } from "@/api/login";
  import config from "@/config";
  // console.log(getVerifyCode);
  export default {
    name: "LoginForm",
    props: {
      userNameRules: {
        type: Array,
        default: () => {
          return [{
            required: true,
            message: "账号不能为空",
            trigger: "blur"
          }];
        }
      },
      passwordRules: {
        type: Array,
        default: () => {
          return [{
            required: true,
            message: "密码不能为空",
            trigger: "blur"
          }];
        }
      },
      codeRules: {
        type: Array,
        default: () => {
          return [{
            len: 4,
            required: true,
            message: "验证码必须是4位",
            trigger: "blur"
          }];
        }
      }
    },
    data() {
      return {
        verifyImgSrc: config.localTestUrl + "api/access/verifycode",
        flag: false,
        form: {
          userName: "",
          password: "",
          code: ""
        }
      };
    },
    computed: {
      rules() {
        return {
          userName: this.userNameRules,
          password: this.passwordRules,
          code: this.codeRules
        };
      }
    },
    methods: {
      handleSubmit() {
        this.$refs.loginForm.validate(valid => {
          if (config.auth === false) this.flag = true
          if (valid && this.flag == true) {
            this.$emit("on-success-valid", {
              userName: this.form.userName,
              password: this.form.password,
              code: this.form.code
            });
            this.$Message.success("正在登录");
          } else {
            this.$Message.error("登录失败登录名不存在或密码错误");
            this.getCode()
          }
        });
      },
      getCode() {
        this.verifyImgSrc =
          config.localTestUrl + "api/access/verifycode?random=" + Math.random();
      },
      handleCode() {
        if (this.form.code.length == 4) {
          verifyCode(this.form.code)
            .then(res => {
              res = res.data;
              if (res.code == 200) {
                this.flag = true;
                console.log(res);
              }
            })
            .catch(err => {
              console.log(err);
            });
        } else {
          this.flag = false;
        }
      }
    }
  };

</script>
