package maintest;

import dbaccess.OrderMapper;
import functionlayer.Order;

/**
 *
 * @author malik
 */
public class Main 
{
    public static void main(String[] args) 
    {
        OrderMapper om = new OrderMapper();
        Order o = new Order(4, 10, 10, 2);
        om.createPreOrder(o);
        System.out.println("Check: " + o);
    }
}
