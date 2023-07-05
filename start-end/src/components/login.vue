<template>
  <div class="login-container">
    <div
      class="card-inner user-login"
      :class="{ 'selected': selectedLogin === 'user' }"
      @click="selectLogin('user')"
    >
      <h1>普通登录</h1>
      <form>
        <input type="text" placeholder="用户名" />
        <input type="password" placeholder="密码" />
        <button type="submit">登录</button>
      </form>
    </div>
    <div
      class="card-inner admin-login"
      :class="{ 'selected': selectedLogin === 'admin' }"
      @click="selectLogin('admin')"
    >
      <h1>管理员</h1>
      <form>
        <input type="text" placeholder="管理员用户名" />
        <input type="password" placeholder="管理员密码" />
        <button type="submit">登录</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name:'login',
  data() {
    return {
      selectedLogin: "user"
    };
  },
  methods: {
    selectLogin(loginType) {
      this.selectedLogin = loginType;
    }
  }
};
</script>

<style>
.login-container {
  margin-top: 3%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family:serif;
  font-weight: 900;
}

.card-inner {
  width: 370px;
  height: 420px;
  padding: 20px;
  background-color: rgba(119, 120, 122, 0.129);
  transition: background-color 0.5s;
  border-radius: 15%;
  margin-left: 10px;
}

.card-inner.selected {
  background-color: rgba(0, 72, 255, 0.534);
  color: #fff;
}

h1{
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
  margin-top: 50px;
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
}
</style>
