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

        if (request.getParameter("chosenid").length() > 0) {
            chosenId = Integer.parseInt(request.getParameter("chosenid"));
        }
        
        session.setAttribute("orderid", chosenId);
        return "specificOrder";
    }
}
