<template>
  <div id="app">
    <HelloWorld msg="hhh"></HelloWorld>
    <ul>
      <li><router-link to="/a">test</router-link></li>
    </ul>

    <router-view></router-view>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  }
}
</script> 

<style>

</style>
