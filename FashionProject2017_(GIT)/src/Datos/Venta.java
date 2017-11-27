
package Datos;

import Controlador.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Venta {
    int id_venta;
    String fecha;
    float monto_total;
    private Conexion mysql; //instancia a la cadena de Conexion
    private Connection cn;
    private String querySQL = "";//cadena de Conexion
    private int totalregistros=0;
    ArrayList<Clientes> listC = new ArrayList<Clientes>();
    ArrayList<Tratamientos> listT = new ArrayList<Tratamientos>();
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

    public float getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(float monto_total) {
        this.monto_total = monto_total;
    }

    public Venta(int id_venta, String fecha, float monto_total) {
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
    
}
