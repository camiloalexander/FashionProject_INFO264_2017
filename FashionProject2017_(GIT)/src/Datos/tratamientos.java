package Datos;

import Controlador.Fecha;
import Controlador.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class tratamientos {
    private int id_tratamiento;
    private String tipo;
    private int precio;
    private int estado;
    
    Fecha fecha = new Fecha();
    private conexion mysql = new conexion(); //instancia a la cadena de conexion
    private Connection cn = mysql.conectar();
    private String querySQL = "";//cadena de conexion
    public Integer totalregistros;
    
    public tratamientos() {
    }

    public tratamientos(int id_tratamiento, String tipo, int precio,int estado) {
        this.id_tratamiento = id_tratamiento;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
    }

    public int getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(int id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
       
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo; 
        String [] columnas = {"ID", "Tipo", "Precio", "Estado"}; 
        String [] registro = new String [4]; 
        totalregistros=0;
        modelo = new DefaultTableModel(null,columnas);
        modelo.isCellEditable(totalregistros, 4);
        querySQL="select * from tratamiento where "
                + "(tratamiento.tipo like '%"+buscar+"%' )"
                + "or (tratamiento.precio like '%"+buscar+"%' )"
                + "order by tratamiento.id_tratamiento";
        try{
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                //if(rs.getString("estado").equals("0")){  //si esta dado de baja no se muestra 
                  //  rs.next();
                //}else{
                    registro[0] = rs.getString("id_tratamiento");
                    registro[1] = rs.getString("tipo");
                    registro[2] = rs.getString("precio");
                    registro[3] = rs.getString("estado");
                    totalregistros=totalregistros+1;
                    modelo.addRow(registro);
                //}
            }
            rs.close();                    
            st.close(); 
            return modelo;

        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
   }
    
    public boolean ingresar(tratamientos tra){
        querySQL = "insert into tratamiento(tipo,precio,estado) values(?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setString(1, tra.getTipo());   
            pst.setInt(2, tra.getPrecio());
            pst.setInt(3, 1);
            int n = pst.executeUpdate();
            pst.close();                    
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
    
    
    public boolean modificar(tratamientos tra){
        //querySQL = "update cliente set run=?,tipo=?,telefono=?,ciudad=?,correo=?,estado=?,edad=?,fecha_ingreso=? where id_cliente=?";
        querySQL = "update tratamiento set tratamiento.tipo=?,tratamiento.precio=? where tratamiento.id_tratamiento=?";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setString(1, tra.getTipo());
            pst.setInt(2, tra.getPrecio());
            pst.setInt(3, tra.getId_tratamiento());
            int n = pst.executeUpdate();                   
            pst.close(); 
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
    
    public boolean eliminar(tratamientos tra){
        querySQL = "update tratamiento set tratamiento.estado = 0 where tratamiento.id_tratamiento = ? ";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setInt(1, tra.getId_tratamiento());
            int n = pst.executeUpdate();                   
            pst.close(); 
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
    public String tipoTratamiento(String id_tratamiento){
        String tipo="";
        querySQL = "select tratamiento.tipo from tratamiento where tratamiento.id_tratamiento = "+id_tratamiento+"";
        try {
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                tipo = rs.getString("tipo");
                break;
            }
            rs.close();                    
            st.close(); 
            return tipo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return tipo;
        }
    }
     public boolean verificarTratamientoNombre(String tipo){
        boolean esta = false;
        boolean sigue = true;
        String r = "";
        System.out.println("01");
        querySQL = "select * from tratamiento where tratamiento.tipo="+tipo+"";
        System.out.println("02");
        try {
            System.out.println("03");
            Statement st = cn.createStatement(); //variable de conexion a la bd
            System.out.println("04");
            ResultSet rs = st.executeQuery(querySQL); ////////
            System.out.println("11");
            if(rs.first()){//recorre el resultset al siguiente registro si es que existen
                System.out.println("22");
                rs.beforeFirst();//regresa el puntero al primer registro
                while(rs.next() && sigue){ //rs.next da falso algunas veces por eso el if de arriba
                    System.out.println("hay coincidencias de tipo");
                    r=rs.getString("tipo");
                    if(r.equals(tipo)){    
                        esta = true;
                        sigue = false;
                    }    
                }
            }else{
                System.out.println("sin coincidencias de tratamiento con ese tipo");
                esta = false;
            }
            rs.close();                    
            st.close(); 
            return esta;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return esta;
        }
    }
    public int estadoTratamiento(String tipo){
        boolean sigue = true;
        int estado=2;
        querySQL = "select * from tratamiento where tratamiento.tipo="+tipo+"";
        try {
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next() && sigue){
                estado=rs.getInt("estado");  
                if(estado == 0 || estado == 1){
                    sigue=false;
                }
            }
            rs.close();                    
            st.close(); 
            return estado;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return estado;
        }
    }
    
    public boolean modificarEstadodeEliminado(tratamientos tra){
        querySQL = "update tratamiento set tratamiento.estado=1 where tratamiento.id_tratamiento=?";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setInt(1, tra.getId_tratamiento());
            int n = pst.executeUpdate();                   
            pst.close(); 
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
    public int obtenerIDTratamientoNombre(String tipo){
        int id=0;
        boolean sigue = true;
        querySQL = "select * from tratamiento where tratamiento.tipo="+tipo+"";
        try {
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            if(rs.first()){//recorre el resultset al siguiente registro si es que existen
                rs.beforeFirst();//regresa el puntero al primer registro
                while(rs.next() && sigue){ //rs.next da falso algunas veces por eso el if de arriba
                    if((rs.getString("tipo")).equals(tipo) && rs.getInt("estado")==0){    
                        id = rs.getInt("id_tratamiento");
                        sigue = false;
                    }    
                }
            }else{
                System.out.println("sin coincidencias de tratamiento con ese tipo");
            }
            rs.close();                    
            st.close(); 
            return id;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return id;
        }
    }
}
