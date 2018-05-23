function myFunction() {

    var checkboxtoolshed = document.getElementById("toolshed");
    var modaltoolshed = document.getElementById('customordrertoolshed');



    if (checkboxtoolshed.checked == true) {
        modaltoolshed.style.display = "block";

    } else {
        modaltoolshed.style.display = "none";
    }
}



