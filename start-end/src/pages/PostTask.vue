
<template>
  <!-- 学生post_task页面，发布个人任务 -->
  <div class="post">
    <div class="main-container">
      <h3 class="h_container"><i class="fas fa-edit"></i>发布任务</h3>
      <hr />
      <div class="main">
        <input type="text" placeholder="准备做点啥~" v-model="taskTitle" />
        <textarea
          name=""
          id=""
          cols="30"
          rows="10"
          placeholder="描述"
          v-model="taskDescription"
        ></textarea>
        <button @click="confirmPost">发布</button>
      </div>
    </div>
    <div class="overlay" v-if="showOverlay">
      <div class="popup">
        <h3>确认提交任务？</h3>
        <div class="buttons"> 
          <button @click="cancelPost">取消</button>
          <button @click="submitPost">确认</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "PostTask",
  data() {
    return {
      taskTitle: "",
      taskDescription: "",
      showOverlay: false,
    };
  },
  methods: {
    confirmPost() {
      this.showOverlay = true;
    },
    cancelPost() {
      this.showOverlay = false;
    },
    submitPost() {
      // 发送请求给后端传递参数
      // ...
      // 刷新页面
      location.reload();
    },
  },
};
</script>
<style scoped>
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.post {
  margin-top: 5%;
  display: flex;
  justify-content: center;
  /* align-items: center; */
  height: 100vh;
}
.main-container {
  background-color: white;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
  width: 600px;
  height: 500px;
  padding: 30px;
}
.main {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.main input,
textarea {
  outline: none;
  float: left;
  margin-top: 10px;
  margin-left: 0;
  left: 0;
  width: 80%;
}
input[type="text"],
textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  outline: none;
  font-size: 14px;
  margin-bottom: 10px;
}
.main input {
  border: none;
  border-bottom: solid 1px;
}
.h_container {
  text-align: center;
  font-size: 20px;
  margin-bottom: 10px;
}
.popup {
  width: 300px;
  padding: 20px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  text-align: center;
}
.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}
button {
  padding: 10px 20px;
  background-color: rgba(40, 75, 78, 0.374);
  color: #202a2be9;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 14px;
}
button:hover {
  background-color: #51b5ce94;
  color: #fff;
  cursor: pointer;
}
.buttons {
  margin-top: 20px;
}
.buttons button {
  margin-right: 10px;
}
</style>
