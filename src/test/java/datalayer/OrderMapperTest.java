package datalayer;

import businesslayer.UniversalExceptions;
import businesslayer.Orders;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class OrderMapperTest {

    public OrderMapperTest() {
    }

    @Before
    public void setUp() {
    }

    private OrderMapper om = new OrderMapper();

    @Test //works
    public void testCreatePreOrder() throws UniversalExceptions {
        Orders ord = new Orders(1, 20, 20, 4);

        int orderId = om.CreateOrder(ord);

        Orders checkOrder = om.getOrder(orderId);
        assertNotNull(checkOrder);
    }

    @Test //works
    public void testGetOrder() throws UniversalExceptions {
        Orders checkId = om.getOrder(2);
        int expected = 2;
        assertEquals(expected, checkId.getOrderId());
    }

    @Test //works
    public void testAllOrders() throws UniversalExceptions {
        int expected = om.allOrders().size() + 1;
        Orders ord = new Orders(1, 99, 99, 9);
        om.CreateOrder(ord);
        int actual = om.allOrders().size();

        assertEquals(expected, actual);
    }

    @Test //works
    public void testConfirmedOrders() throws UniversalExceptions {
        Orders ord = new Orders(1, 10, 20, 30, true);
        System.out.println("Ord " + ord);
        om.CreateOrder(ord);
        boolean expected = true;
        System.out.println("Check " + expected);
        System.out.println("Actual " + ord.isOrderConfirmed());
        assertEquals(expected, ord.isOrderConfirmed());
    }

    @Test //works
    public void testPendingOrders() throws UniversalExceptions {
        Orders ord = new Orders(1, 30, 20, 10, false);
        System.out.println("Ord " + ord);
        om.CreateOrder(ord);
        boolean expected = false;
        System.out.println("Check " + expected);
        System.out.println("Actual " + ord.isOrderConfirmed());
        assertEquals(expected, ord.isOrderConfirmed());
    }

    @Test //works provided at least 2 orders is made and order 2 is sent
    @Disabled
    public void testAllCustomerOrders() throws UniversalExceptions {
        int expected = 4;
        int actual;
        actual = om.allCustomerOrders(2).size();
        assertEquals(expected, actual);
    }

    @Test //works provided at least 2 orders is made and order 2 is sent
    @Disabled
    public void testIsOrderSentTrue() throws Exception {
        boolean actual = om.isOrderSent(2);

        assertTrue(actual);
    }

    @Test //works provided at least 6 orders is made and order 6 is not sent
    public void testIsOrderSentFalse() throws Exception {
        boolean actual = om.isOrderSent(6);
        assertFalse(actual);
    }

    @Test //works provided at least 5 orders is made and order 5 is not sent
    @Disabled
    public void testSendOrderYes() throws UniversalExceptions, ClassNotFoundException {
        om.sendOrder(5);
        assertTrue(om.isOrderSent(5));

    }
    
    @Test //works provided at least 10 orders is made and order 10 is not sent
    @Disabled
    public void testSendOrderNo() throws ClassNotFoundException, UniversalExceptions {
        assertFalse(om.isOrderSent(10));
        om.sendOrder(10);
        assertTrue(om.isOrderSent(10));
    }
}
