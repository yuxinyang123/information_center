<template>
  <Card :bordered="false"dis-hover>
    <p slot="title">
      <Icon type="ios-cloud-outline"></Icon>
      天气
    </p>
    <Row> 
        <i-col span="12" class='tupian' align='center' ><img :src="img" ></i-col>
        <i-col span="12" class="wendu" align='center'>{{wendu}}°</i-col>
    </Row>
    <br>
    <Row> 
        <i-col span="12"  align='center' ><Icon type="ios-flag"></Icon>
      {{city}}</i-col>
        <i-col span="12"  align='center'>空气污染指数:{{aqi}}</i-col>
    </Row>
    <br>
     <Row> 
        <i-col span="12"  align='center' >{{date}} </i-col>
        <i-col span="12"  align='center'>最{{low }} /最{{high}}</i-col>
    </Row>
    <br>
    <h5>{{ganmao}}</h5>
  </Card>
</template>

<script>

export default {
name: 'ChartPie',
props:{
  city:String,
  forecast:Array,
  ganmao:String,
  wendu:String,
  date:String,
  low:String,
  high:String,
  aqi:String,
  type:String,
},
  data () {
    return {
        img:String
    }
  },
  methods: {
      aggimage:function(type){
          this.img = require("../../assets/images/"+type+".png")
      }
  },
  mounted:function(){
  },
  beforeUpdate:function(){
    this.aggimage(this.type)
  },
  
}

</script>
<style lang="less">
img { width: 55%; height: 50%;}
  .a{
    width: 50%;
    height: 90%;}
    .b{
      background: red;
      width: 50%;
      height: 90%;
      float: right;
    }
    .wendu{
      font-size: 50px;
      margin-top:10px;
    }
    
  @import './style.less';
</style>
