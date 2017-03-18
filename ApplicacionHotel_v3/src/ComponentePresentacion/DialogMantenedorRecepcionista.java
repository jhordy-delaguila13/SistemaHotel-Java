/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentePresentacion;

import ComponenteEntidad.Recepcionista;
import ComponenteNegocio.RecepcionistaCN;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon; 
/**
 *
 * @author PRACTICAS-TESIS
 */
public class DialogMantenedorRecepcionista extends javax.swing.JDialog {

    /**
     * Creates new form DialogMantenedorRecepcionista
     */
    boolean registro;
    public DialogMantenedorRecepcionista(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        textos(false);
        setLocationRelativeTo(null);
        setSize(800,450);
    }

     public void limpiarTextos() {
        txtIdRecepcionista.setText("");
        txtDni.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
    }
    
    public void textos(boolean verdad) {
        txtIdRecepcionista.setEditable(verdad);
        txtDni.setEditable(verdad);
        txtNombre.setEditable(verdad);
        txtApellidos.setEditable(verdad);
        txtTelefono.setEditable(verdad);
        txtCorreo.setEditable(verdad);
        txtDireccion.setEditable(verdad);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtIdRecepcionista = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Vani", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RECEPCIONISTA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CORREO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 120, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 70, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("APELLIDOS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("idRecepcionista");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DIRECCION");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 80, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TELEFONO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 70, 20));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 210, -1));
        getContentPane().add(txtIdRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 70, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 210, -1));
        getContentPane().add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 210, -1));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 130, -1));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 210, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449578430_files-folders-04.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 140, 50));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449578263_preferences-contact-list.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 120, 50));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449578194_contact-new.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 140, 50));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1436819557_f-cross_256.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 140, 50));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449578379_document_delete.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 130, 50));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449578379_document_delete.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 120, 50));
        getContentPane().add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 210, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DNI");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 120, 20));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1436817581_Log Out.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 110, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449577957_Businessman.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 130, 130));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo-madera-negro.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
      if(txtIdRecepcionista.getText().compareTo("")!=0 && txtApellidos.getText().compareTo("")!=0 && txtNombre.getText().compareTo("")!=0
            && txtDireccion.getText().compareTo("")!=0 && txtTelefono.getText().compareTo("")!=0 ) {
        String id = txtIdRecepcionista.getText();
        String dni = txtDni.getText();
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();
        String direccion = txtDireccion.getText();
        Recepcionista recepcionista = new Recepcionista(id, nombre, apellidos, direccion, dni, telefono, correo);
        //textos(true);
        try {
            if (registro) {
                RecepcionistaCN.getInstancia().crearRecepcionista(recepcionista);
                JOptionPane.showMessageDialog(rootPane, "Se registro sus datos.");
                textos(false);
            } else {
                RecepcionistaCN.getInstancia().modificarRecepcionista(recepcionista);
                JOptionPane.showMessageDialog(rootPane, "Dato Modificado");
            }
            limpiarTextos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
      }else{
          JOptionPane.showMessageDialog(null,"faltan llenar datos");
      } 
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        registro = true;
        textos(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTextos();
        textos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String id = JOptionPane.showInputDialog("Id del Recepcionista: ");
        try {
            Recepcionista recepcionista = RecepcionistaCN.getInstancia().buscarRecepcionista(id);
            if (recepcionista != null) {
                txtIdRecepcionista.setText(recepcionista.getIdRecepcionista());
                txtDni.setText(recepcionista.getDNI());
                txtNombre.setText(recepcionista.getNombres());
                txtApellidos.setText(recepcionista.getApellidos());
                txtTelefono.setText(recepcionista.getTelefono());
                txtCorreo.setText(recepcionista.getCorreo());
                txtDireccion.setText(recepcionista.getDireccion());
                textos(true);
                txtIdRecepcionista.setEditable(false);
                registro = false; 
            }else
            {
                JOptionPane.showMessageDialog(rootPane, "Recepcionista no encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String id = JOptionPane.showInputDialog("Id del Recepcionista: ");
        try {
            Recepcionista recepcionista = RecepcionistaCN.getInstancia().buscarRecepcionista(id);
            if (recepcionista != null) {
                txtIdRecepcionista.setText(recepcionista.getIdRecepcionista());
                txtDni.setText(recepcionista.getDNI());
                txtNombre.setText(recepcionista.getNombres());
                txtApellidos.setText(recepcionista.getApellidos());
                txtTelefono.setText(recepcionista.getTelefono());
                txtCorreo.setText(recepcionista.getCorreo());
                txtDireccion.setText(recepcionista.getDireccion());
                textos(false);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Recepcionista no encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String id = JOptionPane.showInputDialog("Id del recepcionista: ");
        try {
           Recepcionista recepcionista = RecepcionistaCN.getInstancia().buscarRecepcionista(id);
            if (recepcionista != null) {
                txtIdRecepcionista.setText(recepcionista.getIdRecepcionista());
                txtDni.setText(recepcionista.getDNI());
                txtNombre.setText(recepcionista.getNombres());
                txtApellidos.setText(recepcionista.getApellidos());
                txtTelefono.setText(recepcionista.getTelefono());
                txtCorreo.setText(recepcionista.getCorreo());
                txtDireccion.setText(recepcionista.getDireccion());
                int respuesta = JOptionPane.showConfirmDialog(rootPane, "Deseas eliminar?", "Eliminar", JOptionPane.OK_CANCEL_OPTION);
                if (respuesta == JOptionPane.OK_OPTION) {
                    RecepcionistaCN.getInstancia().eliminarRecepcionista(recepcionista);
                }
                limpiarTextos();
                textos(false);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DialogMantenedorRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogMantenedorRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogMantenedorRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogMantenedorRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogMantenedorRecepcionista dialog = new DialogMantenedorRecepcionista(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtIdRecepcionista;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
