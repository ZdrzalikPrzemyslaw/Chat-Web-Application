<template>
  <div class="containter" id="main_container">
    <form>
      <div class="form-group">
        <input
          type="text"
          v-model="this.searchText"
          id="inputUser"
          placeholder="Name and Surname"
          class="form-control"
        />
      </div>
      <div class="form-group">
        <input
          type="button"
          v-on:click="returnData()"
          class="btn btn-sm btn-block sm-3"
          value="Search"
        />
      </div>
    </form>
  </div>
</template>

<script>
import authHeader from "../services/auth-header";
import axios from "axios";

export default {
  name: "Search",
  data() {
    return {
      chats: [],
      searchText: "",
      dataToReturn: [],
    };
  },

  methods: {

    returnData: function () {
      this.getChats();
    },

    getChats() {
      let self = this;
      this.searchText = this.searchText.trim();
      let res = this.searchText.split(/[ ,]+/);
      let name = res[0];
      let surname = "";
      if(!res[1]) {
        surname = name;
      }
      else {
        surname = res[1];
      }
      const params = new URLSearchParams({
        name: name,
        surname: surname
      }).toString();
      axios
        .get(process.env.VUE_APP_BACKEND_URL + "/search" + "?" + params , {
          headers: authHeader(),
        })
        .then(function (response) {
          self.chats = response.data.users;
          self.dataToReturn = self.chats;
          console.log(self.dataToReturn)
          self.$emit("search-event", self.dataToReturn);
          console.log("event emitted");
        })
        .catch(function (error) {
          console.log(error);
        });
    },
  },
  // w created jest emitowanie calej listy, zeby na starcie sie ona pokazywala
  created: function () {
    this.getChats();
  },
};
</script>

<style scoped>
@import url("http://fonts.googleapis.com/css?family=Kaushan+Script");

h1 {
  color: rgba(245, 245, 245, 0.8);
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
  border: 2px solid rgba(245, 245, 245, 0.8);
  border-radius: 10px;
}

.btn {
  margin-left: 50px;
  background: none;
  border: 4px solid rgba(245, 245, 245, 0.8);
  border-radius: 10px;
  color: rgba(245, 245, 245, 0.8);
  display: block;
  font-size: 1em;
  font-weight: bold;
  position: relative;
  text-transform: uppercase;
  text-align: center;
}

.btn:hover {
  color: rgb(48, 47, 47, 0.8);
  border: 4px solid rgb(48, 47, 47, 0.8);
  background: rgba(245, 245, 245, 0.8);
}
</style>
