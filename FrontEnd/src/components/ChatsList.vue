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
  data() {
    return {
      chats: [{user: "Julia Szymanska", message: "Dobranoc"}, {user: "Martyna Piasecka", message: "Do zobaczenia"}, 
      {user: "Przemyslaw Zdrzalik", message: "Zrobimy to jutro!"}, {user: "Huber Gawłowski", message: "Kiedy wychodzimy?"}, 
      {user: "Kamil Kiszko-Zgierski", message: "Ok"}]
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
  margin: 5px;
  border-radius: 10px;
}

#UserName {
  font-weight: bold;
  padding: 2px 0
}

#LastMessage {
  opacity: 0.9;
}

/* #main_container {
  
} */
 
</style>