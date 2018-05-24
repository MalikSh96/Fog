package functionlayer;

import businesslayer.ItemList;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
        int width = 800; //600 ends in the first if
        int length = 800;
        int expected;
        int actual;
        if(width < 800)
        {
            expected = 8;
            
            li.postAmount(length, width);
            actual = li.getPostTotal();
            
            assertEquals(expected, actual);
        }
        else
        {
            expected = 12;
            li.postAmount(length, width);
            actual = li.getPostTotal();
            
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testRaftAmount() 
    {
        int width = 400;
        int length = 800;
        int expected;
        int actual;
        if(width < 600)
        {
            expected = 16;
            li.raftAmount(length, width);
            actual = li.getRaftTotal();
            
            assertEquals(expected, actual);         
        }
        else
        {
            expected = 32;
            li.raftAmount(length, width);
            actual = li.getRaftTotal();
            
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testRemAmount() 
    {
        int length = 800; //600 and less gives 2
        int expected;
        int actual;
        if(length <= 600)
        {
            expected = 2;
            li.remAmount(length);
            actual = li.getRemTotal();
            
            assertEquals(expected, actual);
        }
        else
        {
            expected = 4;
            li.remAmount(length);
            actual = li.getRemTotal();
            
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testRoofAmount() 
    {
        int width = 700;
        int length = 700;
        int expected;
        int actual;
        if(width > 600)
        {
            expected = 14;
            li.roofAmount(length, width);
            actual = li.getRoofTotal();
            
            assertEquals(expected, actual);            
        }
        else
        {
            expected = 4;
            li.roofAmount(length, width);
            actual = li.getRoofTotal();
            
            assertEquals(expected, actual);
        }
    }

    @Test
    @Disabled
    public void testShed() {
    }    
}
