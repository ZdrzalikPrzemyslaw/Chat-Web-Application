<template>
  <div id="registration">
    <h2>Register</h2>
    <Form @submit="register" :validation-schema="schema" v-slot="{ errors }">
      <div class="form-group sm-3">
        <label for="username">Username</label>
        <Field name="username" v-model="user.username" type="text" class="form-control sm-3" :class="{ 'is-invalid': errors.username }"/>
        <div class="invalid-feedback">{{ errors.username }}</div>
      </div>

      <div class="form-group sm-3">
        <label htmlFor="password">Password</label>
        <Field name="password" v-model="user.password" type="password" class="form-control sm-3" :class="{ 'is-invalid': errors.password }"/>
        <div class="invalid-feedback">{{ errors.password }}</div>
      </div>

      <div class="form-group sm-3">
        <label htmlFor="name">Name</label>
        <Field name="name" v-model="user.name" type="text" class="form-control sm-3" :class="{ 'is-invalid': errors.name }"/>
        <div class="invalid-feedback">{{ errors.name }}</div>
      </div>

      <div class="form-group sm-3">
        <label htmlFor="surname">Surname</label>
        <Field name="surname" v-model="user.surname" type="text" class="form-control sm-3" :class="{ 'is-invalid': errors.surname }"/>
        <div class="invalid-feedback">{{ errors.surname }}</div>
      </div>

      <div class="form-group sm-3">
        <label htmlFor="name">Email</label>
        <Field name="email" v-model="user.email" type="text" class="form-control sm-3" :class="{ 'is-invalid': errors.email }"/>
        <div class="invalid-feedback">{{ errors.email }}</div>
      </div>

      <div class="container text-center" id="buttons">
        <button class="btn btn-primary" type="submit">Register</button>
      </div>
    </Form>
  </div>
<!--  <div id="registration">-->
<!--    <h2>Register</h2>-->
<!--    <div class="form-group sm-3">-->
<!--      <label for="username">Username</label>-->
<!--      <input-->
<!--        type="text"-->
<!--        v-model="username"-->
<!--        name="username"-->
<!--        class="form-control sm-3"-->
<!--      />-->
<!--      <div v-show="submitted && !username" class="invalid-feedback">-->
<!--        Username is required-->
<!--      </div>-->
<!--    </div>-->

<!--    <div class="form-group sm-3">-->
<!--      <label htmlFor="password">Password</label>-->
<!--      <input-->
<!--        type="password"-->
<!--        v-model="password"-->
<!--        name="password"-->
<!--        class="form-control sm-3"-->
<!--        :class="{ 'is-invalid': submitted && !password }"-->
<!--      />-->
<!--      <div v-show="submitted && !password" class="invalid-feedback">-->
<!--        Password is required-->
<!--      </div>-->
<!--    </div>-->

<!--    <div class="form-group sm-3">-->
<!--      <label htmlFor="name">Name</label>-->
<!--      <input-->
<!--        type="text"-->
<!--        v-model="name"-->
<!--        name="name"-->
<!--        class="form-control sm-3"-->
<!--        :class="{ 'is-invalid': submitted && !name }"-->
<!--      />-->
<!--      <div v-show="submitted && !name" class="invalid-feedback">-->
<!--        Name is required-->
<!--      </div>-->
<!--    </div>-->

<!--    <div class="form-group sm-3">-->
<!--      <label htmlFor="surname">Surname</label>-->
<!--      <input-->
<!--        type="text"-->
<!--        v-model="surname"-->
<!--        name="surname"-->
<!--        class="form-control sm-3"-->
<!--        :class="{ 'is-invalid': submitted && !surname }"-->
<!--      />-->
<!--      <div v-show="submitted && !surname" class="invalid-feedback">-->
<!--        Surname is required-->
<!--      </div>-->
<!--    </div>-->

<!--    <div class="form-group sm-3">-->
<!--      <label htmlFor="email">Email</label>-->
<!--      <input-->
<!--        type="text"-->
<!--        v-model="email"-->
<!--        name="email"-->
<!--        class="form-control sm-3"-->
<!--        :class="{ 'is-invalid': submitted && !email }"-->
<!--      />-->
<!--      <div v-show="submitted && !email" class="invalid-feedback">-->
<!--        Email is required-->
<!--      </div>-->
<!--    </div>-->

<!--      <button class="btn btn-primary" v-on:click="this.register">-->
<!--        Register-->
<!--      </button>-->
<!--  </div>-->
</template>

<script>
import axios from "axios";
import User from '../models/user';
//import store from '../store/index';
import { Form, Field } from 'vee-validate';
import * as Yup from 'yup';

export default {
  name: "RegistrationForm",
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
      name: Yup.string()
          .required('Firstname is required'),
      surname: Yup.string()
          .required('Surname is required'),
      email: Yup.string()
          .required('Email is required')
          .email('Email is invalid'),

    });
    return {
      user: new User("","","","",""),
      // username: "",
      // password: "",
      // name: "",
      // surname: "",
      // email: "",
      // submitted: false,
      schema
    };
  },
  methods: {
    register: function() {
      let self = this;
      axios
        .post(process.env.VUE_APP_BACKEND_URL + "/registration", {
            username: self.user.username,
            password: self.user.password,
            name: self.user.name,
            surname: self.user.surname,
            email: self.user.email
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
