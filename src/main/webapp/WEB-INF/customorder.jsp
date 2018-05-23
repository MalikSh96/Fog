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
    </head>
    <body>


        <%@include file="../navigation/menu.jsp" %>
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

                <br/> 
                <input id="orderSubmit" type="submit" value="Order">
            </div>
            <div>
                * Hvis du f.eks. har valgt en carport med målene 240x360 cm kan redskabsrummet maksimalt måle 210x330 cm.

            </div>
        </form> 


        
        
        <script src="./javascriptcustomordre.js" type="text/javascript"></script>

    </body>
</html>
