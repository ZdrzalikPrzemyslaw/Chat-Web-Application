<template>
<div class=".container-fluid">
  <div class="row">
    <div class="col-2">
      <Search/>
      <ChatsList/>
    </div>
     <div class="col-1">
    </div>
    <div class="col-9">
      <ConversationView/>
    </div>
  </div>
</div>


  
  
</template>

<script>
import ChatsList from "../components/ChatsList";
import ConversationView from "../components/ConversationView"
import Search from "../components/Search"
export default {
  name: 'Home',
  components: {
    ChatsList,
    ConversationView,
    Search
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  width: 100%;
}
.container *{
  width: 100%;
  table-layout: fixed;
}
/* ChatsList{
  width:15%;
  float: left;
}
ConversationView{
  width: 75%;
  float: right;
} */
</style>