<template>
  <div class="game">
    <Row type="flex" justify="center">
      <Col span="">score:{{score}}</Col>
    </Row>
    <Row justify="center" type="flex" v-for="i in 4" :key="i">
      <Col v-for="j in 4" :key="i+':'+j">
        <div class="gamediv">{{num[j-1+(i-1)*4]}}</div>
      </Col>
    </Row>
  </div>
</template>
<style lang="less">
.game {
  font-size: 2em;
  margin-top: 50px;
  .gamediv {
    background-color: aliceblue;
    width: 5em;
    height: 5em;
    border: 2px solid darkorange;
    margin-left: -2px;
    margin-top: -2px;
    vertical-align:middle;
    text-align:center;
    line-height: 5em;
  }
}
</style>

<script>
 import animate from "animate.css";
export default {
  name: "game2048",
  data() {
    return {
      num: Array(16).fill(""),
      flag: false,
      score: 0
    };
  },
  methods: {
    init() {
      this.num = Array(16).fill("");
      this.flag = false;
      this.score = 0;
      this.addCell(2);
    },
    addCell(num) {
      // 获取所有的空白cell放入数组中
      let blankArr = new Array();
      let [...tmpNum] = this.num;
      this.num.forEach((value, index) => {
        if (value === "") {
          blankArr.push(index);
        }
      });
      // 无空白则游戏结束
      if (blankArr.length == 0) {
        this.flag = true;
        return;
      }
      // 随机打乱顺序
      for (let i in blankArr) {
        let index = Math.floor(Math.random() * (blankArr.length - 2));
        [blankArr[index], blankArr[i]] = [blankArr[i], blankArr[index]];
      }
      // 添加格子
      for (; num != 0; num--) {
        if (blankArr.length != 1) {
          let shift = blankArr.shift();
          tmpNum[shift] = Math.random() > 0.9 ? 4 : 2;
        } else {
          tmpNum[blankArr[-1]] = Math.random() > 0.9 ? 4 : 2;
          break;
        }
      }
      // 赋值给实际数组
      this.num = [].concat(tmpNum);
    },
    setCell(num, i, j, val) {
      num[j - 1 + (i - 1) * 4] = val;
    },
    getCell(num, i, j) {
      return num[j - 1 + (i - 1) * 4];
    },
    solveAllCell() {
      let [...tmpNum] = this.num;
      for (let i = 1; i <= 4; i++) {
        for (let j = 1; j <= 4; j++) {
          if (this.getCell(tmpNum, i, j) !== "") {
            for (let jj = j; jj - 1 >= 1; jj--) {
              if (
                this.getCell(tmpNum, i, jj - 1) === this.getCell(tmpNum, i, jj)
              ) {
                this.setCell(
                  tmpNum,
                  i,
                  jj - 1,
                  this.getCell(tmpNum, i, jj) * 2
                );
                this.score += this.getCell(tmpNum, i, jj - 1);
                this.setCell(tmpNum, i, jj, "");
                break;
              } else if (this.getCell(tmpNum, i, jj - 1) === "") {
                this.setCell(tmpNum, i, jj - 1, this.getCell(tmpNum, i, jj));
                this.setCell(tmpNum, i, jj, "");
              }
            }
          }
        }
      }
      // console.log("tmpNum:")
      // console.log(tmpNum);
      this.num = [].concat(tmpNum);
    },
    handleEvent(e) {
      const map = { 37: 0, 38: 1, 39: 2, 40: 3 };
      if (this.flag == true) return;
      if (e.keyCode in map) {
        this.num = this.leftTransposed(map[e.keyCode]);
        this.solveAllCell();
        this.addCell(1);
        this.num = this.leftTransposed(4 - map[e.keyCode]);
      }
    },
    leftTransposed(counts) {
      let tmpArr = new Array(16).fill("");
      let [...tmp] = this.num;
      counts %= 4;
      while (counts--) {
        for (let i = 1; i <= 4; i++) {
          for (let j = 1; j <= 4; j++) {
            this.setCell(tmpArr, 4 - j + 1, i, this.getCell(tmp, i, j));
          }
        }
        [...tmp] = tmpArr;
        tmpArr = [];
      }
      return tmp;
    }
  },
  mounted() {
    document.addEventListener("keyup", this.handleEvent);
    this.init();
  }
};
</script>

