/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import functionlayer.Orders;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void testCreatePreOrder() 
    {
        OrderMapper om = new OrderMapper();
        Orders ord = new Orders(1, 20, 20, 4);
        
        int orderId = om.createPreOrder(ord);
        
        Orders checkOrder = om.getOrder(orderId);
        assertNotNull(checkOrder);        
    }

    @Test
    public void testGetOrder() 
    {
        OrderMapper om = new OrderMapper();
        
        Orders checkId = om.getOrder(1);
        assertEquals(checkId.getOrderId(), 1);
    }

    @Test
    public void testAllOrders() 
    {
        OrderMapper om = new OrderMapper();
        int expected = om.allOrders().size()+1;
        Orders ord = new Orders(1, 99, 99, 9);
        om.createPreOrder(ord);
        int actual = om.allOrders().size();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testConfirmedOrders() {
    }

    @Test
    public void testPendingOrders() {
    }
    
    
}
