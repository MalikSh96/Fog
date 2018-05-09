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

        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>

        <%  int length = (int) session.getAttribute("længde"); %>
        <%  int width = (int) session.getAttribute("bredde");%>
        <%  int height = (int) session.getAttribute("højde"); %>
        <%  int roof_tiles = (int) session.getAttribute("tagsten");%>
        <% int roof_raft = 55;%>
        <% int heightground = (int) session.getAttribute("højdejord");%>
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
        <h3>fugleperspektiv</h3>
        <button id="myBtnbirdseye">Åben model</button>
        <div id="myFogSVGbirdseye" class="modal">

            <div class="modal-content">
                <% int x = 0; %>
                <span class="close">&times;</span>
                <SVG height="<%out.print(session.getAttribute("breddeSVG"));%>" 
                     width="<%out.print(session.getAttribute("længdeSVG"));%>">

                <% for (int i = 17; i < length; i += 200) {%>
                <rect x="<% out.print(i);%>" 
                      y="48" height="6" 
                      width="8"
                      style="stroke:black; fill: none"/>
                <% }%>

                <% for (int i = 17; i < length; i += 200) {%>
                <rect x="<% out.print(i);%>" 
                      y="<%out.print(session.getAttribute("breddespær"));%>" height="6" 
                      width="8"
                      style="stroke:black; fill: none"/>
                <% }%>

                <% for (int i = 3; i < length; i += roof_raft) {%>
                <rect x="<% out.print(i);%>" 
                      y="30" height="<%out.print(session.getAttribute("bredde"));%>" 
                      width="<% if (length >= i + roof_raft) {
                              roof_raft = roof_raft - 6;
                              out.print(roof_raft);
                              roof_raft = roof_raft + 6;
                          } else {
                              roof_raft = length % i;
                              out.print(roof_raft);
                          }%>"
                      style="stroke:black; fill: none"/>
                <text x="<%=i + (roof_raft / 2)%>" y="25" font-size="8px"
                      text-anchor="middle"><% out.print(roof_raft); %>cm</text>
                <% }%>


                <% for (int i = 0; i < length; i += roof_tiles) {%>

                <rect x="<% out.print(i);%>" 
                      y="30" height="<%out.print(session.getAttribute("bredde"));%>" 
                      width="<% if (length >= i + roof_tiles) {
                              out.print(roof_tiles);
                          } else {
                              roof_tiles = length % i;
                              out.print(roof_tiles);
                          }%>"
                      style="stroke:black; fill: none"/>  
                <text x="<%=i + (roof_tiles / 2)%>" y="10" font-size="8px"
                      text-anchor="middle"><% out.print(roof_tiles); %>cm</text>
                <% }%>

                <rect x="0" y="30"  height="<%= width%>"
                      width="<%= length%>"         
                      style = "stroke: black; fill: none;" />

                <rect x="0" y="30" height="<%= width%>" 
                      width="6" style="stroke:black; fill: none"/>

                <rect x="0" y="48" height="5" 
                      width="<%=length%>"
                      style="stroke:black; fill: none"/>

                <rect x="<%out.print(session.getAttribute("længdespær"));%>" 
                      y="30" 
                      height="<%= width%>" 
                      width="3" 
                      style="stroke:black; fill: none"/>




                <rect x="0" y="<%out.print(session.getAttribute("breddespær"));%>"
                      height="5" 
                      width="<%= length%>" 
                      style="stroke:black; fill: none"/>

                <line stroke-dasharray="5 5" x1="6"  y1="53" 
                      x2="<%out.print(session.getAttribute("længdespær"));%>"   
                      y2="<%out.print(session.getAttribute("breddespær"));%>"
                      style="stroke:#006600;"/>
                <line stroke-dasharray="5 5" x1="6"  
                      y1="<%out.print(session.getAttribute("breddespær"));%>" 
                      x2="<%out.print(session.getAttribute("længdespær"));%>" 
                      y2="53" style="stroke:#006600;"/>

                <text x="<%out.print(session.getAttribute("længdelinje"));%>" y="<%out.print(session.getAttribute("breddemidtentekst"));%>"
                      font-size="10px"
                      text-anchor="middle"
                      style="writing-mode: tb;">Bredde <%= width%> cm</text>

                <text x="<%out.print(session.getAttribute("længdemidtentekst"));%>" 
                      y="<%out.print(session.getAttribute("breddelinje"));%>"
                      font-size="10px"
                      text-anchor="middle">Længde <%= length%> cm</text>

                </SVG>
                <% roof_raft = 55; %>
            </div>
        </div>
        <br/>
        <br/>
        <h3>Sidebillede</h3>
        <button id="myBtnsideview">Åben model</button>
        <div id="myFogSVGsideview" class="modalone">
            <div class="modal-contentone">
                <span class="closeone">&times;</span>
                <SVG width="<%out.print(session.getAttribute("længdeSVG"));%>" 
                     height="<%out.print(session.getAttribute("højdeSVG"));%>" style="stroke:black; fill: none">

                
                
                
                <% for (int i = 0; i < length; i += roof_raft) { %>
                <rect x="<% out.print(i);%>" y="0" height="10" width="<%if (length >= i + roof_raft) {
                        out.print(roof_raft);
                    } else {
                        roof_raft = length % i;
                        out.print(roof_raft);
                    }%>" 
                      style="stroke:black; fill: none"/>       
                <% }%>

                <rect x="0" y="10" height="15" width="<% out.print(length); %>" style="stroke:black; fill: none"/>


                <% for (int i = 25; i < length; i += 200) {%>

                <rect x="<%= i%>" 

                      y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"

                      width="8" style="stroke:black; fill: none"/>
                
                <%if ((length > 300) && (i > length - 100)){%>
                <rect x="<%
                    int lastpole = length - 25;
                    out.print(lastpole); %>"
                      y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"

                      width="8" style="stroke:black; fill: none"/>
                <% }%>

                
                <% }%>
                <line x1="0" x2="<%= length%>" y1="<% out.print(heightground); %>" y2="<% out.print(heightground);%>" />


                </SVG>


            </div>
        </div>

        <script>
            var modal = document.getElementById('myFogSVGbirdseye');
            var modalone = document.getElementById('myFogSVGsideview');

            var btn_birds_eye = document.getElementById("myBtnbirdseye");
            var btn_side_view = document.getElementById("myBtnsideview");




            var span_birds_eye = document.getElementsByClassName("close")[0];
            var span_side_view = document.getElementsByClassName("closeone")[0];

            btn_birds_eye.onclick = function () {
                modal.style.display = "block";

            }

            btn_side_view.onclick = function () {
                modalone.style.display = "block";

            }

            span_birds_eye.onclick = function () {
                modal.style.display = "none";
            }

            span_side_view.onclick = function () {
                modalone.style.display = "none";
            }



            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";

                }
            }

            window.onclick = function (eventone) {
                if (eventone.target == modalone) {
                    modalone.style.display = "none";

                }
            }
        </script>
    </body>
</html>
