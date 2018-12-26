<template>
  <div>
    <forum-content :id="id"></forum-content>
    <forum-comment :id="id"></forum-comment>
  </div>
</template>
<script>
  import ForumContent from "_c/forum-content";
  import ForumComment from "_c/forum-comment";
  import {
    getComment
  } from "@/api/data";
  export default {
    components: {
      ForumContent,
      ForumComment
    },
    props: {
      id: String,
      type: String
    },
    data() {
      return {
        title: "this is title",
        pageNum: 0,
        pageSize: 0,
        essayId: 0,
        lists: [],
      };
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
    created() {
      // console.log(this.$router.currentRoute.meta.title);
    },
    mounted() {
       this.handleGetComment()
      // console.log(this.id, this.type);
    }
  };

</script>
