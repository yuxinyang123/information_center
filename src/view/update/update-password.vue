<template>
  <div>
    <Row type="flex" justify="center">
      <Form :rules="ruleUpdate" :model="formModel" ref="updateForm">
        <FormItem label="密码" prop="newpasswd">
          <Input type="password" v-model="formModel.newpasswd" placeholder="Enter your password "> </Input>
        </FormItem>
        <FormItem label="确认密码：" prop="passwdCheck">
          <Input type="password" v-model="formModel.passwdCheck" placeholder="Enter your password again"></Input>
        </FormItem>
        <Row type="flex" justify="center" style="width:400px">
          <div>
            <Button type="primary" @click="handleSubmit()">修改</Button>
            <Button @click="handleReset('updateForm')" style="margin-left: 8px">重置</Button>
          </div>
        </Row>
      </Form>
    </Row>
  </div>
</template>

<script>
import {
   updatepassword 
  } from "@/api/data";
  export default {
    name: 'updateForm',
    components: {

    },
    data() {
      const validatePass = (rule, value, callback) => {
        if (value === "") {
          callback(new Error("请输入您的密码"));
        } else {
          if (this.updateForm.passwdCheck !== "") {
            // 对第二个密码框单独验证
            this.$refs.formModel.validateField("passwdCheck");
          }
          callback();
        }
      };
      const validatePassCheck = (rule, value, callback) => {
        if (value === "") {
          callback(new Error("请再次输入密码"));
        } else if (value !== this.formModel.newpasswd) {
          callback(new Error("两次密码输入不一致"));
        } else {
          callback();
        }
      }
      return {
        formModel: {
          newpasswd: "",
          passwdCheck: "",

        },
        updateForm: {
          newpasswd: "",
          passwdCheck: ""
        },
        ruleUpdate: {
          newpasswd: [{
            required: true,
            validator: validatePass,
            trigger: "blur"
          }],
          passwdCheck: [{
            required: true,
            validator: validatePassCheck,
            trigger: "blur"
          }],
        }
      }
    },

    methods: {
        handleSubmit() {
      this.$refs.updateForm.validate(valid => {
        if (valid) {
          updatepassword(
            this.formModel.newpasswd,        
          )
            .then(res => {
             
            })
            .catch(err => {
              console.log(err);
            });
        }
      });
    },
        handleReset(name) {
      this.$refs[name].resetFields();
    }
    },
    mounted() {

    }
  };

</script>
<style>

</style>
