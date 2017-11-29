
package Datos;

import Controlador.Conexion;
import Controlador.Fecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Venta {
    int id_venta;
    String fecha;
    int monto_total;
    private Conexion mysql; //instancia a la cadena de Conexion
    private Connection cn;
    private String querySQL = "";//cadena de Conexion
    private int totalregistros=0;
    Fecha f = new Fecha();
    public ArrayList<Clientes> listC = new ArrayList<Clientes>(); //Lista de clientes seleccionados para la venta
    public ArrayList<Tratamientos> listT = new ArrayList<Tratamientos>(); //lista de tratamientos para cada cliente
    
    public Venta() {

    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(int monto_total) {
        this.monto_total = monto_total;
    }

    public Venta(int id_venta, String fecha, int monto_total) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.monto_total = monto_total;
    }
    
    
    /*public Object[] cli_trat(Object[] c, Object [] t){
        boolean sigue = true;
        querySQL = "select * from cliente where cliente.id_cliente=?";
        Object[] ct = new Object[5];
        try {
            PreparedStatement st = cn.prepareStatement(querySQL);
            //st.setInt(1, Integer.parseInt());
            ResultSet rs = st.executeQuery();
            
            while(rs.next() && sigue){
                //estado=rs.getInt("estado");  

            }
            rs.close();                    
            st.close(); 
            return ct;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
            return ct;
        }
        
    }*/
    
    public boolean ingresarVenta(Trabajadores tr, int monto){
        querySQL = "insert into venta(fecha, monto_total, id_cliente, id_tratamiento, id_trabajador) values(?,?,?,?,?)";
        mysql = new Conexion();
        cn = mysql.conectar();
        try {
            int n=0;
            PreparedStatement pst = cn.prepareStatement(querySQL);
            for(int i=0; i< listT.size(); i++){
                pst = cn.prepareStatement(querySQL);
                pst.setString(1, f.obtenerFecha());
                pst.setInt(2, monto);   
                pst.setInt(3, listC.get(i).getId_cliente());
                pst.setInt(4, listT.get(i).getId_tratamiento());
                pst.setInt(5, tr.getId_trabajador());
                n = pst.executeUpdate();
            }
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
    
    public DefaultTableModel mostrar(Clientes c, Tratamientos t){
        listC.add(c);
        listT.add(t);
        DefaultTableModel modelo; //
        String [] columnas = {"RUN", "Nombre", "¿Beneficio?", "Tratamiento", "Precio $"};
        modelo = new DefaultTableModel(null,columnas);
        modelo.isCellEditable(totalregistros, 5);
        /*Object fila[] = new Object[5];
        fila[0] = c.getRun();
        fila[1] = c.getNombre();
        fila[2] = c.getBeneficio();
        fila[3] = t.getTipo();
        fila[4] = t.getPrecio();*/
            if(listT.size() > 0){
                for(int i=0; i< listT.size(); i++){
                    Object fila[] = new Object[5];
                    fila[0] = listC.get(i).getRun();
                    fila[1] = listC.get(i).getNombre();
                    fila[2] = listC.get(i).getBeneficio();
                    fila[3] = listT.get(i).getTipo();
                    fila[4] = listT.get(i).getPrecio();
                    modelo.addRow(fila);
                    totalregistros=totalregistros+1;
                }
            }
        return modelo;
    }
    
    public boolean existeVenta(Clientes c, Tratamientos t){
        boolean existe = false;
        for(int i=0; i< listT.size(); i++){
            if((c.getId_cliente()==listC.get(i).getId_cliente()) && t.getId_tratamiento()==listT.get(i).getId_tratamiento()){
                existe = true;
                break;
            } 
        }
        return existe;   
    }
    
    public boolean actualizaBeneficios(){
        querySQL = "update cliente set beneficio=beneficio+1 where id_cliente=?";
        mysql = new Conexion();
        cn = mysql.conectar();
        ArrayList<Clientes> copialistC= new ArrayList<Clientes>();
        copialistC = listC;
        try {
            int n=0;
            PreparedStatement pst = cn.prepareStatement(querySQL);
            for(int i=0; i< copialistC.size(); i++){
                System.out.println("sjew123e");
                pst = cn.prepareStatement(querySQL);
                //pst.setInt(1, copialistC.get(i).getBeneficio()+1);
                pst.setInt(1, copialistC.get(i).getId_cliente());
                n = pst.executeUpdate();
                int idCliente = copialistC.get(i).getId_cliente();
                for(int j=0; j< copialistC.size(); j++){
                    if(idCliente == copialistC.get(j).getId_cliente()){
                        copialistC.remove(j);
                    }
                }
                System.out.println(i);
            }
            copialistC.clear();
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
