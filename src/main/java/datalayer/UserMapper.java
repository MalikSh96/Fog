package datalayer;

import businesslayer.Constants;
import businesslayer.UniversalExceptions;
import businesslayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    private static Constants con = new Constants();

    /**
     *
     * @param user
     * @throws UniversalExceptions
     */
    public static void createUser(User user) throws UniversalExceptions {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (name, lastname, address, postalnumber, phone, email, password, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getName());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getAddress());
            ps.setInt(4, user.getPostalcode());
            ps.setInt(5, user.getPhone());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getPassword());
            ps.setString(8, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            con.getUEX().ThrowDidNotCreateUserException();
            throw new UniversalExceptions(ex.getMessage());
        }
    }

    /**
     *
     * @param email
     * @param password
     * @return user
     * @throws UniversalExceptions
     */
    public static User login(String email, String password) throws UniversalExceptions {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new UniversalExceptions("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            con.getUEX().ThrowDidNotLoginException();
            throw new UniversalExceptions(ex.getMessage());
        }
    }

    /**
     *
     * @param email
     * @return id
     * @throws UniversalExceptions
     */
    public static int getUserId(String email) throws UniversalExceptions {
        int id = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id FROM FogUsers.users where email = '" + email + "';";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            con.getUEX().ThrowDidNotGetTheUserIdException();
            throw new UniversalExceptions(ex.getMessage());
        }
        return id;
    }

    /**
     *
     * @param userId
     * @return user
     * @throws UniversalExceptions
     */
    public static User getUser(int userId) throws UniversalExceptions {
        User u = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM FogUsers.users where id = '" + userId + "'";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery(SQL);
            while (rs.next()) {
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                int postal = rs.getInt("postalnumber");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String password = rs.getString("password");

                u = new User(name, lastname, address, postal, phone, email, password);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            con.getUEX().ThrowDidNotGetTheUserException();
            throw new UniversalExceptions(ex.getMessage());
        }
        return u;
    }

    /**
     *
     * @param userId
     * @param name
     * @param lastname
     * @param address
     * @param postalnumber
     * @param phone
     * @param email
     * @param password
     * @throws UniversalExceptions
     */
    public static void UpdateUserInfo(int userId, String name, String lastname, String address,
            int postalnumber, int phone, String email, String password) throws UniversalExceptions {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE FogUsers.users SET name = '" + name
                    + "', lastname = '" + lastname + "', address = '" + address + "', postalnumber = '" + postalnumber
                    + "', phone = '" + phone + "', email = '" + email
                    + "', password = '" + password + "' WHERE id='" + userId + "';";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            con.getUEX().ThrowDidNotUpdateUserInfoException();
            throw new UniversalExceptions(ex.getMessage());
        }
    }

    /**
     *
     * @return userList
     * @throws UniversalExceptions
     */
    public static List<User> getAllUsers() throws UniversalExceptions {
        List<User> userlist = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM FogUsers.users";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery(SQL);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                int postal = rs.getInt("postalnumber");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String password = rs.getString("password");

                userlist.add(new User(id, name, lastname, address, postal, phone, email, password));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            con.getUEX().ThrowDidNotGetUserListException();
            throw new UniversalExceptions(ex.getMessage());
        }
        return userlist;
    }

    /**
     *
     * @return idList
     * @throws UniversalExceptions
     */
    public static List<Integer> getAllUserIds() throws UniversalExceptions {
        List<Integer> idList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id FROM FogUsers.users order by id asc";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery(SQL);
            while (rs.next()) {
                int id = rs.getInt("id");
                idList.add(id);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            con.getUEX().ThrowDidNotGetAllUserIdsException();
            throw new UniversalExceptions(ex.getMessage());
        }
        return idList;
    }

    /**
     *
     * @return list
     * @throws UniversalExceptions
     */
    public static List<String> getAllUserNames() throws UniversalExceptions {
        List<String> names = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT name FROM FogUsers.users order by id asc";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery(SQL);
            while (rs.next()) {
                String id = rs.getString("name");

                names.add(id);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            con.getUEX().ThrowDidNotGetAllUserIdsException();
            throw new UniversalExceptions(ex.getMessage());
        }

        return names;
    }

    /**
     *
     * @return list
     * @throws UniversalExceptions
     */
    public static List<String> getAllUserLastnames() throws UniversalExceptions {
        List<String> lastnames = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT lastname FROM FogUsers.users order by id asc";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery(SQL);
            while (rs.next()) {
                String id = rs.getString("lastname");

                lastnames.add(id);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            con.getUEX().ThrowDidNotGetAllUserIdsException();
            throw new UniversalExceptions(ex.getMessage());
        }
        return lastnames;
    }

    /**
     *
     * @param userId
     * @return list
     * @throws UniversalExceptions
     */
    public static List<String> getAllUserInfo(int userId) throws UniversalExceptions {
        List<String> infoList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM FogUsers.users where id='" + userId + "'";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery(SQL);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                int postal = rs.getInt("postalnumber");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                infoList.add("Bruger id: " + id);
                infoList.add("Navn: " + name + " " + lastname);
                infoList.add("Adresse: " + address);
                infoList.add("Post nr: " + postal);
                infoList.add("Telefon nr: " + phone);
                infoList.add("Email: " + email);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            con.getUEX().ThrowDidNotGetAllUserIdsException();
            throw new UniversalExceptions(ex.getMessage());
        }
        return infoList;
    }

    /**
     *
     * @param userId
     * @return role
     * @throws UniversalExceptions
     */
    public static String getUserRole(int userId) throws UniversalExceptions {
        String role = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT role FROM FogUsers.users where id = '" + userId + "';";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                role = rs.getString("role");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            con.getUEX().ThrowDidNotGetUserRoleException();
            throw new UniversalExceptions(ex.getMessage());
        }
        return role;
    }

    /**
     *
     * @param userId
     * @return username
     * @throws UniversalExceptions
     */
    public static String getUserName(int userId) throws UniversalExceptions {
        String name = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT name FROM FogUsers.users where id = '" + userId + "';";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            con.getUEX().ThrowDidNotGetUserRoleException();
            throw new UniversalExceptions(ex.getMessage());
        }
        return name;
    }

    /**
     *
     * @param userId
     * @return lastname
     * @throws UniversalExceptions
     */
    public static String getUserLastname(int userId) throws UniversalExceptions {
        String lastname = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT lastname FROM FogUsers.users where id = '" + userId + "';";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lastname = rs.getString("lastname");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            con.getUEX().ThrowDidNotGetUserRoleException();
            throw new UniversalExceptions(ex.getMessage());
        }
        return lastname;
    }

    /**
     *
     * @param userId
     * @return boolean
     * @throws UniversalExceptions
     */
    public boolean UserIdExists(int userId) throws UniversalExceptions {
        boolean exists = false;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM FogUsers.users where id = '" + userId + "';";

            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
                return exists;
            }
        } catch (SQLException | ClassNotFoundException ex) { //temporary error
            con.getUEX().ThrowDidNotFindUserIdException();
            throw new UniversalExceptions(ex.getMessage());
        }
        return exists;
    }
}
