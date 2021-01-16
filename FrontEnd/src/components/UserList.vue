<template>
  <div class=".container" id="main_container">
    <div
      class="col sm-3"
      v-for="user in users"
      v-bind:key="user"
      id="OneChat"
    >
      <div class="row" id="UserName">
        {{ user.name }}
      </div>
      <div class="row" id="UserSurname">
        {{ user.surname }}
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "ChatsList",
  props: {
    users: Array,
  },
  data() {
    return {};
  },
  created: function() {
  },
  methods: {
  
  },
};
</script>

<style scoped>
#OneChat {
  padding: 20px;
  text-align: left;
  cursor: pointer;
  width: 100%;
  background: rgba(245, 245, 245, 0.5);
  margin: 10px 5px 5px 50px;
  border-radius: 10px;
  color: black;
}

#UserName {
  font-weight: bold;
  padding: 5px 0;
  margin-left: 5px;
}

#LastMessage {
  opacity: 0.9;
  margin-left: 5px;
}
</style>