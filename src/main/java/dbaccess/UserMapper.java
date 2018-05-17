/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;


import com.mysql.cj.api.mysqla.result.Resultset;
import functionlayer.LoginSampleException;
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
public class UserMapper 
{
    public static void createUser(User user) throws LoginSampleException 
     {
        try 
        {
            Connection con = dbaccess.Connector.connection();
            String SQL = "INSERT INTO users (name, lastname, address, postalnumber, phone, email, password, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getAddress());
            ps.setString(4, ""+user.getPostalcode());
            ps.setString(5, ""+user.getPhone());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getPassword());
            ps.setString(8, user.getRole());
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
    
    public static int getUserId(String email) throws LoginSampleException 
    {
        int id = 0;
        try 
        {
            Connection con = dbaccess.Connector.connection();
            String SQL = "SELECT id FROM FogUsers.users where email = '" + email +"';";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException | ClassNotFoundException ex) 
        {
            throw new LoginSampleException(ex.getMessage());
        }
        return id;
    }
    
    public static User getUser(int id) throws LoginSampleException {
        User u = null;
        try 
        {
            Connection con = dbaccess.Connector.connection();
            String SQL = "SELECT * FROM FogUsers.users where id = '" + id + "'";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery(SQL);
            while(rs.next()) {
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                int postal = rs.getInt("postalnumber");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String password = rs.getString("password");
                
                u = new User(name, lastname, address, postal, phone, email, password);
            } 
        } catch (SQLException | ClassNotFoundException ex) 
        {
            throw new LoginSampleException(ex.getMessage());
        }
        
        return u;
    }
    
        public static void UpdateUserInfo(int id, String name, String lastname, String address, int postalnumber, int phone, String email, String password) throws LoginSampleException 
        {
        try 
        {
            Connection con = dbaccess.Connector.connection();
            String SQL = "UPDATE FogUsers.users SET name = '" +name +
            "', lastname = '" + lastname + "', address = '"+address+"', postalnumber = '"+postalnumber+
                    "', phone = '"+phone+"', email = '"+email+
                    "', password = '"+password+ "' WHERE id='" + id +"';";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) 
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }
        
        public static List<User> getAllUsers() throws LoginSampleException {
            List<User> userlist = new ArrayList<>();
            
            try 
        {
            Connection con = dbaccess.Connector.connection();
            String SQL = "SELECT * FROM FogUsers.users";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery(SQL);
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                int postal = rs.getInt("postalnumber");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String password = rs.getString("password");
                
                userlist.add(new User(id, name, lastname, address, postal, phone, email, password));
            } 
        } catch (SQLException | ClassNotFoundException ex) 
        {
            throw new LoginSampleException(ex.getMessage());
        }
            
            return userlist;
        }
        
                public static List<Integer> getAllUserIds() throws LoginSampleException {
            List<Integer> idList = new ArrayList<>();
            
            try 
        {
            Connection con = dbaccess.Connector.connection();
            String SQL = "SELECT id FROM FogUsers.users order by id asc";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery(SQL);
            while(rs.next()) {
                int id = rs.getInt("id");                
                
                idList.add(id);
            } 
        } catch (SQLException | ClassNotFoundException ex) 
        {
            throw new LoginSampleException(ex.getMessage());
        }
            
            return idList;
        }
                
                public static String getUserRole(int id) throws LoginSampleException {
                    {
        String role = null;
        try 
        {
            Connection con = dbaccess.Connector.connection();
            String SQL = "SELECT role FROM FogUsers.users where id = '" + id +"';";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                role = rs.getString("role");
            }
        } catch (SQLException | ClassNotFoundException ex) 
        {
            throw new LoginSampleException(ex.getMessage());
        }
        return role;
                }
                }
}

