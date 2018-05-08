package functionlayer;

import java.util.List;


/**
 * The purpose of User is to...
 * @author kasper
 */
public class User 
{

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String name;
    private String address;
    private int postalcode;
    private int phone;
    private String email;
    private String password; // Should be hashed and all
    private String role;    

    
    public User( String email, String password, String role ) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    public User( String name, String address, int postalcode, int phone, String email, String password, String role ) {
        this.name = name;
        this.address = address;
        this.postalcode = postalcode;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(int id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String name, String address, int postal, int phone, String email, String password) {
        this.name = name;
        this.address = address;
        this.postalcode = postal;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }



    public String getEmail() 
    {
        return email;
    }

    public void setEmail( String email ) 
    {
        this.email = email;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword( String password ) 
    {
        this.password = password;
    }

    public String getRole() 
    {
        return role;
    }

    public void setRole( String role ) 
    {
        this.role = role;
    }

    public int getId() 
    {
        return id;
    }

    public void setId( int id ) 
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    @Override
    public String toString() 
    {
        return "User\nId: " + id + "\nemail: " + email + "\nPassword: " + password + "\nrole: " + role + "\naddress: " + address + "\nname: " + name + "\npostal: " + postalcode + "\nphone: " + phone;
    }    
}