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

    public UniversalExceptions() 
    {
        
    }

    //Ordermapper exceptions
    public void ThrowNoPreOrderCreatedException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to create your order. Try again");
    }
    
    public void ThrowCouldNotFindTheDateException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the dates for the given user id. Try again");
    }
    
    public void ThrowDidNotGetOrderException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the order. Try again");
    }
    
    public void ThrowLatestOrderDidNotGetFoundException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to find the latest order. Try again");
    }
    
    public void ThrowDidNotFindTheOrderException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to find the order you were looking for. Try again");
    }
    
    public void ThrowDidNotGetUserIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the orders for the user you chose. Try again");
    }
    
    public void ThrowDidNotGetNonSentOrderIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the list with the non sent order id. Try again");
    }
    
    public void ThrowDidNotGetAllOrdersIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the list with all the id's of the orders. Try again");
    }
    
    public void ThrowDidNotGetAllOrdersException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the list. Try again");
    }
    
    public void ThrowDidNotGetAllConfirmedOrdersException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the list the confirmed orders. Try again");
    }
    
    public void ThrowDidNotGetAllPendingOrdersException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the list with the pending orders. Try again");
    }
    
    public void ThrowDidNotGetAllCustomerOrdersException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the list with all the customer orders. Try again");
    }
    
    public void ThrowDidNotGetAllCustomerOrdersIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the list with all the customer orders id. Try again");
    }
    
    public void ThrowCouldNotSendOrderException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to send the order. Try again");
    }
    
    public void ThrowDidNotFindThePriceException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to find the price. Try again");
    }

    
    //Usermapper exceptions
    public void ThrowDidNotCreateUserException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to create a user. Try again");
    }
    
    public void ThrowDidNotLoginException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to log in. Try again");
    }
    
    public void ThrowDidNotGetTheUserIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the user with that id. Try again");
    }
    
    public void ThrowDidNotGetTheUserException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the user you were looking for. Try again");
    }
    
    public void ThrowDidNotUpdateUserInfoException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to update the user. Try again");
    }
    
    public void ThrowDidNotGetUserListException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the list with all users. Try again");
    }
    
    public void ThrowDidNotGetAllUserIdsException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retrieve the list with all users' id. Try again");
    }
    
    public void ThrowDidNotGetUserRoleException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to retirve the role for the desired user. Try again");
    }
    
    public void ThrowDidNotFindUserIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Was not possible to find the user you were looking for. Try again");
    }
    
    
    //InventoryMapper exceptions --- needs some messages to display
    public void ThrowDidNotGetTheCompleteInventoryException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowCouldNotAddToInventoryException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
<<<<<<< HEAD

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
=======
    
    public void ThrowDidNotGetTheNameException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowDidNotGetTheLengthException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowDidNotGetTheUnitException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowDidNotGetTheIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowDidNotGetTheDescriptionException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowDidNotGetTheSpecificItemException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowDidNotGetTheStatusException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowDidNotGetThePriceException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowDidNotUpdateTheStatusException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowCouldNotReverseTheStatusUpdateException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowCouldNotUpdateInventoryException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    
    //ItemListMapper exceptions --- needs some messages to display
    public void ThrowDidNotAddToItemlistException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowDidNotGetTheFullItemlistException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowDidNotGetTheFullItemlisIdtException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
    }
    
    public void ThrowDidNotGetTheAmounttException() throws UniversalExceptions
    {
        throw new UniversalExceptions("");
>>>>>>> a97b363216b068e742c55f65e28ac06f1f4d3f9e
    }
}
