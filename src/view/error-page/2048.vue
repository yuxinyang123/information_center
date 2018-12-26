<template>
  <div class="game">
    <Row justify="center" type="flex" v-for="i in 4" :key="i">
      <Col v-for="j in 4" :key="i+':'+j">
        <div class="gamediv" :ref="'c'+i*j">{{num[j-1+(i-1)*4]}}</div>
      </Col>
    </Row>
  </div>
</template>
<style lang="less">
.game {
  font-size: 2em;
  margin-top: 50px;
  .gamediv {
    width: 5em;
    height: 5em;
    border: 1px solid darkorange;
    margin-left: -1px;
    margin-top: -1px;
  }
}
</style>

<script>
export default {
  name: "game2048",
  data() {
    return {
      num: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    };
  },
  methods: {
    debug() {
      console.log(this.$refs.c1);
    },
    init() {
        
    }
  },
  mounted() {
    this.debug();
  }
};
</script>

