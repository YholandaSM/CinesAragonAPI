/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pelicula;
import model.Sesion;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Hp
 */
public class SesionDAO implements IDAO<Sesion, Integer>{

    private MotorSQL motorSql;
    public SesionDAO() {
        motorSql = ConnectionFactory.selectDb();
    }
    @Override
    public int add(Sesion bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Sesion> findAll(Sesion bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Sesion bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private final String SQL_FIND_CINE
            = "SELECT p.*"
            + " FROM pelicula  p,sesion s,sala sa,cine c"
            + " WHERE p.id_pelicula=s.id_pelicula"
            + " AND   s.id_sala=sa.num_sala"
            + " AND   c.id_cine=sa.id_cine"
            + " AND   c.id_cine=";
    //        
    /**
     * Lista de películas por el cine el el que se proyectan. Si hay parámetros,
     * también filtra por género y publico(Requerimientos punto 2)
     * 
     *          SELECT * 
     *          FROM `pelicula  p,sesion s,sala sa,cine c
     *          WHERE p.id_pelicula=s.id_pelicula 
     *          AND   s.id_sala=sa.num_sala 
     *          AND   c.id_cine=sa.id_cine 
     *          AND   c.id_cine= 
     * 
     * @param bean
     * @param cine
     * @return 
     */
    public ArrayList<Pelicula> findPeliculasByCine(Sesion bean) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql = "";
        try {
            //1º) 
            motorSql.connect();

            sql= SQL_FIND_CINE + bean.getSala().getCine().getId();

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setId(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setPrecio(rs.getDouble(3));
                pelicula.setDuracion(rs.getInt(4));
                pelicula.setTrailer(rs.getString(5));
                pelicula.setSinopsis(rs.getString(6));
                pelicula.setnVotos(rs.getInt(7));
                pelicula.setsPuntuacion(rs.getInt(8));
                pelicula.setFechaEstreno(rs.getString(9));
                pelicula.setUrl(rs.getString(10));
                pelicula.setId_genero(rs.getInt(11));

                peliculas.add(pelicula);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;

    }
}
