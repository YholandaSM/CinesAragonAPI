package DAO;

import interfaces.IDAO;
import java.util.ArrayList;
import model.Butaca;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Hp
 */
public class ButacaDAO implements IDAO<Butaca,Integer>{
    
    private final String SQL_ADD
            = "INSERT INTO `butaca` id_sala, fila, columna  VALUES ";

    private MotorSQL motorSql;

    public ButacaDAO() {

        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public int add(Butaca bean) {
          int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "('"
                    + bean.getSala().getIdSala() + "', "
                    + bean.getFila() +  "', "
                    + bean.getColumna()+"');";

            resp = motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Butaca insertada con exito.");
        }
        return resp;
       
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Butaca> findAll(Butaca bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Butaca bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
