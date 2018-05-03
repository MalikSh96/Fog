/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;


import functionlayer.LoginSampleException;
import functionlayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author malik
 */
public class UserMapper 
{
    public void createUser(User user) throws LoginSampleException 
    {
        try 
        {
            Connection con = dbaccess.Connector.connection();
            String SQL = "INSERT INTO users (name, address, postalnumber, phone, email, password, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            
            
            String postal = ""+user.getPostalcode();
            String phone = ""+ user.getPhone();

            ps.setString(1, user.getName());
            ps.setString(2, user.getAddress());
            ps.setString(3, postal);
            ps.setString(4, phone);
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPassword());
            ps.setString(7, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);      
            
        } catch (SQLException | ClassNotFoundException ex) 
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static User login(String email, String password) throws LoginSampleException 
    {
        try 
        {
            Connection con = dbaccess.Connector.connection();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) 
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static void getUserId(User user) throws LoginSampleException 
    {
        try 
        {
            Connection con = dbaccess.Connector.connection();
            String SQL = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) 
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}

