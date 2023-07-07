<template>
  <!-- 管理者发布任务界面 -->
  <div class="give_task">
    <a href="/adminHome" class="back">back</a>
    <p v-if="titleError" class="error">Title cannot be empty</p>
    <p class="t">Title</p>
    <input
      type="text"
      class="inp"
      v-model="send_title"
      placeholder="text your task-title..."
    /><br />
    <p v-if="contentError" class="error">Content cannot be empty</p>
    <label>Content</label>
    <textarea
      class="inp2"
      rows="10"
      v-model="send_content"
      placeholder="text your task-content..."
    ></textarea>
    <br />
    <button @click="checkInputs" class="btn">create</button>
    <div
      class="modal"
      v-if="showModal"
      @click.self="showModal = false"
      @keydown.ESC="closeModal"
    >
      <div class="modal-content">
        <div slot="header">
          <h3>Select students</h3>
        </div>
        <div slot="body">
          <ul>
            <li
              v-for="name in names"
              :key="name.id"
              @click="toggleNames(name.id)"
            >
              <input
                type="checkbox"
                :checked="selectedNames.includes(name.id)"
              />
              {{ name.name }}
            </li>
          </ul>
        </div>
        <div slot="footer" class="button-container">
          <button @click="confirmSend">Confirm</button>
          <button @click="cancelSend">Cancel</button>
        </div>
      </div>
    </div>
  </div>
  <!-- <div class="modal-container">
      <div v-for="name in names" :key="name">
        <input
          type="checkbox"
          :id="name"
          :value="name"
          v-model="selectedNames"
        />
        <label :for="name">{{ name }}</label>
      </div>
    </div> -->
  <!-- <ViewAllTasks :data="data"></ViewAllTasks> -->
</template>

<script>
import axios from "axios";
// import ViewAllTasks from './ViewAllTasks.vue'
export default {
  name: "GiveTask",
  components: {
    // ViewAllTasks,
  },
  data() {
    return {
      // modalVisible: false,
      send_title: "",
      send_content: "",
      titleError: false,
      contentError: false,
      showModal: false,
      names: [],
      selectedNames: [],
      // date:[],
    };
  },
  methods: {
    // 发送请求给后端接受
    // async create() {
    //   this.titleError = this.send_title === "";
    //   this.contentError = this.send_content === "";
    //   if (!this.titleError && !this.contentError) {
    //     const response = await axios.get("/task/create");
    //     this.names = response.data;
    //     this.showModal = true;
    //   }
    // },
    // async confirmSend() {
    //   const response = await axios.post("/api/data", {
    //     send_title: this.send_title,
    //     send_content: this.send_content,
    //     names: this.selectedNames,
    //   });
    //   this.data = response.data;
    //   this.showModal = false;
    // },
    checkInputs() {
      if (this.send_title.trim() === "" || this.send_content.trim() === "") {
        this.titleError = this.send_title.trim() === "";
        this.contentError = this.send_content.trim() === "";
        setTimeout(() => {
          this.titleError = false;
          this.contentError = false;
        }, 2000);
      } else {
        this.showModal = true;
      }
    },
    async confirmSend() {
      this.titleError = this.send_title === "";
      this.contentError = this.send_content === "";
      if (!this.titleError && !this.contentError) {
        const response = await axios.get("/task/create");
        this.names = response.data;
        this.showModal = true;
      }
    },
    cancelSend() {
      this.showModal = false;
    },
    // showModal() {
    //   this.modalVisible = true;
    //   document.body.style.overflow = "hidden";
    //   // var moving = document.getElementsByClassName("give_task");
    //   // for (var i = 0; i < moving.length; i++) {
    //   //   var element = moving[i];
    //   //   element.style.transform = "translateX(0)";
    //   // }
    // },
    // hideModal() {
    //   this.modalVisible = false;
    //   document.body.style.overflow = "auto";
    //   // var moving = document.getElementsByClassName("give_task");
    //   // for (var i = 0; i < moving.length; i++) {
    //   //   var element = moving[i];
    //   //   element.style.transform = "translateX(-50%)";
    //   // }
    // },
    toggleNames(nameId) {
      if (this.selectedNames.includes(nameId)) {
        this.selectedNames = this.selectedNames.filter((id) => id !== nameId);
      } else {
        this.selectedNames.push(nameId);
      }
    },
    // giveTasks() {
    //   if (confirm("Confirm Publish?")) {
    //     console.log(this.selectedNames);
    //   }
    // },
    handleKeyDown(event) {
      if (event.key === "Escape") {
        this.showModal = false;
      }
    },
  },
  mounted() {
    window.addEventListener("keydown", this.handleKeyDown);
  },
  beforeDestroy() {
    window.removeEventListener("keydown", this.handleKeyDown);
  },
};
</script>

