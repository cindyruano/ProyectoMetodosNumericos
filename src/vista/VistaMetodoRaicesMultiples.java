package vista;

import javax.swing.JFrame;

/**
 *
 * @author cindy
 */
public class VistaMetodoRaicesMultiples extends javax.swing.JFrame {

    /**
     * Creates new form VistaMetodoRaicesMultiples
     */
    public VistaMetodoRaicesMultiples() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
        imagen = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        btnInicio = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnResolver = new javax.swing.JButton();
        tblTablaRaicesMultiples = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        funcion = new javax.swing.JLabel();
        funcionDerivada = new javax.swing.JLabel();
        segundaFuncion = new javax.swing.JLabel();
        recurrencia = new javax.swing.JLabel();
        txtFuncion = new javax.swing.JTextField();
        txtFuncionDerivada = new javax.swing.JTextField();
        txtSegundaDerivada = new javax.swing.JTextField();
        txtRecurrencia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondoPanel.setBackground(new java.awt.Color(157, 174, 202));
        fondoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/imagen 90.png"))); // NOI18N
        fondoPanel.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1150, -1));

        titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("MÉTODO RAICES MÚLTIPLES");
        fondoPanel.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1150, -1));

        separador.setBackground(new java.awt.Color(255, 255, 255));
        separador.setForeground(new java.awt.Color(255, 255, 255));
        separador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        separador.setOpaque(true);
        fondoPanel.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 127, 410, -1));

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

        btnResolver.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnResolver.setText("RESOLVER");
        btnResolver.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnResolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fondoPanel.add(btnResolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 80, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "i", "Xi", "f(Xi)", "f'(x)", "f''(x)", "Xr", "Tolerancia"
            }
        ));
        tblTablaRaicesMultiples.setViewportView(jTable1);

        fondoPanel.add(tblTablaRaicesMultiples, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 890, 300));

        funcion.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        funcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        funcion.setText("FUNCIÓN:");
        fondoPanel.add(funcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 160, -1));

        funcionDerivada.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        funcionDerivada.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        funcionDerivada.setText("FUNCIÓN DERIVADA:");
        fondoPanel.add(funcionDerivada, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 160, -1));

        segundaFuncion.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        segundaFuncion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        segundaFuncion.setText("II FUNCIÓN DERIVADA:");
        fondoPanel.add(segundaFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 160, -1));

        recurrencia.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        recurrencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        recurrencia.setText("RECURRENCIA:");
        fondoPanel.add(recurrencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, -1, -1));

        txtFuncion.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        fondoPanel.add(txtFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 260, -1));

        txtFuncionDerivada.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        fondoPanel.add(txtFuncionDerivada, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 170, -1));

        txtSegundaDerivada.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtSegundaDerivada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSegundaDerivadaActionPerformed(evt);
            }
        });
        fondoPanel.add(txtSegundaDerivada, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 170, -1));

        txtRecurrencia.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        fondoPanel.add(txtRecurrencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 230, -1));

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

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        VistaInicio vi = new VistaInicio();
        vi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        VistaMetodoAbierto vi = new VistaMetodoAbierto();
        vi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtSegundaDerivadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegundaDerivadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSegundaDerivadaActionPerformed

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
            java.util.logging.Logger.getLogger(VistaMetodoRaicesMultiples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMetodoRaicesMultiples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMetodoRaicesMultiples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMetodoRaicesMultiples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMetodoRaicesMultiples().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnResolver;
    private javax.swing.JPanel fondoPanel;
    private javax.swing.JLabel funcion;
    private javax.swing.JLabel funcionDerivada;
    private javax.swing.JLabel imagen;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel recurrencia;
    private javax.swing.JLabel segundaFuncion;
    private javax.swing.JSeparator separador;
    private javax.swing.JScrollPane tblTablaRaicesMultiples;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtFuncion;
    private javax.swing.JTextField txtFuncionDerivada;
    private javax.swing.JTextField txtRecurrencia;
    private javax.swing.JTextField txtSegundaDerivada;
    // End of variables declaration//GEN-END:variables
}
