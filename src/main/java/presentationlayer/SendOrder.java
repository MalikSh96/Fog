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

/**
 *
 * @author malik
 */
public class SendOrder extends Command {

    int id = 0;
    Constants con = new Constants();
    BusinessFacade bf = con.getBf();
    boolean possible = true;

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {
        HttpSession session = request.getSession();
        id = (int) session.getAttribute("ordernumber");
        User us = (User) session.getAttribute("user");
        List<Integer> itemIds = bf.getFullItemlistId(id);
        List<Integer> wrongIds = new ArrayList<>();
        for (int i = 0; i < itemIds.size(); i++) {
            if (!bf.updateStatus(itemIds.get(i), bf.getAmount(id, itemIds.get(i)))) {
                possible = false;
                wrongIds.add(itemIds.get(i));
            }
        }
        if (!possible) {
            for (int i = 0; i < itemIds.size(); i++) {
                bf.reverseStatusUpdate(itemIds.get(i), bf.getAmount(id, itemIds.get(i)), wrongIds);
            }
        } else {
            bf.sendOrder(id);
        }
        if (us.isAdmin(bf.getUserRole(us.getId()))) {
            return "adminpage";
        }
        return "storagechiefpage";
    }
}
