<template>
  <div class="container" id="main_container">
    <img src="../assets/profile_pic.jpg">
    <p id="user_name">Marcin "Brick" Cegielski</p>   
    <div v-for="message in messages" v-bind:key="message">
    <div v-if="message[2]==0" class="container" >
      <p>{{message[0]}}</p>
      <span class="time-left">{{message[1]}}</span>
    </div>
    <div v-else class="container darker">
      <p>{{message[0]}}</p>
      <span class="time-right">{{message[1]}}</span>
    </div>
    </div>
  </div>
</template>


<script>
export default {
  name: "ConversationView",
  data() {
    return {
      messages: [["Witam prosze mi opowiedzieć o protokole HTTP","17:48",0], ["opowiedz o tym protokole HTTP czlowieku","17:55",0],
         ["moze grzeczniej","17:56",1], ["poprosze Hubert ten protokół","17:58",0]], // 0 - we receive message, 1 -we send message
      
    }
  }
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