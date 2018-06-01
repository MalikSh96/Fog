<%@page import="businesslayer.ItemList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
        <link href="stylesheetnavigation.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetjavascript.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href="stylesheetfooter.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <%  int length = (int) session.getAttribute("længde"); %>

        <%  int width = (int) session.getAttribute("bredde");%>
        <%  int height = (int) session.getAttribute("højde"); %>
        <%  int roof_tiles = (int) session.getAttribute("tagsten");%>
        <% int roof_raft = 55;%>
        <% int heightground = (int) session.getAttribute("højdejord");%>
        <% int heightpole = (int) session.getAttribute("højdestolpe"); %>
        <% int lengthrafter = (int) session.getAttribute("længdespær");%>
        <% int widthrafter = (int) session.getAttribute("breddespær");%>
        <% int widthline = (int) session.getAttribute("breddelinje"); %>
        <% int heightline = (int) session.getAttribute("højdelinje"); %>
        <% int lengthline = (int) session.getAttribute("længdelinje");
            %> 
    </head>
    <body>       

        <%@include file="../navigation/menu.jsp" %>

        <div class="text-center"> 

            <h1>Din ordre blev gennemført!</h1><br>
            <h3>Fog vil kontakte dig snarerst</h3>
            <br/>
        </div>
        <div class="container">
            <div class="row">




                <table class="table">
                    <tr>
                        <th scope="col">Længde</th>
                        <th scope="col">Bredde</th>
                        <th scope="col">Højde</th>
                    </tr>
                    <tr>
                        <td scope="row"><%out.print(session.getAttribute("længde"));%></td>
                        <td><%out.print(session.getAttribute("bredde")); %></td>
                        <td><%out.print(session.getAttribute("højde"));%></td>
                    </tr>
                </table>
            </div>          
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xs-4 col-centered">
                        <h3>Fugleperspektiv</h3>
                        <button id="myBtnbirdseye">Åben model</button>
                        <div id="myFogSVGbirdseye" class="modal">
                            <div class="modal-content">

                                <!-- Picture size of SVG  -->
                                <span class="close">&times;</span>
                                <SVG height="<%out.print(session.getAttribute("breddeSVG"));%>" 
                                     width="<%out.print(session.getAttribute("længdeSVG"));%>">
                                <!---------------> 

                                <!-- length and width of picture -->
                                <rect x="0" y="30"  height="<%= width%>"
                                      width="<%= length%>"         
                                      style = "stroke: black; fill: none;" />
                                <!---------------> 
                                <!--------------->
                                <!-- first and last pole on top -->

                                <rect x="25" y="48" height="6"
                                      width="8" style="stroke:black; fill: black"/>

                                <rect x="<%out.print(length - 31);%>"    
                                      y="48" height="6"
                                      width="8" style="stroke:black; fill: black"/>
                                <!--------------->


                                <!--first and last pole on bottom-->

                                <rect x="25" y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                                      width="8" style="stroke:black; fill: black"/>


                                <rect x="<%out.print(length - 31);%>" 
                                      y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                                      width="8" style="stroke:black; fill: black"/>
                                <!--------------->
                                <!-- length 225 to 450 come there middle pole on top -->
                                <% if ((225 < length) && (450 > length)) {%>
                                <rect x="<%out.print(length / 2);%>" 
                                      y="48" height="6"
                                      width="8" style="stroke:black; fill: black"/>                

                                <!--------------->
                                <!-- length 225 to 450 come there middle pole on bottom -->

                                <rect x="<%out.print(length / 2);%>" 
                                      y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                                      width="8" style="stroke:black; fill: black"/>                
                                <% }%>
                                <!--------------->
                                <!--if length 450 then come 4 pole on top to 675 -->

                                <% if ((450 <= length) && (675 > length)) {%>
                                <rect x="<%out.print(length / 3);%>" 
                                      y="48" height="6"
                                      width="8" style="stroke:black; fill: black"/>

                                <rect x="<%out.print(length / 1.5);%>" 
                                      y="48" height="6"
                                      width="8" style="stroke:black; fill: black"/> 
                                <!--------------->
                                <!--if length 450 then come 4 pole on bottom to 675 --> 
                                <rect x="<%out.print(length / 3);%>" 
                                      y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                                      width="8" style="stroke:black; fill: black"/>
                                <rect x="<%out.print(length / 1.5);%>" 
                                      y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                                      width="8" style="stroke:black; fill: black"/>
                                <% }%>
                                <!--------------->
                                <!--if length 675 then come 6 pole to top 1000  -->    
                                <% if ((675 <= length) && (1000 > length)) {%>
                                <% for (int n = 1; n < 5; n++) { %>
                                <rect x="<%out.print(length / 5 * n);%>" 
                                      y="48" height="6"
                                      width="8" style="stroke:black; fill: black"/>
                                <% }%>
                                <% }%>
                                <!--------------->
                                <!--if length 675 then come 6 pole to bottom 1000  -->    
                                <% if ((675 <= length) && (1000 > length)) {%>
                                <% for (int n = 1; n < 5; n++) { %>
                                <rect x="<%out.print(length / 5 * n);%>" 
                                      y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                                      width="8" style="stroke:black; fill: black"/>
                                <% }%>
                                <% }%>


                                <!--------------->
                                <!-- roof_raft 55 cm. going to length of picture  -->
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
                                <!--------------->
                                <!-- Text to roof_raft 55 cm. -->
                                <text x="<%=i + (roof_raft / 2)%>" y="25" font-size="8px"
                                      text-anchor="middle"><% out.print(roof_raft); %>cm</text>
                                <% }%>  
                                <!--------------->
                                <!-- roof_tiles 110 cm. going to length of picture  -->

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
                                <!--------------->
                                <!--Text to roof-tiles 110 cm. -->
                                <text x="<%=i + (roof_tiles / 2)%>" y="10" font-size="8px"
                                      text-anchor="middle"><% out.print(roof_tiles); %>cm</text>
                                <% }%>
                                <!--------------->
                                <!--left rafter of 6 cm -->
                                <rect x="0" y="30" height="<%= width%>" 
                                      width="6" style="stroke:black; fill: none"/>
                                <!--------------->
                                <!--top rafter of 6 cm -->
                                <rect x="0" y="48" height="6" 
                                      width="<%=length%>"
                                      style="stroke:black; fill: none"/>
                                <!--------------->
                                <!--right rafter of 6 cm -->
                                <rect x="<%out.print(session.getAttribute("længdespær"));%>" 
                                      y="30" 
                                      height="<%= width%>" 
                                      width="3" 
                                      style="stroke:black; fill: none"/>
                                <!--------------->
                                <!--bottom rafter of 6 cm -->
                                <rect x="0" y="<%out.print(session.getAttribute("breddespær"));%>"
                                      height="6" 
                                      width="<%= length%>" 
                                      style="stroke:black; fill: none"/>
                                <!--------------->
                                <!-- so cross was not being made if you chose the length or width need both to making a toolshef -->

                                <!--------------->
                                <!--cross on middle start top left ends bottom right -->
                                <line stroke-dasharray="5 5" x1="6"  y1="53" x2="<%= lengthrafter%>"
                                      y2="<%out.print(session.getAttribute("breddespær"));%>"
                                      style="stroke:#006600;"/>
                                <!--------------->
                                <!--cross on middle start bottom left ends top right  -->
                                <line stroke-dasharray="5 5" x1="6"  
                                      y1="<%out.print(session.getAttribute("breddespær"));%>" 
                                      x2="<%= lengthrafter%>" 
                                      y2="53" style="stroke:#006600;"/>
                                <!--------------->
                                <!-- text width of picture -->
                                <text x="<%out.print(lengthline + 15);%>" y="<%out.print(session.getAttribute("breddemidtentekst"));%>"
                                      font-size="10px"
                                      text-anchor="middle"
                                      style="writing-mode: tb;">Bredde <%= width%> cm</text>

                                <!--------------->
                                <!-- text length of picture -->
                                <text x="<%out.print(session.getAttribute("længdemidtentekst"));%>" 
                                      y="<%out.print(widthline + 15);%>"
                                      font-size="10px"
                                      text-anchor="middle">Længde <%= length%> cm</text>
                                <!--------------->
                                </SVG>
                            </div>
                        </div>

                    </div>

                    <div class="col-xs-4 col-centered">

                        <h3>Sidebillede</h3>
                        <!-- how big roof_raft are -->
                        <% roof_raft = 55; %>
                        <!----------->
                        <button class="" id="myBtnsideview">Åben model</button>
                        <div id="myFogSVGsideview" class="modalone">

                            <div class="modal-contentone">
                                <span class="closeone">&times;</span>
                                <!-- Picture size of SVG  -->
                                <SVG width="<%out.print(session.getAttribute("længdeSVG"));%>" 
                                     height="<%out.print(session.getAttribute("højdeSVG"));%>" style="stroke:black; fill: none">
                                <!------------->
                                <!-- roof 55 cm. + extra on roof --->
                                <% for (int i = 0; i < length; i += roof_raft) { %>
                                <rect x="<% out.print(i);%>" y="0" height="10" width="<%if (length >= i + roof_raft) {
                                        out.print(roof_raft);
                                    } else {
                                        roof_raft = length % i;
                                        out.print(roof_raft);
                                    }%>" 
                                      style="stroke:black; fill: none"/>       
                                <% }%>
                                <!------------>
                                <!--rafter under roof -->       
                                <rect  x = "0" y = "10" height = "15" width = "<% out.print(length); %>" style="stroke:black; fill: none"/>

                                <!--------->
                                <!--first pole and last pole -->
                                <rect x="25" y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"
                                      width="8" style="stroke:black; fill: none"/>

                                <% if ((225 < length) && (450 > length)) {%>
                                <text x="<% out.print(((length) / 2) / 2);%>" y="<%out.print(heightline);%>"
                                      font-size="10px"
                                      text-anchor="middle"><% out.print((length) / 2);%> cm</text>
                                <% }%>

                                <% if ((225 < length) && (450 > length)) {%>
                                <text x="<% out.print(((length) / 2) * 1.5);%>" y="<%out.print(heightline);%>"
                                      font-size="10px"
                                      text-anchor="middle"><% out.print((length) / 2);%> cm</text>
                                <% } %>

                                <rect x="<%out.print(length - 25);%>" 
                                      y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"
                                      width="8" style="stroke:black; fill: none"/>
                                <!-------------->
                                <!--middle pole for 225 to 450 -->
                                <% if ((225 < length) && (450 > length)) {%>
                                <rect x="<%out.print((length) / 2);%>" 
                                      y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"
                                      width="8" style="stroke:black; fill: none"/>                
                                <% }%>
                                <!------------->
                                <!--if length 450 then come 4 pole to 675  -->
                                <% if ((450 <= length) && (675 > length)) {%>
                                <rect x="<%out.print(length / 3);%>" 
                                      y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"
                                      width="8" style="stroke:black; fill: none"/>

                                <rect x="<%out.print((length) / 1.5);%>" 
                                      y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"
                                      width="8" style="stroke:black; fill: none"/>
                                <% }%>

                                <!------------->
                                <!--if length 675 then come 6 pole to 1000  -->    
                                <% if ((675 <= length) && (1000 > length)) {%>
                                <% for (int n = 1; n < 5; n++) { %>
                                <rect x="<%out.print((length) / 5 * n);%>" 
                                      y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"
                                      width="8" style="stroke:black; fill: none"/>
                                <% }%>
                                <% }%>

                                <!----------------->                     


                                <!--heightground to the carport - 25 roof of ------>
                                <line x1="0" x2="<%= length%>" y1="<% out.print(heightground - 25); %>" y2="<% out.print(heightground - 25);%>" />

                                <text x="<%out.print(lengthline + 15);%>" y="<%out.print(height / 2);%>"
                                      font-size="10px"
                                      text-anchor="middle"
                                      style="writing-mode: tb;">Højde <%= height%> cm</text>

                                </SVG>

                            </div>
                        </div>
                    </div>
                </div>
                <br/>

                <div class="text-center">

                    <h4>Her kan du se status over din ordre</h4>
                    <a href="FrontController?command=myorders" class="btn btn-secondary">Status</a>
                </div>

            </div> 
        </div>

        <%@include file="../footer/footer.jsp" %>
        <script src="./javascriptordre.js" type="text/javascript"></script>


    </body>
</html>