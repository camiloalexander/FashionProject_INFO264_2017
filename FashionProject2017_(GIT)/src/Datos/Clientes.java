
package Datos;

import Controlador.Fecha;
import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Clientes {
    private int id_cliente;
    private String run;
    private String telefono;
    private String ciudad;
    private String correo;
    private int estado;
    private int edad;
    private String fecha_ingreso;
    private int beneficio;
    
    Fecha fecha = new Fecha();
    private Conexion mysql; //instancia a la cadena de Conexion
    private Connection cn;
    private String querySQL = "";//cadena de Conexion
    public Integer totalregistros;
    private String nombre;
    
    public Clientes() {
    }

    public Clientes(int id_cliente, String nombre, String run, String telefono, String ciudad, String correo, int estado, int edad, String fecha_ingreso, int beneficio) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.run = run;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.correo = correo;
        this.estado = estado;
        this.edad = edad;
        this.fecha_ingreso = fecha_ingreso;
        this.beneficio =  beneficio;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
        Digito =11 - (Suma % 11);
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
    
    public Clientes obtenerCliente(String run){
        Clientes cl = new Clientes();
        querySQL = "select * from cliente where cliente.run = ?";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            PreparedStatement st = cn.prepareStatement(querySQL);
            st.setString(1, run);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                cl.setId_cliente(rs.getInt("id_cliente"));
                cl.setRun(rs.getString("run"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setCiudad(rs.getString("ciudad"));
                cl.setCorreo(rs.getString("correo"));
                cl.setEstado(rs.getInt("estado"));
                cl.setEdad(rs.getInt("edad"));
                cl.setFecha_ingreso(rs.getString("fecha_ingreso"));
                cl.setBeneficio(rs.getInt("beneficio"));
                break;
            }
            rs.close();                    
            st.close(); 
            cn.close();
            return cl;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return cl;
        }
    }
    
    public DefaultTableModel mostrar(String buscar){
        mysql = new Conexion();
        cn = mysql.conectar();
        DefaultTableModel modelo; //
        //String [] columnas = {"ID", "RUN", "Nombre", "Telefono", "Ciudad", "Correo", "Estado", "Edad", "Fecha de ingreso"}; //titulos
        String [] columnas = {"ID", "RUN", "Nombre", "Telefono", "Ciudad", "Correo", "Estado", "Edad", "Fecha de ingreso", "Beneficio"}; //titulos
        //String [] columnas = {"ID", "RUN", "Nombre", "Edad", "Ciudad", "Telefono", "Correo", "Fecha de ingreso"}; //titulos
        
        ////String [] registro = new String [9]; //se almacenan los registros
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,columnas);
        modelo.isCellEditable(totalregistros, 10);
        ArrayList<Clientes> list = new ArrayList<Clientes>();
        Clientes cl;
        /*querySQL="select * from cliente where "
                + "(cliente.nombre like '%?%' )"
                + "or (cliente.run like '%?%' )"
                + "or (cliente.edad like '%?%' )"
                + "or (cliente.ciudad like '%?%' )"
                + "or (cliente.telefono like '%?%' )"
                + "or (cliente.correo like '%?%' )"
                + "or (cliente.fecha_ingreso like '%?%' )"
                + "order by cliente.id_cliente";*/
        querySQL="select * from cliente where "
                + "(cliente.nombre like '%"+buscar+"%' )"
                + "or (cliente.run like '%"+buscar+"%' )"
                + "or (cliente.edad like '%"+buscar+"%' )"
                + "or (cliente.ciudad like '%"+buscar+"%' )"
                + "or (cliente.telefono like '%"+buscar+"%' )"
                + "or (cliente.correo like '%"+buscar+"%' )"
                + "or (cliente.estado like '%"+buscar+"%' )"
                + "or (cliente.edad like '%"+buscar+"%' )"
                + "or (cliente.fecha_ingreso like '%"+buscar+"%' )"
                + "or (cliente.beneficio like '%"+buscar+"%' )"
                + "order by cliente.id_cliente";
        try{
            /*PreparedStatement st = cn.prepareStatement(querySQL);
            st.setString(1, buscar);
            st.setString(2, buscar);
            st.setString(3, buscar);
            st.setString(4, buscar);
            st.setString(5, buscar);
            st.setString(6, buscar);
            st.setString(7, buscar);
            ResultSet rs = st.executeQuery();*/
            Statement st = cn.createStatement(); //variable de Conexion a la bd
            ResultSet rs = st.executeQuery(querySQL);
            while(rs.next()){
                if(rs.getString("estado").equals("0")){  //si esta dado de baja no se muestra 
                    rs.next();
                }else{
                /*
                    registro[0] = rs.getString("id_cliente");
                    registro[1] = rs.getString("run");
                    registro[2] = rs.getString("nombre");
                    registro[3] = rs.getString("telefono");
                    registro[4] = rs.getString("ciudad");
                    registro[5] = rs.getString("correo");
                    registro[6] = rs.getString("estado");
                    registro[7] = rs.getString("edad"); 
                    registro[8] = rs.getString("fecha_ingreso");
                    */
                    cl = new Clientes();
                    cl.setId_cliente(rs.getInt("id_cliente"));
                    cl.setRun(rs.getString("run"));
                    cl.setNombre(rs.getString("nombre"));
                    cl.setTelefono(rs.getString("telefono"));
                    cl.setCiudad(rs.getString("ciudad"));
                    cl.setCorreo(rs.getString("correo"));
                    cl.setEstado(rs.getInt("estado"));
                    cl.setEdad(rs.getInt("edad"));
                    cl.setFecha_ingreso(rs.getString("fecha_ingreso"));
                    cl.setBeneficio(rs.getInt("beneficio"));
                    list.add(cl);
                   
                    totalregistros=totalregistros+1;
                    //modelo.addRow(registro);
                }
            }
            rs.close();                    
            st.close(); 
            cn.close();
            if(list.size()-1 > 0){
                for(int i=0; i< list.size(); i++){
                    Object fila[] = new Object[10];
                    cl = list.get(i);
                    fila[0] = cl.getId_cliente();
                    fila[1] = cl.getRun();
                    fila[2] = cl.getNombre();
                    fila[3] = cl.getTelefono();
                    fila[4] = cl.getCiudad();
                    fila[5] = cl.getCorreo();
                    fila[6] = cl.getEstado();
                    fila[7] = cl.getEdad();
                    fila[8] = cl.getFecha_ingreso();
                    fila[9] = cl.getBeneficio();

                    modelo.addRow(fila);
                }
            }
            //sirve para recorrer el arraylist de Clientes
            /*Iterator<clientes> nombreIterator = list.iterator();
            while(nombreIterator.hasNext()){
                Clientes c = nombreIterator.next();
                System.out.println(c.getId_cliente()+" "+c.getNombre());
            }*/
            return modelo;
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
        
    public boolean ingresar(Clientes cl){
        querySQL = "insert into cliente(run,nombre,telefono,ciudad,correo,estado,edad,fecha_ingreso,beneficio) values(?,?,?,?,?,?,?,?,?)";
        mysql = new Conexion();
        cn = mysql.conectar();
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
            pst.setInt(9, 1);
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
    
    public boolean modificar(Clientes cl){
        //querySQL = "update cliente set run=?,nombre=?,telefono=?,ciudad=?,correo=?,estado=?,edad=?,fecha_ingreso=? where id_cliente=?";
        querySQL = "update cliente set cliente.run=?,cliente.nombre=?,cliente.telefono=?,cliente.ciudad=?,cliente.correo=?,cliente.edad=? where cliente.id_cliente=?";
        mysql = new Conexion();
        cn = mysql.conectar();
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
    
    public boolean eliminar(Clientes cl){
        //querySQL = "delete from cliente where id_cliente = ?";
        querySQL = "update cliente set cliente.estado = 0 where cliente.id_cliente = ? ";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setInt(1, cl.getId_cliente());
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
    public String nombreCliente(String id_cliente){
        String nombre="";
        querySQL = "select cliente.nombre from cliente where cliente.id_cliente = ?";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            PreparedStatement st = cn.prepareStatement(querySQL);
            st.setString(1, id_cliente);
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
    public boolean verificarClienteRun(String run){
        boolean esta = false;
        boolean sigue = true;
        String r = "";
        querySQL = "select * from cliente where cliente.run=?";
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
                System.out.println("sin coincidencias de clientes con ese rut");
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
    public int estadoCliente(String run){
        boolean sigue = true;
        int estado=2;
        querySQL = "select * from cliente where cliente.run=?";
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
    public boolean modificarEstadodeEliminado(Clientes cl){
        querySQL = "update cliente set cliente.estado=1 where cliente.id_cliente=?";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            PreparedStatement pst = cn.prepareStatement(querySQL);
            pst.setInt(1, cl.getId_cliente());
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
    public int obtenerIDClienteRun(String run){
        int id=0;
        boolean sigue = true;
        querySQL = "select * from cliente where cliente.run=?";
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
                        id = rs.getInt("id_cliente");
                        sigue = false;
                    }    
                }
            }else{
                System.out.println("sin coincidencias de clientes con ese rut");
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
}