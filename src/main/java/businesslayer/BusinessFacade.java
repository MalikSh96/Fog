package businesslayer;

import datalayer.DataFacade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author malik
 */
public class BusinessFacade {

    // ***USERMAPPER***

    /**
     *
     * @param name
     * @param lastname
     * @param address
     * @param postal
     * @param phone
     * @param email
     * @param password
     * @return user
     * @throws UniversalExceptions
     */
    public static User createUser(String name, String lastname, String address, int postal, int phone, String email, String password) throws UniversalExceptions {
        return DataFacade.createUser(name, lastname, address, postal, phone, email, password);
    }

    /**
     *
     * @param id
     * @return user
     * @throws UniversalExceptions
     */
    public static User getUser(int id) throws UniversalExceptions {
        return DataFacade.getUser(id);
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
        DataFacade.updateUserInfo(id, name, lastname, address, postal, phone, email, password);
    }

    /**
     *
     * @param chosenId
     * @return boolean
     * @throws UniversalExceptions
     */
    public boolean UserIdExists(int chosenId) throws UniversalExceptions {
        return DataFacade.UserIdExists(chosenId);
    }

    /**
     *
     * @param id
     * @return userRole
     * @throws UniversalExceptions
     */
    public String getUserRole(int id) throws UniversalExceptions {
        return DataFacade.getUserRole(id);
    }

    /**
     *
     * @param id
     * @return username
     * @throws UniversalExceptions
     */
    public String getUserName(int id) throws UniversalExceptions {
        return DataFacade.getUserName(id);
    }

    /**
     *
     * @param id
     * @return userLastname
     * @throws UniversalExceptions
     */
    public String getUserLastname(int id) throws UniversalExceptions {
        return DataFacade.getUserLastname(id);
    }

    /**
     *
     * @param email
     * @return userID
     * @throws UniversalExceptions
     */
    public int getUserId(String email) throws UniversalExceptions {
        return DataFacade.getUserId(email);
    }

    /**
     *
     * @return list
     * @throws UniversalExceptions
     */
    public List<Integer> getAllUserIds() throws UniversalExceptions {
        return DataFacade.getAllUserIds();
    }

    // ***ORDERMAPPER***

    /**
     *
     * @param id
     * @param length
     * @param width
     * @param height
     * @throws UniversalExceptions
     */
    public static void createOrder(int id, int length, int width, int height) throws UniversalExceptions {
        Orders ord = new Orders(id, length, width, height);
        DataFacade.createOrder(ord);
    }

    /**
     *
     * @return orderId
     * @throws UniversalExceptions
     */
    public static int getOrderId() throws UniversalExceptions {
        return DataFacade.getOrderId();
    }

    /**
     *
     * @return latestOrderId
     * @throws UniversalExceptions
     */
    public static int getLatestOrderId() throws UniversalExceptions {
        return DataFacade.getOrderId();
    }

    /**
     *
     * @param chosenId
     * @return boolean
     * @throws UniversalExceptions
     */
    public boolean OrderIdExists(int chosenId) throws UniversalExceptions {
        return DataFacade.OrderIdExists(chosenId);
    }

    /**
     *
     * @param id
     * @throws UniversalExceptions
     */
    public void sendOrder(int id) throws UniversalExceptions {
        DataFacade.sendOrder(id);
    }

    /**
     *
     * @param id
     * @return list
     * @throws UniversalExceptions
     */
    public static List<Integer> allCustomerOrdersId(int id) throws UniversalExceptions {
        return DataFacade.allCustomerOrdersId(id);
    }

    /**
     *
     * @return list
     * @throws UniversalExceptions
     */
    public static List<Integer> getAllOrderIds() throws UniversalExceptions {
        return DataFacade.getAllorderIds();
    }

    /**
     *
     * @param id
     * @return order
     * @throws UniversalExceptions
     */
    public static Orders getOrder(int id) throws UniversalExceptions {
        return DataFacade.getOrder(id);
    }

    /**
     *
     * @param id
     * @return userId
     * @throws UniversalExceptions
     */
    public static int getUserId(int id) throws UniversalExceptions {
        return DataFacade.getUserId(id);
    }

    /**
     *
     * @param id
     * @return orderPrice
     * @throws UniversalExceptions
     */
    public static int getOrderPrice(int id) throws UniversalExceptions {
        return DataFacade.getOrderPrice(id);
    }

    /**
     *
     * @return list
     * @throws UniversalExceptions
     */
    public static List<Integer> getNonSentOrderId() throws UniversalExceptions {
        return DataFacade.getNonSentOrderId();
    }

    /**
     *
     * @return list
     * @throws UniversalExceptions
     */
    public static List<String> getNonSentOrderDates() throws UniversalExceptions {
        return DataFacade.getNonSentOrderDates();
    }

    /**
     *
     * @return list
     * @throws UniversalExceptions
     */
    public static List<Integer> getNonSentOrderCustomerIds() throws UniversalExceptions {
        return DataFacade.getNonSentOrderCustomerIds();
    }

