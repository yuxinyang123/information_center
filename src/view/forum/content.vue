<template>
  <div>
    <forum-content :id="id"></forum-content>
    <forum-comment :id="id" v-for="i in lists" :lists="i"></forum-comment>
    <Card style="height:80px">
      <Row type='flex' align='middle' justify='center' style="height:55px">
        <Col span='10'>
        <Page :total="total" :page-size="pageSize" :current="pageNum" show-total @on-change="handleNextPage"  />
        </Col>
      </Row>
    </Card>
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
        pageNum: 1,
        pageSize: 5,
        essayId: 0,
        lists: [],
        total: 0,
      };
    },
    methods: {
      handleGetComment(id) {
        getComment(this.pageNum, this.pageSize, id)
          .then(res => {
            res = res.data.data;
            this.lists = res.list
            this.total = res.total
          })
          .catch(err => { 
            console.log(err);
          });
      },
      handleNextPage(num) {
        this.pageNum = num;
        getComment(num, this.pageSize, this.id)
          .then(res => {
            res = res.data.data;
            this.lists = res.list
          })
          .catch(err => {
            console.log(err);
          });
      }
    },
    
    mounted() {
      this.handleGetComment(this.id)
     
    }
  };

</script>
