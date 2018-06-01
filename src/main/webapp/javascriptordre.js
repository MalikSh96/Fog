var modelbirdview = document.getElementById('myFogSVGbirdseye');
var modelsideview = document.getElementById('myFogSVGsideview');



var btn_birds_eye = document.getElementById("myBtnbirdseye");
var btn_side_view = document.getElementById("myBtnsideview");




var span_birds_eye = document.getElementsByClassName("close")[0];
var span_side_view = document.getElementsByClassName("closeone")[0];



btn_birds_eye.onclick = function () {
    modelbirdview.style.display = "block";
    modelsideview.style.display = "none";
}

btn_side_view.onclick = function () {
    modelsideview.style.display = "block";
    modelbirdview.style.display = "none";
}


span_birds_eye.onclick = function () {
    modelbirdview.style.display = "none";
}

span_side_view.onclick = function () {
    modelsideview.style.display = "none";
}





window.onclick = function (event) {
    if (event.target == modelbirdview) {
        modelbirdview.style.display = "none";

    }
}

window.onclick = function (eventone) {
    if (eventone.target == modelsideview) {
        modelsideview.style.display = "none";

    }
}




