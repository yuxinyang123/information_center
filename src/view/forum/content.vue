<template>
  <div>
    <forum-content :id="id"></forum-content>
    <forum-comment :id="id" v-for="i in lists" :lists="i"></forum-comment>
    <forum-add :id="id"></forum-add>


    </Row>
  </div>
</template>
<script>
  import ForumContent from "_c/forum-content";
  import ForumComment from "_c/forum-comment";
  import ForumAdd from "_c/forum-comment/forum-add";
  import {
    getComment
  } from "@/api/data";
  export default {
    components: {
      ForumContent,
      ForumComment,
      ForumAdd
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
      handleGetComment(id) {
        getComment(this.pageNum, this.pageSize, id)
          .then(res => {
            res = res.data.data;
            this.lists = res.list
            console.log(res)
          })
          .catch(err => {
            console.log(err);
          });
      }
    },
    created() {
      // console.log(this.$router.currentRoute.meta.title);
    },
    mounted() {
      this.handleGetComment(this.id)
      // console.log(this.id, this.type);
    }
  };

</script>
