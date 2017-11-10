
package Otras_Clases;

import Controlador.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class LlenarTabla {
    private Conexion mysql = new Conexion(); //instancia a la cadena de Conexion
    private Connection cn = mysql.conectar();
    
    public void llenar_tabla(int numCol,int columBoolean,DefaultTableModel modelo, JTable tabla){    
        try{
            String query="select nombre,run from trabajador where trabajador.estado=1";
            Statement st = cn.createStatement(); //variable de Conexion a la bd
            ResultSet rs = st.executeQuery(query);
            //cantidad de columnas=3 contando la columna checkbox
            Object[] filas = new Object[numCol];
            while(rs.next()){
//              filas[0]=rs.getString(1);
                for(int i=1;i<=numCol;i++){
                    /*La variable columBoolean indica
                 * el número de columna que tendrá los checkbox
                 * es decir la booleana
                 */
                    //si i es igual a la columna checkbox
                    if(i==columBoolean){
                        //por defecto saldrán sin seleccionar, es decir como FALSE
                        filas[columBoolean-1]=Boolean.FALSE;
                    }else{
                        //si no rellenará la tabla con los datos normalmente
                        filas[i-1]=rs.getObject(i-1);
                    }
                }
                //añade las filas
                modelo.addRow(filas);
            }
            tabla.updateUI();//actualiza
            st.close();
            rs.close();
        }catch(SQLException | HeadlessException e)
        {System.err.println(e);}
    }
}
