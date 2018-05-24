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
    BusinessFacade bf = con.getBf();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {

        HttpSession session = request.getSession();

        chosenId = Integer.parseInt(request.getParameter("chosenuserid"));
        if (bf.UserIdExists(chosenId)) {
            session.setAttribute("specificUserid", chosenId);
            return "specificuser";
        }

        return "userlist";
    }
}
