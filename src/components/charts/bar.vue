<template>
  <Card :bordered="false" dis-hover>
    <p slot="title">
      <Icon type="ios-flame"/>热点新闻
    </p>
    <a href="#" slot="extra" @click="changePageNum">刷新</a>
    <Row>
      <i-col span="12">
        <ul>
          <li v-for="(item,index) in hottitle" v-if="index<10">
            <Row>
              <i-col span="2">{{item.id}}</i-col>
              <i-col span="20">
                <a :href="item.hoturl" target="_blank">{{ item.title }}</a>
                {{item.hotnum}}
              </i-col>
            </Row>
          </li>
        </ul>
      </i-col>
      <i-col span="12">
        <ul>
          <li v-for="(item,index) in hottitle" v-if="index>9&&index<20">
            <Row>
              <i-col span="2">{{item.id}}</i-col>
              <i-col span="20">
                <a :href="item.hoturl" target="_blank">{{ item.title }}</a>
                {{item.hotnum}}
              </i-col>
            </Row>
          </li>
        </ul>
      </i-col>
    </Row>
  </Card>
</template>
<script>
export default {
  name: "ChartBar",
  props: {
    hottitle: Array
  },
  data() {
    return {
      pageNum: 1,
      pageSize: 20
    };
  },
  methods: {
    changePageNum: function() {
      this.$emit(
        "change",
        (this.pageNum++ % 3) + 1,
        this.pageSize
      );
    }
  },
  mounted() {}
};
</script>
<style>

li {
  list-style-type: none;
}
</style>