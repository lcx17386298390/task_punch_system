<template>
  <div class="viewtasks">
    <!-- <div>
      <ul v-for="(item, index) in data" :key="index">
        <li>{{ item.title }}</li>
        <li>{{ item.content }}</li>
        <li>{{ item.names.join(', ') }}</li>
        <button @click="edit(index)">Edit</button>
        <button @click="remove(index)">Remove</button>
      </ul>
    </div> -->
    <a href="/studentHome" class="back">back</a>
    <div class="container">
      <span style="letter-spacing: 2px">My Tasks</span>
      <div class="search" style="margin: 6px">
        我的<input type="radio" name="aaa" @click="initPage(1,6)" :checked="isMineChecked">
        管理员<input type="radio" name="aaa" @click="initAllAdminTaskItem(1,6)">
      </div>
      <hr />
      <table  v-if="adminShow">
        <thead>
          <tr>
            <th>序号</th>
            <th>标题</th>
            <th>查看</th>
            <th>删除</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item, index) in taskList" :key="item.id" class="line">
            <td>{{ index + 1 }}</td>
            <td>
              <span
                v-show="!item.editState"
                class="desc"
                @click="enterEdit(item)"
                >{{ item.title }}</span
              >
              <input
                  maxlength="15"
                v-show="item.editState"
                ref="inputDesc"
                type="text"
                :value="item.title"
                @blur="updateDesc(item, $event)"
              />
            </td>
            <!-- <td>
              <span
                v-show="!item.editState1"
                class="desc"
                @click="enterEdit1(item)"
                >{{ item.content }}</span
              >
              <input
                v-show="item.editState1"
                ref="inputDesc1"
                type="text"
                :value="item.content"
                @blur="updateDesc1(item, $event)"
              />
            </td> -->
            <td>
              <button class="plus" @click="viewTaskItemContent(item.name,item.id)">
                <i class="fa fa-plus"></i>
              </button>
            </td>
            <td>
              <button class="delete" @click="deleteTaskItem(item.name,item.id)"><i class="fas fa-times"></i></button>
            </td>
          </tr>
        </tbody>
      </table>

      <table  v-if="!adminShow">
        <thead>
        <tr>
          <th>序号</th>
          <th>内容</th>
          <th>查看</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="item in allAdminTaskList" :key="item.id" class="line">
          <td>{{ item.name }}</td>
          <td>
              <span
                  v-show="!item.editState"
                  class="desc"
              >{{ item.content }}</span
              >
          </td>
          <!-- <td>
            <span
              v-show="!item.editState1"
              class="desc"
              @click="enterEdit1(item)"
              >{{ item.content }}</span
            >
            <input
              v-show="item.editState1"
              ref="inputDesc1"
              type="text"
              :value="item.content"
              @blur="updateDesc1(item, $event)"
            />
          </td> -->
          <td>
            <button class="plus" @click="viewTaskItemContent(item.name,item.id)">
              <i class="fa fa-plus"></i>
            </button>
          </td>
<!--          <td>-->
<!--            <button class="delete" @click="deleteTaskItem(item.name,item.id)"><i class="fas fa-times"></i></button>-->
<!--          </td>-->
        </tr>
        </tbody>
      </table>

      <div class="page">
        <ul>
          <li class="up"><a href="javascript:;" @click="first">首页</a></li>
          <li class="up"><a href="javascript:;" @click="pre">上一页</a></li>
          <li>{{this.pageInfo.pageNo}}</li>
          <li class="down"><a href="javascript:;" @click="next">下一页</a></li>
          <li class="down"><a href="javascript:;" @click="last">尾页</a></li>
          <br>
          <li class="li1">共{{this.pageInfo.totalPage}}页</li>
          <li>共{{this.pageInfo.totalRecord}}个任务</li>
        </ul>
      </div>
    </div>

    <div class="box">
      <div class="mask" v-if="showModal" @click="showModal = false,ifShow=false"></div>
      <div class="pop" v-if="showModal">
        <!-- 关闭 -->
        <div class="main-container">
          <h3><i class="fas fa-edit"></i>任务内容</h3>
          <hr />
          <div class="main">
            <span v-if="!ifShow" style="line-height: 24px;letter-spacing: 2px;">{{this.tempContent}}</span>
            <textarea v-if="ifShow"
              name=""
              id=""
              cols="10"
              rows="8"
              placeholder="任务点内容"
              v-model="tempContent"
            ></textarea>
              <span v-if="inputError" style="color: crimson;padding-top:4px;">内容不能超过200字~~</span>
              <button v-if="adminShow" @click="ifShow=true">Edit</button>
              <button v-if="adminShow" @click="editTaskItemContent(tempContent),ifCommit(tempContent)">commit</button>

          </div>
        </div>
      </div>
    </div>
    <div class="score">
      <span>My Score:</span>
      <div class="scoreShow">{{ this.calScore }}</div>
    </div>
  </div>
