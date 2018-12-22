<template>
  <Row :gutter="10">
    <i-col span="12">
      <Card shadow>
        <video ref="video" id="video" width="480" height="320"></video>
      </Card>
    </i-col>
    <i-col span="12">
      <Card shadow>
        <canvas id="canvas" width="480" height="320"></canvas>
      </Card>
    </i-col>
  </Row>
</template>

<script>
export default {
  name: "update_paste_page",
  components: {},
  data() {
    return {};
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
      let video = this.$refs.video;
      console.log(video);
      video.srcObject.getTracks()[0].stop();
    },
    ok() {},
    cancle() {}
  },
  mounted() {
    this.openVideo();
    console.log($("#video")[0]);
  },
  beforeDestroy() {
    console.log("before destoryed");
    console.log("jq" + $("#video")[0]);
    console.log("ref:" + this.$refs.video);
    this.stopVideo();
  },
  destroyed() {
    console.log("destoryed");
    console.log("jq" + $("#video")[0]);
    console.log("ref:" + this.$refs.video);
  }
};
</script>
