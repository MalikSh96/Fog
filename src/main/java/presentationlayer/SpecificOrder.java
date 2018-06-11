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

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {
        HttpSession session = request.getSession();
        User curUs = (User) session.getAttribute("user");

        if (request.getParameter("chosenid").length() > 0) {
            chosenId = Integer.parseInt(request.getParameter("chosenid"));
        }
        if (curUs.isAdmin(con.getBf().getUserRole(curUs.getId())) && !con.getBf().OrderIdExists(chosenId)) {
            return "adminpage";
        } else if (con.getBf().getUserRole(con.getBf().getUserId(curUs.getEmail())).equals("storageworker") && !con.getBf().OrderIdExists(chosenId)) {
            return "storageworkerpage";
        } else if (con.getBf().getUserRole(con.getBf().getUserId(curUs.getEmail())).equals("storagechief") && !con.getBf().OrderIdExists(chosenId)) {
            return "storagechiefpage";
        } else if (!curUs.isAdmin(con.getBf().getUserRole(curUs.getId())) && curUs.getId() != con.getBf().getUserId(chosenId) && con.getBf().getUserRole(con.getBf().getUserId(curUs.getEmail())).equals("storageworker") && con.getBf().getUserRole(con.getBf().getUserId(curUs.getEmail())).equals("storagechief")) {
            return "myorders";
        }
        session.setAttribute("orderid", chosenId);
        return "specificOrder";
    }
}
