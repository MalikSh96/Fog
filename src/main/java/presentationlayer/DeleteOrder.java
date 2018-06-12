package presentationlayer;

import businesslayer.UniversalExceptions;
import businesslayer.BusinessFacade;
import businesslayer.Constants;
import businesslayer.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteOrder extends Command {

    int orderId = 0;
    Constants con = new Constants();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {
        HttpSession session = request.getSession();
        orderId = (int) session.getAttribute("ordernumber");
        User us = (User) session.getAttribute("user");
       
        con.getBf().deleteOrder(orderId);
        
        if (us.isAdmin(con.getBf().getUserRole(us.getId()))) {
            return "adminpage";
        }
        return "storagechiefpage";
    }
}
