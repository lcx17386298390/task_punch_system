<template>
  <div class="viewtasks">
   <!-- <div>
    <ul v-for="(item, index) in data" :key="index">
      <li>{{ item.title }}</li>
      <li>{{ item.content }}</li>
      <li>{{ item.names.join(', ') }}</li>
      <button @click="edit(index)">Edit</button>
      <button @click="remove(index)">Remove</button>
    </ul>
  </div> -->
    

    <div class="container">
      <table>
        <thead>
        <tr>
        <th>id</th>
        <th>标题</th>
        <th>内容</th>
        <th>增加任务点</th>
        <th>删除</th>
        <th>修改</th>
        </tr>
        </thead>
        <tbody>
          <tr v-for="(item, index) in items" :key="index" class="line">
          <td>{{ item.id }}</td>
          <td>
            <span v-show="!item.editState" class="desc" @click="enterEdit(item)">{{ item.title }}</span>
            <input v-show="item.editState" ref="inputDesc" type="text" :value="item.title" @blur="updateDesc(item,$event)">
          </td>
          <td>
            <span >{{ item.content }}</span>
            <input type="text" :value="item.content">
          </td>
          <td><button class="plus"><i class="fa fa-plus"></i></button></td>
          <td><button class="delete"><i class="fas fa-times"></i></button></td>
          <td><button class="edit"><i class="fas fa-pencil-alt fa-fw"></i></button></td>
        </tr>
        </tbody>
        
      </table>

      <div class="page">
        <ul>
          <li class="up"><a href="javascript:;">首页</a></li>
          <li class="up"><a href="javascript:;">上一页</a></li>
          <li>1</li>
          <li class="down"><a href="javascript:;">下一页</a></li>
          <li class="down"><a href="javascript:;">尾页</a></li>
        </ul>
      </div>
    </div>
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
        { id:'001',title: '1asdfasdf', content: 'Itemasdf asdf1'},
        { id:'002',title: '2asdfasdfa', content: 'Item asdfas2' },
        { id:'003',title: 'asdf3sdf', content: 'Itemadsf 3' },
        { id:'003',title: 'asdf3sdf', content: 'Itemadsf 3' },
        { id:'003',title: 'asdf3sdf', content: 'Itemadsf 3' },
        { id:'003',title: 'asdf3sdf', content: 'Itemadsf 3' }
      ],
      send_title: '',
      send_content: '',
      // submittedData: [],
    }
  },
  computed:{

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

  methods:{
    enterEdit(item){
      if(item.hasOwnProperty('editState')){
        item.editState=true
      }else{
        this.$set(item,'editState',true)
      }
      this.$nextTick(()=>{
        this.items.forEach((item,index) => {
          this.$refs.inputDesc[index].focus()
        });
      })
    },
    updateDesc(item,e){
      item.title=e.target.value
      item.editState=false
    }
  }
};
</script>

 <style scoped>
/* .viewtasks {
  width: 960px;
  height: auto;
  margin: 0 auto;
  background-color: #c5aeae84;
 } */
    *{
          padding: 0;
          margin: 0;
          box-sizing: border-box;
      }
    .viewtasks{
              display: flex;
              justify-content: center;
              align-items: center;
              /* height: 100vh; */
    }
    .container{
            background-color:white;
            box-shadow: 0 5px 10px rgba(0, 0, 0, .2);
            border-radius: 2%;
            width: 700px;
            height: 500px;
            padding: 30px;
    }
    .container table{
      left: 0;
      right: 0;
      margin: 0 auto;
      width: 90%;
      border-collapse: collapse;
    }
    table .line:hover{
      background-color:#f2f7feb0;
    }
    
    .container th,td{
    text-align: center;
    padding: 14px 0px;
    border-bottom:rgba(0, 0, 0, .2) 1px solid;
    letter-spacing: 2px;
    }
    button{
      height: 24px;
      width:24px;
      background-color:#a7cad7a9;
      border-radius: 50%;
      padding: 4px;
    }
    button:hover{
      background-color: rgba(0, 0, 0, .2);
      transform: translateY(-2px);
    }
    .edit:active{
        background-color: #2c66e4;
    }
    .delete:active{
      background-color: crimson;
    }
    .plus:active{
      background-color: rgb(56, 147, 150);
    }

    .page{
              display: flex;
              justify-content: center;
              align-items: center;
    }
    a{
      text-decoration: none;
      color: black;
    }
    a:hover{
      color: #a7cad7a9;
    }
    a:active{
      color: #2c66e4
    }
    .page li{
      float: left;
      padding: 0 6px;
      padding-top: 20px;
    }
    .page .up:hover{
      transform: translateX(-3px);
    }
    .page .down:hover{
      transform: translateX(3px);
    }

    .desc{
      cursor: pointer;
    }
</style>