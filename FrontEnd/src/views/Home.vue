<template>
<div class=".container-fluid">
  <div class="row">
    <div class="col-1">
      <Settings/>
    </div>
    <div class="col-2">
      <Search @search-event="handleAppEvent"/>
      <ChatsList :chats='eventData'/>
    </div>
    <div class="col-9">
      <ConversationView/>
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
      console.log('event received');
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
  color: #2c3e50;
  margin-top: 60px;
  width: 100%;
}
.container *{
  width: 100%;
  table-layout: fixed;
}
/* ChatsList{
  width:15%;
  float: left;
}
ConversationView{
  width: 75%;
  float: right;
} */
</style>