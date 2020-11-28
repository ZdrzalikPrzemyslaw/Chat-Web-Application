<template>
  <div class=".containter" id="main_container">
    <form>
    <div class="col sm-3">                <!-- zrobiłam taki rozmiar jak ChatList.vue, bo nie wiedziałam jaki jest koncept -->
      <input type="text"  v-model='chats.user' id="inputUser" placeholder="Imię i nazwisko użytkownika"
             class="form-control">
    </div>
      <div>
        <input type="button" v-on:click="returnData()" class="btn btn-info col-sm-3" value="Szukaj"/>
      </div>
    </form>
  </div>
</template>

<script>
//import _ from 'underscore'              // używam underscora do przeszukiwania listy

export default {
name: "Search",
  data: function() {
    return {
      receivedData: {},                 // tu zapiszemy odebraną tabelę z użytkownikami
      receivedDataToTable: [],
      dataToReturn: [],
      chats: {
        user: ''
      }
    }
  },

  /*created() {
    this.emitter.on('sendData', (data) => {
      this.receivedData = data
      this.receivedDataToTable = this.receivedData
    });
  },

  methods: {
    search: function () {
      this.dataToReturn = [];

      // wyszukiwanie po użytkowniku
      _.each(this.receivedDataToTable, (userName) => {
        if (userName.user.includes(this.chats.user)) {
          this.dataToReturn.push(userName)
        }
      })

      console.log("this.dataToReturn", this.dataToReturn);
    },*/
    returnData: function () {
      //this.search()
      //this.emitter.emit('returnFilteredData', this.dataToReturn);
    }
  //}
}
</script>

<style scoped>

</style>