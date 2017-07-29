/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.h2.jdbcx.JdbcConnectionPool;

/**
 *
 * @author Ashenafi
 */
public class ConnectionManager {

    private static ConnectionManager connectionManager = null;
    JdbcConnectionPool jdbcConnectionPool;

    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "12345";
    private static final String CONN_STRING = "jdbc:h2:src/DbFolder/Vocabulary";
    Connection conn = null;

    private ConnectionManager() {
    }
    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            return new ConnectionManager();
        } else {
            return connectionManager;
        }
    }

    private boolean openConnection() {

        try {
            jdbcConnectionPool = JdbcConnectionPool.create(CONN_STRING, USER_NAME, PASSWORD);
            conn = jdbcConnectionPool.getConnection();
            //conn = DriverManager.getConnection(CONN_STRING, USER_NAME, PASSWORD);
            return true;
        } catch (SQLException ex) {
            System.out.println("Jdbc is not working correctly");
            return false;
        }
    }

    public Connection getConnection() {
        if (conn == null) {
            if (openConnection()) {
                System.out.println("Connection Opened");
                return conn;
            } else {
                return null;
            }
        }
        return conn;

    }
    
    public void closeConnection() {

        try {
            System.out.println("Closing Connection");
            conn.close();
            conn = null;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
