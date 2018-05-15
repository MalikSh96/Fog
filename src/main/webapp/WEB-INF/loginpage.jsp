<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
        <table class="middle">
            <tr>
                <td>
                    <h1>Login</h1>
                </td>
            </tr>

            <tr>
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
            <tr>
                <td>
                    <br>

                    <a href="FrontController?command=registration">Opret bruger</a>


                    <% String error = (String) request.getAttribute("error");
                if (error != null) {%>
                    <H2>Error!!</h2>
                    <p><%= error%>
                        <% }
                        %>  
                </td>

            </tr>
        </table>
                
                <%@include file="../footer/footer.jsp" %>
    </body>
</html>
