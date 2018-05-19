var modal = document.getElementById('myFogSVGbirdseye');
var modalone = document.getElementById('myFogSVGsideview');



var btn_birds_eye = document.getElementById("myBtnbirdseye");
var btn_side_view = document.getElementById("myBtnsideview");




var span_birds_eye = document.getElementsByClassName("close")[0];
var span_side_view = document.getElementsByClassName("closeone")[0];



btn_birds_eye.onclick = function () {
    modal.style.display = "block";
    modalone.style.display = "none";
}

btn_side_view.onclick = function () {
    modalone.style.display = "block";
    modal.style.display = "none";
}


span_birds_eye.onclick = function () {
    modal.style.display = "none";
}

span_side_view.onclick = function () {
    modalone.style.display = "none";
}





window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";

    }
}

window.onclick = function (eventone) {
    if (eventone.target == modalone) {
        modalone.style.display = "none";

    }
}




