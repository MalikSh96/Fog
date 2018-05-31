package datalayer;

import businesslayer.Constants;
import businesslayer.UniversalExceptions;
import businesslayer.Orders;
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

    private static Constants con = new Constants();
    private static UniversalExceptions uex = con.getUEX();

    /**
     *
     * @param ord
     * @return orderId
     * @Description: To generate an orderid for an order created
     * @throws UniversalExceptions
     */
    public static int createPreOrder(Orders ord) throws UniversalExceptions {
        int orderId = 0;
        Connection con;
        try {
            con = Connector.connection();
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

        } catch (SQLException | ClassNotFoundException ex) {

            uex.ThrowNoPreOrderCreatedException();
        }

        return orderId;
    }

    /**
     *
     * @param id
     * @return date
     * @Description: Get the dates from the order table where user id matches
     * @throws UniversalExceptions
     */
    public String getDates(int id) throws UniversalExceptions {

        String dates = null;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT dates FROM FogUsers.orders where userID = " + id;

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                dates = resultset.getString("dates");

            }
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowCouldNotFindTheDateException();
        }

        return dates;
    }

    /**
     *
     * @param orderId
     * @return ord
     * @Description: Get an order from the order table where the id matches then one being searched for 
     * @throws UniversalExceptions
     */
    public Orders getOrder(int orderId) throws UniversalExceptions {
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

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetOrderException();
        }
        return ord;
    }

    /**
     *
     * @return id
     * @Description: Getting the latest order
     * @throws UniversalExceptions
     */
    public static int getLatestOrder() throws UniversalExceptions {
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

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowLatestOrderDontExistException();
        }
        return id;
    }

    /**
     *
     * @param orderId
     * @return boolean
     * @Description: See if an order id exists
     * @throws UniversalExceptions
     */
    public boolean orderIdExists(int orderId) throws UniversalExceptions {
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

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowOrderDoesNotExistException();
        }
        return exists;
    }

    /**
     *
     * @param orderId
     * @return userId
     * @Description: Getting the user where orderId matches
     * @throws UniversalExceptions
     */
    public int getUserId(int orderId) throws UniversalExceptions //shows specifik orders for the chosen user
    {
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

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetUserIdException();
        }
        return userId;
    }
    
    /**
     *
     * @param userId
     * @return dates
     * @Description: Return a list of all the dates where a user with a specific id has made orders
     * @throws UniversalExceptions
     */
    public List<String> getAllUserOrderDates(int userId) throws UniversalExceptions {

        List<String> dates = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT dates FROM FogUsers.orders where userID = '" + userId + "' order by dates desc";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String date = rs.getString("dates");
                dates.add(date);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetNonSentOrderIdException();
        }
        return dates;
    }
    
    /**
     *
     * @return orderNumbers
     * @Description: Gets all order id which is not send
     * @throws UniversalExceptions
     */
    public List<Integer> getNonSentOrderId() throws UniversalExceptions {

        List<Integer> orderNumbers = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT orderId FROM FogUsers.orders where orderConfirmed=0 order by orderId desc;";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("orderId");
                orderNumbers.add(id);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetNonSentOrderIdException();
        }
        return orderNumbers;
    }
    
    /**
     *
     * @return orderDates
     * @Description: Gets all the dates for orders which is not send
     * @throws UniversalExceptions
     */
    public List<String> getNonSentOrderDates() throws UniversalExceptions {

        List<String> orderDates = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT dates FROM FogUsers.orders where orderConfirmed=0 order by orderId desc;";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("dates");
                orderDates.add(id);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetNonSentOrderIdException();
        }
        return orderDates;
    }
    
    public List<String> getAllOrderDates() throws UniversalExceptions {

        List<String> orderDates = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT dates FROM FogUsers.orders order by orderId desc;";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("dates");
                orderDates.add(id);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetNonSentOrderIdException();
        }
        return orderDates;
    }
    /**
     *
     * @return userId
     * @Description: Gets all non sent order ids for the specific user
     * @throws UniversalExceptions
     */
    public List<Integer> getNonSentOrderCustomerIds() throws UniversalExceptions {

        List<Integer> userIds = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT userID FROM FogUsers.orders where orderConfirmed=0 order by orderId desc;";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("userId");
                userIds.add(id);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetNonSentOrderIdException();
        }
        return userIds;
    }
    
    public List<Integer> getOrderCustomerIds() throws UniversalExceptions {

        List<Integer> userIds = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT userID FROM FogUsers.orders order by orderId desc;";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("userId");
                userIds.add(id);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetNonSentOrderIdException();
        }
        return userIds;
    }
    
    
    

    /**
     *
     * @return orderNumbers
     * @Description: Gets a list containing all order ids
     * @throws UniversalExceptions
     */
    public List<Integer> getAllOrderIds() throws UniversalExceptions {
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

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetAllOrdersIdException();
        }
        return orderNumbers;
    }

    /**
     *
     * @return orders
     * @Description: Gets a list of all the orders
     * @throws UniversalExceptions
     */
    public List<Orders> allOrders() throws UniversalExceptions {
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

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetAllOrdersException();
        }

        return orders;
    }

    /**
     *
     * @return orders
     * @Description: gets all confirmed orders
     * @throws UniversalExceptions
     */
    public List<Orders> confirmedOrders() throws UniversalExceptions {
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

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetAllConfirmedOrdersException();
        }

        return orders;
    }

    /**
     *
     * @return orders
     * @Description: Gets all pending orders
     * @throws UniversalExceptions
     */
    public List<Orders> pendingOrders() throws UniversalExceptions {
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

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetAllPendingOrdersException();
        }

        return orders;
    }

    /**
     *
     * @param id
     * @return orders
     * @Description: Gets all the orders for a customer with a specific id
     * @throws UniversalExceptions
     */
    public List<Orders> allCustomerOrders(int id) throws UniversalExceptions {
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

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetAllCustomerOrdersException();
        }

        return orders;
    }

    /**
     *
     * @param id
     * @return orderIds
     * @Description: Gets all the order ids for a specific user id
     * @throws UniversalExceptions
     */
    public List<Integer> allCustomerOrdersId(int id) throws UniversalExceptions {
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

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetAllCustomerOrdersIdException();
        }

        return orderIds;
    }

    /**
     *
     * @param orderID
     * @return sent
     * @Description: Checks if an order is sent or not
     * @throws ClassNotFoundException
     */
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

    /**
     *
     * @param orderID
     * @Description: Sends an order
     * @throws UniversalExceptions
     */
    public void sendOrder(int orderID) throws UniversalExceptions {
        try {
            Connection con = Connector.connection();
            String SQL = "update orders set orderConfirmed= '1' where orderId= '" + orderID + "'";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowCouldNotSendOrderException();
        }
    }

    /**
     *
     * @param id
     * @return result
     * @Description: Gets the price for a specific order id
     * @throws UniversalExceptions
     */
    public int getPrice(int id) throws UniversalExceptions {
        int result = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT price FROM orders where orderId = '" + id + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            System.out.println("sql syntax ok? " + SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                result = resultset.getInt("price");
            return result;
            }


        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotFindThePriceException();
        }
        return result;
    }

   public void updateTotalPrice(int totalPrice, int orderId) throws UniversalExceptions {
     try {
            Connection con = Connector.connection();
            String SQL = "update orders set price= '" + totalPrice + "' where orderId= '" + orderId + "'";

            PreparedStatement ps = con.prepareStatement(SQL);

            System.out.println("Check sql order " + SQL);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowCouldNotSendOrderException();
        }
    }

    public int getUserIdFromOrderId(int orderId) throws UniversalExceptions {
        int userid = 0;
     try {
            Connection con = Connector.connection();
            String SQL = "SELECT userID FROM orders where orderId = '" + orderId + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            System.out.println("sql syntax ok? " + SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                userid = resultset.getInt("userID");
            return userid;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowCouldNotSendOrderException();
        }
     return userid;
    }
}
