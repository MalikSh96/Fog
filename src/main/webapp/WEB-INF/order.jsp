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
        <%  int length = (int) session.getAttribute("længde"); %>
        <%  int width = (int) session.getAttribute("bredde");%>
        <%  int roof_tiles = (int) session.getAttribute("tagsten"); %>
    </head>
    <body>



        <%@include file="../navigation/menu.jsp" %>
        <h1>Order page</h1>


        <h3>Din ordre blev gennemført!</h3><br>

        <table border="1">
            <tr>
                <th><p>Længde</th>
                <th><p>Bredde</th>
                <th><p>Højde</th>
            </tr>
            <tr>
                <td><p><%out.print(session.getAttribute("længde"));%></td>
                <td><p><%out.print(session.getAttribute("bredde")); %></td>
                <td><p><%out.print(session.getAttribute("højde"));%></td>


            </tr>
        </table>

        <br>

        <button id="myBtn">Åben model</button>
        <div id="myFogSVG" class="modal">

            <div class="modal-content">
                <% int x = 0; %>
                <span class="close">&times;</span>
                <SVG height="<%out.print(session.getAttribute("breddeSVG"));%>" 
                     width="<%out.print(session.getAttribute("længdeSVG"));%>">

                <% for (int i = 0; i < length; i += roof_tiles) { %>
                <rect x="<% if (length >= i + roof_tiles) {
                        out.print(i);

                      %>" 
                      y="0" height="<%out.print(session.getAttribute("bredde"));%>" 
                      width="<%out.print(roof_tiles);} else {
                              x = length % i;
                              out.print(x);
                          }%>"
                      style="stroke:black; fill: none"/>    
                <%}%>


                <rect x="0" y="0"  height="<%= width%>"
                      width="<%= length%>"         
                      style = "stroke: black; fill: none;" />

                <rect x="0" y="0" height="<%= width%>" 
                      width="3" style="stroke:black; fill: none"/>

                <rect x="0" y="20" height="3" 
                      width="<%=length%>"
                      style="stroke:black; fill: none"/>

                <rect x="<%out.print(session.getAttribute("længdespær"));%>" y="0" 
                      height="<%= width%>" 
                      width="3" 
                      style="stroke:black; fill: none"/>



                <rect x="0" y="<%out.print(session.getAttribute("breddespær"));%>"
                      height="3" 
                      width="<%= length%>" 
                      style="stroke:black; fill: none"/>

                <line stroke-dasharray="5 5" x1="3"  y1="23" 
                      x2="<%out.print(session.getAttribute("længdespær"));%>"   
                      y2="<%out.print(session.getAttribute("breddespær"));%>"
                      style="stroke:#006600;"/>
                <line stroke-dasharray="5 5" x1="3"  
                      y1="<%out.print(session.getAttribute("breddespær"));%>" 
                      x2="<%out.print(session.getAttribute("længdespær"));%>" 
                      y2="23" style="stroke:#006600;"/>

                <text x="<%out.print(session.getAttribute("længdelinje"));%>" y="<%out.print(session.getAttribute("breddemidtentekst"));%>"
                      font-size="10px"
                      text-anchor="middle"
                      style="writing-mode: tb;">Bredde <%= width%> cm</text>

                <text x="<%out.print(session.getAttribute("længdemidtentekst"));%>" 
                      y="<%out.print(session.getAttribute("breddelinje"));%>"
                      font-size="10px"
                      text-anchor="middle">Længde <%= length%> cm</text>





                </svg>

            </div>
        </div>

        <script>
            var modal = document.getElementById('myFogSVG');

            var btn = document.getElementById("myBtn");

            var span = document.getElementsByClassName("close")[0];

            btn.onclick = function () {
                modal.style.display = "block";

            }

            span.onclick = function () {
                modal.style.display = "none";
            }



            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";

                }


            }
        </script>
    </body>
</html>
