function myFunction() {

    var modaltoolshed = document.getElementById('customordrertoolshed');
    var checkboxtoolshed = document.getElementById("toolshed");


//checkboxtoolshed.onclick = function (event) {
//    event.preventDefault();
//    if (modaltoolshed.style.display === "block") {
//        modaltoolshed.style.display = "none";
//    } else {
//        modaltoolshed.style.display = "block";
//    }
//}

    if (checkboxtoolshed.checked == true) {
        modaltoolshed.style.display = "block";

    } else {
        modaltoolshed.style.display = "none";
    }
}



