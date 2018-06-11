<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordrebestilling</title>

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

                <div  class="col-sm-4">
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
