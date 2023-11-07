/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dwes.proyecto1.model;

/**
 *
 * @author manuc
 */
public class Producto {
    private int id;
    private String name;
    private float price;
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
 
    public Producto(){
        this.id = -1;
        this.name = "";
        this.price = 0f;
    }
 
    public Producto(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}