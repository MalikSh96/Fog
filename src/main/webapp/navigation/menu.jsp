<%@page import="dbaccess.UserMapper"%>
<%@page import="functionlayer.User"%>
<%User user = (User) session.getAttribute("user");
    UserMapper u = new UserMapper();%>
<header class="bannershow hidden-print">
    <nav>
        <div class="container-resposize-header">

            <div class="navwrapper">

                <div class="logo">
                    <img src="Image/logo.png" class="img-responsive">

                </div> 
                <div class="nav_rapper">
                    <div class="nav">

                        <div class="topnavgation">
                            <div class="container">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <ul class="logintitems">
                                            <li class="topviews"><a href="index.jsp">Forside</a></li>
                                            <li class="topviews"><a href="FrontController?command=customorder">Bygselv Carport</a></li>


                                        </ul> 
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="mainnavigation  ng-scope">
                            <div class="container">
                                <div class="row">
                                    <ul class="navigation">

                                        <% if (user != null && user.isAdmin(u.getUserRole(user.getId()))) { %>
                                        <li class="topviews"><a href="FrontController?command=adminpage">admin</a></li>
                                            <% }%>
                                            <% if (user != null && !user.isAdmin(u.getUserRole(user.getId()))) { %>
                                        <li class="topviews"><a href="FrontController?command=customerpage">Min Side</a></li>
                                            <% }%>


                                        <% if (user == null) { %>
                                        <li class="topviews"><a href="FrontController?command=loginpage">Login</a></li>
                                            <% } else { %>
                                        <li class="topviews"> <a href="FrontController?command=logout">Logout</a></li>
                                            <% }%>
                                    </ul>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
