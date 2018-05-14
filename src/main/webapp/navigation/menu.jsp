<nav>
    <div class="container-resposize-header">
        <header>
            <%@page import="functionlayer.User"%>
            <%User user = (User) session.getAttribute("user");%>
            <div class="navwrapper">

                <div class="logo">
                    <img src="Image/logo.png" class="img-responsive">

                </div>
                <div class="nav">

                    <div class="topnavgation">
                        <div>
                            <div>
                                <ul>
                                    <li><a href="index.jsp">Forside</a></li>
                                    <li><a href="FrontController?command=customorder">Bygselv Carport</a></li>

                                </ul> 

                            </div>  
                        </div>
                        <ul>
                            <% if (user != null) { %>
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
