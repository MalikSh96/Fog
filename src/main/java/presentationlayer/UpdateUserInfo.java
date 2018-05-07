/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import dbaccess.UserMapper;
import functionlayer.LoginSampleException;
import functionlayer.Orders;
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
        postal = Integer.parseInt(request.getParameter("postal"));
        phone = Integer.parseInt(request.getParameter("phone"));
        name = request.getParameter("name");
        address = request.getParameter("address");
        email = request.getParameter("email");
        password = request.getParameter("password");
        
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
