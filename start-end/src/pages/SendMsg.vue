<template>
  <div class="send_msg">
    <div class="checkbox">
      <label v-for="person in people" :key="person.id">
      <input type="checkbox" :value="person.id" v-model="selectedPeople"> {{ person.name }}
    </label>
    </div>
    <textarea v-model="message" class="text" cols="50" rows="10"></textarea>
    <button  @click="sendMsg" class="btn">send</button>
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
        { id: 4, name: '李四' },
        { id: 5, name: '反倒是' },
        { id: 6, name: '附件是' },
        { id: 7, name: '十分恼' },
        { id: 8, name: '返回' }
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
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
}
.text {
    background-color: #d4ddec00;
  border: 1px solid #c7c6c6;
  padding: 5px;
}
.btn {
    margin-block-start: 10px;
}
.checkbox{
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 10px;
  margin-block-end: 10px;
}
</style>