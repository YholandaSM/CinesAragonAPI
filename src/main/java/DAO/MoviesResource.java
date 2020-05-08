package DAO;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Pelicula;

/**
 * REST Web Service
 *
 * @author Hp
 */
@Path("movies")
public class MoviesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MoviesResource
     */
    public MoviesResource() {
    }

   
    @GET
    @Produces("application/json")
    public String getJson() {
        PeliculaDAO peliculaDao = new PeliculaDAO();
        ArrayList<Pelicula> lstPeliculas = peliculaDao.findAll(null);
        return Pelicula.toArrayJSon(lstPeliculas);
    }
    
     
    @GET()
     @Path("/topten")
    @Produces("application/json")
    public String getTopTen() {
        PeliculaDAO peliculaDao = new PeliculaDAO();
        ArrayList<Pelicula> lstPeliculas = peliculaDao.findTopTen();
        return Pelicula.toArrayJSon(lstPeliculas);
    }

    /**
     * PUT method for updating or creating an instance of MoviesResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String add(Pelicula pelicula){
        PeliculaDAO peliculaDao = new PeliculaDAO();
        int resp = peliculaDao.add(pelicula);
        return Pelicula.toObjectJson(pelicula);
    }

}
