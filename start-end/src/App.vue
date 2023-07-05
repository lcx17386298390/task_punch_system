<template>
  <div id="app">
    <TopBanner></TopBanner>
    <!-- <Login></Login> -->
    <Home></Home>
    <router-view></router-view>
  </div>
</template>

<script>
import Login from './components/login.vue';
import TopBanner from './components/TopBanner.vue';
import Home from './components/Home.vue';
export default {
  name: 'App',
  components: {
    Login,
    TopBanner,
    Home
  }
}
</script> 

<style>

</style>

