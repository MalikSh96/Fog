///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dbaccess;
//
//import functionlayer.Orders;
//import java.util.List;
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
//    @Test
//    @Disabled
//    public void testCreatePreOrder() 
//    {      
//        Orders ord = new Orders(1, 20, 20, 4);
//        
//        int orderId = om.createPreOrder(ord);
//        
//        Orders checkOrder = om.getOrder(orderId);
//        assertNotNull(checkOrder);        
//    }
//
//    @Test
//    public void testGetOrder() 
//    {
//        Orders checkId = om.getOrder(2);
//        int expected = 2;
//        assertEquals(expected, checkId.getOrderId());
//    }
//
//    @Test
//    @Disabled
//    public void testAllOrders() 
//    {       
//        int expected = om.allOrders().size()+1;
//        Orders ord = new Orders(1, 99, 99, 9);
//        om.createPreOrder(ord);
//        int actual = om.allOrders().size();
//        
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    @Disabled
//    public void testConfirmedOrders() 
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
//    @Test
//    @Disabled
//    public void testPendingOrders() 
//    {
//        Orders ord = new Orders(1, 30, 20, 10, false);
//        System.out.println("Ord " + ord);
//        om.createPreOrder(ord);
//        boolean expected = false;
//        System.out.println("Check " + expected);
//        System.out.println("Actual " + ord.isOrderConfirmed());
//        assertEquals(expected, ord.isOrderConfirmed());
//    }
//}