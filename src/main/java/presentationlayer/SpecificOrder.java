/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import dbaccess.OrderMapper;
import dbaccess.UserMapper;
import functionlayer.UniversalExceptions;
import functionlayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joklin
 */
public class SpecificOrder extends Command {

    int chosenId = 0;
    OrderMapper om = new OrderMapper();
    UserMapper um = new UserMapper();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {

        HttpSession session = request.getSession();
        User curUs = (User) session.getAttribute("user");

        chosenId = Integer.parseInt(request.getParameter("chosenid"));
        if (!curUs.isAdmin(um.getUserRole(curUs.getId())) && om.getUserId(chosenId) != curUs.getId()) {
            return "myorders";
        }else if(curUs.isAdmin(um.getUserRole(curUs.getId())) && !om.findOrderId(chosenId)) {
        return "adminpage";
        }
        session.setAttribute("orderid", chosenId);
        return "specificOrder";
    }
}

