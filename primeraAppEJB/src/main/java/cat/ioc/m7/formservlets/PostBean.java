/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package cat.ioc.m7.formservlets;

import jakarta.ejb.Stateless;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alumne_2n
 */
@Stateless
public class PostBean implements PostBeanLocal {
 
@Override
public Boolean isValidEmail(String email) {
//pattern
String regex = "^(.+)@(.+)\\.(.+)$";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(email);
return matcher.matches();
}
 
@Override
public Boolean isValidAge(String age) {
//min 18
if(age != null && !age.equals("")) return Integer.parseInt(age) >= 18;
return false;
}
 
@Override
public Boolean isValidPost(String message) {
//length post < 150
return message.length() <= 150;
}

    @Override
    public Boolean isValidNomCognom(String nomCognom) {
        String regex = "^([a-zA-Z]+) ([a-zA-Z]+)$";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(nomCognom);
return matcher.matches();
    }

    @Override
    public Boolean isValidDataN(String dataN) {
        String regex = "^([0-9]{2})-([0-9]{2})-([0-9]{4})$";
        Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(dataN);
    return matcher.matches();
    }

    @Override
    public Boolean isValidTelefon(String telefon) {
             String regex = "^[0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(telefon);
    return matcher.matches();
    }

    @Override
    public Boolean isValidAdress(String adress) {
  String regex = "^(.+)$";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(adress);
return matcher.matches();    }

    @Override
    public Boolean isValidCodiP(String codiP) {
String regex = "^[0-9]{5}$";
        Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(codiP);
    return matcher.matches();    }

    @Override
    public Boolean isValidPoblacio(String poblacio) {
         String regex = "^[a-zA-Z]+$";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(poblacio);
return matcher.matches();
    }
    
}
