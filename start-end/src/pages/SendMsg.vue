<template>
  <div class="send_msg">
    <br>
    <a href="/adminHome" class="back">back</a>
      <h2>SendMsg</h2>
      <!-- 多选选人 -->
    <div class="checkbox">
      <label v-for="person in people" :key="person.id">
      <input type="checkbox" :value="person.name" v-model="selectedPeople"> {{ person.name }}
    </label>
    </div>

    <!-- 编写消息 发送 -->
    <div>
      <textarea v-model="message" class="text" cols="29" rows="8" placeholder="Edit your message..."></textarea>
    <button  @click="sendMsg" class="_btn">send</button>
    </div>

    <!-- 呈现消息 -->
    <div class="content">
      <!-- 查找 -->
      &nbsp;&nbsp;&nbsp;sender:<input type="text" v-model="inputSearchSender">
      recipient:<input type="text" v-model="inputSearchRecipient">
      <button class="_btn_" @click="queryMsg">search</button>
      <hr>
      <ul>
        <li v-for="msg in sentMessages" :key="msg.id">
          <span>{{ msg.fromuser }}</span> send a message to <span>{{ msg.touser }}</span> :
          <p>{{ msg.msg }}</p>
          <!-- {{currentDate}} -->
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
        text:'',
      inputSearchSender: "",
      inputSearchRecipient:"",
        people: [
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
      // currentDate: new Date()
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

      if (this.selectedPeople.length > 0 && this.message !== '') {
        for (let person of this.selectedPeople) {
          // this.sentMessages.push({
          //   id: Date.now(),
          //   sender: 'You',
          //   recipient:this.selectedPeople[0],
          //   content: this.message
          // });
          doGet("http://localhost:8002/tms/sendmessage", {
            fromuser: 'You',
            toname: this.selectedPeople[0],
            msg:this.message,
            id:Date.now()
          }).then((resp) => {
            // eslint-disable-next-line no-empty
            if (resp) {

            }
          });
        }
        this.selectedPeople = [];
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
    }
  }
  
}
</script>

<style>
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
  margin: 10px 0 0 200px;
}
.text {
  font-size: 20px;
  background-color: #d4ddec00;
  border: 1px solid #c7c6c6;
  display: flex;
  margin: 0px 0px 10px;
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
.checkbox {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-columns: 100px 100px 100px;
  grid-template-rows: 35px 35px 35px;
  margin: 0px 0px 0px 640px;
}
.send_msg h2 {
  margin: 0 0px 40px;
  color: #181a1ebf;
  font-size: 2em;
  font-weight:bold;

}
.content {
  position: absolute;
  inline-size: 800px;
  block-size: 530px;
  border-radius: 20px;
  box-shadow: 0 0 30px #9cadb3a9;
  margin: 0 0 0 1300px;
  overflow: auto;
  overflow-wrap: break-word; 
  line-height: 1.5;
}
.content ul li {
  margin: 30px 30px 0 30px;
}
.content input {
  border-radius: 4px;
  margin-inline-end: 4px;
  padding: 6px;
  margin: 30px 30px 0 30px;
}
._btn_ {
 background-color: rgb(210, 210, 210);
  margin-block-start: 10px;
  font-weight: 700;
  border: 5px;
  border-radius: 4px;
  padding: 7px 20px;
  transform: scale(1.035);
  transition: transform 0.3s ease;
}
._btn_:hover {
  background-color: #6abddca9;
  transform: scale(1.035);
}
</style>