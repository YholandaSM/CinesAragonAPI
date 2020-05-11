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
import model.Sesion;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Hp
 */
public class CineDAO implements IDAO<Cine, Integer> {

    private final String SQL_FINDALL
            = "SELECT * FROM `cine` WHERE 1=1 ";

    private MotorSQL motorSql;

    public CineDAO() {

        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public int add(Cine bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Cine bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cine> findAll(Cine bean) {
        ArrayList<Cine> cines = new ArrayList<>();
        String sql = SQL_FINDALL;

        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getId() != 0) {
                    sql += "AND ID_CINE='" + bean.getId() + "'";
                }
                if (bean.getNombre()!= null) {
                    sql += "AND NOMBRE='" + bean.getNombre() + "'";
                }

                if (bean.getLoc() != null) {
                    sql += "AND LOCALIDAD='" + bean.getLoc() + "'";
                }
                
                
              
 
                //PUNTO 1 DEL REQUERIMIENTO
                //si parametro 10 peliculas más votadas
                //sql += "AND FOUND_ROWS()<11 ORDER BY PUNTUACION DESC" + "'";

            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Cine cine = new Cine();

                cine.setId(rs.getInt(1));
                cine.setNombre(rs.getString(2));
                cine.setLoc(rs.getString(3));
             

                cines.add(cine);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return cines;
    }
    
   
}
