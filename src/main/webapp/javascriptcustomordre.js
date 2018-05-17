var modaltoolshed = document.getElementById('customordrertoolshed');


var btn_toolshed = document.getElementById("toolshed");

btn_toolshed.onclick = function (event){
    event.preventDefault();
    if(modaltoolshed.style.display === "block"){
     modaltoolshed.style.display = "none";   
    } else {
    modaltoolshed.style.display = "block";
    }
    
    
}