    /**
     *
     * @param totalPrice
     * @param orderId
     * @throws UniversalExceptions
     */
    public void updateTotalPrice(int totalPrice, int orderId) throws UniversalExceptions {
        DataFacade.updateTotalPrice(totalPrice, orderId);
    }
    
    /**
     *
     * @param userId
     * @return list
     * @throws UniversalExceptions
     */
    public static List<String> getAllUserOrderDates(int userId) throws UniversalExceptions {
    return DataFacade.getAllUserOrderDates(userId);
}

    // ***INVENTORYMAPPER***

    /**
     *
     * @param name
     * @return itemId
     * @throws UniversalExceptions
     */
    public static int getItemId(String name) throws UniversalExceptions {
        return DataFacade.getItemId(name);
    }

    /**
     *
     * @param id
     * @return itemLength
     * @throws UniversalExceptions
     */
    public static int getItemLength(int id) throws UniversalExceptions {
        return DataFacade.getItemLength(id);
    }

    /**
     *
     * @param id
     * @return itemDescription
     * @throws UniversalExceptions
     */
    public static String getItemDescription(int id) throws UniversalExceptions {
        return DataFacade.getItemDesc(id);
    }

    /**
     *
     * @param id
     * @return itemName
     * @throws UniversalExceptions
     */
    public static String getItemName(int id) throws UniversalExceptions {
        return DataFacade.getItemName(id);
    }

    /**
     *
     * @param name
     * @return itemUnit
     * @throws UniversalExceptions
     */
    public String getItemUnit(String name) throws UniversalExceptions {
        return DataFacade.getItemUnit(name);
    }

    /**
     *
     * @param id
     * @return itemStatus
     * @throws UniversalExceptions
     */
    public int getItemStatus(int id) throws UniversalExceptions {
        return DataFacade.getItemStatus(id);
    }

    /**
     *
     * @param id
     * @return itemPrice
     * @throws UniversalExceptions
     */
    public static int getItemPrice(int id) throws UniversalExceptions {
        return DataFacade.getItemPrice(id);
    }

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
    public static void updateInventory(int inventoryId, String name, String desc, int length, String unit, int status, int price) throws UniversalExceptions {
        DataFacade.updateInventory(inventoryId, name, desc, length, unit, status, price);
    }

    /**
     *
     * @param itemId
     * @param amount
     * @return boolean
     * @throws UniversalExceptions
     */
    public static boolean updateStatus(int itemId, int amount) throws UniversalExceptions {
        return DataFacade.updateStatus(itemId, amount);
    }

    /**
     *
     * @param itemId
     * @param amount
     * @param wrongId
     * @throws UniversalExceptions
     */
    public static void reverseStatusUpdate(int itemId, int amount, List<Integer> wrongId) throws UniversalExceptions {
        DataFacade.reverseStatusUpdate(itemId, amount, wrongId);
    }

    /**
     *
     * @param name
     * @param desc
     * @param length
     * @param unit
     * @param status
     * @param price
     * @throws UniversalExceptions
     */
    public void addToInventory(String name, String desc, int length, String unit, int status, int price) throws UniversalExceptions {
        DataFacade.addToInventory(name, desc, length, unit, price, status);
    }

    /**
     *
     * @return list
     * @throws UniversalExceptions
     */
    public static List<Inventory> completeInventory() throws UniversalExceptions {
        return DataFacade.completeInventory();
    }

    // ***ITEMLISTMAPPER***

    /**
     *
     * @param name
     * @param desc
     * @param length
     * @param amount
     * @param orderId
     * @param id
     * @throws UniversalExceptions
     */
    public static void addToItemList(String name, String desc, int length, int amount, int orderId, int id) throws UniversalExceptions {
        DataFacade.addToItemList(name, desc, length, amount, orderId, id);
        DataFacade.updateStatus(DataFacade.getItemId(name), amount);
    }

    /**
     *
     * @param orderId
     * @return list
     * @throws UniversalExceptions
     */
    public List<String> getFullItemlist(int orderId) throws UniversalExceptions {
        return DataFacade.getFullItemList(orderId);
    }

    /**
     *
     * @param price
     * @param amount
     * @return totalPrice
     */
    public static int calculateTotalPrice(int price, int amount) {

        return price * amount;
    }

    /**
     *
     * @param id
     * @return list
     * @throws UniversalExceptions
     */
    public List<Integer> getFullItemlistId(int id) throws UniversalExceptions {
        return DataFacade.getFullItemlistId(id);
    }

    /**
     *
     * @param orderId
     * @param itemId
     * @return amount
     * @throws UniversalExceptions
     */
    public int getAmount(int orderId, int itemId) throws UniversalExceptions {
        return DataFacade.getAmount(orderId, itemId);
    }

    /**
     *
     * @param orderId
     * @return list
     * @throws UniversalExceptions
     */
    public List<Integer> getAmountList(int orderId) throws UniversalExceptions {
        return DataFacade.getAmountList(orderId);
    }

    // ***BUSINESSLAYER***

    /**
     *
     * @param length
     * @return calculateRemAmount
     */
    public static int calculateRemAmount(int length) {
        return ItemList.remAmount(length).get(0);
    }

