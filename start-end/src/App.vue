<template>
  <div id="app">
    <TopBanner></TopBanner>
    <!-- <login></login> -->
    <registration></registration>
    <!-- <router-view></router-view> -->
  </div>
</template>

<script>
import TopBanner from './components/TopBanner.vue';
import login from './components/login.vue';
import registration from './components/registration.vue';
export default {
  name: 'App',
  components: {
    TopBanner,    
    login,
    registration,
  }
}
</script> 

<style>

</style>

