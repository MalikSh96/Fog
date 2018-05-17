<%@page import="functionlayer.ItemList"%>
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

        <%  int length = (int) session.getAttribute("længde"); %>

        <%  int width = (int) session.getAttribute("bredde");%>
        <%  int height = (int) session.getAttribute("højde"); %>
        <%  int roof_tiles = (int) session.getAttribute("tagsten");%>
        <% int roof_raft = 55;%>
        <% int heightground = (int) session.getAttribute("højdejord");%>
        <% int redskabsrumlængde = (int) session.getAttribute("redskabsrumlængde");%>
        <% int redskabsrumbredde = (int) session.getAttribute("redskabsrumbredde");%>
        <% int heightpole = (int) session.getAttribute("højdestolpe"); %>
        <% int lengthrafter = (int) session.getAttribute("længdespær");%>
        <% int widthrafter = (int) session.getAttribute("breddespær");%>
        <% int widthline = (int) session.getAttribute("breddelinje"); %>
        <% int heightline = (int) session.getAttribute("højdelinje"); %>
        <% int lengthline = (int) session.getAttribute("længdelinje"); %> 
    </head>
    <body>

        <%int toolshedcross = 0; %>
        <%int toolshedlength = 0; %>
        <% int toolshedwidth = 0; %>
        <%if ((redskabsrumlængde != 0) && (redskabsrumbredde != 0)) {
                        toolshedcross = redskabsrumlængde + 4;
                        toolshedlength = redskabsrumlængde;
                        toolshedwidth = redskabsrumbredde;
                    }%>

        <%@include file="../navigation/menu.jsp" %>
        <h1>Order page</h1>


        <h3>Din ordre blev gennemført!</h3><br>

        <table border="1">
            <tr>
                <th><p>Længde</th>
                <th><p>Bredde</th>
                <th><p>Højde</th>
                    <%if ((0 != toolshedlength) && (0 != toolshedwidth)) { %>
                <th><p>Redskabsrum længde</th>
                <th><p>Redskabsrum bredde</th>
                    <% } %>
            </tr>
            <tr>
                <td><p><%out.print(session.getAttribute("længde"));%></td>
                <td><p><%out.print(session.getAttribute("bredde")); %></td>
                <td><p><%out.print(session.getAttribute("højde"));%></td>
                <%if ((0 != toolshedlength) && (0 != toolshedwidth)) { %>
                <td><p><%out.print(session.getAttribute("redskabsrumlængde"));%></td>
                <td><p><%out.print(session.getAttribute("redskabsrumbredde"));%></td>
                <% } %>

            </tr>
        </table>

        <br>
        <h3>fugleperspektiv</h3>
        <button id="myBtnbirdseye">Åben model</button>
        <div id="myFogSVGbirdseye" class="modal">

            <div class="modal-content">

                <!-- Picture size of SVG  -->
                <span class="close">&times;</span>
                <SVG height="<%out.print(session.getAttribute("breddeSVG"));%>" 
                     width="<%out.print(session.getAttribute("længdeSVG"));%>">
                <!---------------> 
                
                
                <!-- toolshedlength and toolshedwidth -->
                <rect x="<%out.print(length - 10 - toolshedlength);%>" y="48" height="<% out.print(toolshedwidth); %>"
                      width="<% out.print(toolshedlength); %>" style="stroke:black; fill: none"/>
                <!-- length and width of picture -->
                <rect x="0" y="30"  height="<%= width%>"
                      width="<%= length%>"         
                      style = "stroke: black; fill: none;" />
                <!---------------> 
                <% if(toolshedlength > 150){ %>
                <!-- text to toolshef -->
                <text x="<%out.print(lengthline);%>" y="<%out.print(width / 6 * 2);%>"
                      font-size="10px"
                      text-anchor="middle"
                      style="writing-mode: tb;">Skur bredde <%= toolshedwidth%> cm</text>
                
                <text x="<%out.print(length / 6 * 4.5);%>" y="<%out.print(widthline);%>"
                      font-size="10px"
                      text-anchor="middle">Skur længde <%= toolshedlength%> cm</text>
                
                <rect x="<%out.print(length - 10 - toolshedlength - 2); %>" y="48" height="6"
                      width="8" style="stroke:black; fill: black"/>
                <rect x="<%out.print(length - 18 + 2); %>" y="48" height="6"
                      width="8" style="stroke:black; fill: black"/>
                <rect x="<%out.print(length / 6 * 4.5); %>" y="48" height="6"
                      width="8" style="stroke:black; fill: black"/>
                
                <rect x="<%out.print(length - 10 - toolshedlength - 2); %>" y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                      width="8" style="stroke:black; fill: black"/>
                <rect x="<%out.print(length - 18 + 2); %>" y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                      width="8" style="stroke:black; fill: black"/>
                <rect x="<%out.print(length / 6 * 4.5); %>" y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                      width="8" style="stroke:black; fill: black"/>
                
                <rect x="<%out.print(length - 10 - toolshedlength - 2); %>" y="<% out.print(toolshedwidth + 42 );%>" height="6"
                      width="8" style="stroke:black; fill: black"/>
                <rect x="<%out.print(length - 18 + 2); %>" y="<% out.print(toolshedwidth + 43 );%>" height="6"
                      width="8" style="stroke:black; fill: black"/>
                <rect x="<%out.print(length / 6 * 4.5); %>" y="<% out.print(toolshedwidth + 43 );%>" height="6"
                      width="8" style="stroke:black; fill: black"/>
                
                <rect x="<%out.print(length - 10 - toolshedlength - 2); %>" y="<% out.print((toolshedwidth / 2) + 42);%>" height="8"
                      width="6" style="stroke:black; fill: black"/>
                <rect x="<%out.print(length - 18 + 4); %>" y="<% out.print((toolshedwidth / 2) + 43 );%>" height="8"
                      width="6" style="stroke:black; fill: black"/>
                
                <% }%>
                <!--------------->
                <!-- first and last pole on top -->
                
                <rect x="25" y="48" height="6"
                      width="8" style="stroke:black; fill: black"/>
                <% if(toolshedlength == 0){ %>
                
                <rect x="<%out.print(length - 31);%>"    
                      y="48" height="6"
                      width="8" style="stroke:black; fill: black"/>
               <% }%>
                <!--------------->
                

                <!--first and last pole on bottom-->
                
                <rect x="25" y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                      width="8" style="stroke:black; fill: black"/>
                
               <% if(toolshedlength == 0){ %>
               
                <rect x="<%out.print(length - 31);%>" 
                      y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                      width="8" style="stroke:black; fill: black"/>
                <% }%>
                <!--------------->
                <!-- length 225 to 450 come there middle pole on top -->
                <% if(toolshedlength == 0){ %>
                <% if ((225 < length) && (450 > length)) {%>
                <rect x="<%out.print(length / 2);%>" 
                      y="48" height="6"
                      width="8" style="stroke:black; fill: black"/>                
                
                <!--------------->
                <!-- length 225 to 450 come there middle pole on bottom -->
                
                
                <rect x="<%out.print(length  / 2);%>" 
                      y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                      width="8" style="stroke:black; fill: black"/>                
                <% }%>
                <% }%>
                <!--------------->
                <!--if length 450 then come 4 pole on top to 675 -->
                
                <% if ((450 <= length) && (675 > length)) {%>
                <rect x="<%out.print(length / 3);%>" 
                      y="48" height="6"
                      width="8" style="stroke:black; fill: black"/>
                
                <% if(toolshedlength == 0){ %> 
                
                <rect x="<%out.print(length / 1.5);%>" 
                      y="48" height="6"
                      width="8" style="stroke:black; fill: black"/> 
                <% }%>
                <!--------------->
                <!--if length 450 then come 4 pole on bottom to 675 --> 
                <rect x="<%out.print(length / 3);%>" 
                      y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                      width="8" style="stroke:black; fill: black"/>
                 <% if(toolshedlength == 0){ %>
                <rect x="<%out.print(length / 1.5);%>" 
                      y="<%out.print(session.getAttribute("breddespær"));%>" height="6"
                      width="8" style="stroke:black; fill: black"/>
                <% }%>
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
                <line stroke-dasharray="5 5" x1="6"  y1="53" 

                      x2="<%= lengthrafter - toolshedcross%>"   
                      y2="<%out.print(session.getAttribute("breddespær"));%>"
                      style="stroke:#006600;"/>
                <!--------------->
                <!--cross on middle start bottom left ends top right  -->
                <line stroke-dasharray="5 5" x1="6"  
                      y1="<%out.print(session.getAttribute("breddespær"));%>" 
                      x2="<%= lengthrafter - toolshedcross%>" 
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
        <br/>
        <br/>
        <h3>Sidebillede</h3>
        <!-- how big roof_raft are -->
        <% roof_raft = 55; %>
        <!----------->
        <button id="myBtnsideview">Åben model</button>
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
                <%if (toolshedlength > 150) { %>
                    <rect  x = "0" y = "10" height = "15" width = "<% out.print(length - toolshedlength - 10); %>" style="stroke:black; fill: none"/>
                    <rect  x = "<%out.print(length - 10);  %>" y = "10" height = "15" width = "10" style="stroke:black; fill: none"/>
                    <%  } else{ %>
                    <rect  x = "0" y = "10" height = "15" width = "<% out.print(length); %>" style="stroke:black; fill: none"/>
                <% }%>
                    <!--------->
                <!--first pole and last pole -->
                <rect x="25" y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"
                      width="8" style="stroke:black; fill: none"/>
                
                <!-- first pole to toolshed text --->
                <% if(toolshedlength != 0) { %>
                <text x="<% out.print((length - 10 - toolshedlength) / 2);%>" y="<%out.print(heightline);%>"
                      font-size="10px"
                      text-anchor="middle"><% out.print(length - 10 - toolshedlength - 25);%> cm</text>
                <% } %>
               
                
                
                <% if(toolshedlength == 0){ %>
                <rect x="<%out.print(length - 25);%>" 
                      y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"
                      width="8" style="stroke:black; fill: none"/>
                <% }%>
                <!-------------->
                <!--middle pole for 225 to 450 -->
                <% if(toolshedlength == 0){ %>
                <% if ((225 < length) && (450 > length)) {%>
                <rect x="<%out.print((length - toolshedlength) / 2);%>" 
                      y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"
                      width="8" style="stroke:black; fill: none"/>                
                <% }%>
                <% }%>
                <!------------->
                <!--if length 450 then come 4 pole to 675  -->
                <% if ((450 <= length) && (675 > length)) {%>
                <rect x="<%out.print(length / 3);%>" 
                      y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"
                      width="8" style="stroke:black; fill: none"/>
                
                
                <% if(toolshedlength == 0){ %>
                <rect x="<%out.print((length - toolshedlength) / 1.5);%>" 
                      y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"
                      width="8" style="stroke:black; fill: none"/>
                
                <% }%>
                <% }%>

                <!------------->
                <!--if length 675 then come 6 pole to 1000  -->    
                <% if ((675 <= length) && (1000 > length)) {%>
                <% for (int n = 1; n < 5; n++) { %>
                <rect x="<%out.print((length - toolshedlength ) / 5 * n);%>" 
                      y="25" height="<%out.print(session.getAttribute("højdestolpe"));%>"
                      width="8" style="stroke:black; fill: none"/>
                <% }%>
                <% }%>

                <!----------------->
                <!-- Toolshed --->
                <% int endtoolshedwidth = length - 10; %>
                <%int toolshedswidth = length - 10 - toolshedlength; %>
                
                <rect x="<%out.print(length - 10 - toolshedlength);%>" y="10" 
                      height="<%out.print(heightpole + 15); %>"
                      width="<% out.print(toolshedlength); %>" style="stroke:black; fill: none"/>
                <!------------------------>
                <!-- wood toolshed -->
                <%int n = 0; %>
                <% int toolswood = 6; %>
                <% for (int i = 0; i < toolshedlength; i += toolswood) { %>
                <rect x="<%out.print(toolshedswidth + i);%>" y="10" height="<%out.print(heightpole + 15); %>" 
                      width="<%if (toolshedlength > i + toolswood) {
                        out.print(toolswood);
                        n = i;
                    } else {
                        toolswood = toolshedlength % i;
                        out.print(toolswood);
                    }%>" 
                      style="stroke:black; fill: none"/>       
                <% }%>
                
                
                
                <!--heightground to the carport - 25 roof of ------>
                <line x1="0" x2="<%= length%>" y1="<% out.print(heightground - 25); %>" y2="<% out.print(heightground - 25);%>" />
                
                <text x="<%out.print(lengthline + 15);%>" y="<%out.print(height / 2);%>"
                      font-size="10px"
                      text-anchor="middle"
                      style="writing-mode: tb;">Højde <%= height%> cm</text>

                </SVG>


            </div>
        </div>              
                      <script src="./javascriptordre.js" type="text/javascript"></script>
        
        <table border = 1>
            <tr>
                <th><p>Navn</p></th>
                <th><p>Beskrivelse</p></th>
                <th><p>Længe i cm</p></th>
                <th><p>Antal</p></th>
            </tr>
            <tr>
                
                <td><p> <%out.println(session.getAttribute("postName"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("postDesc"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("postLength"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("postAmount"));%></p> </td>
                
            </tr>
            <tr>
                
                <td><p> <%out.println(session.getAttribute("raftName"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("raftDesc"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("raftLength"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("raftAmount"));%></p> </td>
                
            </tr>
            <tr>
                
                <td><p> <%out.println(session.getAttribute("remName"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("remDesc"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("remLength"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("remAmount"));%></p> </td>
                
            </tr>
            <tr>
                
                <td><p> <%out.println(session.getAttribute("roofName"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("roofDesc"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("roofLength"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("roofAmount"));%></p> </td>
                
            </tr>
            <tr>
                
                <td><p> <%out.println(session.getAttribute("roofScrewName"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("roofScrewDesc"));%></p> </td>
                <td><p> <%out.println(0);%></p> </td>
                <td><p> <%out.println(session.getAttribute("roofScrewAmount"));%></p> </td>
                
            </tr>
            <tr>
                
                <td><p> <%out.println(session.getAttribute("universalRightName"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("universalRightDesc"));%></p> </td>
                <td><p> <%out.println(0);%></p> </td>
                <td><p> <%out.println(session.getAttribute("universalRightAmount"));%></p> </td>
                
            </tr>
            <tr>
                
                <td><p> <%out.println(session.getAttribute("universalLeftName"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("universalLeftDesc"));%></p> </td>
                <td><p> <%out.println(0);%></p> </td>
                <td><p> <%out.println(session.getAttribute("universalLeftAmount"));%></p> </td>
                
            </tr>
            <tr>
                
                <td><p> <%out.println(session.getAttribute("bracketScrewName"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("bracketScrewDesc"));%></p> </td>
                <td><p> <%out.println(0);%></p> </td>
                <td><p> <%out.println(session.getAttribute("bracketScrewAmount"));%></p> </td>
                
            </tr>
            <tr>
                
                <td><p> <%out.println(session.getAttribute("carriageBoltName"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("carriageBoltDesc"));%></p> </td>
                <td><p> <%out.println(0);%></p> </td>
                <td><p> <%out.println(session.getAttribute("carriageBoltAmount"));%></p> </td>
                
            </tr>
            <tr>
                
                <td><p> <%out.println(session.getAttribute("squareSlicesName"));%></p> </td>
                <td><p> <%out.println(session.getAttribute("squareSlicesDesc"));%></p> </td>
                <td><p> <%out.println(0);%></p> </td>
                <td><p> <%out.println(session.getAttribute("squareSlicesAmount"));%></p> </td>
                
            </tr>
        </table>
        
    </body>
</html>