</template>
  
  <script>
// import TopBanner from "@/components/general/TopBanner";

import {doGet} from "@/api/httpRequest";
import layx from "vue-layx";

export default {
  name: "ViewYourTasks",
  components: {
    // GiveTask ，
    // TopBanner,
  },
  data() {
    return {
      showModal: false,
      ifShow:false,
      adminShow:true,
      inputError:false,
      isMineChecked: true,
      checkedItems: [],
      StuName: "chh",
      tempContent:"",
      calScore: "",
      tempId: "",
      tempName: "",
      allAdminTaskList: [{
        id: "",
        title: "",
        content: ""
      }],
      taskList: [
        {
          id: "",
          title: "",
          content: ""
        }
      ],
      pageInfo : [{
          pageNo: 1,
          totalRecord: "",
          totalPage: ""
      }],
      send_title: "",
      send_content: "",
      // submittedData: [],
    };
  },
  computed: {},
  created() {
    this.send_title = this.$route.query.send_title || "";
    this.send_content = this.$route.query.send_content || "";
  },
  // watch: {
  //   input1(value) {
  //     this.submittedData[0] = value;
  //   },
  //   input2(value) {
  //     this.submittedData[1] = value;
  //   },
  // },

  methods: {
    enterEdit(item) {
      // eslint-disable-next-line no-prototype-builtins
      if (item.hasOwnProperty("editState")) {
        item.editState = true;
      } else {
        this.$set(item, "editState", true);
      }
      this.$nextTick(() => {
        this.taskList.forEach((item, index) => {
          this.$refs.inputDesc[index].focus();
        });
      });
    },
    enterEdit1(item) {
      // eslint-disable-next-line no-prototype-builtins
      if (item.hasOwnProperty("editState1")) {
        item.editState1 = true;
      } else {
        this.$set(item, "editState1", true);
      }
      this.$nextTick(() => {
        this.items.forEach((item, index) => {
          this.$refs.inputDesc1[index].focus();
        });
      });
    },
    updateDesc(item, e) {
      if (e.target.value == "") return;
      else {
        item.title = e.target.value;
        item.editState = false;
        doGet('http://localhost:8000/tms/taskitem/editStuTaskItemTitleVal', {
          name: item.name,
          id: item.id,
          title: item.title
        })
            .then(resp => {
              if (resp) {
                console.log(resp.data.message);
                //console.log(resp.data)
              }
            });
      }
    }
    ,
    updateDesc1(item, e) {
      if (e.target.value == "") return;
      else {
        item.content = e.target.value;
        item.editState1 = false;
      }
    },
    /*/taskitem/viewSelfTask*/
    initPage(pageNo, pageSize) {
      this.adminShow=true
      this.isMineChecked=true
      doGet('http://localhost:8001/tms/taskitem/viewSelfTask', {
        pageNo: pageNo, pageSize: pageSize, name: this.StuName
      })
          .then(resp => {
            if (resp) {
              //console.log(resp.data.retData);
              this.taskList = resp.data;
              //console.log(resp.data)
            }
          });
      this.updatePage(pageNo);
    },
    calculateScore() {
      doGet('http://localhost:8001/tms/taskitem/scoreForStu', {
        name: this.StuName
      }).then(resp => {
        if (resp) {
          console.log(Object.values(resp.data)[0]);
          this.calScore = Object.values(resp.data)[0]
          //this.calScore = resp.data
        }
      })
    },
    updatePage(pageNo) {
      doGet('http://localhost:8000/tms/taskitem/cal', {
        pageNo: this.pageInfo.pageNo, name: this.StuName
      }).then(resp => {
        if (resp) {
          this.pageInfo = resp.data;
          this.pageInfo.pageNo = pageNo
        }
      })
    },
    first() {
      if (this.pageInfo.pageNo === 1) {
        layx.msg('已经是第一页数据.', {dialogIcon: 'warn', position: 'ct'});
      } else if(this.isMineChecked){
        this.initPage(1, 6);
        this.updatePage(1);
      }else{
        this.initAllAdminTaskItem(1,6);
        this.initAllAdminTaskItemPageInfo(1);
      }
    },
    last() {
      if (this.pageInfo.pageNo === this.pageInfo.totalPage) {
        layx.msg('已经是最后一页数据.', {dialogIcon: 'warn', position: 'ct'});
      } else if(this.isMineChecked){
        this.initPage(this.pageInfo.totalPage, 6);
        this.updatePage(this.pageInfo.totalPage);
      }else{
        this.initAllAdminTaskItem(this.pageInfo.totalPage,6);
        this.initAllAdminTaskItemPageInfo(this.pageInfo.totalPage);
      }
    },
    pre() {
      if (this.pageInfo.pageNo <= 1) {
        layx.msg('已经是第一页数据.', {dialogIcon: 'warn', position: 'ct'});
      } else if(this.isMineChecked){
        this.initPage(this.pageInfo.pageNo - 1, 6);
        this.updatePage(this.pageInfo.pageNo - 1);
      }else{
        this.initAllAdminTaskItem(this.pageInfo.pageNo - 1, 6);
        this.initAllAdminTaskItemPageInfo(this.pageInfo.pageNo - 1);
      }

    },
    next() {
      if (this.pageInfo.pageNo >= this.pageInfo.totalPage) {
        layx.msg('已经是最后一页数据.', {dialogIcon: 'warn', position: 'ct'});
      } else if(this.isMineChecked){
        this.initPage(this.pageInfo.pageNo + 1, 6);
        this.updatePage(this.pageInfo.pageNo + 1);
      }else{
        this.initAllAdminTaskItem(this.pageInfo.pageNo + 1, 6);
        this.initAllAdminTaskItemPageInfo(this.pageInfo.pageNo + 1);
      }

    },
    // showModal = true
    viewTaskItemContent(name, id) {
      this.showModal = true
      doGet('http://localhost:8000/tms/taskitem/view', {
        name: name, id: id
      }).then(resp => {
        if (resp) {
          //console.log(resp.data.message)
          this.tempContent = resp.data.retData.content
          this.tempName=name
          this.tempId=id
        }
      })
    },
    deleteTaskItem(name, id) {
      doGet('http://localhost:8000/tms/taskitem/delete', {
        name: name, id: id
      }).then(resp => {
        if (resp) {
          location.reload()
          //console.log(resp.data.message)
        }
      })
    },
    initAllAdminTaskItem(pageNo, pageSize) {
      this.adminShow = false
      this.isMineChecked=false
      //console.log("更改为学生列表")
      doGet('http://localhost:8000/tms/taskitem/viewAdminTaskItemByPage', {
        pageNo: pageNo, pageSize: pageSize
      }).then(resp => {
        if (resp) {
          this.allAdminTaskList = resp.data.retData;
          //console.log(resp.data)
        }
      })
      this.initAllAdminTaskItemPageInfo(pageNo)
    },
    initAllAdminTaskItemPageInfo(pageNo) {
      doGet('http://localhost:8000/tms/taskitem/calAdminTaskItem', {
        pageNo: this.pageInfo.pageNo,
      }).then(resp => {
        if (resp) {
          this.pageInfo = resp.data;
          this.pageInfo.pageNo = pageNo
        }
      })
    },
    editTaskItemContent(content) {
      // /taskitem/editContent
      if(content.length>200){this.inputError=true;return}
      this.showModal = false
      this.ifShow = false
      doGet('http://localhost:8000/tms/taskitem/editContent', {
        name: this.tempName, id: this.tempId, content: content
      }).then(resp => {
        if (resp) {
          //console.log(resp.data.message)
          location.reload()
        }

      })
    }
  },
  mounted(){
    this.initPage(1,6);
    this.updatePage(1)
    this.calculateScore()
  }
};
</script>
  
   <style scoped>
