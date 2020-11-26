<template>
  <div class="container" id="main_container">
    <img src="../assets/profile_pic.jpg" />
    <p id="user_name"></p>

    <div v-for="oneMessage in messages" :key="">
        <div v-if="userName === 'Julia'" class="container">
          <p>{{ message }}</p>
          <p>{{ date }}</p>
        </div>
        <div v-else class="container darker">
          <p>{{ userName }}</p>
          <p>{{ message }}</p>
          <p>{{ date }}</p>
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
import axios from 'axios'
export default {
  name: "ConversationView",
  data() {
    return {
      messages: [],
    };
  },

  created() {
    let self = this;
    axios.get("https://czatmat.azurewebsites.net/przyklad")
    .then(function (response) {
      console.log(response.data);
      self.messages = response.data;
    })
    .catch(function (error){
      console.log(error);
    })
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
  border-color: rgb(47, 0, 255);
  background-color: #ddd;
}

.container::after {
  content: "";
  clear: both;
  display: table;
}

.container img {
  float: left;
  max-width: 50px;
  width: 100%;
  margin-right: 20px;
  border-radius: 50%;
}

.time-right {
  float: right;
  color: #aaa;
  font-size: 15px;
}

.time-left {
  float: left;
  color: #aaa;
  font-size: 15px;
}

#main_container {
  float: left;
  margin-left: 40px;
  width: 80%;
}

#user_name {
  text-align: left;
}
</style>