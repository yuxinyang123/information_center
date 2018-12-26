<template>
  <div>
    <Card style="height:80px">
      <Row type='flex' align='middle' justify='center' style="height:55px">
        <Col span='10'>
            <Page :total="100" show-elevator />
        </Col>
      </Row>
    </Card>
    <editor ref="editor" :value="content" @on-change="handleChange" />
    <Card>
      <Row type='flex' align='middle' justify='start'>
        <Col span='3'>
        <Button type="primary" @click="handleSubmit()">添加评论</Button>
        </Col>
      </Row>
    </Card>
  </div>
</template>
<script>
  import Editor from '_c/editor'
  import {
    addComment
  } from "@/api/data";
  export default {
    name: 'ForumAdd',
    props: {
        id:String
    },
    components: {
      Editor
    },
    data() {
      return {
        content: ''
      }
    },
    methods: {
      handleSubmit(comment, context, id) {
        addComment(comment, context, id)
          .then(res => {
            res = res.data
            console.log(res)
          })
          .catch(err => {
            console.log(err);
          });
      },
      handleChange(html, text) {
        console.log(html, text)
      },
    },
    mounted() {

    }
  }

  //

</script>
