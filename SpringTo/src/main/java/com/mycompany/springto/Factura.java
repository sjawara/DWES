/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springto;


public abstract class Factura{

private int numero;
private String concepto;
private double importe;


public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

/**
     * generem tots els mètodes abstractes setters, getters,
     * una constructora sense paràmetres, i
     * una constructora amb tots els paràmetres
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Factura() {
    }

    public Factura(int numero, String concepto, double importe) {
        this.numero = numero;
        this.concepto = concepto;
        this.importe = importe;
    }
    

    public abstract double getImporteTotal();

}
