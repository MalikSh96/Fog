/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import functionlayer.Orders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author malik
 */
public class OrderMapper {
    
    public void createPreOrder(Orders ord) //To test in main
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

            }
        } catch ( SQLException | ClassNotFoundException ex ) { //temporary error
            throw new Error( ex.getMessage() );
        }
    }
}
