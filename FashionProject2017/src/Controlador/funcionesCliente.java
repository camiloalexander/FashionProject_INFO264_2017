
package Controlador;

import Datos.clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class funcionesCliente {
    /*Fecha fecha = new Fecha();
    private conexion mysql = new conexion(); //instancia a la cadena de conexion
    private Connection cn = mysql.conectar();
    private String querySQL = "";//cadena de conexion
    public Integer totalregistros;*/
    /*
    public DefaultTableModel mostrar(String buscar){
        //clientes cl = new clientes();
        DefaultTableModel modelo; //
        //String [] columnas = {"ID", "RUN", "Nombre", "Telefono", "Ciudad", "Correo", "Estado", "Edad", "Fecha de ingreso"}; //titulos
        String [] columnas = {"ID", "RUN", "Nombre", "Telefono", "Ciudad", "Correo", "Estado", "Edad", "Fecha de ingreso"}; //titulos
        //String [] columnas = {"ID", "RUN", "Nombre", "Edad", "Ciudad", "Telefono", "Correo", "Fecha de ingreso"}; //titulos
        String [] registro = new String [9]; //se almacenan los registros
        totalregistros=0;
        modelo = new DefaultTableModel(null,columnas);
        modelo.isCellEditable(totalregistros, 9);
        querySQL="select * from cliente where "
                + "(nombre like '%?%' )"
                + "or (run like '%?%' )"
                + "or (edad like '%?%' )"
                + "or (ciudad like '%?%' )"
                + "or (telefono like '%?%' )"
                + "or (correo like '%?%' )"
                + "or (fecha_ingreso like '%?%' )"
                + "order by id_cliente";
        try{
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            PreparedStatement pst = cn.prepareStatement(querySQL);

            for(int i=1; i<=7;i++){
                pst.setString(i, buscar);
            }
            while(rs.next()){
                //if(rs.getString("estado").equals("0")){  //si esta dado de baja no se muestra 
                  //  rs.next();
                //}else{
                    registro[0] = rs.getString("id_cliente");
                    registro[1] = rs.getString("run");
                    registro[2] = rs.getString("nombre");
                    registro[3] = rs.getString("telefono");
                    registro[4] = rs.getString("ciudad");
                    registro[5] = rs.getString("correo");
                    registro[6] = rs.getString("estado");
                    registro[7] = rs.getString("edad"); 
                    registro[8] = rs.getString("fecha_ingreso");
                    totalregistros=totalregistros+1;
                    modelo.addRow(registro);
                //}
            }
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
   }*/
    /*
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo; //
        //String [] columnas = {"ID", "RUN", "Nombre", "Telefono", "Ciudad", "Correo", "Estado", "Edad", "Fecha de ingreso"}; //titulos
        String [] columnas = {"ID", "RUN", "Nombre", "Telefono", "Ciudad", "Correo", "Estado", "Edad", "Fecha de ingreso"}; //titulos
        //String [] columnas = {"ID", "RUN", "Nombre", "Edad", "Ciudad", "Telefono", "Correo", "Fecha de ingreso"}; //titulos
        String [] registro = new String [9]; //se almacenan los registros
        totalregistros=0;
        modelo = new DefaultTableModel(null,columnas);
        modelo.isCellEditable(totalregistros, 9);
        querySQL="select * from cliente where "
                + "(cliente.nombre like '%"+buscar+"%' )"
                + "or (cliente.run like '%"+buscar+"%' )"
                + "or (cliente.edad like '%"+buscar+"%' )"
                + "or (cliente.ciudad like '%"+buscar+"%' )"
                + "or (cliente.telefono like '%"+buscar+"%' )"
                + "or (cliente.correo like '%"+buscar+"%' )"
                + "or (cliente.fecha_ingreso like '%"+buscar+"%' )"
                + "order by cliente.id_cliente";
        try{
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                //if(rs.getString("estado").equals("0")){  //si esta dado de baja no se muestra 
                  //  rs.next();
                //}else{
                    registro[0] = rs.getString("id_cliente");
                    registro[1] = rs.getString("run");
                    registro[2] = rs.getString("nombre");
                    registro[3] = rs.getString("telefono");
                    registro[4] = rs.getString("ciudad");
                    registro[5] = rs.getString("correo");
                    registro[6] = rs.getString("estado");
                    registro[7] = rs.getString("edad"); 
                    registro[8] = rs.getString("fecha_ingreso");
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
    
    public boolean ingresar(clientes cl){
        querySQL = "insert into cliente(run,nombre,telefono,ciudad,correo,estado,edad,fecha_ingreso) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setString(1, cl.getRun());   //ver mas tarde el tema del rut
            pst.setString(2, cl.getNombre());
            pst.setString(3, cl.getTelefono());
            pst.setString(4, cl.getCiudad());
            pst.setString(5, cl.getCorreo());
            pst.setString(6, "1");
            pst.setInt(7, cl.getEdad());
            pst.setString(8, fecha.obtenerFecha());
            cl.setFecha_ingreso(fecha.obtenerFecha());
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
    
    public boolean modificar(clientes cl){
        //querySQL = "update cliente set run=?,nombre=?,telefono=?,ciudad=?,correo=?,estado=?,edad=?,fecha_ingreso=? where id_cliente=?";
        querySQL = "update cliente set cliente.run=?,cliente.nombre=?,cliente.telefono=?,cliente.ciudad=?,cliente.correo=?,cliente.edad=? where cliente.id_cliente=?";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setString(1, cl.getRun());
            pst.setString(2, cl.getNombre());
            pst.setString(3, cl.getTelefono());
            pst.setString(4, cl.getCiudad());
            pst.setString(5, cl.getCorreo());
            //pst.setInt(6, cl.getEstado());
            pst.setInt(6, cl.getEdad());
            //pst.setString(8, cl.getFecha_ingreso());
            pst.setInt(7, cl.getId_cliente());
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
    
    public boolean eliminar(clientes cl){
        //querySQL = "delete from cliente where id_cliente = ?";
        querySQL = "update cliente set cliente.estado = 0 where cliente.id_cliente = ? ";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setInt(1, cl.getId_cliente());
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
    public String nombreCliente(String id_cliente){
        String nombre="";
        querySQL = "select cliente.nombre from cliente where cliente.id_cliente = "+id_cliente+"";
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
    public boolean verificarClienteRun(String run){
        boolean esta = false;
        boolean sigue = true;
        String r = "";
        querySQL = "select * from cliente where cliente.run="+run+"";
        try {
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            if(rs.first()){//recorre el resultset al siguiente registro si es que existen
                rs.beforeFirst();//regresa el puntero al primer registro
                while(rs.next() && sigue){ //rs.next da falso algunas veces por eso el if de arriba
                    System.out.println("hay coincidencias de rut");
                    r=rs.getString("run");
                    if(r.equals(run)){    
                        esta = true;
                        sigue = false;
                    }    
                }
            }else{
                System.out.println("sin coincidencias de clientes con ese rut");
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
    public int estadoCliente(String run){
        boolean sigue = true;
        int estado=2;
        querySQL = "select * from cliente where cliente.run="+run+"";
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
    public boolean modificarEstadodeEliminado(clientes cl){
        querySQL = "update cliente set cliente.estado=1 where cliente.id_cliente=?";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setInt(1, cl.getId_cliente());
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
    public int obtenerIDClienteRun(String run){
        int id=0;
        boolean sigue = true;
        querySQL = "select * from cliente where cliente.run="+run+"";
        try {
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            if(rs.first()){//recorre el resultset al siguiente registro si es que existen
                rs.beforeFirst();//regresa el puntero al primer registro
                while(rs.next() && sigue){ //rs.next da falso algunas veces por eso el if de arriba
                    if((rs.getString("run")).equals(run) && rs.getInt("estado")==0){    
                        id = rs.getInt("id_cliente");
                        sigue = false;
                    }    
                }
            }else{
                System.out.println("sin coincidencias de clientes con ese rut");
            }
            rs.close();                    
            st.close(); 
            return id;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return id;
        }
    }*/
}
