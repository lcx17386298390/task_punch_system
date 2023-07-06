<template>
  <div>
    任务标题:<input type="text" v-model="inputTitle" placeholder="不得多于十个字符"><br>
    任务简介:<textarea cols="30" rows="10" v-model="inputContent"></textarea><br>
    <button @click="createList">新增任务</button> <br>
    指定任务点学生姓名:<input type="text" v-model="inputStudentName"> <br>
    指定任务点所写内容:<textarea cols="30" rows="10" v-model="inputTaskItemContent"></textarea> <br>
    指定任务点评分:<input type="number" v-model="inputScore"> <br>
    <table>
      <tr>
        <th>id</th>
        <th>标题</th>
        <th>内容</th>
      </tr>
      <tr v-for="viewTask of taskList" :key="viewTask.id">
        <td>{{viewTask.id}}</td>
        <td>{{viewTask.title}}</td>
        <td>{{viewTask.content}}</td>
        <td><button @click="createTaskItem(viewTask.id)">增加任务点</button></td>
        <td><button @click="deleteList(viewTask.id,viewTask.title)">删除</button></td>
        <td><button @click="editTaskItem(viewTask.id)">修改</button></td>
        <td></td>
      </tr>
    </table>
    <!--分页-->
    <div class="page_box">
      <ul class="pagination">
        <li ><a href="javascript:void(0)" @click="first">首页</a></li>
        <li><a href="javascript:void(0)" @click="pre">上一页</a></li>
        <li class="active"><span>{{this.pageInfo.pageNo}}</span></li>
        <li><a href="javascript:void(0)" @click="next">下一页</a></li>
        <li><a href="javascript:void(0)" @click="last">尾页</a></li>
        <li class="totalPages"><span>共{{this.pageInfo.totalPage}}页</span></li>
      </ul>
    </div>
    共{{this.pageInfo.totalRecord}}个任务 <br>
    请输入你要查询学生姓名:<input type="text" v-model="queryStuName">
    <button @click="calculateScore">查询</button> <br>
    <h3>{{calScore}}</h3>
  </div>
</template>

<script>
import axios from "axios";
import {doGet} from "@/api/httpRequest";
import layx from "vue-layx";

export default {
  name: "testTask",
  data:function (){
    return {
      inputTitle: "",
      inputContent: "",
      inputStudentName:"",
      inputTaskItemContent: "",
      inputScore: "",
      queryStuName: "",
      calScore: 0,
      taskList : [{
        id: "",
        content: "",
        title: ""
      }],
      pageInfo : [{
        pageNo: 1,
        totalRecord: "",
        totalPage: ""
      }]
    }
  },
  methods:{
    createList(){
      if(this.inputTitle.trim() === ""){
        alert("标题不能为空!");
        return;
      }
      if(this.inputContent.trim() === ""){
        alert("任务简介不能为空!");
        return;
      }
      return axios({
        url: 'http://localhost:8000/tms/task/create',
        method: 'post',
        params: {
          title:this.inputTitle,content:this.inputContent}
      }).then(resp => {
        if(resp){
          alert("创建任务成功!");
          //this.taskList = resp.data.taskList;
          //document.location('http://localhost:8000/tms/task/create')
          location.reload()
        }
      })
    },
    deleteList(id,name){
      if(id === ""){
        alert("请选择至少一项任务进行删除!");
        return;
      }
      return axios({
        url: 'http://localhost:8000/tms/task/delete',
        method: 'post',
        params: {
          id:id
        }
      }).then(resp => {
        if(resp){
          alert("删除" + name + "成功!!!");
          location.reload();
        }
      })
    },
    createTaskItem(id){
      if(id === ""){
        alert("请至少选择一项任务进行任务点添加!");
        return;
      }
      if(this.inputStudentName.trim() === ""){
        alert("请指定一名学生增加任务点!");
        return;
      }
      if(this.inputTaskItemContent.trim() === ""){
        alert("请填写任务点的内容！")
        return;
      }
      return axios({
        url: 'http://localhost:8000/tms/taskitem/create',
        method: 'post',
        params: {
          id:id,
          content:this.inputTaskItemContent,
          name:this.inputStudentName
        }
      }).then(resp => {
        if(resp){
          alert("添加" + this.inputStudentName + "任务成功");
          location.reload();
        }
      })
    },
    editTaskItem(id){
      if(this.inputStudentName === ""){
        alert("学生姓名不能为空！");
        return;
      }
      if(this.inputTaskItemContent === ""){
        alert("修改内容不能为空！");
        return;
      }
      return axios({
        url: 'http://localhost:8000/tms/taskitem/edit',
        method: 'post',
        params: {
          id: id,
          name: this.inputStudentName,
          content: this.inputTaskItemContent,
          judgefinish: this.inputScore
        }
      }).then(resp => {
        if(resp){
          alert("修改成功!");
          location.reload();
        }
      })
    },
    initPage(pageNo,pageSize) {
      doGet('http://localhost:8000/tms/task', {
        pageNo: pageNo,pageSize:pageSize})
          .then(resp => {
            if (resp) {
              this.taskList = resp.data;
              //console.log(resp.data)
            }
          });
      this.updatePage(pageNo);
    },
    first(){
      if( this.pageInfo.pageNo === 1 ){
        layx.msg('已经是第一页数据.',{dialogIcon:'warn',position:'ct'});
      } else {
        this.initPage(1,9);
        this.updatePage(1);
      }
    },
    last(){
      if( this.pageInfo.pageNo === this.pageInfo.totalPage ){
        layx.msg('已经是最后一页数据.',{dialogIcon:'warn',position:'ct'});
      } else {
        this.initPage(this.pageInfo.totalPage,9);
        this.updatePage(this.pageInfo.totalPage);
      }
    },
    pre(){
      if( this.pageInfo.pageNo <= 1 ){
        layx.msg('已经是第一页数据.',{dialogIcon:'warn',position:'ct'});
      } else {
        this.initPage(this.pageInfo.pageNo - 1 , 9);
        this.updatePage(this.pageInfo.pageNo - 1);
      }

    },
    next(){
      if( this.pageInfo.pageNo >= this.pageInfo.totalPage ){
        layx.msg('已经是最后一页数据.',{dialogIcon:'warn',position:'ct'});
      } else {
        this.initPage(this.pageInfo.pageNo + 1, 9);
        this.updatePage(this.pageInfo.pageNo + 1);
      }

    },
    updatePage(pageNo){
      doGet('http://localhost:8000/tms/task/cal').then(resp => {
        if(resp){
          this.pageInfo = resp.data
          this.pageInfo.pageNo = pageNo
        }
      })
    },
    calculateScore(){
      doGet('http://localhost:8001/tms/taskitem/score',{
        name: this.queryStuName
      }).then(resp => {
        if(resp){
          console.log(resp.data);
          this.calScore = Object.values(resp.data)[0]
        }
      })
    }
  },
  mounted() {
    /*doGet('http://localhost:8000/tms/task',{
      pageNo: this.pageInfo.pageNo
    }).then(resp => {
      if(resp){
        this.taskList = resp.data
      }
    })*/

    this.initPage(1,9)
    this.updatePage(1)

  }
}


</script>

<style scoped>

</style>