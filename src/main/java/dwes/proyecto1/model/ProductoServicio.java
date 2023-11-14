/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dwes.proyecto1.model;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author manuc
 */
public class ProductoServicio {
            List<Producto> products = new ArrayList<>();

    public ProductoServicio() {
        products.add(new Producto(1,2004,"Fifa 04","EA SPORT",50f));
        products.add(new Producto(2,2007,"PES07","PES",40f));
        products.add(new Producto(3,2018,"Fortnite","EPIC GAMES",0f));
    }
    
       public List<Producto> getProductos(){
        return products;
    }
       public void addProducto(String nom, ){
       
       }
       
       public void eliminarProducto(int  id){
                   Iterator<Producto> iterator = products.iterator();

           boolean sortida =false;
           while(iterator.hasNext()){
               Producto product=iterator.next();
               if(product.getId() == id){
                    iterator.remove();               
           }}}
       
    /**
     *
     * @param id
     * @return
     */
    public Producto getProducto(int id) {
        Producto product = null;
        for(int i=0;i<products.size();i++){
        if(products.get(i).getId()==id){
        product = products.get(i);
        }
        }
        return product;
    } 
}