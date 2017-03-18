package ComponentePresentacion;

import ComponenteEntidad.Cliente;
import ComponenteEntidad.Habitacion;
import ComponenteEntidad.Recepcionista;
import ComponenteEntidad.Reserva;
import ComponenteNegocio.ReservaCN;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PRACTICAS-TESIS
 */
public class DialogMantenedorReserva extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo1 = new DefaultTableModel();
    String nombreColumna[] = {"Codigo","numero","Costo","Tipo","Estado"};
    String nombreColumna1[] = {"Codigo","numero","Costo","Tipo"};
    Cliente cliente;
    Recepcionista recepcionista;
    private String SELECCIONA_ID;
    private int SELECCIONA_NUMERO;
    private double SELECCIONAR_COSTO;
    private String SELECCIONA_ESTADO;
    private String SELECCIONA_TIPO;
    Date fecha;
    public DialogMantenedorReserva(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        setSize(830,680);
        fecha = Date.valueOf(String.format("%1$tY-%1$tm-%1$te", new java.util.Date()));  ;
        modelo.setColumnIdentifiers(nombreColumna);
        modelo1.setColumnIdentifiers(nombreColumna1);
        buscar();
        txtFechaEntrada.setText("" + fecha);
    }
    
    public void buscar(){
     
        String habilitado = Habitacion.ESTADO_LIBRE;
        try {
            List<Habitacion> habitaciones = ReservaCN.getInstancia().buscarHabitaciones(habilitado);
            Object datos[][] = new Object[habitaciones.size()][5];
            for( int i = 0 ;i < habitaciones.size() ; i++){
                Habitacion habitacion = habitaciones.get(i);
                datos[i][0] = habitacion.getIdHabitacion();
                datos[i][1] = habitacion.getNumero();
                datos[i][2] = habitacion.getCosto();
                datos[i][3] = habitacion.getCategoria().getIdCategoria();
                datos[i][4] = habitacion.getEstado();
            }
            modelo.setDataVector(datos, nombreColumna);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        
    }
    
    public void capturar(){
        int numerofila = tablaHabitaciones.getSelectedRow();
        SELECCIONA_ID = (String) tablaHabitaciones.getValueAt(numerofila, 0);
        SELECCIONA_NUMERO = (Integer)tablaHabitaciones.getValueAt(numerofila, 1);
        SELECCIONAR_COSTO = (Double)tablaHabitaciones.getValueAt(numerofila, 2);
        SELECCIONA_TIPO = (String) tablaHabitaciones.getValueAt(numerofila, 3);
        SELECCIONA_ESTADO = (String) tablaHabitaciones.getValueAt(numerofila, 4);
    }
    
    public void agregar(){
        Object fila[] = {
                SELECCIONA_ID,
                SELECCIONA_NUMERO ,
                SELECCIONAR_COSTO,
                SELECCIONA_TIPO};
        modelo1.addRow(fila);
    }
    
    public boolean datosIguales(String productoid_nuevo){
        int numeroFila = tablaReserva.getRowCount();
        String productoid_actual = "";
        if(numeroFila > 0){
            for(int i = 0 ; i < numeroFila ; i++){
                productoid_actual = (String)tablaReserva.getValueAt(i, 0);
                if(productoid_actual == productoid_nuevo)
                    return true;
            }
        }
        return false;
    }
    
    public double calcularCostoTotal(){
        double costo_habitacion = 0.0;
        double total = 0;
        for(int i = 0 ;i < tablaReserva.getRowCount();i++){
             costo_habitacion = (Double)tablaReserva.getValueAt(i, 2);
             total += costo_habitacion;
        }
        return total;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdReserva = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        txtFechaEntrada = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtdniRecepcionista = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombreRecepcionista = new javax.swing.JTextField();
        botBuscarRecepcionista = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        botBuscarCliente = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtNombrecliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReserva = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHabitaciones = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtCostoHabitacion = new javax.swing.JTextField();
        botAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RESERVA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("COSTO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("idReserva:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 74, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha entrada");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 75, -1, -1));
        getContentPane().add(txtIdReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 75, 100, -1));

        txtCosto.setEditable(false);
        txtCosto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCosto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 80, 49));

        txtFechaEntrada.setEditable(false);
        txtFechaEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(txtFechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 98, 105, -1));

        btnRegistrar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Reservas_1.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 150, 40));

        btnCancelar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1436819557_f-cross_256.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 160, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("BUSCAR RECEPCIONISTA");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel1.add(txtdniRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 110, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("DNI");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 30, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("NOMBRE");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, 20));

        txtNombreRecepcionista.setEditable(false);
        jPanel1.add(txtNombreRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 200, 20));

        botBuscarRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1436817213_system-search.png"))); // NOI18N
        botBuscarRecepcionista.setText("BUSCAR");
        botBuscarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botBuscarRecepcionistaActionPerformed(evt);
            }
        });
        jPanel1.add(botBuscarRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 130, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 75, 327, 140));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("DNI");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, -1, -1));
        jPanel2.add(txtDniCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 32, 70, -1));

        botBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1436817213_system-search.png"))); // NOI18N
        botBuscarCliente.setText("BUSCAR");
        botBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botBuscarClienteActionPerformed(evt);
            }
        });
        jPanel2.add(botBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 27, 120, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("NOMBRE");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 69, 70, 20));

        txtNombrecliente.setEditable(false);
        jPanel2.add(txtNombrecliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 71, 220, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 129, 359, 100));

        tablaReserva.setModel(modelo1);
        jScrollPane1.setViewportView(tablaReserva);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 359, 160));

        tablaHabitaciones.setModel(modelo);
        tablaHabitaciones.setName(""); // NOI18N
        tablaHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaHabitacionesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaHabitaciones);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 327, 160));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Numero:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel6.setText("Costo:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 53, -1, -1));

        txtNumero.setEditable(false);
        txtNumero.setAutoscrolls(false);
        jPanel3.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 17, 118, -1));

        txtCostoHabitacion.setEditable(false);
        jPanel3.add(txtCostoHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 50, 118, -1));

        botAgregar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        botAgregar.setText("Agregar");
        botAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(botAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 100, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 480, 320, 80));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, 722, 10));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("HABITACIONES DISPONIBLES");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/background2-1024x640.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void botBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botBuscarClienteActionPerformed
        String dni = txtDniCliente.getText().trim();
        try {
            cliente = ReservaCN.getInstancia().buscarCliente(dni);
            if(cliente != null){
                txtNombrecliente.setText(cliente.getNombre() + " " + cliente.getApellidos());
            }else
                JOptionPane.showMessageDialog(rootPane, "Cliente no existe.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_botBuscarClienteActionPerformed

    private void botBuscarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botBuscarRecepcionistaActionPerformed
        String dni = txtdniRecepcionista.getText().trim();
        try {
            recepcionista = ReservaCN.getInstancia().buscarRecepcionista(dni);
            if(recepcionista != null){
                txtNombreRecepcionista.setText(recepcionista.getNombres()+ " " + recepcionista.getApellidos());
            }else
                JOptionPane.showMessageDialog(rootPane, "Recepcionista no existe.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_botBuscarRecepcionistaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String id = txtIdReserva.getText();
        double costototal = Double.parseDouble(txtCosto.getText());
        Reserva reserva = new Reserva(id, fecha, costototal, cliente, recepcionista);
        try {
            for(int i = 0 ;i < tablaReserva.getRowCount() ; i++){
                String habitacionid = (String) tablaReserva.getValueAt(i, 0);
                Habitacion habitacion = new Habitacion();
                habitacion.setEstado(Habitacion.ESTADO_OCUPADO);
                habitacion.setIdHabitacion(habitacionid);
                reserva.agregarHabitacion(habitacion);
            }
            ReservaCN.getInstancia().crearReserva(reserva);
            JOptionPane.showMessageDialog(rootPane, "Se registros los datos.");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tablaHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaHabitacionesMouseClicked
        capturar();
        txtNumero.setText("" + SELECCIONA_NUMERO);
        txtCostoHabitacion.setText("" + SELECCIONAR_COSTO);
    }//GEN-LAST:event_tablaHabitacionesMouseClicked

    private void botAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAgregarActionPerformed
        capturar();
        if(!datosIguales(SELECCIONA_ID)){
            agregar();
            txtCosto.setText("" + calcularCostoTotal());
        }
        
    }//GEN-LAST:event_botAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAgregar;
    private javax.swing.JButton botBuscarCliente;
    private javax.swing.JButton botBuscarRecepcionista;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaHabitaciones;
    private javax.swing.JTable tablaReserva;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtCostoHabitacion;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtFechaEntrada;
    private javax.swing.JTextField txtIdReserva;
    private javax.swing.JTextField txtNombreRecepcionista;
    private javax.swing.JTextField txtNombrecliente;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtdniRecepcionista;
    // End of variables declaration//GEN-END:variables
}