<style>
.give_task {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: 55px 599px;
  box-shadow: 2px 2px 25px rgba(89, 114, 114, 0.5);
  padding: 66px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: white;
}
ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin-bottom: 10px;
  cursor: pointer;
}
.inp {
  height: 35px;
  width: 400px;
  border: 1px solid #ccc;
  border-radius: 4px;
  margin-bottom: 15px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
  transition: transform 0.3s ease;
}
.inp2 {
  border-radius: 4px;
  border: 1px solid #ccc;
  width: 400px;
  height: 212px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
  text-align: left;
  resize: none;
  font-size: 16px;
  font-family: Arial, sans-serif;
  word-wrap: break-word;
  transition: transform 0.3s ease;
}
.inp:hover {
  transform: scale(1.035);
}
.inp2:hover {
  transform: scale(1.035);
}
.input-container input,
.input-container textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}
.container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  background-color: white;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.title {
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  margin-bottom: 20px;
}

.input-container {
  margin-bottom: 20px;
}

.input-container label {
  display: block;
  font-weight: bold;
  margin-bottom: 5px;
}

label {
  font-size: 21px;
  margin-top: -15px;
  margin-left: -320px;
  text-align: left;
  font-weight: bold;
  color: #181a1ebf;
  font-weight: bold;
  margin-bottom: 10px;
}

.t {
  font-size: 21px;
  margin-top: -15px;
  margin-left: -350px;
  text-align: left;
  font-weight: bold;
  color: #181a1ebf;
  font-weight: bold;
  margin-bottom: 10px;
}
.btn {
  margin-top: 10px;
  background-color: #9eb3b865;
  border: none;
  border-radius: 4px;
  padding: 10px 20px;
  color: #333;
  font-size: 16px;
  cursor: pointer;
  transition: transform 0.3s ease;
}
.btn:hover {
  background-color: #51b5ce94;
  color: #fff;
  cursor: pointer;
  transform: scale(1.1);
}
.modal-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-top: 20px;
}

.modal-container div {
  display: flex;
  align-items: center;
  margin-right: 20px;
}

.modal-container label {
  margin-left: 5px;
}

.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
}
body {
  background-color: #e4e0e067;
  font-family: Arial, sans-serif;
}
/* .show-modal {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
} */
/*侧边显示 
.modal-content {
  background-color: #fffff999;
  max-width: 600px;
  padding: 15px 40px;
  border-radius: 6px;
  margin-left: 749px;
  border: 1px solid #929c9c96;
} */

.modal-content {
  background-color: white;
  padding: 20px;
  border-radius: 5px;
}
.modal-content h3 {
  margin: 0;
  text-align: center;
  margin-top: 10px;
  margin-bottom: 10px;
  font-size: 20px;
  font-weight: bold;
}
.modal-content ul {
  list-style-type: none;
  padding: 0;
}

.modal-content li {
  margin-bottom: 10px;
  cursor: pointer;
}

.modal-header {
  display: flex;
  justify-content: flex-end;
}
.modal-body {
  margin-bottom: 200px;
}
.modal-footer {
  display: flex;
  justify-content: flex-end;
}
.button-container {
  display: flex;
  justify-content: flex-end;
  margin-top: 20px;
  border: none;
  border-radius: 4px;
  padding: 10px 20px;
  cursor: pointer;
}

.button-container button {
  padding: 10px 20px;
  margin-left: 20px;
  margin-right: 20px;
  background-color: #99a0a9e1;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.btn:hover {
  background-color: #51b5ce94;
  color: #fff;
  cursor: pointer;
}
.button-container button:hover {
  border: none;

  background-color: #51b5ce94;
  color: #fff;
  cursor: pointer;
}
.error {
  color: rgba(255, 0, 0, 0.712);
  margin-top: -10px;
  text-align: left;
}
.back {
  display: flex;
  align-items: top;
  margin-bottom: 25px;
  text-decoration: none;
  color: #4f6e6c;
  position: relative;
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
  background-color: #000000;
  visibility: hidden;
  transform: scaleX(0);
  transition: all 0.3s ease-in-out;
}
.back:hover::after {
  visibility: visible;
  transform: scaleX(1);
}
/* .glyphicon.glyphicon-remove {
  font-size: 37px;
  font-weight: bold;
}
.glyphicon.glyphicon-remove:hover {
  cursor: pointer;
} */
</style>
