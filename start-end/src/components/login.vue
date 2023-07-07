<template>
  <div class="login-container">
    <div class="text-container">
      <span
        @click="selectColor('red')"
        :class="{
          active: selectedColor === 'red',
          red: selectedColor === 'red',
          gray: selectedColor === 'blue',
        }"
        >普通登录</span
      >
      <span
        @click="selectColor('blue')"
        :class="{
          active: selectedColor === 'blue',
          blue: selectedColor === 'blue',
          gray: selectedColor === 'red',
        }"
        >管理员登录</span
      >
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
        <button type="submit">登录.</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      password: "",
      usernameError: false,
      passwordError: false,
      selectedColor: "red",
    };
  },
  methods: {
    selectColor(color) {
      this.selectedColor = color;
    },
    goToRegistration() {
      this.$router.push("/registration");
    },
    checkInputs() {
      if (this.username.trim() === "" || this.password.trim() === "") {
        this.usernameError = this.username.trim() === "";
        this.passwordError = this.password.trim() === "";
        setTimeout(() => {
          this.usernameError = false;
          this.passwordError = false;
        }, 2000);
      }
    },
  },
};
</script>

<style scoped>
.re {
  margin-top: 20px;
  margin-left: 300px;
  width: 80px;
  height: 50px;
}

span {
  display: block;
  width: 50%;
  height: 50px;
  line-height: 50px;
  text-align: center;
}

.login-container {
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

.text-container {
  display: flex;
  background-color: #fff;
  box-shadow: 15%;
  width: 400px;
  height: 50px;
  margin-left: 30px;
  margin-bottom: 30px;
}

.card-inner {
  width: 420px;
  height: 420px;
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

.gray {
  color: rgba(56, 57, 60, 0.155);
}

.red {
  background-color: rgba(0, 72, 255, 0.534);
  border-radius: 20%;
}

.blue {
  background-color: rgba(0, 72, 255, 0.534);
  border-radius: 20%;
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
  border-radius: 50px;
  background-image: linear-gradient(
    to right,
    #03a9f4,
    #f441a5,
    #ffeb3b,
    #09a8f4
  );
  background-size: 400%;
}

button:hover {
  animation: sun 8s infinite;
}

button:hover::before {
  animation: sun 8s infinite;
}

.error {
  margin-top: -24px;
  color: rgba(255, 0, 0, 0.712);
  margin-left: -150px;
}

@keyframes sun {
  100% {
    /* 背景位置 */
    background-position: -400% 0;
  }
}
</style>