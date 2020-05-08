package DAO;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Pelicula;
import model.Usuario;

/**
 * REST Web Service
 *
 * @author Hp
 */
@Path("UserWS")
public class UserWs {

    @Context
    private UriInfo context;

    public UserWs() {
    }

    @POST
    @Produces("application/json")
    @Path("/historico")
    public String getJson(Usuario user) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        ArrayList<Pelicula> lstPeliculas = usuarioDao.findPeliculasByUser(user);
        return Pelicula.toArrayJSon(lstPeliculas);
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public String login(Usuario user) {

        UsuarioDAO usuarioDao = new UsuarioDAO();
        //  user.setEmail("diego@gmail.com");
        //user.setPassword("1234");
        // ArrayList<Usuario> usuarios   = usuarioDao.findAll(user); 
        ArrayList<Usuario> usuarios = usuarioDao.findAll(user);
        return Usuario.toArrayJSon(usuarios);

    }

    /**
     * PUT method for updating or creating an instance of UserWs
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
