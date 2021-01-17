<template>
  <div class=".container" id="main_container">
    <div v-for="user in users" v-bind:key="user">
      <div class="row" id="OneChat">
        <div class="col sm-3">
          <div class="row" id="UserName">
            {{ user.name }}
          </div>
          <div class="row" id="UserSurname">
            {{ user.surname }}
          </div>
        </div>
        <div class="col sm-3">
          <div class="row" id="but">
            <input
              type="button"
              id="but"
              class="btn btn-sm btn-block sm-3"
              value="+"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ChatsList",
  props: {
    users: Array,
    chatId: Number,
  },
  data() {
    return {};
  },
  created: function () {},
  methods: {},
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
}

#LastMessage {
  opacity: 0.9;
  margin-left: 5px;
}

#but {
  font-size: 45px;
}
</style>
