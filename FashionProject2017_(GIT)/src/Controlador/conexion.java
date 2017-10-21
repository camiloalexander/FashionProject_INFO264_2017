
package Controlador;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {
    private static String db="bd_peluqueria";
    private static String user="root";
    private static String pass="";
    private static String host="localhost";
    private static String server="jdbc:mysql://"+host+"/"+db;
    
    public conexion(){
        
    }
    public Connection conectar(){
        Connection link = null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            link=(Connection) DriverManager.getConnection(this.server,this.user,this.pass);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showConfirmDialog(null,e);
        }
        return link;
    }
}
