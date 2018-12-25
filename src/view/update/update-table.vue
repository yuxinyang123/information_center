<template>
  <div>
    <Card>
      <h1 style="text-align:center">编辑资料</h1>
      <Form :rules="ruleRegist" :model="formModel" ref="updateForm" :label-width="90">
        <FormItem label="学院：" prop="academy">
          <Input v-model="formModel.academy" placeholder="Enter your academy"></Input>
        </FormItem>
        <FormItem label="班级：" prop="Class">
          <Input type="text" v-model="formModel.Class" placeholder="Enter your class"></Input>
        </FormItem>
        <FormItem label="主修：" prop="major">
          <Input type="text" v-model="formModel.major" placeholder="Enter your major"></Input>
        </FormItem>
        <FormItem label="性别：" prop="sex">
          <RadioGroup v-model="formModel.sex">
            <Radio label="male">男</Radio>
            <Radio label="female">女</Radio>
          </RadioGroup>
        </FormItem>
        <FormItem label="个人签名：" prop="signature">
          <Input type="text" v-model="formModel.signature" placeholder="Enter your signature"></Input>
        </FormItem>
        <FormItem label="用户名：" prop="username">
          <Input v-model="formModel.username" placeholder="Enter your username"></Input>
        </FormItem>
        <FormItem label="电话：" prop="phone">
          <Input v-model="formModel.phone" placeholder="Enter your tel"></Input>
        </FormItem>
        <FormItem label="教务学号：" prop="num">
          <Input type="text" v-model="formModel.num" placeholder="Enter your num"></Input>
        </FormItem>
        <FormItem label="教务密码：" prop="password">
          <Input type="text" v-model="formModel.password" placeholder="Enter your password"></Input>
        </FormItem>

        <Row type="flex" justify="center">
          <div>
            <Button type="primary" @click="handleSubmit()">保存</Button>
            <Button type="primary" @click="handleReset('updateForm')" style="margin-left: 8px">重置</Button>
          </div>
        </Row>
      </Form>
    </Card>
  </div>
</template>

<script>
  import {
    getUserInfo,
    updateUserInfo
  } from "@/api/user";
  export default {
    name: "registForm",
    components: {},
    data() {
      return {
        formModel: {
          num: '',
          password: '',
          signature: "",
          major: '',
          Class: '',
          academy: '',
          sex: '',
          age: 0,
          location: "",
          username:'',
          phone:''
        },

        ruleRegist: {
          academy: [{
            required: false,
            trigger: "blur"
          }],
          Class: [{
            required: false,
            trigger: "blur"
          }],
          major: [{
            required: false,
            trigger: "blur"
          }],
          num: [{
            required: true,
            trigger: "blur"
          }],
          signature: [{
            required: false,
            trigger: "blur"
          }],
          phone: [{
            required: false,
            trigger: "blur"
          }],
          username: [{
            required: false,
            trigger: "blur"
          }],
          password: [{
            required: true,
            trigger: "blur"
          }]
        }
      };
    },

    methods: {
      getUserInfo() {
        let token = this.$store.state.user.token;
        getUserInfo(token)
          .then(res => {
            res = res.data.data;
            console.log(res);
            this.formModel.academy = res.academy;
            this.formModel.Class = res.class;
            this.formModel.major = res.major;
            this.formModel.num = res.num;
            this.formModel.phone = res.phone;
            this.formModel.signature = res.signature;
            this.formModel.username = res.username;
          })
          .catch(err => {
            console.log(err);
          });
      },
      handleSubmit() {
        this.$refs.updateForm.validate(valid => {
          if (valid) {
            updateUserInfo(
                this.formModel.academy,
                this.formModel.Class,
                this.formModel.num,
                this.formModel.major,
                this.formModel.age,
                this.formModel.location,
                this.formModel.password,
                this.formModel.signature,
                this.formModel.sex
              )
              .then(res => {
                res = res.data;
                console.log(res);
                this.$Message.success('修改成功!');
              })
              .catch(err => {
                console.log(err);
                this.$Message.error('修改失败');
              });
          }
        })
      },


      handleReset(name) {
        this.$refs[name].resetFields();
        this.getUserInfo()
      }
    },
    mounted() {
      this.getUserInfo();
    }
  };

</script>
<style>
  .regist {
    background-color: rgb(255, 255, 255);
    margin: auto;
    width: 500px;
    padding: 10px;
    border-radius: 10px;
  }

  .regist h1 {
    text-align: center;
  }

  .regist form FormItem {
    width: 450px;
  }

</style>
