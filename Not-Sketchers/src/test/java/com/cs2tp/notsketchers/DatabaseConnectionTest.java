package com.cs2tp.notsketchers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseConnectionTest {
    @Test
    public void testDatabaseConnection() throws SQLException {
        /** Replace "your_url" and "your_db" with your Localhost URL and Database Name.
         *  Replace "your_username" and "your_password" with your Localhost PHPMyAdmin
         *  username and password.
         */
        String url = "jdbc:mysql://your_url/your_db";
        String username = "your_username";
        String password = "your_password";

        //Creates a connection using the DriverManager and the arguments provided above
        Connection connection = DriverManager.getConnection(url, username, password);

        // Asserts whether the connection is established or not
        assertNotNull(connection);
        assertTrue(connection.isValid(0));
    }
}