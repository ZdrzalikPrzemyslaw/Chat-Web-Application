<template>
  <div class="container" id="main_container">
    <div class="row">
      <div class="col">
        <img src="../assets/profile_pic.jpg" id="image" />
        <p id="user_name">Julia</p>
<!--        <p id="token">{{ currentUser.accessToken}}</p> odkomentowac do wyswietlenia tokenu -->
      </div>
    </div>

    <div v-for="(message, index, key) in messages" :key="key">
      <div v-if="message.userName === 'Julia'" class="container">
        <p>{{ message.message }}</p>
        <p>{{ message.date }}</p>
      </div>
      <div v-else class="container darker">
        <p>{{ message.userName }}</p>
        <p>{{ message.message }}</p>
        <p>{{ message.date }}</p>
      </div>
    </div>

    <!-- <div v-for="message in messages" v-bind:key="message">
      <div v-if="message[2] == 0" class="container">
        <p>{{ message[0] }}</p>
        <span class="time-left">{{ message[1] }}</span>
      </div>
      <div v-else class="container darker">
        <p>{{ message[0] }}</p>
        <span class="time-right">{{ message[1] }}</span>
      </div>
    </div> -->
  </div>
</template>

<script>
import axios from "axios";
//import store from '../store/index'; // odkomentowac do wyswietlenia tokenu
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
    getPrzyklad: function () {
      let self = this;
      axios
        .get(process.env.VUE_APP_BACKEND_URL + "/przyklad")
        .then(function (response) {
          console.log(response.data);
          self.messages = response.data;
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
  border: 2px solid #ff0000;
  background-color: #f1f1f1;
  border-radius: 20px;
  padding: 10px;
  margin: 5px 0;
}

.darker {
  border-color: rgb(97, 95, 95);
  background-color: #ddd;
}

/* .container::after {
  content: "";
  clear: both;
  display: table;
} */

.container img {
  float: left;
  max-width: 50px;
  /* width: 100%; */
  margin-right: 20px;
  border-radius: 50%;
}

/* .time-right {
  float: right;
  color: #aaa;
  font-size: 15px;
} */

/* .time-left {
  float: left;
  color: #aaa;
  font-size: 15px;
} */

#user_name {
  text-align: left;
  margin: auto;
}
</style>
