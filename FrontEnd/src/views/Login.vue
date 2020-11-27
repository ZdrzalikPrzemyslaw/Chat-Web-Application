<template>
  <LoginForm  class="justify-center"/>
</template>

<script>
import LoginForm from "../components/LoginForm";
export default {
  name: 'Login',
  components: {
    LoginForm
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>