<template>
  <Card :bordered="false"dis-hover>
    <p slot="title">
      <Icon type="ios-cloud-outline"></Icon>
      天气
    </p>
    <Row> 
        <i-col span="12" class='tupian' >col-12</i-col>
        <i-col span="12" class="wendu" align='center'>{{wendu}}°</i-col>
    </Row>
    <div class="a" align="center"  id='a'>
      <br>
      <br>
      <Icon type="ios-flag"></Icon>
      {{city}}<br>
      <br>
      {{date}}
      <br>
      <br>
      
    </div>
    <!-- <div class='b'>
      {{forecast[0].type}}
    </div> -->
   
    <h5>{{ganmao}}</h5>
    <!-- <ul>
        <li v-for="item of forecast"
        :key="item.date">
        {{item.date}}
           
        </li>
    </ul> -->
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

},
  data () {
    return {

    }
  },
  methods: {
    //   aggimage:function(){
    //   var d=forecast[0].type;
    //   path1="../../assets/images/01.png";//请修改为本地图片的路径
    //   switch(d)
    //     {
    //       case "'晴'":document.getElementById('a').innerHTML='<img src="'+path1+'" />' ;
    //       break;
    //     }
    // }
  },
  mounted:function(){
    
      // this.aggimage()
      // this.changeLimit();
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
      // height: px;
      font-size: 50px
    }
    
  @import './style.less';
</style>
