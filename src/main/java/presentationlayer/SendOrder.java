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

public class SendOrder extends Command {

    int orderId = 0;
    Constants con = new Constants();
    boolean possible = true;

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {
        HttpSession session = request.getSession();
        orderId = (int) session.getAttribute("ordernumber");
        User us = (User) session.getAttribute("user");
        List<Integer> itemIds = con.getBf().getFullItemlistId(orderId);
        List<Integer> wrongIds = new ArrayList<>();
        for (int i = 0; i < itemIds.size(); i++) {
            if (!con.getBf().updateStatus(itemIds.get(i), con.getBf().getAmount(orderId, itemIds.get(i)))) {
                possible = false;
                wrongIds.add(itemIds.get(i));
            }
        }
        if (!possible) {
            for (int i = 0; i < itemIds.size(); i++) {
                con.getBf().reverseStatusUpdate(itemIds.get(i), con.getBf().getAmount(orderId, itemIds.get(i)), wrongIds);
            }
        } else {
            con.getBf().sendOrder(orderId);
        }
        if (us.isAdmin(con.getBf().getUserRole(us.getId()))) {
            return "adminpage";
        }
        return "storagechiefpage";
    }
}
