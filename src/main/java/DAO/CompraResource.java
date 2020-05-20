/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import model.Compra;
import model.CompraEntrada;

/**
 * REST Web Service
 *
 * @author Hp
 */
@Path("compra")
@RequestScoped
public class CompraResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VompraResource
     */
    public CompraResource() {
    }

    /**
     * Retrieves representation of an instance of DAO.VompraResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of VompraResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertar")
    public String add(CompraEntrada compra) {
        CompraDao compraDao = new CompraDao();
        int resp = compraDao.add(compra.getCompra());
        return Compra.toObjectJson(compra.getCompra());
    }
}
