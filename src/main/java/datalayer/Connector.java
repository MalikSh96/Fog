package datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static final String URL = "jdbc:mysql://159.89.10.5/FogUsers?serverTimezone=UTC&autoReconnect=true";
    private static final String USERNAME = "testuser";
    private static final String PASSWORD = "Password123#";

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (singleton == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return singleton;
    }

}
