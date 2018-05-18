package maintest;

import dbaccess.InventoryMapper;
import dbaccess.OrderMapper;
import dbaccess.UserMapper;
import functionlayer.Inventory;
import functionlayer.ItemList;
import functionlayer.LoginSampleException;
import functionlayer.Orders;
import functionlayer.User;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author malik
 */
public class Main {

    public static void main(String[] args) throws LoginSampleException, ClassNotFoundException {
        OrderMapper om = new OrderMapper();
        InventoryMapper im = new InventoryMapper();
        UserMapper um = new UserMapper();
        User us = um.getUser(1);
        File file = new File("");
        System.out.println(file.getAbsolutePath() + File.separator + "order nr " + om.getOrderId() + " - Stykliste.txt");
        //System.out.println(System.getProperty("user.home"));
        //System.out.println(System.getProperty("user.home") + File.separator + "Documents" + File.separator +"Stykliste" + File.separator + "order nr " + om.getOrderId() + " - Stykliste.txt");
//        System.out.println(om.getOrderId());
//        System.out.println(um.getUserRole(2));
        
//        im.addToInventory("lars", "er", 4, "tyk", 100);
//
//        List<User> userlist = new ArrayList<>();
//        om.sendOrder(1);
//        userlist = um.getAllUsers();
//        im.updateStatus(1, 20);
//        System.out.println(userlist.toString());
//
//        System.out.println(im.getDescription(4));
//        System.out.println(im.completeInventory().toString());
//
//        Orders o = new Orders(1, 2, 2, 2);
//
//        Orders o = new Orders(4, 1, 1, 1);
//
//        System.out.println(om.allCustomerOrders(2).toString());
//
//        OrderMapper om = new OrderMapper();
//        UserMapper um = new UserMapper();
//        System.out.println(um.getUser(3));
//        um.updateUserInfo(3, "flash", "brandi", 1234, 17565631, "Flækse@flas.dk", "98765");
//
//        System.out.println("\n" + um.getUser(3));
//        Orders o = new Orders(1, 2, 2, 2);
//
//        Orders o = new Orders(4, 1, 1, 1);
//        System.out.println(om.allCustomerOrders(2).toString());
//
//        System.out.println(om.allCustomerOrders(2).toString());
//
//        Orders ord = new Orders(1, 10, 8, 6, true);
//        int o = om.createPreOrder(ord);
//        int orderNumber = om.createPreOrder(o);
//        System.out.println("ord num" + orderNumber);
//        System.out.println("Check: " + o + "....orderNumber" + orderNumber);
//        Orders checkOrder = om.getOrder(orderNumber); //works
//        System.out.println("\nCheck2: " + checkOrder + "....orderNumber" + orderNumber); //works
//
//        System.out.println("All orders: " + om.allOrders()); //works
//
//        System.out.println("Confirmed orders: " + om.confirmedOrders()); //works
//
//        System.out.println("Pending orders: " + om.pendingOrders());
//
//        UserMapper um = new UserMapper();
//        User u = new User("Lang", "man", 1111, 1111111111, "mer.com", "1234", "customer");
//        um.createUser(u);
//        System.out.println("T " + u);

//        System.out.println("Send?? " + om.isOrderSent(1));
//        System.out.println("\nSending order");
//        om.sendOrder(1);
//        System.out.println("\n");
//        System.out.println("Is order send now?? " + om.isOrderSent(1));

//        ItemList i = new ItemList();
//        System.out.println("Post " + i.postAmount(800, 800));
//        System.out.println("Raft " + i.raftAmount(900, 900));
//        System.out.println("Rem " + i.remAmount());
//        System.out.println("Roof " + i.roofAmount(700, 700));
    }
}
