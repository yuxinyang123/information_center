<template>
  <div>123</div>
</template>
<script>
export default {
  props: {
    id: String,
    type: String
  },
  data() {
    return {
      title: "this is title"
    };
  },
  methods: {},
  created() {
    console.log(this.$router.currentRoute.meta.title);
  },
  mounted() {
    console.log(this.id, this.type);
  }
};
</script>

