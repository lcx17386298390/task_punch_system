<template>
    <div class="login-container">
      <div class="text-container">
        <span>欢迎来到注册页面</span>
    </div>
      <div class="card-inner">
      <form>
        <input type="text" placeholder="用户名" />
        <input type="password" placeholder="密码" />
        <input type="Email" placeholder="注册邮箱">
        <div style="display: flex;">
          <input type="identifying code" placeholder="验证码">
          <button class="f">发送验证码</button>
        </div>
        <button type="submit">注册</button>
      </form>
  </div>
    </div>
</template>

<script>
export default {
  data() {
    return {
      selectedColor: "red",
    };
  },
  
};
</script>

<style scoped>
.f{
  margin-left: 20px;
  width: 150px;
  height: 40px;
}
span{
  display: block;
  width: 50%;
  height: 50px;
  line-height: 50px;
  text-align: center;
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

.text-container {
  display: flex;
  background-color: #fff;
  box-shadow: 15%;
  width: 400px;
  height: 50px;
  margin-left: 30px;
  margin-bottom: 30px;
}

.card-inner{
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
</style>