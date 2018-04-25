/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import functionlayer.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author malik
 */
public class UserMapperTest {
    
    public UserMapperTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testCreateUser() throws Exception {
        User original = new User( "king@kong.com", "uhahvorhemmeligt", "konge" );
        UserMapper.createUser( original );
        User retrieved = UserMapper.login( "king@kong.com", "uhahvorhemmeligt" );
        assertEquals( "konge", retrieved.getRole() );
        
    }

    @Test
    public void testLogin() throws Exception {
        User user = UserMapper.login( "maliksharfo@hotmail.com", "1234" );
        assertTrue( user != null );
    }
    
}
