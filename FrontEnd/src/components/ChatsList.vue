<template>
  <div class="container" id="main_container">
    <div class="row" v-for="chat in this.chats" v-bind:key="chat" id="OneChat" @click="this.onClickChat">
      <div class="col" id="UserName">
        {{ chat[0] }}
      </div>
      <div class="row" id="LastMessage">
        {{ chat[1] }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ChatsList",
  data() {
    return {
      chats: [["Julia Szymanska", "Dobranoc"], ["Martyna Piasecka", "Do zobaczenia"], ["Przemyslaw Zdrzalik", "Zrobimy to jutro!"], ["Huber Gawłowski", "Kiedy wychodzimy?"], ["Kamil Kiszko-Zgierski", "Ok"]],
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

#main_container {
  float: left;
  width: 10%;
}
 
</style>