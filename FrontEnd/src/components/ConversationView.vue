<template>
  <div class="container" id="main_container">
    <div class="row">
      <div class="col">
        <p id="user_name">{{ chatName }}</p>
      </div>
      <div class="col">
        <button
          type="submit"
          class="btn btn-primary float-right"
          value=".float-right"
          id="deleteButton"
          v-on:click="deleteChat()"
        >
          Delete
        </button>
      </div>
    </div>

    <div v-for="(message, index, key) in sortArrays(messages)" :key="key">
      <div
        v-if="message.senderId === getCurrentUserId()"
        class="container"
        id="ourMessage"
      >
        <p class="d-flex flex-row-reverse">{{ message.text }}</p>
        <p class="d-flex flex-row-reverse" id="createAt">
          {{ getDateForMessage(message.createdAt) }}
        </p>
      </div>
      <div v-else class="container darker" id="theirMessage">
        <p class="d-flex flex-row">
          {{ getNameAndSurnameForMessage(message) }}
        </p>
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
import userId from "../services/user-id";
import _ from "lodash";

export default {
  name: "ConversationView",
  props: {
    chatId: Number,
    chatName: String,
  },
  data() {
    return {
      messages: [],
      usersList: new Map(),
    };
  },

  created() {
    this.usersList = new Map();
    this.$emit("search-event", false);
  },

  watch: {
    chatId: function () {
      this.$emit("search-event", true);
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

    getCurrentUserId() {
      return userId();
    },

    // TODO: zrobic pobieranie chatu przy watchu i wtedy jest pobrane chatName i uzytkownicy
    getNameAndSurnameForMessage(message) {
      let self = this;
      if (self.usersList.get(message.senderId) === undefined) {
        const par = new URLSearchParams({
          id: message.senderId,
        }).toString();
        axios
          .get(process.env.VUE_APP_BACKEND_URL + "/search/id" + "?" + par, {
            headers: authHeader(),
          })
          .then(function (response) {
            self.usersList.set(message.senderId, response.data);
          })
          .catch(function (error) {
            console.log(error);
          });
      } else {
        let mes = self.usersList.get(message.senderId);
        return mes.users[0].name + " " + mes.users[0].surname;
      }
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
      if (self.chatId != null) {
        const params = new URLSearchParams({
          chatId: self.chatId,
        }).toString();

        axios
          .get(
            process.env.VUE_APP_BACKEND_URL + "/chat/message" + "?" + params,
            {
              headers: authHeader(),
            }
          )
          .then(function (response) {
            self.messages = response.data.messages;
            for (var i = 0; i < self.messages.length; i++) {
              self.messages[i].createdAt = new Date(self.messages[i].createdAt);
            }
          })
          .catch(function (error) {
            console.log(error);
          });
      } else {
        this.$emit("search-event", false);
      }
    },

    deleteChat() {
      let self = this;
      const params = new URLSearchParams({
        chatId: self.chatId,
      }).toString();

      axios
        .delete(process.env.VUE_APP_BACKEND_URL + "/chat" + "?" + params, {
          headers: authHeader(),
        })
        .then(function (response) {
          console.log(response.data);
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
  background-color: rgba(212, 211, 211, 0.5);
  border-radius: 20px;
  padding: 8px 12px;
  margin: 5px 0px;
}

.darker {
  border-color: rgb(97, 95, 95);
  background-color: rgba(255, 255, 255, 0.5);
}

.container img {
  float: left;
  max-width: 50px;
  margin-right: 20px;
  border-radius: 50%;
}

#deleteButton {
  max-width: 100px;
  max-height: 50px;
  margin-right: 30px;
  margin-top: 5px;
}

#createAt {
  color: rgb(143, 141, 141);
  font-size: 17px;
}

#user_name {
  text-align: start;
  font-weight: bold;
  padding: 2px 0;
  margin-left: 30px;
  margin-top: 5px;
  font-size: 25px;
}
</style>
