<template>
  <ChatsList/>
  <ConversationView/>
</template>

<script>
import ChatsList from "../components/ChatsList";
import ConversationView from "../components/ConversationView"
export default {
  name: 'Home',
  components: {
    ChatsList,
    ConversationView
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