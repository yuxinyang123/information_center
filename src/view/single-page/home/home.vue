<template>
  <div>
    <Row :gutter="20">
      <i-col :xs="12" :md="100" :lg="6" v-for="(infor, i) in inforCardData" :key="`infor-${i}`" style="height: 120px;padding-bottom: 10px;">
        <infor-card shadow :color="infor.color" :icon="infor.icon" :icon-size="36">
          <count-to :end="infor.count" count-class="count-style"/>
          <p>{{ infor.title }}</p>
        </infor-card>
      </i-col>
    </Row>
    <Row :gutter="20" style="margin-top: 10px;">
      <i-col :md="24" :lg="8" style="margin-bottom: 20px;">
        <Card shadow>
          <chart-pie style="height: 300px;" :type="type" :aqi="aqi" :high="high" :date="date" :low="low" :wendu="wendu" :city="city" :forecast="forecast" :ganmao="ganmao"  text="天气"></chart-pie>
        </Card>
      </i-col>
      <i-col :md="24" :lg="16" style="margin-bottom: 20px;">
        <Card shadow>        
          <chart-bar style="height: 300px;"  text="热点新闻"/>
        </Card>
      </i-col>
    </Row>
    <Row>
        <example style="height: 310px;"/>  
    </Row>
  </div>
</template>

<script>
import {getWhetherData} from '@/api/data'
import InforCard from '_c/info-card'
import CountTo from '_c/count-to'
import { ChartPie, ChartBar } from '_c/charts'
import Example from './example.vue'
export default {
  name: 'home',
  components: {
    InforCard,
    CountTo,
    ChartPie,
    ChartBar,
    Example
  },
  data () {
    return {
      ganmao:'',
      city:'',
      forecast:[],
      wendu:'',
      date:'',
      low:'',
      high:'',
      aqi:'',
      type:'',
      inforCardData: [
        { title: '加权平均分', icon: 'md-person-add', count: 803, color: '#2d8cf0' },
        { title: '平均学分绩点', icon: 'md-locate', count: 232, color: '#19be6b' },
        { title: '第二课堂', icon: 'md-help-circle', count: 142, color: '#ff9900' },
        { title: '选修', icon: 'md-share', count: 657, color: '#ed3f14' }
      ],
     }
   },

  mounted(){
    getWhetherData().then(res => {
      res=res.data.data
      this.city=res.city
      this.forecast=res.forecast
      this.ganmao=res.ganmao
      this.wendu=res.wendu
      this.date=res.forecast[0].date
      this.low=res.forecast[0].low
      this.high=res.forecast[0].high
      this.aqi=res.aqi
      this.type=res.forecast[0].type
      console.log(res)
      }).catch(err => {
        console.log(err)
    })
  }
}
</script>

<style lang="less">
.count-style{
  font-size: 50px;
}
</style>
