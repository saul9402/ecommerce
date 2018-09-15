package mx.com.lickodev.ecommercejee.cad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.lickodev.ecommercejee.javabeans.Categoria;

/**
 *
 * @author Santa Cecilia
 */
public class CategoriaCad {

    public static ArrayList<Categoria> listar() {
        String sql = "{call sp_listarCategoriaSuperior()}";
        Connection connection = Conexion.conectar();
        CallableStatement callableStatement;
        try {
            callableStatement = connection.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();
            ArrayList<Categoria> categorias = new ArrayList<>();
            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setCodigo(resultSet.getInt("codigo"));
                categoria.setNombre(resultSet.getString("nombre"));
                categorias.add(categoria);
            }
            return categorias;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaCad.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