    /**
     *
     * @param length
     * @param width
     * @return calculateRaftAmount
     */
    public static int calculateRaftAmount(int length, int width) {
        return ItemList.raftAmount(length, width).get(0);
    }

    /**
     *
     * @param length
     * @param width
     * @return calculatePostAmount
     */
    public static int calculatePostAmount(int length, int width) {
        return ItemList.postAmount(length, width).get(0);
    }

    /**
     *
     * @param length
     * @param width
     * @return calculateRoofAmount
     */
    public static int calculateRoofAmount(int length, int width) {
        return ItemList.roofAmount(length, width).get(0);
    }
    
    /**
     *
     * @param dates
     * @param ids
     * @return list
     */
    public static List<String> combineUserOrderDatesWithId(List<String> dates, List<Integer> ids)  {
        
        List<String> result = new ArrayList<>();
        result.add("<div class=\"container\">");
        result.add("<table class=\"table table-hover\">");
        result.add( "<tr>");
        result.add("<th scope=\"col\">#</th>");  
        result.add("<th scope=\"col\">Dato</th>");
        result.add("</tr>");
        if(dates.size() == ids.size()) 
            for (int i = 0; i < dates.size(); i++) {
                
                result.add("<tr><th scope=\"row\"><p><a href=\"FrontController?command=specificOrder&chosenid=" + ids.get(i) + "\">"+ ids.get(i) + "</a></th><td><p>" + " "+ dates.get(i) + "</td></tr>");
               // result.add("<th><p>"+ids.get(i) + "</th><th><p>" + dates.get(i) + "<th><br>");
               // result.add(""+ids.get(i) + " " + dates.get(i) + "<br>");
            }
        result.add("</table>");
        result.add("</div>");
        return result;
    }
    
    /**
     *
     * @param idsOrdre
     * @param name
     * @param lastname
     * @param dates
     * @return list
     */
    public static List<String> allsCurrentOrdes( List<Integer> idsOrdre, List<String> name, List<String> lastname, List<String> dates){
        
        List<String> result = new ArrayList<>();
        result.add("<div class=\"contatiner\">");
        result.add("<table class=\"table table-hover\">");
        result.add("<tr>");

        result.add("<th scope=\"col\">OrdreId</th>");
        result.add("<th scope=\"col\">firstname</th>");
        result.add("<th scope=\"col\">lastname</th>");
        result.add("<th scope=\"col\">Dato</th>");
        result.add("</tr>");
    
        for (int i = 0; i < idsOrdre.size(); i++) {    
            result.add("<tr>");
            result.add("<td> <p><a href=\"FrontController?command=specificOrder&chosenid=" + idsOrdre.get(i) + "\">"+ idsOrdre.get(i) +  "</a></p></td>");
            result.add("<td> <p>" + name.get(i) + "</p></td>");
            result.add("<td><p>" + lastname.get(i) + "</p></td>");
            result.add("<td><p>" + dates.get(i) + "</p></td>");
            result.add("</tr>");
        }
        result.add("</table>");
        result.add("</div>");
        
        return result;
    }
    
    /**
     *
     * @param idsOrdre
     * @param name
     * @param lastname
     * @param dates
     * @return list
     */
    public static List<String> allsOrdes( List<Integer> idsOrdre, List<String> name, List<String> lastname, List<String> dates){
        
        List<String> result = new ArrayList<>();
        result.add("<div class=\"contatiner\">");
        result.add("<table class=\"table table-hover\">");
        result.add("<tr>");

        result.add("<th scope=\"col\">OrdreId</th>");
        result.add("<th scope=\"col\">firstname</th>");
        result.add("<th scope=\"col\">lastname</th>");
        result.add("<th scope=\"col\">Dato</th>");
        result.add("</tr>");
    
        for (int i = 0; i < idsOrdre.size(); i++) {    
            result.add("<tr>");
            result.add("<td> <p><a href=\"FrontController?command=specificOrder&chosenid=" + idsOrdre.get(i) + "\">"+ idsOrdre.get(i) +  "</a></p></td>");
            result.add("<td> <p>" + name.get(i) + "</p></td>");
            result.add("<td><p>" + lastname.get(i) + "</p></td>");
            result.add("<td><p>" + dates.get(i) + "</p></td>");
            result.add("</tr>");
        }
        result.add("</table>");
        result.add("</div>");
        
        return result;
    }
            
    /**
     *
     * @param ids
     * @return list
     * @throws UniversalExceptions
     */
    public List<String> allCurrentOrderCustomerNames(List<Integer> ids) throws UniversalExceptions {
        List<String> names = new ArrayList<>();
        
        for (int i = 0; i < ids.size(); i++) {
            names.add(getUserName(ids.get(i)));
        }
        return names;
    }
            
    /**
     *
     * @param ids
     * @return list
     * @throws UniversalExceptions
     */
    public List<String> allCurrentOrderCustomerLastnames(List<Integer> ids) throws UniversalExceptions {
        List<String> lastnames = new ArrayList<>();
        
        for (int i = 0; i < ids.size(); i++) {
            lastnames.add(getUserLastname(ids.get(i)));
        }
        return lastnames;
    }
}
