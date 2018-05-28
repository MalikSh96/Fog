package datalayer;

import businesslayer.Constants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import businesslayer.UniversalExceptions;
import businesslayer.Inventory;
import businesslayer.LoginSampleException;
import dbaccess.Connector;
import java.sql.Statement;

public class InventoryMapper {

    private static Constants con = new Constants();
    private static UniversalExceptions uex = con.getUEX();

    public static List<Inventory> completeInventory() throws UniversalExceptions {

        List<Inventory> inventory = new ArrayList<>();
        Inventory inv = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM inventory order by id";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                int length = resultset.getInt("length");
                String unit = resultset.getString("unit");
                String desc = resultset.getString("description");
                int status = resultset.getInt("status");
                int price = resultset.getInt("price");

                inv = new Inventory(id, name, length, unit, desc, status, price);
                inventory.add(inv);

            }
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetTheCompleteInventoryException();
        }

        return inventory;
    }

    public static void addToInventory(String name, String desc, int length, String unit, int status, int price) throws UniversalExceptions {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO FogUsers.inventory SET name = '" + name
                    + "', description = '" + desc + "', length = '" + length
                    + "', unit = '" + unit + "', status = '" + status + "', price = '" + price + "';";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowCouldNotAddToInventoryException();
            throw new UniversalExceptions(ex.getMessage());
        }
    }

    public static String getName(int id) throws UniversalExceptions {

        String name = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT name FROM inventory where id = '" + id + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                name = resultset.getString("name");

            }
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetTheNameException();
        }

        return name;
    }

    public static int getLength(int id) throws UniversalExceptions {

        int length = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT length FROM inventory where id = '" + id + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                length = resultset.getInt("length");

            }
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetTheLengthException();
        }

        return length;
    }

    public static String getUnit(String name) throws UniversalExceptions {

        String unit = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT unit FROM inventory where name = '" + name + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                unit = resultset.getString("unit");

            }
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetTheUnitException();
        }

        return unit;
    }

    public static int getId(String name) throws UniversalExceptions {

        int id = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id FROM inventory where name = '" + name + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                id = resultset.getInt("id");

            }
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetTheIdException();
        }

        return id;
    }

    public static String getDescription(int id) throws UniversalExceptions {

        String desc = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT description FROM inventory where id = '" + id + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                desc = resultset.getString("description");

            }
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetTheDescriptionException();
        }

        return desc;
    }

    public static Inventory getSpecificItem(int id) throws UniversalExceptions {

        Inventory result = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM inventory where id = '" + id + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {

                String name = resultset.getString("name");
                String desc = resultset.getString("description");
                int length = resultset.getInt("length");
                String unit = resultset.getString("unit");
                int status = resultset.getInt("status");
                int price = resultset.getInt("price");
                result = new Inventory(id, name, length, unit, desc, status, price);
            }

            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetTheSpecificItemException();
        }

        return result;
    }

    public static int getStatus(int id) throws UniversalExceptions {

        int result = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT status FROM inventory where id = '" + id + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                result = resultset.getInt("status");

            }

            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetTheStatusException();
        }

        return result;
    }

    public static int getPrice(int id) throws UniversalExceptions {

        int result = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT price FROM inventory where id = '" + id + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                result = resultset.getInt("price");
            }

            System.out.println("sql syntax ok? " + SQL);
            return result;

        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowDidNotGetThePriceException();

        }
        return result;
    }

    public static boolean updateStatus(int id, int amount) throws UniversalExceptions {
        int result = getStatus(id) - amount;
        if (result > 0) {
            try {
                Connection con = Connector.connection();
                String SQL = "UPDATE FogUsers.inventory SET status ='" + result + "' WHERE id='" + id + "';";

                PreparedStatement ps = con.prepareStatement(SQL);

                ps.executeUpdate(SQL);

                System.out.println("sql syntax ok? " + SQL);
                return true;
            } catch (SQLException | ClassNotFoundException ex) {
                uex.ThrowDidNotUpdateTheStatusException();
            }
        }
        return false;
    }

    public static void reverseStatusUpdate(int id, int amount, List<Integer> wrongIds) throws UniversalExceptions {
        int result = getStatus(id) + amount;
        for (int i = 0; i < wrongIds.size(); i++) {
            if (id != wrongIds.get(i)) {
                try {
                    Connection con = Connector.connection();
                    String SQL = "UPDATE FogUsers.inventory SET status ='" + result + "' WHERE id='" + id + "';";

                    PreparedStatement ps = con.prepareStatement(SQL);

                    ps.executeUpdate(SQL);

                    System.out.println("sql syntax ok? " + SQL);
                } catch (SQLException | ClassNotFoundException ex) {
                    uex.ThrowCouldNotReverseTheStatusUpdateException();
                }
            }
        }
    }

    public static void UpdateInventory(int id, String name, String desc, int length, String unit, int status, int price) throws UniversalExceptions {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE FogUsers.inventory SET name = '" + name
                    + "', description = '" + desc + "', length = '" + length + "', unit = '" + unit
                    + "', status = '" + status + "', price = '" + price
                    + "' WHERE id='" + id + "';";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            uex.ThrowCouldNotUpdateInventoryException();
            throw new UniversalExceptions(ex.getMessage());
        }
    }
}
