<template>
<div> 
    {{classname}}
    <!-- <i-table :columns="columns1" :data="data1" v-for="item in classname">{{item.classname}}</i-table> -->
     <Row type="flex" justify="center" align="middle" style="color:#19be6b" id="a">
        <Col span="4"  align="center" >节次</Col>
        <Col span="4">星期一</Col>
        <Col span="4">星期二</Col>  
        <Col span="4">星期三</Col>
        <Col span="4">星期四</Col>
        <Col span="4">星期五</Col>
        
    </Row>
    <Row type="flex"  align="middle" class="course" v-for="m in n" :key="m" >
        <Col span="4"  align="center">{{m}}</Col>
        <Col span="4"><p></p></Col>
        <Col span="4">212313</Col>  
        <Col span="4">123321</Col>
        <Col span="4">212313</Col>
        <Col span="4">123321</Col>
        
    </Row>
</div>
</template>
<script>
export default {
name: 'StudentCourse',
props:{
    classname:Object,
    n:Number
},
data () {
    return {
        
         columns1: [
             
            {
                title: '节次',
                key: 'time',
                className: 'demo-table-info'
            },
            {
                title: "周一",
                key: 'Mon',
                className: 'demo-table-info-mon'
            },
            {
                title: '周二',
                key: 'Tue',
                className: 'demo-table-info-tue'
            },
            {
                title: '周三',
                key: 'Wen',
                className: 'demo-table-info-wen'
            },
            {
                title: '周四',
                key: 'Thu',
                className: 'demo-table-info-thu'

            },
            {
                title: '周五',
                key: 'Fri',
                className: 'demo-table-info-fri'

            }
        ],
         data:[{
             time:'1',
             Mon:'2'
         }]

    }
},
methods:{
   part(){
       console.log(this.classname.星期一[0].startpart)
        for(m=0;this.classname.星期一[0].startpart==this.m||m==14;m++){
            
        }

   }
},
mounted(){
   this.part();
       
        
    
}
}

 
 
</script>
<style>

    .ivu-table td.demo-table-info{
        background-color: #5cadff;
        color: #fff;
    }
    .ivu-table td.demo-table-info-mon{
        background-color: #ff9900;
        color: #fff;
    }
    .ivu-table td.demo-table-info-tue{
        background-color: #ff6600;
        color: #fff;
    }
    
    .ivu-table td.demo-table-info-wen {
        background-color: #19be6b;
        color: #fff;
    }
    .ivu-table td.demo-table-info-thu {
        background-color: #ed4014;
        color: #fff;
    }
    .ivu-table td.demo-table-info-fri {
        background-color: #2db7f5;
        color: #fff;
    }
    .course{
        font-family:50px;
        height:52px ;
        color:#ff9900
    }
</style>


