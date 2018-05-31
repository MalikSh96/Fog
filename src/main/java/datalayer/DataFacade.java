package datalayer;

import businesslayer.Constants;
import businesslayer.Inventory;
import businesslayer.UniversalExceptions;
import businesslayer.Orders;
import businesslayer.User;
import java.util.List;

/**
 *
 * @author malik
 */
public class DataFacade {

    private static final Constants con = new Constants();

    //User section
    /**
     *
     * @param email
     * @param password
     * @return login
     * @throws UniversalExceptions
     */
    public static User login(String email, String password) throws UniversalExceptions {
        return con.getUM().login(email, password);
    }

    /**
     *
     * @param name
     * @param lastname
     * @param address
     * @param postalcode
     * @param phone
     * @param email
     * @param password
     * @return user
     * @throws UniversalExceptions
     */
    public static User createUser(String name, String lastname, String address, 
            int postalcode, int phone, String email, String password) throws UniversalExceptions {
        User user = new User(name, lastname, address, postalcode, phone, email, password, "customer");
        con.getUM().createUser(user);
        return user;
    }

    /**
     *
     * @param id
     * @return user
     * @Description: Return as user with specific id
     * @throws UniversalExceptions
     */
    public static User getUser(int id) throws UniversalExceptions {
        return con.getUM().getUser(id);
    }

    /**
     *
     * @param id
     * @param name
     * @param lastname
     * @param address
     * @param postal
     * @param phone
     * @param email
     * @param password
     * @throws UniversalExceptions
     */
    public static void updateUserInfo(int id, String name, String lastname, String address, int postal, int phone, String email, String password) throws UniversalExceptions {
        con.getUM().UpdateUserInfo(id, name, lastname, address, postal, phone, email, password);
    }

    /**
     *
     * @param chosenId
     * @return 
     * @throws UniversalExceptions
     */
    public static boolean UserIdExists(int chosenId) throws UniversalExceptions {
        return con.getUM().UserIdExists(chosenId);
    }

    /**
     *
     * @param id
     * @return userRole
     * @Description: Gets the role of a specific user
     * @throws UniversalExceptions
     */
    public static String getUserRole(int id) throws UniversalExceptions {
        return con.getUM().getUserRole(id);
    }

    /**
     *
     * @param id
     * @return username
     * @Description: Gets name of a user with specific id
     * @throws UniversalExceptions
     */
    public static String getUserName(int id) throws UniversalExceptions {
        return con.getUM().getUserName(id);
    }

    /**
     *
     * @param id
     * @return lastname
     * @Description: Gets the lastname for a user with a specific id
     * @throws UniversalExceptions
     */
    public static String getUserLastname(int id) throws UniversalExceptions {
        return con.getUM().getUserLastname(id);
    }

    /**
     *
     * @param email
     * @return userId
     * @Description: Gets the id of user using email
     * @throws UniversalExceptions
     */
    public static int getUserId(String email) throws UniversalExceptions {
        return con.getUM().getUserId(email);
    }

    /**
     *
     * @return allUserIds
     * @Description: Gets a list with all user ids
     * @throws UniversalExceptions
     */
    public static List<Integer> getAllUserIds() throws UniversalExceptions {
        return con.getUM().getAllUserIds();
    }

    public static List<String> getAllUserNames() throws UniversalExceptions {
        return con.getUM().getAllUserNames();
    }

    public static List<String> getAllUserLastnames() throws UniversalExceptions {
        return con.getUM().getAllUserLastnames();
    }

    public static List<String> getAllUserInfo(int userId) throws UniversalExceptions {
        return con.getUM().getAllUserInfo(userId);
    }
    /**
     *
     * @param ord
     * @return ord
     * @Description: Returns an order created
     * @throws UniversalExceptions
     */
    public static Orders createOrder(Orders ord) throws UniversalExceptions {
        OrderMapper.createPreOrder(ord);
        return ord;
    }

    /**
     *
     * @return orderId
     * @Description: Gets an order id
     * @throws UniversalExceptions
     */
    public static int getOrderId() throws UniversalExceptions {
        return con.getOM().getLatestOrder();
    }

