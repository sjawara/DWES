/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springto;

/**
 *
 * @author alumne_2n
 */
public class SpringT1 {
    public static void main (String[] args){

Factura f1= FactoriaFacturas.getInstance("IVA");
f1.setNumero(1);
f1.setConcepto("ordenador gama baja");
f1.setImporte(300);
System.out.println(f1.getImporteTotal());

Factura f2= FactoriaFacturas.getInstance("SinIVA");
f2.setNumero(2);
f2.setConcepto("ordenador gama alta");
f2.setImporte(500);
System.out.println(f2.getImporteTotal());
}
}



