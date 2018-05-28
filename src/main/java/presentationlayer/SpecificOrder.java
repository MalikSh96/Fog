package presentationlayer;

import businesslayer.UniversalExceptions;
import businesslayer.BusinessFacade;
import businesslayer.Constants;
import businesslayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SpecificOrder extends Command {

    int chosenId = 0;
    Constants con = new Constants();
    BusinessFacade bf = con.getBf();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {

        HttpSession session = request.getSession();
        User curUs = (User) session.getAttribute("user");

        chosenId = Integer.parseInt(request.getParameter("chosenid"));
        if (!curUs.isAdmin(bf.getUserRole(curUs.getId())) && curUs.getId() != bf.getUserId(chosenId)) {
            return "myorders";
        } else if (curUs.isAdmin(bf.getUserRole(curUs.getId())) && !bf.OrderIdExists(chosenId)) {
            return "adminpage";
        } else if (bf.getUserRole(curUs.getId()) == "storageworker" && !bf.OrderIdExists(chosenId)) {
            return "storageworkerpage";
        } else if (bf.getUserRole(curUs.getId()) == "storagechief" && !bf.OrderIdExists(chosenId)) {
            return "storagechiefpage";
        }
        session.setAttribute("orderid", chosenId);
        return "specificOrder";
    }
}
