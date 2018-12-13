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
          <count-to :end="infor.count" count-class="count-style"/>
          <p>{{ infor.title }}</p>
        </infor-card>
      </i-col>
    </Row>
    <Row :gutter="20" style="margin-top: 10px;">
      <i-col :md="24" :lg="8" style="margin-bottom: 20px;">
        <Card shadow>
          <chart-pie style="height: 300px;" :cityname='cityname'  :type="type" :aqi="aqi" :high="high" :date="date" :low="low" :wendu="wendu" :city="city" :forecast="forecast" :ganmao="ganmao"  text="天气"></chart-pie>
        </Card>
      </i-col>
      <i-col :md="24" :lg="16" style="margin-bottom: 20px;">
<<<<<<< HEAD
        <Card shadow>        
          <chart-bar style="height: 300px;"  :hottitle="hottitle" @change="ChangePageNum" text="热点新闻"/>
=======
        <Card shadow>
          <chart-bar style="height: 300px;" text="热点新闻"/>
>>>>>>> 6cfb6eb34df9dd5c40a556550c8e1d7eb167494d
        </Card>
      </i-col>
    </Row>
    <Row>
        <student-course :course='course' style="height: 300px;"/>  
    </Row>
  </div>
</template>

<script>
import {getWhetherData} from '@/api/data'
import {getNews} from '@/api/data'
import {updateWeatherInfo} from '@/api/data'
import InforCard from '_c/info-card'
import CountTo from '_c/count-to'
import {getStudentCourse} from '@/api/data'
import { ChartPie, ChartBar } from '_c/charts'
import StudentCourse from './StudentCourse.vue'
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
      ganmao:'',
      city:'',
      forecast:[],
      wendu:'',
      date:'',
      low:'',
      high:'',
      aqi: '',
      type:'',
      cityname:'',
<<<<<<< HEAD
      hottitle:[],
      pageNum:1,
      pageSize:10,
      inforCardData: [
        { title: '加权平均分', icon: 'md-person-add', count: 803, color: '#2d8cf0' },
        { title: '平均学分绩点', icon: 'md-locate', count: 232, color: '#19be6b' },
        { title: '第二课堂', icon: 'md-help-circle', count: 142, color: '#ff9900' },
        { title: '选修', icon: 'md-share', count: 657, color: '#ed3f14' }
      ],
     }
   },
  methods:{
    ChangePageNum:function(){
      if(this.pageNum*this.pageSize<=50){
        this.pageNum++;
      }else{
        this.pageNum=0;
      }
=======
      course:{},
      // day1:{},
      // day2:{},
      // day3:{},
      // day4:{},
      // day5:{},
      inforCardData: [
        {
          title: "加权平均分",
          icon: "md-person-add",
          count: 803,
          color: "#2d8cf0"
        },
        {
          title: "平均学分绩点",
          icon: "md-locate",
          count: 232,
          color: "#19be6b"
        },
        {
          title: "第二课堂",
          icon: "md-help-circle",
          count: 142,
          color: "#ff9900"
        },
        { title: "选修", icon: "md-share", count: 657, color: "#ed3f14" }
      ]
    };
  },
>>>>>>> 6cfb6eb34df9dd5c40a556550c8e1d7eb167494d

    }
  },
  mounted(){
    getWhetherData().then(res => {
     
      
      res=res.data.data
      this.city=res.cityname
      this.ganmao=res.notice
      this.wendu=res.wendu
      this.date=res.nowdate
      this.low=res.low
      this.high=res.high
      this.aqi=String(res.AQI)
      this.type=res.type
      }).catch(err => {
        console.log(err)
    })
<<<<<<< HEAD
    getNews(this.pageNum,this.pageSize).then(res => {
     console.log(res.data.data)
     res=res.data.data
     this.hottitle=res.list
    }).catch(err => {
      console.log(err)
    })
  }

}
=======
      // updateWeatherInfo().then(res =>{
      //   res=res.data
      //   this
      // })
    getStudentCourse('1').then(res=>{
     
      res=res.data.data
      
      this.course=res
      // this.day1=res.星期一[0]
      // this.day2=res.星期二[0]
      // this.day3=res.星期三[0]
      // this.day4=res.星期四[0]
      // this.day5=res.星期五[0]
      // console.log(this.day1)
      // console.log(res)
    }).catch(err =>{
      console.log(err)
    })
  }
};
>>>>>>> 6cfb6eb34df9dd5c40a556550c8e1d7eb167494d
</script>

<style lang="less">
.count-style {
  font-size: 50px;
}
</style>
