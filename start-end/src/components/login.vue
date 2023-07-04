<template>
  <div class="login-container">
    <div class="card-wrapper">
      <div class="card-inner user-login" :class="{ 'selected': selectedLogin === 'user' }" @mouseover="selectUserLogin">
        <h2>普通登录</h2>
        <!-- 普通登录表单 -->
        <form>
          <!-- 添加其他登录字段 -->
          <input type="text" placeholder="用户名" />
          <input type="password" placeholder="密码" />
          <button type="submit">登录</button>
        </form>
      </div>
      <div class="card-inner admin-login" :class="{ 'selected': selectedLogin === 'admin' }" @mouseover="selectAdminLogin">
        <h2>管理员登录</h2>
        <!-- 管理员登录表单 -->
        <form>
          <!-- 添加其他登录字段 -->
          <input type="text" placeholder="管理员用户名" />
          <input type="password" placeholder="管理员密码" />
          <button type="submit">登录</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedLogin: "", // 默认未选择任何登录方式
    };
  },
  methods: {
    selectUserLogin() {
      this.selectedLogin = "user";
    },
    selectAdminLogin() {
      this.selectedLogin = "admin";
    },
  },
};
</script>

<style>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.card-wrapper {
  position: relative;
  perspective: 1000px;
  cursor: pointer;
}

.card-inner {
  width: 300px;
  height: 400px;
  position: absolute;
  padding: 20px;
  background-color: #f2f2f2;
  transition: transform 0.3s, box-shadow 0.3s;
  backface-visibility: hidden;
}

.admin-login {
  background-color: #ddd;
}

.card-wrapper .selected {
  transform: translate(0, -50%) scale(1.1);
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
  z-index: 1;
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
