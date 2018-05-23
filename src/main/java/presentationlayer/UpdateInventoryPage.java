/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;


import businesslayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joklin
 */
public class UpdateInventoryPage extends Command {

    int id = 0;
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
    
                HttpSession session = request.getSession();
                
               id = Integer.parseInt(request.getParameter("choseninventoryid"));
               
                session.setAttribute("inventoryid", id);
        return "updateinventorypage";    
    }
    
}

