<template>
<div> 
    {{course}}
    <!-- <i-table :columns="columns1" :data="data1" v-for="item in classname" :key='item'>{{item.classname}}</i-table> -->
     <!-- <Row type="flex" justify="center" align="middle" style="color:#19be6b" id="a">
        <Col span="4"  align="center" >节次</Col>
        <Col span="4">星期一</Col>
        <Col span="4">星期二</Col>  
        <Col span="4">星期三</Col>l
        <Col span="4">星期四</Col>
        <Col span="4">星期五</Col>
    </Row>
    <Row type="flex"  align="middle" class="course" v-for="m in n" :key="m" >
        <Col span="4"  align="center">{{m}}</Col>
        <Col span="4">{{classname.星期一[0].classname}}</Col>
        <Col span="4">212313</Col>  
        <Col span="4">123321</Col>
        <Col span="4">212313</Col>
        <Col span="4">123321</Col> -->
    <!-- </Row> -->
    <table class="course">
        <tr>
            <th class="tablehead">节次</th><th>周一</th><th>周二</th><th>周三</th><th>周四</th><th>周五</th>
        </tr>
        <tr>
            <td>1</td><td></td><td></td><td></td><td></td><td></td>
        </tr>
         <tr>
            <td>2</td><td></td><td></td><td></td><td></td><td></td>
        </tr>
         <tr>
            <td>3</td><td></td><td></td><td></td><td></td><td></td>
        </tr>
         <tr>
            <td>4</td><td></td><td></td><td></td><td></td><td></td>
        </tr>
         <tr>
            <td>5</td><td></td><td></td><td></td><td></td><td></td>
        </tr>
         <tr>
            <td>6</td><td></td><td></td><td></td><td></td><td></td>
        </tr>
         <tr>
            <td>7</td><td></td><td></td><td></td><td></td><td></td>
        </tr> 
        <tr>
            <td>8</td><td></td><td></td><td></td><td></td><td></td>
        </tr> 
        <tr>
            <td>9</td><td></td><td></td><td></td><td></td><td></td>
        </tr>
         <tr>
            <td>10</td><td></td><td></td><td></td><td></td><td></td>
        </tr>
         <tr>
            <td>11</td><td></td><td></td><td></td><td></td><td></td>
        </tr>
         <tr>
            <td>12</td><td></td><td></td><td></td><td></td><td></td>
        </tr>
         <tr>
            <td>13</td><td></td><td></td><td></td><td></td><td></td>
        </tr>
    </table>
</div>
</template>
<script>
export default {
name: 'StudentCourse',
props:{
    course:Object,
    day1:Object,
    day2:Object,
    day3:Object,
    day4:Object,
    day5:Object,
},
data () {
    return {
        i:1,
        n:13,
        j:0,
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
beforeUpdate(){
   
     this.addid(); 
     this.part();      
    
},
methods:{
   part(){
       var td1=document.getElementsByTagName('td')
       for (var i=0;i<td1.length;i++) {
            var a=td1[i].id
            var c=document.getElementById('a');
            var b = a.split(",")
            console.log(c)
            // console.log(this.day1.startpart)
         if(this.day1.stratpart==b[0]){
            
         
         }
       }
        
       
        
    },
    addid(){
        var tdl=document.getElementsByTagName('td');
        var trl=document.getElementsByTagName('tr')
        
         for(this.i;this.i<=trl.length;this.i++){
                 
                 for(this.j;this.j<tdl.length;this.j++){
                    
                    tdl[this.j].setAttribute('id',[Math.floor((this.j)/6)+1,(this.j%6+1)]);                   
                 }
        }   
     }
   
    },

}

 
 
</script>
<style>


    .ivu-table td.demo-table-info-mon{
        background-color: #ff9900;
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
        font-size: 18px;
        height:52px ;
        color:#2db7f5;
        text-align: center;
        width: 100%;
    }
    .tablehead{
        width: 10%;
    }
    .course tr{
        height: 43px;
    }
</style>


