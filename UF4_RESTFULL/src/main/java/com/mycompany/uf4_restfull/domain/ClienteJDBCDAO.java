/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uf4_restfull.domain;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author alumne_2n
 */
public class ClienteJDBCDAO {
    private static SessionFactory sessionFactory;

    // Bloque de inicialización estático para configurar Hibernate y crear el SessionFactory
    static {
        try {
            // Cargar la configuración desde hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            // Crear la sesión de fábrica (SessionFactory)
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Manejar la excepción inicial si la configuración falla
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void guardarCliente(Cliente cli) {
        // Abrir una sesión de Hibernate
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            // Guardar el objeto Cliente en la base de datos
            session.save(cli);
            tx.commit();
            // Leer el cliente recién guardado desde la base de datos
            Cliente clienteGuardado = session.get(Cliente.class, cli.getId());
            System.out.println("Cliente guardado: " + clienteGuardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void modificarCliente(Cliente cli) {
            try (Session session = sessionFactory.openSession()) {
                Transaction tx = session.beginTransaction();

                // Verificar si el cliente existe en la base de datos
                //Lo he echo asi porque al modificar con el session me aparecia un error.
                Cliente clienteExistente = session.get(Cliente.class, cli.getId());
                if (clienteExistente != null) {
                    // Copiar valores del nuevo cliente al cliente existente
                    clienteExistente.setNombre(cli.getNombre());
                    clienteExistente.setApellidos(cli.getApellidos());
                    clienteExistente.setDireccion(cli.getDireccion());
                    clienteExistente.setCodPostal(cli.getCodPostal());
                    clienteExistente.setCiudad(cli.getCiudad());

                    // Actualizar el objeto Cliente en la base de datos
                    session.update(clienteExistente);
                    tx.commit();

                    // Leer el cliente recién actualizado desde la base de datos
                    Cliente clienteGuardado = session.get(Cliente.class, cli.getId());
                    System.out.println("Cliente actualizado: " + clienteGuardado);
                } else {
                    System.out.println("Cliente no encontrado con ID: " + cli.getId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    public void borrarClientePorId(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            
            // Obtener el cliente de la base de datos según su ID
            Cliente cliente = session.get(Cliente.class, id);
            if (cliente != null) {
                // Borrar el objeto Cliente de la base de datos
                session.delete(cliente);
                tx.commit();
                System.out.println("Cliente borrado: " + cliente);
            } else {
                System.out.println("Cliente no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cliente obtenerClientePorId(int id) {
        Cliente cliente = null;
        // Abrir una sesión de Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Obtener el cliente de la base de datos según su ID
            cliente = session.get(Cliente.class, id);
            System.out.println("Cliente obtenido: " + cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
        public ArrayList<Cliente> obtenerTodosLosClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        // Abrir una sesión de Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Crear una consulta HQL para obtener todos los clientes
            Query<Cliente> query = session.createQuery("from Cliente", Cliente.class);
            // Ejecutar la consulta y obtener el resultado
            listaClientes.addAll(query.getResultList());
            System.out.println("Clientes obtenidos: " + listaClientes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    // Método para cerrar el SessionFactory al finalizar (opcional, por si se requiere)
    public static void cerrarSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}