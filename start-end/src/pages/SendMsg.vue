<template>
  <div class="send_msg">
    <h2>SendMsg</h2>

    <div class="checkbox">
      <label v-for="person in people" :key="person.id">
      <input type="checkbox" :value="person.id" v-model="selectedPeople"> {{ person.name }}
    </label>
    </div>

    <div>
      <textarea v-model="message" class="text" cols="29" rows="8" placeholder="Edit your message..."></textarea>
    <button  @click="sendMsg" class="btn">send</button>
    </div>

    </div>
</template>

<script>
export default {
  neme:'SendMsg',
  data(){
    return{
        text:'',
        people: [
        { id: 1, name: '张三二' },
        { id: 2, name: '李四颐' },
        { id: 3, name: '王五' },
        { id: 4, name: '李四我' },
        { id: 5, name: '反倒是' },
        { id: 6, name: '附件是' },
        { id: 7, name: '十分恼' },
        { id: 8, name: '十分恼' },
        { id: 9, name: '返回' }
      ],
      selectedPeople:[],
      message: ''
    }
  },
  methods:{
    sendMsg() {
      const selectedPeople = this.selectedPeople;
      const message = this.message;

      // axios.post('/api/send_msg', { selectedPeople, message })
      //   .then(response => {
      //     console.log('消息已发送');
      //   })
      //   .catch(error => {
      //     console.error('发送消息时出错', error);
      //   });
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
.btn {
  margin-block-start: 10px;
  font-weight: 700;
  inline-size: 100%;
}
.btn:hover {
  background-color: #6abddca9;
  border:none;
}
.checkbox {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-columns: 100px 100px 100px;
  grid-template-rows: 35px 35px 35px;
  margin: 0px 0px 0px 650px;
}

.send_msg h2 {
  margin: 50px 0px 30px;
  color: #181a1ebf;
  font-size: 2em;
  font-weight:bold;

}
</style>