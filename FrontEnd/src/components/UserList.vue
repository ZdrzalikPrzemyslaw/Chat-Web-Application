<template>
  <div class=".container" id="main_container">
    <div v-for="user in searchedUsers" v-bind:key="user">
      <div class="row" id="OneChat">
        <div class="col sm-3">
          <div class="row" id="UserName">
            {{ user.name }}
          </div>
          <div class="row" id="UserSurname">
            {{ user.surname }}
          </div>
        </div>
        <div class="col sm-3">
          <div class="row" id="but">
            <input
              type="button"
              id="but"
              v-on:click="addUserToChat(user.username)"
              class="btn btn-sm btn-block sm-3"
              value="+"
            />
          </div>
        </div>
      </div>
    </div>
    <div v-for="user in usersInChat" v-bind:key="user">
      <div class="row" id="OneChat">
        <div class="col sm-3">
          <div class="row" id="UserName">
            {{ user.name }}
          </div>
          <div class="row" id="UserSurname">
            {{ user.surname }}
          </div>
        </div>
        <div class="col sm-3">
          <div class="row" id="but">
            <input
              type="button"
              id="but"
              v-on:click="deleteUserFromChat(user.username)"
              class="btn btn-sm btn-block sm-3"
              value="-"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import authHeader from "../services/auth-header";

export default {
  name: "UserList",
  props: {
    usersFromSearch: Array,
    chatId: Number,
  },
  data() {
    return {
      usersInChat: [],
      searchedUsers: [],
      chat: [],
    };
  },
  watch: {
    chatId: function() {
      this.getChatFromId();
    },
    usersFromSearch: {
      deep: true,
      handler() {
        this.deleteAllUsersFromArrayFromChat();
      },
    },
  },
  created: function() {},
  methods: {
    getChatFromId() {
      let self = this;
      const params = new URLSearchParams({
        id: self.chatId,
      }).toString();

      axios
        .get(process.env.VUE_APP_BACKEND_URL + "/chat/id" + "?" + params, {
          headers: authHeader(),
        })
        .then(function(response) {
          self.chat = response.data.chatsList[0];
          self.usersInChat = response.data.chatsList[0].userList;
        })
        .catch(function(error) {
          console.log(error);
        });
    },

    deleteAllUsersFromArrayFromChat() {
      this.searchedUsers = this.usersFromSearch;
      var i = this.searchedUsers.length;
      while (i--) {
        for (const j in this.usersInChat) {
          if (this.searchedUsers[i].id === this.usersInChat[j].id) {
            this.searchedUsers.splice(i, 1);
          }
        }
      }
    },

    deleteUserFromChat(userName) {
      let self = this;
      const params = new URLSearchParams({
        chatId: self.chatId,
      }).toString();
      axios
        .delete(
          process.env.VUE_APP_BACKEND_URL + "/chat/users" + "?" + params,
          {
            headers: authHeader(),
            data: {
              users: [{ username: userName }],
            },
          }
        )
        .then(function() {
          for (const i in self.usersInChat) {
            if (self.usersInChat[i].username === userName) {
              self.usersInChat.splice(i, 1);
              break;
            }
          }
        })
        .catch(function(error) {
          console.log(error);
        });
    },

    addUserToChat(userName) {
      let self = this;
      const params = new URLSearchParams({
        chatId: self.chatId,
      }).toString();
      axios
        .post(
          process.env.VUE_APP_BACKEND_URL + "/chat/users" + "?" + params,
          { users: [{ username: userName }] },
          {
            headers: authHeader(),
          }
        )
        .then(function() {
          for (const i in self.searchedUsers) {
            if (self.searchedUsers[i].username === userName) {
              self.usersInChat.push(self.searchedUsers[i]);
              self.searchedUsers.splice(i, 1);
              break;
            }
          }
        })
        .catch(function(error) {
          console.log(error);
        });
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

#UserSurname {
  font-weight: bold;
  padding: 5px 0;
}

#LastMessage {
  opacity: 0.9;
  margin-left: 5px;
}

#but {
  font-size: 45px;
}
</style>
