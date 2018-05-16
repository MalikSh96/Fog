/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import dbaccess.UserMapper;
import functionlayer.LoginSampleException;
import functionlayer.Orders;
import functionlayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joklin
 */
public class UpdateUserInfo extends Command {

    int userID = 0;
    String name, address, email, password;
    int postal, phone;
    UserMapper um = new UserMapper();
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        userID = (int) session.getAttribute("id");
        User user = um.getUser(userID);
        name = user.getName();
        address = user.getAddress();
        email = user.getEmail();
        postal = user.getPostalcode();
        phone = user.getPhone();
        password = user.getPassword();
        
        
        
        if(request.getParameter("name") != null) name = request.getParameter("name");
        if(request.getParameter("address") != null) address = request.getParameter("address"); 
        if(request.getParameter("email") != null) email = request.getParameter("email"); 
        if(request.getParameter("postal") != null) 
         postal = Integer.parseInt(request.getParameter("postal")); 
        if(request.getParameter("phone") != null) phone = Integer.parseInt(request.getParameter("phone")); 
        if(request.getParameter("password") != null) password = request.getParameter("password");
        
        um.UpdateUserInfo(userID, name, address, postal, phone, email, password);
              return "customerpage";
    }

}

/*        til order jsp

<th><p>1x2</th>
<td><p><%out.print(session.getAttribute("længde")); %></td>
<td><p><%out.print(session.getAttribute("vidde")); %></td>
<td><p><%out.print(session.getAttribute("bredde")); %></td>

*/
