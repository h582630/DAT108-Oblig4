let rootEl = document.getElementById("root");
let fornavnInput = rootEl.querySelector('input[fornavn-input]');
let etternavnInput = rootEl.querySelector('input[etternavn-input]');
let mobilInput = rootEl.querySelector('input[mobil-input]');
let passordInput = rootEl.querySelector('input[passord-input]');
let passRepInput = rootEl.querySelector('input[passrepetert-input]');
let modal = document.getElementById("myModal");

rootEl.addEventListener("submit", handleSubmit);

function handleSubmit(event) {
	if (!isValid()) {
		if (confirm("Noen av feltene er feil, fortsette?")) {
            return true;
        } else {
			event.preventDefault();
	        return false;
        }         
	}
}

window.onload = () => {
    validate(fornavnInput);
    validate(etternavnInput);
    uvalidatePhone(mobilInput);
    passwordStrength(passordInpt);
    samePassword(passRepInput, passordInput);
};
fornavnInput.addEventListener("input", () => {
    validate(fornavnInput);
});

etternavnInput.addEventListener("input", () => {
    validate(etternavnInput);
});

mobilInput.addEventListener("input", () => {
    validatePhone(mobilInput);
});

passordInput.addEventListener("input", () => {
    passwordStrength(passordInput);
    samePassword(passRepInput, passordInput);
});


passordInput.addEventListener("mouseover", function() {
    modal.style.display = "block";
  })
passordInput.addEventListener("mouseout", function() {
    modal.style.display = "none";
  })

passRepInput.addEventListener("input", () => {
    samePassword(passRepInput, passordInput);
});

function validate(e) {
    if (e.value === "" || e.value.length < 2) {
        e.classList.remove("validStyle");
        e.classList.add("errorStyle");
        return false;
    } else {
        e.classList.remove("errorStyle");
        e.classList.add("validStyle")
        return true;
    }
}

function validatePhone(e) {
    if (e.value === "" || e.value.length < 8 || e.value.length > 8) {
        e.classList.remove("validStyle");
        e.classList.add("errorStyle");
        return false;
    } else {
        e.classList.remove("errorStyle");
        e.classList.add("validStyle")
        return true;
    }
}

function passwordStrength(e) {
    if (e.value === "" || e.value.length < 6) {
        e.classList.remove("validStyle");
        e.classList.remove("mediumStyle");
        e.classList.add("errorStyle");
        return false;
    } else if (e.value.length < 10){
        e.classList.remove("validStyle");
        e.classList.remove("errorStyle");
        e.classList.add("mediumStyle");
        return true;
    } else {
        e.classList.remove("errorStyle");
        e.classList.remove("mediumStyle");
        e.classList.add("validStyle");
        return true;
    }
}

function samePassword(e1, e2) {
    if (e1.value === "") {
        e1.classList.remove("validStyle");
        e1.classList.add("errorStyle");
        return false;
    } else if (e1.value === e2.value) {
        e1.classList.add("validStyle");
        e1.classList.remove("errorStyle");
        return true;
    } else {
        e1.classList.remove("validStyle");
        e1.classList.add("errorStyle");
        return false;
    }
}

function isValid() {
    return validate(fornavnInput) && validate(etternavnInput) && validatePhone(mobilInput) && passwordStrength(passordInput) && samePassword(passRepInput, passordInput);
}


