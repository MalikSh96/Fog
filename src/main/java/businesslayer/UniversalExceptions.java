package businesslayer;

public final class UniversalExceptions extends Exception {

    public UniversalExceptions(String msg) {
        super(msg);
    }

    public UniversalExceptions() {
        
    }

    //Ordermapper exceptions
    public void ThrowNoPreOrderCreatedException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not create order. Try again.");
    }
    
    public void ThrowCouldNotFindTheDateException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not find order dates from the given user. Try again.");
    }
    
    public void ThrowDidNotGetOrderException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve order with the given id. Try again.");
    }
    
    public void ThrowLatestOrderDontExistException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieved latest order. Try again.");
    }
    
    public void ThrowOrderDoesNotExistException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Requested order does not exist. Try again.");
    }
    
    public void ThrowDidNotGetUserIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not get specific user from given order. Try again.");
    }
    
    public void ThrowDidNotGetNonSentOrderIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve all current order id's. Try again.");
    }
    
    public void ThrowDidNotGetAllOrdersIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve all order id's. Try again.");
    }
    
    public void ThrowDidNotGetAllOrdersException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve all orders. Try again.");
    }
    
    public void ThrowDidNotGetAllConfirmedOrdersException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve all confirmed orders. Try again.");
    }
    
    public void ThrowDidNotGetAllPendingOrdersException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve all pending orders. Try again.");
    }
    
    public void ThrowDidNotGetAllCustomerOrdersException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrive all orders from given user id. Try again.");
    }
    
    public void ThrowDidNotGetAllCustomerOrdersIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve all order id's from given user id. Try again.");
    }
    
    public void ThrowCouldNotSendOrderException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not send order. Try again.");
    }
    
    public void ThrowDidNotFindThePriceException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve the price. Try again.");
    }

    
    //Usermapper exceptions
    public void ThrowDidNotCreateUserException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not create user. Try again.");
    }
    
    public void ThrowDidNotLoginException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not log in. Try again.");
    }
    
    public void ThrowDidNotGetTheUserIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve id for the given email. Try again.");
    }
    
    public void ThrowDidNotGetTheUserException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve the given user. Try again.");
    }
    
    public void ThrowDidNotUpdateUserInfoException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not update user information. Try again.");
    }
    
    public void ThrowDidNotGetUserListException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrive full user list. Try again.");
    }
    
    public void ThrowDidNotGetAllUserIdsException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve all user id's. Try again.");
    }
    
    public void ThrowDidNotGetUserRoleException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve role for the given user. Try again.");
    }
    
    public void ThrowDidNotFindUserIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not find the given user. Try again.");
    }
    
    
    //InventoryMapper exceptions
    public void ThrowDidNotGetTheCompleteInventoryException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Complete inventorylist could not be retrieved. Try again.");
    }
    
    public void ThrowCouldNotAddToInventoryException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Item could not be added to the inventory. Try again.");
    }
    
    public void ThrowDidNotGetTheNameException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Item name could not be retrived. Try again.");
    }
    
    public void ThrowDidNotGetTheLengthException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Item length could not be retrived. Try again.");
    }
    
    public void ThrowDidNotGetTheUnitException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Item unit could not be retrived. Try again.");
    }
    
    public void ThrowDidNotGetTheIdException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Item id could not be retrived. Try again.");
    }
    
    public void ThrowDidNotGetTheDescriptionException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Item description could not be retrived. Try again.");
    }
    
    public void ThrowDidNotGetTheSpecificItemException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrive given item. Try again.");
    }
    
    public void ThrowDidNotGetTheStatusException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Item status could not be retrived. Try again.");
    }
    
    public void ThrowDidNotGetThePriceException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Item price could not be retrived. Try again.");
    }
    
    public void ThrowDidNotUpdateTheStatusException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not update item status. Try again.");
    }
    
    public void ThrowCouldNotReverseTheStatusUpdateException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not reverse status update. Try again.");
    }
    
    public void ThrowCouldNotUpdateInventoryException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Inventory could not be updated. Try again.");
    }
    
    
    //ItemListMapper exceptions --- needs some messages to display
    public void ThrowDidNotAddToItemlistException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Item could not be added to itemlist. Try again.");
    }
    
    public void ThrowDidNotGetTheFullItemlistException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrieve the itemlist. Try again.");
    }
    
    public void ThrowDidNotGetTheFullItemlisIdtException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not get all item id's from the itemlist. Try again.");
    }
    
    public void ThrowDidNotGetTheAmounttException() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not retrive the item amount. Try again.");
    }
}
