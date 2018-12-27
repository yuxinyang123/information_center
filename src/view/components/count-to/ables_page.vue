<template>
  <div>
    <div>
      <Row type="flex" justify="center">
        <Col span="5">
        <h1>各班成绩详细分布</h1>
        </Col>
      </Row>
      <Row>
        <Col span="24">
        <div id="chartclassgrade" style="width: 100%;height: 500px; "></div>
        </Col>
      </Row>
    </div>
    <Row type="flex" align="middle" justify="center">
      <Col span="8">
      <Card>
        <Form :label-width="100" :model="formModel" ref="gradeForm" :rules="ruleforcast">
          <h2 align="center">成绩预测</h2>
          <br>
          <FormItem label="学号：">
            <Input v-model="studentid" disabled placeholder="学号" size="default" />
          </FormItem>
          <FormItem label="学科类型：" prop="accounttype">
            <Select placeholder="选择你的科目类型" v-model="formModel.accounttype">
              <Option value="必修">必修</Option>
              <Option value="选修">选修</Option>
            </Select>
          </FormItem>
          <FormItem label="考试类型：" prop="examtype">
            <Select placeholder="正常考试" v-model="formModel.examtype">
              <Option value="正常考试">正常考试</Option>
            </Select>
          </FormItem>
          <FormItem label="学分：" prop="credit">
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
            <Button type="primary" @click="handleForecast()" size="large">开始预测</Button>
          </FormItem>
        </Form>
      </Card>
      </Col>
      <Col span="16" v-show="forcastFlag">
      <Card style="height:375px">

        <h1>此预测成绩算法使用向量knn法，手动pca，求取最小夹角匹配项，对预测极值进行回归。</h1>

      </Card>
      </Col>
      <Col span="8" v-show="forcastedFlag">
      <div style="text-align:center">
        <h1>你的预测分数为{{grade}}</h1>
      </div>
      </Col>
      <Col span="8" v-show="forcastedFlag">
      <div>
        <h1>{{advice}}</h1>
      </div>
      </Col>
    </Row>
  </div>
</template>
<script>
  import {
    forcastGrade,
    selectGrade,
    getAverage
  } from "@/api/data";
  import charts from "echarts";
  import "echarts-gl";
  export default {
    name: "ables_page",

    data() {
      return {
        formModel: {
          accounttype: "",
          examtype: "",
          credit: ""
        },
        data:[],
        grade: '',
        advice: '',
        forcastFlag: true,
        forcastedFlag: false,
        studentid: "",
        ruleforcast: {
          accounttype: [{
            required: true,
            message: "学科类型不能为空",
            trigger: "blur"
          }],
          examtype: [{
            required: true,
            message: "考试类型不能为空",
            trigger: "blur"
          }],
          credit: [{
            required: true,
            message: "学分不能为空",
            trigger: "blur"
          }],

        }
      };
    },
    methods: {
      handleChartsclassgrade() {
        var myChart = charts.init($("#chartclassgrade")[0], "light");
        var hours = [
          "0",
          "1班",
          "2班",
          "3班",
          "4班",
          "5班",
          "6班",
          "7班",
          "8班",
          "9"
        ];
        var days = [
          "0",
          "大一上学期",
          "大一下学期",
          "大二上学期",
          "大二下学期",
          "5"

        ];

        var data = this.data;
        var option = {
          tooltip: {},

          visualMap: {
            min: 70,
            max: 85,
            inRange: {
              color: [
                '#36A3DB', '#32C5E9', '#66E1E3', '#9FE7B9', '#FFDB3E', '#FF9F7E', '#FB7293', '#E162AF', '#E791D1',
                '#E7BDF3', '#9D97F5', '#8378EB', '#97BFFF'
              ]
            }
          },
          xAxis3D: {
            type: "category",
            data: hours
          },
          yAxis3D: {
            type: "category",
            data: days
          },
          zAxis3D: {
            type: "value",
            min: 60,
            max: 85,
          },
          grid3D: {
            boxWidth: 200,
            boxDepth: 80,
            viewControl: {
              // projection: 'orthographic'
            },
            light: {
              main: {
                intensity: 0.55,
                shadow: true
              },
              ambient: {
                intensity: 0.7,

              },

            }
          },
          series: [{
            type: "bar3D",
            data: data.map(function (item) {
              return {
                value: [item[1], item[0], item[2]]
              };
            }),
            shading: "lambert",

            label: {
              textStyle: {
                fontSize: 16,
                borderWidth: 1
              }
            },

            emphasis: {
              label: {
                textStyle: {
                  fontSize: 30,
                  color: "#900"
                }
              },
              itemStyle: {
                color: "#900"
              }
            }
          }]
        };
        myChart.setOption(option);
      },
      handlestudentid() {
        selectGrade(1, 1)
          .then(res => {
            res = res.data.data.list;
            this.studentid = res[0].studentId;
          })
          .catch(err => {
            console.log(err);
          });
      },
      handleForecast() {

        this.$refs.gradeForm.validate(valid => {
          if (valid) {
            forcastGrade(
                this.studentid,
                this.formModel.accounttype,
                this.formModel.examtype,
                this.formModel.credit
              )
              .then(res => {
                this.grade = res.data.data
                if (this.grade < 60 && this.grade > 40) {
                  this.advice = "同学，你已经挂科了，挂科意味着你还需要参加下学期的补考，如果补考不过，就只能重修，若重修再不过，就延迟毕业了～"
                } else if (this.grade >= 60 && this.grade <= 70) {
                  this.advice = "然后第二个是，你已经在危险的边缘试探了，若再不调整状态就可能GG了"
                } else if (this.grade < 40) {
                  this.advice =
                    "出现这种情况有两种可能你是你没有好好学习，二是你好好学习之后考成这样，前者的话可以通过改变学习态度，调整学习方法来改变现状，后者就要好好思考一下，是不是不太适合上学"
                } else if (this.grade > 70 && this.grade < 85) {
                  this.advice = "你现在的状态一般，需要更加的刻苦学习，再迈一大步就可以到达更高的地方哟"
                } else if (this.grade >= 85) {
                  this.advice =
                    "你现在的状态很好，而学如逆水行舟不进则退，基础非常扎实并且找到了适合自己的学习方法，取得了很好的成绩，学如逆水行舟不进则退，希望不要骄傲，继续保持，一定要更加努力哟！继续保持~"
                }

                this.$Message.success(
                  "正在计算")
               
                this.forcastFlag = false
                this.forcastedFlag = true

              })
              .catch(err => {
                console.log(err);
              });
          } else {
            this.$Message.error("计算失败.");
          }
        })
      },
      handlegetAverage() {
        getAverage().then(res => {
            res = res.data.data;
            this.data = res;
         
            this.handleChartsclassgrade()
          })
          .catch(err => {
            console.log(err)
          })
      }

    },
    mounted() {
      this.$nextTick(() => {
        this.handleChartsclassgrade();
      });
      this.handlestudentid();
      this.handlegetAverage()
    }
  };

</script>
