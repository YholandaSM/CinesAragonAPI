package DAO;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pelicula;
import model.Usuario;
import utils.ConnectionFactory;
import utils.MotorSQL;

public class PeliculaDAO
        implements IDAO<Pelicula, Integer> {

    private final String SQL_FINDALL
            = "SELECT * FROM `pelicula` WHERE 1=1 ";
    private final String SQL_ADD
            = "INSERT INTO `pelicula` (`Titulo`, `Precio`, `Duracion`, `Trailer`, `Sinopsis`, `N_Votos`, `S_Puntuacion`, `Fecha_Estreno`,`URL`) VALUES ";
    private final String SQL_DELETE = "DELETE FROM `pelicula` WHERE ID_Pelicula=";
    private final String SQL_UPDATE = "UPDATE `pelicula` SET ";
    private final String SQL_TOPTEN = "SELECT * FROM `pelicula` WHERE FOUND_ROWS()<11 "
            + " ORDER BY PUNTUACION DESC";
    
       private final String SQL_HISTORICO=
            " select p.* " +
            "from pelicula p, sesion s,entrada e,compra c, usuario u " +
            "where p.id_pelicula=s.id_pelicula " +
            "and s.id_sesion=e.id_sesion " +
            "and e.id_compra=c.id_compra " +
            "and u.id_usuario=c.id_usuario " +
            "and u.email=";

    private MotorSQL motorSql;

    public PeliculaDAO() {
        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public ArrayList<Pelicula> findAll(Pelicula bean) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getId() != 0) {
                    sql += "AND ID_PELICULA='" + bean.getId() + "'";
                }
                if (bean.getTitulo() != null) {
                    sql += "AND TITULO='" + bean.getTitulo() + "'";
                }

                if (bean.getDuracion() != 0) {
                    sql += "AND DURACION='" + bean.getDuracion() + "'";
                }
                if (bean.getTrailer() != null) {
                    sql += "AND TRAILER='" + bean.getTrailer() + "'";
                }
                if (bean.getSinopsis() != null) {
                    sql += "AND SINOPSIS LIKE('%" + bean.getSinopsis() + "%')";
                }
                if (bean.getnVotos() != 0) {
                    sql += "AND VOTOS='" + bean.getnVotos() + "'";
                }
                if (bean.getsPuntuacion() != 0) {
                    sql += "AND PUNTUACION='" + bean.getsPuntuacion() + "'";
                }
                if (bean.getFechaEstreno() != null) {
                    sql += "AND FECHA_ESTRENO='" + bean.getFechaEstreno() + "'";
                }
                if (bean.getUrl() != null) {
                    sql += "AND URL='" + bean.getUrl() + "'";
                }

                if (bean.getId_genero() != 0) {
                    sql += "AND ID_GENERO='" + bean.getUrl() + "'";
                }
                if (bean.getId_publico() != 0) {
                    sql += "AND ID_PUBLICO='" + bean.getUrl() + "'";
                }

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
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }

    @Override
    public int add(Pelicula bean) {
        int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "('"
                    + bean.getTitulo() + "', "
                    + bean.getPrecio() + ", "
                    + bean.getDuracion() + ", '"
                    + bean.getTrailer() + "', '"
                    + bean.getSinopsis() + "', '"
                    + bean.getnVotos() + ", "
                    + bean.getsPuntuacion() + ", '"
                    + bean.getFechaEstreno() + "', '"
                    + bean.getUrl() + "');";

//                    + bean.getsPuntuacion() + "',"
//                    + "CURRENT_DATE)";
            resp = motorSql.execute(sql);
            /* RECUPERAR EL ID DEL ÚLTIMO OBJETO INSERTADO*/

 /*FIN*/
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Película insertada con exito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer id) {
        int resp = 0;
        motorSql.connect();
        try {
            String sql = SQL_DELETE + id;
            //desactivo la restriccion de claves foráneas para borrado
            motorSql.execute("SET FOREIGN_KEY_CHECKS=0;");
            resp = motorSql.execute(sql);
            //vuelvo a activar la restricción de claves foráneas
            motorSql.execute("SET FOREIGN_KEY_CHECKS=1;");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Borrado con exito.");
        } else {
            System.out.println("No se pudo borrar.");
        }
        return resp;
    }

    @Override
    public int update(Pelicula bean) {
        int resp = 0;
        String sql;
        try {
            motorSql.connect();

            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {

                sql = SQL_UPDATE;
                if (bean.getTitulo() != null) {
                    sql += "TITULO='" + bean.getTitulo() + "'";
                }

                if (bean.getPrecio() != null) {
                    sql += "PRECIO='" + bean.getPrecio() + "'";
                }

                if (bean.getDuracion() > 0) {
                    sql += "DURACION='" + bean.getDuracion() + "'";
                }

                if (bean.getTrailer() != null) {
                    sql += "TRAILER='" + bean.getTrailer() + "', ";
                }

                if (bean.getSinopsis() != null) {
                    sql += "SIPNOSIS='" + bean.getSinopsis() + "'";
                }

                if (bean.getnVotos() > 0) {
                    sql += "N_Votos='" + bean.getnVotos() + "'";
                }

                if (bean.getsPuntuacion() > 0) {
                    sql += "S_Puntuacion='" + bean.getsPuntuacion() + "'";
                }

                if (bean.getFechaEstreno() != null) {
                    sql += "Fecha_Estreno='" + bean.getFechaEstreno() + "'";
                }

                sql += " WHERE `ID_Pelicula`=" + bean.getId() + ";";
                System.out.println(sql);
                resp = motorSql.execute(sql);
            }

        } catch (Exception e) {

        } finally {
            motorSql.disconnect();
        }

        if (resp > 0) {
            System.out.println("Pelicula actualizada con éxito.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
        return resp;
    }

    /**
     * Método que recupera las 10 películas más votadas
     *
     * @return
     */
    public ArrayList<Pelicula> findTopTen() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql = SQL_TOPTEN;
        try {
            //1º) 
            motorSql.connect();

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
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }
    /**
     * Listado del histórico de películas de un usuario
     * @param bean
     * @return 
     */
    public ArrayList<Pelicula> findPeliculasByUser(Usuario bean) {
       ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql = "";
        try {
            //1º) 
            motorSql.connect();

            sql= SQL_HISTORICO +"'"+ bean.getEmail()+"'";
             

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


    public static void main(String[] args) {
        /*PRUEBAS UNITARIAS - TEST*/
        PeliculaDAO peliculaDAO = new PeliculaDAO();

        //Findall - filtra segun campos que no son null o 0
//        ArrayList lstPeliculas
//                = peliculaDAO.findAll(new Pelicula("Interstellar", null, null, null, 0, 500, 0, 0, null, null));
//        System.out.println(lstPeliculas.toString());
//
//        Pelicula peliprueba = new Pelicula("Joshua y los teleñecos", "www", "abc", "2015", 90, 5, 6, 9, 5.3, null);
//        //Add de registro
        // peliculaDAO.add(peliprueba);
//        //Update del registro con id pelicula 1
        //     peliculaDAO.update(new Pelicula("Titulo cambiado", null, null, null, 0, 0, 0, 1, null));
//        //Delete del registro 2
        //     peliculaDAO.delete(2);
    }

     
}
