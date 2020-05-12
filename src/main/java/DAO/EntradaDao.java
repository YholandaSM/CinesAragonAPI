package DAO;

import interfaces.IDAO;
import java.util.ArrayList;
import model.Entrada;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Hp
 */
public class EntradaDao implements IDAO<Entrada,Integer>{
    
      private final String SQL_ADD
            = "INSERT INTO `entrada` (id_sesion, id_compra,id_butaca,importe ) VALUES ";

    private MotorSQL motorSql;

    public EntradaDao() {

        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public int add(Entrada bean) {
        int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "("
                    + bean.getSesion().getIdSesion() + ", "
                    + bean.getCompra().getIdCompra() + ", "
                    + bean.getButaca().getIdButaca() + ", " 
                    + bean.getImporte()+ ");";
                    

            resp = motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Entrada insertada con exito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Entrada> findAll(Entrada bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Entrada bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
