<template>
<div class=".container-fluid">
  <div class="row">
    <div class="col-2" id="firstColumn">
      <Search @search-event="handleAppEvent"/>
      <ChatsList :chats='eventData'/>
    </div>
    <div class="col-1"/>
    <div class="col-6">
      <ConversationView/>
    </div>
     <div class="col-2" id="lastColumn">
      <Settings/>
    </div>
  </div>
</div>
</template>

<script>
import ChatsList from "../components/ChatsList";
import ConversationView from "../components/ConversationView"
import Settings from "../components/Settings"
import Search from "../components/Search";

export default {
  name: 'Home',
  components: {
    Search,
    Settings,
    ChatsList,
    ConversationView
  },
  data() {
    return {
      eventData: Array
    }
  },
  methods: {
    handleAppEvent: function (data) {
      this.eventData = data;
      console.log('event received');    //color: #2c3e50;font-family: Arial ;
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  margin-top: 60px;
  width: 100%;
  font-size: 16px;
}
body {
  background: #00abb7;
}
.container *{
  width: 100%;
  table-layout: fixed;
}
#firstColumn {
  margin: 10px;
}
#lastColumn {
  align-items: left;
}
</style>