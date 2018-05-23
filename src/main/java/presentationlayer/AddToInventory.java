/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import datalayer.InventoryMapper;
import datalayer.UserMapper;
import businesslayer.LoginSampleException;
import businesslayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joklin
 */
public class AddToInventory extends Command {

    InventoryMapper im = new InventoryMapper();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String name = request.getParameter("name");

        String desc = request.getParameter("description");

        int status = Integer.parseInt(request.getParameter("status"));

        int length = Integer.parseInt(request.getParameter("length"));

        String unit = request.getParameter("unit");

        int price = Integer.parseInt(request.getParameter("price"));

        im.addToInventory(name, desc, length, unit, status, price);

        return "adminpage";
    }

}
