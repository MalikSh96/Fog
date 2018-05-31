package maintest;

import businesslayer.BusinessFacade;
import businesslayer.Constants;
import businesslayer.ItemList;
import businesslayer.UniversalExceptions;
import businesslayer.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws UniversalExceptions, ClassNotFoundException, SQLException {
        
        Constants con = new Constants();
        BusinessFacade bf = con.getBf();
        User us = bf.getUser(5);
//        int id = 0;
//        if (us.isAdmin(bf.getUserRole(us.getId())) && !bf.getOrder(id).isOrderConfirmed() || bf.getUserRole(bf.getUserId(us.getEmail())).equals("storagechief") && !bf.getOrder(id).isOrderConfirmed()) {
//            
//        }
        bf.sendOrder(4);
        boolean possible = true;
        List<Integer> itemIds = bf.getFullItemlistId(8);
        System.out.println(bf.getFullItemlist(8));
//        List<Integer> wrongIds = new ArrayList<>();
//       for (int i = 0; i < itemIds.size(); i++) {
//            if (!bf.updateStatus(itemIds.get(i), bf.getAmount(8, itemIds.get(i)))) {
//                possible = false;
//                wrongIds.add(itemIds.get(i));
//            }
//            System.out.println(possible);

//        if(bf.getUserRole(bf.getUserId(us.getEmail())).equals("seller")){ System.out.println(bf.getUserRole(7));}
//        System.out.println(bf.getUserRole(5));
//        ItemList il = new ItemList();
//        System.out.println("Post: " + il.postAmount(800, 600));
//        System.out.println("Raft: " + il.raftAmount(800, 400));
//        System.out.println("Rem: " + il.remAmount(800));

    }
}
