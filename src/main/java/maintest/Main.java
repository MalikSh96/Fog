package maintest;

import dbaccess.OrderMapper;
import functionlayer.Orders;

/**
 *
 * @author malik
 */
public class Main 
{
    public static void main(String[] args) 
    {
        OrderMapper om = new OrderMapper();
        Orders o = new Orders(4, 1, 1, 1);
        int orderNumber = om.createPreOrder(o);
        System.out.println("ord num"+orderNumber);
//        System.out.println("Check: " + o + "....orderNumber" + orderNumber);
        Orders checkOrder = om.getOrder(orderNumber); //works
        System.out.println("\nCheck2: " + checkOrder + "....orderNumber" + orderNumber); //works
        
        System.out.println("All orders: " + om.allOrders()); //works

//        System.out.println("Confirmed orders: " + om.confirmedOrders(o)); //works

//        System.out.println("Pending orders: " + om.pendingOrders(o));
        
    }
}