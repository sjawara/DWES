package cat.ioc.m7.formservlets;

 
import jakarta.ejb.Local;
 
@Local
public interface PostBeanLocal {

public Boolean isValidNomCognom(String nomCognom);

public Boolean isValidEmail(String email);

public Boolean isValidDataN(String dataN);
public Boolean isValidTelefon(String telefon);
public Boolean isValidAdress(String adress);
public Boolean isValidCodiP(String codiP);
public Boolean isValidPoblacio(String poblacio); 


public Boolean isValidAge(String age);




 
public Boolean isValidPost(String message);
 
}
