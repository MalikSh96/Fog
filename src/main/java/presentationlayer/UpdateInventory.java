package presentationlayer;

import businesslayer.BusinessFacade;
import businesslayer.Constants;
import businesslayer.UniversalExceptions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateInventory extends Command {

    int inventoryId = 0;
    String name, desc, unit;
    int length, status, price;
    Constants con = new Constants();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {
        HttpSession session = request.getSession();

        inventoryId = (int) session.getAttribute("inventoryid");
        name = con.getBf().getItemName(inventoryId);
        desc = con.getBf().getItemDescription(inventoryId);
        length = con.getBf().getItemLength(inventoryId);
        unit = con.getBf().getItemUnit(name);
        status = con.getBf().getItemStatus(inventoryId);
        price = con.getBf().getItemPrice(inventoryId);

        if (request.getParameter("name").length() > 0) {
            name = request.getParameter("name");
        }
        if (request.getParameter("desc").length() > 0) {
            desc = request.getParameter("desc");
        }
        if (request.getParameter("length").length() > 0) {
            length = Integer.parseInt(request.getParameter("length"));
        }
        if (request.getParameter("unit").length() > 0) {
            unit = request.getParameter("unit");
        }
        if (request.getParameter("status").length() > 0) {
            status = Integer.parseInt(request.getParameter("status"));
        }
        if (request.getParameter("price").length() > 0) {
            price = Integer.parseInt(request.getParameter("price"));
        }

        con.getBf().updateInventory(inventoryId, name, desc, length, unit, status, price);
        return "adminpage";
    }
}
