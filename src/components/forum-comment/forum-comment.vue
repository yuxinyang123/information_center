<template>
  <div>
    <Card>
      <Row>
        <Col span="2">
        <Avatar src="https://i.loli.net/2017/08/21/599a521472424.jpg" />&nbsp{{lists.username}}
        </Col>
        <Col span="18">
        {{lists.commentContext}}
        </Col>
        <Col span="4">
        <h5> 发表时间：{{date}}</h5>
        </Col>
      </Row>
    </Card>
  </div>
</template>
<script>
  export default {
    name: "ForumComment",
    props: {
      id: String,
      lists: Object,


    },
    data() {
      return {
        date: String,

      }
    },

    methods: {

      handleTime() {
        var dt = new Date(this.lists.commentDate);
        var date = [
          [dt.getFullYear(), dt.getMonth() + 1, dt.getDate()].join('-'),
          [dt.getHours(), dt.getMinutes(), dt.getSeconds()].join(':')
        ].join(' ').replace(/(?=\b\d\b)/g, '0'); // 正则补零
        this.date = date
        console.log(date);
      }
    },
    mounted() {
      this.handleTime()

    }
  }

</script>
