
package Vista;

import Datos.Clientes;
import Datos.Tratamientos;
import Datos.Venta;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormVenta extends javax.swing.JFrame {
    FashionProject m = new FashionProject();
    Login l = new Login();
    public int fila_cliente;
    public int fila_tratamiento;
    
    Clientes clienteVenta;
    Tratamientos tratamientoVenta;
    
    public int totalregistrosventa=0;
    Venta v =new Venta();
    
    public FormVenta() {
        initComponents();
        /*clienteVenta.setRun("188863841");
        clienteVenta.setNombre("Camilo");
        clienteVenta.setBeneficio(0);
        tratamientoVenta.setPrecio(2000);
        tratamientoVenta.setTipo("hola");*/
        this.setLocationRelativeTo(null);
        mostrarListaClientes("");
        mostrarListaTratamientos("");
        //mostrarListaVenta();
        inhabilitar();
        lbltrabajador.setText(l.trabajadorpublic.getNombre());  //TRABAJADOR
    }
    void inhabilitar(){
        tabla_venta.setEnabled(false);
        btnrealizarventa.setEnabled(false);
        btncancelarventa.setEnabled(false); 
    }
    void habilitar(){
        tabla_venta.setEnabled(true);
        btnrealizarventa.setEnabled(true);
        btncancelarventa.setEnabled(true); 
    }
    
    public Tratamientos retornarTratamiento(String nombre){
            Tratamientos tra = new Tratamientos();
            tratamientoVenta = tra.obtenerTratamiento(nombre);
            return tratamientoVenta;
    }
    public Clientes retornarCliente(String run){
            Clientes cl = new Clientes();
            clienteVenta = cl.obtenerCliente(run);
            return clienteVenta;
    }
    
    /*void mostrarListaVenta(){
        String [] columnas = {"Run", "Nombre", "¿Beneficio?", "Tratamiento", "Precio $"}; 
        modeloVenta = new DefaultTableModel(null,columnas);
        tabla_venta.setModel(modeloVenta);
    }*//*
    public void mostrarVenta(Clientes c, Tratamientos t){
            //modeloVenta.isCellEditable(totalregistrosventa, 5);
            modeloVenta.insertRow(totalregistrosventa, new Object[]{});
            modeloVenta.setValueAt(c.getRun(),totalregistrosventa,0);
            modeloVenta.setValueAt(c.getNombre(),totalregistrosventa,1);
            modeloVenta.setValueAt(c.getBeneficio(),totalregistrosventa,2);
            modeloVenta.setValueAt(t.getTipo(),totalregistrosventa,3);
            modeloVenta.setValueAt(t.getPrecio(),totalregistrosventa,4);
            totalregistrosventa=totalregistrosventa+1;*/
            /*Object fila[] = new Object[5];
            fila[0] = clienteVenta.getRun();
            fila[1] = clienteVenta.getNombre();
            fila[2] = clienteVenta.getBeneficio();
            fila[3] = tratamientoVenta.getTipo();
            fila[4] = tratamientoVenta.getPrecio();

            modeloVenta.addRow(fila);
            tabla_venta.setModel(modeloVenta);
            totalregistrosventa=totalregistrosventa+1;
            System.out.println("asfasdada");*/

    //}
    
    void mostrarListaVenta(){
        try {
            DefaultTableModel modeloVenta;
            Venta vv = new Venta();
            modeloVenta = vv.mostrar(clienteVenta, tratamientoVenta); 
            modeloVenta = vv.mostrar(clienteVenta, tratamientoVenta); 
            tabla_venta.setModel(modeloVenta); //////////NO FUNCIONA CON ESTA TABLA, PERO SI CON LAS OTRAS 
            System.out.println(clienteVenta.getNombre()+"   "+tratamientoVenta.getTipo());
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
 
    void mostrarListaClientes(String buscar){
        try {
            DefaultTableModel modelo;

            Clientes cl =new Clientes();
            modelo = cl.mostrar(buscar);
            tabla_cliente.setModel(modelo);
            int[ ] ocultar_columna_cli = {0,3,4,5,6,7,8};
            for(int i: ocultar_columna_cli){
                tabla_cliente.getColumnModel().getColumn(i).setMaxWidth(0);
                tabla_cliente.getColumnModel().getColumn(i).setMinWidth(0);
                tabla_cliente.getColumnModel().getColumn(i).setPreferredWidth(0);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    
    void mostrarListaTratamientos(String buscar){
        try {
            DefaultTableModel modelo;

            Tratamientos trat =new Tratamientos();
            modelo = trat.mostrar(buscar); 
            tabla_tratamiento.setModel(modelo);
            int[ ] ocultar_columna_tra = {0,3};
            for(int i: ocultar_columna_tra){
                tabla_tratamiento.getColumnModel().getColumn(i).setMaxWidth(0);
                tabla_tratamiento.getColumnModel().getColumn(i).setMinWidth(0);
                tabla_tratamiento.getColumnModel().getColumn(i).setPreferredWidth(0);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnsalirtr = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnrealizarventa = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbltrabajador = new javax.swing.JLabel();
        btncancelarventa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_venta = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_cliente = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_tratamiento = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_tratamiento = new javax.swing.JTextField();
        btn_agregar_a_venta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnsalirtr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/atras.png"))); // NOI18N
        btnsalirtr.setText("Volver al Menú");
        btnsalirtr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsalirtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirtrActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Venta");

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumen Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        btnrealizarventa.setText("Realizar Venta");
        btnrealizarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrealizarventaActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trabajador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        jLabel3.setText("Trabajador Actual: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbltrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btncancelarventa.setText("Cancelar Venta");
        btncancelarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarventaActionPerformed(evt);
            }
        });

        jLabel2.setText("$ ...");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setText("TOTAL:");

        tabla_venta = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla_venta.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_venta.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        tabla_venta.setFocusable(false);
        tabla_venta.setShowGrid(true);
        tabla_venta.getTableHeader().setReorderingAllowed(false);
        tabla_venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_ventaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabla_venta);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 701, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnrealizarventa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncancelarventa))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnrealizarventa)
                    .addComponent(btncancelarventa)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        tabla_venta = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla_cliente.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        tabla_cliente.setFocusable(false);
        tabla_cliente.setShowGrid(true);
        tabla_cliente.getTableHeader().setReorderingAllowed(false);
        tabla_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_clienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_cliente);

        jButton2.setText("AGREGAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Cliente");

        jLabel6.setText("Buscar:");

        txt_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_clienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(214, 214, 214)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        tabla_venta = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla_tratamiento.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_tratamiento.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        tabla_tratamiento.setFocusable(false);
        tabla_tratamiento.setShowGrid(true);
        tabla_tratamiento.getTableHeader().setReorderingAllowed(false);
        tabla_tratamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_tratamientoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_tratamiento);

        jLabel5.setText("Tratamiento");

        jLabel7.setText("Buscar:");

        txt_tratamiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tratamientoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addGap(185, 185, 185)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(txt_tratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_agregar_a_venta.setText("CONTINUAR");
        btn_agregar_a_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_a_ventaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_agregar_a_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_agregar_a_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalirtr, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnsalirtr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnrealizarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrealizarventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnrealizarventaActionPerformed

    private void btnsalirtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirtrActionPerformed
        Object [] botones = { "Salir Venta", "Continuar Venta"};
        int resp = JOptionPane.showOptionDialog (null, "Seleccione opción", "Salir o Continuar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);            
        if(resp == 0){
            m.setVisible(true);
            this.setVisible(false);
        }
        if (resp != 0){
            this.setVisible(true);
        }
    }//GEN-LAST:event_btnsalirtrActionPerformed

    private void btncancelarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelarventaActionPerformed

    private void tabla_tratamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_tratamientoMouseClicked
        fila_tratamiento = tabla_tratamiento.rowAtPoint(evt.getPoint());  //fila donde hago click
        String nombre = tabla_tratamiento.getValueAt(fila_tratamiento, 1).toString();
        retornarTratamiento(nombre);
    }//GEN-LAST:event_tabla_tratamientoMouseClicked

    private void tabla_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clienteMouseClicked
        fila_cliente = tabla_cliente.rowAtPoint(evt.getPoint());  //fila donde hago click
        String run = tabla_cliente.getValueAt(fila_cliente, 1).toString();
        retornarCliente(run);
    }//GEN-LAST:event_tabla_clienteMouseClicked
 
    /*public Object[] cliente_tratamiento(Object[] cli, Object[] trat){
        
        Venta v = new Venta();
        v.cli_trat(cli, trat);
        Object[] cli_tra = new Object[5];
        
        return cli_tra;
    }*/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Object [] botones = { "Registrar Cliente", "Continuar Anónimo"};
        int resp = JOptionPane.showOptionDialog (null, "Agregar Cliente ...", "Nuevo Cliente", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null/*icono*/, botones, botones[0]);            
        if(resp == 0){
            FormCliente fc = new FormCliente();
            fc.setVisible(true);
            this.setVisible(false);
        }
        if (resp != 0){
            System.out.println("Cliente Anónimo!!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_clienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clienteKeyReleased
        mostrarListaClientes(txt_cliente.getText());
    }//GEN-LAST:event_txt_clienteKeyReleased

    private void txt_tratamientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tratamientoKeyReleased
        mostrarListaTratamientos(txt_tratamiento.getText());
    }//GEN-LAST:event_txt_tratamientoKeyReleased

    private void btn_agregar_a_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_a_ventaActionPerformed
        habilitar();
        mostrarListaVenta();
        //mostrarVenta(clienteVenta,tratamientoVenta);
        /*System.out.println(clienteVenta.getRun());
        System.out.println(clienteVenta.getNombre());
        System.out.println(clienteVenta.getBeneficio());
        System.out.println(tratamientoVenta.getTipo());
        System.out.println(tratamientoVenta.getPrecio());*/

        
    }//GEN-LAST:event_btn_agregar_a_ventaActionPerformed

    private void tabla_ventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_ventaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_ventaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar_a_venta;
    private javax.swing.JButton btncancelarventa;
    private javax.swing.JButton btnrealizarventa;
    private javax.swing.JButton btnsalirtr;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbltrabajador;
    private javax.swing.JTable tabla_cliente;
    private javax.swing.JTable tabla_tratamiento;
    private javax.swing.JTable tabla_venta;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_tratamiento;
    // End of variables declaration//GEN-END:variables
}
