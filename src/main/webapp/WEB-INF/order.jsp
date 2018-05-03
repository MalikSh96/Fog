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
                <td><p><%out.print(session.getAttribute("længde"));%></td>
                <td><p><%out.print(session.getAttribute("vidde")); %></td>
                <td><p><%out.print(session.getAttribute("højde"));%></td>


            </tr>
        </table>

        <br>
        <br>
        <br>
        <br>

        <SVG height="<%out.print(session.getAttribute("højde"));%>" 
             width="<%out.print(session.getAttribute("længde"));%>">
        
        <rect x="0" y="0"  height="<%out.print(session.getAttribute("højde"));%>"
                          width="<%out.print(session.getAttribute("længde"));%>"         
                          style = "stroke: black; fill: none;" />
        
        <rect x="0" y="0" height="<%out.print(session.getAttribute("højde"));%>" 
              width="3" style="stroke:black; fill: none"/>
        
        <rect x="0" y="0" height="3" 
              width="<%out.print(session.getAttribute("længde"));%>"
              style="stroke:black; fill: none"/>
        
        <rect x="<%out.print(session.getAttribute("længdespær"));%>" y="0" 
              height="<%out.print(session.getAttribute("højde"));%>" 
              width="3" 
              style="stroke:black; fill: none"/>
        
               
               
            <rect x="0" y="<%out.print(session.getAttribute("højdespær"));%>"
                  height="3" 
                  width="<%out.print(session.getAttribute("længde"));%>" 
                  style="stroke:black; fill: none"/>
            
            <line stroke-dasharray="5 5" x1="3"  y1="3" 
                  x2="<%out.print(session.getAttribute("længdespær"));%>"   
                  y2="<%out.print(session.getAttribute("højdespær"));%>"
                  style="stroke:#006600;"/>
                <line stroke-dasharray="5 5" x1="3"  
                      y1="<%out.print(session.getAttribute("højdespær"));%>" 
                      x2="<%out.print(session.getAttribute("længdespær"));%>" 
                      y2="3" style="stroke:#006600;"/>
        </svg>
        
        
    </body>
</html>
