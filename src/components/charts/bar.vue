<template>
 <!--  <div ref="dom" class="charts chart-bar"></div> -->
 <Card :bordered="false"dis-hover>
        <p slot="title">
            <Icon type="ios-flame" />
            热点新闻
        </p>
        <ul>
            <li v-for="item in randomMovieList">
                <a :href="item.url" target="_blank">{{ item.name }}</a>
                <span>
                    <Icon type="ios-star" v-for="n in 4" :key="n"></Icon><Icon type="ios-star" v-if="item.rate >= 9.5"></Icon><Icon type="ios-star-half" v-else></Icon>
                    {{ item.rate }}
                </span>
            </li>
        </ul>
    </Card>
</template>

<script>
// import echarts from 'echarts'
// import tdTheme from './theme.json'
// import { on, off } from '@/libs/tools'
// echarts.registerTheme('tdTheme', tdTheme)
export default {
  name: 'ChartBar',
  data () {
            return {
                movieList: [
                    {
                        name: 'The Shawshank Redemption',
                        url: 'https://movie.douban.com/subject/1292052/',
                        rate: 9.6
                    },
                    {
                        name: 'Leon:The Professional',
                        url: 'https://movie.douban.com/subject/1295644/',
                        rate: 9.4
                    },
                    {
                        name: 'Farewell to My Concubine',
                        url: 'https://movie.douban.com/subject/1291546/',
                        rate: 9.5
                    },
                    {
                        name: 'Forrest Gump',
                        url: 'https://movie.douban.com/subject/1292720/',
                        rate: 9.4
                    },
                    {
                        name: 'Life Is Beautiful',
                        url: 'https://movie.douban.com/subject/1292063/',
                        rate: 9.5
                    },
                    {
                        name: 'Spirited Away',
                        url: 'https://movie.douban.com/subject/1291561/',
                        rate: 9.2
                    },
                    {
                        name: 'Schindlers List',
                        url: 'https://movie.douban.com/subject/1295124/',
                        rate: 9.4
                    },
                    {
                        name: 'The Legend of 1900',
                        url: 'https://movie.douban.com/subject/1292001/',
                        rate: 9.2
                    },
                    {
                        name: 'WALL·E',
                        url: 'https://movie.douban.com/subject/2131459/',
                        rate: 9.3
                    },
                    {
                        name: 'Inception',
                        url: 'https://movie.douban.com/subject/3541415/',
                        rate: 9.2
                    }
                ],
                randomMovieList: []
            }
        },
        methods: {
            changeLimit () {
                function getArrayItems(arr, num) {
                    const temp_array = [];
                    for (let index in arr) {
                        temp_array.push(arr[index]);
                    }
                    const return_array = [];
                    for (let i = 0; i<num; i++) {
                        if (temp_array.length>0) {
                            const arrIndex = Math.floor(Math.random()*temp_array.length);
                            return_array[i] = temp_array[arrIndex];
                            temp_array.splice(arrIndex, 1);
                        } else {
                            break;
                        }
                    }
                    return return_array;
                }
                this.randomMovieList = getArrayItems(this.movieList, 5);
            }
        },
        mounted () {
            this.changeLimit();
        }
    }
//   props: {
//     value: Object,
//     text: String,
//     subtext: String
//   },
//   data () {
//     return {
//       dom: null
//     }
//   },
//   methods: {
//     resize () {
//       this.dom.resize()
//     }
//   },
//   mounted () {
//     this.$nextTick(() => {
//       let xAxisData = Object.keys(this.value)
//       let seriesData = Object.values(this.value)
//       let option = {
//         title: {
//           text: this.text,
//           subtext: this.subtext,
//           x: 'center'
//         },
//         xAxis: {
//           type: 'category',
//           data: xAxisData
//         },
//         yAxis: {
//           type: 'value'
//         },
//         series: [{
//           data: seriesData,
//           type: 'bar'
//         }]
//       }
//       this.dom = echarts.init(this.$refs.dom, 'tdTheme')
//       this.dom.setOption(option)
//       on(window, 'resize', this.resize)
//     })
//   },
//   beforeDestroy () {
//     off(window, 'resize', this.resize)
//   }
 

</script>
