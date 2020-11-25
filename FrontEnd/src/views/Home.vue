<template>
  <ChatsList/>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import ChatsList from "../components/ChatsList";
export default {
  name: 'Home',
  components: {
    // HelloWorld,
    ChatsList,
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