
package Vista;

import Datos.trabajadores;

import java.awt.event.ActionEvent; 
import java.awt.event.MouseEvent; 
import javax.swing.ButtonGroup; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JRadioButton; 
import javax.swing.JScrollPane; 
import javax.swing.JSeparator; 
import javax.swing.JTable; 
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class formTrabajador extends javax.swing.JFrame {
    fashionProject m = new fashionProject();
    menuEnVentanas mv = new menuEnVentanas();
    int fila;
    String runinicial;
    private String accion="guardar"; //lo que se muestra en un comienzo en el boton de multiples opciones
    int privilegiosTr;
    
    public formTrabajador() {
        initComponents();
        mostrarListaTrabajadores("");
        inhabilitar();
        //panelmenu.removeAll();
        //panelmenu.add(mv,BorderLayout.CENTER);
        //panelmenu.revalidate();
        //panelmenu.repaint();
    }
    void limpiarregistroTr(){
        txtrun.setText("");
        txtnombre.setText("");
        txttelefono.setText("");
        txtpass.setText("");
        privilegios.clearSelection();
        txtidtrabajador.setText("");
    }
    void ocultar_columnas(){
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    void inhabilitar(){
        txtrun.setEnabled(false);
        txtnombre.setEnabled(false); 
        txttelefono.setEnabled(false); 
        txtpass.setEnabled(false); 
        opadmin.setEnabled(false); 
        opnormal.setEnabled(false);
        //btnnuevo.setEnabled(false);
        btnguardartr.setEnabled(false);
        btncancelartr.setEnabled(false); 
        txtrun.setText("");
        txtnombre.setText("");
        txttelefono.setText("");
        txtpass.setText("");
        privilegios.clearSelection();
    }
    void habilitar(){
        txtrun.setEnabled(true);
        txtnombre.setEnabled(true); 
        txttelefono.setEnabled(true); 
        txtpass.setEnabled(true); 
        opadmin.setEnabled(true); 
        opnormal.setEnabled(true);
        btnnuevotr.setEnabled(true);
        btnguardartr.setEnabled(true);
        btncancelartr.setEnabled(true); 
    }
    
    void mostrarListaTrabajadores(String buscar){
        try {
            DefaultTableModel modelo;
            //funcionesCliente func = new funcionesCliente();
            trabajadores tr =new trabajadores();
            modelo = tr.mostrar(buscar); //instancia de las funciones, buscar es de buscar cliente
            tabla.setModel(modelo);
            ocultar_columnas();
            lblregistrostotal.setText("Total de registros: "+Integer.toString(tr.totalregistros));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    void guardar_o_modificar_trabajador(){
        trabajadores tr =new trabajadores();
        
        String runformateado = tr.arreglaRUN(txtrun.getText());
        txtrun.setText(runformateado);
        System.out.println(tr.ValidaRUN(runformateado));
        
        if(tr.ValidaRUN(runformateado)==false){
                JOptionPane.showMessageDialog(rootPane, "RUN '"+txtrun.getText()+"' es inválido, por favor verificar.", "RUN inválido!", JOptionPane.WARNING_MESSAGE);
                txtrun.requestFocus();
                txtrun.selectAll();
                //txtrun.setBackground(Color.red);
                return;
        }
        if(accion.equals("guardar")){
            if((tr.verificarTrabajadorRun(txtrun.getText()))){
                JOptionPane.showMessageDialog(rootPane, "RUN '"+txtrun.getText()+"' ya existente en los registros.", "RUN ya existente!", JOptionPane.OK_OPTION);
                if(tr.estadoTrabajador(txtrun.getText()) == 0){ //si usuario que guardamos esta eliminado
                    int resp = JOptionPane.showConfirmDialog(null, "¿Desea reincorporar el trabajador?", "Dar de alta a trabajador!", JOptionPane.YES_NO_OPTION);                    
                    if(resp == 0){
                        System.out.println("Si hay que cambiarle el estado");
                        trabajadores t = new trabajadores();
                        int id = tr.obtenerIDTrabajadorRun(txtrun.getText());
                        t.setId_trabajador(id);
                        tr.modificarEstadodeEliminado(t);  //////modifica el estado, de eliminado(0) a no eliminado(1)
                        modificarTrabajador(fila); //desplegamos la informacion del trabajador
                        mostrarListaTrabajadores(""); //actualizamos la tabla
                    }
                }
                txtrun.requestFocus();
                txtrun.selectAll();
                return;
            }
        }
        if(accion.equals("editar") && !(runinicial.equals(txtrun.getText()))){ //en el && veo si es que no se edito el rut
            if((tr.verificarTrabajadorRun(txtrun.getText()))){ 
                JOptionPane.showMessageDialog(rootPane, "RUN '"+txtrun.getText()+"' ya existente en los registros.", "RUN ya existente!", JOptionPane.WARNING_MESSAGE);
                txtrun.requestFocus();
                txtrun.selectAll();
                return;
            }
        }
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
        if(txttelefono.getText().equals("")){
                JOptionPane.showConfirmDialog(rootPane, "Debe ingresar Teléfono.","",JOptionPane.WARNING_MESSAGE);
                txttelefono.requestFocus();
                return;
        }
        if(txtpass.getText().length()==0){
            JOptionPane.showConfirmDialog(rootPane, "Debe ingresar Contraseña.","",JOptionPane.WARNING_MESSAGE);
            txtpass.requestFocus();
            return;
        }
        if(!(opadmin.isSelected() || opnormal.isSelected())){
                JOptionPane.showConfirmDialog(rootPane, "Debe ingresar Privilegios.","",JOptionPane.WARNING_MESSAGE);
                opadmin.requestFocus();
                opnormal.requestFocus();
                return;
        }
        if(opadmin.isSelected()){
            privilegiosTr = 777;
        }
        if(opnormal.isSelected()){
            privilegiosTr = 111;
        }
        
        tr.setRun(txtrun.getText());    //paso los datos del formulario al objeto cliente
        tr.setNombre(txtnombre.getText());
        tr.setTelefono(txttelefono.getText());
        tr.setPass(txtpass.getText());
        tr.setPrivilegios(privilegiosTr);
        
        if (accion.equals("guardar")) {
            if (tr.ingresar(tr)) {
                JOptionPane.showMessageDialog(rootPane, "Trabajador '"+tr.getNombre()+"' registrado satisfactoriamente.");
                mostrarListaTrabajadores("");
                inhabilitar();
            }
        }
        else if(accion.equals("editar")){
            tr.setId_trabajador(Integer.parseInt(txtidtrabajador.getText()));
            if (tr.modificar(tr)) {
                JOptionPane.showMessageDialog(rootPane, "Trabajador '"+tr.getNombre()+"' modificado satisfactoriamente.");
                mostrarListaTrabajadores("");
                inhabilitar();
            }
        }
    }
    
    void nuevoTrabajador(){
        limpiarregistroTr();
        habilitar();
        btnguardartr.setText("Guardar Nuevo Trabajador");
        btnguardartr.setToolTipText("Guardar Nuevo Trabajador");
        btncancelartr.setToolTipText("Cancelar la Modificación Actual");
        accion="guardar"; //si es guardar o editar
        
    }
    void eliminarTrabajador(){
        trabajadores tr = new trabajadores();
        //funcionesCliente func = new funcionesCliente();
        if (!txtidtrabajador.getText().equals("")) {
            //cl.setId_cliente(Integer.parseInt(txtidcliente.getText()));
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro "
                    + "de dar de baja a trabajador: Nombre = '"+tr.nombreTrabajador(txtidtrabajador.getText())+"' ?","Confirmar",2);
            if (confirmacion==0) {
                tr.setId_trabajador(Integer.parseInt(txtidtrabajador.getText()));
                tr.eliminar(tr);
                mostrarListaTrabajadores("");
                inhabilitar();
                limpiarregistroTr();
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un trabajador en la tabla de trabajadores del costado derecho.","",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    void modificarTrabajador(int fila){
        btnguardartr.setText("Guardar Modificación");
        habilitar();
        btneliminartr.setEnabled(true);
        accion="editar";
        trabajadores tr = new trabajadores();

        txtidtrabajador.setText(tabla.getValueAt(fila, 0).toString());
        txtrun.setText(tabla.getValueAt(fila, 1).toString());
        txtnombre.setText(tabla.getValueAt(fila, 2).toString());
        txttelefono.setText(tabla.getValueAt(fila, 3).toString());
        txtpass.setText(tabla.getValueAt(fila, 4).toString());
        if(tabla.getValueAt(fila, 5).equals("111")){
            opnormal.setSelected(true);
            privilegiosTr = 111;
        }else{
            if(tabla.getValueAt(fila, 5).equals("777")){
                opadmin.setSelected(true);
                privilegiosTr = 777;
            }
        }

        tr.setId_trabajador(Integer.parseInt(txtidtrabajador.getText()));
        tr.setRun(txtrun.getText());
        tr.setNombre(txtnombre.getText());
        tr.setTelefono(txttelefono.getText());
        tr.setPass(txtpass.getText());
        tr.setPrivilegios(privilegiosTr);
        tr.setEstado(Integer.parseInt(tabla.getValueAt(fila, 6).toString()));
        tr.setFecha_ingreso((tabla.getValueAt(fila, 7).toString()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        privilegios = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnnuevotr = new javax.swing.JButton();
        btneliminartr = new javax.swing.JButton();
        btnsalirtr = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtrun = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtidtrabajador = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnguardartr = new javax.swing.JButton();
        btncancelartr = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        opadmin = new javax.swing.JRadioButton();
        opnormal = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        lblregistrostotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión Trabajadores FashionProject");
        setPreferredSize(new java.awt.Dimension(1194, 692));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Gestión de Trabajadores");

        btnnuevotr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/add.png"))); // NOI18N
        btnnuevotr.setText("Nuevo Trabajador");
        btnnuevotr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnuevotr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevotrActionPerformed(evt);
            }
        });

        btneliminartr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/eliminar.png"))); // NOI18N
        btneliminartr.setText("Eliminar Trabajador");
        btneliminartr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminartr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminartrActionPerformed(evt);
            }
        });

        btnsalirtr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/atras.png"))); // NOI18N
        btnsalirtr.setText("Volver al Menú");
        btnsalirtr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsalirtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirtrActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(243, 248, 235));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Trabajadores"));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Contraseña");

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

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabel10.setText("(*) Obligatorios");

        jLabel8.setText("Nº Registro Trabajador");

        txtidtrabajador.setEditable(false);
        txtidtrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidtrabajadorActionPerformed(evt);
            }
        });

        jLabel11.setText("*");

        jLabel12.setText("*");

        jLabel13.setText("*");

        jLabel14.setText("*");

        btnguardartr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/modificar.png"))); // NOI18N
        btnguardartr.setText("Guardar");
        btnguardartr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardartr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardartrActionPerformed(evt);
            }
        });

        btncancelartr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancel_77947.png"))); // NOI18N
        btncancelartr.setText("Cancelar");
        btncancelartr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelartr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelartrActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel15.setText("Privilegios");

        jLabel16.setText("*");

        txtpass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });

        privilegios.add(opadmin);
        opadmin.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        opadmin.setText("Administrador");
        opadmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opadminMouseClicked(evt);
            }
        });

        privilegios.add(opnormal);
        opnormal.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        opnormal.setText("Normal");
        opnormal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opnormalMouseClicked(evt);
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
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidtrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtrun, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addComponent(opnormal)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtpass, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txttelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                                    .addComponent(opadmin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnguardartr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncancelartr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidtrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel15)
                                .addGap(37, 37, 37))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnguardartr)
                                .addGap(6, 6, 6)
                                .addComponent(btncancelartr))))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(opadmin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opnormal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(248, 246, 221));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Trabajadores"));

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
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Buscar Trabajador");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblregistrostotal))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalirtr))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnnuevotr, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(btneliminartr, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnsalirtr, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnuevotr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(275, 275, 275)
                        .addComponent(btneliminartr))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevotrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevotrActionPerformed
        nuevoTrabajador();
    }//GEN-LAST:event_btnnuevotrActionPerformed

    private void btneliminartrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminartrActionPerformed
        eliminarTrabajador();
    }//GEN-LAST:event_btneliminartrActionPerformed

    private void btnsalirtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirtrActionPerformed
        //this.dispose();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnsalirtrActionPerformed

    private void txtrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrunActionPerformed
        txtrun.transferFocus();
    }//GEN-LAST:event_txtrunActionPerformed

    private void txtrunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrunKeyTyped
        char c = evt.getKeyChar();
        if(c==KeyEvent.VK_SPACE || !(Character.isDigit(c) || c=='k' ||  c=='K')){
            evt.consume();
        }
    }//GEN-LAST:event_txtrunKeyTyped

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        txtnombre.transferFocus();
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        txttelefono.transferFocus();
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c=='+' || c=='-')) evt.consume();    
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtidtrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidtrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidtrabajadorActionPerformed

    private void btnguardartrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardartrActionPerformed
        guardar_o_modificar_trabajador();
    }//GEN-LAST:event_btnguardartrActionPerformed

    private void btncancelartrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelartrActionPerformed
        inhabilitar();
    }//GEN-LAST:event_btncancelartrActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        fila = tabla.rowAtPoint(evt.getPoint());  //fila donde hago click
        modificarTrabajador(fila);
        //txtrun.setEnabled(false); //deshabilitar modificacion de run
        runinicial = txtrun.getText();
    }//GEN-LAST:event_tablaMouseClicked

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        mostrarListaTrabajadores(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    private void opadminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opadminMouseClicked
        // radio administrador
        privilegiosTr = 777;
    }//GEN-LAST:event_opadminMouseClicked

    private void opnormalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opnormalMouseClicked
        // radio normal
        privilegiosTr = 111;
    }//GEN-LAST:event_opnormalMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelartr;
    private javax.swing.JButton btneliminartr;
    private javax.swing.JButton btnguardartr;
    private javax.swing.JButton btnnuevotr;
    private javax.swing.JButton btnsalirtr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblregistrostotal;
    private javax.swing.JRadioButton opadmin;
    private javax.swing.JRadioButton opnormal;
    public static javax.swing.ButtonGroup privilegios;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtidtrabajador;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtrun;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
