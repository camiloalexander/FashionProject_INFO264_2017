package Datos;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Informes {
        private Conexion mysql; //instancia a la cadena de Conexion
        private Connection cn;
        private String querySQL = "";//cadena de Conexion
    
    
    public int dineroTrabajador(int id_t){
        int gan_tot = 0;
        querySQL = "select * from venta where id_trabajador = ?";
        mysql = new Conexion();
        cn = mysql.conectar();
        try{
            PreparedStatement st = cn.prepareStatement(querySQL);
            st.setInt(1, id_t);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                gan_tot = gan_tot + rs.getInt("monto_total");
            }
            rs.close();                    
            st.close(); 
            cn.close();
            return gan_tot;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return gan_tot;
        }
    }
    
    public int ingresoFecha(int m, int a){
        int in_tot = 0;
        querySQL = "select * from venta where fecha like '%-"+m+"-%' and fecha like '"+a+"-%'";
        mysql = new Conexion();
        cn = mysql.conectar();
        try{
            Statement st = cn.createStatement(); //variable de Conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                in_tot = in_tot + rs.getInt("monto_total");
            }
            rs.close();                    
            st.close(); 
            cn.close();
            return in_tot;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return in_tot;
        }
    }
    
    public int gastoFecha(int m, int a){
        int gas_tot = 0;
        querySQL = "select * from gastos where fecha_Gasto like '%-"+m+"-%' and fecha_Gasto like '"+a+"-%'";
        mysql = new Conexion();
        cn = mysql.conectar();
        try{
            Statement st = cn.createStatement(); //variable de Conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                gas_tot = gas_tot + rs.getInt("total_gasto");
            }
            rs.close();                    
            st.close(); 
            cn.close();
            return gas_tot;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return gas_tot;
        }
    }
    
    public int gastoAnual(int a){
        int gas_tot = 0;
        querySQL = "select * from gastos where fecha_Gasto like '"+a+"-%'";
        mysql = new Conexion();
        cn = mysql.conectar();
        try{
            Statement st = cn.createStatement(); //variable de Conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                gas_tot = gas_tot + rs.getInt("total_gasto");
            }
            rs.close();                    
            st.close(); 
            cn.close();
            return gas_tot;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return gas_tot;
        }
    }
    public int gananciaAnual(int a){
        int gan_tot = 0;
        querySQL = "select * from venta where fecha like '"+a+"-%'";
        mysql = new Conexion();
        cn = mysql.conectar();
        try{
            Statement st = cn.createStatement(); //variable de Conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                gan_tot = gan_tot + rs.getInt("monto_total");
            }
            rs.close();                    
            st.close(); 
            cn.close();
            return gan_tot;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return gan_tot;
        }
    }
}
