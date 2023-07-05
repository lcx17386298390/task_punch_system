<template>
  <div class="give_task">
    <button @click="addToArray" class="btn">submit</button><br />
    <input
      type="text"
      class="inp"
      v-model="send_title"
      placeholder="text your title..."
    /><br>
    <input
      type="text"
      class="inp2"
      v-model="send_content"
      placeholder="text your content..."
    /><br/>
  </div>
</template>

<script>
// import TopBanner from "@/components/general/TopBanner";
export default {
  name: "GiveTask",
  components: {
    // TopBanner,
  },
  data() {
    return {
      send_title: "",
      send_content: "",
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
  },
};
</script>

<style>
.give_task {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 500px;
  height: 400px;
  border-radius: 4px;
  border: 1px solid #ccc;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 20px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
}
li {
  list-style: none;
}
.inp {
  height: 40px;
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
</style>