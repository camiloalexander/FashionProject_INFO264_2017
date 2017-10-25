
package Vista;

import Datos.clientes;

import java.awt.event.ActionEvent; 
import java.awt.event.MouseEvent; 
import javax.swing.JButton; 
import javax.swing.JCheckBoxMenuItem; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JMenu; 
import javax.swing.JMenuBar; 
import javax.swing.JPanel; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.menuEnVentanas;


public class formCliente extends javax.swing.JFrame {
    fashionProject m = new fashionProject();
    menuEnVentanas mv = new menuEnVentanas();
    int fila;
    String runinicial;
    private String accion="guardar"; //lo que se muestra en un comienzo en el boton de multiples opciones
    
    
    public formCliente(){
        initComponents();
        mostrarListaClientes("");
        inhabilitar();
    }
    void limpiarregistroCl(){
        txtcorreo.setText("");
        txtrun.setText("");
        txtnombre.setText("");
        txttelefono.setText("");
        txtciudad.setText("");
        txtedad.setText("");
        txtidcliente.setText("");
        
    }
    void ocultar_columnas(){
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    void inhabilitar(){
        txtcorreo.setEnabled(false);
        txtrun.setEnabled(false);
        txtnombre.setEnabled(false); 
        txttelefono.setEnabled(false); 
        txtciudad.setEnabled(false); 
        txtedad.setEnabled(false); 
        //btnnuevo.setEnabled(false);
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false); 
        txtcorreo.setText("");
        txtrun.setText("");
        txtnombre.setText("");
        txttelefono.setText("");
        txtciudad.setText("");
        txtedad.setText("");
    }
    void habilitar(){
        txtcorreo.setEnabled(true);
        txtrun.setEnabled(true);
        txtnombre.setEnabled(true); 
        txttelefono.setEnabled(true); 
        txtciudad.setEnabled(true); 
        txtedad.setEnabled(true); 
        btnnuevo.setEnabled(true);
        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true); 
    }
    
    void mostrarListaClientes(String buscar){
        try {
            DefaultTableModel modelo;
            //funcionesCliente func = new funcionesCliente();
            clientes cl =new clientes();
            modelo = cl.mostrar(buscar); //instancia de las funciones, buscar es de buscar cliente
            tabla.setModel(modelo);
            ocultar_columnas();
            lblregistrostotal.setText("Total de registros: "+Integer.toString(cl.totalregistros));
                        /////////////para poner un nuevo jpanel en la ventana
            panelmenu.removeAll();
            panelmenu.setBackground(Color.white);
            panelmenu.add(mv,BorderLayout.CENTER);
            panelmenu.show();
            
            panelmenu.updateUI();
            panelmenu.revalidate();
            panelmenu.repaint();
            System.out.println("paso por el panel");
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    void guardar_o_modificar_cliente(){
        if(txtrun.getText().length()==0 /*|| (txtrun.getText().trim()).equals("")*/){  //confirmo que tenga rut y nombre en los campos para guardar
            JOptionPane.showConfirmDialog(rootPane, "Debe ingresar RUN.","",JOptionPane.WARNING_MESSAGE);
            txtrun.selectAll();
            txtrun.requestFocus();
            return;
        }
        if((txtnombre.getText().trim()).length()==0 || (txtnombre.getText().trim()).equals("")){
            JOptionPane.showConfirmDialog(rootPane, "Debe ingresar Nombre.","",JOptionPane.WARNING_MESSAGE);
            txtnombre.requestFocus();
            return;
        }
        if(txtedad.getText().length()==0){
            JOptionPane.showConfirmDialog(rootPane, "Debe ingresar Edad.","",JOptionPane.WARNING_MESSAGE);
            txtedad.requestFocus();
            return;
        }
        if(txtciudad.getText().length()==0){
            JOptionPane.showConfirmDialog(rootPane, "Debe ingresar Ciudad.","",JOptionPane.WARNING_MESSAGE);
            txtciudad.requestFocus();
            return;
        }
        if(!(txtcorreo.getText().equals(""))){
            if((txtcorreo.getText().indexOf("@")==-1)){
                JOptionPane.showConfirmDialog(rootPane, "Debe ingresar un Correo válido.","",JOptionPane.WARNING_MESSAGE);
                txtcorreo.requestFocus();
                return;
            }

        }
        
        clientes cl =new clientes();
        
        String runformateado = cl.arreglaRUN(txtrun.getText());
        txtrun.setText(runformateado);
        System.out.println(cl.ValidaRUN(runformateado));
        
        if(cl.ValidaRUN(runformateado)==false){
                JOptionPane.showMessageDialog(rootPane, "RUN '"+txtrun.getText()+"' es inválido, por favor verificar.", "RUN inválido!", JOptionPane.WARNING_MESSAGE);
                txtrun.requestFocus();
                txtrun.selectAll();
                //txtrun.setBackground(Color.red);
                return;
        }
        if(accion.equals("guardar")){
            if((cl.verificarClienteRun(txtrun.getText()))){
                JOptionPane.showMessageDialog(rootPane, "RUN '"+txtrun.getText()+"' ya existente en los registros.", "RUN ya existente!", JOptionPane.OK_OPTION);
                if(cl.estadoCliente(txtrun.getText()) == 0){ //si usuario que guardamos esta eliminado
                    int resp = JOptionPane.showConfirmDialog(null, "¿Desea reincorporar el cliente?", "Dar de alta a cliente!", JOptionPane.YES_NO_OPTION);                    
                    if(resp == 0){
                        System.out.println("Si hay que cambiarle el estado");
                        clientes c = new clientes();
                        int id = cl.obtenerIDClienteRun(txtrun.getText());
                        c.setId_cliente(id);
                        cl.modificarEstadodeEliminado(c);  //////modifica el estado, de eliminado(0) a no eliminado(1)
                        modificarCliente(fila); //desplegamos la informacion del cliente
                        mostrarListaClientes(""); //actualizamos la tabla
                    }
                }
                txtrun.requestFocus();
                txtrun.selectAll();
                return;
            }
        }
        if(accion.equals("editar") && !(runinicial.equals(txtrun.getText()))){ //en el && veo si es que no se edito el rut
            if((cl.verificarClienteRun(txtrun.getText()))){ 
                JOptionPane.showMessageDialog(rootPane, "RUN '"+txtrun.getText()+"' ya existente en los registros.", "RUN ya existente!", JOptionPane.WARNING_MESSAGE);
                txtrun.requestFocus();
                txtrun.selectAll();
                return;
            }
        }
       
        cl.setRun(txtrun.getText());    //paso los datos del formulario al objeto cliente
        cl.setNombre(txtnombre.getText());
        cl.setTelefono(txttelefono.getText());
        cl.setCiudad(txtciudad.getText());
        cl.setCorreo(txtcorreo.getText());
        cl.setEdad(Integer.parseInt(txtedad.getText()));
        
        if (accion.equals("guardar")) {
            if (cl.ingresar(cl)) {
                JOptionPane.showMessageDialog(rootPane, "Cliente '"+cl.getNombre()+"' registrado satisfactoriamente.");
                mostrarListaClientes("");
                inhabilitar();
            }
        }
        else if(accion.equals("editar")){
            cl.setId_cliente(Integer.parseInt(txtidcliente.getText()));
            if (cl.modificar(cl)) {
                JOptionPane.showMessageDialog(rootPane, "Cliente '"+cl.getNombre()+"' modificado satisfactoriamente.");
                mostrarListaClientes("");
                inhabilitar();
            }
        }
    }
    
    void nuevoCliente(){
        limpiarregistroCl();
        habilitar();
        btnguardar.setText("Guardar Nuevo Cliente");
        btnguardar.setToolTipText("Guardar Nuevo Cliente");
        btncancelar.setToolTipText("Cancelar la Modificación Actual");
        accion="guardar"; //si es guardar o editar
    }
    void eliminarCliente(){
        clientes cl = new clientes();
        //funcionesCliente func = new funcionesCliente();
        if (!txtidcliente.getText().equals("")) {
            //cl.setId_cliente(Integer.parseInt(txtidcliente.getText()));
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro "
                    + "de dar de baja a cliente: Nombre = '"+cl.nombreCliente(txtidcliente.getText())+"' ?","Confirmar",2);
            if (confirmacion==0) {
                cl.setId_cliente(Integer.parseInt(txtidcliente.getText()));
                cl.eliminar(cl);
                mostrarListaClientes("");
                inhabilitar();
                limpiarregistroCl();
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un cliente en la tabla de clientes del costado derecho.","",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    void modificarCliente(int fila){
        btnguardar.setText("Guardar Modificación");
        habilitar();
        btneliminar.setEnabled(true);
        accion="editar";
        clientes cl = new clientes();

        txtidcliente.setText(tabla.getValueAt(fila, 0).toString());
        txtrun.setText(tabla.getValueAt(fila, 1).toString());
        txtnombre.setText(tabla.getValueAt(fila, 2).toString());
        txttelefono.setText(tabla.getValueAt(fila, 3).toString());
        txtciudad.setText(tabla.getValueAt(fila, 4).toString());
        txtcorreo.setText(tabla.getValueAt(fila, 5).toString());
        txtedad.setText(tabla.getValueAt(fila, 7).toString());
        
        cl.setId_cliente(Integer.parseInt(txtidcliente.getText()));
        cl.setRun(txtrun.getText());
        cl.setNombre(txtnombre.getText());
        cl.setTelefono(txttelefono.getText());
        cl.setCiudad(txtcorreo.getText());
        cl.setCorreo(txtcorreo.getText());
        cl.setEdad(Integer.parseInt(txtedad.getText()));
        cl.setEstado(Integer.parseInt(tabla.getValueAt(fila, 6).toString()));
        cl.setFecha_ingreso((tabla.getValueAt(fila, 8).toString()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtcorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtrun = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtciudad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtedad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtidcliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblregistrostotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnsalir = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        panelmenu = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión Clientes FashionProject");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(234, 253, 234));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Cliente"));

        txtcorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });
        txtcorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcorreoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setText("Correo");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Ciudad de residencia");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("Teléfono");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("RUN");

        txtrun.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtrun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrunActionPerformed(evt);
            }
        });
        txtrun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrunKeyTyped(evt);
            }
        });

        txtnombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        txttelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        txtciudad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtciudadActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Edad");

        txtedad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtedadActionPerformed(evt);
            }
        });
        txtedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtedadKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabel10.setText("(*) Obligatorios");

        jLabel8.setText("Nº Registro Cliente");

        txtidcliente.setEditable(false);
        txtidcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidclienteActionPerformed(evt);
            }
        });

        jLabel11.setText("*");

        jLabel12.setText("*");

        jLabel13.setText("*");

        jLabel14.setText("*");

        btnguardar.setIcon(new javax.swing.ImageIcon("/Users/alexndr/GitHub/FashionProject_INFO264_2017/FashionProject2017_(GIT)/files/modificar.png")); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon("/Users/alexndr/GitHub/FashionProject_INFO264_2017/FashionProject2017_(GIT)/files/cancel_77947.png")); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btncancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtrun, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10)))
                            .addComponent(txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnguardar)
                                .addGap(6, 6, 6)
                                .addComponent(btncancelar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtrun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Gestión de Clientes");

        jPanel2.setBackground(new java.awt.Color(221, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Clientes"));

        lblregistrostotal.setText("' '");

        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        tabla.setFocusable(false);
        tabla.setShowGrid(true);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Buscar Cliente");

        txtbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblregistrostotal))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9)
                        .addGap(60, 60, 60)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblregistrostotal))
        );

        btnsalir.setIcon(new javax.swing.ImageIcon("/Users/alexndr/GitHub/FashionProject_INFO264_2017/FashionProject2017_(GIT)/files/atras.png")); // NOI18N
        btnsalir.setText("Volver al Menú");
        btnsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnnuevo.setIcon(new javax.swing.ImageIcon("/Users/alexndr/GitHub/FashionProject_INFO264_2017/FashionProject2017_(GIT)/files/add.png")); // NOI18N
        btnnuevo.setText("Nuevo Cliente");
        btnnuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon("/Users/alexndr/GitHub/FashionProject_INFO264_2017/FashionProject2017_(GIT)/files/eliminar.png")); // NOI18N
        btneliminar.setText("Eliminar Cliente");
        btneliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelmenuLayout = new javax.swing.GroupLayout(panelmenu);
        panelmenu.setLayout(panelmenuLayout);
        panelmenuLayout.setHorizontalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );
        panelmenuLayout.setVerticalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );

        jMenu2.setText("Otros");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jCheckBoxMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Ver cantidad de registros");
        jCheckBoxMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBoxMenuItem1.setEnabled(false);
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Ver clientes dados de baja");
        jCheckBoxMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBoxMenuItem2.setEnabled(false);
        jMenu2.add(jCheckBoxMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(823, 823, 823)
                        .addComponent(btnsalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(panelmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnnuevo)
                        .addGap(18, 18, 18)
                        .addComponent(panelmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed
        txtcorreo.transferFocus();
    }//GEN-LAST:event_txtcorreoActionPerformed

    private void txtrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrunActionPerformed
        txtrun.transferFocus();
    }//GEN-LAST:event_txtrunActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        txtnombre.transferFocus();
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        txttelefono.transferFocus();
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtciudadActionPerformed
        txtciudad.transferFocus();
    }//GEN-LAST:event_txtciudadActionPerformed

    private void txtedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtedadActionPerformed
        txtedad.transferFocus();
    }//GEN-LAST:event_txtedadActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        guardar_o_modificar_cliente();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        nuevoCliente();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void txtidclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidclienteActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        //this.dispose();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminarCliente();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        fila = tabla.rowAtPoint(evt.getPoint());  //fila donde hago click
        modificarCliente(fila);
        //txtrun.setEnabled(false); //deshabilitar modificacion de run
        runinicial = txtrun.getText();
    }//GEN-LAST:event_tablaMouseClicked

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        mostrarListaClientes(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        inhabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        //mostrar("");
        //funcionesCliente func = new funcionesCliente();
        //lblregistrostotal.setText("Total de registros: "+Integer.toString(func.totalregistros));
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void txtedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtedadKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c))) evt.consume();    
        if(txtedad.getText().length()>=3) evt.consume();  // valido que no sea mayor que 3 digitos
    }//GEN-LAST:event_txtedadKeyTyped

    private void txtcorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorreoKeyTyped
        char c = evt.getKeyChar();
        if(c==KeyEvent.VK_SPACE) evt.consume();   
    }//GEN-LAST:event_txtcorreoKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        char c = evt.getKeyChar();
        if(c==KeyEvent.VK_SPACE) evt.consume();
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtrunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrunKeyTyped
        char c = evt.getKeyChar();
        if(c==KeyEvent.VK_SPACE || !(Character.isDigit(c) || c=='k' ||  c=='K')){
            evt.consume();
        }
    }//GEN-LAST:event_txtrunKeyTyped

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblregistrostotal;
    public static javax.swing.JPanel panelmenu;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtciudad;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtrun;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
