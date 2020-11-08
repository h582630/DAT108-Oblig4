<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" />

<link rel="stylesheet" type="text/css" href=css/index.css>

<link rel="stylesheet" type="text/css" href=css/formController.css>


<title>Registration</title>
<script src="/js/FormController.js" defer></script>

</head>
<body>
	<div id="root">
	<form method="post" action="Registration" data-form>
			<div class="mainContainer">
			<h2 class="title">Registration</h2>
			
			<label class="container">
			<span>Fornavn:</span>
			<input type="text" name="fornavn" id="fornavn" value="" />
			</label>
			<font color="red">${ loginFirstName }</font>
			
			
			
		    <label class="container">
			<span>Etternavn:</span>
			<input type="text" name="etternavn" id="etternavn" value="" />
			</label>
			<font color="red">${ loginLastName }</font>
	
	
			<label class="container">
			<span>Mobil:</span>
			<input type="text" name="mobil" id="mobil" value="" />
			</label>
			<font color="red">${ loginPhone }</font>
		
			
			<label class="container">
			<span>Passord:</span>
			<input type="password" name="passord" id="passord" value="" />
			</label>
			<font color="red">${ loginPassword }</font>
	
			
			<label class="container">
			<span>Passord repetert:</span>
			<input type="password" name="passordRepetert" id="passordRepetert" value="" />
			</label>
			<font color="red">${ loginRepeatPass }</font>
			
			
			 <div class="container">
                <span>Kjønn:</span>
                <div>
                    <label>
                        <input type="radio" name="kjonn"
                               value="mann"/> mann
                    </label>
                    <label>
                        <input type="radio" name="gender"
                               value="kvinne"/>kvinne
                    </label>
                    		<font color="red">${ loginSex }</font>
                </div>
            </div>
			
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
			</div>
	
	</form>
	 <div class="modal-password modal" data-password>
        <div class="modal-content">
            <span> Passordkrav: Minst 6 tegn
            </span>
        </div>
        </div>
        </div>
        

</body>
</html>