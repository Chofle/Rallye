/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rallye;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    static Connection conexion = null;
    public static void conectarBD(String db_host,String db_name,
            String db_user, String db_password) {        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://"+db_host+"/"+db_name, 
                       db_user, db_password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DialogListCategorias.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this, "No se ha encontrado la librería MySQL", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (InstantiationException ex) {
            Logger.getLogger(DialogListCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DialogListCategorias.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this, "No se ha podido conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (SQLException ex) {            
            Logger.getLogger(DialogListCategorias.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(this, "No se ha podido conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
