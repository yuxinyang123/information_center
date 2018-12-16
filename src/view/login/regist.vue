<style lang="less">
@import "./login.less";
</style>
<style>
.regist {
  background-color: rgba(245, 245, 245, 0.904);
  position: absolute;

  left: 33%;
  right: 33%;
  top: 20%;
  margin: auto;
  width: 500px;
  padding: 10px;
  border-radius: 10px;
}
.regist h1 {
  text-align: center;
}
</style>
<template>
  <div class="login">
    <div class="regist">
      <h1>注册</h1>
      <Form
        :rules="ruleRegist"
        :model="formModel"
        ref="registForm"
        :label-width="90"
        label-position="left"
      >
        <FormItem label="E-mail：" prop="mail">
          <Input v-model="formModel.mail" placeholder="Enter your e-mail"></Input>
        </FormItem>
        <FormItem label="密码：" prop="passwd">
          <Input type="password" v-model="formModel.passwd" placeholder="Enter your password"></Input>
        </FormItem>
        <FormItem label="确认密码：" prop="passwdCheck">
          <Input
            type="password"
            v-model="formModel.passwdCheck"
            placeholder="Enter your password again"
          ></Input>
        </FormItem>
        <FormItem label="用户名：" prop="username">
          <Input type="text" v-model="formModel.username" placeholder="Enter your username"></Input>
        </FormItem>
        <FormItem label="手机号：" prop="phone">
          <Input type="text" v-model="formModel.phone" placeholder="Enter your phonenumber"></Input>
        </FormItem>
        <FormItem label="教务账号：" prop="eduaccount">
          <Input
            type="text"
            v-model="formModel.eduaccount"
            placeholder="Enter your educational account"
          ></Input>
        </FormItem>
        <FormItem label="教务密码：" prop="edupasswd">
          <Input
            type="password"
            v-model="formModel.edupasswd"
            placeholder="Enter your educational password "
          ></Input>
        </FormItem>
        <Row type="flex" justify="center">
          <div>
            <Button type="primary" @click="handleSubmit('registForm')">Submit</Button>
            <Button @click="handleReset('registForm')" style="margin-left: 8px">Reset</Button>
          </div>
        </Row>
      </Form>
    </div>
  </div>
</template>

<script>
import RegistForm from "_c/regist-form";
import { mapActions } from "vuex";
import regist from "@/api/login"
export default {
  name: "registForm",
  components: {
    RegistForm
  },

  data() {
    const validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入您的密码"));
      } else {
        if (this.registForm.passwdCheck !== "") {
          // 对第二个密码框单独验证
          this.$refs.formModel.validateField("passwdCheck");
        }
        callback();
      }
    };
    const validatePassCheck = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.formModel.passwd) {
        callback(new Error("两次密码输入不一致"));
      } else {
        callback();
      }
    };
    return {
      formModel: {
        mail: "",
        passwd: "",
        passwdCheck: "",
        username: "",
        phone: "",
        eduaccount: "",
        edupasswd: ""
      },
      registForm: {
        passwd: "",
        passwdCheck: ""
      },
      ruleRegist: {
        mail: [
          { required: true, message: "邮箱不能为空", trigger: "blur" },
          { type: "email", message: "邮箱输入有误", trigger: "blur" }
        ],
        passwd: [{ required: true, validator: validatePass, trigger: "blur" }],
        passwdCheck: [
          { required: true, validator: validatePassCheck, trigger: "blur" }
        ],
        username: [
          { required: true, message: "用户名不能为空", trigger: "blur" }
        ],
        eduaccount: [
          { required: true, message: "账号不能为空", trigger: "blur" }
        ],
        phone: [{ required: true, message: "手机号不能为空", trigger: "blur" }],
        edupasswd: [
          { required: true, message: "密码不能为空", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    handleSubmit(name) {
      this.$refs[name].validate(valid => {
        if (valid) {
          regist(this.formModel.mail)
          this.$Message.success("Success!");
        } else {
          this.$Message.error("Fail!");
        }
      });
    },
    handleReset(name) {
      this.$refs[name].resetFields();
    }
  }
};
</script>



