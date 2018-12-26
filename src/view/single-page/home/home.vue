<template>
  <div>
    <Row :gutter="20">
      <i-col
        :xs="12"
        :md="100"
        :lg="6"
        v-for="(infor, i) in inforCardData"
        :key="`infor-${i}`"
        style="height: 120px;padding-bottom: 10px;"
      >
        <infor-card shadow :color="infor.color" :icon="infor.icon" :icon-size="36">
          <count-to :end="infor.count" :decimals="2" count-class="count-style"/>
          <p>{{ infor.title }}</p>
        </infor-card>
      </i-col>
    </Row>
    <Row :gutter="20" style="margin-top: 10px;">
      <i-col :md="24" :lg="8" style="margin-bottom: 20px;">
        <Card shadow>
          <chart-pie
            style="height: 300px;"
            :type="type"
            :aqi="aqi"
            :high="high"
            :date="date"
            :low="low"
            :wendu="wendu"
            :city="city"
            :forecast="forecast"
            :ganmao="ganmao"
            @updateLocal="handleUpdateWeather"
            text="天气"
          ></chart-pie>
        </Card>
      </i-col>
      <i-col :md="24" :lg="16" style="margin-bottom: 20px;">
        <Card shadow>
          <chart-bar
            style="height: 300px;"
            :hottitle="hottitle"
            @change="handleGetNews"
            text="热点新闻"
          />
        </Card>
      </i-col>
    </Row>
    <Row>
      <student-course :course="course" style="height: 300px;"/>
    </Row>
  </div>
</template>

<script>
import {
  getWhetherData,
  updateWeatherInfo,
  getStudentCourse,
  get4Tag,
  getNews
} from "@/api/data";
import InforCard from "_c/info-card";
import CountTo from "_c/count-to";
import { ChartPie, ChartBar } from "_c/charts";
import StudentCourse from "./StudentCourse.vue";

export default {
  name: "home",
  components: {
    InforCard,
    CountTo,
    ChartPie,
    ChartBar,
    StudentCourse
  },
  data() {
    return {
      ganmao: "",
      city: "",
      forecast: [],
      wendu: "",
      date: "",
      low: "",
      high: "",
      aqi: "",
      type: "",
      cityname: "",
      course: {},

      hottitle: [],
      pageNum: 1,
      pageSize: 20,
      inforCardData: [
        {
          title: "加权平均分",
          icon:"logo-snapchat",
          count: 0,
          color: "#2d8cf0"
        },
        {
          title: "已获得学分",
          icon: "ios-planet",
          count: 0,
          color: "#19be6b"
        },
        {
          title: "绩点",
          icon: "logo-freebsd-devil",
          count: 0,
          color: "#515a6e"
        },
        {
          title: "选修学分",
          icon: "ios-paw",
          count: 0,
          color: "#ed3f14"
        }
      ]
    };
  },
  methods: {
    ChangePageNum: function() {
      if (this.pageNum * this.pageSize <= 50) {
        this.pageNum++;
      } else {
        this.pageNum = 0;
      }
    },

    handleGetWeather() {
      let date = new Date();
      getWhetherData()
        .then(res => {
          console.log(res);
          res = res.data.data;
          this.city = res.city;
          this.ganmao = res.notice;
          this.wendu = res.wendu;
          this.date =
            date.getFullYear() +
            "-" +
            (date.getMonth() + 1) +
            "-" +
            date.getDate();
          this.low = res.low;
          this.high = res.high;
          this.aqi = String(res.aqi);
          this.type = res.type;
        })
        .catch(err => {
          console.log(err);
        });
    },
    handleGetCourse() {
      getStudentCourse(this.$store.state.user.userId)
        .then(res => {
          res = res.data.data;
          this.course = res;
        })
        .catch(err => {
          console.log(err);
        });
    },
    handleGet4Tag() {
      get4Tag()
        .then(res => {
          res = res.data;
          let a = res.data.avggrade;
          // console.log(a);
          if (res.code == 200) {
            this.inforCardData[0].count = res.data.avggrade;
            this.inforCardData[1].count = res.data.havacredit;
            this.inforCardData[2].count = res.data.performancepoint;
            this.inforCardData[3].count = res.data.choosecredit;
          }
        })
        .catch(err => {
          console.log(err);
        });
    },
    handleUpdateWeather(cityname) {
      console.log("handleUpdateWeather:" + cityname);
      updateWeatherInfo(cityname)
        .then(res => {
          res = res.data;
          console.log(res);
          if (res.code == 200) {
            this.$Message.success("修改成功！");
            this.handleGetWeather();
          } else {
            this.$Message.error("修改失败！");
          }
        })
        .catch(err => {
          console.log(err);
        });
      
    },
    handleGetNews(pageNum,pageSize) {
      getNews(pageNum, pageSize)
        .then(res => {
         
          res = res.data.data;
          this.hottitle = res;
        })
        .catch(err => {
          console.log(err);
        });
    }
  },
  mounted() {
    this.handleGetWeather();
    this.handleGetCourse();
    this.handleGet4Tag();
    this.handleGetNews(this.pageNum,this.pageSize);
  }
};
</script>

<style lang="less">
.count-style {
  font-size: 50px;
}
</style>
