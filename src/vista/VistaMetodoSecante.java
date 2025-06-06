package vista;

import controladores.ControladorSecante;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author cindy
 */
public class VistaMetodoSecante extends javax.swing.JFrame {

    /**
     * Creates new form VistaMetodoSecante
     */
    public VistaMetodoSecante() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JTextField getTxtFuncion() {
        return txtFuncion;
    }

    public JTextField getTxtXi_1() {
        return txtXi_1;
    }

    public JTextField getTxtXi() {
        return txtXi;
    }

    public JTextField getTxtRecurrencia() {
        return txtRecurrencia;
    }

    public JTable getTblTablaSecante() {
        return tblTablaSecante;
    }

    public JButton getBtnResolver() {
        return btnResolver;
    }

    public JLabel getXi() {
        return xi;
    }

    public JLabel getXi_1() {
        return xi_1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoPanel = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        funcion = new javax.swing.JLabel();
        xi_1 = new javax.swing.JLabel();
        xi = new javax.swing.JLabel();
        recurrencia = new javax.swing.JLabel();
        txtFuncion = new javax.swing.JTextField();
        txtXi_1 = new javax.swing.JTextField();
        txtXi = new javax.swing.JTextField();
        txtRecurrencia = new javax.swing.JTextField();
        tblMetodoSecante = new javax.swing.JScrollPane();
        tblTablaSecante = new javax.swing.JTable();
        btnResolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondoPanel.setBackground(new java.awt.Color(157, 174, 202));
        fondoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        fondoPanel.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 240, 80, 30));

        btnInicio.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnInicio.setText("INICIO");
        btnInicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        fondoPanel.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 240, 80, 30));

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/imagen 90.png"))); // NOI18N
        fondoPanel.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1150, -1));

        titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("MÉTODO SECANTE");
        fondoPanel.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1150, -1));

        separador.setBackground(new java.awt.Color(255, 255, 255));
        separador.setForeground(new java.awt.Color(255, 255, 255));
        separador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        separador.setOpaque(true);
        fondoPanel.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 127, 290, -1));

        funcion.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        funcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        funcion.setText("FUNCIÓN:");
        fondoPanel.add(funcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 160, -1));

        xi_1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        xi_1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xi_1.setText("Xi_1:");
        fondoPanel.add(xi_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 160, -1));

        xi.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        xi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xi.setText("Xi :");
        fondoPanel.add(xi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 160, -1));

        recurrencia.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        recurrencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        recurrencia.setText("RECURRENCIA:");
        fondoPanel.add(recurrencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, -1, -1));

        txtFuncion.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuncionActionPerformed(evt);
            }
        });
        fondoPanel.add(txtFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 260, -1));

        txtXi_1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtXi_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXi_1ActionPerformed(evt);
            }
        });
        fondoPanel.add(txtXi_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 170, -1));

        txtXi.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtXi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXiActionPerformed(evt);
            }
        });
        fondoPanel.add(txtXi, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 170, -1));

        txtRecurrencia.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtRecurrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecurrenciaActionPerformed(evt);
            }
        });
        fondoPanel.add(txtRecurrencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 230, -1));

        tblTablaSecante.setBackground(new java.awt.Color(192, 197, 196));
        tblTablaSecante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "i", "Xi_1", "Xi", "f(Xi_1)", "f(Xi)", "Xr", "Tolerancia"
            }
        ));
        tblMetodoSecante.setViewportView(tblTablaSecante);

        fondoPanel.add(tblMetodoSecante, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 890, 300));

        btnResolver.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnResolver.setText("RESOLVER");
        btnResolver.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnResolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });
        fondoPanel.add(btnResolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        VistaMetodoAbierto vi = new VistaMetodoAbierto();
        vi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        VistaInicio vi = new VistaInicio();
        vi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void txtXiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXiActionPerformed

    private void txtFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFuncionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFuncionActionPerformed

    private void txtXi_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXi_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXi_1ActionPerformed

    private void txtRecurrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecurrenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecurrenciaActionPerformed

    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed
        ControladorSecante controlador = new ControladorSecante(this);
        controlador.resolverSecante(); // TODO add your handling code here:
    }//GEN-LAST:event_btnResolverActionPerformed

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
            java.util.logging.Logger.getLogger(VistaMetodoSecante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMetodoSecante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMetodoSecante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMetodoSecante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMetodoSecante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnResolver;
    private javax.swing.JPanel fondoPanel;
    private javax.swing.JLabel funcion;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel recurrencia;
    private javax.swing.JSeparator separador;
    private javax.swing.JScrollPane tblMetodoSecante;
    private javax.swing.JTable tblTablaSecante;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtFuncion;
    private javax.swing.JTextField txtRecurrencia;
    private javax.swing.JTextField txtXi;
    private javax.swing.JTextField txtXi_1;
    private javax.swing.JLabel xi;
    private javax.swing.JLabel xi_1;
    // End of variables declaration//GEN-END:variables
}
