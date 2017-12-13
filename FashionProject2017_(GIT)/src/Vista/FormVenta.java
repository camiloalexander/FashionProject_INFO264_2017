
package Vista;

import Datos.Clientes;
import Datos.Tratamientos;
import Datos.Venta;
import java.text.DecimalFormat;
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
    
    private int precio_total=0;
    private int descuento_total=0;
    
    DefaultTableModel modeloVenta;
    DefaultTableModel modeloCliente;
    DefaultTableModel modeloTratamiento;
    boolean tablaClSeleccionada = false;
    boolean tablaTraSeleccionada = false;
    
    DecimalFormat formateador = new DecimalFormat("###,###.###");
    
    public FormVenta() {
        initComponents();
        TABLA_NO.setVisible(false);
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
        btn_agregar_a_venta.setEnabled(false);
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
                if(v.existeVenta(clienteVenta, tratamientoVenta)==true){
                    JOptionPane.showMessageDialog(null, "Venta duplicada.");          

                }
                else{
                    //Venta vv = new Venta();
                    //modeloVenta = vv.mostrar(clienteVenta, tratamientoVenta); 
                    modeloVenta = v.mostrar(clienteVenta, tratamientoVenta); 
                    tabla_venta.setModel(modeloVenta); //////////NO FUNCIONA CON ESTA TABLA, PERO SI CON LAS OTRAS 
                    //System.out.println(clienteVenta.getNombre()+"   "+tratamientoVenta.getTipo());

                    descuento_total=descuento_total+clienteVenta.getBeneficio();
                    lbldescuento.setText(String.valueOf(descuento_total));

                    precio_total=precio_total+tratamientoVenta.getPrecio()-(clienteVenta.getBeneficio());
                    lblpreciototal.setText(String.valueOf(formateador.format(precio_total)));
                    System.out.println("SE AGREGA A VENTA:");
                    System.out.println("** Trabajador: "+l.trabajadorpublic.getNombre()+"  - id: "+l.trabajadorpublic.getId_trabajador());
                    System.out.println("** Cliente: "+clienteVenta.getNombre()+"  - id: "+clienteVenta.getId_cliente());
                    System.out.println("** Tratamiento: "+tratamientoVenta.getTipo()+"  - id: "+tratamientoVenta.getId_tratamiento());
                    System.out.println("");
                }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
 
    void mostrarListaClientes(String buscar){
        try {
            Clientes cl =new Clientes();
            modeloCliente = cl.mostrar(buscar);
            tabla_cliente.setModel(modeloCliente);
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
            Tratamientos trat =new Tratamientos();
            modeloTratamiento = trat.mostrar(buscar); 
            tabla_tratamiento.setModel(modeloTratamiento);
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbltrabajador = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblpreciototal = new javax.swing.JLabel();
        btncancelarventa = new javax.swing.JButton();
        btnrealizarventa = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TABLA_NO = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla_venta = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        lbldescuento = new javax.swing.JLabel();

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

        jPanel5.setBackground(new java.awt.Color(250, 236, 250));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(233, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_cliente = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla_cliente.setFocusable(false);
        tabla_cliente.setShowGrid(true);
        tabla_cliente.getTableHeader().setReorderingAllowed(false);
        tabla_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_clienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_cliente);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/add.png"))); // NOI18N
        jButton2.setText("Nuevo Cliente");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
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
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addGap(200, 200, 200)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(223, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_tratamiento = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla_tratamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_tratamiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla_tratamiento.setFocusable(false);
        tabla_tratamiento.setShowGrid(true);
        tabla_tratamiento.getTableHeader().setReorderingAllowed(false);
        tabla_tratamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_tratamientoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_tratamiento);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(151, 151, 151)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(311, 311, 311))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btn_agregar_a_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/agregar-icono-8359-128.png"))); // NOI18N
        btn_agregar_a_venta.setText("Agregar a Venta");
        btn_agregar_a_venta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_agregar_a_venta)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_agregar_a_venta, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Trabajador Actual: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel8.setText("TOTAL: $");

        lblpreciototal.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N

        btncancelarventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/600px-No-Symbol.png"))); // NOI18N
        btncancelarventa.setText("Eliminar Venta");
        btncancelarventa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarventaActionPerformed(evt);
            }
        });

        btnrealizarventa.setBackground(new java.awt.Color(255, 255, 255));
        btnrealizarventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/298303.png"))); // NOI18N
        btnrealizarventa.setText("Venta Realizada");
        btnrealizarventa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrealizarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrealizarventaActionPerformed(evt);
            }
        });

        TABLA_NO = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TABLA_NO.setModel(new javax.swing.table.DefaultTableModel(
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
        TABLA_NO.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        TABLA_NO.setFocusable(false);
        TABLA_NO.setShowGrid(true);
        TABLA_NO.getTableHeader().setReorderingAllowed(false);
        TABLA_NO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLA_NOMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TABLA_NO);

        tabla_venta = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla_venta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUN", "Nombre", "¿Beneficio?", "Tratamiento", "Precio $"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_venta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla_venta.setFocusable(false);
        tabla_venta.setShowGrid(true);
        tabla_venta.getTableHeader().setReorderingAllowed(false);
        tabla_venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_ventaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabla_venta);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Decuento: $");

        lbldescuento.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(736, 736, 736)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane5)
                                .addGap(44, 44, 44)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbldescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(lblpreciototal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnrealizarventa, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(btncancelarventa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbldescuento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblpreciototal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btncancelarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnrealizarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalirtr, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                                             

    private void tabla_tratamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_tratamientoMouseClicked
        fila_tratamiento = tabla_tratamiento.rowAtPoint(evt.getPoint());  //fila donde hago click
        String nombre = tabla_tratamiento.getValueAt(fila_tratamiento, 1).toString();
        retornarTratamiento(nombre);
        tablaTraSeleccionada = true;
        if(tablaClSeleccionada){
            btn_agregar_a_venta.setEnabled(true);
        }
    }//GEN-LAST:event_tabla_tratamientoMouseClicked

    private void tabla_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clienteMouseClicked
        fila_cliente = tabla_cliente.rowAtPoint(evt.getPoint());  //fila donde hago click
        String run = tabla_cliente.getValueAt(fila_cliente, 1).toString();
        retornarCliente(run);
        tablaClSeleccionada = true;
        if(tablaTraSeleccionada){
            btn_agregar_a_venta.setEnabled(true);
        }
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
        tabla_cliente.clearSelection();
        tabla_tratamiento.clearSelection();
        tabla_venta.clearSelection();
        btn_agregar_a_venta.setEnabled(false);
        tablaTraSeleccionada = false;
        tablaClSeleccionada = false;
        
        //lblpreciototal.setText(Integer.toString(tratamientoVenta.getPrecio()));
        //mostrarVenta(clienteVenta,tratamientoVenta);
        /*System.out.println(clienteVenta.getRun());
        System.out.println(clienteVenta.getNombre());
        System.out.println(clienteVenta.getBeneficio());
        System.out.println(tratamientoVenta.getTipo());
        System.out.println(tratamientoVenta.getPrecio());*/

        
    }//GEN-LAST:event_btn_agregar_a_ventaActionPerformed

    private void btncancelarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarventaActionPerformed
        Object [] botones = { "Cancelar Venta", "Seguir con la venta"};
        int resp = JOptionPane.showOptionDialog (null, "¿Cancelar venta actual?", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);            
        if(resp == 0){
            precio_total=0;
            lblpreciototal.setText(String.valueOf(formateador.format(precio_total)));
            descuento_total=0;
            lbldescuento.setText(String.valueOf(descuento_total));
            v.listC.clear();
            v.listT.clear();
            modeloVenta.setRowCount(0);
        }        
    }//GEN-LAST:event_btncancelarventaActionPerformed

    private void btnrealizarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrealizarventaActionPerformed
        Object [] botones = { "Venta ya realizada", "Cliente aun no paga"};
        int resp = JOptionPane.showOptionDialog (null, "¿Se efectuó el pago de la venta?", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);            
        if(resp == 0){
                v.ingresarVenta(l.trabajadorpublic, precio_total);
                JOptionPane.showMessageDialog(null, "Venta realizada con exito.");
                inhabilitar();
                precio_total=0;
                lblpreciototal.setText(String.valueOf(formateador.format(precio_total)));
                descuento_total=0;
                lbldescuento.setText(String.valueOf(descuento_total));
                v.listC.clear();
                v.listT.clear();
                modeloVenta.setRowCount(0);
                v.actualizaBeneficios();
                v.mostrar(clienteVenta, tratamientoVenta);
        }  
    }//GEN-LAST:event_btnrealizarventaActionPerformed

    private void tabla_ventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_ventaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_ventaMouseClicked

    private void TABLA_NOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLA_NOMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TABLA_NOMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TABLA_NO;
    private javax.swing.JButton btn_agregar_a_venta;
    private javax.swing.JButton btncancelarventa;
    private javax.swing.JButton btnrealizarventa;
    private javax.swing.JButton btnsalirtr;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbldescuento;
    private javax.swing.JLabel lblpreciototal;
    private javax.swing.JLabel lbltrabajador;
    private javax.swing.JTable tabla_cliente;
    private javax.swing.JTable tabla_tratamiento;
    private javax.swing.JTable tabla_venta;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_tratamiento;
    // End of variables declaration//GEN-END:variables
}
