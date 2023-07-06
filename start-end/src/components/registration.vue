<template>
  <div>
    <h2>Registration</h2>
    <form @submit.prevent="register">
      <div>
        <label for="username">用户名</label>
        <input type="text" id="username" v-model="username" required>
      </div>
      <div>
        <label for="password">密码</label>
        <input type="password" id="password" v-model="password" required>
      </div>
      <div>
        <label for="email">邮箱</label>
        <input type="email" id="email" v-model="email" required>
      </div>
      <div>
        <label for="verificationCode">验证码</label>
        <input type="text" id="verificationCode" v-model="verificationCode" required>
        <button @click.prevent="sendVerificationCode" :disabled="isSendingCode">{{ isSendingCode ? 'Sending...' : 'Send Code' }}</button>
      </div>
      <div>
        <button type="submit">注册</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      email: '',
      verificationCode: '',
      isSendingCode: false
    };
  },
  methods: {
    sendVerificationCode() {
      // 发送验证码的逻辑
      // 在发送过程中，isSendingCode设置为true，表示正在发送验证码
      this.isSendingCode = true;

      // 模拟发送验证码的延迟（2秒）
      // setTimeout(() => {
      //   this.isSendingCode = false;
      //   代码省略：处理验证码发送成功或失败的逻辑
      // }, 2000);
    },
    register() {
      // 注册的逻辑
      // 注册成功后，可以跳转到登录页面或其他操作
    }
  }
};
</script>
