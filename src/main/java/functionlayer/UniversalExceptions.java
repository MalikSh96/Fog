package functionlayer;

import dbaccess.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The purpose of UniversalExceptions is to...
 *
 * @author kasper
 */
public final class UniversalExceptions extends Exception {

    public String getErrorMessage(int id) {
        String error = "";

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT message FROM error where id = '" + id + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultset = ps.executeQuery();

            while (resultset.next()) {
                error = resultset.getString("message");

            }
            System.out.println("sql syntax ok? " + SQL);

        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            throw new Error(ex.getMessage());
        }

        return error;
    }

    public UniversalExceptions(String msg) {
        super(msg);
    }

    public UniversalExceptions() {
        NoPreOrderCreated();
    }

    public void NoPreOrderCreated() {
        throw new Error("Order did not get created, try again");
    }

    public void DidNotGetOrder(String msg) {
        throw new Error("Could not find the order you were looking for, try again");
    }

    public void LatestOrderDidNotGetFound(String msg) {
        throw new Error("Latest order could not be found");
    }

    public void DidNotFindTheOrder(String msg) {
        throw new Error("Did not find the order");
    }

    public void DidNotGetNonSentOrderId(String msg) {
        throw new NullPointerException("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }

    public void DidNotGetAllOrdersId(String msg) {
        throw new NullPointerException("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }

    public void DidNotGetAllOrders(String msg) {
        throw new NullPointerException("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }

    public void DidNotGetAllConfirmedOrders(String msg) {
        throw new NullPointerException("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }

    public void DidNotGetAllPendingOrders(String msg) {
        throw new NullPointerException("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }

    public void DidNotGetAllCustomerOrders(String msg) {
        throw new NullPointerException("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }

    public void DidNotGetAllCustomerOrdersId(String msg) {
        throw new NullPointerException("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }

    public void CouldNotSendOrder(String msg) {
        throw new Error("Order did not get send. Tr again");
    }

    public void DidNotFindThePrice(String msg) {
        throw new Error("Not possible to find the price. Try again");
    }
}
