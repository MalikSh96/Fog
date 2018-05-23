/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import functionlayer.Orders;
import functionlayer.UniversalExceptions;
import functionlayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author malik
 */
public class OrderMapper {
    
    UniversalExceptions ue = new UniversalExceptions();

    public int createPreOrder(Orders ord) throws ClassNotFoundException, SQLException {
        int orderId = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (userID, length, width, height, price) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ord.getUserId()); //user id
            ps.setInt(2, ord.getLength());
            ps.setInt(3, ord.getWidth());
            ps.setInt(4, ord.getHeight());
            ps.setInt(5, ord.getPrice());

            System.out.println("Check sql order " + SQL);

            int check = ps.executeUpdate();
            if (check == 1) {
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                orderId = ids.getInt(1);
                System.out.println("Debug " + orderId);
                return orderId;

            }
        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            System.out.println(ue.getErrorMessage(1));
//            throw new Error(ex.getMessage());
//            throw new Error("No order created, try again or contact us");
//            Connection con = Connector.connection();
//            System.out.println("You are here");
//            String sql = "select * from FogUsers.error where id = '1'";
//            PreparedStatement ps = con.prepareStatement(sql);
//            System.out.println("... " + ps.execute());
        }
        return orderId;
    }

    public Orders getOrder(int orderId) {
        Orders ord = null;
        try {
            Connection con = Connector.connection();
            String SQL = "select * from orders where orderid = ?";

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int userID = rs.getInt("userID");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                boolean conf = rs.getBoolean("orderConfirmed");
                ord = new Orders(orderId, userID, length, width, height, conf);
                System.out.println("Debug " + orderId);
                return ord;

            }
        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }
        return ord;
    }

    public int getLatestOrder() {
        int id = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT MAX(orderId) FROM FogUsers.orders;";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("MAX(orderId)");
                return id;

            }
        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }
        return id;
    }

    public boolean findOrderId(int orderId) {
        boolean exists = false;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM FogUsers.orders where orderId = '" + orderId + "';";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
                return exists;

            }
        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }
        return exists;
    }

    public int getUserId(int orderId) {
        int userId = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT userId FROM FogUsers.orders where orderId = '" + orderId + "'";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                userId = rs.getInt("userId");
                return userId;

            }
        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }
        return userId;
    }

    public List<Integer> getNonSentOrderId() {
        List<Integer> orderNumbers = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT orderId FROM FogUsers.orders where orderConfirmed=0;";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("orderId");
                orderNumbers.add(id);

            }
        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }
        return orderNumbers;
    }

    public List<Integer> getAllOrderIds() {
        List<Integer> orderNumbers = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT orderId FROM FogUsers.orders order by orderId desc;";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("orderId");
                orderNumbers.add(id);

            }
        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }
        return orderNumbers;
    }

    public List<Orders> allOrders() {
        List<Orders> orders = new ArrayList<>();
        Orders ord = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders order by orderId desc";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
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

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return orders;
    }

    public List<Orders> confirmedOrders() {
        List<Orders> orders = new ArrayList<>();
        Orders ord = null;

        try {
            Connection con = Connector.connection();
            String SQL = "select * from FogUsers.orders where orderConfirmed "
                    + "= '1' order by orderId desc;";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
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

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return orders;
    }

    public List<Orders> pendingOrders() {
        List<Orders> orders = new ArrayList<>();
        Orders ord = null;

        try {
            Connection con = Connector.connection();
            String SQL = "select * from FogUsers.orders where orderConfirmed "
                    + "= '0' order by orderId desc;";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
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

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return orders;
    }

    public List<Orders> allCustomerOrders(int id) {
        List<Orders> orders = new ArrayList<>();
        Orders ord = null;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM FogUsers.orders where userID = " + id;

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                int orderId = resultset.getInt("orderId");
                int userID = resultset.getByte("userID");
                int length = resultset.getInt("length");
                int width = resultset.getInt("width");
                int height = resultset.getInt("height");
                boolean conf = resultset.getBoolean("orderConfirmed");

                if (userID == id) {
                    ord = new Orders(orderId, userID, length, width, height, conf);
                    orders.add(ord);
                }

            }
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return orders;
    }

    public List<Integer> allCustomerOrdersId(int id) {
        List<Integer> orderIds = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT orderId FROM FogUsers.orders where userID = " + id;

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                int orderId = resultset.getInt("orderId");

                orderIds.add(orderId);

            }
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return orderIds;
    }

    public boolean isOrderSent(int orderID) throws ClassNotFoundException {
        int sent = 0;
        try {
            Connection con = Connector.connection();
            String sql = "Select orderConfirmed from orders where orderId= '" + orderID + "'";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultset = ps.executeQuery(sql);

            while (resultset.next()) {
                sent = resultset.getInt("orderConfirmed");
            }
            if (sent == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void sendOrder(int orderID) {
        try {
            Connection con = Connector.connection();
            String SQL = "update orders set orderConfirmed= '1' where orderId= '" + orderID + "'";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new Error(ex.getMessage());
        }
    }

    public int getPrice(int id) {

        int result = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT price FROM orders where orderId = '" + id + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                result = resultset.getInt("price");
            }

            System.out.println("sql syntax ok? " + SQL);
            return result;

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }
    }
}
