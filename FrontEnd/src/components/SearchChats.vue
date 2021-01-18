<template>
  <div class="containter" id="main_container">
    <form>
      <div class="form-group">
        <h1 class="md-4">CzatMat</h1>
        <input
          type="text"
          v-model="this.searchText"
          id="inputUser"
          placeholder="Chat Name"
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

  mounted: function () {
    this.timer = setInterval(() => {
      this.returnData();
    }, 15000);
  },

  methods: {
    returnData: function() {
      this.getChats();
    },
    getChats() {
      let self = this;

      const params = new URLSearchParams({
        chatName: this.searchText,
      }).toString();
      axios
        .get(process.env.VUE_APP_BACKEND_URL + "/chat" + "?" + params, {
          headers: authHeader(),
        })
        .then(function(response) {
          self.chats = response.data.chatsList;
          self.dataToReturn = self.chats;

          for (var i = 0; i < self.chats.length; i++) {
            self.chats[i].lastMessageDate = new Date(
              self.chats[i].lastMessageDate
            );
          }
          self.$emit("search-event", self.dataToReturn);
        })
        .catch(function(error) {
          console.log(error);
        });
    },
  },
  // w created jest emitowanie calej listy, zeby na starcie sie ona pokazywala
  created: function() {
    this.getChats();
  },

  beforeUnmount() {
    clearInterval(this.timer);
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
