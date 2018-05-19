/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import dbaccess.InventoryMapper;
import dbaccess.UserMapper;
import functionlayer.LoginSampleException;
import functionlayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joklin
 */
public class AddToInventory extends Command {

    String name, desc, unit;
    int status, length, price;
    InventoryMapper im = new InventoryMapper();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        if (request.getParameter("name") != null) {
            name = request.getParameter("name");
        }
        if (request.getParameter("description") != null) {
            desc = request.getParameter("description");
        }
        if (request.getParameter("status") != null) {
            status = Integer.parseInt(request.getParameter("status"));
        }
        if (request.getParameter("length") != null) {
            length = Integer.parseInt(request.getParameter("length"));
        }
        if (request.getParameter("unit") != null) {
            unit = request.getParameter("unit");
        }
        if (request.getParameter("price") != null) {
            price = Integer.parseInt(request.getParameter("price"));
        }

        im.addToInventory(name, desc, length, unit, status, price);

        return "adminpage";
    }

}
