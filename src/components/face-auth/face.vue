<template>
  <div>
    <Modal
      title="请输入人脸验证的登录邮箱"
      v-model="fullScreen"
      :mask-closable="false"
      :closable="false"
      @on-ok="ok('f')"
      @on-cancel="cancle"
      :loading="loading"
      cancel-text="后退"
    >
      <Form :model="form" :rules="rule" ref="f">
        <FormItem label="Email" prop="userEmail">
          <Input v-model="form.userEmail" placeholder="Enter your e-mail"></Input>
        </FormItem>
      </Form>
    </Modal>
    <div v-show="isOk">
      <video id="video" width="480" height="320"></video>
      <i-button @click="authFace" ghost>匹配</i-button>
      <Button @click="back" ghost>返回</Button>
      <canvas id="canvas" width="480" height="320"></canvas>
    </div>
  </div>
</template>
<script>
import { authFace } from "@/api/login";
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
        userEmail: [
          {
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
        console.log(valid);
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
    back(){
      this.stopVideo()
      this.$router.push("login")
    }
  },
  watch: {
    flag(val) {
      if (val == true) {
        console.log("closed")
        this.stopVideo();
      }
    }
  },
  mounted() {}
};
</script>

