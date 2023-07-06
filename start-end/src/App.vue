<template>
  <div id="app">
    <TopBanner></TopBanner>
    <SendMsg></SendMsg>
    <router-view></router-view>

  </div>
</template>

<script>
import TopBanner from './components/TopBanner.vue';
import SendMsg from './pages/SendMsg.vue';

export default {
  name: 'App',
  components: {
    TopBanner,
    SendMsg
  }
}
</script> 

<style>

</style>

