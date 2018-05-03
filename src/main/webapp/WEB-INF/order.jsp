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
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="../navigation/menu.jsp" %>
        <h1>Order page</h1>


        <h3>Din ordre blev gennemført!</h3><br>

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

        <br>
        <br>
        <br>
        <br>


        <SVG width="780" height=600>
        <rect x="0" y="0" height="600" width="780"
              style = "stroke: black; fill: none;" /> 
        <rect x="4" y="20" height="5" width="771"
              style = "stroke: black; fill: none;" />
        <rect x="4" y="580" height="5" width="771"
              style = "stroke: black; fill: none;" />
        <rect x="0" y="0" height="600" width="4"
              style = "stroke: black; fill: none;" />
        <rect x="776" y="0" height="600" width="4"
              style = "stroke: black; fill: none;" />
        <line stroke-dasharray="5 5" x1="4"  y1="24" x2="776"   y2="580" style="stroke:#006600;"/>
        <line stroke-dasharray="5 5" x1="4"  y1="580" x2="776"   y2="24" style="stroke:#006600;"/>



        </svg>

    </body>
</html>
