package presentationlayer;

import functionlayer.LogicFacade;
import functionlayer.LoginSampleException;
import functionlayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String name = request.getParameter( "name" );
        String address = request.getParameter( "address" );
        String postnr = request.getParameter( "postalcode" );
        String phonenr = request.getParameter( "phonenumber" );
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        int postal = Integer.parseInt(postnr);
        int phone = Integer.parseInt(phonenr);
        if ( password1.equals( password2 ) ) {
            User user = LogicFacade.createUser( name, address, postal, phone, email, password1 );
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            session.setAttribute("id", user.getId());
            session.setAttribute( "role", user.getRole() );
            return user.getRole() + "page";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }

}
