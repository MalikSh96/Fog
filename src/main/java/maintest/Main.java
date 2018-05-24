package maintest;

import dbaccess.InventoryMapper;
import dbaccess.ItemlistMapper;
import dbaccess.OrderMapper;
import dbaccess.UserMapper;
import functionlayer.Inventory;
import functionlayer.ItemList;
import functionlayer.UniversalExceptions;
import functionlayer.Orders;
import functionlayer.User;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import presentationlayer.Order;

/**
 *
 * @author malik
 */
public class Main {

    public static void main(String[] args) throws UniversalExceptions, ClassNotFoundException, SQLException {
        OrderMapper om = new OrderMapper();
        InventoryMapper im = new InventoryMapper();
        UserMapper um = new UserMapper();
//        Orders ord = new Orders(0, -1, 0);
//        System.out.println("... " + om.createPreOrder(ord));

        ItemList il = new ItemList();
        System.out.println("Post: " + il.postAmount(800, 600));
        System.out.println("Raft: " + il.raftAmount(800, 400));
        System.out.println("Rem: " + il.remAmount(800));


    }
}
