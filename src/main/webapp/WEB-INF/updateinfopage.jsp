<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opdater Brugerinfo</title>
 </head>
    <body>

        <style>
            input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none;
                margin: 0;
            }
            input[type=number] {
                -moz-appearance: textfield;
            }




        </style>
        <%@include file="../navigation/menu.jsp" %>

        <%
            int id = (int) session.getAttribute("id");
            User us = con.getBf().getUser(id);
        %>

        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateinfo">
            <div class="information-text-center-site">   

                <h3>Information</h3>
                Navn: <%= us.getName() + " " + us.getLastname()%><br>
                Adresse:  <%= us.getAddress()%><br>
                Post nr: <%= us.getPostalcode()%><br>
                Telefon nr: <%= us.getPhone()%><br>
                Email: <%= us.getEmail()%><br><br> 
            </div> 


            <div class="center-text" >
                <h1>Opdater personlige oplysninger</h1>
                <br/>
            </div>
            <table class="updateinfopagetable">
                <tr>
                    <td> 

                        <label> Navn</label><br><input type="text" name="name" placeholder="Navn"/>
                    </td>
                    <td>

                        <label> Telefon nummer</label><br><input type="number" name="phone" maxlength="8" max="99999999" min="11111111" placeholder="Telefonnr."/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label> Efternavn</label><br><input type="text" name="lastname" placeholder="Efternavn"/>

                    </td>
                    <td>
                        <label> Email</label><br><input type="text" name="email" placeholder="Email"/>

                    </td>
                </tr>
                <tr>
                    <td>

                        <label> Password</label><br><input type="text" name="password" placeholder="Password"/><br>
                    </td>
                    <td>
                        <label> Adresse</label><br><input type="text" name="address" placeholder="Adresse"/>
                        <br/>
                    </td>
                <tr/>
                <tr>

                    <td colspan="2" style="width: 150px; text-align: center;" > 
                        <label> Postnummer</label><br><input type="number" name="postal" max="9999" min="1111" placeholder="Postnr."/>
                    </td>            
                </tr>
                <tr>

                    <td  style="width: 150px; text-align: center; padding-top: 10px;">
                        <input type="submit" value="Gem Ændringer" class="btn btn-primary" >
                    </td>
                    <td style="width: 150px; text-align: center; padding-top: 10px;">
                        <a href="FrontController?command=customerpage" class="btn btn-primary" role="button">Gå Tilbage</a>
                    </td>

                </tr>
            </table>
        </form>

        <%@include file="../footer/footer.jsp" %>
    </body>
</html>
