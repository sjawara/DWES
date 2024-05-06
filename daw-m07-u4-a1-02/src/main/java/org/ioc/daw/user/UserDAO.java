/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ioc.daw.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.ioc.daw.DBConnection;
import static org.ioc.daw.Uf3.getConnection;
import org.ioc.daw.user.User;

/**
 *
 * @author alumne_2n
 */
public class UserDAO {

    private DBConnection dBConnection;
    private Connection connection;

    public UserDAO(DBConnection dBConnection) {
        this.dBConnection = dBConnection;
    }

    public DBConnection getDBConnection() {
        return this.dBConnection;
    }

    public List<User> findAllUsers() {
        String qry = "select user_id, username, name, email, rank, active, created_on from users";
        List<User> users = executeQuery(qry);
        return users;
    }

    public User findUserByEmail(String userEmail) throws Exception {
        String qry = "select * from users where email ='" + userEmail + "'";
        return findUniqueResult(qry);
    }

    public User findUserByUsername(String username) throws Exception {
        String qry = "select * from users where username ='" + username + "'";
        return findUniqueResult(qry);
    }

    private User buildUserFromResultSet(ResultSet rs) throws SQLException {
        int userId = rs.getInt("user_id");
        String username = rs.getString("username");
        String name = rs.getString("name");
        String email = rs.getString("email");
        int rank = rs.getInt("rank");
        boolean active = rs.getBoolean("active");
        Timestamp timestamp = rs.getTimestamp("created_on");
        User user = new User(userId, username, name, email, rank, timestamp, active);
        return user;
    }

    private User findUniqueResult(String query) throws Exception {
        List<User> users = executeQuery(query);
        if (users.isEmpty()) {
            return null;
        }
        if (users.size() > 1) {
            throw new Exception("Only one result expected");
        }
        return users.get(0);
    }

    private List<User> executeQuery(String query) {
        List<User> users = new ArrayList<>();

        if (getConnection() == null) {
            try {
                setConnection(dBConnection.getConnection());
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        try (
                Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                User user = buildUserFromResultSet(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public User createUser(String username, String name, String email) throws Exception {
        String qry = "INSERT INTO users (username, name, email) VALUES ('"
                + username + "', '"
                + name + "', '"
                + email + "'"
                + ");";
        return createOrUpdateUser(username, qry);
    }

    private int executeUpdateQuery(String query) {
        int result = 0;
        if (getConnection() == null) {
            try {
                setConnection(dBConnection.getConnection());
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        try (
                Statement stmt = getConnection().createStatement()) {
            result = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public User updateUserEmail(String username, String newEmail) throws Exception {
        String qry = "UPDATE users "
                + "SET email = '" + newEmail + "' "
                + "WHERE username = '" + username + "' "
                + ";";
        return createOrUpdateUser(username, qry);
    }

    private User createOrUpdateUser(String username, String query) throws Exception {
        int result = executeUpdateQuery(query);
        if (result == 0) {
            throw new Exception("Error creating user");
        }
        return findUserByUsername(username);
    }

    public void deleteUser(User user) throws Exception {
        String query = "DELETE FROM users WHERE user_id = '" + user.getUserId() + "' ";
        createOrUpdateUser(user.getUsername(), query);
    }

}
