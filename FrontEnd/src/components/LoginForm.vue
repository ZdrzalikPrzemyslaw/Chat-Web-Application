<template>
  <div id="login">
    <h2>Login</h2>
    <form @submit.prevent="handleSubmit">
      <div class="form-group sm-3">
        <label for="username">Username</label>
        <input
          type="text"
          v-model="username"
          name="username"
          class="form-control mx-sm-3"
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
          class="form-control mx-sm-3"
          :class="{ 'is-invalid': submitted && !password }"
        />
        <div v-show="submitted && !password" class="invalid-feedback">
          Password is required
        </div>
      </div>
      <div class="form-group">
        <button class="btn btn-primary" v-on:click="this.$router.push('/')">Login</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "LoginForm",
  data() {
    return {
      username: "",
      password: "",
      submitted: false,
    };
  },
};
</script>

<style scoped>
#login {
  width: 20%;
}
</style>
