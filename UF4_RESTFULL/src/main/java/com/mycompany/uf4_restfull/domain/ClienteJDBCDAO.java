/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uf4_restfull.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author alumne_2n
 */
public class ClienteJDBCDAO {
    public  void guaradrCliente(Cliente cli){
    	// Cargar la configuración desde hibernate.cfg.xml
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");

    	// Crear la sesión de fábrica (SessionFactory)
    	SessionFactory sessionFactory = configuration.buildSessionFactory();

    	// Abrir una sesión de Hibernate
    	try (Session session = sessionFactory.openSession()) {

        	Transaction tx = session.beginTransaction();

        	// Crear un objeto Producto y guardarlo en la base de datos
        	
        	session.save(cli);

        	tx.commit();

        	// Leer el producto recién guardado desde la base de datos
        	Cliente productoGuardado = session.get(Cliente.class, cli.getId());
        	System.out.println("Producto guardado: " + productoGuardado);

    	} catch (Exception e) {
        	e.printStackTrace();
    	} finally {
        	// Cerrar la sesión de fábrica al finalizar
        	sessionFactory.close();
    	}
	}

}
