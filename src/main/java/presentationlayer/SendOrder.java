/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;


import dbaccess.OrderMapper;
import functionlayer.LoginSampleException;
import functionlayer.User;
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
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {    

        HttpSession session = request.getSession();
        id = (int)session.getAttribute("ordernumber");
                
        om.sendOrder(id);       
        
        return "allCurrentOrders";    
    }
    
}
