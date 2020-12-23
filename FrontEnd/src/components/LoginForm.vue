<template>
  <div id="login">
    <h2>Login</h2>
    <div class="form-group sm-3">
      <label for="username">Username</label>
      <input
        type="text"
        v-model="user.username"
        name="username"
        class="form-control sm-3"
      />
      <div v-show="submitted && !user.username" class="invalid-feedback">
        Username is required
      </div>
    </div>
    <div class="form-group">
      <label htmlFor="password">Password</label>
      <input
        type="password"
        v-model="user.password"
        name="password"
        class="form-control sm-3"
        :class="{ 'is-invalid': submitted && !user.password }"
      />
      <div v-show="submitted && !user.password" class="invalid-feedback">
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
<!--todo adjust to vee-validate 4 (vee-validate 4 works with vue 3, previous no)
  https://vee-validate.logaretm.com/v4/  https://vee-validate.logaretm.com/v4/examples/checkboxes-and-radio
  https://jasonwatmore.com/post/2020/10/01/vue-3-veevalidate-form-validation-example -->
<script>
//import axios from "axios";
import User from '../models/user';
import store from '../store/index';
import { Form, Field } from 'vee-validate';
import * as Yup from 'yup';

export default {
  name: "LoginForm",
  data() {
    return {
      user: new User('',''),
      // username: "",
      // password: "",
      loading:false,
      submitted: false,
    };
  },
  computed: {
    loggedIn() {
      return store.state.auth.status.loggedIn;
    }
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/home");
    }
  },
  methods: {
    login: function() {
      this.loading = true;
      this.$validator.validateAll().then(isValid => {
        if (!isValid) {
          this.loading = false;
          return;
        }
        if (this.user.username && this.user.password) {
          store.dispatch('/auth/login', this.user).then(
              () => {
                this.$router.push('/home');
              },
              // error => {
              //   this.loading = false;
              // }
          );
        }
      });
      // let self = this;
      // axios
      //   .post(process.env.VUE_APP_BACKEND_URL + "/login", {
      //     username: self.username,
      //     password: self.password,
      //   })
      //   .then(function(response) {
      //     console.log(response.data);
      //     self.$router.push("/home");
      //   })
      //   .catch(function(error) {
      //     console.log(error.response);
      //   });
    }
  }
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
