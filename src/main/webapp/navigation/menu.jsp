<%@page import="businesslayer.BusinessFacade"%>
<%@page import="businesslayer.Constants"%>
<%@page import="datalayer.UserMapper"%>
<nav>
    <div class="container-resposize-header">
        <header>
            <%@page import="businesslayer.User"%>
            <%User user = (User) session.getAttribute("user");
            Constants con = new Constants();
            BusinessFacade bf = con.getBf();%>
            <div class="navwrapper">

                <div class="logo">
                    <img src="Image/logo.png" class="img-responsive">

                </div>
                <div class="nav">

                    <div class="topnavgation">
                        <div>
                            
                                <ul>
                                    <li><a href="index.jsp">Forside</a></li>
                                    <li><a href="FrontController?command=customorder">Bygselv Carport</a></li>

                                </ul> 

                             
                        </div>
                        <ul>
                            <% if (user != null && user.isAdmin(bf.getUserRole(user.getId()))) { %>
                            <li><a href="FrontController?command=adminpage">admin</a></li>
                                <% }%>
                            <% if (user != null && !user.isAdmin(bf.getUserRole(user.getId()))) { %>
                            <li><a href="FrontController?command=customerpage">Min Side</a></li>
                                <% }%>
                                <% if (user == null) { %>
                            <li>        <a href="FrontController?command=loginpage">Login</a></li>
                                <% } else { %>
                            <li> <a href="FrontController?command=logout">Logout</a></li>
                                <% }%>
                        </ul>


                    </div>
                </div>
            </div>
        </header>
    </div>
</nav>
