package businesslayer;

import java.util.List;


/**
 * The purpose of User is to...
 * @author kasper
 */
public class User 
{

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String name;
    private String lastname;
    private String address;
    private int postalcode;
    private int phone;
    private String email;
    private String password; // Should be hashed and all
    private String role;    

    /**
     *
     * @param email
     * @param password
     * @param role
     */
    public User( String email, String password, String role ) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    /**
     *
     * @param name
     * @param lastname
     * @param address
     * @param postalcode
     * @param phone
     * @param email
     * @param password
     * @param role
     */
    public User( String name, String lastname, String address, int postalcode, int phone, String email, String password, String role ) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.postalcode = postalcode;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     *
     * @param id
     * @param email
     * @param password
     * @param role
     */
    public User(int id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     *
     * @param id
     * @param name
     * @param lastname
     * @param address
     * @param postal
     * @param phone
     * @param email
     * @param password
     */
    public User(int id, String name, String lastname, String address, int postal, int phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.postalcode = postal;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    /**
     *
     * @param name
     * @param lastname
     * @param address
     * @param postal
     * @param phone
     * @param email
     * @param password
     */
    public User(String name, String lastname, String address, int postal, int phone, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.postalcode = postal;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    /**
     *
     * @return lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return email
     */
    public String getEmail() 
    {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail( String email ) 
    {
        this.email = email;
    }

    /**
     *
     * @return password
     */
    public String getPassword() 
    {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword( String password ) 
    {
        this.password = password;
    }

    /**
     *
     * @return role
     */
    public String getRole() 
    {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole( String role ) 
    {
        this.role = role;
    }

    /**
     *
     * @return id
     */
    public int getId() 
    {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId( int id ) 
    {
        this.id = id;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return postalcode
     */
    public int getPostalcode() {
        return postalcode;
    }

    /**
     *
     * @param postalcode
     */
    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    /**
     *
     * @return phonenumber
     */
    public int getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    /**
     *
     * @param role
     * @return boolean
     */
    public boolean isAdmin(String role) {
        if (role.equals("admin")) { return true; }
        return false;
              
    }

    /**
     *
     * @param role
     * @return boolean
     */
    public boolean isCustomer(String role) {
    if(role.equals("customer")) {return true;}
    return false;
    }
    
    
    @Override
    public String toString() 
    {
        return "<br><br>Id: " + id + "<br>Email: " + email + "<br>Password: " + password + "<br>Adresse: " + address + "<br>Navn: " + name + " " + lastname + "<br>Post nr.: " + postalcode + "<br>Telefon nr.: " + phone;
    }    
}