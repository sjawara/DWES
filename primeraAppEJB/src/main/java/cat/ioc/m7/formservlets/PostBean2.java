/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatefulEjbClass.java to edit this template
 */
package cat.ioc.m7.formservlets;

import jakarta.ejb.Stateful;

/**
 *
 * @author alumne_2n
 */
@Stateful
public class PostBean2 implements PostBean2Local {
 
private int edat;
 
private String  nomCognom, adress, poblacio,codiP, telefon;
 
private String email;
 
@Override
public int getEdat() {
return edat;
}
 
@Override
public void setEdat(String edat) {
if(!edat.equals("")){
this.edat=Integer.parseInt(edat);
}
else{
this.edat = 0;
}
}
 

 
@Override
public String getEmail() {
return email;
}
 
@Override
public void setEmail(String email) {
this.email = email;
}

    @Override
    public String getNomCognom() {
return nomCognom;    }

    @Override
    public String getTelefon() {
return telefon;    }

    @Override
    public String getAdress() {
return adress;    }

    @Override
    public String getCodiP() {
return codiP;    }

    @Override
    public String getPoblacio() {
return poblacio;    }

    
    
    @Override
    public void setNomCognom(String nomCognom) {
this.nomCognom=nomCognom;    }

    @Override
    public void setTelefon(String telefon) {
this.telefon=telefon;
    }

    @Override
    public void setAdress(String adress) {
this.adress=adress;    }

    @Override
    public void setCodiP(String codiP) {
this.codiP=codiP;
    }

    @Override
    public void setPoblacio(String poblacio) {
this.poblacio=poblacio;    }
}
