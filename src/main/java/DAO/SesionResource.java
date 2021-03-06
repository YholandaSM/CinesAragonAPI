/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import model.Cine;
import model.ParametrosJason;
import model.Pelicula;
import model.Sesion;

/**
 * REST Web Service
 *
 * @author Hp
 */
@Path("sesion")
@RequestScoped
public class SesionResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SesionResource
     */
    public SesionResource() {
    }

   
    /**
     * Retrieves representation of an instance of DAO.SesionResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of SesionResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    
   /* @POST
    @Path("/sesionfiltros")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public String getSesionByPeliculaCine(Pelicula pelicula, Cine cine) {

        SesionDAO sesionDao = new SesionDAO();
        ArrayList<Sesion> lstSesiones = sesionDao.findSesionByPeliculaCine(pelicula, cine);
        return Sesion.toArrayJSon(lstSesiones);

    }*/
    
    @POST
    @Path("/sesionfiltros")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public String getSesionByPeliculaCine(ParametrosJason parametros) {

        SesionDAO sesionDao = new SesionDAO();
        ArrayList<Sesion> lstSesiones = sesionDao.findSesionByPeliculaCine(parametros.getPelicula(), parametros.getCine());
        return Sesion.toArrayJSon(lstSesiones);

    }
    
    
}
