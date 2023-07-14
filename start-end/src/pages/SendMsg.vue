<template>
  <div class="send_msg">
    <br>
    <a href="/adminHome" class="back">back</a>
      <h2>SendMsg</h2>
      <!-- 搜索选人 -->
    <div class="selected">
  <input type="text" v-model="searchText" @input="filterData" class="search-input" placeholder="请输入姓名...">
  <ul v-show="showDropdown" class="dropdown">
    <li v-for="item in filteredData" :key="item.id" @click="selectItem(item)">&nbsp;&nbsp;{{ item.name }}</li>
  </ul>
</div>

    <!-- 编写消息 发送 -->
    <div>
      <textarea v-model="message" class="text" cols="29" rows="8" placeholder="请编辑信息..."></textarea>
    <button  @click="sendMsg" class="_btn">发送</button>
    </div>

    <!-- 呈现消息 -->
    <div class="content1">
      <h3>发送信息</h3>
      <hr>
      <ul>
        <li v-for="msg in sentMessages" :key="msg.id">
          <span>{{ msg.fromuser }}</span> 发了一个消息给 <span>{{ msg.touser }}</span> :
          <p>{{ msg.msg }}</p>
          {{currentDate}}
          <hr>
        </li>
      </ul>
      
    </div>
    <div class="content2">
      <h3>接收信息</h3>
      <hr>
      <ul>
        <li v-for="msg in sentMessages" :key="msg.id">
          <span>{{ msg.touser }}</span> 发了一个消息给 <span>{{ msg.fromuser }}</span> :
          <p>{{ msg.msg }}</p>
          {{currentDate}}
          <hr>
        </li>
      </ul>
      
    </div>
    </div>
</template>

<script>
import {doGet} from "@/api/httpRequest";

export default {
  name:'SendMsg',
  data(){
    return{
      searchText: '',
      inputSearchSender: "",
      inputSearchRecipient:"",
        data: [
        { id: 1, name: 'chh' },
        { id: 2, name: 'dc' },
        { id: 3, name: 'yq' },
        { id: 4, name: 'cyj' },
        { id: 5, name: 'gt' },
        { id: 6, name: 'xxj' },
        { id: 7, name: 'wqw' },
        { id: 8, name: 'wy' },
        { id: 9, name: 'lcx' }
      ],
      selectedPeople:[],
      sentMessages: [],
      message: '',
      showDropdown: false,
      filteredData: [],
      currentDate: new Date()
    }
  },
  
  methods:{
    sendMsg() {
      
      // axios.post('/api/send_msg', { selectedPeople, message })
      //   .then(response => {
      //     console.log('消息已发送');
      //   })
      //   .catch(error => {
      //     console.error('发送消息时出错', error);
      //   });

      if (this.filteredData.length > 0 && this.message !== '') {
        for (let item of this.filteredData) {
          // this.sentMessages.push({
          //   id: Date.now(),
          //   sender: 'You',
          //   recipient:this.selectedPeople[0],
          //   content: this.message
          // });
          if (item.isSelected) {
          doGet("http://localh ost:8002/tms/sendmessage", {
            fromuser: '你',
            toname: item.name,
            msg:this.message,
            id:Date.now()
          }).then((resp) => {
            // eslint-disable-next-line no-empty
            if (resp) {

            }
          });
          }
        }
        this.searchText = '';
        this.message = '';
      }
      
  },
    queryMsg(){
      doGet("http://localhost:8002/tms/querymsg", {
        fromuser: this.inputSearchSender,
        touser: this.inputSearchRecipient,
      }).then((resp) => {
        if (resp) {
          this.sentMessages=resp.data;
          //location.reload()
        }
      });
    },
    filterData() {
      this.filteredData = this.data.filter(item => item.name.includes(this.searchText));
      this.showDropdown = this.filteredData.length > 0;
    },
    selectItem(item) {
      this.searchText = item.name;
      this.showDropdown = false;
      for (let dataItem of this.data) {
        dataItem.isSelected = (dataItem.name === item.name);
  }
    },
  }
  
}
</script>

<style scoped>
.send_msg {
  position:relative;
  inline-size: 400px;
  block-size: 530px;
  border-radius: 20px;
  box-shadow: 0 0 30px #9cadb3a9;
  display: flex;
  place-items: center;
  align-items: center;
  flex-direction: column;
  margin: 10px 0 0 150px;
}
.text {
  font-size: 20px;
  background-color: #d4ddec00;
  border: 1px solid #c7c6c6;
  display: flex;
  margin: 40px 0px 10px;
  padding:10px;
}
._btn {
  background-color: rgb(210, 210, 210);
  margin-block-start: 10px;
  font-weight: 700;
  inline-size: 100%;
  border: 5px;
  border-radius: 4px;
  padding: 10px 20px;
  transform: scale(1.035);
  transition: transform 0.3s ease;
}
._btn:hover {
  background-color: #6abddca9;
  transform: scale(1.035);
}

.send_msg h2 {
  margin: 10px 0px 20px;
  color: #181a1ebf;
  font-size: 40px;
  font-weight:bold;

}
.content1 {
  position: absolute;
  inline-size: 400px;
  block-size: 530px;
  border-radius: 20px;
  box-shadow: 0 0 30px #9cadb3a9;
  margin: 0 0 0 860px;
  overflow: auto;
  overflow-wrap: break-word; 
  line-height: 1.5;
  z-index: 2;
}
.content1 h3 {
  margin: 20px 0 0 20px;
  color: #181a1ebf;
  font-size: 20px;
  font-weight:bold;
}
.content2 {
  position: absolute;
  inline-size: 400px;
  block-size: 530px;
  border-radius: 20px;
  box-shadow: 0 0 30px #9cadb3a9;
  margin: 0 0 0 1720px;
  overflow: auto;
  overflow-wrap: break-word; 
  line-height: 1.5;
  z-index: 2;
}
.content2 h3 {
  margin: 20px 0 0 20px;
  color: #181a1ebf;
  font-size: 20px;
  font-weight:bold;
}
.content ul li {
  margin: 30px 30px 0 30px;
}
.content input {
  background-color: rgb(235, 233, 233);
  border-radius: 4px;
  margin-inline-end: 4px;
  padding: 6px;
  margin: 30px 30px 0 30px;
}

.search-input {
  background-color: rgb(235, 233, 233);
  border-radius: 4px;
  margin-inline-end: 4px;
  padding: 6px;
  margin: 20px 0 0 0 ;
   
}

.dropdown {
  position: absolute;
  z-index: 1;
  border-radius: 4px;
  border: 2px solid #737373;
  max-block-size: 200px;
  inline-size: 174px;
  overflow-y: auto;
  background-color: #f3f3f3;
}
</style>