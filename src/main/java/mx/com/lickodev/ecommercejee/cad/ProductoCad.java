package mx.com.lickodev.ecommercejee.cad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.lickodev.ecommercejee.javabeans.Producto;
import mx.com.lickodev.ecommercejee.javabeans.ProductoMoneda;

/**
 *
 * @author Santa Cecilia
 */
public class ProductoCad {

    public static boolean registrarProducto(Producto producto, ProductoMoneda cop, ProductoMoneda usd, ProductoMoneda pen) {
        try {
            String sql = "{call sp_registrarproducto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            Connection connection = Conexion.conectar();
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.setString(1, producto.getNombre());
            callableStatement.setFloat(2, producto.getPrecio());
            callableStatement.setFloat(3, producto.getPrecionuevo());
            callableStatement.setInt(4, producto.getStock());
            callableStatement.setBoolean(5, producto.isNuevo());
            callableStatement.setBoolean(6, producto.isRecomendado());
            callableStatement.setString(7, producto.getDescripcion());
            callableStatement.setBoolean(8, producto.isVisible());
            callableStatement.setInt(9, producto.getCodigo_marca());
            callableStatement.setInt(10, producto.getCodig_categoria());
            callableStatement.setString(11, producto.getImg());

            callableStatement.setString(12, cop.getMoneda());
            callableStatement.setFloat(13, cop.getPrecio());
            callableStatement.setFloat(14, cop.getPrecionuevo());

            callableStatement.setString(15, usd.getMoneda());
            callableStatement.setFloat(16, usd.getPrecio());
            callableStatement.setFloat(17, usd.getPrecionuevo());

            callableStatement.setString(18, pen.getMoneda());
            callableStatement.setFloat(19, pen.getPrecio());
            callableStatement.setFloat(20, pen.getPrecionuevo());
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaCad.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
