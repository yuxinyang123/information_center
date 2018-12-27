<template>
  <div>
    <Modal title="请输入人脸验证的登录邮箱" v-model="fullScreen" :mask-closable="false" :closable="false" @on-ok="ok('f')"
      @on-cancel="cancle" :loading="loading" cancel-text="后退">
      <Form :model="form" :rules="rule" ref="f">
        <FormItem label="Email" prop="userEmail">
          <Input v-model="form.userEmail" placeholder="Enter your e-mail"></Input>
        </FormItem>
      </Form>
    </Modal>
    <Row>
      <Col span="24" style=" margin-top:10%">&nbsp
      </Col>
    </Row>
    <Row :gutter="10" v-show="isOk">

      <i-col span="2">&nbsp</i-col>
      <i-col span="9">
        <Card shadow style=" background-color: rgba(245, 245, 245, 0.5)">
          <h1>
            <font color="white">拍摄人脸</font>
          </h1><br>
          <Row type="flex" justify="center">
            <Col style="height:350px">
            <video id="video" width="100%" height="100%"></video>
            </Col>
          </Row>
          <Row type="flex">
            <i-col span="9">
              &nbsp
            </i-col>
            <i-col span="12">
              <i-button type="info" @click="authFace">匹配</i-button>&nbsp
              <Button type="primary" @click="back">返回</Button>
            </i-col>
          </Row>
        </Card>
      </i-col>
      <i-col span="3">&nbsp </i-col>

      <i-col span="9">
        <Card shadow style=" background-color: rgba(245, 245, 245, 0.5)">
          <h1>
            <font color="white">识别</font>
          </h1><br>
          <Row type="flex" justify="center">
            <Col style="height:380px">
            <canvas id="canvas" width="480" height="350"></canvas>
            </Col>
          </Row>
        </Card>
      </i-col>
    </Row>
  </div>
</template>
<script>
  import {
    authFace
  } from "@/api/login";
  export default {
    name: "FaceAuth",
    props: {
      flag: false
    },
    data() {
      return {
        fullScreen: true,
        isOk: false,
        loading: true,
        text: "",
        form: {
          pic: "",
          userEmail: ""
        },
        rule: {
          userEmail: [{
              required: true,
              trigger: "blur",
              message: "登录邮箱不为空"
            },
            {
              trigger: "blur",
              message: "请输入正确的邮箱格式",
              type: "email"
            }
          ]
        }
      };
    },
    methods: {
      openVideo() {
        let video = $("#video")[0];
        navigator.mediaDevices
          .getUserMedia({
            audio: false,
            video: {
              width: 480,
              height: 320
            }
          })
          .then(
            stream => {
              video.srcObject = stream;
              video.play();
            },
            e => {
              console.error(e);
            }
          );
      },
      authFace() {
        let context = $("#canvas")[0].getContext("2d");
        context.drawImage(video, 0, 0, 480, 320);
        this.form.pic = $("#canvas")[0].toDataURL();
        this.$emit("handleAuth", this.form);
      },
      stopVideo() {
        video.srcObject.getTracks()[0].stop();
      },
      ok() {
        this.$refs.f.validate(valid => {
         
          if (valid) {
            this.$Message.success("开始人脸识别");
            this.openVideo();
            this.isOk = true;
            this.loading = false;
            this.fullScreen = false;
          } else {
            this.$Message.error("请输入正确的邮箱");
            this.$refs.f.resetFields();
            this.loading = false;
          }
        });
        setInterval(() => {
          this.loading = true;
        }, 1000);
      },
      cancle() {
        this.$router.push('login')
      },
      back() {
        this.stopVideo()
        this.$router.push("login")
      }
    },
    watch: {
      flag(val) {
        if (val == true) {
       
          this.stopVideo();
        }
      }
    },
    mounted() {}
  };

</script>
<style>

</style>
