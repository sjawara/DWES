package com.mycompany.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
	public static void main(String[] args) {
            Producto productoGuardado = new Producto();
            System.out.print("El main se ejecuta de cabo");
    	// Cargar la configuración desde hibernate.cfg.xml
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");

    	// Crear la sesión de fábrica (SessionFactory)
    	SessionFactory sessionFactory = configuration.buildSessionFactory();

    	// Abrir una sesión de Hibernate
    	try (Session session = sessionFactory.openSession()) {

        	Transaction tx = session.beginTransaction();

        	// Crear un objeto Producto y guardarlo en la base de datos
        	Producto producto;
                producto = new Producto("Teclado", 30.0);
        	session.save(producto);

        	tx.commit();

        	// Leer el producto recién guardado desde la base de datos
        	 productoGuardado= session.get(Producto.class, producto.getId());
        	System.out.println("Producto guardado: " + productoGuardado);

    	} catch (Exception e) {
        	e.printStackTrace();
    	} finally {
        	// Cerrar la sesión de fábrica al finalizar
        	sessionFactory.close();
    	}
        	System.out.println("Producto guardado: " + productoGuardado.getNombre());
	}
}

