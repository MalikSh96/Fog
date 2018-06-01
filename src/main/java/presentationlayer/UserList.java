package presentationlayer;

import businesslayer.UniversalExceptions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserList extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {
        return "userlist";
    }
}
