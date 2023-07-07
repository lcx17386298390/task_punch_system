<template>
    <div class="login-container">
      <div >
        <span>欢迎来到注册页面</span>
    </div>
      <div class="card-inner">
      <a href="/login" class="back_">back</a>
      <form>
        <input v-model="name" type="text" placeholder="用户名" />
        <input v-model="password" type="password" placeholder="密码" />
        <input v-model="email" type="email" placeholder="注册邮箱">
        <div   style="display: flex;">
          <input  v-model="code" placeholder="验证码">
          <button @click="sendRequest" class="f">发送验证码</button>
        </div>
        <p v-if="showError" class="error">错误:输入必须为6位整数</p>
        <button @click="checkInput,compareCode" >注册</button>
      </form>
  </div>
    </div>
</template>

<script>
import axios from 'axios'

export default {
  name:'registration',
  data() {
    return {
      selectedColor: "red",
      name:'',
      password:'',
      email:'',
      code: '',
      showError: false
    };
  },
  methods:{
    checkInput() {
      // 检测验证码形式
      const value = this.code;
      if (!/^\d{6}$/.test(value)) {
        this.showError = true;
        setTimeout(() => {
          this.showError = false;
        }, 1000);
      } else {
        this.showError = false;
      }
    },
   sendRequest(){
    axios.get('/api/testEmail').then(response=>{
      this.code=response.data.code;
    })
    .catch(error=>{
      console.error(error);
    })
   },
   compareCode(){
    if(this.code===this.$data.code){
      axios.post('/api/register',{
        name:this.name,
        password:this.password,
        email:this.email
      })
      .then(response=>{
        console.log(response.data);
      })
      .catch(error=>{
        console.error(error);
      })
    }
   }
  }
};
</script>

<style scoped>
.error {
  margin-top: -24px;
  color: rgba(255, 0, 0, 0.712);
  margin-left: -150px;
}

.f{
  margin-left: 20px;
  width: 150px;
  height: 40px;
}
span{
  display: block;
  width: 400px;
  height: 50px;
  line-height: 50px;
  text-align: center;
  background-color: rgba(16, 34, 229, 0.603);
  margin-bottom: 20px;
  position: fixed;
  top: -10%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.login-container{
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  margin-top: 3%;
  justify-content: center;
  align-items: center;
  margin-top: 3%;
  font-family: serif;
  font-weight: 900;
}



.card-inner{
  width: 420px;
  height: 440px;
  padding: 20px;
  background-color: rgba(119, 120, 122, 0.129);
  transition: background-color 0.5s;
  border-radius: 15%;
  margin-left: 20px;
  box-shadow: 15px 20px 10px rgba(0, 0, 0, 0.182);
}
.text-container span {
  margin-right: 10px;
  cursor: pointer;
  background-color: d4ddec63;
  transition: transform 0.5s;
}

.text-container span:hover {
  transform: scale(1.2);
}



h1 {
  margin-top: 50px;
  text-align: center;
  margin-bottom: 20px;
  font-size: 40px;
  letter-spacing: 0.5em;
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 26px;
}

input {
  width: 80%;
  height: 30px;
  margin-bottom: 10px;
  padding: 10px;
  margin-bottom: 30px;
  background-color: rgba(251, 251, 251, 0.573);
  border: none;
}

button {
  margin-top: 10px;
  padding: 10px;
  background-color: rgb(70, 73, 79);
  color: #fff;
  border: none;
  cursor: pointer;
  width: 50%;
  border-radius: 50px;
  background-image: linear-gradient(to right, #03a9f4, #f441a5, #ffeb3b, #09a8f4);
  background-size: 400%;
}

button:hover {
  animation: sun 8s infinite;
}

button:hover::before {
  animation: sun 8s infinite;
}

@keyframes sun {
  100% {
    /* 背景位置 */
    background-position: -400% 0;
  }
}
.back_ {
  padding-top: 2%;
  display: flex;
  margin-left: 185px;
  text-decoration: none;
  color: #4f6e6c;
  position: relative;
  font-size: 20px;
  transition: all 0.3s ease-in-out;
}
.back_::after {
  content: "";
  position: absolute;
  bottom: -5px;
  left: 0;
  width: 45px;
  height: 2px;
  background-color: #000000;
  visibility: hidden;
  transform: scaleX(0);
  transition: all 0.3s ease-in-out;
}
.back_:hover::after {
  visibility: visible;
  transform: scaleX(1);
}
</style>