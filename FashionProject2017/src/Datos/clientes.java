
package Datos;

public class clientes {
    private int id_cliente;
    private String nombre;
    private String run;
    private String telefono;
    private String ciudad;
    private String correo;
    private int estado;
    private int edad;
    private String fecha_ingreso;
    
    public clientes() {
    }

    public clientes(int id_cliente, String nombre, String run, String telefono, String ciudad, String correo, int estado, int edad, String fecha_ingreso) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.run = run;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.correo = correo;
        this.estado = estado;
        this.edad = edad;
        this.fecha_ingreso = fecha_ingreso;
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

}