/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import businesslayer.BusinessFacade;
import businesslayer.Constants;
import businesslayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joklin
 */
public class AddToInventory extends Command {

    Constants con = new Constants();
    BusinessFacade bf = con.getBf();
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String name = request.getParameter("name");

        String desc = request.getParameter("description");

        int status = Integer.parseInt(request.getParameter("status"));

        int length = Integer.parseInt(request.getParameter("length"));

        String unit = request.getParameter("unit");

        int price = Integer.parseInt(request.getParameter("price"));

        bf.addToInventory(name, desc, length, unit, status, price);

        return "adminpage";
    }

}
