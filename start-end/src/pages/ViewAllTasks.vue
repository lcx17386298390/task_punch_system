<template>
  <div class="viewtasks">
    <ul>
      <li v-for="(item, index) in items" :key="index">
        <input type="checkbox" :id="index" :value="item.title" v-model="checkedItems">
        <label :for="index">{{ item.title }}</label>
        <p>{{ item.content }}</p>
      </li>
    </ul>
    <p>send_title: {{ send_title }}</p>
    <p>send_context : {{ send_content }}</p>
  </div>
</template>

<script>
// import TopBanner from "@/components/general/TopBanner";
export default {
  name: "ViewAllTasks",
  components: {
    // GiveTask ，
    // TopBanner,
  },
  data() {
    return {
      checkedItems:[],
      items: [
        { title: '1asdfasdf', content: 'Itemasdf asdf1' },
        { title: '2asdfasdfa', content: 'Item asdfas2' },
        { title: 'asdf3sdf', content: 'Itemadsf 3' },
      ],
      send_title: '',
      send_content: '',
      // submittedData: [],
    }
  },
  created() {
    this.send_title = this.$route.query.send_title || '';
    this.send_content = this.$route.query.send_content || '';
  },
  // watch: {
  //   input1(value) {
  //     this.submittedData[0] = value;
  //   },
  //   input2(value) {
  //     this.submittedData[1] = value;
  //   },
  // },
};
</script>

 <style>
/* .viewtasks {
  width: 960px;
  height: auto;
  margin: 0 auto;
  background-color: #c5aeae84;
 } */
 li {
  list-style: none;
} 
</style>