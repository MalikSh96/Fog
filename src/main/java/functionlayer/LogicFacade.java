package functionlayer;

import dbaccess.UserMapper;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade 
{
    public static User login(String email, String password) throws LoginSampleException 
    {
        return UserMapper.login(email, password);
    }
    
    public static User createUser(String name, String lastname, String address, int postalcode, int phone, String email, String password) throws LoginSampleException 
    {
        User user = new User(name, lastname, address, postalcode, phone, email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }
}
