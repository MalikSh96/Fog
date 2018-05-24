package datalayer;

import businesslayer.Constants;
import businesslayer.Inventory;
import businesslayer.LoginSampleException;
import businesslayer.Orders;
import businesslayer.User;
import datalayer.UserMapper;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 * The purpose of DataFacade is to...
 *
 * @author kasper
 */
public class DataFacade {

    private static final Constants con = new Constants();

    //user
    public static User login(String email, String password) throws LoginSampleException {
        return con.getUM().login(email, password);
    }

    public static User createUser(String name, String lastname, String address, int postalcode, int phone, String email, String password) throws LoginSampleException {
        User user = new User(name, lastname, address, postalcode, phone, email, password, "customer");
        con.getUM().createUser(user);
        return user;
    }

    public static User getUser(int id) throws LoginSampleException {
        return con.getUM().getUser(id);
    }

    public static void updateUserInfo(int id, String name, String lastname, String address, int postal, int phone, String email, String password) throws LoginSampleException {
        con.getUM().UpdateUserInfo(id, name, lastname, address, postal, phone, email, password);
    }

    public static boolean UserIdExists(int chosenId) {
        return con.getUM().UserIdExists(chosenId);
    }

    public static String getUserRole(int id) throws LoginSampleException {
    return con.getUM().getUserRole(id);
    }

    public static int getUserId(String email) throws LoginSampleException {
        return con.getUM().getUserId(email);
    }

    public static List<Integer> getAllUserIds() throws LoginSampleException {
        return con.getUM().getAllUserIds();
    }

    //order
    public static Orders createOrder(Orders ord) throws LoginSampleException {
        OrderMapper.createPreOrder(ord);
        return ord;
    }

    public static int getOrderId() {
        return con.getOM().getLatestOrder();
    }

    public static boolean OrderIdExists(int chosenId) {
        return con.getOM().orderIdExists(chosenId);
    }

    public static void sendOrder(int id) {
        con.getOM().sendOrder(id);
    }
    
        public static List<Integer> allCustomerOrdersId(int id) {
        return con.getOM().allCustomerOrdersId(id);
    }

    public static Orders getOrder(int id) {
        return con.getOM().getOrder(id);
    }

    public static int getOrderPrice(int id) {
        return con.getOM().getPrice(id);
    }

    public static List<Integer> getAllorderIds() {
        return con.getOM().getAllOrderIds();
    }

    public static List<Integer> getNonSentOrderId() {
        return con.getOM().getNonSentOrderId();
    }

    //itemlist
    public static void addToItemList(String name, String desc, int length, int amount, int orderId, int itemId) {
        con.getILM().addToItemlist(name, desc, length, amount, orderId, itemId);
    }

    public static List<Integer> getFullItemlistId(int id) {
        return con.getILM().getFullItemlistId(id);
    }
    
    public static int getAmount(int id, int id2) {
    return con.getILM().getAmount(id, id2);
    }

    //inventory
    public static void updateInventory(int inventoryId, String name, String desc, int length, String unit, int status, int price) throws LoginSampleException {
        con.getIM().UpdateInventory(inventoryId, name, desc, length, unit, status, price);
    }

    public static List<String> getFullItemList(int orderId) {
        return con.getILM().getFullItemlist(orderId);
    }

    public static int getItemId(String name) {
        return con.getIM().getId(name);
    }

    public static int getItemLength(int id) {
        return con.getIM().getLength(id);
    }

    public static String getItemDesc(int id) {
        return con.getIM().getDescription(id);
    }

    public static String getItemName(int id) {
        return con.getIM().getName(id);
    }

    public static int getItemPrice(int id) {
        return con.getIM().getPrice(id);
    }

    public static String getItemUnit(String name) {
        return con.getIM().getUnit(name);
    }

    public static int getItemStatus(int id) {
        return con.getIM().getStatus(id);
    }

    public static boolean updateStatus(int itemId, int amount) {
     return con.getIM().updateStatus(itemId, amount);
    }

    public static void reverseStatusUpdate(int itemId, int amount, List<Integer> wrongId) {
    con.getIM().reverseStatusUpdate(itemId, amount, wrongId); 
    }
    
    public static void addToInventory(String name, String desc, int length, String unit, int price, int status) throws LoginSampleException {
     con.getIM().addToInventory(name, desc, length, unit, price, status);
    }

    public static List<Inventory> completeInventory() {
    return con.getIM().completeInventory();
    }


}
