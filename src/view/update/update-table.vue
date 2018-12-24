<template>
  <div class="login" >
    <Card>
      <h1>编辑资料</h1>
      <Form :rules="ruleRegist" :model="formModel" ref="registForm" :label-width="90">
        <FormItem label="学院：" prop="academy">
          <Input v-model="formModel.academy" placeholder="Enter your academy"></Input>
        </FormItem>
        <FormItem label="班级：" prop="Class">
          <Input type="text" v-model="formModel.Class" placeholder="Enter your class"></Input>
        </FormItem>
        <FormItem label="主修：" prop="major">
          <Input type="text" v-model="formModel.major" placeholder="Enter your major"></Input>
        </FormItem>
        <FormItem label="个人签名：" prop="signature">
<<<<<<< HEAD
          <Input
            type="text"
            v-model="formModel.signature"
            placeholder="Enter your signature"
          ></Input>
        </FormItem>
        <FormItem label="邮箱：" prop="userEmail">
          <Input
            type="text"
            v-model="formModel.edupasswd"
            placeholder="Enter your educational emil"
          ></Input>
=======
          <Input type="text" v-model="formModel.signature" placeholder="Enter your signature"></Input>
>>>>>>> 94ddc883e16538b1a3ba264a701a9f67f76cce1d
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
            <Button type="primary" @click="handleSubmit()">提交</Button>
            <Button type="primary" @click="handleReset()" style="margin-left: 8px">重置</Button>
          </div>
        </Row>
      </Form>
    </Card>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import { getUser } from "@/api/data";
import { putUser } from "@/api/data";
export default {
  name: "registForm",
  components: {},
  data() {
    return {
      formModel: {
        academy: "",
        Class: "",
        major: "",
        num: "",
        phone: "",
        signature: "",
        username: "",
        password: ""
      },

      ruleRegist: {
        academy: [
          {
            required: false,
            trigger: "blur"
          }
        ],
        Class: [
          {
            required: false,
            trigger: "blur"
          }
        ],
        major: [
          {
            required: false,
            trigger: "blur"
          }
        ],
        num: [
          {
            required: true,
            trigger: "blur"
          }
        ],
        signature: [
          {
            required: false,
            trigger: "blur"
          }
        ],
        phone: [
          {
            required: false,
            trigger: "blur"
          }
        ],
        username: [
          {
            required: false,
            trigger: "blur"
          }
        ],
        password: [
          {
            required: true,
            trigger: "blur"
          }
        ]
      }
    };
  },

  methods: {
    getUserInfo() {
      getUser()
        .then(res => {
          res = res.data.data;
          console.log(res);
        })
        .catch(err => {
          console.log(err);
        });
    },
    putUserInfo(
      num,
      password,
      signature,
      major,
      Class,
      academy,
      sex,
      age,
      location
    ) {
      this.academy = academy;
      this.Class = Class;
      this.num = num;
      this.major = major;
      this.age = age;
      this.location = location;
      this.password = password;
      this.signature = signature;
      this.sex = sex;
      putUser(
        this.academy,
        this.Class,
        this.num,
        this.major,
        this.age,
        this.location,
        this.password,
        this.signature,
        this.sex
      )
        .then(res => {
          res = res.data.data;
          console.log(res);
        })
        .catch(err => {
          console.log(err);
        });
    },
    handleSubmit() {}
  },
  mounted() {
    this.getUserInfo();
    // this.putUserInfo();
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