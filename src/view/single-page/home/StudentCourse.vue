<template>
  <div>
    <div style="display: none">
   {{course}}
</div>
    <table class="course" border="1">
      <thead>
        <tr>
          <th>节次</th>
          <th id="z1">周一</th>
          <th id="z2">周二</th>
          <th id="z3">周三</th>
          <th id="z4">周四</th>
          <th id="z5">周五</th>
          <th id="z6">周六</th>
          <th id="z7">周日</th>
        </tr>
      </thead>
      <tr v-for="i in 13" :key="i" :id="i+'j'">
        <td>{{i}}</td>
        <td v-for="j in 7" :key="j+i" :id="'z'+j+'-'+i+'j'" @click="handleClick('z'+j+'-'+i+'j')">
          <!-- {{course.}} -->
        </td>
      </tr>
    </table>
  </div>
</template>
<script>
  export default {
    name: 'StudentCourse',
    props: {
      course: Object,
    },
    data() {
      return {

      }
    },
    beforeUpdate() {
      this.generatorCourse()

    },
    methods: {
      generatorCourse() {
        // console.log(this.course)
        function mergeSameTd(node, z) {
          for (let c in node) {
            let startpart = node[c].startpart
            let endpart = node[c].endpart
            let j = startpart + "j"
            $("#" + z + "-" + j).attr("rowspan", endpart - startpart + 1);
            for (let i = startpart + 1; i <= endpart; i++) {
              $("#" + z + "-" + i + "j").hide();
            }
          }

        }

        function writeTdByNode(node, z) {
          for (let c in node) {
            let courseNode = node[c]
            for (let index = courseNode.startpart; index <= courseNode.endpart; index++) {
              let j = index + "j"
              let node = $("#" + z + "-" + j)
              node.html(node.html() + '<p class="classname">' + courseNode.classname + '</p>')
              node.html(node.html() + '<p class="classroom">' + courseNode.classroom + '</p>')
              node.html(node.html() + '<p class="teacher">' + courseNode.teacher + '</p>')
            }
          }
        }

        let course = this.course
        for (let weekend in course) {
          let z
          switch (weekend) {
            case "星期一":
              z = "z1"
              break
            case "星期二":
              z = "z2"
              break
            case "星期三":
              z = "z3"
              break
            case "星期四":
              z = "z4"
              break
            case "星期五":
              z = "z5"
              break
            case "星期六":
              z = "z6"
              break
            case "星期日":
              z = "z7"
              break
          }
          writeTdByNode(course[weekend], z)
          mergeSameTd(course[weekend], z)
        }
      },
      handleClick(id){
        console.log(id)
      }

    },

  }

</script>
<style>
  /* .ivu-table td.demo-table-info-mon {
    background-color: #ff9900;
    color: #fff;
  }

  .ivu-table td.demo-table-info-wen {
    background-color: #19be6b;
    color: #fff;
  }

  .ivu-table td.demo-table-info-thu {
    background-color: #ed4014;
    color: #fff;
  }

  .ivu-table td.demo-table-info-fri {
    background-color: #2db7f5;
    color: #fff;
  } */

  .course {
    font-size: 18px;
    height: 52px;
    color: #2db7f5;
    text-align: center;
    width: 100%;
  }

  .tablehead {
    width: 10%;
  }

  .course tr {
    height: 43px;
  }

  .course td {
    width: 10%;
  }

</style>
