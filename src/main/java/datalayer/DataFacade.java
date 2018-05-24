package datalayer;

import businesslayer.Constants;
import businesslayer.Inventory;
import businesslayer.UniversalExceptions;
import businesslayer.Orders;
import businesslayer.User;
import java.util.List;

public class DataFacade {

    private static final Constants con = new Constants();

    //user
    public static User login(String email, String password) throws UniversalExceptions {
        return con.getUM().login(email, password);
    }

    public static User createUser(String name, String lastname, String address, int postalcode, int phone, String email, String password) throws UniversalExceptions {
        User user = new User(name, lastname, address, postalcode, phone, email, password, "customer");
        con.getUM().createUser(user);
        return user;
    }

    public static User getUser(int id) throws UniversalExceptions {
        return con.getUM().getUser(id);
    }

    public static void updateUserInfo(int id, String name, String lastname, String address, int postal, int phone, String email, String password) throws UniversalExceptions {
        con.getUM().UpdateUserInfo(id, name, lastname, address, postal, phone, email, password);
    }

    public static boolean UserIdExists(int chosenId) throws UniversalExceptions {
        return con.getUM().UserIdExists(chosenId);
    }

    public static String getUserRole(int id) throws UniversalExceptions {
        return con.getUM().getUserRole(id);
    }

    public static int getUserId(String email) throws UniversalExceptions {
        return con.getUM().getUserId(email);
    }

    public static List<Integer> getAllUserIds() throws UniversalExceptions {
        return con.getUM().getAllUserIds();
    }

    //order
    public static Orders createOrder(Orders ord) throws UniversalExceptions {
        OrderMapper.createPreOrder(ord);
        return ord;
    }

    public static int getOrderId() throws UniversalExceptions {
        return con.getOM().getLatestOrder();
    }

    public static boolean OrderIdExists(int chosenId) throws UniversalExceptions {
        return con.getOM().orderIdExists(chosenId);
    }

    public static void sendOrder(int id) throws UniversalExceptions {
        con.getOM().sendOrder(id);
    }

    public static List<Integer> allCustomerOrdersId(int id) throws UniversalExceptions {
        return con.getOM().allCustomerOrdersId(id);
    }

    public static Orders getOrder(int id) throws UniversalExceptions {
        return con.getOM().getOrder(id);
    }

    public static int getOrderPrice(int id) throws UniversalExceptions {
        return con.getOM().getPrice(id);
    }

    public static List<Integer> getAllorderIds() throws UniversalExceptions {
        return con.getOM().getAllOrderIds();
    }

    public static List<Integer> getNonSentOrderId() throws UniversalExceptions {
        return con.getOM().getNonSentOrderId();
    }

    public static int getUserId(int orderId) throws UniversalExceptions {
        return con.getOM().getUserId(orderId);
    }

    public static void updateTotalPrice(int totalPrice, int orderId) throws UniversalExceptions {
        con.getOM().updateTotalPrice(totalPrice, orderId);
    }

    //itemlist
    public static void addToItemList(String name, String desc, int length, int amount, int orderId, int itemId) throws UniversalExceptions {
        con.getILM().addToItemlist(name, desc, length, amount, orderId, itemId);
    }

    public static List<Integer> getFullItemlistId(int id) throws UniversalExceptions {
        return con.getILM().getFullItemlistId(id);
    }

    public static int getAmount(int id, int id2) throws UniversalExceptions {
        return con.getILM().getAmount(id, id2);
    }

    public static List<Integer> getAmountList(int orderId) throws UniversalExceptions {
        return con.getILM().getFullItemlistId(orderId);
    }

    //inventory
    public static void updateInventory(int inventoryId, String name, String desc, int length, String unit, int status, int price) throws UniversalExceptions {
        con.getIM().UpdateInventory(inventoryId, name, desc, length, unit, status, price);
    }

    public static List<String> getFullItemList(int orderId) throws UniversalExceptions {
        return con.getILM().getFullItemlist(orderId);
    }

    public static int getItemId(String name) throws UniversalExceptions {
        return con.getIM().getId(name);
    }

    public static int getItemLength(int id) throws UniversalExceptions {
        return con.getIM().getLength(id);
    }

    public static String getItemDesc(int id) throws UniversalExceptions {
        return con.getIM().getDescription(id);
    }

    public static String getItemName(int id) throws UniversalExceptions {
        return con.getIM().getName(id);
    }

    public static int getItemPrice(int id) throws UniversalExceptions {
        return con.getIM().getPrice(id);
    }

    public static String getItemUnit(String name) throws UniversalExceptions {
        return con.getIM().getUnit(name);
    }

    public static int getItemStatus(int id) throws UniversalExceptions {
        return con.getIM().getStatus(id);
    }

    public static boolean updateStatus(int itemId, int amount) throws UniversalExceptions {
        return con.getIM().updateStatus(itemId, amount);
    }

    public static void reverseStatusUpdate(int itemId, int amount, List<Integer> wrongId) throws UniversalExceptions {
        con.getIM().reverseStatusUpdate(itemId, amount, wrongId);
    }

    public static void addToInventory(String name, String desc, int length, String unit, int price, int status) throws UniversalExceptions {
        con.getIM().addToInventory(name, desc, length, unit, price, status);
    }

    public static List<Inventory> completeInventory() throws UniversalExceptions {
        return con.getIM().completeInventory();
    }

}
