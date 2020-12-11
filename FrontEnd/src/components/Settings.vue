<template>
		<div id="mainContainer" class="container-fluid">
			<div id="settingsIcon" class="d-flex justify-content-right">
				<button v-on:click="showMenu('.menu')" class="settings_btn btn">
					<i style="color: white;" class="fas fa-user-cog"></i>
				</button>
			</div>
			<div class="menu menu--active justify-content-right">
				<div>
                    <div class="row pl-sm-2">
                        <div class="col-sm-4 desc text-left">Name and surname</div>
                        <div class="col-sm-6 text-left">{{name}} {{surname}}</div>
                        <div class="col-sm-1">
                            <button v-on:click="showMenu('.name-block')" class="pen-icon">
                                <i class="fas fa-pencil-alt pen-icon-color"></i>
                            </button>
                        </div>
                    </div>
					<div class="name-block menu--active">
						<form role="form">
                            <div class="form-group form-row">
                                <label for="name" class="col-form-label text-left col-md-4 desc">Name</label>
                                <input v-model="newName" type="text" id="name" class="form-control col-md-6 ml-md-2"/>
                            </div>
                            <div class="form-group form-row">
                                <label for="surname" class="col-form-label text-left col-md-4 desc">Surname</label>
                                <input v-model="newSurname" type="text" id="surname" class="form-control col-md-6 ml-md-2"/>
                            </div>
                            <div class="text-right">
                                <input v-on:click="changeNames()" class="btn btn-primary" type="button" value="Submit"/>   
                            </div>    
						</form>
					</div>
				</div>
				<hr>
                <div>
                    <div class="row pl-sm-2">
                        <div class="col-sm-4 desc text-left">Username</div>
                        <div class="col-sm-6 text-left">{{username}}</div>
                        <div class="col-sm-1">
                            <button v-on:click="showMenu('.login-block')" class="pen-icon">
                                <i class="fas fa-pencil-alt pen-icon-color"></i>
                            </button>
                        </div>
                    </div>
					<div class="login-block menu--active">
						<form role="form">
                            <div class="form-group form-row">
                                <label for="login" class="col-form-label text-left col-md-4 desc">New login</label>
                                <input v-model="newUsername" type="text" id="login" class="form-control col-md-6 ml-md-2"/>
                            </div>
                            <div class="text-right">
                                <input v-on:click="changeUsername()" class="btn btn-primary" type="button" value="Submit"/>   
                            </div>    
						</form>
					</div>
                </div>    
				<hr>
                <div>
                    <div class="row pl-sm-2">
                        <div class="col-sm-4 desc text-left">Email</div>
                        <div class="col-sm-6 text-left">{{email}}</div>
                        <div class="col-sm-1">
                            <button v-on:click="showMenu('.email-block')" class="pen-icon">
                                <i class="fas fa-pencil-alt pen-icon-color"></i>
                            </button>
                        </div>
                    </div>
					<div class="email-block menu--active">
						<form role="form">
                            <div class="form-group form-row">
                                <label for="email" class="col-form-label text-left col-md-4 desc">New email</label>
                                <input v-model="newEmail" type="email" id="email" class="form-control col-md-6 ml-md-2" />
                            </div>
                            <div class="text-right">
                                <input v-on:click="changeEmail()" class="btn btn-primary" type="button" value="Submit"/>   
                            </div>    
						</form>
					</div>
				</div>
                <hr>
					<div>Change password</div>
					<div style="display: none">
						<form>
							<input type="password" placeholder="Old password"/>
							<input type="text" placeholder="New password"/>
							<input type="text" placeholder="Repeat new password" />
							<input type="checkbox" value="Show password" />
							<input type="button" value="Submit"/>
						</form>
					</div>
				</div>
			</div>
</template>

<script>
import axios from "axios";

export default {
  data() {
      return {
        name: 'Jan',
        surname: 'Nowak',
        username: 'JanLogin',
        email: 'jannowak@p.lodz.pl',
        newName: 'Jan',
        newSurname: 'Nowak',
        newEmail: '',
        newUsername: ''
      }
  },
  methods: {
      showMenu: function(managedClass) {
          const menuButton = document.querySelector(managedClass);
          menuButton.classList.toggle('menu--active');
      },
      changeNames: function() {
        let self = this;
        axios
        .post(process.env.VUE_APP_BACKEND_URL + '/update/names', {
            username: self.username,
            newName: self.newName,
            newSurname: self.newSurname
        })
        .then(function(response) {
          console.log(response.data);
          self.name = self.newName;
          self.surname = self.newSurname;
        })
        .catch(function(error) {
          console.log(error.response);
          self.newName = self.name;
          self.newSurname = self.surname;
        });
      },
      changeEmail: function() {
        let self = this;
        axios
        .post(process.env.VUE_APP_BACKEND_URL + '/update/email', {
            username: self.username,
            email: self.newEmail
        })
        .then(function(response) {
          console.log(response.data);
          self.email = self.newEmail;
          self.newEmail = '';
        })
        .catch(function(error) {
          console.log(error.response);
          self.newEmail = '';
        });
      },
      changeUsername: function() {
        let self = this;
        axios
        .post(process.env.VUE_APP_BACKEND_URL + '/update/username', {
            username: self.username,
            newUsername: self.newUsername
        })
        .then(function(response) {
          console.log(response.data);
          self.username = self.newUsername;
          self.newUsername = '';
        })
        .catch(function(error) {
          console.log(error.response);
          self.newUsername = '';
        });
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css");
 .settings_btn {
  background-color: #9C35F2;
  border: none; 
  color: white; 
  padding: 10px;
  font-size: 22px; 
  cursor: pointer; 
  margin: 0; 
}

.menu {
	position: absolute;
	background-color: #D1B5E8;
	width: 420px;
	padding: 10px;
    z-index: 1000;
}

.name-block, .login-block, .email-block {
    padding: 10px;
}

.menu--active {
    display: none;
}

.desc {
	font-weight: 700;
}

.pen-icon {
    border: none; 
    background-color: #D1B5E8; 
    cursor: pointer;
}
.pen-icon-color {
    color: #9C35F2;
}
</style>
