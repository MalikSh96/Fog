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

        if(request.getParameter("chosenid").length() > 0) {chosenId = Integer.parseInt(request.getParameter("chosenid"));}
         if (curUs.isAdmin(bf.getUserRole(curUs.getId())) && !bf.OrderIdExists(chosenId)) {
            return "adminpage";
        } else if (bf.getUserRole(bf.getUserId(curUs.getEmail())).equals("storageworker") && !bf.OrderIdExists(chosenId)) {
            return "storageworkerpage";
        } else if (bf.getUserRole(bf.getUserId(curUs.getEmail())).equals("storagechief") && !bf.OrderIdExists(chosenId)) {
            return "storagechiefpage";
        } else if (!curUs.isAdmin(bf.getUserRole(curUs.getId())) && curUs.getId() != bf.getUserId(chosenId) && bf.getUserRole(bf.getUserId(curUs.getEmail())).equals("storageworker") && bf.getUserRole(bf.getUserId(curUs.getEmail())).equals("storagechief")) {
            return "myorders";
        }
        session.setAttribute("orderid", chosenId);
       // session.setAttribute("orderuser", bf.getUserIdFromOrderId(chosenId));
        return "specificOrder";
    }
}
