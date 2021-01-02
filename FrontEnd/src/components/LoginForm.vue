<template>
<!--  walidacja wprowadzanych za pomoca Form i Field z vee-validate, nizej linki do dokumentacji-->
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
        <button class="btn btn-primary btn-sm" type="submit" id="loginBtn">Login</button>
        <button class="btn btn-secondary" v-on:click="this.$router.push('/registration')">Go To Registration</button>
      </div>
    </Form>
    <div class="form-group">
      <div v-if="message" class="alert alert-danger" role="alert">{{message}}</div>
    </div>
  </div>
</template>

<!--
  https://vee-validate.logaretm.com/v4/  https://vee-validate.logaretm.com/v4/examples/checkboxes-and-radio
  https://jasonwatmore.com/post/2020/10/01/vue-3-veevalidate-form-validation-example -->
<script>
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
    const schema = Yup.object().shape({ //nie wiem czy tego nie zrobic w setup() zamiast w data()
      username: Yup.string() // za pomoca biblioteki yup wyswietlamy errory dot. wprowadzanych danych
          .required('Username is required'),
      password: Yup.string()
          .required('Password is required'),
    });
    return {
      user: new User('',''), // tu tylko username i password usera
      schema,
      message: ''
    };
  },
  computed: {
    loggedIn() {
      return store.state.auth.status.loggedIn;
    }
  },
  created() {
    if (this.loggedIn) { // jesli zalogowany to przekierowujemy do /home
      this.$router.push("/home");
    }
  },
  methods: {
    login: function () { // funkcja do logowania
      if (this.user.username && this.user.password) {
        store.dispatch('auth/login', this.user).then(
            () => {
              this.$router.push('/home');
            },
            error => {         // do wyswietlania errorow przy blednych danych, na razie po prostu wyswietla fragment
              this.message =   // HTMLa (kod 401 - Unauthorized)
                  (error.response && error.response.data) ||
                  error.message ||
                  error.toString();
            }
        );
      }
    }
  }
};
</script>

<style scoped>
h2 {
  font-weight: bold;
  margin-bottom: 30px;
}

#login {
  width: 25%;
  margin: 150px auto auto;
  border: 1px solid gray;
  border-radius: 10px;
  padding: 10px 30px;
  background: #dcdcdc;
}

#buttons > button {
  width: 60%;
  margin: 10px;
  text-align: center;
  border-radius: 10px;
  font-size: 15px;
  font-weight: bold;
}

#buttons > #loginBtn {
  background: #00abb7;
}
</style>
