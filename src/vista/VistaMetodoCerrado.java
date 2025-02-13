package vista;

import javax.swing.JFrame;

/**
 *
 * @author cindy
 */
public class VistaMetodoCerrado extends javax.swing.JFrame {

    /**
     * Creates new form VistaMetodoCerrado
     */
    public VistaMetodoCerrado() {
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
        pregunta = new javax.swing.JLabel();
        btnMetodoBiseccion = new javax.swing.JButton();
        btnMetodoReglaFalsa = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondoPanel.setBackground(new java.awt.Color(157, 174, 202));
        fondoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/imagen 200.png"))); // NOI18N
        fondoPanel.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1150, -1));

        titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("MÉTODOS CERRADOS");
        fondoPanel.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1150, -1));

        separador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        separador.setOpaque(true);
        fondoPanel.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 277, 350, -1));

        pregunta.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        pregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pregunta.setText("Seleccione el tipo de métodos cerrados a realizar.");
        fondoPanel.add(pregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 1150, -1));

        btnMetodoBiseccion.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnMetodoBiseccion.setText("MÉTODO BISECCIÓN");
        btnMetodoBiseccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnMetodoBiseccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMetodoBiseccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMetodoBiseccionActionPerformed(evt);
            }
        });
        fondoPanel.add(btnMetodoBiseccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 230, 40));

        btnMetodoReglaFalsa.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnMetodoReglaFalsa.setText("MÉTODO REGLA FALSA");
        btnMetodoReglaFalsa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnMetodoReglaFalsa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMetodoReglaFalsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMetodoReglaFalsaActionPerformed(evt);
            }
        });
        fondoPanel.add(btnMetodoReglaFalsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 230, 40));

        btnRegresar.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        fondoPanel.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 620, 110, 30));

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

    private void btnMetodoBiseccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMetodoBiseccionActionPerformed
        VistaMetodoBiseccion  vi  = new VistaMetodoBiseccion();
        vi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMetodoBiseccionActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        VistaInicio vi = new VistaInicio();
        vi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnMetodoReglaFalsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMetodoReglaFalsaActionPerformed
        VistaMetodoReglaFalsa vi = new VistaMetodoReglaFalsa();
        vi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMetodoReglaFalsaActionPerformed

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
            java.util.logging.Logger.getLogger(VistaMetodoCerrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMetodoCerrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMetodoCerrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMetodoCerrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMetodoCerrado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMetodoBiseccion;
    private javax.swing.JButton btnMetodoReglaFalsa;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel fondoPanel;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel pregunta;
    private javax.swing.JSeparator separador;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
