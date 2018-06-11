package presentationlayer;

import businesslayer.UniversalExceptions;
import businesslayer.BusinessFacade;
import businesslayer.Constants;
import businesslayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToInventory extends Command {

    Constants con = new Constants();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {
        HttpSession session = request.getSession();
        User us = (User) session.getAttribute("user");
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        int status = Integer.parseInt(request.getParameter("status"));
        int length = Integer.parseInt(request.getParameter("length"));
        String unit = request.getParameter("unit");
        int price = Integer.parseInt(request.getParameter("price"));

        con.getBf().addToInventory(name, desc, length, unit, status, price);
        if (us.isAdmin(con.getBf().getUserRole(us.getId()))) {
            return "adminpage";
        }
        return "storagechiefpage";
    }
}
