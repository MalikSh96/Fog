package businesslayer;

import datalayer.DataFacade;
import java.util.ArrayList;
import java.util.List;

public class BusinessFacade {
    
    static DataFacade df = new DataFacade();
    
    public static User createUser(String name, String lastname, String address, int postal, int phone, String email, String password) throws LoginSampleException {
        return df.createUser(name, lastname, address, postal, phone, email, password);
    }
    
    public static void createItemList(String name, String desc, int length, int amount, int orderId, int id) {
        
      DataFacade.addToItemList(name, desc, length, amount, orderId, id);
    }
    
    
    public static void createOrder(int id, int length, int width, int height, int totalPrice, boolean priced, String what) {
        Orders ord = new Orders(id, length, width, height, totalPrice, true, "priced");
      DataFacade.createOrder(ord);
    }
    
    
    public static int getOrderId() {
        return DataFacade.getOrderId();
    }
    
    public static int getItemLength(int id) {
        return DataFacade.getItemLength(id);
    }
    
    public static String getItemDesc(int id) {
        return DataFacade.getItemDesc(id);
    }
    
    public static String getItemName(int id) {
        return DataFacade.getItemName(id);
    }
    
    public static int calculateRemAmount(int length) {
        return ItemList.remAmount(length).get(0);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static int calculateTotalPrice(int length) {
        return ItemList.remAmount(length).get(0);
    }
    
    
}
