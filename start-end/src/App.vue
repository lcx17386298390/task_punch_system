<template>
  <div id="app">
    <TopBanner></TopBanner>
    <router-view></router-view>
  </div>
</template>

<script>
import TopBanner from './components/TopBanner.vue';
export default {
  name: 'App',
  components: {
    TopBanner,    
  }
}
</script> 

<style>

</style>

