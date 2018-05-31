package presentationlayer;

import businesslayer.BusinessFacade;
import businesslayer.Constants;
import businesslayer.UniversalExceptions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author malik
 */
public class UpdateInventory extends Command {

    int inventoryId = 0;
    String name, desc, unit;
    int length, status, price;
    Constants con = new Constants();
    BusinessFacade bf = con.getBf();
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions {

        HttpSession session = request.getSession();
        
        inventoryId = (int) session.getAttribute("inventoryid");
        name = bf.getItemName(inventoryId);
        desc = bf.getItemDescription(inventoryId);
        length = bf.getItemLength(inventoryId);
        unit = bf.getItemUnit(name);
        status = bf.getItemStatus(inventoryId);
        price = bf.getItemPrice(inventoryId);
        

        if(request.getParameter("name").length() > 0 ){ name = request.getParameter("name");}
        if(request.getParameter("desc").length() > 0 ){ desc = request.getParameter("desc");}
        if(request.getParameter("length").length() > 0){ length = Integer.parseInt(request.getParameter("length"));} 
        if(request.getParameter("unit").length() > 0) { unit = request.getParameter("unit"); }
        if(request.getParameter("status").length() > 0) { status = Integer.parseInt(request.getParameter("status")); }
        if(request.getParameter("price").length() > 0) {price = Integer.parseInt(request.getParameter("price")); }
        
        bf.updateInventory(inventoryId, name, desc, length, unit, status, price);
        
              return "updateinventorypage";
    }

}     