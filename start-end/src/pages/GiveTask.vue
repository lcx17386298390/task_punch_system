
<template>
  <!-- 管理者发布任务界面 -->
  <div class="give_task">
    <button @click="addToArray" class="btn">create</button><br />
    <input
      type="text"
      class="inp"
      v-model="send_title"
      placeholder="text your title..."
    /><br />
    <input
      type="text"
      class="inp2"
      v-model="send_content"
      placeholder="text your content..."
    /><br />
    <div class="modal-container">
      <button @click="showModal" class="btn">create</button>
      <div v-if="modalVisible" class="show-modal">
        <div class="modal-content">
          <div class="modal-header">
            <span class="glyphicon glyphicon-remove" @click="hideModal">
              &times;
            </span>
          </div>
          <div class="modal-body">
            <h3>Select students</h3>
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
          <div class="modal-footer">
            <button @click="giveTasks" class="btn">Confirm</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "GiveTask",
  components: {
    // TopBanner,
  },
  data() {
    return {
      modalVisible: false,
      send_title: "",
      send_content: "",
      names: [
        { id: 1, name: "cyj" },
        { id: 2, name: "gt" },
        { id: 3, name: "xxj" },
        { id: 4, name: "dc" },
      ],
      selectedNames: [],
    };
  },
  methods: {
    addToArray() {
      this.$router.push({
        path: "/ViewAllTasks",
        query: {
          send_title: this.send_title,
          send_content: this.send_content,
        },
      });
    },
    showModal() {
      this.modalVisible = true;
      document.body.style.overflow = "hidden";
      // var moving = document.getElementsByClassName("give_task");
      // for (var i = 0; i < moving.length; i++) {
      //   var element = moving[i];
      //   element.style.transform = "translateX(0)";
      // }
    },
    hideModal() {
      this.modalVisible = false;
      document.body.style.overflow = "auto";
      // var moving = document.getElementsByClassName("give_task");
      // for (var i = 0; i < moving.length; i++) {
      //   var element = moving[i];
      //   element.style.transform = "translateX(-50%)";
      // }
    },
    toggleNames(nameId) {
      if (this.selectedNames.includes(nameId)) {
        this.selectedNames = this.selectedNames.filter((id) => id !== nameId);
      } else {
        this.selectedNames.push(nameId);
      }
    },
    giveTasks() {
      if (confirm("Confirm Publish?")) {
        console.log(this.selectedNames);
      }
    },
    handleKeyDown(event) {
      if (event.key === "Escape") {
        this.hideModal();
      }
    },
  },
  mounted() {
    document.addEventListener("keydown", this.handleKeyDown);
  },
  beforeDestroy() {
    document.removeEventListener("keydown", this.handleKeyDown);
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
  margin-bottom: 10px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
}
.inp2 {
  border-radius: 4px;
  border: 1px solid #ccc;
  width: 100%;
  height: 200px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
  text-align: left;
  vertical-align: top;
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
  /* background-clip: padding-box; */
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
.modal-content {
  background-color: #fffff999;
  max-width: 600px;
  padding: 15px 40px;
  border-radius: 6px;
  margin-left: 749px;
  border: 1px solid #929c9c96;
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
.glyphicon.glyphicon-remove {
  font-size: 37px;
  font-weight: bold;
}
.glyphicon.glyphicon-remove:hover {
  cursor: pointer;
}
</style>
