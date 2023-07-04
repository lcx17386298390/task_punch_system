<template>
  <div id="app">
    <TopBanner></TopBanner>
    <Login></Login>

    <router-view></router-view>
  </div>
</template>

<script>
import Login from './components/login.vue';
import TopBanner from './components/TopBanner.vue';

export default {
  name: 'App',
  components: {
    Login,
    TopBanner
  }
}
</script> 

<style>

</style>

