<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custom Order</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
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
            <div>
                <label>Vælg Længde*</label><br>
                <input type="number" name="length" max="999" required value="240" min="240"/>
            </div>            
            <div>
                <label>Vælg Bredde*</label><br>
                <input type="number" name="width" max="999" required value="240" min="240"/>
            </div>            
            <div>
                <label> Vælg Højde</label><br><input type="number" name="height" max="250" required value="200" min="200"/>
            </div> 

            <% // int length = (int) session.getAttribute("længde");%> 
            <br/>
            <div>
                <label>Carport længde</label><br/>
                <select name="toolshedlength">
                    <option value="0">Ønske ikke redskabsrum</option>
                    <%//if(length > 459){ %><option value="160">160 cm</option> <%// }%>
                    <option value="170">170 cm</option>
                    <option value="180">180 cm</option>
                    <option value="190">190 cm</option>
                    <option value="200">200 cm</option>
                    <option value="210">210 cm</option>
                </select>              
            </div>
            <br/>
            <div>
                <label>Carport bredde</label><br/>
                <select name="toolshedwidth">
                    <option value="0">Ønske ikke redskabsrum</option>
                    <option value="150">160 cm</option>
                    <option value="160">160 cm</option>
                    <option value="170">170 cm</option>
                    <option value="180">180 cm</option>
                    <option value="190">190 cm</option>
                    <option value="200">200 cm</option>
                    <option value="210">210 cm</option>
                </select>
            </div>
            <div>
                <input type="submit" value="Order">
            </div>
            <div>
                * Hvis du f.eks. har valgt en carport med målene 240x360 cm kan redskabsrummet maksimalt måle 210x330 cm.
                
            </div>
            
        </form>
                    
    </body>
</html>
