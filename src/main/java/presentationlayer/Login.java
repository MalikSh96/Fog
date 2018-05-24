package presentationlayer;

import businesslayer.UniversalExceptions;
import datalayer.DataFacade;
import businesslayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = DataFacade.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        session.setAttribute("id", user.getId());
        if (request.getParameter("from") != null) {
            return request.getParameter("from");
        } else {
            return user.getRole() + "page";
        }
    }
}
