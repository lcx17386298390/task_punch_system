<template>
  <div class="login-container">
    <h1>Login</h1>
    <form @submit.prevent="login">
      <label for="username">Username</label>
      <input type="text" id="username" v-model="username">
      
      <label for="password">Password</label>
      <input type="password" id="password" v-model="password">
      
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script>
export default {
  name:'login',
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    login() {
      // 在这里执行登录逻辑，可以向服务器发送登录请求或进行其他处理
      console.log('登录成功！');
    }
  }
}
</script>

<style>
.login-container {
  max-width: 300px;
  margin: 0 auto;
}

h1 {
  text-align: center;
  margin-bottom: 20px;
}

label {
  display: block;
  margin-top: 10px;
}

input {
  width: 100%;
  padding: 5px;
  margin-top: 5px;
}

button {
  width: 100%;
  padding: 10px;
  margin-top: 10px;
}
</style>