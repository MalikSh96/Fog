package presentationlayer;

import businesslayer.Constants;
import businesslayer.UniversalExceptions;
import businesslayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUserInfo extends Command {

    int userID = 0;
    String name, lastname, address, email, password;
    int postal, phone;
    Constants con = new Constants();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {
        HttpSession session = request.getSession();
        userID = (int) session.getAttribute("id");
        User user = con.getBf().getUser(userID);
        name = user.getName();
        lastname = user.getLastname();
        address = user.getAddress();
        email = user.getEmail();
        postal = user.getPostalcode();
        phone = user.getPhone();
        password = user.getPassword();

        if (request.getParameter("name").length() > 0) {
            name = request.getParameter("name");
        }
        if (request.getParameter("lastname").length() > 0) {
            lastname = request.getParameter("lastname");
        }
        if (request.getParameter("address").length() > 0) {
            address = request.getParameter("address");
        }
        if (request.getParameter("email").length() > 0) {
            email = request.getParameter("email");
        }
        if (request.getParameter("postal").length() > 0) {
            postal = Integer.parseInt(request.getParameter("postal"));
        }
        if (request.getParameter("phone").length() > 0) {
            phone = Integer.parseInt(request.getParameter("phone"));
        }
        if (request.getParameter("password").length() > 0) {
            password = request.getParameter("password");
        }
        con.getBf().updateUserInfo(userID, name, lastname, address, postal, phone, email, password);

        return "customerpage";
    }
}