/* .viewtasks {
    width: 960px;
    height: auto;
    margin: 0 auto;
    background-color: #c5aeae84;
   } */
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.viewtasks {
  display: flex;
  margin-top: 30px;
  justify-content: center;
  align-items: center;
  /* height: 100vh; */
}
.container {
  background-color: white;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
  border-radius: 2%;
  width: 700px;
  height: 520px;
  padding: 30px;
  top: 20%;
}
.score {
  position: fixed;
  background-color: rgba(255, 255, 255, 0.2);
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
  left: 72%;
  top: 18%;
  border-radius: 10%;
  width: 100px;
  height: 100px;
  padding: 10px;
}
.scoreShow {
  padding: 20px 0;
  text-align: center;
  color: rgba(220, 20, 60, 0.897);
  font-size: larger;
}
.container table {
  left: 0;
  right: 0;
  margin: 0 auto;
  width: 90%;
  border-collapse: collapse;
}
table .line:hover {
  background-color: #f2f7feb0;
}

.container th,
td {
  text-align: center;
  padding: 14px 0px;
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

.page {
  display: flex;
  justify-content: center;
  align-items: center;
}
a {
  text-decoration: none;
  color: black;
}
a:hover {
  color: #a7cad7a9;
}
a:active {
  color: #2c66e4;
}
.page li {
  float: left;
  padding: 0 6px;
  padding-top: 20px;
}
.page .li1 {
  margin-left: 40px;
}
.page .up:hover {
  transform: translateX(-3px);
}
.page .down:hover {
  transform: translateX(3px);
}

.desc {
  cursor: pointer;
}

/* 弹窗 */
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
  width: 100%;
  height: 100%;
  z-index: 1;
}

