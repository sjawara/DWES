/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ioc.daw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alumne_2n
 */
public class Uf3 {
    public static Connection getConnection() {
  Connection con = null;
  try {
    Class.forName("org.h2.Driver");
    con = DriverManager.getConnection("jdbc:h2:mem:socioc_db", "usuari" , "passwd");
  } catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
  }
  return con;
}

public static void main(String[] args){
  System.out.println("Voy a conectarme");
  Connection con = getConnection();
  if (con != null){
    System.out.println("Si no ha habido error me he conectado");
    System.out.println(con.toString());
  } else {
    System.out.println("Algo no fue bien");
  }
}

}
