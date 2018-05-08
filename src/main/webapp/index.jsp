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
    </head>
    <body>       

        <%@include file="navigation/menu.jsp" %>




        <table class="loginregister">
            <tr>
                <td colspan="3">
                    <% String error = (String) request.getAttribute( "error");
           if ( error != null) { %>
                    <H2>Error!!</h2>
                    <p><%= error %>
                        <% }
                        %>   
                </td>
            </tr>
        </table>






    </body>
</html>
