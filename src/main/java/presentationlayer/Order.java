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
public class Order extends Command {

    int userID = 0;
    int length = 0;
    int width = 0;
    int height = 0;
    int lengthrafter = 0;
    int heightrafter = 0;
    OrderMapper om = new OrderMapper();
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        userID = (int) session.getAttribute("id");
        length = Integer.parseInt(request.getParameter("length"));
        width = Integer.parseInt(request.getParameter("width"));
        height = Integer.parseInt(request.getParameter("height"));
        lengthrafter = Integer.parseInt(request.getParameter("length")) - 3;
        heightrafter = Integer.parseInt(request.getParameter("height")) - 3;
     //   PreOrder pre = new PreOrder(userID, length, width, height);
        session.setAttribute("længde", length);
        session.setAttribute("vidde", width);
        session.setAttribute("højde", height);
        session.setAttribute("længdespær", lengthrafter);
        session.setAttribute("højdespær", heightrafter);
        Orders ord = new Orders(userID, length, width, height);
        om.createPreOrder(ord);
      
              return "order";
    }

}

/*        til order jsp

<th><p>1x2</th>
<td><p><%out.print(session.getAttribute("længde")); %></td>
<td><p><%out.print(session.getAttribute("vidde")); %></td>
<td><p><%out.print(session.getAttribute("bredde")); %></td>

*/
