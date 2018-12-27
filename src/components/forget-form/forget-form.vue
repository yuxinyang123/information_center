<template>
  <div class="forget">
    <h1>密码找回</h1>
    <Form :model="form" ref="formRef">
      <FormItem label="E-mail：" prop="mail" :rules="rule.mail">
        <Input placeholder="Enter your e-mail" v-model="form.mail"></Input>
      </FormItem>
      <Row type="flex" justify="center" :gutter="12">
        <Col>
          <Button @click="handleReset">重置</Button>
        </Col>
        <Col>
          <Button type="primary" :disabled="flag" @click="handleSend">发送</Button>
          <span v-show="textFlag">{{time}}后重新发送</span>
        </Col>
      </Row>
    </Form>
  </div>
</template>
<script>
import { sendForgetEmail } from "@/api/login";
export default {
  props: {
    pass: String
  },
  data() {
    return {
      flag: false,
      textFlag: false,
      time: 0,
      form: {
        mail: ""
      },
      rule: {
        mail: [
          {
            required: true,
            type: "email",
            trigger: "blur",
            message: "请输入正确的邮箱！"
          }
        ]
      }
    };
  },
  methods: {
    handleReset() {
      this.$refs.formRef.resetFields();
   
    },
    handleSend() {
      this.$refs.formRef.validate(valid => {
        if (valid) {
          sendForgetEmail(this.form.mail)
          this.flag = true;
          this.textFlag = true;
          this.startTime(() => {
            this.flag = false;
            this.textFlag = false;
          });
        }
      });
    },
    startTime(resolve) {
      let i = 30;
      let time = setInterval(() => {
        if (i == -1) {
          resolve();
          clearInterval(time);
          this.time = 0;
        } else {
          this.time = i;
          i--;
        }
      }, 1000);
    }
  }
};
</script>
<style lang="less">
.forget {
  background-color: rgba(245, 245, 245, 0.904);
  position: absolute;
  left: 33%;
  right: 33%;
  top: 15%;
  margin: auto;
  width: 500px;
  padding: 10px;
  border-radius: 10px;
  h1 {
    text-align: center;
  }
  form FormItem {
    width: 450px;
  }
}
</style>

