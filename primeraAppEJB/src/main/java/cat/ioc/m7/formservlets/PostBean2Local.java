/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package cat.ioc.m7.formservlets;

import jakarta.ejb.Local;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author alumne_2n
 */
@Local
public interface PostBean2Local {
 
@Min(value=18, message = "Has de ser major d'edat per escriure un missatge.")
public int getEdat();

@NotNull @Pattern(regexp="^([a-zA-Z]+) ([a-zA-Z]+)$", message = "El nom/cognom no és vàlid.")
public String getNomCognom();
 
@NotNull @Pattern(regexp="^(.+)@(.+)\\.(.+)$", message = "El correu no és vàlid.")
public String getEmail();

@NotNull @Pattern(regexp="^[0-9]{9}$", message="El telefon no es valid")
public String getTelefon();

@NotNull @Pattern(regexp="^(.+)$", message="La direccio no es valida")
public String getAdress();

@NotNull @Pattern(regexp="^[0-9]{5}$", message="El codi postal no es valid")
public String getCodiP();

@NotNull @Pattern(regexp="^[a-zA-Z]+$", message="La poblacio no es valida")
public String getPoblacio();



 
public void setEdat(String edat);

public void setNomCognom(String nomCognom);

public void setTelefon(String telefon);

public void setAdress(String adress);

public void setCodiP(String codiP);

public void setPoblacio(String poblacio);

public void setEmail(String email);
 
}


