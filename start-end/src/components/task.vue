<template>
  <div>
    任务标题:<input type="text" v-model="inputTitle"><br>
    任务简介:<input type="text" v-model="inputContent"><br>
    <button @click="createList">新增任务</button> <br>
    指定任务点学生姓名:<input type="text" v-model="inputStudentName"> <br>
    指定任务点所写内容:<input type="text" v-model="inputTaskItemContent"> <br>
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
        <td></td>
      </tr>
      </table>
  </div>
</template>

<script>
import axios from "axios";
import {doGet} from "@/api/httpRequest";

export default {
  name: "testTask",
  data:function (){
    return {
      inputTitle: "",
      inputContent: "",
      inputStudentName:"",
      inputTaskItemContent: "",
      taskList : [{
        id: "",
        content: "",
        title: ""
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
    }
  },
  mounted() {
    doGet('http://localhost:8000/tms/task').then(resp => {
      if(resp){
        this.taskList = resp.data
      }
    })
  }
}


</script>

<style scoped>

</style>