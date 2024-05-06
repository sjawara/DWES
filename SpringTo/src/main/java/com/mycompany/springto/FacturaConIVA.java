/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springto;

/**
 *
 * @author alumne_2n
 */
public class FacturaConIVA extends Factura {


// implementar les dues funcions constructores

@Override
public double getImporteTotal(){
return this.getImporte()*1.21;
}

    public FacturaConIVA() {
    }

    public FacturaConIVA(int numero, String concepto, double importe) {
        super(numero, concepto, importe);
    }

}
