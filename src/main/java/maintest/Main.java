package maintest;

import dbaccess.OrderMapper;
import dbaccess.UserMapper;
import functionlayer.LoginSampleException;
import functionlayer.Orders;
import functionlayer.User;

/**
 *
 * @author malik
 */
public class Main 
{
    public static void main(String[] args) throws LoginSampleException, ClassNotFoundException 
    {
        OrderMapper om = new OrderMapper();

//        Orders o = new Orders(1, 2, 2, 2);

//        Orders o = new Orders(4, 1, 1, 1);
//        System.out.println(om.allCustomerOrders(2).toString());

//        Orders ord = new Orders(1, 10, 8, 6, true);
//        int o = om.createPreOrder(ord);
//        int orderNumber = om.createPreOrder(o);
//        System.out.println("ord num"+orderNumber);
//        System.out.println("Check: " + o + "....orderNumber" + orderNumber);
//        Orders checkOrder = om.getOrder(orderNumber); //works
//        System.out.println("\nCheck2: " + checkOrder + "....orderNumber" + orderNumber); //works
        
//        System.out.println("All orders: " + om.allOrders()); //works

//        System.out.println("Confirmed orders: " + om.confirmedOrders()); //works

//        System.out.println("Pending orders: " + om.pendingOrders());

//        UserMapper um = new UserMapper();
//        User u = new User("Lang", "man", 1111, 1111111111, "mer.com", "1234", "customer");
//        um.createUser(u);
//        System.out.println("T " + u);

        System.out.println("Send?? " + om.isOrderSent(1));
        System.out.println("\nSending order");
        om.sendOrder(1);
        System.out.println("\n");
        System.out.println("Is order send now?? " + om.isOrderSent(1));
    }
}