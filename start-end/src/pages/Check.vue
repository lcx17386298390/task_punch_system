<template>
  <div>
    <div class="mask" v-if="inputIfShow" @click="inputIfShow = false"></div>
    <div class="check-container">
      <span>增加共同任务点</span>
      <button class="plus" @click="showState1 = true">
        <i class="fa fa-plus"></i>
      </button>

      <div id="app">
        <div class="dialog-container">
          <button class="dialog-button" @click="openDialog">
            {{ selectedName || "全部" }}
          </button>
          <div
              v-if="dialogVisible"
              class="dialog"
              @click="closeDialog"
              @keydown.esc="closeDialog"
              tabindex="0"
          >
            <p>选择姓名</p>
            <ul>
              <li
                  v-for="item in names"
                  :key="item.id"
                  @click="selectName(item)"
              >
                {{ item.name }}
              </li>
            </ul>
          </div>
        </div>
<!--        <div id="content">{{ content }}</div>-->
      </div>

      <div class="newFile">
        <div class="showNewDetails">
          <h3>
            <i class="fas fa-edit"></i>{{ this.$route.query.taskContent }}
          </h3>
          <hr />
          <div class="addNewTasks">
            <span style="margin-right: 4px">给ta增加任务点</span>
            <button class="plus"
                @click="inputIfShow = true">
              <i class="fa fa-plus"></i></button
            ><br />
            <input
                type="text"
                v-if="inputIfShow"
                style="position: fixed; width: 40%"
                placeholder="任务内容"
                v-model="inputTaskItemContentForSb"
            /><button
              class="search"
              v-if="inputIfShow"
              @click="createTaskItemForSb()"
              style="position: fixed; left: 45%"
          >
            <i class="fa fa-check"></i>
          </button>
            <div class="newTasks">
              <table>
                <tbody>
                <tr v-for="task of tasks" :key="task.id">
                  <td>{{ task.name }}</td>
                  <td>{{ task.content }}</td>
                  <td v-if="task.judgefinish===0">未评</td>
                  <td v-else>{{task.judgefinish}}</td>
                  <td>
                    <button
                        class="delete"
                        @click="deleteTaskItem(task.id, task.name)"
                    >
                      <i class="fas fa-times"></i>
                    </button>
                  </td>
                  <td>
                    <button
                        class="edit"
                        @click="transmitNameAndId(task.name, task.id)"
                    >
                      <i class="fas fa-pencil-alt fa-fw"> </i>
                    </button>
                  </td>
                </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
        <span v-if="!(this.selectedName==='全部' || this.selectedName==='')">ta的任务均分为{{tempScore}}</span>
      </div>
    </div>

    <div class="box">
      <div class="mask" v-if="showState" @click="showState = false"></div>
      <div class="scoreModel" v-if="showState">
        <h3><i class="fa fa-smile"></i>评分</h3>
        <hr />
        <input
            type="number"
            :placeholder="this.tempPlaceholder"
            max="100"
            min="0"
            oninput="if(value>100)value=100;if(value<0)value=0;"
            v-model="inputStuScore"
        />
        <button @click="markTaskItem()">commit</button>
      </div>
    </div>

    <!-- 指定多人任务点弹窗 -->
    <div class="box">
      <div class="mask" v-if="showState1" @click="showState1 = false"></div>
      <div class="model0" v-if="showState1">
        <h3>指定</h3>
        <ul>
          <li
              v-for="name in names"
              :key="name.id"
              @click="toggleNames(name.name)"
          >
            {{ name.name
            }}<input
              type="checkbox"
              style="float: left"
              :checked="selectedNames.includes(name.name)"
          />
          </li>
        </ul>
        <input
            type="text"
            placeholder="任务内容"
            v-model="inputCreateTaskItemContent"
        />
        <br />
        <button
            @click="
            createTaskItem(
              $route.query.taskId,
              selectedNames,
              inputCreateTaskItemContent
            )
          "
        >
          commit
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { doGet } from "@/api/httpRequest";
import axios from "axios";
import qs from "qs";
import layx from "vue-layx";

