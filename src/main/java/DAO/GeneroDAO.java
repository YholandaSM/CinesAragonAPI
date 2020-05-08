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
import model.Genero;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Hp
 */
public class GeneroDAO implements IDAO<Genero, Integer> {

    private final String SQL_FINDALL
            = "SELECT * FROM `genero` WHERE 1=1 ";

    private MotorSQL motorSql;

    public GeneroDAO() {

        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public int add(Genero bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Genero> findAll(Genero bean) {
        ArrayList<Genero> listGenero = new ArrayList<>();
        String sql = SQL_FINDALL;

        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getIdGenero() != 0) {
                    sql += "AND ID_GENERO='" + bean.getIdGenero() + "'";
                }
                if (bean.getGenero() != null) {
                    sql += "AND GENERO='" + bean.getGenero() + "'";
                }

            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Genero genero = new Genero();

                genero.setIdGenero(rs.getInt(1));
                genero.setGenero(rs.getString(2));

                listGenero.add(genero);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return listGenero;
    }

    @Override
    public int update(Genero bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

 
    
 
