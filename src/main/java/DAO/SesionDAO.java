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
import model.Cine;
import model.Pelicula;
import model.Sala;
import model.Sesion;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Hp
 */
public class SesionDAO implements IDAO<Sesion, Integer> {

    private final String SQL_FINDBYPELICULACINE
            = "select s.* "
            + "from sesion s, pelicula p, sala sa, cine c "
            + "where s.id_pelicula=p.id_pelicula "
            + "and s.id_sala=sa.num_sala "
            + "and c.id_cine=sa.id_cine ";

    /*  private final String SQL_FIND_CINE
            = "SELECT p.*"
            + " FROM pelicula  p,sesion s,sala sa,cine c"
            + " WHERE p.id_pelicula=s.id_pelicula"
            + " AND   s.id_sala=sa.num_sala"
            + " AND   c.id_cine=sa.id_cine";*/
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

    /**
     * select s.* from sesion s, pelicula p, sala sa, cine c where
     * s.id_pelicula=p.id_pelicula and s.id_sala=sa.num_sala and
     * c.id_cine=sa.id_cine and p.id_pelicula=3 and c.id_cine=1;
     *
     * @param pelicula
     * @param cine
     * @return
     */
    public ArrayList<Sesion> findSesionByPeliculaCine(Pelicula pelicula,
            Cine cine) {
        ArrayList<Sesion> sesiones = new ArrayList<>();

        try {

            String sql = SQL_FINDBYPELICULACINE;

            //1º)
            motorSql.connect();
            if (pelicula != null) {
                if (pelicula.getId() != 0) {
                    sql += "AND ID_PELICULA='" + pelicula.getId() + "'";
                }

            }
            if (cine != null) {
                if (cine.getId() != 0) {
                    sql += "AND ID_CINE='" + cine.getId() + "'";
                }

            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Sesion sesion = new Sesion();

                sesion.setIdSesion(rs.getInt(1));
                sesion.setSala(new Sala(rs.getInt(2)));
                sesion.setPelicula(new Pelicula(rs.getInt(3)));
                sesion.setHora(rs.getString(4));
                sesion.setFecha(rs.getString(5));

                sesiones.add(sesion);

            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return sesiones;

    }

//        
    /**
     * borra!!!!!!! Lista de películas por el cine el el que se proyectan. Si
     * hay parámetros, también filtra por género y publico(Requerimientos punto
     * 2)
     *
     * SELECT * FROM `pelicula p,sesion s,sala sa,cine c WHERE
     * p.id_pelicula=s.id_pelicula AND s.id_sala=sa.num_sala AND
     * c.id_cine=sa.id_cine AND p.id_genero= AND p.id_publico= AND c.id_cine=
     *
     * @param bean
     * @param cine
     * @return
     */
    /*  public ArrayList<Pelicula> findPeliculasByParametros(Sesion bean, int idGenero, int idPublico) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql = SQL_FIND_CINE;
        try {
            //1º) 
            motorSql.connect();

            if (bean != null) {
                sql += "c.id_cine='" + bean.getSala().getCine().getId() + "'";
            }

            if (idGenero != 0) {
                sql += " p.id_genero='" + idGenero + "'";
            }

            if (idPublico != 0) {
                sql += " p.id_publico='" + idGenero + "'";
            }

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

    }*/
}
