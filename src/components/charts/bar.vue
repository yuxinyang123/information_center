<template>
    <Card :bordered="false"dis-hover>
        <p slot="title">
           <Icon type="ios-flame" />
           热点新闻
        </p>
        <a href="#" slot="extra" @click="changePageNum">
            刷新
        </a>
        <Row>
        <i-col span="12">
            <ul>
                <li v-for="(item,index) in hottitle"
                    v-if="index<7">
                     <Row>
                        <i-col span="2">{{item.id}}</i-col>
                        <i-col span="15"> 
                            <a :href="item.hoturl" target="_blank">{{ item.title }}</a>
                            
                        </i-col>
                        <i-col span="4">{{item.hotnum}}</i-col>
                    </Row>                  
                </li>
            </ul>
        </i-col>
        <i-col span="12">
            <ul>
                <li v-for="(item,index) in hottitle"
                    v-if="index>6&&index<14">
                     <Row>
                        <i-col span="2">{{item.id}}</i-col>
                        <i-col span="15"> 
                            <a :href="item.hoturl" target="_blank">{{ item.title }}</a>
                            
                        </i-col>
                        <i-col span="4">{{item.hotnum}}</i-col>
                    </Row>                  
                </li>
            </ul>
        </i-col>
        </Row>
        
    </Card>
</template>
<script>
    export default {
         name: 'ChartBar',
         props:{  
              hottitle:Array
            },
        methods: {
            changePageNum:function(){
                this.$emit('change');
            }
           
        }
    }
</script>
<style>
    li{list-style-type:none;
     font-size: 22px}
    
</style>