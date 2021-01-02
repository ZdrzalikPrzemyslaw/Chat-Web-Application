<template>
  <div class=".container" id="main_container">
    <div class="col sm-3" v-for="chat in this.chats" v-bind:key="chat" id="OneChat" @click="this.onClickChat">
      <div class="row" id="UserName">
        {{ chat.user }}
      </div>
      <div class="row" id="LastMessage">
        {{ chat.message }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ChatsList",
  props: {
    chats: Array
  },
  data() {
    return {
    }
  },
  methods: {
    onClickChat: function () {
    //    Tutaj trzeba będzie zrobić metodę onClick
    }
  }
}
</script>

<style scoped>
#OneChat {
  padding: 20px;
  text-align: left;
  cursor: pointer;
  width: 100%;
  background: #D4D4D4;
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