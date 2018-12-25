<template>
  <!-- <forum-content></forum-content>
  <forum-comment></forum-comment> -->
</template>
<script>
import ForumContent from "_c/forum-content";
import ForumComment from "_c/forum-comment";
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

