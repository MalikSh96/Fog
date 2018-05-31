package datalayer;

import businesslayer.Constants;
import businesslayer.UniversalExceptions;
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
public class ItemlistMapper {

    private static Constants con = new Constants();
    private static UniversalExceptions uex = con.getUEX();

    /**
     *
     * @param name
     * @param desc
     * @param length
     * @param amount
     * @param orderId
     * @param itemId
     * @throws UniversalExceptions
     */
    public static void addToItemlist(String name, String desc, int length, 
            int amount, int orderId, int itemId) throws UniversalExceptions {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO itemlist (name, description, length, unit, amount, orderid, itemId) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name); //user id
            ps.setString(2, desc);
            ps.setInt(3, length);
            ps.setString(4, InventoryMapper.getUnit(name));
            ps.setInt(5, amount);
            ps.setInt(6, orderId);
            ps.setInt(7, itemId);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotAddToItemlistException();
        }
    }

    /**
     *
     * @param orderId
     * @return itemList
     * @throws UniversalExceptions
     */
    public static List<String> getFullItemlist(int orderId) throws UniversalExceptions {

        List<String> itemlist = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM itemlist where orderid = '" + orderId + "'";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();
            itemlist.add("Order nr: " + orderId + " Stykliste");
            itemlist.add("");
            while (resultset.next()) {
                String name = resultset.getString("name");
                String desc = resultset.getString("description");
                int length = resultset.getInt("length");
                String unit = resultset.getString("unit");
                int amount = resultset.getInt("amount");

                itemlist.add("Navn: " + name);
                itemlist.add("Beskrivelse: " + desc);
                if (length > 0) {
                    itemlist.add("Længde: " + length);
                }
                itemlist.add("Enhed: " + unit);
                itemlist.add("Antal: " + amount);
                itemlist.add("");

            }
        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetTheFullItemlistException();
        }

        return itemlist;
    }

    /**
     *
     * @param orderId
     * @return itemIds
     * @throws UniversalExceptions
     */
    public List<Integer> getFullItemlistId(int orderId) throws UniversalExceptions {

        List<Integer> itemIds = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT itemId FROM itemlist where orderid = '" + orderId + "'";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();
            while (resultset.next()) {
                itemIds.add(resultset.getInt("itemId"));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetTheFullItemlisIdtException();
        }

        return itemIds;
    }

    /**
     *
     * @param orderId
     * @param itemId
     * @return amount
     * @throws UniversalExceptions
     */
    public int getAmount(int orderId, int itemId) throws UniversalExceptions {

        int amount = 0;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT amount FROM itemlist where orderid = '" + orderId + "' and itemId = '" + itemId + "'";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();
            while (resultset.next()) {
                amount = resultset.getInt("amount");

            }
        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetTheAmounttException();
        }
        return amount;
    }

    /**
     *
     * @param orderId
     * @return amount
     * @throws UniversalExceptions
     */
    public List<Integer> getAmountList(int orderId) throws UniversalExceptions {

        List<Integer> amount =  new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT amount FROM itemlist where orderid = '" + orderId + "'";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();
            while (resultset.next()) {
                amount.add(resultset.getInt("amount"));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetTheAmounttException();
        }
        return amount;
    }
}
