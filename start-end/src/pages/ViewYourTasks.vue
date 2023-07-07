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
    
      <div class="container">
        <span style="letter-spacing: 2px;">My Tasks</span>
        <hr>
        <table>
          <thead>
          <tr>
          <th>id</th>
          <th>标题</th>
          <th>内容</th>
          <th>增加任务点</th>
          <th>删除</th>
          </tr>
          </thead>
          <tbody>
            <tr v-for="(item, index) in items" :key="index" class="line">
            <td>{{ item.id }}</td>
            <td>
              <span v-show="!item.editState" class="desc" @click="enterEdit(item)">{{ item.title }}</span>
              <input v-show="item.editState" ref="inputDesc" type="text" :value="item.title" @blur="updateDesc(item,$event)">
            </td>
            <td>
              <span v-show="!item.editState1" class="desc" @click="enterEdit1(item)">{{ item.content }}</span>
              <input v-show="item.editState1" ref="inputDesc1" type="text" :value="item.content" @blur="updateDesc1(item,$event)">
            </td>
            <td><button class="plus" @click="showModal=true"><i class="fa fa-plus"></i></button></td>
            <td><button class="delete"><i class="fas fa-times"></i></button></td>
          </tr>
          </tbody>
          
        </table>
  
        <div class="page">
          <ul>
            <li class="up"><a href="javascript:;">首页</a></li>
            <li class="up"><a href="javascript:;">上一页</a></li>
            <li>1</li>
            <li class="down"><a href="javascript:;">下一页</a></li>
            <li class="down"><a href="javascript:;">尾页</a></li>
            <br>
            <li class="li1">共1页</li>
            <li>共6个任务</li>
          </ul>
        </div>
      </div>
  
    <div class="box">
      <div class="mask" v-if="showModal" @click="showModal=false"></div>
        <div class="pop" v-if="showModal">
            <!-- 关闭 -->
            <div class="main-container">
              <h3><i class="fas fa-edit"></i>增加任务点</h3>
              <hr>
                <div class="main">
                  <textarea name="" id="" cols="30" rows="10" placeholder="任务点内容"></textarea>
                  <button @click="showModal=false">commit</button>   
                </div>
          </div>
        </div>
      </div>
      <div class="score">
        <span>My Score:</span>
        <div class="scoreShow">100</div>
      </div>
    </div>
  </template>
  
  <script>
  // import TopBanner from "@/components/general/TopBanner";
  
  export default {
    name: "ViewYourTasks",
    components: {
      // GiveTask ，
      // TopBanner,
    },
    data() {
      return {
        showModal:false,
        checkedItems:[],
        items: [
          { id:'001',title: '1asdfasdf', content: 'Itemasdf asdf1'},
          { id:'002',title: '2asdfasdfa', content: 'Item asdfas2' },
          { id:'003',title: 'asdf3sdf', content: 'Itemadsf 3' },
          { id:'003',title: 'asdf3sdf', content: 'Itemadsf 3' },
          { id:'003',title: 'asdf3sdf', content: 'Itemadsf 3' },
          { id:'003',title: 'asdf3sdf', content: 'Itemadsf 3' }
        ],
        send_title: '',
        send_content: '',
        // submittedData: [],
      }
    },
    computed:{
  
    },
    created() {
      this.send_title = this.$route.query.send_title || '';
      this.send_content = this.$route.query.send_content || '';
    },
    // watch: {
    //   input1(value) {
    //     this.submittedData[0] = value;
    //   },
    //   input2(value) {
    //     this.submittedData[1] = value;
    //   },
    // },
  
    methods:{
      enterEdit(item){
        if(item.hasOwnProperty('editState')){
          item.editState=true
        }else{
          this.$set(item,'editState',true)
        }
        this.$nextTick(()=>{
          this.items.forEach((item,index) => {
            this.$refs.inputDesc[index].focus()
          });
        })
      },
      enterEdit1(item){
        if(item.hasOwnProperty('editState1')){
          item.editState1=true
        }else{
          this.$set(item,'editState1',true)
        }
        this.$nextTick(()=>{
          this.items.forEach((item,index) => {
            this.$refs.inputDesc1[index].focus()
          });
        })
      },
      updateDesc(item,e){
        if(e.target.value=='')return
        else{
          item.title=e.target.value
        item.editState=false
        }
      },
      updateDesc1(item,e){
        if(e.target.value=='')return
        else{
          item.content=e.target.value
        item.editState1=false
        }
      }
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
      *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
      .viewtasks{
                display: flex;
                justify-content: center;
                align-items: center;
                /* height: 100vh; */
      }
      .container{
              background-color:white;
              box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
              border-radius: 2%;
              width: 700px;
              height: 500px;
              padding: 30px;
              top: 20%;
      }
      .score{
              position: fixed;
              background-color:rgba(255, 255, 255, 0.2);
              box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
              left: 72%;
              top: 18%;
              border-radius: 10%;
              width: 100px;
              height: 100px;
              padding: 10px;
      }
      .scoreShow{
        padding: 20px 0;
        text-align: center;
        color: rgba(220, 20, 60, 0.897);
        font-size: larger;
      }
      .container table{
        left: 0;
        right: 0;
        margin: 0 auto;
        width: 90%;
        border-collapse: collapse;
      }
      table .line:hover{
        background-color:#f2f7feb0;
      }
      
      .container th,td{
      text-align: center;
      padding: 14px 0px;
      border-bottom:rgba(0, 0, 0, .2) 1px solid;
      letter-spacing: 2px;
      }
      button{
        height: 24px;
        width:24px;
        background-color:#a7cad7a9;
        border-radius: 50%;
        padding: 4px;
        border: none;
      }
      button:hover{
        background-color: rgba(0, 0, 0, .2);
        transform: translateY(-2px);
      }
      .edit:active{
          background-color: #2c66e4;
      }
      .delete:active{
        background-color: crimson;
      }
      .plus:active{
        background-color: rgb(56, 147, 150);
      }
  
      .page{
                display: flex;
                justify-content: center;
                align-items: center;
      }
      a{
        text-decoration: none;
        color: black;
      }
      a:hover{
        color: #a7cad7a9;
      }
      a:active{
        color: #2c66e4
      }
      .page li{
        float: left;
        padding: 0 6px;
        padding-top: 20px;
      }
      .page .li1{
        margin-left: 40px;
      }
      .page .up:hover{
        transform: translateX(-3px);
      }
      .page .down:hover{
        transform: translateX(3px);
      }
  
      .desc{
        cursor: pointer;
      }
  
  
  /* 弹窗 */
  .box{
    display: flex;
    flex-direction: column;
  }
    .mask {
        background:#55585d;
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
        left: 50%;
        top: 20%;
        bottom: 30%;
        z-index: 90;
        margin-left: -20px;
        box-shadow: -20px 0 20px 0 rgb(0 0 0 / 10%);
        flex-direction: column;
        padding: 30px;
        border-radius: 6px;
      }
      .scoreModel{
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
          .main{
              display: flex;
              flex-direction: column;
              align-items: center;
          }
          .main textarea{
              outline: none;
              float: left;
              margin-top: 30px;
              margin-left: 0;
              left: 0;
              width: 80%;
          }
          .main button{
            width: 100px;
            margin-top:10px;
            border-radius: 4px;
          }
          .main button:hover,
          .scoreModel button:hover{
            transform:none;
          }
          .main button:active{
            background-color:rgb(56, 147, 150);
          }
  
          .scoreModel button{
            width: 70px;
            margin-left:80px;
            border-radius: 4px;
          }
          .scoreModel button:active{
            background-color: #2c66e4;
          }
  </style>