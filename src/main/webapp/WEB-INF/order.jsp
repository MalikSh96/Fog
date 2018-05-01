<%-- 
    Document   : order
    Created on : 01-05-2018, 11:29:46
    Author     : Joklin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
    </head>
    <body>
        <h1>Order page</h1>


        <h2>Din ordre blev gennemført!</h2><br>

        <table border="1">
            <tr>
                <th><p>Længde</th>
                <th><p>Vidde</th>
                <th><p>Højde</th>
            </tr>
            <tr>
                <td><p><%out.print(session.getAttribute("længde")); %></td>
                <td><p><%out.print(session.getAttribute("vidde")); %></td>
                <td><p><%out.print(session.getAttribute("højde"));%></td>


            </tr>
        </table>



    </body>
</html>
