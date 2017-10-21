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
    private String nombre;
    private int precio;
    private int estado;
    
    Fecha fecha = new Fecha();
    private conexion mysql = new conexion(); //instancia a la cadena de conexion
    private Connection cn = mysql.conectar();
    private String querySQL = "";//cadena de conexion
    public Integer totalregistros;
    
    public tratamientos() {
    }

    public tratamientos(int id_tratamiento, String nombre, int precio,int estado) {
        this.id_tratamiento = id_tratamiento;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
    }

    public int getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(int id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        String [] columnas = {"ID", "Nombre", "Precio", "Estado"}; 
        String [] registro = new String [4]; 
        totalregistros=0;
        modelo = new DefaultTableModel(null,columnas);
        modelo.isCellEditable(totalregistros, 9);
        querySQL="select * from tratamiento where "
                + "(tratamineto.nombre like '%"+buscar+"%' )"
                + "or (tratamiento.precio like '%"+buscar+"%' )"
                + "order by tratamiento.id_tratamiento";
        try{
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                //if(rs.getString("estado").equals("0")){  //si esta dado de baja no se muestra 
                  //  rs.next();
                //}else{
                    registro[0] = rs.getString("id_cliente");
                    registro[1] = rs.getString("nombre");
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
        querySQL = "insert into tratamiento(nombre,precio,estado) values(?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setString(1, tra.getNombre());   
            pst.setInt(2, tra.getPrecio());
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
        //querySQL = "update cliente set run=?,nombre=?,telefono=?,ciudad=?,correo=?,estado=?,edad=?,fecha_ingreso=? where id_cliente=?";
        querySQL = "update tratamiento set tratamiento.nombre=?,tratamiento.precio=? where tratamiento.id_tratamiento=?";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setString(1, tra.getNombre());
            pst.setInt(2, tra.getPrecio());
            pst.setInt(7, tra.getId_tratamiento());
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
    public String nombreTratamiento(String id_tratamiento){
        String nombre="";
        querySQL = "select tratamiento.nombre from tratamiento where tratamiento.id_tratamiento = "+id_tratamiento+"";
        try {
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                nombre = rs.getString("nombre");
                break;
            }
            rs.close();                    
            st.close(); 
            return nombre;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return nombre;
        }
    }
     public boolean verificarTratamientoNombre(String nombre){
        boolean esta = false;
        boolean sigue = true;
        String r = "";
        querySQL = "select * from cliente where cliente.run="+nombre+"";
        try {
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            if(rs.first()){//recorre el resultset al siguiente registro si es que existen
                rs.beforeFirst();//regresa el puntero al primer registro
                while(rs.next() && sigue){ //rs.next da falso algunas veces por eso el if de arriba
                    System.out.println("hay coincidencias de nombre");
                    r=rs.getString("nombre");
                    if(r.equals(nombre)){    
                        esta = true;
                        sigue = false;
                    }    
                }
            }else{
                System.out.println("sin coincidencias de tratamiento con ese nombre");
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
    public int estadoTratamiento(String nombre){
        boolean sigue = true;
        int estado=2;
        querySQL = "select * from tratamiento where tratamiento.nombre="+nombre+"";
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
    public int obtenerIDTratamientoNombre(String nombre){
        int id=0;
        boolean sigue = true;
        querySQL = "select * from tratamiento where tratamiento.nombre="+nombre+"";
        try {
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            if(rs.first()){//recorre el resultset al siguiente registro si es que existen
                rs.beforeFirst();//regresa el puntero al primer registro
                while(rs.next() && sigue){ //rs.next da falso algunas veces por eso el if de arriba
                    if((rs.getString("nombre")).equals(nombre) && rs.getInt("estado")==0){    
                        id = rs.getInt("id_tratamiento");
                        sigue = false;
                    }    
                }
            }else{
                System.out.println("sin coincidencias de tratamiento con ese nombre");
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
