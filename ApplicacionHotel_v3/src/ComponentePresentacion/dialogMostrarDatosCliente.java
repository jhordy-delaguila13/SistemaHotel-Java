package ComponentePresentacion;

import ComponenteEntidad.Cliente;
import ComponenteNegocio.ClienteCN;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dialogMostrarDatosCliente extends javax.swing.JDialog {
    
    DefaultTableModel modelo = new DefaultTableModel();
    String nombreColumna[] = {"Codigo","dni","nombre","apellido","Direccion","telefono","nacionalidad"};
    public dialogMostrarDatosCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setSize(865,535);
        
        modelo.setColumnIdentifiers(nombreColumna);
        buscar();
    }
    
    public void buscar(){
        String nombre = txtNombre.getText();
        try {
            List<Cliente> clientes = ClienteCN.getInstancia().listadoClientes(nombre);
            Object datos[][] = new Object[clientes.size()][7];
            for(int i = 0 ; i < clientes.size(); i++){
                Cliente cliente = clientes.get(i);
                datos[i][0] = cliente.getIdCliente();
                datos[i][1] = cliente.getDNI();
                datos[i][2] = cliente.getNombre();
                datos[i][3] = cliente.getApellidos();
                datos[i][4] = cliente.getDireccion();
                datos[i][5] = cliente.getTelefono();
                datos[i][6] = cliente.getNacionalidad();
            }
            modelo.setDataVector(datos, nombreColumna);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaChoferes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        botBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setTitle("Listado de Choferes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaChoferes.setModel(modelo);
        jScrollPane1.setViewportView(tablaChoferes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 630, 247));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTADO DE Clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 120, 20));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 163, -1));

        botBuscar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        botBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1436817213_system-search.png"))); // NOI18N
        botBuscar.setText("Buscar");
        botBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(botBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 85, 120, 40));

        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1436817581_Log Out.png"))); // NOI18N
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 130, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/background-wooden-pictures-wallpapers.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_botBuscarActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        buscar();
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaChoferes;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
