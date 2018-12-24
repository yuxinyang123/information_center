<template>
  <div class="message">
    <Card :bordered="false" dis-hover>
      <h1>编辑资料</h1><br>
      <Form :rules="ruleRegist" :model="formModel" ref="redactForm" :label-width="90" >
        <FormItem label="学院：" prop="academy">
          <Input v-model="formModel.academy" placeholder="Enter your academy"></Input>
        </FormItem>
        <FormItem label="班级：" prop="Class">
          <Input type="text" v-model="formModel.Class" placeholder="Enter your class"></Input>
        </FormItem>
        <FormItem label="主修：" prop="major">
          <Input type="text" v-model="formModel.major" placeholder="Enter your major"></Input>
        </FormItem>      
        <FormItem label="用户名：" prop="username">
          <Input v-model="formModel.username" placeholder="Enter your username"></Input>
        </FormItem>
        <FormItem label="年龄：" prop="age">
          <Input v-model="formModel.age" placeholder="Enter your age"></Input>
        </FormItem>
          <FormItem label="个人签名：" prop="signature">
          <Input type="text" v-model="formModel.signature" placeholder="Enter your signature"></Input>
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
            <Button type="primary" @click="handleReset('redactForm')" style="margin-left: 8px">重置</Button>
          </div>
        </Row>
      </Form>
    </Card>
  </div>
</template>
<script>
import { mapActions } from "vuex";
import { putUser } from "@/api/data";
export default {
  name: "redactForm",
  components: {},
  data() {
    return {
      formModel: {
        academy: "",
        Class: "",
        major: "",
        num: "",
        age: "",
        signature: "",
        username: "",
        password: "",
        sex:""

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
        age: [
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
        })
        .catch(err => {
          console.log(err);
        });
    },
    handleSubmit() {
      this.$refs.redactForm.validate(valid => {
        if (valid) {
          putUser(           
            this.formModel.num, 
            this.formModel.password,
            this.formModel.signature,
            this.formModel.major,
            this.formModel.Class,
            this.formModel.academy,
            this.formModel.sex,
            this.formModel.age,            
            this.formModel.username,
                 
          )
            .then(res => {
              console.log(res);
              if (res.data.code == 200) {
                this.$Message.success(
                  "修改成功"
                );              
              } else if (res.data.code == 500) {
                this.$Message.error("修改失败");
              }
            })
            .catch(err => {
              console.log(err);
            });
        }       
      });
    },handleReset(name) {
      this.$refs[name].resetFields();
    }
  },
  mounted() {
  }
};
</script>
<style>
.message {
  background-color: rgb(255, 255, 255);
  margin: auto;
  width: 500px;
  padding: 10px;
  border-radius: 10px;
}
.message h1 {
  text-align: center;
}
.message form FormItem {
  width: 450px;
}
</style>