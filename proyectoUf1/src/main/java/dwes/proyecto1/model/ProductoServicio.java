/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dwes.proyecto1.model;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author manuc
 */
public class ProductoServicio {
       public List<Producto> getProductos(){
        List<Producto> products = new ArrayList<>();
        products.add(new Producto(1,"HP Laptop",799f));
        products.add(new Producto(2,"IBM Desktop",599f));
        products.add(new Producto(3,"Cannon Printer",159f));
        return products;
    }
       
    /**
     *
     * @param id
     * @return
     */
    public Producto getProducto(int id) {
        Producto product = null;
        switch(id)
        {
            case 1:
                product = new Producto(1,"HP Laptop",799f);
                break;
            case 2:
                product = new Producto(2,"IBM Desktop",599f);
                break;
            case 3:
                product = new Producto(3,"Cannon Printer",159f);
                break;
        }
        return product;
    } 
}