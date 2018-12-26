<template>
  <div>
    <i-table :columns="typelist" :data="singleType"></i-table>
  </div>
</template>
<script>
  import {
    getLists
  } from "@/api/data";
  export default {
    props: {
      typeName: String
    },
    watch: {
      typeName:function (val, oldVal) {
            
      this.handlegetLists(this.typeName);
    },
    },
    data() {
      return {
        singleType: [],
        typelist: [{
            title: '评论',
            key: 'resCommentCount'
          },
          {
            title: '标题',
            key: 'resTitle'
          },
          {
            title: '发布者',
            key: 'resAuthor'
          },
          {
            title: '时间',
            key: 'resDate'
          }
        ],

      }
    },
    methods: {
      handlegetLists(typeName) {
        return new Promise((resolve, reject) => {
          getLists(typeName).then(res => {
            res = res.data.data[0];
            this.singleType = res.resourcePos
            resolve();
          }).catch(err => {
            console.log(err);
            reject(err);
          });
        });
      },
    },
    mounted() {
      this.handlegetLists(this.typeName);
    },
 
  }

</script>
