package presentationlayer;

import dbaccess.InventoryMapper;
import functionlayer.UniversalExceptions;
import functionlayer.Orders;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import functionlayer.User;
/**
 *
 * @author Joklin
 */
public class Inventory extends Command {

    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {
            
        return "inventory";
    }
}