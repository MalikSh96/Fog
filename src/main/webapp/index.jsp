<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>       
        <%@include file="/navigation/menu.jsp" %>

        <div class="indexheading">
            <h1>FOG TRÆLAST & BYGGECENTER</h1>
<h1>VELKOMMEN TIL QUICK–SELVBYG CARPORTE.</h1>
        </div>
<div class="indextext">
<p>På denne side kan du selv tilpasse 
din carport og redskabsskur med dine specifikke ønsker om størrelse. </p>
        </div>
        <div class="indeximagefuglpersketiv">
            <img src="Image/fuglpersketiv.png" class="indexsrc"/>
            
        </div>
        <div class="indeximagesidepersketiv">
            <img src="Image/sidepersketiv.png" class="indexsrc"/>
            
        </div>
        
        <%@include file="/footer/footer.jsp" %>



    </body>
</html>
