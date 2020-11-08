"use strict";

class FormController {
    constructor(root) {
        this.root = root;
        this.run = this.run.bind(this);
    }

    /**
     * @public
     */
    run() {
        this.rootElement = document.getElementById(this.root);
        this.setupInput();
     
    }

    /**
     * @private
     */
    setupInput() {
        this.inputs = this.rootElement.getElementsByTagName("input")
        for (let input of this.inputs) {
            if (input.name === "fornavn") {
                validate(input, /^[A-ZÃ†Ã˜Ã…][a-zÃ¦Ã¸Ã¥A-zÃ†Ã˜Ã…\- ]{1,19}$/g);
                input.oninput = (() => {
                    validate(input, /^[A-ZÃ†Ã˜Ã…][a-zÃ¦Ã¸Ã¥A-zÃ†Ã˜Ã…\- ]{1,19}$/g);
                })
           
            } else if (input.name === "etternavn") {
                validate(input, /^[A-ZÃ†Ã˜Ã…][a-zÃ¦Ã¸Ã¥A-zÃ†Ã˜Ã…\-]{1,19}$/g);
                input.oninput = (() => {
                    validate(input, /^[A-ZÃ†Ã˜Ã…][a-zÃ¦Ã¸Ã¥A-zÃ†Ã˜Ã…\-]{1,19}$/g);
                })
                
            } else if (input.name === "mobil") {
                validate(input, /^[0-9]{8}$/g);
                input.oninput = (() => {
                    validate(input, /^[0-9]{8}$/g);
                })
            } else if (input.name === "passord") {
                validate(input);
                input.oninput = (() => {
                    validate(input);
                    validate(this.inputs.namedItem("passordRepetert"), input)
                })
                input.onmouseenter = (() => {
                    this.rootElement.querySelector("*[data-password]").style.display = "block";
                })
                input.onmouseleave = (() => {
                    this.rootElement.querySelector("*[data-password]").style.display = "none";
                })
            } else if (input.name === "passwordRepeat") {
                validate(input, this.inputs.namedItem("passord"));
                input.oninput = (() => {
                    validate(input, this.inputs.namedItem("passord"));
                })
            }
        }
    }
}

function validate(input, regex) {
    if (input.name === "password") {
        if (input.value === "") {
            input.classList.remove("formController_mediumPassword",
                "formController_strongPassword",
                "formController_weakPassword");

        } else {
            let strength = 0;
            if (/[\p{Ll}]+/gu.test(input.value)) strength++;

            if (/[\p{Lu}]+/gu.test(input.value)) strength++;

            if (/[\d]+/g.test(input.value)) strength++;

            if (/[^\d\p{L}]+/gu.test(input.value)) strength++;

            if (input.value.length >= 5) strength++;

            if (strength < 3) {
                input.classList.remove("formController_mediumPassword", "formController_strongPassword")
                input.classList.add("formController_weakPassword")
            } else if (strength < 5) {
                input.classList.remove("formController_strongPassword", "formController_weakPassword")
                input.classList.add("formController_mediumPassword")
            } else {
                input.classList.remove("formController_mediumPassword", "formController_weakPassword")
                input.classList.add("formController_strongPassword");
            }
        }

    } else if (input.name === "passwordRepeat") {
        if (input.value === "" || (regex.value === "" && input.value === "")) {
            input.classList.remove("formController_validInput", "formController_invalidInput");
        } else {
            if (input.value === regex.value) {
                input.classList.remove("formController_invalidInput");
                input.classList.add("formController_validInput")
            } else {
                input.classList.remove("formController_validInput");
                input.classList.add("formController_invalidInput");
            }
        }

    } else {
        if (input.value === "") input.classList.remove("formController_invalidInput", "formController_validInput");

        else if (regex.test(input.value)) {
            input.classList.remove("formController_invalidInput");
            input.classList.add("formController_validInput");
        } else {
            input.classList.remove("formController_validInput");
            input.classList.add("formController_invalidInput");
        }
    }
}

const form = new FormController("root");

document.addEventListener("DOMContentLoaded", form.run)

