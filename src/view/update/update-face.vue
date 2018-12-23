<template>
  <Row :gutter="10">
    <i-col span="12">
      <Card shadow>
        <h1>拍摄人脸</h1>
        <Row type="flex" justify="center">
          <Col>
            <video ref="video" id="video" width="480" height="320"></video>
          </Col>
        </Row>
        <Row type="flex" justify="center">
          <Col>
            <Button type="primary" @click="drawImage()">拍摄</Button>
          </Col>
        </Row>
      </Card>
    </i-col>
    <i-col span="12">
      <Card shadow>
        <h1>上传人脸</h1>
        <Row type="flex" justify="center">
          <Col>
            <canvas id="canvas" width="480" height="320"></canvas>
          </Col>
        </Row>
        <Row type="flex" justify="center">
          <Col>
            <Button @click="send()">添加</Button>
          </Col>
        </Row>
      </Card>
    </i-col>
  </Row>
</template>

<script>
import { addUserFace } from "@/api/user";
export default {
  name: "update_paste_page",
  components: {},
  data() {
    return {
      pic: String
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
    drawImage() {
      let context = $("#canvas")[0].getContext("2d");
      context.drawImage(video, 0, 0, 480, 320);
      this.pic = $("#canvas")[0].toDataURL();
    },
    stopVideo() {
      let video = this.$refs.video;
      video.srcObject.getTracks()[0].stop();
    },
    send() {
      addUserFace(this.pic).then(res => {
        res = res.data.data;
        if (res.result.face_token != null) {
          this.$Message.success("注册成功");
        } else {
          this.$Message.error(res.error_msg);
        }
      });
    }
  },
  mounted() {
    this.openVideo();
  },
  beforeDestroy() {
    this.stopVideo();
  }
};
</script>
