package functionlayer;

/**
 * The purpose of UniversalExceptions is to...
 * @author kasper
 */
public final class UniversalExceptions extends Exception {

    public UniversalExceptions(String msg) {
        super(msg);
    }

    public UniversalExceptions() {
    }

    
    
    public void NoPreOrderCreated() throws UniversalExceptions
    {
        throw new UniversalExceptions("Order did not get created, try again");
    }
    
    public void DidNotGetOrder() throws UniversalExceptions
    {
        throw new UniversalExceptions("Could not find the order you were looking for, try again");
    }
    
    public void LatestOrderDidNotGetFound(String msg) throws UniversalExceptions
    {
        throw new UniversalExceptions("Latest order could not be found");
    }
    
    public void DidNotFindTheOrder(String msg) throws UniversalExceptions
    {
        throw new UniversalExceptions("Did not find the order");
    }
    
    public void DidNotGetNonSentOrderId(String msg) throws UniversalExceptions
    {
        throw new UniversalExceptions("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }
    
    public void DidNotGetAllOrdersId(String msg) throws UniversalExceptions
    {
        throw new UniversalExceptions("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }
    
    public void DidNotGetAllOrders(String msg) throws UniversalExceptions
    {
        throw new UniversalExceptions("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }
    
    public void DidNotGetAllConfirmedOrders(String msg) throws UniversalExceptions
    {
        throw new UniversalExceptions("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }
    
    public void DidNotGetAllPendingOrders(String msg) throws UniversalExceptions
    {
        throw new UniversalExceptions("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }
    
    public void DidNotGetAllCustomerOrders(String msg) throws UniversalExceptions
    {
        throw new UniversalExceptions("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }
    
    public void DidNotGetAllCustomerOrdersId(String msg) throws UniversalExceptions
    {
        throw new UniversalExceptions("Seems like the list didn't come through, possible cause is the list is empty. Try again");
    }
    
    public void CouldNotSendOrder(String msg) throws UniversalExceptions
    {
        throw new UniversalExceptions("Order did not get send. Tr again");
    }
    
    public void DidNotFindThePrice(String msg) throws UniversalExceptions
    {
        throw new UniversalExceptions("Not possible to find the price. Try again");
    }
}
