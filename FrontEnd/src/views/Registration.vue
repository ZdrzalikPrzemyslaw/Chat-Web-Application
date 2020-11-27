<template>
  <RegistrationForm  class="justify-center"/>
</template>

<script>
import RegistrationForm from "../components/RegistrationForm";
export default {
  name: 'Registration',
  components: {
    RegistrationForm
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