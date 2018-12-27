<template>
  <div>
    <editor ref="editor" :value="commentContext" @on-change="handleChange" />
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
      id: String
    },
    components: {
      Editor
    },
    data() {
      return {
        commentContext: '',
      }
    },
    methods: {
      handleSubmit(commentContext, id) {
        if (this.commentContext == '') {
          this.$Message.error('评论不能为空');
        } else {
          addComment(this.commentContext, this.id)
            .then(res => {
              res = res.data
            
              this.$Message.success('添加成功');
            })
            .catch(err => {
              console.log(err);
            });
        }
      },
      handleChange(html, text) {

        this.commentContext = text
        

      },
    },
    mounted() {

    }
  }

  //

</script>
