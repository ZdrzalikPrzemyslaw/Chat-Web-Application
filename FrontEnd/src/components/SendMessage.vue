<template>
  <div class="container" id="main_container">
    <form class="row" id="inputWithButton">
      <div class="col-md-10" id="textarea">
        <textarea
          class="form-control"
          placeholder="Type your message..."
          rows="3"
          v-model="this.inputTextMessage"
        ></textarea>
      </div>
      <div class="col-md-2" id="sendButton">
        <button
          type="button"
          class="btn btn-primary"
          v-on:click="sendMessage()"
        >
          Send
        </button>
      </div>
    </form>
  </div>
</template>


<script>
import axios from "axios";
import authHeader from "../services/auth-header";

export default {
  name: "ConversationView",
  props: {
    chatId: Number,
  },
  data() {
    return {
      inputTextMessage: "",
    };
  },

  methods: {
    sendMessage() {
      let self = this;
      const params = new URLSearchParams({
        chatId: self.chatId,
      }).toString();

      axios
        .put(
          process.env.VUE_APP_BACKEND_URL + "/chat/message" + "?" + params,
          { text: self.inputTextMessage },
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
.container {
  border: 2px solid rgb(97, 95, 95);
  background-color: #f1f1f1;
  border-radius: 20px;
  padding: 15px;
  margin: 5px 0px;
}

#inputWithButton {
  margin-top: 15px;
  padding: 5px;
}
</style>
