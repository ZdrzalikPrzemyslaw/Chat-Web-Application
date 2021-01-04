<template>
  <div class=".container" id="main_container">
    <div
      class="col sm-3"
      v-for="chat in this.chats"
      v-bind:key="chat"
      id="OneChat"
      @click="this.onClickChat(chat.chatId)"
    >
      <div class="row" id="UserName">
        {{ chat.chatName }}
      </div>
      <div class="row" id="LastMessage">
        {{ chat.lastMessageDate }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ChatsList",
  props: {
    chats: Array,
  },
  data() {
    return {};
  },
  methods: {
    onClickChat: function (chatId) {
      self.$emit("search-event", chatId);
      console.log("event emitted chat id to display");
    },
  },
  created: function () {
    self.$emit("search-event", this.chats[0].chatId);
    console.log("event emitted chat id to display");
  },
};
</script>

<style scoped>
#OneChat {
  padding: 20px;
  text-align: left;
  cursor: pointer;
  width: 100%;
  background: #d4d4d4;
  margin: 10px 5px 5px 50px;
  border-radius: 10px;
  color: black;
}

#UserName {
  font-weight: bold;
  padding: 5px 0;
  margin-left: 5px;
}

#LastMessage {
  opacity: 0.9;
  margin-left: 5px;
}
</style>