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
import java.util.ArrayList;
import java.util.List;
import functionlayer.Inventory;
import functionlayer.LoginSampleException;
import java.sql.Statement;

/**
 *
 * @author Joklin
 */
public class InventoryMapper {

    public List<Inventory> completeInventory() {

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

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return inventory;
    }

    public void addToInventory(String name, String desc, int length, String unit, int status, int price) throws LoginSampleException {
        try {
            Connection con = dbaccess.Connector.connection();
            String SQL = "INSERT INTO FogUsers.inventory SET name = '" + name
                    + "', description = '" + desc + "', length = '" + length
                    + "', unit = '" + unit + "', status = '" + status + "', price = '" + price + "';";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public String getName(int id) {

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

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return name;
    }

    public int getLength(int id) {

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

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return length;
    }

    public String getUnit(String name) {

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

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return unit;
    }
    
    public int getId(String name) {

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

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return id;
    }

    public String getDescription(int id) {

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

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return desc;
    }

    public Inventory getSpecificItem(int id) {

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

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return result;
    }

    public int getStatus(int id) {

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

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return result;
    }

    public int getPrice(int id) {

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

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return result;
    }
    

    public void updateStatus(int id, int amount) {
        int result = getStatus(id) - amount;
        if (result > 0) {
            try {
                Connection con = Connector.connection();
                String SQL = "UPDATE FogUsers.inventory SET status ='" + result + "' WHERE id='" + id + "';";

                PreparedStatement ps = con.prepareStatement(SQL);

                ps.executeUpdate(SQL);

                System.out.println("sql syntax ok? " + SQL);

            } catch (SQLException | ClassNotFoundException ex) { //temporary error
                throw new Error(ex.getMessage());
            }
        }
    }

    public static void UpdateInventory(int id, String name, String desc, int length, String unit, int status, int price) throws LoginSampleException {
        try {
            Connection con = dbaccess.Connector.connection();
            String SQL = "UPDATE FogUsers.inventory SET name = '" + name
                    + "', description = '" + desc + "', length = '" + length + "', unit = '" + unit
                    + "', status = '" + status + "', price = '" + price
                    + "' WHERE id='" + id + "';";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
