package Datos;

import Controlador.Fecha;
import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Trabajadores {
    private int id_trabajador;
    private String run;
    private String nombre;
    private String telefono;
    private String pass;
    private int privilegios;
    private int estado;
    private String fecha_ingreso;
    
    Fecha fecha = new Fecha();
    private Conexion mysql; //instancia a la cadena de Conexion
    private Connection cn;
    private String querySQL = "";//cadena de Conexion
    public Integer totalregistros;
    
    public Trabajadores() { }
    
    public Trabajadores(int id_trabajador, String run, String nombre, String telefono, String pass, int privilegios, int estado, String fecha_ingreso) {
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
    public String arreglaRUN(String run){
        run = run.trim();
        // Despejar Puntos
        String runformateado=run.replace(".","");
        // Despejar Guión
        //runformateado = runformateado.replace("-","");
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
        mysql = new Conexion();
        cn = mysql.conectar();
        String [] columnas = {"ID", "RUN", "Nombre", "Telefono", "Contraseña", "Privilegios", "Estado", "Fecha de ingreso"}; //titulos
        //String [] registro = new String [9]; //se almacenan los registros
        
        ArrayList<Trabajadores> list = new ArrayList<Trabajadores>();
        Trabajadores tr;
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,columnas);
        modelo.isCellEditable(totalregistros, 8);
        try{
            Statement st = cn.createStatement(); //variable de Conexion a la bd
            querySQL="select * from trabajador where trabajador.run like '%"+buscar+"%' "
                    + "or trabajador.nombre like '%"+buscar+"%' "
                    + "or trabajador.telefono like '%"+buscar+"%' "
                    + "or trabajador.fecha_ingreso like '%"+buscar+"%' "
                    + "order by trabajador.id_trabajador";
            ResultSet rs = st.executeQuery(querySQL);
            /*System.out.println("2");
            PreparedStatement st = cn.prepareStatement(querySQL);
            System.out.println("3");
            
            st.setString(1, buscar);
            System.out.println("4");
            st.setString(2, buscar);
            st.setString(3, buscar);
            st.setString(4, buscar);
            System.out.println("5");
            ResultSet rs = st.executeQuery();
            System.out.println("6");*/
            while(rs.next()){
                if(rs.getString("estado").equals("0")){  //si esta dado de baja no se muestra 
                    rs.next();
                }else{
                /*
                    registro[0] = rs.getString("id_trabajador");
                    registro[1] = rs.getString("run");
                    registro[2] = rs.getString("nombre");
                    registro[3] = rs.getString("telefono");
                    registro[4] = rs.getString("pass");
                    registro[5] = rs.getString("privilegios");
                    registro[6] = rs.getString("estado");
                    registro[7] = rs.getString("fecha_ingreso");
                    */
                    tr = new Trabajadores();
                    tr.setId_trabajador(rs.getInt("id_trabajador"));
                    tr.setRun(rs.getString("run"));
                    tr.setNombre(rs.getString("nombre"));
                    tr.setTelefono(rs.getString("telefono"));
                    tr.setPass(rs.getString("pass"));
                    tr.setPrivilegios(rs.getInt("privilegios"));
                    tr.setEstado(rs.getInt("estado"));
                    tr.setFecha_ingreso(rs.getString("fecha_ingreso"));
                    list.add(tr);
                    
                    totalregistros=totalregistros+1;
                    //modelo.addRow(registro);
                }
            }
            if(list.size() > 0){
                for(int i=0; i< list.size(); i++){
                    Object fila[] = new Object[8];
                    tr = list.get(i);
                    fila[0] = tr.getId_trabajador();
                    fila[1] = tr.getRun();
                    fila[2] = tr.getNombre();
                    fila[3] = tr.getTelefono();
                    fila[4] = tr.getPass();
                    fila[5] = tr.getPrivilegios();
                    fila[6] = tr.getEstado();
                    fila[7] = tr.getFecha_ingreso();

                    modelo.addRow(fila);
                }
            }
            rs.close();                    
            st.close(); 
            cn.close();
            return modelo;

        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
   }
    
    public boolean ingresar(Trabajadores tr){
        querySQL = "insert into trabajador(run,nombre,telefono,pass,privilegios,estado,fecha_ingreso) values(?,?,?,?,?,?,?)";
        mysql = new Conexion();
        cn = mysql.conectar();
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
    
    public boolean modificar(Trabajadores tr){
        querySQL = "update trabajador set trabajador.run=?,trabajador.nombre=?,trabajador.telefono=?,trabajador.pass=?,trabajador.privilegios=? where trabajador.id_trabajador=?";
        mysql = new Conexion();
        cn = mysql.conectar();
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
    
    public boolean eliminar(Trabajadores tr){
        //querySQL = "delete from cliente where id_cliente = ?";
        querySQL = "update trabajador set trabajador.estado = 0 where trabajador.id_trabajador = ? ";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setInt(1, tr.getId_trabajador());
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
    public String nombreTrabajador(String id_trabajador){
        String nombre="";
        querySQL = "select trabajador.nombre from trabajador where trabajador.id_trabajador = ?";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            PreparedStatement st = cn.prepareStatement(querySQL);
            st.setInt(1, Integer.parseInt(id_trabajador));
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                nombre = rs.getString("nombre");
                break;
            }
            rs.close();                    
            st.close(); 
            cn.close();
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
        querySQL = "select * from trabajador where trabajador.run=?";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            PreparedStatement st = cn.prepareStatement(querySQL);
            st.setString(1, run);
            ResultSet rs = st.executeQuery();
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
            cn.close();
            return esta;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return esta;
        }
    }
    public int estadoTrabajador(String run){
        boolean sigue = true;
        int estado=2;
        querySQL = "select * from trabajador where trabajador.run=?";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            PreparedStatement st = cn.prepareStatement(querySQL);
            st.setString(1, run);
            ResultSet rs = st.executeQuery();
            while(rs.next() && sigue){
                estado=rs.getInt("estado");  
                if(estado == 0 || estado == 1){
                    sigue=false;
                }
            }
            rs.close();                    
            st.close();
            cn.close();
            return estado;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return estado;
        }
    }
    public boolean modificarEstadodeEliminado(Trabajadores tr){
        querySQL = "update trabajador set trabajador.estado=1 where trabajador.id_trabajador=?";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setInt(1, tr.getId_trabajador());
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
    public int obtenerIDTrabajadorRun(String run){
        int id=0;
        boolean sigue = true;
        querySQL = "select * from trabajador where trabajador.run=?";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            PreparedStatement st = cn.prepareStatement(querySQL);
            st.setString(1, run);
            ResultSet rs = st.executeQuery();
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
            cn.close();
            return id;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return id;
        }
    }
    
    
    public ArrayList listaTrabajadores(){
        ArrayList<Trabajadores> list = new ArrayList<Trabajadores>();
        Trabajadores tr;
        mysql = new Conexion();
        cn = mysql.conectar();
        try{
            Statement st = cn.createStatement(); //variable de Conexion a la bd
            querySQL="select * from trabajador where estado=1";
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                    tr = new Trabajadores();
                    tr.setId_trabajador(rs.getInt("id_trabajador"));
                    tr.setRun(rs.getString("run"));
                    tr.setNombre(rs.getString("nombre"));
                    tr.setTelefono(rs.getString("telefono"));
                    tr.setPass(rs.getString("pass"));
                    tr.setPrivilegios(rs.getInt("privilegios"));
                    tr.setEstado(rs.getInt("estado"));
                    tr.setFecha_ingreso(rs.getString("fecha_ingreso"));
                    list.add(tr);
            }
            rs.close();                    
            st.close(); 
            cn.close();
            return list;

        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
   }
}
