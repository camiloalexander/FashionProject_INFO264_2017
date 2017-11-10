
package Vista;

import Controlador.Fecha;

public class FashionProject extends javax.swing.JFrame {
    Fecha f = new Fecha();
    Login l = new Login();
    public FashionProject() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblfecha.setText(f.fechaParaMostrar());
        lblusuario.setText(l.trabajadorpublic.getNombre());
        tipoUsuario();
    }
    
    private void tipoUsuario(){
        int privilegios = l.trabajadorpublic.getPrivilegios();
        if(privilegios == 111) usuarioSinPrivilegios();
        if(privilegios == 777) usuarioConPrivilegios();
    }
    
    private void usuarioSinPrivilegios(){
        this.btnadmingastos.setEnabled(false);
        this.btngenerarinformes.setEnabled(false);
        this.btngestionarclientes.setEnabled(true);
        this.btngestionartrabajadores.setEnabled(false);
        this.btngestionartratamientos.setEnabled(false);
        this.btnregistrarventa.setEnabled(true);
        this.lbltipo.setText("No Administrador");
    }
    
    private void usuarioConPrivilegios(){
        this.btnadmingastos.setEnabled(true);
        this.btngenerarinformes.setEnabled(true);
        this.btngestionarclientes.setEnabled(true);
        this.btngestionartrabajadores.setEnabled(true);
        this.btngestionartratamientos.setEnabled(true);
        this.btnregistrarventa.setEnabled(true);
        this.lbltipo.setText("Administrador");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cerrarsesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblusuario = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        txtfecha = new javax.swing.JLabel();
        txtusuario = new javax.swing.JLabel();
        labeltipo = new javax.swing.JLabel();
        lbltipo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnregistrarventa = new javax.swing.JButton();
        btngestionarclientes = new javax.swing.JButton();
        btngestionartrabajadores = new javax.swing.JButton();
        btnadmingastos = new javax.swing.JButton();
        btngenerarinformes = new javax.swing.JButton();
        btngestionartratamientos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú FashionProject");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Logout.png"))); // NOI18N
        cerrarsesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarsesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarsesionMouseClicked(evt);
            }
        });
        cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarsesionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/home.png"))); // NOI18N
        jLabel1.setText(" Menú Principal");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sesión iniciada por"));

        lblusuario.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        lblfecha.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        txtfecha.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        txtfecha.setText("Fecha:");

        txtusuario.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        txtusuario.setText("Usuario:");

        labeltipo.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        labeltipo.setText("Tipo:");

        lbltipo.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(txtusuario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(labeltipo)
                            .addGap(34, 34, 34)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtfecha)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblfecha, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbltipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblusuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))
                .addGap(95, 95, 95))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labeltipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbltipo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(243, 254, 255));

        btnregistrarventa.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        btnregistrarventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/venta.png"))); // NOI18N
        btnregistrarventa.setText("   Venta");
        btnregistrarventa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnregistrarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarventaActionPerformed(evt);
            }
        });

        btngestionarclientes.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btngestionarclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/clientes.png"))); // NOI18N
        btngestionarclientes.setText("      Gestionar Clientes");
        btngestionarclientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btngestionarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestionarclientesActionPerformed(evt);
            }
        });

        btngestionartrabajadores.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btngestionartrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/trabajadores.png"))); // NOI18N
        btngestionartrabajadores.setText("   Gestionar Trabajadores");
        btngestionartrabajadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btngestionartrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestionartrabajadoresActionPerformed(evt);
            }
        });

        btnadmingastos.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        btnadmingastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/gastos.png"))); // NOI18N
        btnadmingastos.setText("   Gastos");
        btnadmingastos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnadmingastos.setEnabled(false);
        btnadmingastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadmingastosActionPerformed(evt);
            }
        });

        btngenerarinformes.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        btngenerarinformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/documento.png"))); // NOI18N
        btngenerarinformes.setText("   Informes");
        btngenerarinformes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btngenerarinformes.setEnabled(false);

        btngestionartratamientos.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btngestionartratamientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/tratamientos.png"))); // NOI18N
        btngestionartratamientos.setText("     Gestionar Tratamientos");
        btngestionartratamientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btngestionartratamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestionartratamientosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btngestionartrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngestionarclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngestionartratamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnadmingastos, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistrarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngenerarinformes, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnregistrarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngestionarclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadmingastos, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(btngestionartrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngenerarinformes, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngestionartratamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cerrarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(156, 156, 156)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cerrarsesion))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btngestionarclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestionarclientesActionPerformed

                FormCliente fcl = new FormCliente();
                fcl.setVisible(true);
                this.setVisible(false);    
    }//GEN-LAST:event_btngestionarclientesActionPerformed

    private void cerrarsesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarsesionMouseClicked

        //JOptionPane.showMessageDialog(null, "La presente acción se implemenatará en próximos incrementos.\n\nDebería ir a la ventana de autenticarse.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_cerrarsesionMouseClicked

    private void cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsesionActionPerformed
                Login l = new Login();
                l.setVisible(true);
                dispose();
    }//GEN-LAST:event_cerrarsesionActionPerformed

    private void btngestionartrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestionartrabajadoresActionPerformed
                FormTrabajador ftr = new FormTrabajador();
                ftr.setVisible(true);
                this.setVisible(false);   
        //JOptionPane.showMessageDialog(null, "La presente acción se implemenatará en próximos incrementos.\n\nDebería redirigirte a la interfaz de los Trabajadores.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btngestionartrabajadoresActionPerformed

    private void btngestionartratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestionartratamientosActionPerformed
                FormTratamiento ftra = new FormTratamiento();
                ftra.setVisible(true);
                this.setVisible(false);   
    }//GEN-LAST:event_btngestionartratamientosActionPerformed

    private void btnregistrarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarventaActionPerformed
                FormVenta fvent = new FormVenta();
                fvent.setVisible(true);
                this.setVisible(false);   
    }//GEN-LAST:event_btnregistrarventaActionPerformed

    private void btnadmingastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadmingastosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnadmingastosActionPerformed
    
    //public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FashionProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FashionProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FashionProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FashionProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FashionProject m = new FashionProject();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Fecha f = new Fecha();
                m.setVisible(true);
                //this.setVisible(false);
                m.txtfecha.setText("Fecha: "+f.obtenerFecha());

            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadmingastos;
    private javax.swing.JButton btngenerarinformes;
    private javax.swing.JButton btngestionarclientes;
    private javax.swing.JButton btngestionartrabajadores;
    private javax.swing.JButton btngestionartratamientos;
    private javax.swing.JButton btnregistrarventa;
    private javax.swing.JButton cerrarsesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labeltipo;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lbltipo;
    public javax.swing.JLabel lblusuario;
    private javax.swing.JLabel txtfecha;
    private javax.swing.JLabel txtusuario;
    // End of variables declaration//GEN-END:variables
}
