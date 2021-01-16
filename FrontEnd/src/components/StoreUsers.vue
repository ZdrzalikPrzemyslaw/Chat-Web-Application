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
    getUsers(userId) {
      const params = new URLSearchParams({
        id: userId,
      }).toString();

      axios
        .get(
          process.env.VUE_APP_BACKEND_URL + "/search/id" + "?" + params, 
          null,
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
