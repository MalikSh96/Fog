<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordrebestilling</title>

        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetjavascript.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <style>
            input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none;
                margin: 0;
            }
            input[type=number] {
                -moz-appearance: textfield;
            }


        </style>
        <%@include file="../navigation/menu.jsp" %>                
        <div class="customordreheading">
            <h1>Bestil Carport</h1>
        </div>


        <div class="container">
            <div class="row">
                <div class="col-sm-4" >
                    Her kan du tilpasse din ordre efter dine specifikke ønsker og når du har placeret din ordre, kan du få 
                    udskrevet en skitsetegning af en carport. 
                    <br/><br/>Udfyld skemaet og klik på "Placèr Ordre"
                </div>
            </div>
            <div>
                <br>   <input type="submit" value="Order">

            </div>
            <div>
                * Hvis du f.eks. har valgt en carport med målene 240x360 cm kan redskabsrummet maksimalt måle 210x330 cm.

                <div  class="col-sm-4">
                    <form name="shedForm" action="FrontController" method="POST" onsubmit="return validateshedform()">
                        <input type="hidden" name="command" value="order">
                        <div class="length">
                            <label>Carport længde i cm*</label><br>
                            <input type="number" class="form-control" name="length" placeholder="vælg længde" min="400" max="999" required>


                        </div> 

                        <div class="width">
                            <label>Carport bredde i cm*</label><br>
                            <input type="number" class="form-control" name="width" placeholder="vælg bredde" min="300" max="800" required>


                        </div>            
                        <div class="height">
                            <label> Carport højde i cm*</label><br>
                            <input type="number" class="form-control" name="height" placeholder="vælg højde" min="180" max="210" required>

                        </div>  


                        <div>
                            Felter markeret * SKAL udfyldes!<br><br>
                        </div>                       
                        <div>

                            <br/> 
                            <input id="orderSubmit" type="submit" value="Placér Ordre">
                            <br/>
                            <br/>
                            <br/>
                            <br/>

                        </div>
                    </form>


                </div>
                <div class="col-sm-4">
                    <div class="customorderimgdiv">
                        <img src="Image/carcarport.png" class="customorderimg"/>
                    </div>
                </div>
            </div>
            <%@include file="../footer/footer.jsp" %>
            <script src="./javascriptcustomordre.js" type="text/javascript"></script>
    </body>
</html>
