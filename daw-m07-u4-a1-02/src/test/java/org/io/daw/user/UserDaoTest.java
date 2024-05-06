/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.io.daw.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.h2.engine.User;
import org.ioc.daw.DBConnection;
import org.ioc.daw.user.UserDAO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author alumne_2n
 */
public class UserDaoTest {

    private DBConnection dBConnection;
    private String connectionProperties = "db-test.properties";

    UserDAO userDAO;

    @Before
    public void setUp() {
        dBConnection = new DBConnection(connectionProperties);
        userDAO = new UserDAO(dBConnection);
    }

    @After
    public void tearDown() throws IOException, SQLException {
        userDAO.getConnection().close();
    }

    @Test
    public void findAllUsers() throws SQLException, IOException {
        List<org.ioc.daw.user.User> users = userDAO.findAllUsers();
        Assert.assertEquals("Hauriem de tenir 2 usuaris a la base de dades", 2, users.size());
    }

    @Test
    public void findUserByEmail() throws Exception {
        String existingEmail = "john@email.com";
        String unknownEmail = "does.not@exist.com";

        org.ioc.daw.user.User user = userDAO.findUserByEmail(existingEmail);
        Assert.assertNotNull(user);
        user = userDAO.findUserByEmail(unknownEmail);
        Assert.assertNull(user);
    }

    @Test
    public void createUser() throws Exception {
        String username = "testUser";
        String name = "Pete Test";
        String email = "pete@email.com";
        org.ioc.daw.user.User createdUser = userDAO.createUser(username, name, email);
        Assert.assertNotNull(createdUser);
        Assert.assertEquals(username, createdUser.getUsername());
        Assert.assertNotEquals(0, createdUser.getUserId());
    }
    
    @Test(expected = Exception.class)
public void createUserWithError() throws Exception {
  String username = "sl','sls";
  String name = "Pete Test";
  String email = "pete@email.com";
  org.ioc.daw.user.User createdUser = userDAO.createUser(username, name, email);
  Assert.assertNull(createdUser);
}

@Test
public void updateUserEmail() throws Exception {
  String username = "testUser";
  String name = "Pete Test";
  String email = "pete@email.com";
  org.ioc.daw.user.User createdUser = userDAO.createUser(username, name, email);
  Assert.assertNotNull(createdUser);
  Assert.assertEquals(email, createdUser.getEmail());
  org.ioc.daw.user.User updatedUser = userDAO.updateUserEmail(createdUser.getUsername(), "new@email.com");
  Assert.assertEquals(createdUser.getUserId(), updatedUser.getUserId());
  Assert.assertEquals("new@email.com", updatedUser.getEmail());
}

@Test
public void deleteUser() throws Exception {
  String username = "testUser";
  String name = "Pete Test";
  String email = "pete@email.com";
        org.ioc.daw.user.User createdUser = userDAO.createUser(username, name, email);
  Assert.assertNotNull(createdUser);
  userDAO.deleteUser(createdUser);
        org.ioc.daw.user.User deletedUser = userDAO.findUserByUsername(username);
  Assert.assertNull(deletedUser);
}





}
