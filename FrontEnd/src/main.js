import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// import store from './store'
import VeeValidate from 'vee-validate'

// import vueResource from 'vue-resource'


// createApp(App).use(vueResource)
createApp(App).use(router,VeeValidate).mount('#app')
// router.replace({ path: '/login', redirect: '/' })
export default router