export default {
  data() {
    return {
      name: "Check",
      inputIfShow: false,
      showState: false,
      showState1: false,
      selectedName: "",
      inputStuScore: "",
      tempPlaceholder: "",
      tempName: "",
      tempId: "",
      inputTaskItemContentForSb: "",
      tempScore: "",
      tasks: [{ id: "", title: "", content: "", name: "" ,judgefinish: ""}],
      inputCreateTaskItemContent: "",
      dialogVisible: false,
      names: [
        {
          id: 1,
          name: "chh",
        },
        {
          id: 2,
          name: "dc",
        },
        {
          id: 3,
          name: "yq",
        },
        {
          id: 4,
          name: "cyj",
        },
        {
          id: 5,
          name: "gt",
        },
        {
          id: 6,
          name: "xxj",
        },
        {
          id: 7,
          name: "wqw",
        },
        {
          id: 8,
          name: "wy",
        },
        {
          id:9,
          name: "全部"
        }
      ],
      selectedNames: [],
      pageInfo: [
        {
          pageNo: 1,
          totalRecord: "",
          totalPage: "",
        },
      ],
    };
  },
  methods: {

    openDialog() {
      this.dialogVisible = true;
      document.addEventListener("click", this.handleOutsideClick);
      document.addEventListener("keydown", this.handleKeyDown);
    },
    closeDialog() {
      this.dialogVisible = false;
      document.removeEventListener("click", this.handleOutsideClick);
      document.removeEventListener("keydown", this.handleKeyDown);
    },
    handleOutsideClick(event) {
      if (!this.$el.contains(event.target)) {
        this.closeDialog();
      }
    },
    handleKeyDown(event) {
      if (event.key === "Escape") {
        this.closeDialog();
      }
    },
    selectName(item) {
      this.selectedName = item.name;
      this.initPage(this.$route.query.taskId,item.name)
      this.closeDialog();
      this.calculateScore();
      //console.log(this.selectedName)
    },

    deleteTaskItem(id, name) {
      doGet("http://localhost:8000/tms/taskitem/delete", {
        id: id,
        name: name,
      }).then((resp) => {
        if (resp) {
          //console.log(resp.data.retData);
          location.reload();
          // this.tasks = resp.data.retData;
          //console.log(resp.data)
        }
      });
    },
    // fetchData(name) {
      // // 发送请求到后端，根据subItemName获取相应的数据
      // axios.get(`/api/data?name=${subItemName}`)
      //   .then(response => {
      //     // 返回的数据是包含id、title和content的对象
      //     const newData = {
      //       id: response.data.id,
      //       title: response.data.title,
      //       content: response.data.content
      //     };
      //     this.tasks.push(newData);
      //   })
      //   .catch(error => {
      //     console.error(error);
      //   });
    // },
    markTaskItem() {
      this.showState = false;
      doGet("http://localhost:8000/tms/taskitem/givemark", {
        name: this.tempName,
        id: this.tempId,
        judgefinish: this.inputStuScore,
      }).then((resp) => {
        if (resp) {
          location.reload();
        }
      });
    },
    calculateScore() {
      doGet('http://localhost:8001/tms/taskitem/score', {
        name: this.selectedName,pid:this.$route.query.taskId
      }).then(resp => {
        if (resp) {
          console.log(Object.values(resp.data)[0]);
          this.tempScore = Object.values(resp.data)[0]
          //this.calScore = resp.data
        }
      })
    },
    transmitNameAndId(name, id) {
      this.showState = true;
      this.tempName = name;
      this.tempId = id;
      this.tempPlaceholder = "给" + name + "同学打分吧~";
    },
    createTaskItem(pid, name, content) {
      const data = qs.stringify(
          { name: name },
          {
            arrayFormat: "comma",
          }
      );
      doGet("http://localhost:8000/tms/taskitem/create", {
        pid: pid,
        name: data,
        content: content,
      }).then((resp) => {
        if (resp) {
          console.log(resp.data.retData);
          location.reload();
          // this.tasks = resp.data.retData;
          //console.log(resp.data)
        }
      });
    },
    toggleNames(name) {
      if (this.selectedNames.includes(name)) {
        this.selectedNames = this.selectedNames.filter((name) => name !== name);
        //console.log(this.selectedNames)
      } else {
        this.selectedNames.push(name);
        //console.log(this.selectedNames)
      }
    },
    initPage(pid,name) {
      //this.adminShow=true
      if("全部" === name){
        doGet("http://localhost:8000/tms/taskitem/viewAdminTaskItem", {
          pid: pid,
        }).then((resp) => {
          if (resp) {
            this.tasks = resp.data.retData;
          }
        });
      }else{
        doGet("http://localhost:8000/tms/taskitem/viewTaskItemByPidAndName", {
          pid: pid,name:name
        }).then((resp) => {
          if (resp) {
            this.tasks = resp.data.retData;
          }
        });
      }

    },
    createTaskItemForSb(){
      if(this.selectedName==="全部"||this.selectedName===""){
        alert("请指定一人进行任务点增加!");
        return;
      }
      this.inputIfShow = false
      const data = qs.stringify(
          { name: this.selectedName },
          {
            arrayFormat: "comma",
          }
      );
      doGet("http://localhost:8000/tms/taskitem/create", {
        pid: this.$route.query.taskId,name:data,content:this.inputTaskItemContentForSb
      }).then((resp) => {
        if (resp) {
          location.reload();
        }
      });
    }
  },
  mounted() {
    this.initPage(this.$route.query.taskId,"全部");
  },
};
</script>

