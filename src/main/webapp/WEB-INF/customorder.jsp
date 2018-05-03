<%-- 
    Document   : customorder
    Created on : 02-05-2018, 12:44:54
    Author     : Joklin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <%@include file="../navigation/menu.jsp" %>
        <h1>Input order</h1>
        
                This is where you will input order

        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="order">
            <div class="height">
                <label> Length</label><input type="number" name="length" max="99" required value="1"/>
            </div>            
            <div class="length">
                <label> Width</label><input type="number" name="width" max="999" required value="1"/>
            </div>            
            <div class="width">
                <label> Height</label><input type="number" name="height" max="999" required value="1"/>
            </div>                        
                <input type="submit" value="Order">
            </form>
    </body>
</html>
