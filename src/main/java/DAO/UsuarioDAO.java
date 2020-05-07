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

public class UsuarioDAO
        implements IDAO<Usuario, Integer> {

    private final String SQL_FINDALL
            = "SELECT * FROM `usuario` WHERE 1=1 ";
    private final String SQL_HISTORICO=
            " select p.* " +
            "from pelicula p, sesion s,entrada e,compra c, usuario " +
            "where p.id_pelicula=s.id_pelicula " +
            "and s.id_sesion=e.id_sesion " +
            "and e.id_compra=c.id_compra " +
            "and u.id_usuario=c.id_usuario " +
            "and u.id_usuario=;";

    private MotorSQL motorSql;

    public UsuarioDAO() {
        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public int add(Usuario bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> findAll(Usuario bean) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getIdUsuario() != 0) {
                    sql += " AND ID_Usuario='" + bean.getIdUsuario() + "'";
                }
                if (bean.getNombre() != null) {
                    sql += " AND Nombre='" + bean.getNombre() + "'";
                }

                if (bean.getApellido() != null) {
                    sql += " AND Apellido ='" + bean.getApellido() + "'";
                }
                if (bean.getEmail() != null) {
                    sql += "AND Email='" + bean.getEmail() + "'";
                }
                if (bean.getPassword() != null) {
                    sql += " AND Password ='" + bean.getPassword() + "'";
                }
                if (bean.getFechaRegistro() != null) {
                    sql += " AND Fecha_registro ='" + bean.
                            getFechaRegistro() + "'";
                }

            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                usuario.setEmail(rs.getString(4));
                usuario.setPassword(rs.getString(5));
                usuario.setFechaRegistro(rs.getString(6));

                usuarios.add(usuario);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return usuarios;
    }

    @Override
    public int update(Usuario bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * Histórico de películas de un usuario.(REQUERIMIENTO PUNTO 7)
     *      select *
     *      from pelicula p, sesion s,entrada e,compra c, usuario u
     *      where p.id_pelicula=s.id_pelicula
     *      and s.id_sesion=e.id_sesion
     *      and e.id_compra=c.id_compra
     *      and u.id_usuario=c.id_usuario
     *      and u.id_usuario=;
     * @param bean
     * @return 
     */
    public ArrayList<Pelicula> findPeliculasByCine(Usuario bean) {
       ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql = "";
        try {
            //1º) 
            motorSql.connect();

            sql= SQL_HISTORICO + bean.getIdUsuario();

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
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        //Findall - filtra segun campos que no son null o 0
        Usuario usuario = new Usuario();
        usuario.setEmail("prueba@gmail.com");
        usuario.setPassword("12345");
        ArrayList<Usuario> lstUsuarios
                = usuarioDAO.findAll(usuario);
        System.out.println(lstUsuarios.toString());
    }

}
