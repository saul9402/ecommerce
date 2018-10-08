package mx.com.lickodev.ecommercejee.cad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.lickodev.ecommercejee.javabeans.Marca;

/**
 *
 * @author Santa Cecilia
 */
public class MarcaCad {

    public static ArrayList<Marca> listarTodoDeMarcas() {
        try {
            String sql = "{call  sp_listartodoMarca()}";
            Connection connection = Conexion.conectar();
            CallableStatement callableStatement;
            callableStatement = connection.prepareCall(sql);
            //callableStatement.setInt(1, catSuperior);
            ResultSet resultSet = callableStatement.executeQuery();
            ArrayList<Marca> marcas = new ArrayList<>();
            while (resultSet.next()) {
                Marca marca = new Marca();
                marca.setCodigo(resultSet.getInt("codigo"));
                marca.setNombre(resultSet.getString("nombre"));
                marcas.add(marca);
            }
            return marcas;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaCad.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static int contarMarcas(int co) {
        try {
            String sql = "{call  sp_contarProductosMarca(?)}";
            Connection connection = Conexion.conectar();
            CallableStatement callableStatement;
            callableStatement = connection.prepareCall(sql);
            callableStatement.setInt(1, co);
            //callableStatement.setInt(1, catSuperior);
            ResultSet resultSet = callableStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaCad.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