.pop {
  position: fixed;
  background-color: rgba(255, 255, 255, 0.788);
  width: 520px;
  display: flex;
  left: 60%;
  top: 20%;
  bottom: 30%;
  z-index: 90;
  margin-left: -20px;
  box-shadow: -20px 0 20px 0 rgb(0 0 0 / 10%);
  flex-direction: column;
  padding: 30px;
  border-radius: 6px;
}
.scoreModel {
  position: fixed;
  background-color: rgba(255, 255, 255, 0.788);
  width: 300px;
  display: flex;
  left: 70%;
  top: 20%;
  bottom: 40%;
  z-index: 91;
  margin-left: -20px;
  box-shadow: -20px 0 20px 0 rgb(0 0 0 / 10%);
  flex-direction: column;
  padding: 30px;
  border-radius: 6px;
}
.main {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  white-space: break-spaces;
  word-break: break-word;
}
.main textarea {
  outline: none;
  float: left;
  margin-top: 30px;
  margin-left: 0;
  left: 0;
  width: 80%;
}
.main button {
  width: 100px;
  margin-top: 10px;
  border-radius: 4px;
}
.main button:hover,
.scoreModel button:hover {
  transform: none;
}
.main button:active {
  background-color: rgb(56, 147, 150);
}

.scoreModel button {
  width: 70px;
  margin-left: 80px;
  border-radius: 4px;
}
.scoreModel button:active {
  background-color: #2c66e4;
}
.back {
  bottom: 218px;
  left: 325px;
  display: flex;
  align-items: center;
  margin-bottom: 25px;
  text-decoration: none;
  color: #273332aa;
  font-size: 20px;
  transition: all 0.3s ease-in-out;
}
.back::after {
  content: "";
  position: absolute;
  bottom: -5px;
  left: 0;
  width: 100%;
  height: 2px;
  background-color: #040303;
  visibility: hidden;
  transform: scaleX(0);
  transition: all 0.3s ease-in-out;
}
.back:hover::after {
  visibility: visible;
  transform: scaleX(1);
}
</style>
