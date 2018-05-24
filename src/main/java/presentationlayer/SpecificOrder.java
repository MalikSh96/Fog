/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;


import businesslayer.BusinessFacade;
import businesslayer.Constants;
import businesslayer.LoginSampleException;
import businesslayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joklin
 */
public class SpecificOrder extends Command {

    int chosenId = 0;
    Constants con = new Constants();
    BusinessFacade bf = con.getBf();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        User curUs = (User) session.getAttribute("user");

        chosenId = Integer.parseInt(request.getParameter("chosenid"));
        if (!curUs.isAdmin(bf.getUserRole(curUs.getId())) && chosenId != bf.getUserId(chosenId)) {
            return "myorders";
        }else if(curUs.isAdmin(bf.getUserRole(curUs.getId())) && !bf.OrderIdExists(chosenId)) {
        return "adminpage";
        }
        session.setAttribute("orderid", chosenId);
        return "specificOrder";
    }
}

