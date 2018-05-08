package dbaccess;
        
import functionlayer.Orders;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author malik
 */
public class OrderMapperTest {
    
    public OrderMapperTest() {
    }
    
    @Before
    public void setUp() {
    }

    private OrderMapper om = new OrderMapper();
    
    @Test //works
    @Disabled
    public void testCreatePreOrder() 
    {      
        Orders ord = new Orders(1, 20, 20, 4);
        
        int orderId = om.createPreOrder(ord);
        
        Orders checkOrder = om.getOrder(orderId);
        assertNotNull(checkOrder);        
    }

    @Test //works
    @Disabled
    public void testGetOrder() 
    {
        Orders checkId = om.getOrder(2);
        int expected = 2;
        assertEquals(expected, checkId.getOrderId());
    }

    @Test //works
    @Disabled
    public void testAllOrders() 
    {       
        int expected = om.allOrders().size()+1;
        Orders ord = new Orders(1, 99, 99, 9);
        om.createPreOrder(ord);
        int actual = om.allOrders().size();
        
        assertEquals(expected, actual);
    }

    @Test //works
    @Disabled
    public void testConfirmedOrders() 
    {
        Orders ord = new Orders(1, 10, 20, 30, true);
        System.out.println("Ord " + ord);
        om.createPreOrder(ord);
        boolean expected = true;
        System.out.println("Check " + expected);
        System.out.println("Actual " + ord.isOrderConfirmed());
        assertEquals(expected, ord.isOrderConfirmed());
    }

    @Test //works
    @Disabled
    public void testPendingOrders() 
    {
        Orders ord = new Orders(1, 30, 20, 10, false);
        System.out.println("Ord " + ord);
        om.createPreOrder(ord);
        boolean expected = false;
        System.out.println("Check " + expected);
        System.out.println("Actual " + ord.isOrderConfirmed());
        assertEquals(expected, ord.isOrderConfirmed());
    }

    @Test
    @Disabled
    public void testAllCustomerOrders() 
    {
    }

    @Test //works
    @Disabled
    public void testIsOrderSentTrue() throws Exception 
    {
        boolean actual = om.isOrderSent(1);
        
        assertTrue(actual);
    }
    
    @Test //works
    @Disabled
    public void testIsOrderSentFalse() throws Exception 
    {
        boolean actual = om.isOrderSent(2);
        assertFalse(actual);      
    }

    @Test
    @Disabled
    public void testSendOrderYes() 
    {
        
        
    }
    
    @Test
    @Disabled
    public void testSendOrderNo() 
    {
    }
}

