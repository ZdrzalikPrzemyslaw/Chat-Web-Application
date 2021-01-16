<template>
  <div>
  </div>
</template>


<script>
import axios from "axios";
import authHeader from "../services/auth-header";

export default {
  name: "StoreUsers",
  props: {
    users: Array,
  },
  data() {
    return {
      usersData: Array,
    };
  },

  methods: {
    getUsers() {
      let self = this;
      const params = new URLSearchParams({
        chatId: self.chatId,
      }).toString();

      axios
        .put(
          process.env.VUE_APP_BACKEND_URL + "/chat/message" + "?" + params,
          { text: self.inputTextMessage },
          {
            headers: authHeader(),
          }
        )
        .then(function (response) {
          console.log(response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
</style>
