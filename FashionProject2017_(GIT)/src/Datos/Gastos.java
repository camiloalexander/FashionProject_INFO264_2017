package Datos;

import Controlador.Conexion;
import Controlador.Fecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Gastos {
    private int id_gastosmes;
    private int luz;
    private int agua;
    private int arriendo;
    private int internet;
    private int otros;
    private String fechaGasto;
    private int total_gasto;
    
    Fecha fecha = new Fecha();
    private Conexion mysql; //instancia a la cadena de Conexion
    private Connection cn;
    private String querySQL = "";//cadena de Conexion
    public Integer total;
    
    public Gastos() {
    }

    public Gastos(int id_gastosmes, int luz, int agua, int arriendo, int internet, int otros, String fechaGasto, int total_gasto) {
        this.id_gastosmes = id_gastosmes;
        this.luz = luz;
        this.agua = agua;
        this.arriendo = arriendo;
        this.internet = internet;
        this.otros = otros;
        this.fechaGasto = fechaGasto;
        this.total_gasto = total_gasto;
    }

    public int getTotal_gasto() {
        return total_gasto;
    }

    public void setTotal_gasto(int total_gasto) {
        this.total_gasto = total_gasto;
    }

    public String getFecha_Gasto() {
        return fechaGasto;
    }

    public void setFecha_Gasto(String fechaGasto) {
        this.fechaGasto = fechaGasto;
    }

    public int getId_Gastosmes() {
        return id_gastosmes;
    }

    public void setId_Gastosmes(int id_gastomes) {
        this.id_gastosmes = id_gastomes;
    }

    public int getLuz() {
        return luz;
    }

    public void setLuz(int luz) {
        this.luz = luz;
    }

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public int getArriendo() {
        return arriendo;
    }

    public void setArriendo(int arriendo) {
        this.arriendo = arriendo;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getOtros() {
        return otros;
    }

    public void setOtros(int otros) {
        this.otros = otros;
    }
        
    public DefaultTableModel mostrar(int mes, int año) {
        mysql = new Conexion();
        cn = mysql.conectar();
        DefaultTableModel modelo; 
        String [] columnas = {"ID", "Luz", "Agua", "Arriendo", "Internet", "Otros", "Fecha Ingreso", "Total Gasto"}; //titulos
        
        total=0;
        modelo = new DefaultTableModel(null,columnas);
        modelo.isCellEditable(total, 8);
        ArrayList<Gastos> list = new ArrayList<Gastos>();
        Gastos gto;
        if(mes!=0 && año!=0){
            querySQL="select * from gastos where "
                + "(gastos.fecha_Gasto like '%-"+mes+"-%' )"
                + "and (gastos.fecha_Gasto like '%"+año+"%' )"
                + "order by gastos.id_gastosmes";
        }else if (año!=0){
            querySQL="select * from gastos where "
                +"(gastos.fecha_Gasto like '%"+año+"%' )"
                + "order by gastos.id_gastosmes";
        }else if (mes!=0){
            querySQL="select * from gastos where "
                + "(gastos.fecha_Gasto like '%-"+mes+"-%' )"
                + "order by gastos.id_gastosmes";
        }else{
            querySQL="select * from gastos where "
                + "(gastos.id_gastosmes = 0 )"
                + "order by gastos.id_gastosmes";
        }

        try{
            Statement st = cn.createStatement(); //variable de Conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                    gto = new Gastos();
                    gto.setId_Gastosmes(rs.getInt("id_gastosmes"));
                    gto.setLuz(rs.getInt("luz"));
                    gto.setAgua(rs.getInt("agua"));
                    gto.setArriendo(rs.getInt("arriendo"));
                    gto.setInternet(rs.getInt("internet"));
                    gto.setOtros(rs.getInt("otros"));
                    gto.setFecha_Gasto(rs.getString("fecha_Gasto"));
                    total = total + gto.getLuz() + gto.getAgua() + gto.getArriendo() + gto.getInternet() + gto.getOtros(); 
                    gto.setTotal_gasto(gto.getLuz() + gto.getAgua() + gto.getArriendo() + gto.getInternet() + gto.getOtros());
                    list.add(gto);
                          
            }
            rs.close();                    
            st.close(); 
            cn.close();
            if(list.size() > 0){
                for(int i=0; i< list.size(); i++){
                    Object fila[] = new Object[8];
                    gto = list.get(i);
                    fila[0] = gto.getId_Gastosmes();
                    fila[1] = gto.getLuz();
                    fila[2] = gto.getAgua();
                    fila[3] = gto.getArriendo();
                    fila[4] = gto.getInternet();
                    fila[5] = gto.getOtros();
                    fila[6] = gto.getFecha_Gasto();
                    fila[7] = gto.getTotal_gasto();
                    
                    modelo.addRow(fila);
                }
            }
            
            return modelo;
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
       
        public boolean modificar(Gastos gto){
        querySQL = "update gastos set luz=?, agua=?, arriendo=?, internet=?, otros=?, total_gasto=? where id_gastosmes=?";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setInt(1, gto.getLuz());
            pst.setInt(2, gto.getAgua());
            pst.setInt(3, gto.getArriendo());
            pst.setInt(4, gto.getInternet());
            pst.setInt(5, gto.getOtros());
            pst.setInt(6, gto.getLuz()+gto.getAgua()+gto.getArriendo()+gto.getInternet()+gto.getOtros());
            pst.setInt(7, gto.getId_Gastosmes());
            System.out.println(gto.getLuz()+" "+gto.getAgua()+" "+gto.getArriendo()+" "+gto.getInternet()+" "+gto.getOtros()+" "+gto.getTotal_gasto()+" "+gto.getId_Gastosmes());
            int n = pst.executeUpdate();             
            pst.close();
            cn.close();
            if(n!=0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return false;
        }
    }
    
    public boolean ingresar(Gastos gto){
        querySQL = "insert into gastos(luz,agua,arriendo,internet,otros,fecha_gasto,total_gasto) values(?,?,?,?,?,?,?)";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setInt(1, gto.getLuz());
            pst.setInt(2, gto.getAgua());
            pst.setInt(3, gto.getArriendo());
            pst.setInt(4, gto.getInternet());
            pst.setInt(5, gto.getOtros());
            pst.setString(6, fecha.obtenerFecha());
            gto.setFecha_Gasto(fecha.obtenerFecha());
            gto.setTotal_gasto(gto.getLuz() + gto.getAgua() + gto.getArriendo() + gto.getInternet() + gto.getOtros());
            pst.setInt(7, gto.getTotal_gasto());
            int n = pst.executeUpdate();
            pst.close(); 
            cn.close();
            if(n!=0){
                return true;
            }else{
                return false;
            } 
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return false;
        }
    }  
}
