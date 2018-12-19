<template>
<Row>
   <Col span="8">
  <div style="width: 90%;height: 350px; align:right ">
    <Form :label-width="100" :model="formModel" ref="gradeForm">
      <h2 align="center">成绩预测</h2>
      <br>
      <FormItem label="学号：">
        <Input v-model='studentid' disabled placeholder="学号" size='default' />
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
        <Button type="primary" @click="handleForecast()" size="large"  > 开始预测</Button>
      </FormItem>
    </Form>
  </div>
  </Col>
  </Row>
</template>
<script>
  export default {
    name: "ables_page",

    data() {
      return {
        formModel: {
          accounttype: '',
          examtype: '',
          credit: ''
        },
        studentid:'',


      };

    },
    methods: {
    handleForecast(){
      this.$refs.gradeForm.validate(valid => {
        if (valid) {
          putregist(
            this.formModel.accounttype,
            this.formModel.examtype,
            this.formModel.credit,
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
    },
    mounted() {

    },
  }

</script>
