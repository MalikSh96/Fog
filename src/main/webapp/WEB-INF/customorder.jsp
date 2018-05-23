<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custom Order</title>

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
        <div class="text-center">
            <h1>Input order</h1>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-4" >


                    Med et specialudviklet computerprogram kan vi lynhurtigt udskrive en skitsetegning på
                    <br>en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.
                    <br><br>
                    Ordre med Skitsetegning.
                    <br><br>

                    Udfyld nedenstående omhyggeligt og klik på "Ordre"<br>
                    Felter markeret * SKAL udfyldes!<br><br>

                </div>
                <div  class="col-sm-4" >
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="order">
                        <div class="length">
                            <label>Carport længde i cm*</label><br>
                            <input type="number" class="form-control" name="length" placeholder="vælg længde" min="0">


                        </div>            
                        <div class="width">
                            <label>Carport bredde i cm*</label><br>
                            <input type="number" class="form-control" name="width" placeholder="vælg bredde">


                        </div>            
                        <div class="height">
                            <label> Carport højde</label><br>
                            <select class="form-control" name="height">
                                <option value="200">Vælg højde</option>
                                <option value="200">200 cm</option>   
                                <option value="210">210 cm</option>
                                <option value="220">220 cm</option>   
                                <option value="230">230 cm</option>
                                <option value="240">240 cm</option>   
                                <option value="250">250 cm</option>
                            </select>
                        </div> 
                        <br/> 
                </div>
                <div class="col-sm-4">
                    <input type="checkbox" id="toolshed" class="inputstl" onclick="shedToggler()"> Redskabsskur  
                    <br/>

                    <div id="customordrertoolshed">
                        <div>
                            <label>Redskabsskur længde</label><br/>
                            <input type="number" value="0"class="form-control" name="toolshedlength" min="0">

                        </div>

                        <br/>
                        <div>
                            <label>Redskabsskur bredde</label><br/>
                            <input type="numbeer" value="0"  min="0" class="form-control" name="toolshedwidth">

                        </div>
                    </div>
                    <div>

                        <br/> 
                        <input id="orderSubmit" type="submit" value="Order">
                    </div>
                    <div>
                        * Hvis du f.eks. har valgt en carport med målene 240x360 cm kan redskabsrummet maksimalt måle 210x330 cm.

                    </div>
                    </form> 
                </div>
            </div>
        </div>

        <%@include file="../footer/footer.jsp" %>
        <script src="./javascriptcustomordre.js" type="text/javascript"></script>
    </body>
</html>
