import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/registration',
    name: 'Registration',
    component: () => import(/* webpackChunkName: "about" */ '../views/Registration.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
  },
  {
    path: '/',
     redirect: {
       name: 'Login'
      },
  },
  {
    path: '/home',
    name: 'Home',
    component: Home
  },
  {
    path: "/:catchAll(.*)",
    name: "NotFound", 
    // TODO: add page not found page
    redirect: '/'
  }
]



const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

router.beforeEach((to, from, next) => {
  // redirect to login page if not logged in and trying to access a restricted page
  const publicPages = ['/login', '/registration'];
  const authRequired = !publicPages.includes(to.path);
  // TODO:
  const loggedIn = localStorage.getItem('user');
  //const loggedIn = true;

  if (authRequired && !loggedIn) {
    return next('/login');
  }
  next();
})

export default router
