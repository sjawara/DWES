/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ioc.con.pru;

import dwes.proyecto1.con.DBConnection;
import dwes.proyecto1.model.Producto;
import dwes.proyecto1.model.ProductoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.h2.engine.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author alumne_2n
 */
public class ProductoDAOTest {

    private DBConnection dBConnection;
    private String connectionProperties = "db-test.properties";

    ProductoDAO ProductoDAO;

    @Before
    public void setUp() {
        dBConnection = new DBConnection(connectionProperties);
        ProductoDAO = new ProductoDAO();
    }

    @After
    public void tearDown() throws IOException, SQLException {
        ProductoDAO.getConnection().close();
    }

    @Test
    public void findAllUsers() throws SQLException, IOException {
        List<Producto> users = ProductoDAO.findAllProductos();
        Assert.assertEquals("Hauriem de tenir 2 usuaris a la base de dades", 2, users.size());
    }

    @Test
    public void findUserByEmail() throws Exception {
        int existingId = 1;
        int unknownId = 15;

        Producto producto = ProductoDAO.findJuegoById(existingId);
        Assert.assertNotNull(producto);
        producto = ProductoDAO.findJuegoById(unknownId);
        Assert.assertNull(producto);
    }

    @Test
    public void createUser() throws Exception {
        int year = 2020;
        String nom = "fortnite";
        String empresa = "Epic";
        float precio = 0.0f;
         ProductoDAO.createJuego(year, nom, empresa, precio);
        Producto createdProducto = ProductoDAO.findJuegoById(3);
        Assert.assertNotNull(createdProducto);
        Assert.assertEquals(nom, createdProducto.getNom());
        Assert.assertNotEquals(0, createdProducto.getId());
    }
    

        
        @Test
        public void updateProducto() throws Exception {
          int year = 2020;
            String nom = "fortnite2";
            String empresa = "Epic";
            float precio = 0.0f;
          ProductoDAO.createJuego(year, nom, empresa, precio);
          Producto createdUser = ProductoDAO.findJuegoById(3);
          Assert.assertNotNull(createdUser);
          ProductoDAO.updateProducto(createdUser.getId(), 200, nom, empresa, precio);
          Producto createdUser2 = ProductoDAO.findJuegoById(3);
          Assert.assertEquals(200, createdUser2.getAny());
        }


        @Test
        public void deleteUser() throws Exception {
            int year = 2020;
            String nom = "fortnite";
            String empresa = "Epic";
            float precio = 0.0f;
          ProductoDAO.createJuego(year, nom, empresa, precio);
          Producto createdUser = ProductoDAO.findJuegoById(3);
          ProductoDAO.deleteProductos(createdUser.getId());
          Producto deletedUser = ProductoDAO.findJuegoById(3);
          Assert.assertNull(deletedUser);
        }





}