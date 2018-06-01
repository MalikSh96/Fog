//package datalayer;
//
//import businesslayer.User;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.jupiter.api.Disabled;
//
//public class UserMapperTest {
//
//    public UserMapperTest() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @Test
//    @Disabled //doesn't work
//    public void testCreateUser() throws Exception {
//        User original = new User("King", "kong", "kingkongvej 2", 1414, 12345678, "king@kong.com", "kingkongpass");
//        UserMapper.createUser(original);
//        User retrieved = UserMapper.login("king@kong.com", "kingkongpass");
//        assertEquals("customer", retrieved.getRole());
//
//    }
//
//    @Test
//    public void testLogin() throws Exception {
//        User user = UserMapper.login("admin@admin.com", "1234");
//        assertEquals(user.getEmail(), "admin@admin.com");
//    }
//
//}
