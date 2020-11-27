<template>
		<div id="mainContainer" class="container-fluid">
			<div id="settingsIcon">
				<button onclick="document.getElementById('menu').style.display = 'block'" style="background: #9C35F2;" class="settings_btn btn">
					<i style="color: white;" class="fas fa-user-cog"></i>
				</button>
			</div>
			<div id="menu">
				<div>
					<div class="desc">Imię i nazwisko</div>
					<div class="desc1">Kamil Kiszko-Zgierski</div>
					<div class="desc2">
						<button style="border: none; background-color: #D1B5E8; cursor: pointer;">
							<i class="fas fa-pencil-alt pen-icon-color"></i>
						</button>
					</div>
						<div style="display: none" id="myDialog">
							<form>
                                <div class="form-group">
                                    <label>Imię</label>
                                    <input type="text"/>
                                    <label>Nazwisko</label>
                                    <input type="text"/>
                                    <input type="button" value="Potwierdź"/>
                                </div>
							</form>
						</div>
				</div>
					<hr>
					<div class="desc">Login</div>
					<div class="desc1">Kamil99125</div>
					<div class="desc2">
						<button onclick="document.getElementById('myDialog1').style.display = 'block'" style="border: none; background-color: #D1B5E8; cursor: pointer; color: orange;">
							<i class="fas fa-pencil-alt pen-icon-color"></i>
						</button>
					</div>
					<div style="display: none" id="myDialog1">
						<form>
                            <div class="form-group row">
                                <label for="login" class="col-form-label col-sm-4">Nowy login</label>
                                <input type="text" id="login" class="form-control col-sm-5 md-sm-5 col-12"/>
                                <input class="btn btn-primary col-sm-3 md-sm-5 col-12" type="button" value="Potwierdź"/>
                            </div>
						</form>
					</div>
					<hr>
					<div class="desc">Email</div>
					<div class="desc1">kamilkiszkozgierski@gmail.com</div>
					<div class="desc2">
						<button style="border: none; background-color: #D1B5E8; cursor: pointer; color: orange;">
							<i class="fas fa-pencil-alt pen-icon-color"></i>
						</button>
					</div>
					<div style="display: none" id="myDialog1">
						<form>
							<label>Nowy email</label>
							<input type="text"/>
							<input type="button" value="Potwierdź"/>
						</form>
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

      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css");
 .settings_btn {
  background-color: DodgerBlue; /* Blue background */
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 10px;
  font-size: 22px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
  margin-bottom: 0px;
}

#menu {
	position: absolute;
	display: none;
	margin: 0;
	background-color: #D1B5E8;
	width: 420px;
	padding: 10px;
    z-index: 1000;
}
.desc {
	width: 130px;
	font-weight: 700;
	display: inline-block;
    text-align: left;
    margin: 0;
    padding: 0;
}
.desc1 {
	width: 230px;
	display: inline-block;
    text-align: left;
}
.desc2 {
	width: 20px;
	display: inline-block;
}
.pen_icon {
    border: none; 
    background-color: #D1B5E8; 
    cursor: pointer;
}
.pen-icon-color {
    color: #9C35F2;
}
</style>
