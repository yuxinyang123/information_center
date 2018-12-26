<template>
  <!-- <error-content code="404" desc="Oh~~您的页面好像飞走了~" :src="src"/> -->
  <game2048></game2048>
</template>

<script>
// import error404 from '@/assets/images/error-page/error-404.svg'
// import errorContent from './error-content.vue'
import game2048 from './2048.vue'
export default {
  name: 'error_404',
  components: {
    game2048
  },
  data () {
    return {
      // src: error404
    }
  }
}
</script>