    /**
     *
     * @param chosenId
     * @return boolean
     * @Description: Checks if an order with a specific id exists
     * @throws UniversalExceptions
     */
    public static boolean OrderIdExists(int chosenId) throws UniversalExceptions {
        return con.getOM().orderIdExists(chosenId);
    }

    /**
     *
     * @param id
     * @Description: Send the order for the specific id
     * @throws UniversalExceptions
     */
    public static void sendOrder(int id) throws UniversalExceptions {
        con.getOM().sendOrder(id);
    }

    /**
     *
     * @param id
     * @return customerOrderId
     * @throws UniversalExceptions
     */
    public static List<Integer> allCustomerOrdersId(int id) throws UniversalExceptions {
        return con.getOM().allCustomerOrdersId(id);
    }

    /**
     *
     * @param id
     * @return order
     * @throws UniversalExceptions
     */
    public static Orders getOrder(int id) throws UniversalExceptions {
        return con.getOM().getOrder(id);
    }

    /**
     *
     * @param id
     * @return price
     * @throws UniversalExceptions
     */
    public static int getOrderPrice(int id) throws UniversalExceptions {
        return con.getOM().getPrice(id);
    }

    /**
     *
     * @return allOrderIds
     * @throws UniversalExceptions
     */
    public static List<Integer> getAllorderIds() throws UniversalExceptions {
        return con.getOM().getAllOrderIds();
    }

    /**
     *
     * @return nonSentOrderId
     * @throws UniversalExceptions
     */
    public static List<Integer> getNonSentOrderId() throws UniversalExceptions {
        return con.getOM().getNonSentOrderId();
    }

    /**
     *
     * @return nonSentOrderDates
     * @throws UniversalExceptions
     */
    public static List<String> getNonSentOrderDates() throws UniversalExceptions {
        return con.getOM().getNonSentOrderDates();
    }
    public static List<String> getAllOrderDates() throws UniversalExceptions {
         return con.getOM().getAllOrderDates();
    }
    /**
     *
     * @return nonSentOrderCustomerIds
     * @throws UniversalExceptions
     */
    public static List<Integer> getNonSentOrderCustomerIds() throws UniversalExceptions {
        return con.getOM().getNonSentOrderCustomerIds();
    }

    public static List<Integer> getOrderCustomerIds() throws  UniversalExceptions {
        return con.getOM().getOrderCustomerIds();
    }
    
    /**
     *
     * @param orderId
     * @return userId
     * @throws UniversalExceptions
     */
    public static int getUserId(int orderId) throws UniversalExceptions {
        return con.getOM().getUserId(orderId);
    }

    /**
     *
     * @param totalPrice
     * @param orderId
     * @throws UniversalExceptions
     */
    public static void updateTotalPrice(int totalPrice, int orderId) throws UniversalExceptions {
        con.getOM().updateTotalPrice(totalPrice, orderId);
    }

    /**
     *
     * @param userId
     * @return allUserOrderDates
     * @throws UniversalExceptions
     */
    public static List<String> getAllUserOrderDates(int userId) throws UniversalExceptions {
        return con.getOM().getAllUserOrderDates(userId);
    }
    
    public static int getUserIdFromOrderId(int orderId) throws UniversalExceptions {
        return con.getOM().getUserIdFromOrderId(orderId);
    }

    //itemlist section
    /**
     *
     * @param name
     * @param desc
     * @param length
     * @param amount
     * @param orderId
     * @param itemId
     * @throws UniversalExceptions
     */
    public static void addToItemList(String name, String desc, int length, 
            int amount, int orderId, int itemId) throws UniversalExceptions {
        con.getILM().addToItemlist(name, desc, length, amount, orderId, itemId);
    }

    /**
     *
     * @param id
     * @return fullItemListId
     * @throws UniversalExceptions
     */
    public static List<Integer> getFullItemlistId(int id) throws UniversalExceptions {
        return con.getILM().getFullItemlistId(id);
    }

    /**
     *
     * @param id
     * @param id2
     * @return amount
     * @throws UniversalExceptions
     */
    public static int getAmount(int id, int id2) throws UniversalExceptions {
        return con.getILM().getAmount(id, id2);
    }

    /**
     *
     * @param orderId
     * @return amountList
     * @throws UniversalExceptions
     */
    public static List<Integer> getAmountList(int orderId) throws UniversalExceptions {
        return con.getILM().getFullItemlistId(orderId);
    }

