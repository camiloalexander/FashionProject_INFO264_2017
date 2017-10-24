
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
        jButton1 = new javax.swing.JButton();

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
        btngestionartrabjadores.setText("    Gestionar Trabajadores");
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

        jButton1.setText("Gestionar Tratamientos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtusuario)
                    .addComponent(txtfecha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cerrarsesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btngestionartrabjadores, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btngestionarclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(199, 199, 199))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cerrarsesion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(btngestionarclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btngestionartrabjadores, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        formTratamiento ftra = new formTratamiento();
                ftra.setVisible(true);
                this.setVisible(false);   
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton btngestionarclientes;
    private javax.swing.JButton btngestionartrabjadores;
    private javax.swing.JButton cerrarsesion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtfecha;
    private javax.swing.JLabel txtusuario;
    // End of variables declaration//GEN-END:variables
}
