<template>
  <div>
    <Row>
      <Col span="12">
        <div id="chart" style="width: 100%;height: 500px; "></div>
      </Col>
      <Col span="12">
        <div id="gradepointchart" style="width: 100%;height: 500px; "></div>
      </Col>
    </Row>

    <Table border :columns="gradelist" :data="singleGrade"></Table>
    <br>
    <Row type="flex" align="center">
      <Col>
        <Button primary @click="handleAllPage">全部</Button>
      </Col>
      <Col>
        <Page
          :current="pageNum"
          :total="pageSize"
          size="small"
          show-elevator
          @on-change="handleNextPage"
        />
      </Col>
    </Row>
  </div>
</template>

<script>
import { selectGrade } from "@/api/data";
import charts from "echarts";
export default {
  name: "count_to",
  data() {
    return {
      scoreFlag: false,
      studentid: 0,
      pageNum: 1,
      pageSize: 0,
      singlePageSize: 10,
      singleGrade: [],
      grade: [],
      gradelist: [
        {
          title: "学期",
          key: "term",
          filters: [
            {
              label: "2016-2017",
              value: 1
            },
            {
              label: "2017-2018",
              value: 2
            },
            {
              label: "2018-2019",
              value: 3
            },
            {
              label: "2019-2020",
              value: 4
            }
          ],
          filterMultiple: false,
          filterMethod(value, row) {
            if (value === 1) {
              return row.term == "2016-2017";
            } else if (value === 2) {
              return row.term == "2017-2018";
            } else if (value === 3) {
              return row.term == "2018-2019";
            } else if (value === 4) {
              return row.term == "2019-2020";
            }
          }
        },
        {
          title: "课程名",
          key: "className"
        },
        {
          title: "课程类型",
          key: "classNature"
        },
        {
          title: "学分",
          key: "credit"
        },
        {
          title: "成绩",
          key: "grade",
          filters: [
            {
              label: "60以下",
              value: 1
            },
            {
              label: "60-70",
              value: 2
            },
            {
              label: "70-80",
              value: 3
            },
            {
              label: "80-90",
              value: 4
            },
            {
              label: "90以上",
              value: 5
            }
          ],
          filterMultiple: false,
          filterMethod(value, row) {
            if (value === 1) {
              return row.grade < 60;
            } else if (value === 2) {
              return row.grade > 60 && row.grade < 70;
            } else if (value === 3) {
              return row.grade > 70 && row.grade < 80;
            } else if (value === 4) {
              return row.grade > 80 && row.grade < 90;
            } else if (value === 5) {
              return row.grade > 90;
            }
          }
        },
        {
          title: "绩点",
          key: "PerformancePoint"
        },
        {
          title: "考试类型",
          key: "testNature"
        }
      ],
      scoreData: [
        {
          value: 0,
          name: "0-50"
        },
        {
          value: 0,
          name: "51-60"
        },
        {
          value: 0,
          name: "61-65"
        },
        {
          value: 0,
          name: "66-70"
        },
        {
          value: 0,
          name: "71-75"
        },
        {
          value: 0,
          name: "76-80"
        },
        {
          value: 0,
          name: "81-85"
        },
        {
          value: 0,
          name: "86-90"
        },
        {
          value: 0,
          name: "91-100"
        }
      ],
      pointData: [
        {
          value: 0,
          name: "0-50"
        },
        {
          value: 0,
          name: "51-60"
        },
        {
          value: 0,
          name: "61-65"
        },
        {
          value: 0,
          name: "66-70"
        },
        {
          value: 0,
          name: "71-75"
        },
        {
          value: 0,
          name: "76-80"
        },
        {
          value: 0,
          name: "81-85"
        },
        {
          value: 0,
          name: "86-90"
        },
        {
          value: 0,
          name: "91-100"
        }
      ]
    };
  },
  methods: {
    handleselectGrade(num, pageSize) {
      return new Promise((resolve, reject) => {
        selectGrade(num, pageSize)
          .then(res => {
            res = res.data.data;
            this.studentid = res.list[0].studentId;
            this.grade = res.list;
            this.pageSize = res.total;
            resolve();
          })
          .catch(err => {
            console.log(err);
            reject(err);
          });
      });
    },
    handleCharts() {
      console.log(this.scoreData);
      var myChart = charts.init($("#chart")[0], "light");
      // 指定图表的配置项和数据
      var option = {
        title: {
          text: "各科成绩分布图",
          subtext: "成绩分布",
          x: "40%"
        },
        tooltip: {
          //   grid: tooltip,
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
          orient: "vertical",
          x: "88%",
          y: "center",
          data: [
            "0-50",
            "51-60",
            "61-65",
            "66-70",
            "71-75",
            "76-80",
            "81-85",
            "86-90",
            "91-100"
          ]
        },
        toolbox: {
          show: true,
          feature: {
            mark: {
              show: true
            },

            magicType: {
              show: true,
              type: ["pie", "funnel"]
            }
          }
        },
        calculable: true,
        series: [
          {
            name: "成绩分布",
            type: "pie",
            radius: [20, 110],
            center: ["50%", "54%"],
            roseType: "area",
            label: {
              normal: {
                show: true
              },
              emphasis: {
                show: true
              }
            },
            lableLine: {
              normal: {
                show: true
              },
              emphasis: {
                show: true
              }
            },
            data: this.scoreData
          }
        ]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    },
    handleGradePointCharts() {
      var myChart = charts.init($("#gradepointchart")[0], "dark");
      // 指定图表的配置项和数据
      var option = {
        backgroundColor: "rgba(245,247,249)",
        title: {
          text: "各科绩点分布图",
          subtext: "绩点分布",
          x: "40%",
          textStyle: {
            color: "#000"
          }
        },
        tooltip: {
          //   grid: tooltip,
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
          orient: "vertical",
          x: "85%",
          y: "center",
          textStyle: {
            color: "rgba(0, 0, 0, 0.9)"
          },
          data: [
            "0-50",
            "51-60",
            "61-65",
            "66-70",
            "71-75",
            "76-80",
            "81-85",
            "86-90",
            "91-100"
          ]
        },
        toolbox: {
          show: true,
          feature: {
            mark: {
              show: true
            },
            dataView: {
              show: true,
              readOnly: false
            },
            magicType: {
              show: true,
              type: ["pie", "funnel"]
            },
            restore: {
              show: true
            },
            saveAsImage: {
              show: true
            }
          }
        },
        calculable: true,
        series: [
          {
            name: "成绩分布",
            type: "pie",
            radius: [0, 110],
            center: ["50%", "54%"],
            roseType: "area",
            label: {
              normal: {
                show: true,
                textStyle: {
                  color: "rgba(0, 0, 0, 0.8)"
                }
              },
              emphasis: {
                show: true
              }
            },
            lableLine: {
              normal: {
                show: true
              },
              emphasis: {
                show: true
              }
            },
            data: [
              {
                value: 10,
                name: "0-50"
              },
              {
                value: 10,
                name: "51-60"
              },
              {
                value: 5,
                name: "61-65"
              },
              {
                value: 15,
                name: "66-70"
              },
              {
                value: 25,
                name: "71-75"
              },
              {
                value: 20,
                name: "76-80"
              },
              {
                value: 35,
                name: "81-85"
              },
              {
                value: 20,
                name: "86-90"
              },
              {
                value: 35,
                name: "91-100"
              }
            ]
          }
        ]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    },
    handleNextPage(num) {
      this.pageNum = num;
      let startNum = (num - 1) * this.singlePageSize;
      let endNum = num * this.singlePageSize;
      this.singleGrade = this.grade.slice(startNum, endNum);
    },
    handleAllPage() {
      this.pageNum = 0;
      this.singleGrade = this.grade;
    },
    getScoreChartsDatas(data) {
      console.log("computedScore");
      for (let i in this.grade) {
        let score = this.grade[i].grade;
        if (score >= 0 && score <= 50) {
          data[0].value += 1;
        } else if (score <= 60) {
          data[1].value += 1;
        } else if (score <= 65) {
          data[2].value += 1;
        } else if (score <= 70) {
          data[3].value += 1;
        } else if (score <= 75) {
          data[4].value += 1;
        } else if (score <= 80) {
          data[5].value += 1;
        } else if (score <= 85) {
          data[6].value += 1;
        } else if (score <= 90) {
          data[7].value += 1;
        } else if (score <= 100) {
          data[8].value += 1;
        }
      }
      console.log(data);
    }
  },
  mounted() {
    this.handleselectGrade(1, 100).then(() => {
      this.handleNextPage(1);
      this.getScoreChartsDatas(this.scoreData);
      this.handleCharts();
      this.handleGradePointCharts();
    }).catch(()=>{
          this.handleNextPage(1);
      this.getScoreChartsDatas(this.scoreData);
      this.handleCharts();
      this.handleGradePointCharts();
    });
  },
  updated() {
    this.handleCharts();
    this.handleGradePointCharts();
  }
};
</script>

