/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionlayer;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author malik
 */
public class ItemListTest {
    
    public ItemListTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    private ItemList li = new ItemList();

    @Test
    public void testPostAmount() 
    {
        int width = 600;
        int length = 600;
        int expected;
        int actual;
        if(width < 800)
        {
            expected = li.getPost().size() + 1; //0
            
            li.postAmount(length, width);
            //actual = li.getPost();
            
            assertEquals(expected, actual);
        }
        else
        {
            
        }
        
    }

    @Test
    @Disabled
    public void testRaftAmount() {
    }

    @Test
    @Disabled
    public void testRemAmount() {
    }

    @Test
    @Disabled
    public void testRoofAmount() {
    }

    @Test
    @Disabled
    public void testShed() {
    }    
}
