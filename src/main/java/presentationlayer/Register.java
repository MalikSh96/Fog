package presentationlayer;

import businesslayer.UniversalExceptions;
import businesslayer.BusinessFacade;
import businesslayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author malik
 */
public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {

        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String postnr = request.getParameter("postalcode");
        String phonenr = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        int postal = Integer.parseInt(postnr);
        int phone = Integer.parseInt(phonenr);
        
        if (password1.equals(password2)) {
            User user = BusinessFacade.createUser(name, lastname, address, postal, phone, email, password1);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("id", user.getId());
            session.setAttribute("role", user.getRole());
            return user.getRole() + "page";
        } else {
            throw new UniversalExceptions("the two passwords did not match");
        }
    }
}
