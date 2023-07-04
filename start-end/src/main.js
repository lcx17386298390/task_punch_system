import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

import store from './vuex/store'
import VueRouter from 'vue-router'
import router from './router'
Vue.use(VueRouter)

new Vue({
  store:store,
  router:router,
  render: h => h(App),
}).$mount('#app')
