package businesslayer;

import datalayer.DataFacade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusinessFacade {

    // ***USERMAPPER***
    public static User createUser(String name, String lastname, String address, int postal, int phone, String email, String password) throws UniversalExceptions {
        return DataFacade.createUser(name, lastname, address, postal, phone, email, password);
    }



    public static User getUser(int id) throws UniversalExceptions {
        return DataFacade.getUser(id);
    }

    public static void updateUserInfo(int id, String name, String lastname, String address, int postal, int phone, String email, String password) throws UniversalExceptions {
        DataFacade.updateUserInfo(id, name, lastname, address, postal, phone, email, password);
    }

    public boolean UserIdExists(int chosenId) throws UniversalExceptions {
        return DataFacade.UserIdExists(chosenId);
    }

    public String getUserRole(int id) throws UniversalExceptions {
        return DataFacade.getUserRole(id);
    }

    public int getUserId(String email) throws UniversalExceptions {
        return DataFacade.getUserId(email);
    }

    public List<Integer> getAllUserIds() throws UniversalExceptions {
        return DataFacade.getAllUserIds();
    }

    // ***ORDERMAPPER***
    public static void createOrder(int id, int length, int width, int height) throws UniversalExceptions {
        Orders ord = new Orders(id, length, width, height);
        DataFacade.createOrder(ord);
    }

    public static int getOrderId() throws UniversalExceptions {
        return DataFacade.getOrderId();
    }

    public static int getLatestOrderId() throws UniversalExceptions {
        return DataFacade.getOrderId();
    }

    public boolean OrderIdExists(int chosenId) throws UniversalExceptions {
        return DataFacade.OrderIdExists(chosenId);
    }

    public void sendOrder(int id) throws UniversalExceptions {
        DataFacade.sendOrder(id);
    }

    public static List<Integer> allCustomerOrdersId(int id) throws UniversalExceptions {
        return DataFacade.allCustomerOrdersId(id);
    }

    public static List<Integer> getAllOrderIds() throws UniversalExceptions {
        return DataFacade.getAllorderIds();
    }

    public static Orders getOrder(int id) throws UniversalExceptions {
        return DataFacade.getOrder(id);
    }

    public static int getUserId(int id) throws UniversalExceptions {
        return DataFacade.getUserId(id);
    }

    public static int getOrderPrice(int id) throws UniversalExceptions {
        return DataFacade.getOrderPrice(id);
    }

    public static List<Integer> getNonSentOrderId() throws UniversalExceptions {
        return DataFacade.getNonSentOrderId();
    }

    public void updateTotalPrice(int totalPrice, int orderId) throws UniversalExceptions {
        DataFacade.updateTotalPrice(totalPrice, orderId);
    }
    
    public static List<String> getAllUserOrderDates(int userId) throws UniversalExceptions {
    return DataFacade.getAllUserOrderDates(userId);
}

    // ***INVENTORYMAPPER***
    public static int getItemId(String name) throws UniversalExceptions {
        return DataFacade.getItemId(name);
    }

    public static int getItemLength(int id) throws UniversalExceptions {
        return DataFacade.getItemLength(id);
    }

    public static String getItemDescription(int id) throws UniversalExceptions {
        return DataFacade.getItemDesc(id);
    }

    public static String getItemName(int id) throws UniversalExceptions {
        return DataFacade.getItemName(id);
    }

    public String getItemUnit(String name) throws UniversalExceptions {
        return DataFacade.getItemUnit(name);
    }

    public int getItemStatus(int id) throws UniversalExceptions {
        return DataFacade.getItemStatus(id);
    }

    public static int getItemPrice(int id) throws UniversalExceptions {
        return DataFacade.getItemPrice(id);
    }

    public static void updateInventory(int inventoryId, String name, String desc, int length, String unit, int status, int price) throws UniversalExceptions {
        DataFacade.updateInventory(inventoryId, name, desc, length, unit, status, price);
    }

    public static boolean updateStatus(int itemId, int amount) throws UniversalExceptions {
        return DataFacade.updateStatus(itemId, amount);
    }

    public static void reverseStatusUpdate(int itemId, int amount, List<Integer> wrongId) throws UniversalExceptions {
        DataFacade.reverseStatusUpdate(itemId, amount, wrongId);
    }

    public void addToInventory(String name, String desc, int length, String unit, int status, int price) throws UniversalExceptions {
        DataFacade.addToInventory(name, desc, length, unit, price, status);
    }

    public static List<Inventory> completeInventory() throws UniversalExceptions {
        return DataFacade.completeInventory();
    }

    // ***ITEMLISTMAPPER***
    public static void addToItemList(String name, String desc, int length, int amount, int orderId, int id) throws UniversalExceptions {
        DataFacade.addToItemList(name, desc, length, amount, orderId, id);
        DataFacade.updateStatus(DataFacade.getItemId(name), amount);
    }

    public List<String> getFullItemlist(int orderId) throws UniversalExceptions {
        return DataFacade.getFullItemList(orderId);
    }

    public static int calculateTotalPrice(int price, int amount) {

        return price * amount;
    }

    public List<Integer> getFullItemlistId(int id) throws UniversalExceptions {
        return DataFacade.getFullItemlistId(id);
    }

    public int getAmount(int orderId, int itemId) throws UniversalExceptions {
        return DataFacade.getAmount(orderId, itemId);
    }

    public List<Integer> getAmountList(int orderId) throws UniversalExceptions {
    return DataFacade.getAmountList(orderId);
    }

    // ***BUSINESSLAYER***
    public static int calculateRemAmount(int length) {
        return ItemList.remAmount(length).get(0);
    }

    public static int calculateRaftAmount(int length, int width) {
        return ItemList.raftAmount(length, width).get(0);
    }

    public static int calculatePostAmount(int length, int width) {
        return ItemList.postAmount(length, width).get(0);
    }

    public static int calculateRoofAmount(int length, int width) {
        return ItemList.roofAmount(length, width).get(0);
    }
    
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
                result.add("<tr><th scope=\"row\"><p>"+ ids.get(i) + "</th><td><p>" + " "+ dates.get(i) + "</td></tr>");
               // result.add("<th><p>"+ids.get(i) + "</th><th><p>" + dates.get(i) + "<th><br>");
               // result.add(""+ids.get(i) + " " + dates.get(i) + "<br>");
            }
        result.add("</table>");
        result.add("</div>");
        return result;
    }
    
    public static List<String> allsCurrentOrdes( List<Integer> ids, String name, String lastname, List<String> dates ){
    
        String intonames[] = name.split(",");
        String intolastnames[] = lastname.split(",");
        
        // prøvet mig frem 
        List<String> ln = new ArrayList<>();
        List<String> na = new ArrayList<>();
        ln = Arrays.asList(intolastnames);
        na = Arrays.asList(intonames);
        // det duer ikke 
        
    List<String> result = new ArrayList<>();
    result.add("<table>");
    result.add("<tr>");
    result.add("<th>#</th>");
    result.add("<th>firstname</th>");
    result.add("<th>lastname</th>");
    result.add("<th>Dato</th>");
    result.add("</tr>");
    
        for (int i = 0; i < ids.size(); i++) {
        result.add("<tr>");
        result.add("<th scope\"row\"><p>" + ids.get(i) + "</th>");
        result.add("<td><p>" + na.get(i) + "</p></td>");
        result.add("<td><p>" + ln.get(i) + "</p></td>");
        result.add("<td><p>" + dates.get(i) + "</p></td>");
        result.add("</tr>");
        }
        result.add("</table>");
    return result;
    }
            

}
