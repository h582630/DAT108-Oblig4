<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" />

<link rel="stylesheet" type="text/css" href=css/index.css>

<title>Registration</title>
<script src="js/FormController.js" defer></script>
</head>
<body>
	<h2>Påmelding</h2>
	<form action="Registration" method="post" id="root" class="pure-form pure-form-aligned">
			<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> 
				<input id="fornavnInput" type="text" name="fornavn" value="" fornavn-input/> 
					<font color="red">${ loginFirstName }</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> 
				<input type="text" name="etternavn" value="" etternavn-input/> 
					<font color="red">${ loginLastName }</font>
						</div>
						
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> 
				<input type="text" name="mobil" value="" mobil-input/> 
				<div id="myModal" class="modal">
						<div class="modal-content">
							<p>Passordstyrke regnes ut i fra lengden på passordet. 
							Passord må være minst 6 karakterer langt.
							</p>
						</div>
					</div>
					<font color="red">${ loginPhone }</font>
			</div>
			
			<div class="pure-control-group">
				<label for="password">Passord:</label> 
				<input type="password" name="passord" value="" passord-input/> 
					<font color="red">${ loginPassword }</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> 
				<input type="password" name="passordRepetert" value="" passrepetert-input/> 
					<font color="red">${ loginRepeatPass }</font>
			</div>
			
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann" 
					 />mann
				<input type="radio" name="kjonn" value="kvinne" 
					 />kvinne
				<font color="red"></font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
		</form>
</body>
</html>