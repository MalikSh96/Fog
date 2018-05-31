package presentationlayer;

import businesslayer.UniversalExceptions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author malik
 */
public class UserInfo extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {
        return "userInfo";
    }
}
