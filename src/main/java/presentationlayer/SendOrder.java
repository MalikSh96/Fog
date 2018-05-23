package presentationlayer;


import dbaccess.InventoryMapper;
import dbaccess.ItemlistMapper;
import dbaccess.OrderMapper;
import functionlayer.ItemList;
import functionlayer.LoginSampleException;
import functionlayer.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendOrder extends Command {

    int id = 0;
    OrderMapper om = new OrderMapper();
    ItemlistMapper ilm = new ItemlistMapper();
    InventoryMapper im = new InventoryMapper();
    boolean possible = true;
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {    

        HttpSession session = request.getSession();
        id = (int)session.getAttribute("ordernumber");
                
        List<Integer> itemIds = ilm.getFullItemlistId(id);
        List<Integer> wrongIds = new ArrayList<>();
        for (int i = 0; i < itemIds.size(); i++) {
            if(!im.updateStatus(itemIds.get(i), ilm.getAmount(id, itemIds.get(i)))) {possible = false;
            wrongIds.add(itemIds.get(i));
            }
        }
        if(!possible) {
        for (int i = 0; i < itemIds.size(); i++) {
            im.reverseStatusUpdate(itemIds.get(i), ilm.getAmount(id, itemIds.get(i)), wrongIds);
        }
        } else { om.sendOrder(id); } 
        
        return "adminpage";    
    }
    
}
