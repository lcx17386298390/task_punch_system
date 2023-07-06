
<template>
  <!-- 管理者发布任务界面 -->
  <div class="give_task">
    <p v-if="titleError" class="error">Title cannot be empty</p>
    <label id="l_a">title</label>
    <input
      type="text"
      class="inp"
      v-model="send_title"
      placeholder="text your title..."
    /><br />
    <p v-if="contentError" class="error">Content cannot be empty</p>
    <label id="l_a">content</label>
    <textarea
      class="inp2"
      rows="10"
      v-model="send_content"
      placeholder="text your content..."
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
        <button class="close" @click="showModal = false">x</button>
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
  position: absolute;
  top: 50%;
  left: 50%;
  width: 501px;
  height: 401px;
  border-radius: 4px;
  border: 1px solid #ccc;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 20px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
  transform: translate(-50%, -50%);
  /* transition: transform 0.5s ease-in-out; */
}
li {
  list-style: none;
}
.inp {
  height: 35px;
  width: 100%;
  border: 1px solid #ccc;
  border-radius: 4px;
  margin-bottom: 15px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
}
.inp2 {
  border-radius: 4px;
  border: 1px solid #ccc;
  width: 100%;
  height: 212px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
  text-align: left;
  resize: none;
  font-size: 16px;
  font-family: Arial, sans-serif;
  word-wrap: break-word;
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
}
.btn:hover {
  background-color: rgba(40, 75, 78, 0.374);
  color: #202a2be9;
  cursor: pointer;
}
.modal-container {
  text-align: center;
  opacity: 0.89;
  background-clip: padding-box;
}
.modal {
  position: fixed;
  top: 50%;
  left: 0;
  width: auto;
  height: auto;
  right: 20px;
  background-color: rgba(0, 0, 0, 0.577);
  display: flex;
  justify-content: center;
  align-items: center;
}
.show-modal {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  /* background-color: rgba(0, 0, 0, 0.5); */
  display: flex;
  align-items: center;
  justify-content: center;
}
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
  width: 430px;
  height: 300px;
  margin-right: -20px;
  background: rgba(186, 190, 191, 0.877);
  padding: 40px;
  border-radius: 5px;
  position: fixed;
  align-content: center;
}
.close {
  position: absolute;
  top: 10px;
  right: 10px;
  background: none;
  border: none;
  font-size: 20px;
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
h3 {
  text-align: center;
  margin-top: 10px;
  margin-bottom: 10px;
  font-size: 20px;
  font-weight: bold;
}
.button-container {
  text-align: center;
  margin-top: 10px;
}
.button-container button {
  margin: 0 10px;
}
.error {
  color: rgba(255, 0, 0, 0.712);
  margin-top: -10px;
  margin-left: -220px;
  text-align: left;
}
#l_a {
  font-size: 19px;
  margin-top: -10px;
  margin-left: -450px;
  text-align: left;
  font-weight: bold;
  color: #181a1ebf;
}
/* .glyphicon.glyphicon-remove {
  font-size: 37px;
  font-weight: bold;
}
.glyphicon.glyphicon-remove:hover {
  cursor: pointer;
} */
</style>
