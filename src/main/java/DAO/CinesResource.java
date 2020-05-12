/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import model.Cine;
import model.Pelicula;
 

/**
 * REST Web Service
 *
 * @author Hp
 */
@Path("cines")
@RequestScoped
public class CinesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CineResource
     */
    public CinesResource() {
    }

    /**
     * Retrieves representation of an instance of DAO.CinesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        CineDAO cineDao = new CineDAO();
        ArrayList<Cine> lstCines = cineDao.findAll(null);
        return Cine.toArrayJSon(lstCines);
    }


    /**
     * PUT method for updating or creating an instance of CinesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
     @POST
    @Path("/cinesporpelicula")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public String getCinesByPelicula(Pelicula pelicula) {

        CineDAO cineDao = new CineDAO();
        ArrayList<Cine> lstCines = cineDao.findCinesByPelicula(pelicula);
        return Cine.toArrayJSon(lstCines);

    }
}
