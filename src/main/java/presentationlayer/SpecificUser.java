package presentationlayer;

import businesslayer.UniversalExceptions;
import businesslayer.BusinessFacade;
import businesslayer.Constants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SpecificUser extends Command {

    int chosenId = 0;
    Constants con = new Constants();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {
        HttpSession session = request.getSession();
        if (request.getParameter("chosenuserid").length() > 0) {
            chosenId = Integer.parseInt(request.getParameter("chosenuserid"));
        }
        if (con.getBf().UserIdExists(chosenId)) {
            session.setAttribute("specificUserid", chosenId);
            return "specificuser";
        }
        return "userlist";
    }
}
