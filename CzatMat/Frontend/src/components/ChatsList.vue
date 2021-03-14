<template>
  <div class=".container" id="main_container">
    <div
      class="col sm-3"
      v-for="chat in sortArrays(this.chats)"
      v-bind:key="chat"
      id="OneChat"
      @click="this.onClickChat(chat)"
    >
      <div class="row" id="UserName">
        {{ chat.chatName }}
      </div>
      <div class="row" id="LastMessage">
        {{ getDateForChat(chat.lastMessageDate) }}
      </div>
    </div>
  </div>
</template>

<script>
import _ from "lodash";

export default {
  name: "ChatsList",
  props: {
    chats: Array,
  },
  watch: {
    chats: function () {
      if (this.chats[0]) {
        let chat = this.sortArrays(this.chats)[0];
        this.$emit("search-event", chat.id);
              this.$emit("search-event-name", chat.chatName);
      }
    },
  },

  data() {
    return {};
  },
  created: function () {
    this.$emit("search-event", null);
  },
  methods: {
    sortArrays(arrays) {
      return _.orderBy(arrays, "lastMessageDate", "desc");
    },
    onClickChat: function (chat) {
      this.$emit("search-event", chat.id);
      console.log(chat.chatName);
      this.$emit("search-event-name", chat.chatName);
    },
    addZero: function (i) {
      if (i < 10) {
        i = "0" + i;
      }
      return i;
    },
    getLastMessageTime(chat) {
      let h = this.addZero(chat.getHours());
      let m = this.addZero(chat.getMinutes());
      let time = h + ":" + m;
      return time;
    },
    getLastMessageDate(chat) {
      let d = this.addZero(chat.getDay());
      let m = this.addZero(chat.getMonth());
      let y = this.addZero(chat.getYear()) + 1900;
      let date = d + "-" + m + "-" + y;
      return date;
    },
    getDateForChat(chat) {
      if (
        this.getLastMessageDate(chat) === this.getLastMessageDate(new Date())
      ) {
        return this.getLastMessageTime(chat);
      }
      return this.getLastMessageDate(chat);
    },
  },
};
</script>

<style scoped>
#OneChat {
  padding: 20px;
  text-align: left;
  cursor: pointer;
  width: 100%;
  background: rgba(245, 245, 245, 0.5);
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