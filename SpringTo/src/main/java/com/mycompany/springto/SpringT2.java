/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springto;


/**
 *
 * @author alumne_2n
 */
public class SpringT2 {
    public static void main(String[] args) {

           // El contexte de l’aplicació que conté la declaració de classes que vull fer servir en el meu programa
    	ApplicationContext contexto = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");

           // Injecció de dependència i inversió de control
    	Factura factura1 = contexto.getBean(FacturaConIVA.class);

    	factura1.setNumero(1);
    	factura1.setConcepto("ordenador");
    	factura1.setImporte(100);
   	 
    	System.out.println(factura1.getNumero());
    	System.out.println(factura1.getConcepto());
    	System.out.println(factura1.getImporte());

	}
}

