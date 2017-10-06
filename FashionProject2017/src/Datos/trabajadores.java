
package Datos;

import Controlador.Fecha;
import Controlador.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class trabajadores {
    private int id_trabajador;
    private String run;
    private String nombre;
    private String telefono;
    private String pass;
    private int privilegios;
    private int estado;
    private String fecha_ingreso;
    
    Fecha fecha = new Fecha();
    private conexion mysql = new conexion(); //instancia a la cadena de conexion
    private Connection cn = mysql.conectar();
    private String querySQL = "";//cadena de conexion
    public Integer totalregistros;
    
    public trabajadores() { }
    public trabajadores(int id_trabajador, String run, String nombre, String telefono, String pass, int privilegios, int estado, String fecha_ingreso) {
        this.id_trabajador = id_trabajador;
        this.run = run;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pass = pass;
        this.privilegios = privilegios;
        this.estado = estado;
        this.fecha_ingreso = fecha_ingreso;
    }
    public int getId_trabajador() {
        return id_trabajador;
    }
    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }
    public String getRun() {
        return run;
    }
    public void setRun(String run) {
        this.run = run;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public int getPrivilegios() {
        return privilegios;
    }
    public void setPrivilegios(int privilegios) {
        this.privilegios = privilegios;
    }
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public String getFecha_ingreso() {
        return fecha_ingreso;
    }
    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
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
    public String arreglaRUN(String run){
        run = run.trim();
        // Despejar Puntos
        String runformateado=run.replace(".","");
        // Despejar Guión
        //runformateado = runformateado.replace("-","");
        if(runformateado.indexOf("-")==-1){
            //hay que agregar un guion
            
        }
        return runformateado;
    }
    
    public boolean ValidaRUN(String run){
        boolean lDevuelve = false;
        int Ult= run.length();
        int Largo = run.length() -2;
        int Constante = 2;
        int Suma = 0;
        int Digito = 0;
        for (int i= Largo; i >=0; i--){
            Suma= Suma + Integer.parseInt(run.substring(i,i+1)) * Constante;
            Constante = Constante + 1 ;
            if (Constante == 8){
                 Constante =2; 
            }
        }
        String Ultimo = run.substring(Ult-1).toUpperCase();
        Digito =11-(Suma%11);
        if (Digito==10 && Ultimo.equals("K")){
            lDevuelve=true;
        }else{ 
            if(Digito == 11 && Ultimo.equals("0")){
                lDevuelve=true;    
            }else{    
                if (Digito == Integer.parseInt(Ultimo)){
                    lDevuelve=true;
                }
            }     
        }
        return lDevuelve;
    }
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo; //
        String [] columnas = {"ID", "RUN", "Nombre", "Telefono", "Contraseña", "Privilegios", "Estado", "Fecha de ingreso"}; //titulos
        String [] registro = new String [9]; //se almacenan los registros
        totalregistros=0;
        modelo = new DefaultTableModel(null,columnas);
        modelo.isCellEditable(totalregistros, 8);
        querySQL="select * from trabajador where "
                + "(trabajador.run like '%"+buscar+"%' )"
                + "or (trabajador.nombre like '%"+buscar+"%' )"
                + "or (trabajador.telefono like '%"+buscar+"%' )"
                + "or (trabajador.privilegios like '%"+buscar+"%' )"
                + "or (trabajador.estado like '%"+buscar+"%' )"
                + "or (trabajador.fecha_ingreso like '%"+buscar+"%' )"
                + "order by trabajador.id_trabajador";
        try{
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                //if(rs.getString("estado").equals("0")){  //si esta dado de baja no se muestra 
                  //  rs.next();
                //}else{
                    registro[0] = rs.getString("id_trabajador");
                    registro[1] = rs.getString("run");
                    registro[2] = rs.getString("nombre");
                    registro[3] = rs.getString("telefono");
                    registro[4] = rs.getString("pass");
                    registro[5] = rs.getString("privilegios");
                    registro[6] = rs.getString("estado");
                    registro[7] = rs.getString("fecha_ingreso");
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
    
    public boolean ingresar(trabajadores tr){
        querySQL = "insert into trabajador(run,nombre,telefono,pass,privilegios,estado,fecha_ingreso) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setString(1, tr.getRun());   //ver mas tarde el tema del rut
            pst.setString(2, tr.getNombre());
            pst.setString(3, tr.getTelefono());
            pst.setString(4, tr.getPass());
            pst.setString(5, String.valueOf(tr.getPrivilegios()));
            pst.setString(6, "1");
            pst.setString(7, fecha.obtenerFecha());
            tr.setFecha_ingreso(fecha.obtenerFecha());
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
    
    public boolean modificar(trabajadores tr){
        querySQL = "update trabajador set trabajador.run=?,trabajador.nombre=?,trabajador.telefono=?,trabajador.pass=?,trabajador.privilegios=? where trabajador.id_trabajador=?";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setString(1, tr.getRun());
            pst.setString(2, tr.getNombre());
            pst.setString(3, tr.getTelefono());
            pst.setString(4, tr.getPass());
            pst.setString(5, String.valueOf(tr.getPrivilegios()));
            //pst.setInt(6, cl.getEstado());
            //pst.setInt(6, tr.getEdad());
            //pst.setString(8, cl.getFecha_ingreso());
            pst.setInt(6, tr.getId_trabajador());
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
    
    public boolean eliminar(trabajadores tr){
        //querySQL = "delete from cliente where id_cliente = ?";
        querySQL = "update trabajador set trabajador.estado = 0 where trabajador.id_trabajador = ? ";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setInt(1, tr.getId_trabajador());
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
    public String nombreTrabajador(String id_trabajador){
        String nombre="";
        querySQL = "select trabajador.nombre from trabajador where trabajador.id_trabajador = "+id_trabajador+"";
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
    public boolean verificarTrabajadorRun(String run){
        boolean esta = false;
        boolean sigue = true;
        String r = "";
        querySQL = "select * from trabajador where trabajador.run="+run+"";
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
                System.out.println("sin coincidencia de trabajador con ese rut");
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
    public int estadoTrabajador(String run){
        boolean sigue = true;
        int estado=2;
        querySQL = "select * from trabajador where trabajador.run="+run+"";
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
    public boolean modificarEstadodeEliminado(trabajadores tr){
        querySQL = "update trabajador set trabajador.estado=1 where trabajador.id_trabajador=?";
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setInt(1, tr.getId_trabajador());
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
    public int obtenerIDTrabajadorRun(String run){
        int id=0;
        boolean sigue = true;
        querySQL = "select * from trabajador where trabajador.run="+run+"";
        try {
            Statement st = cn.createStatement(); //variable de conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            if(rs.first()){//recorre el resultset al siguiente registro si es que existen
                rs.beforeFirst();//regresa el puntero al primer registro
                while(rs.next() && sigue){ //rs.next da falso algunas veces por eso el if de arriba
                    if((rs.getString("run")).equals(run) && rs.getInt("estado")==0){    
                        id = rs.getInt("id_trabajador");
                        sigue = false;
                    }    
                }
            }else{
                System.out.println("sin coincidencias de trabajador con ese rut");
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
