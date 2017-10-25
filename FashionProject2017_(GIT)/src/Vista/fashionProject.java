
package Vista;
import Controlador.Fecha;

import java.awt.event.ActionEvent; 
import java.awt.event.MouseEvent; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class fashionProject extends javax.swing.JFrame {

    public fashionProject() {
        initComponents();
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngestionarclientes = new javax.swing.JButton();
        btngestionartrabjadores = new javax.swing.JButton();
        txtusuario = new javax.swing.JLabel();
        txtfecha = new javax.swing.JLabel();
        cerrarsesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btngestionartratamientos = new javax.swing.JButton();
        btnregistrarventa = new javax.swing.JButton();
        btnadmingastos = new javax.swing.JButton();
        btngenerarinformes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú FashionProject");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        btngestionarclientes.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btngestionarclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/clientes.png"))); // NOI18N
        btngestionarclientes.setText("      Gestionar Clientes");
        btngestionarclientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btngestionarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestionarclientesActionPerformed(evt);
            }
        });

        btngestionartrabjadores.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btngestionartrabjadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/trabajadores.png"))); // NOI18N
        btngestionartrabjadores.setText("   Gestionar Trabajadores");
        btngestionartrabjadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btngestionartrabjadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestionartrabjadoresActionPerformed(evt);
            }
        });

        txtusuario.setText("Usuario");

        txtfecha.setText("Fecha");

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

        btngestionartratamientos.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btngestionartratamientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/tratamientos.png"))); // NOI18N
        btngestionartratamientos.setText("     Gestionar Tratamientos");
        btngestionartratamientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btngestionartratamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestionartratamientosActionPerformed(evt);
            }
        });

        btnregistrarventa.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        btnregistrarventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/venta.png"))); // NOI18N
        btnregistrarventa.setText("   Venta");
        btnregistrarventa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnregistrarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarventaActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cerrarsesion)
                        .addGap(215, 215, 215)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtusuario)
                            .addComponent(txtfecha)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btngestionartratamientos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btngestionartrabjadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btngestionarclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnregistrarventa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnadmingastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btngenerarinformes, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cerrarsesion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnregistrarventa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btngestionarclientes, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btngestionartrabjadores, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnadmingastos, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btngenerarinformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btngestionartratamientos, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                .addGap(86, 86, 86)
                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfecha)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btngestionarclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestionarclientesActionPerformed

                formCliente fcl = new formCliente();
                fcl.setVisible(true);
                this.setVisible(false);                
    }//GEN-LAST:event_btngestionarclientesActionPerformed

    private void cerrarsesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarsesionMouseClicked
        JOptionPane.showMessageDialog(null, "La presente acción se implemenatará en próximos incrementos.\n\nDebería ir a la ventana de autenticarse.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_cerrarsesionMouseClicked

    private void cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarsesionActionPerformed

    private void btngestionartrabjadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestionartrabjadoresActionPerformed
                formTrabajador ftr = new formTrabajador();
                ftr.setVisible(true);
                this.setVisible(false);   
        //JOptionPane.showMessageDialog(null, "La presente acción se implemenatará en próximos incrementos.\n\nDebería redirigirte a la interfaz de los trabajadores.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btngestionartrabjadoresActionPerformed

    private void btngestionartratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestionartratamientosActionPerformed
                formTratamiento ftra = new formTratamiento();
                ftra.setVisible(true);
                this.setVisible(false);   
    }//GEN-LAST:event_btngestionartratamientosActionPerformed

    private void btnregistrarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarventaActionPerformed
                formVenta fvent = new formVenta();
                fvent.setVisible(true);
                this.setVisible(false);   
    }//GEN-LAST:event_btnregistrarventaActionPerformed

    private void btnadmingastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadmingastosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnadmingastosActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fashionProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fashionProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fashionProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fashionProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        fashionProject m = new fashionProject();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Fecha f = new Fecha();
                m.setVisible(true);
                //this.setVisible(false);
                m.txtfecha.setText("Fecha: "+f.obtenerFecha());

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadmingastos;
    private javax.swing.JButton btngenerarinformes;
    private javax.swing.JButton btngestionarclientes;
    private javax.swing.JButton btngestionartrabjadores;
    private javax.swing.JButton btngestionartratamientos;
    private javax.swing.JButton btnregistrarventa;
    private javax.swing.JButton cerrarsesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtfecha;
    private javax.swing.JLabel txtusuario;
    // End of variables declaration//GEN-END:variables
}
