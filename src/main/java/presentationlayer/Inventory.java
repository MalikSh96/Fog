package presentationlayer;

import datalayer.InventoryMapper;
import businesslayer.LoginSampleException;
import businesslayer.Orders;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import businesslayer.User;
/**
 *
 * @author Joklin
 */
public class Inventory extends Command {

    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        

      
              return "inventory";
    }

}