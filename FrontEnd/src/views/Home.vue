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
        <ConversationView :chatId="eventChatId" @search-event="handleBoolAppEvent"/>
        <SendMessage :chatId="eventChatId" v-if="eventBool"/>
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
import SendMessage from "../components/SendMessage";

export default {
  name: "Home",
  components: {
    Search,
    Settings,
    ChatsList,
    ConversationView,
    SendMessage,
  },
  data() {
    return {
      eventChatList: Array,
      eventChatId: Number,
      eventBool: Boolean,
    };
  },
  methods: {
    handleChatListAppEvent: function (data) {
      this.eventChatList = data;
      console.log("event chat list received");
      this.eventChatId = this.eventChatList[0].id;
    },
    handleChatIdAppEvent: function (data) {
      this.eventChatId = data;
      console.log("event chat id received");
    },
    handleBoolAppEvent: function (data) {
      this.eventBool = data;
    },
    created() {
      this.eventChatId = null;
      this.eventBool = false;
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