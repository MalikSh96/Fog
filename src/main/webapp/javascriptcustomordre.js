var modaltoolshed = document.getElementById('customordrertoolshed');


var btn_toolshed = document.getElementById("toolshed");


btn_toolshed.onclick = function (event) {
    event.preventDefault();
    if (modaltoolshed.style.display === "block") {
        modaltoolshed.style.display = "none";
    } else {
        modaltoolshed.style.display = "block";
    }
}

var btn_orderSubmit = document.getElementById('orderSubmit');

var user = '<%(User) session.getAttribute("user"); %>';

btn_orderSubmit.onclick = function () {
    if (user !== null) {
        alert("Du skal logge ind for at lave en ordre!");
    }

}




