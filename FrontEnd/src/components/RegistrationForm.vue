<template>
  <div id="registration">
    <h2>Register</h2>
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

    <div class="form-group sm-3">
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

    <div class="form-group sm-3">
      <label htmlFor="name">Name</label>
      <input
        type="text"
        v-model="name"
        name="name"
        class="form-control sm-3"
        :class="{ 'is-invalid': submitted && !name }"
      />
      <div v-show="submitted && !name" class="invalid-feedback">
        Name is required
      </div>
    </div>

    <div class="form-group sm-3">
      <label htmlFor="surname">Surname</label>
      <input
        type="text"
        v-model="surname"
        name="surname"
        class="form-control sm-3"
        :class="{ 'is-invalid': submitted && !surname }"
      />
      <div v-show="submitted && !surname" class="invalid-feedback">
        Surname is required
      </div>
    </div>

    <div class="form-group sm-3">
      <label htmlFor="email">Email</label>
      <input
        type="text"
        v-model="email"
        name="email"
        class="form-control sm-3"
        :class="{ 'is-invalid': submitted && !email }"
      />
      <div v-show="submitted && !email" class="invalid-feedback">
        Email is required
      </div>
    </div>

    <div class="form-group">
      <button class="btn btn-primary" v-on:click="this.register">
        Register
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
      name: "",
      surname: "",
      email: "",
      submitted: false,
    };
  },
  methods: {
    register: function() {
      let self = this;
      axios
        .post(process.env.VUE_APP_BACKEND_URL + "/registration", {
            login: self.username,
            password: self.password,
            name: self.name,
            surname: self.surname,
            email: self.email
        })
        .then(function(response) {
          console.log(response.data);
          self.$router.push("/login");
        })
        .catch(function(error) {
          console.log(error.response);
        });
    },
  },
};
</script>

<style scoped>
#registration {
  width: 20%;
  margin: auto;
  border: 1px solid gray;
  border-radius: 10px;
  padding: 10px 30px;
  background: #dcdcdc;
}
</style>
