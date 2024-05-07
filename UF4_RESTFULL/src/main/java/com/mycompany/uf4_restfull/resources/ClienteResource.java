/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uf4_restfull.resources;

import com.mycompany.uf4_restfull.domain.Cliente;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author alumne_2n
 */
@Path("/clientes")
public class ClienteResource {

    private static Map<Integer, Cliente> clienteDB
            = new ConcurrentHashMap<Integer, Cliente>();
    private static AtomicInteger idContador = new AtomicInteger();

    @POST
    @Consumes("application/xml")
    public Response crearCliente(Cliente cli) {
        //el parámetro cli se instancia con los datos del cliente del body del mensaje HTTP
        idContador.set(idContador.get() + 1);
        cli.setId(idContador.get());
        clienteDB.put(cli.getId(), cli);
        System.out.println("Cliente creado " + cli.getId());
        return Response.created(URI.create("/clientes/"
                + cli.getId())).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/xml")
    public Cliente recuperarClienteId(@PathParam("id") int id) {
        final Cliente cli = clienteDB.get(id);
        if (cli == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new Cliente(cli.getId(), cli.getNombre(), cli.getApellidos(),
                cli.getDireccion(), cli.getCodPostal(), cli.getCiudad());
    }

    @PUT
    @Path("{id}")
    @Consumes("application/xml")
    public void modificarCliente(@PathParam("id") int id,
            Cliente nuevoCli) {

        Cliente actual = clienteDB.get(id);
        if (actual == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        actual.setNombre(nuevoCli.getNombre());
        actual.setApellidos(nuevoCli.getApellidos());
        actual.setDireccion(nuevoCli.getDireccion());
        actual.setCodPostal(nuevoCli.getCodPostal());
        actual.setCiudad(nuevoCli.getCiudad());
    }
}
