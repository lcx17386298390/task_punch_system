<template>
  <div class="login-container">
    <div
      class="card-inner user-login"
      :class="{ 'selected': selectedLogin === 'user' }"
      @click="selectLogin('user')"
    >
      <h2>普通登录</h2>
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
      <h2>如果你是管理员</h2>
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
  display: flex;
  justify-content: center;
  align-items: center;
}

.card-inner {
  width: 350px;
  height: 400px;
  padding: 20px;
  background-color: #f2f2f2;
  transition: background-color 0.5s;
}

.card-inner.selected {
  background-color: #007bff;
  color: #fff;
}

h2 {
  text-align: center;
  margin-bottom: 20px;
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

input {
  margin-bottom: 10px;
  padding: 10px;
}

button {
  padding: 10px;
  background-color: #333;
  color: #fff;
  border: none;
  cursor: pointer;
}
</style>
