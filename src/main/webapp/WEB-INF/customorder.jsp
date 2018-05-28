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
<<<<<<< HEAD
        <h1>Input order</h1>
        Med et specialudviklet computerprogram kan vi lynhurtigt udskrive en skitsetegning på
        <br>en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.
        <br><br>
        Ordre med Skitsetegning.
        <br><br>

        Udfyld nedenstående omhyggeligt og klik på "Ordre"<br>
        Felter markeret * SKAL udfyldes!<br><br>


        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="order">
            <div class="length">
                <label>Carport længde*</label><br>
                <select class="form-control" name="length">
                    <option value="240">Vælg længde</option>
                    <option value="240">240 cm</option>   
                    <option value="270">270 cm</option>
                    <option value="300">300 cm</option>   
                    <option value="330">330 cm</option>
                    <option value="360">360 cm</option>   
                    <option value="390">390 cm</option>
                    <option value="420">420 cm</option>   
                    <option value="450">450 cm</option>
                    <option value="480">480 cm</option>   
                    <option value="510">510 cm</option>
                    <option value="540">540 cm</option>   
                    <option value="570">570 cm</option>
                    <option value="600">600 cm</option>
                    <option value="630">630 cm</option>   
                    <option value="660">660 cm</option>
                    <option value="690">690 cm</option>   
                    <option value="720">720 cm</option>
                    <option value="750">750 cm</option>
                </select>

            </div>            
            <div class="width">
                <label>Carport bredde*</label><br>
                <select class="form-control" name="width">
                    <option value="240">Vælg bredde</option>
                    <option value="240">240 cm</option>   
                    <option value="270">270 cm</option>
                    <option value="300">300 cm</option>   
                    <option value="330">330 cm</option>
                    <option value="360">360 cm</option>   
                    <option value="390">390 cm</option>
                    <option value="420">420 cm</option>   
                    <option value="450">450 cm</option>
                    <option value="480">480 cm</option>   
                    <option value="510">510 cm</option>
                    <option value="540">540 cm</option>   
                    <option value="570">570 cm</option>
                    <option value="600">600 cm</option>
                    <option value="630">630 cm</option>   
                    <option value="660">660 cm</option>
                    <option value="690">690 cm</option>   
                    <option value="720">720 cm</option>
                    <option value="750">750 cm</option>
                </select>

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


            <button id="toolshed">Redskabsskur</button>  
            <br/>

            <div id="customordrertoolshed">
                <div>
                    <label>Redskabsskur længde</label><br/>
                    <select class="form-control" name="toolshedlength">
                        <option value="0">Ønsker ikke redskabsrum</option>
                        <option value="160">160 cm</option>
                        <option value="170">170 cm</option>
                        <option value="180">180 cm</option>
                        <option value="190">190 cm</option>
                        <option value="200">200 cm</option>
                        <option value="210">210 cm</option>
                        <option value="220">220 cm</option>
                        <option value="230">230 cm</option>
                        <option value="240">240 cm</option>

                    </select>
                </div>

                <br/>
                <div>
                    <label>Redskabsskur bredde</label><br/>
                    <select class="form-control" name="toolshedwidth">
                        <option value="0">Ønsker ikke redskabsrum</option>                 
                        <option value="160">160 cm</option>
                        <option value="170">170 cm</option>
                        <option value="180">180 cm</option>
                        <option value="190">190 cm</option>
                        <option value="200">200 cm</option>
                        <option value="210">210 cm</option>
                        <option value="220">220 cm</option>
                        <option value="230">230 cm</option>
                        <option value="240">240 cm</option>


                    </select>
                </div>
            </div>
            <div>
=======
        <div class="text-center">
            <h1>Input order</h1>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-4" >

>>>>>>> development

                    Med et specialudviklet computerprogram kan vi lynhurtigt udskrive en skitsetegning på
                    <br>en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.
                    <br><br>
                    Ordre med Skitsetegning.
                    <br><br>

                    Udfyld nedenstående omhyggeligt og klik på "Ordre"<br>
                    Felter markeret * SKAL udfyldes!<br><br>

                </div>
                <div  class="col-sm-4" >
                    <form name="shedForm" action="FrontController" method="POST" onsubmit="return validateshedform()">
                        <input type="hidden" name="command" value="order">
                        <div class="length">
                            <label>Carport længde i cm*</label><br>
                            <input type="number" class="form-control" name="length" placeholder="vælg længde" min="200" max="1000" required>


                        </div>            
                        <div class="width">
                            <label>Carport bredde i cm*</label><br>
                            <input type="number" class="form-control" name="width" placeholder="vælg bredde" min="200" max="1000" required>


                        </div>            
                        <div class="height">
                            <label> Carport højde</label><br>
                            <select class="form-control" name="height" required>
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
                    <input name="toolshed_checkbox" type="checkbox" id="toolshed" class="inputstl" onclick="shedToggler()"> Redskabsskur  
                    <br/>

                    <div id="customordrertoolshed">
                        <div>
                            <label>Redskabsskur længde</label><br/>
                            <select class="form-control" name="toolshedlength">
                                <option value="0">Ønske ikke redskabsrum</option>
                                <option value="160">160 cm</option>
                                <option value="170">170 cm</option>
                                <option value="180">180 cm</option>
                                <option value="190">190 cm</option>
                                <option value="200">200 cm</option>
                                <option value="210">210 cm</option>
                                <option value="220">220 cm</option>
                                <option value="230">230 cm</option>
                                <option value="240">240 cm</option>
                                <option value="250">250 cm</option>
                                <option value="260">260 cm</option>
                                <option value="270">270 cm</option>
                                <option value="280">280 cm</option>
                                <option value="290">290 cm</option>
                                <option value="300">300 cm</option>

                            </select>
                        </div>

                        <br/>
                        <div>
                            <label>Redskabsskur bredde</label><br/>
                            <select class="form-control" name="toolshedwidth">
                                <option value="0">Ønske ikke redskabsrum</option>                 
                                <option value="160">160 cm</option>
                                <option value="170">170 cm</option>
                                <option value="180">180 cm</option>
                                <option value="190">190 cm</option>
                                <option value="200">200 cm</option>
                                <option value="210">210 cm</option>
                                <option value="220">220 cm</option>
                                <option value="230">230 cm</option>
                                <option value="240">240 cm</option>
                                <option value="250">250 cm</option>
                                <option value="260">260 cm</option>
                                <option value="270">270 cm</option>
                                <option value="280">280 cm</option>
                                <option value="290">290 cm</option>
                                <option value="300">300 cm</option>

                            </select>

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
