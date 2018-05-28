<<<<<<< HEAD
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dbaccess;
//        
//import functionlayer.Orders;
//import java.sql.SQLException;
//import java.util.List;
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import org.junit.Before;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
///**
// *
// * @author malik
// */
//public class OrderMapperTest {
//    
//    public OrderMapperTest() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//
//    private OrderMapper om = new OrderMapper();
//    
//    @Test //works
//    @Disabled
//    public void testCreatePreOrder() throws ClassNotFoundException, SQLException 
//    {      
//        Orders ord = new Orders(1, 20, 20, 4);
//        
//        int orderId = om.createPreOrder(ord);
//        
//        Orders checkOrder = om.getOrder(orderId);
//        assertNotNull(checkOrder);        
//    }
//
//    @Test //works
//    @Disabled
//    public void testGetOrder() 
//    {
//        Orders checkId = om.getOrder(2);
//        int expected = 2;
//        assertEquals(expected, checkId.getOrderId());
//    }
//
//    @Test //works
//    @Disabled
//    public void testAllOrders() throws ClassNotFoundException, SQLException 
//    {       
//        int expected = om.allOrders().size()+1;
//        Orders ord = new Orders(1, 99, 99, 9);
//        om.createPreOrder(ord);
//        int actual = om.allOrders().size();
//        
//        assertEquals(expected, actual);
//    }
//
//    @Test //works
//    @Disabled
//    public void testConfirmedOrders() throws ClassNotFoundException, SQLException 
//    {
//        Orders ord = new Orders(1, 10, 20, 30, true);
//        System.out.println("Ord " + ord);
//        om.createPreOrder(ord);
//        boolean expected = true;
//        System.out.println("Check " + expected);
//        System.out.println("Actual " + ord.isOrderConfirmed());
//        assertEquals(expected, ord.isOrderConfirmed());
//    }
//
//    @Test //works
//    @Disabled
//    public void testPendingOrders() throws ClassNotFoundException, SQLException 
//    {
//        Orders ord = new Orders(1, 30, 20, 10, false);
//        System.out.println("Ord " + ord);
//        om.createPreOrder(ord);
//        boolean expected = false;
//        System.out.println("Check " + expected);
//        System.out.println("Actual " + ord.isOrderConfirmed());
//        assertEquals(expected, ord.isOrderConfirmed());
//    }
//
//    @Test
//    @Disabled
//    public void testAllCustomerOrders() 
//    {
//        int expected = 3;
//        int actual;
//        actual = om.allCustomerOrders(3).size();
//        assertEquals(expected, actual);
//    }
//
//    @Test //works
//    @Disabled
//    public void testIsOrderSentTrue() throws Exception 
//    {
//        boolean actual = om.isOrderSent(1);
//        
//        assertTrue(actual);
//    }
//    
//    @Test //works
//    @Disabled
//    public void testIsOrderSentFalse() throws Exception 
//    {
//        boolean actual = om.isOrderSent(2);
//        assertFalse(actual);      
//    }
//
//    @Test
//    @Disabled
//    public void testSendOrderYes() throws ClassNotFoundException 
//    {
//        om.sendOrder(9);
//        assertTrue(om.isOrderSent(9));
//        
//    }
//    
//    @Test
//    @Disabled
//    public void testSendOrderNo() throws ClassNotFoundException 
//    {
//        assertFalse(om.isOrderSent(10));
//        om.sendOrder(10);
//        assertTrue(om.isOrderSent(10));
//    }
//}
//
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;
        
import functionlayer.Orders;
import functionlayer.UniversalExceptions;
import java.sql.SQLException;
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
    public void testCreatePreOrder() throws UniversalExceptions 
    {      
        Orders ord = new Orders(1, 20, 20, 4);
        
        int orderId = om.createPreOrder(ord);
        
        Orders checkOrder = om.getOrder(orderId);
        assertNotNull(checkOrder);        
    }

    @Test //works
    @Disabled
    public void testGetOrder() throws UniversalExceptions 
    {
        Orders checkId = om.getOrder(2);
        int expected = 2;
        assertEquals(expected, checkId.getOrderId());
    }

    @Test //works
    @Disabled
    public void testAllOrders() throws UniversalExceptions 
    {       
        int expected = om.allOrders().size()+1;
        Orders ord = new Orders(1, 99, 99, 9);
        om.createPreOrder(ord);
        int actual = om.allOrders().size();
        
        assertEquals(expected, actual);
    }

    @Test //works
    @Disabled
    public void testConfirmedOrders() throws UniversalExceptions 
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
    public void testPendingOrders() throws UniversalExceptions 
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
    public void testAllCustomerOrders() throws UniversalExceptions 
    {
        int expected = 3;
        int actual;
        actual = om.allCustomerOrders(3).size();
        assertEquals(expected, actual);
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
    public void testSendOrderYes() throws UniversalExceptions, ClassNotFoundException  
    {
        om.sendOrder(9);
        assertTrue(om.isOrderSent(9));
        
    }
    
    @Test
    @Disabled
    public void testSendOrderNo() throws ClassNotFoundException, UniversalExceptions 
    {
        assertFalse(om.isOrderSent(10));
        om.sendOrder(10);
        assertTrue(om.isOrderSent(10));
    }
}

>>>>>>> a97b363216b068e742c55f65e28ac06f1f4d3f9e