    //inventory section
    /**
     *
     * @param inventoryId
     * @param name
     * @param desc
     * @param length
     * @param unit
     * @param status
     * @param price
     * @throws UniversalExceptions
     */
    public static void updateInventory(int inventoryId, String name, String desc, 
            int length, String unit, int status, int price) throws UniversalExceptions {
        con.getIM().UpdateInventory(inventoryId, name, desc, length, unit, status, price);
    }

    /**
     *
     * @param orderId
     * @return fullItemList
     * @throws UniversalExceptions
     */
    public static List<String> getFullItemList(int orderId) throws UniversalExceptions {
        return con.getILM().getFullItemlist(orderId);
    }

    /**
     *
     * @param name
     * @return itemId
     * @throws UniversalExceptions
     */
    public static int getItemId(String name) throws UniversalExceptions {
        return con.getIM().getId(name);
    }

    /**
     *
     * @param id
     * @return itemLength
     * @throws UniversalExceptions
     */
    public static int getItemLength(int id) throws UniversalExceptions {
        return con.getIM().getLength(id);
    }

    /**
     *
     * @param id
     * @return ItemDescription
     * @throws UniversalExceptions
     */
    public static String getItemDesc(int id) throws UniversalExceptions {
        return con.getIM().getDescription(id);
    }

    /**
     *
     * @param id
     * @return itemName
     * @throws UniversalExceptions
     */
    public static String getItemName(int id) throws UniversalExceptions {
        return con.getIM().getName(id);
    }

    /**
     *
     * @param id
     * @return itemPrice
     * @throws UniversalExceptions
     */
    public static int getItemPrice(int id) throws UniversalExceptions {
        return con.getIM().getPrice(id);
    }

    /**
     *
     * @param name
     * @return itemUnit
     * @throws UniversalExceptions
     */
    public static String getItemUnit(String name) throws UniversalExceptions {
        return con.getIM().getUnit(name);
    }

    /**
     *
     * @param id
     * @return itemStatus
     * @throws UniversalExceptions
     */
    public static int getItemStatus(int id) throws UniversalExceptions {
        return con.getIM().getStatus(id);
    }

    /**
     *
     * @param itemId
     * @param amount
     * @return updateStatus
     * @throws UniversalExceptions
     */
    public static boolean updateStatus(int itemId, int amount) throws UniversalExceptions {
        return con.getIM().updateStatus(itemId, amount);
    }

    /**
     *
     * @param itemId
     * @param amount
     * @param wrongId
     * @throws UniversalExceptions
     */
    public static void reverseStatusUpdate(int itemId, int amount, List<Integer> wrongId) throws UniversalExceptions {
        con.getIM().reverseStatusUpdate(itemId, amount, wrongId);
    }

    /**
     *
     * @param name
     * @param desc
     * @param length
     * @param unit
     * @param price
     * @param status
     * @throws UniversalExceptions
     */
    public static void addToInventory(String name, String desc, int length, 
            String unit, int price, int status) throws UniversalExceptions {
        con.getIM().addToInventory(name, desc, length, unit, price, status);
    }

    /**
     *
     * @return completeInventory
     * @throws UniversalExceptions
     */
    public static List<Inventory> completeInventory() throws UniversalExceptions {
        return con.getIM().completeInventory();
    }

    public static List<String> getAllItemUnit() throws UniversalExceptions {
            return con.getIM().getAllItemUnit(); 
    }

    public static List<String> getAllItemDesc() throws UniversalExceptions {
            return con.getIM().getAllItemDesc();
    }

    public static List<String> getAllItemNames() throws UniversalExceptions {
            return con.getIM().getAllItemNames();
    }

    public static List<Integer> getAllItemIds() throws UniversalExceptions {
             return con.getIM().getAllItemIds();
    }

    public static List<Integer> getAllItemLength() throws UniversalExceptions {
            return con.getIM().getAllItemLength();
    }

    public static List<Integer> getAllItemStatus() throws UniversalExceptions {
            return con.getIM().getAllItemLength();
    }

    public static List<Integer> getAllItemPrice() throws UniversalExceptions {    
        return con.getIM().getAllItemPrice();
    }
}
