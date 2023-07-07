
<template>
  <div class="_container">
    <div class="send_msg">
      <h2>SendMsg</h2>
      <a href="/adminHome" class="_back">back</a>
      <div class="checkbox">
        <label v-for="person in people" :key="person.id">
          <input type="checkbox" :value="person.id" v-model="selectedPeople" />
          {{ person.name }}
        </label>
      </div>
      <div>
        <textarea
          v-model="message"
          class="text"
          cols="29"
          rows="8"
          placeholder="Edit your message..."
        ></textarea>
        <button @click="sendMsg" class="btn">send</button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  neme: "SendMsg",
  data() {
    return {
      text: "",
      people: [
        { id: 1, name: "张三二" },
        { id: 2, name: "李四颐" },
        { id: 3, name: "王五" },
        { id: 4, name: "李四我" },
        { id: 5, name: "反倒是" },
        { id: 6, name: "附件是" },
        { id: 7, name: "十分恼" },
        { id: 8, name: "十分" },
        { id: 9, name: "返回" },
      ],
      selectedPeople: [],
      message: "",
    };
  },
  methods: {
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
    },
  },
};
</script>
<style scope>
._container {
  margin-top: 2%;
  width: auto;
  height: auto;
  display: flex;
  background-color: inherit;
  justify-content: center;
  align-items: center;
}
.send_msg {
  position: relative;
  inline-size: 550px;
  block-size: 620px;
  border-radius: 20px;
  box-shadow: 0 0 30px #9cadb3a9;
  display: flex;
  place-items: center;
  align-items: center;
  flex-direction: column;
}
.text {
  font-size: 20px;
  border: 1px solid #ccc;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
  background-color: #d4ddec00;
  display: flex;
  margin: 0px 0px 10px;
  padding: 10px;
  transition: transform 0.3s ease;
}
.text:hover {
  transform: scale(1.035);
}
.btn {
  margin-block-start: 10px;
  font-weight: 700;
  inline-size: 100%;
}
.btn:hover {
  background-color: #6abddca9;
  border: none;
}
.checkbox {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-columns: 100px 100px 100px;
  grid-template-rows: 35px 35px 35px;
  margin: 0px 0px 0px 640px;
}
.send_msg h2 {
  margin: 50px 0px 26px;
  color: #181a1ebf;
  font-size: 2em;
  font-weight: bold;
}
._back {
  display: flex;
  align-items: top;
  margin-bottom: 35px;
  text-decoration: none;
  color: #4f6e6c;
  position: relative;
  font-size: 25px;
  transition: all 0.3s ease-in-out;
}
._back::after {
  content: "";
  position: absolute;
  bottom: -5px;
  left: 0;
  width: 100%;
  height: 2px;
  background-color: #000000;
  visibility: hidden;
  transform: scaleX(0);
  transition: all 0.3s ease-in-out;
}
._back:hover::after {
  visibility: visible;
  transform: scaleX(1.025);
}
</style>
