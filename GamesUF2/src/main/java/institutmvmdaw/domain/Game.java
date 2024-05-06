/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institutmvmdaw.domain;

/**
 *
 * @author alumne_2n
 */
public class Game {
    int year,limitDownload;
    String id, nom,empresa, categoria, plataforma;
    float preu;

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    
    
    
    
    
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getLimitDownload() {
        return limitDownload;
    }

    public void setLimitDownload(int limitDownload) {
        this.limitDownload = limitDownload;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Game() {
    }
    


    public Game( String id, String nom, String empresa, float preu, int year,int limitDownload,String categoria, String plataforma) {
        this.year = year;
        this.id = id;
        this.nom = nom;
        this.empresa = empresa;
        this.preu = preu;
        this.limitDownload=limitDownload;
        this.categoria=categoria;
        this.plataforma = plataforma;
    }
    
    
    
    
}
