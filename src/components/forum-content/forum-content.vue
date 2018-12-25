<template>
  <div>
    <Card style="width:100%">
      <Row>
        <Col span="24">
        <h2>{{resContext}}</h2>
        </Col>
      </Row>
      <Row>
        <Col span="24">
        <h4>作者： {{resAuthor}} &nbsp 发表时间： {{resDate}} &nbsp 来源： {{resSource}} &nbsp 回复评论： {{resCommentCount}}</h4>
        </Col>
      </Row>
    </Card>
    <Card>
      <Row>
        <Col span="24">
        <p>　　90年代后随着“文化热”的主流从“反传统”到“弘扬传统”的转变，“大清颂”的调子更越唱越高了，以至出现“满台大辫子”、“五个乾隆（或x个慈禧等等）闹荧屏”的景观。这里除了市场经济中娱乐文艺自然繁荣的成分外，为免罹文网而回避现实的遁世自娱式“说古”也是不可忽视的因素。源自港台的“戏说乾隆”式帝王剧在大陆出现了青胜于蓝的流行，也就不难理解了。非昔比。但有趣的是从80年代起，在当时盛行“荆轲刺孔子”式的传统文化批判的同时，史学界与文艺界都一反民国以来对“满清”的贬斥，竞相掀起歌颂清代帝王的浪潮。从努尔哈赤、皇太极、顺治、康熙、雍正、乾隆以至多尔衮、孝庄文皇后，个个雄才大略，人人奋发有为，圣明君主之多开历朝未有之盛。这种全盘否定远古传统与极为美化近古帝王的二朝并存现象很耐人寻味。
        </p>
        </Col>
      </Row>
    </Card>

  </div>
</template>
<script>
  import {
    getEssay
  } from "@/api/data";
  export default {
    props: {

    },
    data() {
      return {
        resContext: '',
        resAuthor: '',
        resDate: '',
        resCommentCount: '',
        resSource:''
      }
    },
    methods: {
      handleGetEssay(id) {
        getEssay(id)
          .then(res => {
            res = res.data.data;
            this.resContext = res.resContext
            this.resAuthor = res.resAuthor
            this.resDate = res.resDate
            this.resCommentCount = res.resCommentCount
            this.resSource=res.resSource
            
           
          })
          .catch(err => {
            console.log(err);
            reject(err);
          });
      }
    },
    mounted() {
      this.handleGetEssay()
    }
  }

</script>
