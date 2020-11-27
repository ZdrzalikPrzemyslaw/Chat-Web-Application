<template>
		<div id="mainContainer" class="container-fluid">
			<div id="settingsIcon" class="d-flex justify-content-left">
				<button v-on:click="showMenu('.menu')" class="settings_btn btn">
					<i style="color: white;" class="fas fa-user-cog"></i>
				</button>
			</div>
			<div class="menu menu--active justify-content-left">
				<div>
                    <div class="row pl-sm-2">
                        <div class="col-sm-4 desc text-left">Imię i nazwisko</div>
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
                                <label for="name" class="col-form-label text-left col-md-4 desc">Imię</label>
                                <input v-model="name" type="text" id="name" class="form-control col-md-6 ml-md-2"/>
                            </div>
                            <div class="form-group form-row">
                                <label for="surname" class="col-form-label text-left col-md-4 desc">Nazwisko</label>
                                <input v-model="surname" type="text" id="surname" class="form-control col-md-6 ml-md-2"/>
                            </div>
                            <div class="text-right">
                                <input class="btn btn-primary" type="submit" value="Potwierdź"/>   
                            </div>    
						</form>
					</div>
				</div>
				<hr>
                <div>
                    <div class="row pl-sm-2">
                        <div class="col-sm-4 desc text-left">Login</div>
                        <div class="col-sm-6 text-left">{{login}}</div>
                        <div class="col-sm-1">
                            <button v-on:click="showMenu('.login-block')" class="pen-icon">
                                <i class="fas fa-pencil-alt pen-icon-color"></i>
                            </button>
                        </div>
                    </div>
					<div class="login-block menu--active">
						<form role="form">
                            <div class="form-group form-row">
                                <label for="login" class="col-form-label text-left col-md-4 desc">Nowy login</label>
                                <input type="text" id="login" class="form-control col-md-6 ml-md-2"/>
                            </div>
                            <div class="text-right">
                                <input class="btn btn-primary" type="submit" value="Potwierdź"/>   
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
                                <label for="email" class="col-form-label text-left col-md-4 desc">Nowy email</label>
                                <input type="email" id="email" class="form-control col-md-6 ml-md-2"/>
                            </div>
                            <div class="text-right">
                                <input class="btn btn-primary" type="submit" value="Potwierdź"/>   
                            </div>    
						</form>
					</div>
				</div>
                <hr>
					<div>Zmień hasło</div>
					<div style="display: none">
						<form>
							<input type="password" placeholder="Stare hasło"/>
							<input type="text" placeholder="Nowe hasło"/>
							<input type="text" placeholder="Powtórz nowe hasło" />
							<input type="checkbox" value="Pokaż haslo" />
							<input type="button" value="Potwierdź"/>
						</form>
					</div>
				</div>
			</div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
      return {
        name: 'Jacek',
        surname: 'Rogowski',
        login: 'Wrrrr',
        email: 'jacekrogowski1@p.lodz.pl'
      }
  },
  methods: {
      showMenu: function(managedClass) {
          const menuButton = document.querySelector(managedClass);
          menuButton.classList.toggle('menu--active');
      },
      confirmChange: function() {

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
