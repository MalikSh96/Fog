function shedToggler() {

    var checkboxtoolshed = document.getElementById("toolshed");
    var modaltoolshed = document.getElementById('customordrertoolshed');



    if (checkboxtoolshed.checked == true) {
        modaltoolshed.style.display = "block";

    } else {
        modaltoolshed.style.display = "none";
    }
}

function validateshedform() {
    var checkboxtoolshed = document.getElementById("toolshed");
    var toolshedlength = document.forms["shedForm"]["toolshedlength"].value;
    var toolshedwidth = document.forms["shedForm"]["toolshedwidth"].value;
    if (checkboxtoolshed.checked == true) {
        if (toolshedlength == "" || toolshedlength < 100 || toolshedwidth == "" || toolshedwidth < 100) {
            alert("Du skal angive en længde og bredde på skuret på mindst 100");
            return false;
        }
    }
}




