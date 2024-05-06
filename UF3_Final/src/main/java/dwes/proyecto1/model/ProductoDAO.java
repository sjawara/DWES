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
    
     public List<Producto> findAllProductos() {
        String qry = "select id,any, nom, empresa, preu from productos";
        List<Producto> users = executeQuery(qry);
        return users;
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
