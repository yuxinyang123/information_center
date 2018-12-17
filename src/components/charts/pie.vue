<template>
  <Card :bordered="false"dis-hover >
    <p slot="title">
      <Icon type="ios-cloud-outline"></Icon>
      天气
    </p>
    <Row > 
        <i-col span="12"  align='center' ><img :src="img" ></i-col>
        <i-col span="12" class="wendu" align='center'>{{wendu}}°</i-col>
    </Row>
    <br>
    <Row> 
        <i-col span="12"  align='center' ><Icon type="ios-flag"></Icon>
           <a   @click='modal1=true'>{{city}}</a>

           <!-- <Modal v-model="modal1"  scrollable title="城市选择" >
               <div>
                   <weather-model :data="data"  ></weather-model>
=======
           <Modal v-model="modal1"  scrollable title="城市选择" >
               <div>{{cityname}}
                   <weather-model :data="data"  @sendChildData='getChildData'></weather-model>
>>>>>>> 6cfb6eb34df9dd5c40a556550c8e1d7eb167494d
               </div>
           </Modal> -->
        </i-col>
        <i-col span="12"  align='center'>空气污染指数:{{aqi}}</i-col>
    </Row>
    <br>
    <Row> 
        <i-col span="12"  align='center' >{{date}} </i-col>
        <i-col span="12"  align='center'>最{{low }} /最{{high}}</i-col>
    </Row>
    <br>
    <Row>  <i-col span="24"  align='center'><h5>{{ganmao}}</h5></i-col></Row>
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
        data:[],
        gatdata:'',
        modal1: false,
        img:String,
        cityname:''
        
    }
  },
  methods: {
      getChildData(data){
        this.cityname = data
      },
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

  .wendu{
      font-size: 50px;
      margin-top:10px;}

    
  @import './style.less';
</style>
