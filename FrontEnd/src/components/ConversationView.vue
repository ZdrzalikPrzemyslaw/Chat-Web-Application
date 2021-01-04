<template>
  <div class="container" id="main_container">
    <div class="row">
      <div class="col">
        <img src="../assets/profile_pic.jpg" id="image" />
        <p id="user_name">Julia</p>
        <!--        <p id="token">{{ currentUser.accessToken}}</p> odkomentowac do wyswietlenia tokenu -->
      </div>
    </div>

    <div v-for="(message, index, key) in sortArrays(messages)" :key="key">
      <div v-if="message.senderId === 1" class="container" id="ourMessage">
        <p class="d-flex flex-row-reverse">{{ message.text }}</p>
        <p class="d-flex flex-row-reverse" id="createAt">
          {{ message.createdAt }}
        </p>
      </div>
      <div v-else class="container darker" id="theirMessage">
        <p class="d-flex flex-row">{{ message.senderId }}</p>
        <p class="d-flex flex-row">{{ message.text }}</p>
        <p class="d-flex flex-row" id="createAt">{{ message.createdAt }}</p>
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
  data() {
    return {
      messages: [],
    };
  },
  // computed: {   // odkomentowac te 5 linijek do wyswietlenia tokenu
  //   currentUser() {
  //     return store.state.auth.user;
  //   }
  // },
  created() {
    this.getPrzyklad();
  },
  methods: {
    sortArrays(arrays) {
      return _.orderBy(arrays, "createdAt", "asc");
    },

    // TODO: Na potrzeby przykładu (zajęc) pobieramy wiadomosci z czatu nr 1
    getPrzyklad: function () {
      let self = this;
      const params = new URLSearchParams({
        chatId: 1,
      }).toString();

      console.log(authHeader());

      axios
        .get(process.env.VUE_APP_BACKEND_URL + "/chat/message" + "?" + params, {
          headers: authHeader(),
        })
        .then(function (response) {
          console.log(response.data);
          self.messages = response.data.messages;
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
  margin: 5px 0;
}

.darker {
  border-color: rgb(97, 95, 95);
  background-color: #ddd;
}

.container img {
  float: left;
  max-width: 50px;
  /* width: 100%; */
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
