/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import functionlayer.Orders;
import functionlayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author malik
 */
public class OrderMapper {
    
    public int createPreOrder(Orders ord) 
    {
        int orderId = 0;
        try 
        {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (userID, length, width, height) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS ); 
            ps.setInt(1, ord.getUserId()); //user id
            ps.setInt(2, ord.getLength());
            ps.setInt(3, ord.getWidth());
            ps.setInt(4, ord.getHeight());

            System.out.println("Check sql order " + SQL);

            int check = ps.executeUpdate();
            if(check == 1)
            {
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                orderId = ids.getInt( 1 );
                System.out.println("Debug " + orderId);
                return orderId;

            }
        } catch ( SQLException | ClassNotFoundException ex ) { //temporary error
            throw new Error( ex.getMessage() );
        }
        return orderId;
    }

    public Orders getOrder(int orderId) 
    {
        Orders ord = null;
        try 
        {
            Connection con = Connector.connection();
            String SQL = "select * from orders where orderid = ?";

            PreparedStatement ps = con.prepareStatement( SQL); 
            ps.setInt(1, orderId);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                int userID = rs.getInt("userID");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                ord  = new Orders(orderId, userID, length, width, height);
                System.out.println("Debug " + orderId);
                return ord;

            }
        } catch ( SQLException | ClassNotFoundException ex ) { //temporary error
            throw new Error( ex.getMessage() );
        }
        return ord;
    }
    
    public List<Orders> allOrders()
    {
        List<Orders> orders = new ArrayList<>();
        Orders ord = null;
        try 
        {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders order by orderId desc";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next())
            {   
                int id = resultset.getInt("orderId");
                int userID = resultset.getByte("userID");
                int length = resultset.getInt("length");
                int width = resultset.getInt("width");
                int height = resultset.getInt("height");
                
                
                ord = new Orders(id, userID, length, width, height);
                orders.add(ord);
               
            }
            System.out.println("sql syntax ok? " + SQL);
            
        } catch ( SQLException | ClassNotFoundException ex ) { //temporary error
            throw new Error( ex.getMessage() );
        }
        
        return orders;
    }
    
    public List<Orders> confirmedOrders()
    {
        List<Orders> orders = new ArrayList<>();
        Orders ord = null;
        
        try 
        {
            Connection con = Connector.connection();
            String SQL = "select * from FogUsers.orders where orderConfirmed "
                    + "= '1' order by orderId desc;";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next())
            {   
                int id = resultset.getInt("orderId");
                int userID = resultset.getByte("userID");
                int length = resultset.getInt("length");
                int width = resultset.getInt("width");
                int height = resultset.getInt("height");
                boolean conf = resultset.getBoolean("orderConfirmed");

                ord = new Orders(id, userID, length, width, height, conf);
                orders.add(ord);
                
            }
            System.out.println("sql syntax ok? " + SQL);
            
        } catch ( SQLException | ClassNotFoundException ex ) { //temporary error
            throw new Error( ex.getMessage() );
        }
        
        return orders;
    }
    

    public List<Orders> pendingOrders()
    {
        List<Orders> orders = new ArrayList<>();
        Orders ord = null;

        try 
        {
            Connection con = Connector.connection();
            String SQL = "select * from FogUsers.orders where orderConfirmed "
                    + "= '0' order by orderId desc;";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while(resultset.next())
            {
                int id = resultset.getInt("orderId");
                int userID = resultset.getByte("userID");
                int length = resultset.getInt("length");
                int width = resultset.getInt("width");
                int height = resultset.getInt("height");
                boolean conf = resultset.getBoolean("orderConfirmed");

                ord = new Orders(id, userID, length, width, height, conf);
                orders.add(ord);

            }
            System.out.println("sql syntax ok? " + SQL);

        } catch ( SQLException | ClassNotFoundException ex ) { //temporary error
            throw new Error( ex.getMessage() );
        }

        return orders;
    }

    public List<Orders> allCustomerOrders(int id)

    {
        List<Orders> orders = new ArrayList<>();
        Orders ord = null;
        
        try 
        {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM FogUsers.orders where userID = " + id;
            
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();
            
            while(resultset.next())
            {   
                int orderId = resultset.getInt("orderId");
                int userID = resultset.getByte("userID");
                int length = resultset.getInt("length");
                int width = resultset.getInt("width");
                int height = resultset.getInt("height");
                boolean conf = resultset.getBoolean("orderConfirmed");


//                ord = new Orders(id, userID, length, width, height, conf);
//                orders.add(ord);
             
                if(userID == id)
                {
                    ord = new Orders(orderId, userID, length, width, height, conf);
                    orders.add(ord);
                }

            }
            System.out.println("sql syntax ok? " + SQL);
            
        } catch ( SQLException | ClassNotFoundException ex ) { //temporary error
            throw new Error( ex.getMessage() );
        }
        
        return orders;
    }
}