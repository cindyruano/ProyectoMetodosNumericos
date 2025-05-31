/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cindy
 */
public class VistaRaicesMultiplesTablas extends javax.swing.JFrame {

    /**
     * Creates new form VistaRaicesMultiplesTablas
     */
    public VistaRaicesMultiplesTablas() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    //Métodos setters
    public void setModeloIntervalo1(DefaultTableModel modelo) {
        tblIntervalo1.setModel(modelo);
    }

    public void setModeloIntervalo2(DefaultTableModel modelo) {
        tblIntervalo2.setModel(modelo);
    }

    public void setModeloIntervalo3(DefaultTableModel modelo) {
        tblIntervalo3.setModel(modelo);
    }

    public void setModeloIntervalo4(DefaultTableModel modelo) {
        tblIntervalo4.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIntervalo4 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblIntervalo1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblIntervalo2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblIntervalo3 = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondoPanel.setBackground(new java.awt.Color(157, 174, 202));
        fondoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/imagen 90.png"))); // NOI18N
        fondoPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 60, 1150, -1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RAICES MÚLTIPLES");
        fondoPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1150, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jSeparator1.setOpaque(true);
        fondoPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 157, 310, -1));

        tblIntervalo4.setBackground(new java.awt.Color(192, 197, 196));
        tblIntervalo4.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        tblIntervalo4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "i", "Xi", "f(Xi)", "f'(Xi)", "f''(Xi)", "Xr", "Tolerancia"
            }
        ));
        jScrollPane1.setViewportView(tblIntervalo4);

        fondoPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 390, -1, 130));

        tblIntervalo1.setBackground(new java.awt.Color(192, 197, 196));
        tblIntervalo1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        tblIntervalo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "i", "Xi", "f(Xi)", "f'(Xi)", "f''(Xi)", "Xr", "Tolerancia"
            }
        ));
        jScrollPane2.setViewportView(tblIntervalo1);

        fondoPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 260, 450, 110));

        tblIntervalo2.setBackground(new java.awt.Color(192, 197, 196));
        tblIntervalo2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        tblIntervalo2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "i", "Xi", "f(Xi)", "f'(Xi)", "f''(Xi)", "Xr", "Tolerancia"
            }
        ));
        jScrollPane3.setViewportView(tblIntervalo2);

        fondoPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 450, 110));

        tblIntervalo3.setBackground(new java.awt.Color(192, 197, 196));
        tblIntervalo3.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        tblIntervalo3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "i", "Xi", "f(Xi)", "f'(Xi)", "f''(Xi)", "Xr", "Tolerancia"
            }
        ));
        jScrollPane4.setViewportView(tblIntervalo3);

        fondoPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 450, 130));

        btnRegresar.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        fondoPanel.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 530, 80, 30));

        btnInicio.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnInicio.setText("INICIO");
        btnInicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        fondoPanel.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 530, 80, 30));

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
        VistaMetodoRaicesMultiples vi = new VistaMetodoRaicesMultiples();
        vi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        VistaInicio vi = new VistaInicio();
        vi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnInicioActionPerformed

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
            java.util.logging.Logger.getLogger(VistaRaicesMultiplesTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRaicesMultiplesTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRaicesMultiplesTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRaicesMultiplesTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRaicesMultiplesTablas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnRegresar;
    public javax.swing.JPanel fondoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable tblIntervalo1;
    public javax.swing.JTable tblIntervalo2;
    public javax.swing.JTable tblIntervalo3;
    public javax.swing.JTable tblIntervalo4;
    // End of variables declaration//GEN-END:variables
}
