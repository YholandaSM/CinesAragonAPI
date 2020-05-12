package DAO;

import interfaces.IDAO;
import java.util.ArrayList;
import model.Compra;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author Hp
 */
public class CompraDao implements IDAO<Compra, Integer> {

    private final String SQL_ADD
            = "INSERT INTO `compra` (id_usuario, fecha_compra ) VALUES ";

    private MotorSQL motorSql;

    public CompraDao() {

        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public int add(Compra bean) {
        int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "("
                    + bean.getUsuario().getIdUsuario() + ", '"
                    + bean.getFechaCompra() + "');";

            resp = motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Compra insertada con exito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Compra> findAll(Compra bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Compra bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
