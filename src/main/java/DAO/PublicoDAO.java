package DAO;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Publico;
import utils.ConnectionFactory;
import utils.MotorSQL;
 

/**
 *
 * @author Hp
 */
public class PublicoDAO implements IDAO<Publico, Integer>{
    
     private final String SQL_FINDALL
            = "SELECT * FROM `publico` WHERE 1=1 ";

    private MotorSQL motorSql;

    public PublicoDAO() {

        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public int add(Publico bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Publico> findAll(Publico bean) {
       ArrayList<Publico> listPublico = new ArrayList<>();
        String sql = SQL_FINDALL;

        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getIdPublico() != 0) {
                    sql += "AND ID_PUBLICO='" + bean.getIdPublico() + "'";
                }
                if (bean.getNombre() != null) {
                    sql += "AND GENERO='" + bean.getNombre() + "'";
                }

            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Publico publico = new Publico();

                publico.setIdPublico(rs.getInt(1));
                publico.setNombre(rs.getString(2));

                listPublico.add(publico);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return listPublico;
    }

    @Override
    public int update(Publico bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
