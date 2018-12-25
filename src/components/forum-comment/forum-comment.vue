<template>
  <div>
    
  </div>
</template>
<script>
  import {
    getComment
  } from "@/api/data";
  export default {
    props: {

    },
    data() {
      return {
        pageNum: 0,
        pageSize: 0,
        essayId: 0,
        lists: [],
       
      }
    },
    methods: {
      handleGetComment() {
        getComment(this.pageNum, this.pageSize, this.essayId)
          .then(res => {
            res = res.data.data;
            this.lists = res.list
            console.log(res)

          })
          .catch(err => {
            console.log(err);
            reject(err);
          });
      }
    },
    mounted() {
      this.handleGetComment()
    }
  }

</script>
