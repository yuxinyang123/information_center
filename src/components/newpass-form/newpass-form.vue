<template>
  <div class="forget">
    <h1>输入新密码</h1>
    <Form :model="form" ref="passRef">
      <FormItem label="密码：" prop="pass" :rules="rule.pass">
        <Input type="password" placeholder="请输入密码" v-model="form.pass"></Input>
      </FormItem>
      <FormItem label="重复密码：" prop="repeatPass" :rules="rule.repeatPass">
        <Input type="password" placeholder="请输入密码" v-model="form.repeatPass"></Input>
      </FormItem>
      <Row type="flex" justify="center" :gutter="12">
        <Col>
          <Button @click="handleReset">重置</Button>
        </Col>
        <Col>
          <Button type="primary" @click="handleSend">更改</Button>
        </Col>
      </Row>
    </Form>
  </div>
</template>
<script>
import { chargePass } from "@/api/login";
export default {
  name: "NewpassForm",
  props: {
    pass: String
  },
  data() {
    let validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("密码不能为空"));
      } else {
        this.$refs.passRef.validateField("repeatPass");
        callback();
      }
    };
    let validateRepeatPass = (rule, value, callback) => {
      if (value != this.form.pass) {
        callback(new Error("两次密码输入不同"));
      } else {
        callback();
      }
    };
    return {
      form: {
        pass: "",
        repeatPass: ""
      },
      rule: {
        pass: [
          {
            required: true,
            validator: validatePass,
            trigger: "blur"
          }
        ],
        repeatPass: [
          {
            required: true,
            validator: validateRepeatPass,
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    handleReset() {
      this.$refs.passRef.resetFields();
    },
    handleSend() {
      this.$refs.passRef.validate(valid => {
        if (valid) {
          chargePass(this.pass, this.form.pass)
            .then(res => {
              res = res.data;
              if (res.code === 200) {
                this.$Message.success("修改成功，跳转登录页面");
                setTimeout(() => {
                  this.$router.push("login");
                }, 2000);
              } else if (res.code === 404) {
                this.$Message.error("请重新发送邮件");
                setTimeout(() => {
                    this.$router.push("forget");
                  this.$emit("changeFlag");
                }, 2000);
              }
            })
            .catch(res => {
              console.log(res);
            });
        }
      });
    }
  }
};
</script>