<style scoped>
.check-container {
  padding: 20px;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 770px;
  height: 550px;
  background-color: #f9fcfd;
  border-radius: 10px;
  box-shadow: 5px 4px 4px rgba(0, 0, 0, 0.1);
}
.dialog-container {
  position: fixed;
}
.dialog-button {
  padding: 15px 30px;
  background-color: #92a4a8f5;
  color: #232323;
  border: none;
  cursor: rgb(200, 189, 189) nter;
  font-size: 16px;
}

.dialog {
  position: relative;
  top: 70%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding: 20px;
  background-color: #f5f5f5;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  border-radius: 4px;
  max-width: 66px;
  width: 100%;
}

.dialog h2 {
  margin-top: 0;
  font-size: 24px;
  color: #333;
}

.dialog ul {
  list-style-type: none;
  padding: 0;
}

.dialog li {
  margin-bottom: 10px;
  cursor: pointer;
  font-size: 18px;
  color: #333;
}

.dialog li:hover {
  color: #b7c1c5f5;
  background-color: aliceblue;
}
/* cd加的 */
.newFile {
  margin-top: 10%;
}
.newFile .members {
  height: 30px;
  margin-top: 20px;
}
.model0 li {
  margin-right: 5px;
  margin-top: 5px;
  height: 26px;
  padding-top: 4px;
  float: left;
  width: 20%;
  background-color: #adb9d440;
}
/* .newFile .members li:hover {
  background-color: #adb9d482;
  border-top: 1px solid black;
}
.newFile .members li:focus {
  background-color: #adb9d482;
  border-top: 1px solid black;
} */
.showNewDetails {
  border: 1px solid rgba(0, 0, 0, 0.317);
  border-radius: 4px;
  height: 400px;
  padding: 10px;
  margin: 15px 0;
}
.newTasks td {
  padding: 6px 0;
}
.newTasks {
  margin: 27px 0;
  height: 300px;
  overflow-y: auto;
  background-color: #d57ba01a;
}
/* 打分弹窗 */
.box {
  display: flex;
  flex-direction: column;
}
.mask {
  background: #55585d;
  opacity: 0;
  position: fixed;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
  z-index: -1;
}
.scoreModel {
  position: fixed;
  background-color: rgba(255, 255, 255, 0.788);
  width: 300px;
  display: flex;
  left: 70%;
  top: 38%;
  bottom: 42%;
  z-index: 91;
  margin-left: -20px;
  box-shadow: -20px 0 20px 0 rgb(0 0 0 / 10%);
  flex-direction: column;
  padding: 30px;
  border-radius: 6px;
}
.scoreModel button:hover {
  transform: none;
}
.scoreModel button {
  width: 70px;
  margin-left: 36%;
  border-radius: 4px;
}
.scoreModel button:active {
  background-color: #2c66e4;
}

.scoreModel input {
  border: none;
  border: rgba(0, 0, 0, 0.2) 1px solid;
  border-radius: 4px;
  outline: none;
  float: left;
  margin-right: 4px;
  left: 0;
  width: 30%;
  padding: 6px;
}
.scoreModel input {
  width: 80%;
  margin: 20px;
}

/* 指派多人任务弹窗 */
.model0 {
  position: fixed;
  background-color: rgba(255, 255, 255, 0.788);
  width: 300px;
  display: flex;
  left: 36%;
  top: 18%;
  bottom: 58%;
  z-index: 91;
  margin-left: -20px;
  box-shadow: -20px 0 20px 0 rgb(0 0 0 / 10%);
  flex-direction: column;
  padding: 30px;
  border-radius: 6px;
}
.model0 button:hover {
  transform: none;
}
.model0 button {
  width: 70px;
  margin-left: 36%;
  border-radius: 4px;
}
.model0 button:active {
  background-color: #2c66e4;
}

/* .model0 input {
  border: none;
  border: rgba(0, 0, 0, 0.2) 1px solid;
  border-radius: 4px;
  outline: none;
  float: left;
  margin-right: 4px;
  left: 0;
  width: 30%;
  padding: 6px;
}
.model0 input {
  width: 80%;
  margin: 20px;
} */
/* 按钮表格等 */
table {
  left: 0;
  right: 0;
  margin: 0 auto;
  width: 90%;
  border-collapse: collapse;
}
th,
td {
  text-align: center;
  padding: 12px 0px;
  border-bottom: rgba(0, 0, 0, 0.2) 1px solid;
  letter-spacing: 2px;
}
button {
  height: 24px;
  width: 24px;
  background-color: #a7cad7a9;
  border-radius: 50%;
  padding: 4px;
  border: none;
}
button:hover {
  background-color: rgba(0, 0, 0, 0.2);
  transform: translateY(-2px);
}
.edit:active {
  background-color: #2c66e4;
}
.delete:active {
  background-color: crimson;
}
.plus:active {
  background-color: rgb(56, 147, 150);
}
.search:active {
  background-color: #d73a8b66;
}
</style>