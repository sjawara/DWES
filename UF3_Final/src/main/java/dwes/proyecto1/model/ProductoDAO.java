/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dwes.proyecto1.model;

import dwes.proyecto1.con.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumne_2n
 */
public class ProductoDAO {
     private DBConnection dBConnection;
    private Connection connection;
    private String connectionProperties = "db-test.properties";    
       public ProductoDAO () {   
        dBConnection = new DBConnection(connectionProperties);
        this.dBConnection = dBConnection;
    }

    

    public DBConnection getDBConnection() {
        return this.dBConnection;
    }
    
     public Connection getConnection() {
        return this.connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public void deleteProductos(int id) throws Exception{
      String query = "DELETE FROM productos WHERE id = " + id; System.out.println("Esta es la query que elimina "+query);
      createOrUpdateUser("nada", query);
    }
    
     public List<Producto> findAllProductos() {
        String qry = "select id,any, nom, empresa, preu from productos";
        List<Producto> users = executeQuery(qry);
        return users;
    }
     
    public Producto findJuegoById(int id) throws Exception {
       String qry = "select id,any, nom, empresa, preu from productos where id =' " + id + "'";
       Producto users = findUniqueResult(qry);
       return users;
    }
    
    public void createJuego(int year, String nom, String empresa, float precio) throws Exception {
        String qry = "INSERT INTO productos (any, nom, empresa, preu) VALUES ('"
                + year + "', '"
                + nom + "', '"
                + empresa + "', '"
                + precio + "'"
                + ");";
        createProducto(qry);
    }

    
    private void createProducto(String qry) throws Exception{
        System.out.println("Entra en la funcion createProducto DAO");
        int result = executeUpdateQuery(qry);
        if (result == 0) {
            throw new Exception("Error creating user");
        }else{
            System.out.println("El producto se ha añadido correctamente");
        }
    }
    
     public void updateProducto(int id, int year, String nombre, String empresa, float precio) throws Exception {
        String qry = "UPDATE productos "
                + "SET any = '" + year + "' ,"
                + " nom = '" + nombre + "' ,"
                + " empresa = '" + empresa + "' ,"
                + " preu = '" + precio + "' "
                + "WHERE id = '" + id + "' "
                + ";";
        createProducto(qry);
    }
    
    private Producto createOrUpdateUser(String username, String query) throws Exception {
        int result = executeUpdateQuery(query);
        if (result == 0) {
            throw new Exception("Error creating user");
        }
        return findUserByUsername(username);
    }
    
    public Producto findUserByUsername(String username) throws Exception {
        String qry = "select * from productos where username ='" + username + "'";
        return findUniqueResult(qry);
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
    
    

    
    
    private Producto findUniqueResult(String query) throws Exception {
        List<Producto> users = executeQuery(query);
        if (users.isEmpty()) {
            return null;
        }
        if (users.size() > 1) {
            throw new Exception("Only one result expected");
        }
        return users.get(0);
    }
     
     private List<Producto> executeQuery(String query) {
        List<Producto> users = new ArrayList<>();

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
                Producto user = buildProductoFromResultSet(rs);
                users.add(user);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
     
         private Producto buildProductoFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int any = rs.getInt("any");
        String nom = rs.getString("nom");
        String empresa = rs.getString("empresa");
        float preu = rs.getFloat("preu");
        Producto producto = new Producto(id, any, nom, empresa, preu);
        return producto;
    }

}
