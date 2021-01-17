<template>
  <div class=".container" id="main_container">
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
              class="btn btn-sm btn-block sm-3"
              value="+"
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
      chat: [],
    };
  },
  watch: {
    chatId: function () {
      this.getChatFromId();
    },
  },
  created: function () {},
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
        .then(function (response) {
          self.chat = response.data;
          self.usersInChat = response.data.users;
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
}

#LastMessage {
  opacity: 0.9;
  margin-left: 5px;
}

#but {
  font-size: 45px;
}
</style>
