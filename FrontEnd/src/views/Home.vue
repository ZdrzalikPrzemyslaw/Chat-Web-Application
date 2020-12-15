<template>
<div class=".container-fluid">
  <div class="row">
     <div class="col-12 bar">
        <div class="d-flex justify-content-right" id="lastColumn">
          <Settings/>
        </div>
     </div>
  </div>
  <div class="row">
    <div class="col-3" id="firstColumn">
      <Search @search-event="handleAppEvent"/>
      <ChatsList :chats='eventData'/>
    </div>
    <div class="col-8">
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
  width: 100%;
}
.container *{
  width: 100%;
  table-layout: fixed;
}
.bar {
  padding: 0;
  background-color: #9C35F2;
}
#firstColumn {
  margin: 10px;
}

</style>