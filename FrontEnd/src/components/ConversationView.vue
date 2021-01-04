<template>
  <div class="container" id="main_container">
    <div class="row">
      <div class="col">
        <img src="../assets/profile_pic.jpg" id="image" />
        <p id="user_name">Julia</p>
      </div>
    </div>

    <div v-for="(message, index, key) in sortArrays(messages)" :key="key">
      <div v-if="message.senderId === 1" class="container" id="ourMessage">
        <p class="d-flex flex-row-reverse">{{ message.text }}</p>
        <p class="d-flex flex-row-reverse" id="createAt">
          {{ getDateForMessage(message.createdAt) }}
        </p>
      </div>
      <div v-else class="container darker" id="theirMessage">
        <p class="d-flex flex-row">{{ message.senderId }}</p>
        <p class="d-flex flex-row">{{ message.text }}</p>
        <p class="d-flex flex-row" id="createAt">
          {{ getDateForMessage(message.createdAt) }}
        </p>
      </div>
    </div>
  </div>
</template>


<script>
import axios from "axios";
import authHeader from "../services/auth-header";
import _ from "lodash";

export default {
  name: "ConversationView",
  props: {
    chatId: Number,
  },
  data() {
    return {
      messages: [],
    };
  },

  created() {
    this.getChatMessages();
  },

  watch: {
    chatId: function () {
      this.getChatMessages();
    },
  },

  methods: {
    sortArrays(arrays) {
      return _.orderBy(arrays, "createdAt", "asc");
    },
    addZero: function (i) {
      if (i < 10) {
        i = "0" + i;
      }
      return i;
    },

    getMessageTime(message) {
      let h = this.addZero(message.getHours());
      let m = this.addZero(message.getMinutes());
      let time = h + ":" + m;
      return time;
    },
    getMessageDate(message) {
      let d = this.addZero(message.getDay());
      let m = this.addZero(message.getMonth());
      let y = this.addZero(message.getYear()) + 1900;
      let date = d + "-" + m + "-" + y + " " + this.getMessageTime(message);
      return date;
    },
    getDateForMessage(message) {
      if (this.getMessageDate(message) === this.getMessageDate(new Date())) {
        return this.getMessageTime(message);
      }
      return this.getMessageDate(message);
    },

    getChatMessages() {
      let self = this;

      console.log(self.chatId);

      const params = new URLSearchParams({
        chatId: self.chatId,
      }).toString();

      axios
        .get(process.env.VUE_APP_BACKEND_URL + "/chat/message" + "?" + params, {
          headers: authHeader(),
        })
        .then(function (response) {
          console.log(response.data);
          self.messages = response.data.messages;
          for (var i = 0; i < self.messages.length; i++) {
            self.messages[i].createdAt = new Date(self.messages[i].createdAt);
          }
        })
        .catch(function (error) {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
.container {
  border: 2px solid rgb(97, 95, 95);
  background-color: #f1f1f1;
  border-radius: 20px;
  padding: 15px;
  margin: 5px 0px;
}

.darker {
  border-color: rgb(97, 95, 95);
  background-color: #ddd;
}

.container img {
  float: left;
  max-width: 50px;
  margin-right: 20px;
  border-radius: 50%;
}

#createAt {
  color: rgb(143, 141, 141);
  font-size: 12px;
}

#user_name {
  text-align: left;
  margin: auto;
  font-weight: bold;
  padding: 5px 0;
  font-size: 20px;
}
</style>
