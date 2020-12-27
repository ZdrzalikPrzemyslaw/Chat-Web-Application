<template>
  <div id="login">
    <h2>Login</h2>
    <Form @submit="login" :validation-schema="schema" v-slot="{ errors }">
        <div class="form-group sm-3">
          <label for="username">Username</label>
          <Field name="username" v-model="user.username" type="text" class="form-control sm-3" :class="{ 'is-invalid': errors.username }"/>
          <div class="invalid-feedback">{{ errors.username }}</div>
        </div>
        <div class="form-group">
          <label htmlFor="password">Password</label>
          <Field name="password" v-model="user.password" type="text" class="form-control sm-3" :class="{ 'is-invalid': errors.password }"/>
          <div class="invalid-feedback">{{ errors.password }}</div>
        </div>
      <div class="container text-center" id="buttons">
        <button class="btn btn-primary" type="submit">Login</button>
        <button class="btn btn-secondary" v-on:click="this.$router.push('/registration')">Go To Registration</button>
      </div>
    </Form>
  </div>
</template>

<!--
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
  components: {
    Form,
    Field,
  },
  data() {
    const schema = Yup.object().shape({ //nie wiem czy tego nie zrobic w setup
      username: Yup.string()
          .required('Username is required'),
      password: Yup.string()
          .min(5, 'Password must be at least 5 characters')
          .required('Password is required'),
    });
    return {
      user: new User('',''),
      schema,
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
    login: function () {
      if (this.user.username && this.user.password) {
        store.dispatch('auth/login', this.user).then(
            () => {
              this.$router.push('/home');
            },
        );
      }
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
