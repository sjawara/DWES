/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springto;

/**
 *
 * @author alumne_2n
 */
public class FactoriaFacturas {
public static Factura getInstance(String tipo){
if (tipo.equals("IVA")){
  return new FacturaConIVA();
} else {
  return new FacturaSinIVA();
}
}
}
