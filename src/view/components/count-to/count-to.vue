<template>
  <div>
    <Row>
      <Col span="14">
        <div id="chart" style="width: 100%;height: 350px; "></div>
      </Col>
      <Col span="10">
        <div style="width: 90%;height: 350px; align:right ">
          <Form :label-width="100" :model="formModel"  ref="gradeForm" >
           <h2 align="center">成绩预测</h2>
           <br>
           <FormItem label="学号：">
           <Input v-model='studentid' disabled	 placeholder="学号" size='default'/>
           </FormItem>
            <FormItem label="学科类型：">
              <Select placeholder="选择你的科目类型" v-model="formModel.accounttype">
                <Option value="必修">必修</Option>
                <Option value="选修">选修</Option>
              </Select>
            </FormItem>
            <FormItem label="考试类型：">
              <Select placeholder="正常考试" v-model="formModel.examtype">
                <Option value="正常考试">正常考试</Option>
              </Select>
            </FormItem>
            <FormItem label="学分：">
              <Select placeholder="选择学分" v-model="formModel.credit">
                <Option value="1">1</Option>
                <Option value="2">2</Option>
                <Option value="3">3</Option>
                <Option value="4">4</Option>
                <Option value="5">5</Option>
                <Option value="6">6</Option>
              </Select>
            </FormItem>
            <FormItem>
              <Button type="primary" @click="handleForecast()">预测</Button>
            </FormItem>
          </Form>
        </div>
      </Col>
    </Row>

    <Table border :columns="gradelist" :data="grade"></Table>
    <br>
    <Row>
      <Col span="8">&nbsp</Col>
      <Col>
        <Page :total="40" size="small" show-elevator @on-change="handleselectGrade"/>
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
      formModel:{
        accounttype:'',
        examtype:'',
        credit:''
      },
      studentid:'',
      pageNum: 1,
      pageSize: 10,
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
      ]
    };
  },
  methods: {
    handleForecast(){
      this.$refs.gradeForm.validate(valid => {
        if (valid) {
          putregist(
            this.formModel.mail,
            this.formModel.passwd,
            this.formModel.username,
            this.formModel.phone,
          )
            .then(res => {
              console.log(res);
              if (res.data.code == 200) {
                this.$Message.success(
                
                );
                setTimeout(function() {
                  window.open("login.vue", "_self");
                }, 5000);
              } else if (res.data.code == 500) {
                this.$Message.error("注册失败");
              }
            })
            .catch(err => {
              console.log(err);
            });
        }
      });
    },
    handleselectGrade(num) {
      this.pageNum = num;
      selectGrade(this.pageNum, this.pageSize)
        .then(res => {
          res = res.data.data;
          this.studentid=res[0].studentId
          this.grade = res;
          console.log(res);
          console.log(this.studentid)
        })
        .catch(err => {
          console.log(err);
        });
    },
    handleCharts() {
      var myChart = charts.init($("#chart")[0], "light");
      // 指定图表的配置项和数据
      var option = {
        title: {
          text: "南丁格尔玫瑰图",
          subtext: '成绩分布',
          x: "37%"
        },
        tooltip: {
          //   grid: tooltip,
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
          orient: "vertical",
          x: "87%",
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
            radius: [20, 110],
            center: ["50%", "55%"],
            roseType: "radius",
            label: {
              normal: {
                show: false
              },
              emphasis: {
                show: true
              }
            },
            lableLine: {
              normal: {
                show: false
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
                name: "71--75"
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
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.handleCharts();
    });
    this.handleselectGrade();
  }
};
</script>

<style>
</style>
