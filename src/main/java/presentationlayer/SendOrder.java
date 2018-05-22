/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Joklin
 */
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
        for (int i = 0; i < itemIds.size(); i++) {
            if(!im.updateStatus(itemIds.get(i), ilm.getAmount(id, itemIds.get(i)))) {possible = false;}
        }
        if(possible){ om.sendOrder(id); } 
        
        return "adminpage";    
    }
    
}
