package businesslayer;

import datalayer.DataFacade;
import java.util.ArrayList;
import java.util.List;

public class BusinessFacade {
    
    private static Constants con = new Constants();
    
    //usermapper
    
    public static User createUser(String name, String lastname, String address, int postal, int phone, String email, String password) throws LoginSampleException {
        return DataFacade.createUser(name, lastname, address, postal, phone, email, password);
    }
    
    public static void createItemList(String name, String desc, int length, int amount, int orderId, int id) {
        
      DataFacade.addToItemList(name, desc, length, amount, orderId, id);
    }
    
  
    public static User getUser(int id) throws LoginSampleException {
        return DataFacade.getUser(id);
    }
  
    public static void updateUserInfo(int id, String name, String lastname, String address, int postal, int phone, String email, String password) throws LoginSampleException {
        DataFacade.updateUserInfo(id, name, lastname, address, postal, phone, email, password);
    }

    public boolean UserIdExists(int chosenId) {
     return DataFacade.UserIdExists(chosenId);
             }

    public String getUserRole(int id) throws LoginSampleException {
     return DataFacade.getUserRole(id);
    }
    
    //ordermapper
    
    
    public static void createOrder(int id, int length, int width, int height, int totalPrice, boolean priced, String what) throws LoginSampleException {
      Orders ord = new Orders(id, length, width, height, totalPrice, true, "priced");
      DataFacade.createOrder(ord);
    }
  
    public static int getOrderId() {
        return DataFacade.getOrderId();
    }

    public static int getLatestOrderId() {
        return DataFacade.getOrderId();
    }

    public boolean OrderIdExists(int chosenId) {
     return DataFacade.OrderIdExists(chosenId);
    }
    

    public void sendOrder(int id) {
        DataFacade.sendOrder(id);
    }
    //inventorymapper
    
    public static int getItemId(String name) {
        return DataFacade.getItemId(name);
    }
    
    public static int getItemLength(int id) {
        return DataFacade.getItemLength(id);
    }
    
    public static String getItemDescription(int id) {
        return DataFacade.getItemDesc(id);
    }
    
    public static String getItemName(int id) {
        return DataFacade.getItemName(id);
    }

    public String getItemUnit(String name) {
        return DataFacade.getItemUnit(name);
    }

    public int getItemStatus(int id) {
     return DataFacade.getItemStatus(id);}

    public static int getItemPrice(int id) {
        return DataFacade.getItemPrice(id);
    }
    
    public static void updateInventory(int inventoryId, String name, String desc, int length, String unit, int status, int price) throws LoginSampleException {
        DataFacade.updateInventory(inventoryId, name, desc, length, unit, status, price);
    }
    
    public static boolean updateStatus(int itemId, int amount) {
        return DataFacade.updateStatus(itemId, amount);
    }
    
    public static void reverseStatusUpdate(int itemId, int amount, List<Integer> wrongId) {
        DataFacade.reverseStatusUpdate(itemId, amount, wrongId);
    }
    
    //itemlistmapper
    
    public static void addToItemlist(String name, String desc, int length, int amount, int orderId, int itemId) {
        
    }

    public List<String> getFullItemlist(int orderId) {
        return DataFacade.getFullItemList(orderId);
    }

    public static int calculateTotalPrice(int price, int amount) {       
        
        return price * amount;
    }

    public List<Integer> getFullItemlistId(int id) {
      return DataFacade.getFullItemlistId(id);
    }

    public int getAmount(int orderId, int itemId) {
        return DataFacade.getAmount(orderId, itemId);
    }
    
    //businesslayer
    
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

    
    
}