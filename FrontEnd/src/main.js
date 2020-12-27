import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// import vueResource from 'vue-resource'


// createApp(App).use(vueResource)
createApp(App).use(router, store).mount('#app')
// router.replace({ path: '/login', redirect: '/' })
export default router