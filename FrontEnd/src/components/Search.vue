<template>
  <div class="containter" id="main_container">
    <form>
      <div class="form-group">
        <h1 class="md-4">CzatMat</h1>
        <!-- zrobiłam taki rozmiar jak ChatList.vue, bo nie wiedziałam jaki jest koncept -->
        <input
          type="text"
          v-model="chats.user"
          id="inputUser"
          placeholder="Name and Surname"
          class="form-control"
        />
      </div>
      <div class="form-group">
        <input
          type="button"
          v-on:click="returnData()"
          class="btn  btn-sm btn-block sm-3"
          value="Search"
        />
      </div>
    </form>
  </div>
</template>

<script>
import _ from "underscore"; // używam underscora do przeszukiwania listy

export default {
  name: "Search",
  data() {
    return {
      chats: [
        { user: "Julia Szymanska", message: "Dobranoc" },
        { user: "Martyna Piasecka", message: "Do zobaczenia" },
        { user: "Przemyslaw Zdrzalik", message: "Zrobimy to jutro!" },
        { user: "Hubert Gawłowski", message: "Kiedy wychodzimy?" },
        { user: "Kamil Kiszko-Zgierski", message: "Ok" },
      ],
    };
  },

  methods: {
    search: function() {
      this.dataToReturn = [];

      // wyszukiwanie po użytkowniku
      _.each(this.chats, (userName) => {
        if (userName.user.includes(this.chats.user)) {
          this.dataToReturn.push(userName);
        }
      });

      // ponizszy warunek, zeby mozna bylo zobaczyc wszystkie konwersacje, gdy nic nie jest wpisane
      if (this.chats.user == "") {
        this.dataToReturn = this.chats;
      }

      console.log("this.dataToReturn", this.dataToReturn);
    },
    returnData: function() {
      this.search();
      this.$emit("search-event", this.dataToReturn);

      console.log("event emitted");
    },
  },
  // w created jest emitowanie calej listy, zeby na starcie sie ona pokazywala
  created: function() {
    this.dataToReturn = [];
    this.dataToReturn = this.chats;

    this.$emit("search-event", this.dataToReturn);
    console.log("event with all emitted");
  }, //
};
</script>

<style scoped>
@import url("http://fonts.googleapis.com/css?family=Kaushan+Script");

h1 {
  color: black;
  margin-left: 50px;
  font-weight: bold;
  font-family: "Kaushan Script";
  font-size: 45px;
  display: block;
  position: relative;
  margin-bottom: 40px;
}

#inputUser {
  margin-left: 50px;
  margin-top: 30px;
  border: 2px solid #fff;
  border-radius: 10px;
}

.btn {
  margin-left: 50px;
  background: none;
  border: 4px solid #fff;
  border-radius: 10px;
  color: #fff;
  display: block;
  font-size: 1em;
  font-weight: bold;
  position: relative;
  text-transform: uppercase;
  text-align: center;
}

.btn:hover {
  color: black;
  border: 4px solid black;
}
</style>
