<template>
  <div class=".container-fluid">
    <div class="row">
      <div class="col-md-2" id="firstColumn">
        <Search @search-event="handleChatListAppEvent" />
        <ChatsList
          :chats="eventChatList"
          @search-event="handleChatIdAppEvent"
        />
      </div>
      <div class="col-md-1" />
      <div class="col-md-6">
        <ConversationView :chatId="eventChatId" />
      </div>
      <div class="col-md-2" id="lastColumn">
        <Settings />
      </div>
    </div>
  </div>
</template>

<script>
import ChatsList from "../components/ChatsList";
import ConversationView from "../components/ConversationView";
import Settings from "../components/Settings";
import Search from "../components/Search";

export default {
  name: "Home",
  components: {
    Search,
    Settings,
    ChatsList,
    ConversationView,
  },
  data() {
    return {
      eventChatList: Array,
      eventChatId: Number,
    };
  },
  methods: {
    handleChatListAppEvent: function (data) {
      this.eventChatList = data;
      console.log("event chat list received");
    },
    handleChatIdAppEvent: function (data) {
      this.eventChatId = data;
      console.log("event chat id received");
    },
  },
};
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
.container-fluid * {
  width: 100%;
  table-layout: fixed;
}
#firstColumn {
  margin: 10px;
}
#lastColumn {
  align-items: left;
  margin: 10px;
}
</style>