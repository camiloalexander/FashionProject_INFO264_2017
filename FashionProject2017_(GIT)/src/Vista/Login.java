
package Vista;

import Datos.Trabajadores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Login extends javax.swing.JFrame implements ActionListener{
    
    Trabajadores t = new Trabajadores();
    ArrayList <Trabajadores> lt = new ArrayList<Trabajadores>();
    //Object[] trabajadorpublic = new Object[8];
    public static Trabajadores trabajadorpublic;
    JRadioButton [] rb;
    int tam;
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        contraseña.setEnabled(false);
        btnaceptar.setEnabled(false);
        lt=t.listaTrabajadores();
        tam=lt.size();
        opcionesdeTrabajadores();
       
    }
    private void opcionesdeTrabajadores(){
        rb =new JRadioButton[tam];
        Iterator<Trabajadores> i = lt.iterator();
        for(int j=0; j<lt.size();j++){
                Trabajadores t = i.next();
                rb[j]=new JRadioButton(t.getNombre());
                rb[j].addActionListener(this);
                add(rb[j]);
                panel.add(rb[j]);
                buttonGroup1.add(rb[j]);
                panel.updateUI();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<tam; i++){
            if(rb[i].isSelected()){
                //System.out.println("Presionado: "+lt.get(i).getNombre());
                t.setId_trabajador(lt.get(i).getId_trabajador());
                t.setEstado(lt.get(i).getEstado());
                t.setFecha_ingreso(lt.get(i).getFecha_ingreso());
                t.setPass(lt.get(i).getPass());
                t.setPrivilegios(lt.get(i).getPrivilegios());
                t.setRun(lt.get(i).getRun());
                t.setTelefono(lt.get(i).getTelefono());
                t.setNombre(lt.get(i).getNombre());
                trabajadorpublic = t;  //variable que puede ser accedida de otras clases
                contraseña.setEnabled(true);
                btnaceptar.setEnabled(true);
            }   
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnaceptar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        contraseña = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/boton inicio_de_sesion.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("STSong", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ximena & Carolina - \"Fashion Project\"");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(233, 245, 252));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Trabajador");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Contraseña");

        btnaceptar.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnaceptar.setText("Aceptar");
        btnaceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        contraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contraseñaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contraseñaKeyPressed(evt);
            }
        });

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnaceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(contraseña)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnaceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        char[] claveEntrada  = contraseña.getPassword();
        if(claveEntrada.length==0){
            int opcion = JOptionPane.showConfirmDialog(rootPane, "No ha ingresado contraseña. ","",JOptionPane.WARNING_MESSAGE);
            if(opcion == 0){
                contraseña.selectAll();
                contraseña.requestFocus();
            }else{
                dispose();
            }
        }else{
            if(verificaClave(claveEntrada)){
                System.out.println("Contraseña Correcta.  Inicio de sesión para: "+t.getNombre()+"  -  Privilegios: "+t.getPrivilegios());
                System.out.println("");
                //USUARIO INGRESA AL SISTEMA...
                FashionProject fp = new FashionProject();
                fp.setVisible(true);
                this.setVisible(false);
            }
            else{
                int opcion = JOptionPane.showConfirmDialog(rootPane, "Contraseña errónea, intenta de nuevo. ","",JOptionPane.WARNING_MESSAGE);
                if(opcion == 0){
                    contraseña.selectAll();
                    contraseña.requestFocus();
                }else{
                    dispose();
                }
            }
        }
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void contraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseñaKeyTyped

    }//GEN-LAST:event_contraseñaKeyTyped

    private void contraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseñaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnaceptarActionPerformed(null);
        }
    }//GEN-LAST:event_contraseñaKeyPressed

    public boolean verificaClave(char[] clave) {
        boolean esCorrecta = true;
        char[] claveCorrecta = t.getPass().toCharArray();
        if (clave.length != claveCorrecta.length) {
            esCorrecta = false;
        } else {
            esCorrecta = Arrays.equals(clave, claveCorrecta);
        }
        return esCorrecta;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btncancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
