package maintest;

import businesslayer.BusinessFacade;
import businesslayer.Constants;
import businesslayer.ItemList;
import businesslayer.UniversalExceptions;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws UniversalExceptions, ClassNotFoundException, SQLException {
        
        Constants con = new Constants();
        BusinessFacade bf = con.getBf();
        
        ItemList il = new ItemList();
        System.out.println("Post: " + il.postAmount(800, 600));
        System.out.println("Raft: " + il.raftAmount(800, 400));
        System.out.println("Rem: " + il.remAmount(800));

    }
}
