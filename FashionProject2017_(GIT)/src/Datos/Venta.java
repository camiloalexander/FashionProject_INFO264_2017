
package Datos;

public class Venta {
    int id_venta;
    String fecha;
    float monto_total;

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
    
    
    
    
}
