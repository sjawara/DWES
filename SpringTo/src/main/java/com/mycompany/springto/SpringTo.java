/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.springto;

/**
 *
 * @author alumne_2n
 */
public class SpringTo {
            public static void imprimir (Factura factura){

System.out.println("***************");
System.out.println(factura.getImporteTotal());
System.out.println("***************");

}

    public static void main(String[] args) {
        System.out.println("Hello World!");

        FacturaConIVA f1 = new FacturaConIVA(1, "ordenador2", 300);
        imprimir(f1);
        //System.out.println(f1.getImporteTotal());
        FacturaSinIVA f2 = new FacturaSinIVA(2, "tablet", 400);
        imprimir(f2);
        //System.out.println(f2.getImporteTotal());



    }
}
