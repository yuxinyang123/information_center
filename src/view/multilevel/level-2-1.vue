<template>
  <i-table :columns="columns1" :data="data1"></i-table>
</template>
<script>
export default {
  name: 'level_2_1',
  data () {
            return {
                columns1: [
                    {
                        title: '编号',
                        key: 'num'
                    },
                    {
                        title: '标题',
                        key: 'tittle'
                    },
                    {
                    	title:'发布者',
                    	key:'author'
                    },
                    {
                        title: '时间',
                        key: 'data'
                    }
                ],
                data1: [
                    {
                        num: '1',
                        tittle: '行走在川西',
                        author:'摄太郎',
                        data: '2018.11.27'
                    },
                    {
                        num: '1',
                        tittle: '行走在川西',
                        author:'摄太郎',
                        data: '2018.11.27'
                    },{
                        num: '1',
                        tittle: '行走在川西',
                        author:'摄太郎',
                        data: '2018.11.27'
                    },{
                        num: '1',
                        tittle: '行走在川西',
                        author:'摄太郎',
                        data: '2018.11.27'
                    },{
                        num: '1',
                        tittle: '行走在川西',
                        author:'摄太郎',
                        data: '2018.11.27'
                    },{
                        num: '1',
                        tittle: '行走在川西',
                        author:'摄太郎',
                        data: '2018.11.27'
                    },{
                        num: '1',
                        tittle: '行走在川西',
                        author:'摄太郎',
                        data: '2018.11.27'
                    },
                ]
            }
        }
    }

</script>
