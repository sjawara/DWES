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
    
    private int id,any;
    private String nom, empresa;
    private float preu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public Producto(int id, int any, String nom, String empresa, float preu) {
        this.id = id;
        this.any = any;
        this.nom = nom;
        this.empresa = empresa;
        this.preu = preu;
    }
 
    
 
    public Producto(){
        this.id = -1;
        this.nom = "";
        this.preu = 0f;
    }
 
  
}