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
        <%@include file="../navigation/menu.jsp" %>
        <h1>Login</h1>
        
        <table>
            <tr><td>Login</td>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input type="text" name="email" value="" placeholder="Email">
                        <br>
                        Password:<br>
                        <input type="password" name="password" value="" placeholder="Password">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>                
            </tr>
        </table>
        
        <a href="FrontController?command=help">Need help? Press here!</a>


        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { %>
           <H2>Error!!</h2>
           <p><%= error %>
        <% }
        %>    
    </body>
</html>
