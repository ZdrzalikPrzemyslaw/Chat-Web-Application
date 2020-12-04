<template>
  <div id="login">
    <h2>Login</h2>
    <div class="form-group sm-3">
      <label for="username">Username</label>
      <input
        type="text"
        v-model="username"
        name="username"
        class="form-control sm-3"
      />
      <div v-show="submitted && !username" class="invalid-feedback">
        Username is required
      </div>
    </div>
    <div class="form-group">
      <label htmlFor="password">Password</label>
      <input
        type="password"
        v-model="password"
        name="password"
        class="form-control sm-3"
        :class="{ 'is-invalid': submitted && !password }"
      />
      <div v-show="submitted && !password" class="invalid-feedback">
        Password is required
      </div>
    </div>
    <div class="container text-center" id="buttons">
        <button class="btn btn-primary" v-on:click="this.login">
          Login
        </button>
        <button
          class="btn btn-secondary"
          v-on:click="this.$router.push('/registration')"
        >
          Go To Registration
        </button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "LoginForm",
  data() {
    return {
      username: "",
      password: "",
      submitted: false,
    };
  },
  methods: {
    login: function() {
      let self = this;
      axios
        .post(process.env.VUE_APP_BACKEND_URL + "/login", {
          username: self.username,
          password: self.password,
        })
        .then(function(response) {
          console.log(response.data);
          self.$router.push("/");
        })
        .catch(function(error) {
          console.log(error.response);
        });
    },
  },
};
</script>

<style scoped>
#login {
  width: 20%;
  margin: auto;
  border: 1px solid gray;
  border-radius: 10px;
  padding: 10px 30px;
  background: #dcdcdc;
}
#buttons > button {
  width: 60%;
  margin: 3px;
  text-align: center;
}
</style>
