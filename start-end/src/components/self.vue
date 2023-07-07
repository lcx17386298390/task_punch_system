<template>
  <div class="self">
    <h1>Welcome, {{ username }}!</h1>
    <div class="avatar">
      <img :src="avatar" alt="Avatar">
      <input type="file" @change="onFileChange">
      <button @click="uploadAvatar">Upload</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      avatar: null,
    };
  },
  methods: {
    uploadAvatar() {
      let formData = new FormData();
      formData.append('avatar', this.avatar);
      axios.post('/api/upload', formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      });
    }
  },
  created() {
    this.username = this.$route.params.username;
  }
}
</script>

<style scoped>
.self {
  width: 300px;
  margin: 0 auto;
  text-align: center;
}

.avatar {
  margin-top: 20px;
}

.avatar img {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  object-fit: cover;
}

.avatar input {
  display: none;
}

.avatar button {
  margin-top: 10px;
  padding: 10px 20px;
  background-color: #3498db;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.avatar button:hover {
  background-color: #2980b9;
}
</style>