/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponentePresentacion;

import componenteReporte.ReporteClientes;
import componenteReporte.ReporteComprobantePago;
import componenteReporte.ReporteRecepcionista;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rita
 */


public class FrmPrincipal extends javax.swing.JFrame {
    
    /**
     * Creates new form FrmPrincipal
     */
    private static FrmPrincipal instancia;
    public static FrmPrincipal getInstancia() {
        if(instancia==null){
            instancia = new FrmPrincipal();
        }
        return instancia;
    }
    public FrmPrincipal() {
        //setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        setLocationRelativeTo(null);
        setSize(950,650);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel");
        setBackground(new java.awt.Color(204, 204, 255));
        setName("frmPrincipal"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1436819557_f-cross_256.png"))); // NOI18N
        jButton1.setText("SALIR");
        jButton1.setToolTipText("SALIR");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 130, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/HOTEL.PNG.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 550));

        jMenu2.setBorder(null);
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449575527_TechnicalSupportRepresentative_Male_Light.png"))); // NOI18N
        jMenu2.setText("Recepcionista");
        jMenu2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449579432_Add-Male-User.png"))); // NOI18N
        jMenuItem1.setText("Mantenedor Recepcionista");
        jMenuItem1.setToolTipText("REGISTRAR AL RECEPCIONISTA");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1436817213_system-search.png"))); // NOI18N
        jMenuItem2.setText("Buscar Recepcionista");
        jMenuItem2.setToolTipText("BUSCAR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem6.setText("Reporte Recepcionista");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu1.setBorder(null);
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449575404_Customer_Male_Light.png"))); // NOI18N
        jMenu1.setText("Clientes");
        jMenu1.setToolTipText("");
        jMenu1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449576739_user-group-new.png"))); // NOI18N
        jMenuItem3.setText("Mantenedor Cliente");
        jMenuItem3.setToolTipText("REGISTRAR AL CLIENTE");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1436817213_system-search.png"))); // NOI18N
        jMenuItem4.setText("Buscar Cliente");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Reporte Clientes");
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449575667_ic_local_hotel_48px.png"))); // NOI18N
        jMenu3.setText("Habitacion");
        jMenu3.setToolTipText("REGISTRAR HABITACION");
        jMenu3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449577261_application-pgp-signature.png"))); // NOI18N
        jMenuItem5.setText("Mantenedor Habitacion");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449577320_aiga_hotel_information.png"))); // NOI18N
        jMenuItem7.setText("Agregar Categorias de Habitaciones");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449576641_editor-document-file-2-outline-stroke.png"))); // NOI18N
        jMenu5.setText("Reserva");
        jMenu5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449577564_document_text_add.png"))); // NOI18N
        jMenuItem11.setText("Mantenedor Rerva");
        jMenuItem11.setToolTipText("HACER UNA RESERVA");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449579143_show_property.png"))); // NOI18N
        jMenuItem12.setText("Mostrar Reservas");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1436822258_pdf.png"))); // NOI18N
        jMenu6.setText("Comprobante de pago");
        jMenu6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1449577424_vector_65_07.png"))); // NOI18N
        jMenuItem15.setText("Reporte Comprobante de pago");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DialogMantenedorRecepcionista dialogMantenedorRecepcionista = new DialogMantenedorRecepcionista(this, true);
        dialogMantenedorRecepcionista.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        DialogMantenedorCliente dialogMantenedorCliente = new DialogMantenedorCliente(this, true);
        dialogMantenedorCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        DialogMantenedorReserva dialogMantenedorReserva = new DialogMantenedorReserva(this, true);
        dialogMantenedorReserva.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
         dialogMostrarDatosCliente dialogDatosCliente = new dialogMostrarDatosCliente(this, true);
         dialogDatosCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        DialogMostrarDatosRecepcionista dialogMostrarDatosRecepcionista = new DialogMostrarDatosRecepcionista(this, true);
        dialogMostrarDatosRecepcionista.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        DialogCategoria dialogCategoria = new DialogCategoria(this, true);
        dialogCategoria.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        DialogMantenedorHabitacion dialogMantenedorHabitacion = new DialogMantenedorHabitacion(this, true);
        dialogMantenedorHabitacion.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        DialogMostrarReservas mostrarReservas = new DialogMostrarReservas(this, true);
        mostrarReservas.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
        try {
            ReporteClientes reporteClientes = new ReporteClientes();
            reporteClientes.runReporteClientes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        
        try {
            ReporteRecepcionista reporteRecepcionista = new ReporteRecepcionista();
            reporteRecepcionista.runReporteRecepcionista();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        
        JaspReporteComprobantePago comprobantePago = new JaspReporteComprobantePago(this, true);
        comprobantePago.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    // End of variables declaration//GEN-END:variables
}
