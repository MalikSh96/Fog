package presentationlayer;

import businesslayer.UniversalExceptions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateInventoryPage extends Command {

    int inventoryId = 0;

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {

        HttpSession session = request.getSession();
        inventoryId = Integer.parseInt(request.getParameter("choseninventoryid"));
        session.setAttribute("inventoryid", inventoryId);
        return "updateinventorypage";
    }
}
