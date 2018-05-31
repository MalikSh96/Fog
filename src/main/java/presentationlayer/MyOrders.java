package presentationlayer;

import businesslayer.UniversalExceptions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author malik
 */
public class MyOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {

        return "myorders";
    }
}
