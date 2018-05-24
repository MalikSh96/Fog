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

public class ItemlistMapper {

    private static Constants con = new Constants();
    private static UniversalExceptions uex = con.getUEX();

    public static void addToItemlist(String name, String desc, int length, int amount, int orderId, int itemId) throws UniversalExceptions {
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

            System.out.println("Check sql order " + SQL);

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
//            throw new Error(ex.getMessage());
            uex.ThrowDidNotAddToItemlistException();
        }
    }

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
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
//            throw new Error(ex.getMessage());
            uex.ThrowDidNotGetTheFullItemlistException();
        }

        return itemlist;

    }

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
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
//            throw new Error(ex.getMessage());
            uex.ThrowDidNotGetTheFullItemlisIdtException();
        }

        return itemIds;

    }

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
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
//            throw new Error(ex.getMessage());
            uex.ThrowDidNotGetTheAmounttException();
        }

        return amount;

    }

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
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
//            throw new Error(ex.getMessage());
            uex.ThrowDidNotGetTheAmounttException();
        }

        return amount;

    }
}
