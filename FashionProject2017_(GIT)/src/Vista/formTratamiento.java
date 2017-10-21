
 package Vista;

import Datos.tratamientos;

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
import java.awt.Component;

/**
 *
 * @author maria
 */
public class formTratamiento extends javax.swing.JPanel {
    fashionProject m = new fashionProject();
    menuEnVentanas mv = new menuEnVentanas();
    int fila;
    String nombreinicial;
    private String accion="guardar";
    private Component rootPane;
    
    public formTratamiento() {
        initComponents();
        mostrarListaTratamientos("");
        inhabilitar();
    }
    void limpiarregistroTra(){
        txtnombre.setText("");
        txtprecio.setText("");
        txtidtratamiento.setText("");
        
    }
    void ocultar_columnas(){
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    void inhabilitar(){
        txtnombre.setEnabled(false);
        txtprecio.setEnabled(false); 
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false); 
        txtnombre.setText("");
        txtprecio.setText("");
    }
    void habilitar(){
        txtnombre.setEnabled(true);
        txtprecio.setEnabled(true);
        btnnuevo.setEnabled(true);
        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true); 
    }
    void mostrarListaTratamientos(String buscar){
        try {
            DefaultTableModel modelo;
            //funcionesCliente func = new funcionesCliente();
            tratamientos tra =new tratamientos();
            modelo = tra.mostrar(buscar); //instancia de las funciones, buscar es de buscar cliente
            tabla.setModel(modelo);
            ocultar_columnas();
            lblregistrostotal.setText("Total de registros: "+Integer.toString(tra.totalregistros));
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
     void guardar_o_modificar_tratamiento(){
        tratamientos tra =new tratamientos();
        if(accion.equals("guardar")){
            if((tra.verificarTratamientoNombre(txtnombre.getText()))){
                JOptionPane.showMessageDialog(rootPane, "NOMBRE '"+txtnombre.getText()+"' ya existente en los registros.", "NOMBRE ya existente!", JOptionPane.OK_OPTION);
                if(tra.estadoTratamiento(txtnombre.getText()) == 0){ 
                    int resp = JOptionPane.showConfirmDialog(null, "¿Desea reincorporar el tratamiento?", "Dar de alta a tratamiento!", JOptionPane.YES_NO_OPTION);                    
                    if(resp == 0){
                        System.out.println("Si hay que cambiarle el estado");
                        tratamientos t = new tratamientos();
                        int id = tra.obtenerIDTratamientoNombre(txtnombre.getText());
                        t.setId_tratamiento(id);
                        tra.modificarEstadodeEliminado(t);  //////modifica el estado, de eliminado(0) a no eliminado(1)
                        modificarTratamiento(fila); //desplegamos la informacion del cliente
                        mostrarListaTratamientos(""); //actualizamos la tabla
                    }
                }
                txtnombre.requestFocus();
                txtnombre.selectAll();
                return;
            }
        }
        if(accion.equals("editar") && !(nombreinicial.equals(txtnombre.getText()))){ //en el && veo si es que no se edito el rut
            if((tra.verificarTratamientoNombre(txtnombre.getText()))){ 
                JOptionPane.showMessageDialog(rootPane, "Nonbre '"+txtnombre.getText()+"' ya existente en los registros.", "NOMBRE ya existente!", JOptionPane.WARNING_MESSAGE);
                txtnombre.requestFocus();
                txtnombre.selectAll();
                return;
            }
        }
        if((txtnombre.getText().trim()).length()==0 || (txtnombre.getText().trim()).equals("")){
            JOptionPane.showConfirmDialog(rootPane, "Debe ingresar Nombre.","",JOptionPane.WARNING_MESSAGE);
            txtnombre.requestFocus();
            return;
        }

        tra.setNombre(txtnombre.getText());
        tra.setPrecio(Integer.parseInt(txtprecio.getText()));
        
        if (accion.equals("guardar")) {
            if (tra.ingresar(tra)) {
                JOptionPane.showMessageDialog(rootPane, "Tratamiento '"+tra.getNombre()+"' registrado satisfactoriamente.");
                mostrarListaTratamientos("");
                inhabilitar();
            }
        }
        else if(accion.equals("editar")){
            tra.setId_tratamiento(Integer.parseInt(txtidtratamiento.getText()));
            if (tra.modificar(tra)) {
                JOptionPane.showMessageDialog(rootPane, "Tratamiento '"+tra.getNombre()+"' modificado satisfactoriamente.");
                mostrarListaTratamientos("");
                inhabilitar();
            }
        }
    }
    void nuevoTratamiento(){
        limpiarregistroTra();
        habilitar();
        btnguardar.setText("Guardar Nuevo Tratamiento");
        btnguardar.setToolTipText("Guardar Nuevo Tratamiento");
        btncancelar.setToolTipText("Cancelar la Modificación Actual");
        accion="guardar"; //si es guardar o editar
    }
    void eliminarTratamiento(){
        tratamientos tra = new tratamientos();
        if (!txtidtratamiento.getText().equals("")) {
            Component rootPane = null;
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro "
                    + "de dar de baja a tratamiento: Nombre = '"+tra.nombreTratamiento(txtidtratamiento.getText())+"' ?","Confirmar",2);
            if (confirmacion==0) {
                tra.setId_tratamiento(Integer.parseInt(txtidtratamiento.getText()));
                tra.eliminar(tra);
                mostrarListaTratamientos("");
                inhabilitar();
                limpiarregistroTra();
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un tratamiento en la tabla de tratamientos del costado derecho.","",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    void modificarTratamiento(int fila){
        btnguardar.setText("Guardar Modificación");
        habilitar();
        btneliminar.setEnabled(true);
        accion="editar";
        tratamientos tra= new tratamientos();

        txtidtratamiento.setText(tabla.getValueAt(fila, 0).toString());
        txtnombre.setText(tabla.getValueAt(fila, 1).toString());
        txtprecio.setText(tabla.getValueAt(fila, 2).toString());
        
        tra.setId_tratamiento(Integer.parseInt(txtidtratamiento.getText()));
        tra.setNombre(txtnombre.getText());
        tra.setPrecio(Integer.parseInt(txtprecio.getText()));
        tra.setEstado(Integer.parseInt(tabla.getValueAt(fila, 3).toString()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtidtratamiento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblregistrostotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnnuevo = new javax.swing.JButton();
        panelmenu = new javax.swing.JPanel();
        btneliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Gestión de Tratamientos");

        btnsalir.setText("Volver al Menú");
        btnsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(234, 253, 234));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Tratamiento"));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("Precio");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Nombre");

        txtnombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtprecio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabel10.setText("(*) Obligatorios");

        jLabel11.setText("*");

        jLabel13.setText("*");

        btnguardar.setText("Guardar");
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        txtidtratamiento.setEditable(false);
        txtidtratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidtratamientoActionPerformed(evt);
            }
        });

        jLabel8.setText("Nº Registro Tratamiento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtidtratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtidtratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncancelar))
        );

        jPanel2.setBackground(new java.awt.Color(221, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Tratamientos"));

        lblregistrostotal.setText("' '");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Buscar Tratamiento");

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

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9)
                        .addGap(60, 60, 60)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblregistrostotal)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(lblregistrostotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnnuevo.setText("Nuevo Tratamiento");
        btnnuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelmenuLayout = new javax.swing.GroupLayout(panelmenu);
        panelmenu.setLayout(panelmenuLayout);
        panelmenuLayout.setHorizontalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );
        panelmenuLayout.setVerticalGroup(
            panelmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        btneliminar.setText("Eliminar Tratamiento");
        btneliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnnuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        //this.dispose();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        txtprecio.transferFocus();
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char c = evt.getKeyChar();
        if(c==KeyEvent.VK_SPACE || !(Character.isDigit(c) || c=='k' ||  c=='K')){
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        txtprecio.transferFocus();
    }//GEN-LAST:event_txtprecioActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        guardar_o_modificar_tratamiento();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        inhabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtidtratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidtratamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidtratamientoActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        mostrarListaTratamientos(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminarTratamiento();
    }//GEN-LAST:event_btneliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblregistrostotal;
    public static javax.swing.JPanel panelmenu;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtidtratamiento;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
