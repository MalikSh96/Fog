/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import dbaccess.OrderMapper;
import functionlayer.LoginSampleException;
import functionlayer.Orders;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joklin
 */
public class CustomOrder extends Command {
//int length;

    OrderMapper om = new OrderMapper();
    int length;
    int width;
    int height;

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

//        Orders ord = new Orders(length, width, height);
//        if (ord != null) {
//            //om.createPreOrder(ord);
//            length = Integer.parseInt(request.getParameter("length"));
//            width = Integer.parseInt(request.getParameter("width"));
//            height = Integer.parseInt(request.getParameter("height"));
//            HttpSession session = request.getSession();
//            session.setAttribute("length", length);
//            session.setAttribute("width", width);
//            session.setAttribute("height", height);
//        }


        return "customorder";
    }

}
