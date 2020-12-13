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
					<div class="name-block menu--active pl-sm-2">
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
                    <div id="namesAlert" class="alert alert-box"></div> 
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
					<div class="login-block menu--active pl-sm-2">
						<form role="form">
                            <div class="form-group form-row">
                                <label for="login" class="col-form-label text-left col-md-4 desc">New username</label>
                                <input v-model="newUsername" type="text" id="login" class="form-control col-md-6 ml-md-2"/>
                            </div>
                            <div class="text-right">
                                <input v-on:click="changeUsername()" class="btn btn-primary" type="button" value="Submit"/>   
                            </div>    
						</form>
					</div>
                    <div id="usernameAlert" class="alert alert-box"></div> 
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
					<div class="email-block menu--active pl-sm-2">
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
                    <div id="emailAlert" class="alert alert-box"></div> 
				</div>
                <hr>
                <div>
                    <div class="row pl-sm-2">
                        <div class="col-sm-10 desc text-left">Password</div>
                        <div class="col-sm-1">
                            <button v-on:click="showMenu('.password-block')" class="pen-icon">
                                <i class="fas fa-pencil-alt pen-icon-color"></i>
                            </button>
                        </div>
                    </div>
					<div class="password-block menu--active mt-sm-3 pl-sm-2">
						<form role="form">
                            <div class="form-group form-row">
                                <label for="oldPassword" class="col-form-label text-left col-md-4 desc text-left">Old password</label>
                                <input v-model="oldPasswd" type="password" id="oldPassword" class="form-control col-md-6 ml-md-2" />
                            </div>
                            <div class="form-group form-row">
                                <label for="newPassword1" class="col-form-label text-left col-md-4 desc text-left">New password</label>
                                <input v-model="newPasswd1" type="password" id="newPassword1" class="form-control col-md-6 ml-md-2" />
                            </div>
                            <div class="form-group form-row">
                                <label for="newPassword2" class="col-form-label text-left col-md-4 desc text-left">Repeat new password</label>
                                <input v-model="newPasswd2" type="password" id="newPassword2" class="form-control col-md-6 ml-md-2" />
                            </div>
                            <div class="text-right mr-sm-3">
                                <input v-on:click="changePassword()" class="btn btn-primary" type="button" value="Submit"/>   
                            </div>    
						</form>
					</div>
                    <div id="passwordAlert" class="alert alert-box"></div> 
				</div>
			</div>
		</div>
</template>

<script>
import axios from "axios";
import $ from "jquery";

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
        newUsername: '',
        oldPasswd: '',
        newPasswd1: '',
        newPasswd2: ''
      }
  },
  methods: {
      showMenu: function(managedClass) {
          const menuButton = document.querySelector(managedClass);
          menuButton.classList.toggle('menu--active');
      },
      checkPassword: function(passwd1, passwd2) {
          if (passwd1 == passwd2) {
              return true;
          } else {
              return false;
          }
      },
      showAlertBox: function(id, type, message) {
        $(id).addClass(type);
        $(id).empty();
        $(id).append(message);
        $(id).show("slow").delay(5000).hide("slow");
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
          self.showAlertBox("#namesAlert", "alert-success", "Name and surname updated successfully");
        })
        .catch(function(error) {
          console.log(error.response);
          self.newName = self.name;
          self.newSurname = self.surname;
          self.showAlertBox("#namesAlert", "alert-danger", "Unable to update name and surname");
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
          self.showAlertBox("#emailAlert", "alert-success", "Email updated successfully");
        })
        .catch(function(error) {
          console.log(error.response);
          self.newEmail = '';
          self.showAlertBox("#emailAlert", "alert-danger", "Unable to update email");
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
          self.showAlertBox("#usernameAlert", "alert-success", "Username updated successfully");
        })
        .catch(function(error) {
          console.log(error.response);
          self.newUsername = '';
          self.showAlertBox("#usernameAlert", "alert-danger", "Unable to update username");
        });
      },
      changePassword: function() {
          let self = this;
          if (self.checkPassword(self.newPasswd1, self.newPasswd2)) {
            self.showAlertBox("#passwordAlert", "alert-success", "Password updated successfully");
          } else {
            self.showAlertBox("#passwordAlert", "alert-danger", "Passwords are different");
          }
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

.menu--active, .alert-box {
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
