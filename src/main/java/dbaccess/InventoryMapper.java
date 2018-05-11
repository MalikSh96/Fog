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

                inv = new Inventory(id, name, length, unit, desc);
                inventory.add(inv);

            }
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return inventory;
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
}
