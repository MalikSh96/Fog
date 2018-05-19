package presentationlayer;

import dbaccess.InventoryMapper;
import dbaccess.UserMapper;
import functionlayer.LoginSampleException;
import functionlayer.Orders;
import functionlayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joklin
 */
public class UpdateInventory extends Command {

    int inventoryId = 0;
    String name, desc, unit;
    int length, status, price;
    InventoryMapper im = new InventoryMapper();
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        inventoryId = (int) session.getAttribute("inventoryid");
        name = im.getName(inventoryId);
        desc = im.getDescription(inventoryId);
        length = im.getLength(inventoryId);
        unit = im.getUnit(name);
        status = im.getStatus(inventoryId);
        price = im.getPrice(inventoryId);
        

        if(request.getParameter("name").length() > 0 ){ name = request.getParameter("name");}
        if(request.getParameter("desc").length() > 0 ){ desc = request.getParameter("desc");}
        if(request.getParameter("length").length() > 0){ length = Integer.parseInt(request.getParameter("length"));} 
        if(request.getParameter("unit").length() > 0) { unit = request.getParameter("unit"); }
        if(request.getParameter("status").length() > 0) { status = Integer.parseInt(request.getParameter("status")); }
        if(request.getParameter("price").length() > 0) {status = Integer.parseInt(request.getParameter("price")); }
        
        im.UpdateInventory(inventoryId, name, desc, length, unit, status, price);
              return "updateinventorypage";
    }

}
   //<%=//im.getSpecificItem((int)session.getAttribute("inventoryid")).toString().replace("[", "").replace("]", "").replace(",", "") + "<br>"%><br>
       