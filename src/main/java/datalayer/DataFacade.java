package datalayer;

import businesslayer.LoginSampleException;
import businesslayer.User;
import datalayer.UserMapper;
import javax.servlet.http.HttpSession;

/**
 * The purpose of DataFacade is to...
 *
 * @author kasper
 */
public class DataFacade 
        
{       
        
    public static User login(String email, String password) throws LoginSampleException 
    {
        return UserMapper.login(email, password);
    }
    
    public static User createUser(String name, String lastname, String address, int postalcode, int phone, String email, String password) throws LoginSampleException 
    {
        User user = new User(name, lastname, address, postalcode, phone, email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }
    
//    public static boolean updateUserInfo() {
//        
//        
//        HttpSession session = request.getSession();
//        userID = (int) session.getAttribute("id");
//        User user = um.getUser(userID);
//        name = user.getName();
//        lastname = user.getLastname();
//        address = user.getAddress();
//        email = user.getEmail();
//        postal = user.getPostalcode();
//        phone = user.getPhone();
//        password = user.getPassword();
//        
//
//        if(request.getParameter("name").length() > 0 ){ name = request.getParameter("name");}
//        if(request.getParameter("lastname").length() > 0 ){ lastname = request.getParameter("lastname");}
//        if(request.getParameter("address").length() > 0){ address = request.getParameter("address");} 
//        if(request.getParameter("email").length() > 0) { email = request.getParameter("email"); }
//        if(request.getParameter("postal").length() > 0) { postal = Integer.parseInt(request.getParameter("postal")); }
//        if(request.getParameter("phone").length() > 0) {phone = Integer.parseInt(request.getParameter("phone")); }
//        if(request.getParameter("password").length() > 0){ password = request.getParameter("password");}
//
//        
//        um.UpdateUserInfo(userID, name, lastname, address, postal, phone, email, password);
//    }
    
    public static void addToItemList(String name, String desc, int length, int amount, int orderId, int itemId) {
        ItemlistMapper.addToItemlist(name, desc, length, amount, orderId, itemId);
    }
    
    public static int getOrderId() {
        return OrderMapper.getLatestOrder();
    }
    
    public static int getItemLength(int id) {
        return InventoryMapper.getLength(id);
    }
    
    public static String getItemDesc(int id) {
        return InventoryMapper.getDescription(id);
    }
    
    public static String getItemName(int id) {
        return InventoryMapper.getName(id);
    }
}
