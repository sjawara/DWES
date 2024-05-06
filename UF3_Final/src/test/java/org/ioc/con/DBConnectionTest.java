package org.ioc.con;

import dwes.proyecto1.con.DBConnection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {

    DBConnection dBConnection;
    Connection connection;

        /*
    @Before
    public void setUp() {
        dBConnection = new DBConnection("db.properties");
    }
*/
    @After
    public void cleanUp() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void connectarAmbLaBaseDeDades() throws IOException, SQLException {
        if (connection != null) {
            connection.close();
        }
        dBConnection = new DBConnection("db.properties");
        connection = dBConnection.getConnection();
        Assert.assertEquals("H2 JDBC Driver", connection.getMetaData().getDriverName());
        Assert.assertEquals("SOCIOC_DB", connection.getCatalog());
    }

    @Test
    public void dbConnectionWrongDriver() throws IOException, SQLException {
        if (connection != null) {
            connection.close();
        }
        dBConnection = new DBConnection("wrong.properties");
        connection = dBConnection.getConnection();
        Assert.assertNull(connection);
    }

}
