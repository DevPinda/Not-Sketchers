package com.cs2tp.notsketchers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySqlIntegrationTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            assertTrue(connection.isValid(500));
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
