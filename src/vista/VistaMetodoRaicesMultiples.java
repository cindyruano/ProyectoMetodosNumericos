package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import vista.VistaRaicesMultiplesTablas;

/**
 *
 * @author cindy
 */
public class VistaMetodoRaicesMultiples extends javax.swing.JFrame {

    //Instancias de clase 
    private VistaRaicesMultiplesTablas vistaTablas;
    private DefaultTableModel modeloIntervalo1;
    private DefaultTableModel modeloIntervalo2;
    private DefaultTableModel modeloIntervalo3;
    private DefaultTableModel modeloIntervalo4;

    public VistaMetodoRaicesMultiples() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    //------------ MÉTODOS AUXILIARES ------------
    //PRIMERA DERIVADA
    private String formatDerivado(double coef, int pot) {
        if (pot == 0) {
            return String.valueOf(coef); //Se devuelve el mismo valor
        }
        if (pot == 1) {
            return coef + "x"; //No lleva exponente
        }
        return coef + "x^" + pot; //Devuelve el formato completo con potencias
    }

    //SEGUNDA DERIVADA 
    private String formatearDerivado(double coef, int pot) {
        String coefStr = (coef == (int) coef) ? String.valueOf((int) coef) : String.valueOf(coef); //Si es entero se mantiene entero, si es decimal como decimal
        if (pot == 0) {
            return coefStr; //Devuelve solo el coeficiente
        }
        if (pot == 1) {
            return coefStr + "x"; //Devuelve el coeficiente seguido de "x"
        }
        return coefStr + "x^" + pot; //Devuelve el término completo
    }

    //EVALUAR DERIVADAS 
    private double evaluarFuncion(double x) {
        double resultado = 0; //Inicializa la variable que almacenará la suma de los términos.
        resultado += Double.parseDouble(txtTermino1.getText()) * Math.pow(x, Integer.parseInt(txtPotencia1.getText())); //Lee coef y pot,los multiplica y se suman al resultado
        if (!txtTermino2.getText().trim().isEmpty() && !txtPotencia2.getText().trim().isEmpty()) {
            resultado += Double.parseDouble(txtTermino2.getText()) * Math.pow(x, Integer.parseInt(txtPotencia2.getText()));
        } //Verifica que el segundo término y potencia no estén vacíos. Si tienen se multiplican y se suman al resultado
        if (!txtTermino3.getText().trim().isEmpty()) {
            resultado += Double.parseDouble(txtTermino3.getText()); //Si hay un valor en termino 3, lo suma como un término constante (independiente de x).
        }
        return resultado; //Devuelve el resultado total de la evaluación de la función en x.
    }

    private double evaluarPrimeraDerivada(double x) {
        double resultado = 0; //Inicializa el acumulador para la suma de los términos derivados.
        double coef1 = Double.parseDouble(txtTermino1.getText());
        int pot1 = Integer.parseInt(txtPotencia1.getText()); //Lee coef y pot

        resultado += coef1 * pot1 * Math.pow(x, pot1 - 1); //Formula
        if (!txtTermino2.getText().trim().isEmpty() && !txtPotencia2.getText().trim().isEmpty()) {
            double coef2 = Double.parseDouble(txtTermino2.getText());
            int pot2 = Integer.parseInt(txtPotencia2.getText());
            resultado += coef2 * pot2 * Math.pow(x, pot2 - 1); //Si existe el 2 término y pot, hace el mismo proceso para el 2 término y + el resultado.
        }
        return resultado;
    }

    private double evaluarSegundaDerivada(double x) {
        double resultado = 0;
        double coef1 = Double.parseDouble(txtTermino1.getText());
        int pot1 = Integer.parseInt(txtPotencia1.getText());
        if (pot1 >= 2) { //Solo calcula la segunda derivada si la potencia es mayor o igual a 2
            resultado += coef1 * pot1 * (pot1 - 1) * Math.pow(x, pot1 - 2);
        }
        if (!txtTermino2.getText().trim().isEmpty() && !txtPotencia2.getText().trim().isEmpty()) {
            double coef2 = Double.parseDouble(txtTermino2.getText());
            int pot2 = Integer.parseInt(txtPotencia2.getText());
            if (pot2 >= 2) {
                resultado += coef2 * pot2 * (pot2 - 1) * Math.pow(x, pot2 - 2); 
            } //Si el 2 término y pot existen, hace el mismo cálculo para el 2 término y + al resultado.
        }
        return resultado;
    }

    //------------ DISEÑO TABLA ------------
    class ColorRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            try {
                double num = Double.parseDouble(value.toString().replace(",", "."));
                if (num < 0) {
                    c.setForeground(Color.RED);
                } else {
                    c.setForeground(Color.BLACK);
                }
            } catch (NumberFormatException ex) {
                c.setForeground(Color.BLACK);
            }
            return c;
        }
    }

    private void centrarColumnas(JTable tabla) {
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
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
        funcion = new javax.swing.JLabel();
        funcionDerivada = new javax.swing.JLabel();
        segundaFuncion = new javax.swing.JLabel();
        recurrencia = new javax.swing.JLabel();
        txtTermino1 = new javax.swing.JTextField();
        txtFuncionDerivada = new javax.swing.JTextField();
        txtSegundaDerivada = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIntervalos = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtVariable1 = new javax.swing.JTextField();
        txtSimPotencia1 = new javax.swing.JTextField();
        txtPotencia1 = new javax.swing.JTextField();
        txtTermino2 = new javax.swing.JTextField();
        txtVariable2 = new javax.swing.JTextField();
        txtTermino3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtIntervalos = new javax.swing.JTextArea();
        btnMostrarTablas = new javax.swing.JButton();
        txtSimPotencia2 = new javax.swing.JTextField();
        txtPotencia2 = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtIntervalo1 = new javax.swing.JTextField();
        txtIntervalo2 = new javax.swing.JTextField();
        txtIntervalo3 = new javax.swing.JTextField();
        txtIntervalo4 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtRecurrencia = new javax.swing.JTextArea();

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
        fondoPanel.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 620, 80, 30));

        btnRegresar.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        fondoPanel.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 620, 80, 30));

        btnResolver.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnResolver.setText("RESOLVER");
        btnResolver.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnResolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });
        fondoPanel.add(btnResolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 80, 30));

        funcion.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        funcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        funcion.setText("FUNCIÓN:");
        fondoPanel.add(funcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 70, -1));

        funcionDerivada.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        funcionDerivada.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        funcionDerivada.setText("FUNCIÓN DERIVADA:");
        fondoPanel.add(funcionDerivada, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 160, -1));

        segundaFuncion.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        segundaFuncion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        segundaFuncion.setText("II FUNCIÓN DERIVADA:");
        fondoPanel.add(segundaFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 160, -1));

        recurrencia.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        recurrencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        recurrencia.setText("RECURRENCIA:");
        fondoPanel.add(recurrencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, -1, -1));

        txtTermino1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtTermino1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fondoPanel.add(txtTermino1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 50, -1));

        txtFuncionDerivada.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtFuncionDerivada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuncionDerivadaActionPerformed(evt);
            }
        });
        fondoPanel.add(txtFuncionDerivada, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 100, -1));

        txtSegundaDerivada.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtSegundaDerivada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSegundaDerivadaActionPerformed(evt);
            }
        });
        fondoPanel.add(txtSegundaDerivada, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 100, -1));

        tblIntervalos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "x", "f(x)"
            }
        ));
        tblIntervalos.setToolTipText("");
        tblIntervalos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblIntervalos);

        fondoPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 260, 200));

        btnBuscar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        fondoPanel.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 80, 30));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel2.setText("INTERVALOS:");
        fondoPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, -1, -1));

        txtVariable1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtVariable1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVariable1.setText("x");
        fondoPanel.add(txtVariable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 30, -1));

        txtSimPotencia1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtSimPotencia1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSimPotencia1.setText("^");
        txtSimPotencia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSimPotencia1ActionPerformed(evt);
            }
        });
        fondoPanel.add(txtSimPotencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 30, 20));

        txtPotencia1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtPotencia1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fondoPanel.add(txtPotencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 30, 20));

        txtTermino2.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtTermino2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fondoPanel.add(txtTermino2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 50, -1));

        txtVariable2.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtVariable2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVariable2.setText("x");
        fondoPanel.add(txtVariable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 30, -1));

        txtTermino3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtTermino3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fondoPanel.add(txtTermino3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 50, -1));

        txtIntervalos.setColumns(20);
        txtIntervalos.setFont(new java.awt.Font("Gill Sans MT", 0, 16)); // NOI18N
        txtIntervalos.setRows(5);
        jScrollPane2.setViewportView(txtIntervalos);

        fondoPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 520, 170, 70));

        btnMostrarTablas.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnMostrarTablas.setText("MOSTRAR TABLAS");
        btnMostrarTablas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnMostrarTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTablasActionPerformed(evt);
            }
        });
        fondoPanel.add(btnMostrarTablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 560, 140, 30));

        txtSimPotencia2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtSimPotencia2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSimPotencia2.setText("^");
        fondoPanel.add(txtSimPotencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 30, 20));

        txtPotencia2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtPotencia2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fondoPanel.add(txtPotencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 30, 20));

        btnLimpiar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        fondoPanel.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 80, 30));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel3.setText("Ingrese los intervalos");
        fondoPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        txtIntervalo1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtIntervalo1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fondoPanel.add(txtIntervalo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 269, 260, -1));

        txtIntervalo2.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtIntervalo2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fondoPanel.add(txtIntervalo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 296, 260, -1));

        txtIntervalo3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtIntervalo3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fondoPanel.add(txtIntervalo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 323, 260, -1));

        txtIntervalo4.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        txtIntervalo4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIntervalo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIntervalo4ActionPerformed(evt);
            }
        });
        fondoPanel.add(txtIntervalo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 260, -1));

        txtRecurrencia.setColumns(20);
        txtRecurrencia.setFont(new java.awt.Font("Gill Sans MT", 0, 16)); // NOI18N
        txtRecurrencia.setRows(5);
        jScrollPane3.setViewportView(txtRecurrencia);

        fondoPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, 260, 100));

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

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        txtPotencia1.setText("");
        txtPotencia2.setText("");
        txtTermino1.setText("");
        txtTermino2.setText("");
        txtTermino3.setText("");
        txtSegundaDerivada.setText("");
        txtFuncionDerivada.setText("");
        txtIntervalos.setText("");
        txtIntervalo1.setText("");
        txtIntervalo2.setText("");
        txtIntervalo3.setText("");
        txtIntervalo4.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnMostrarTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTablasActionPerformed

        VistaRaicesMultiplesTablas vistaTablas = new VistaRaicesMultiplesTablas();

        if (modeloIntervalo1 != null) {
            vistaTablas.tblIntervalo1.setModel(modeloIntervalo1);
            centrarColumnas(vistaTablas.tblIntervalo1);
        }
        if (modeloIntervalo2 != null) {
            vistaTablas.tblIntervalo2.setModel(modeloIntervalo2);
            centrarColumnas(vistaTablas.tblIntervalo2);
        }
        if (modeloIntervalo3 != null) {
            vistaTablas.tblIntervalo3.setModel(modeloIntervalo3);
            centrarColumnas(vistaTablas.tblIntervalo3);
        }
        if (modeloIntervalo4 != null) {
            vistaTablas.tblIntervalo4.setModel(modeloIntervalo4);
            centrarColumnas(vistaTablas.tblIntervalo4);
        }

        vistaTablas.setVisible(true);
        vistaTablas.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnMostrarTablasActionPerformed

    private void txtSimPotencia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSimPotencia1ActionPerformed
    }//GEN-LAST:event_txtSimPotencia1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        //------------ INTERVALOS y VALOR f(x) ------------
        try {
            // Valores por defecto
            String potencia1 = txtPotencia1.getText().trim();
            int poten1 = Integer.parseInt(potencia1);

            String termino1 = txtTermino1.getText().trim();
            double term1 = Double.parseDouble(termino1);

            // Leer y validar segundo término (puede estar vacío)
            double coef2 = 0;
            int pot2 = 0;
            boolean tieneSegundoTermino = !txtTermino2.getText().trim().isEmpty() && !txtPotencia2.getText().trim().isEmpty();
            if (tieneSegundoTermino) {
                coef2 = Double.parseDouble(txtTermino2.getText().trim());
                pot2 = Integer.parseInt(txtPotencia2.getText().trim());
            }

            // Leer constante
            double constante = 0;
            if (!txtTermino3.getText().trim().isEmpty()) {
                constante = Double.parseDouble(txtTermino3.getText().trim());
            }

            // Modelo para la tabla
            DecimalFormat formato = new DecimalFormat("#.00");
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("x");
            modelo.addColumn("f(x)");

            //Muestra de intervalos
            Double fxAnterior = null;
            Integer xAnterior = null;
            List<String> intervalosCambio = new ArrayList<>();

            for (int x = 5; x >= -5; x--) {
                double fx = term1 * Math.pow(x, poten1);
                if (tieneSegundoTermino) {
                    fx += coef2 * Math.pow(x, pot2);
                }
                fx += constante;

                // Detectar cambio de signo entre valores consecutivos
                if (fxAnterior != null && (fxAnterior * fx < 0)) {
                    intervalosCambio.add("(" + x + ", " + xAnterior + ")");
                }

                fxAnterior = fx;
                xAnterior = x;

                modelo.addRow(new Object[]{x, formato.format(fx)});
            }

            // Asignar modelo
            tblIntervalos.setModel(modelo);
            tblIntervalos.setModel(modelo);

            // Mostrar en Text Area
            if (intervalosCambio.isEmpty()) {
                txtIntervalos.setText("No hay cambio de signo en los intervalos.");
            } else {
                txtIntervalos.setText("");
                for (String intervalo : intervalosCambio) {
                    txtIntervalos.append(intervalo + "\n");
                }
            }

            // Centrar columnas
            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
            centrado.setHorizontalAlignment(SwingConstants.CENTER);
            tblIntervalos.getColumnModel().getColumn(0).setCellRenderer(centrado);
            tblIntervalos.getColumnModel().getColumn(1).setCellRenderer(new ColorRenderer() {
                {
                    setHorizontalAlignment(SwingConstants.CENTER);
                }
            });

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese los valores correctamente: " + ex.getMessage());
        }

        //------------ DERIVADAS ------------
        try {
            // Leer datos del primer término
            double coef1 = Double.parseDouble(txtTermino1.getText().trim());
            int pot1 = Integer.parseInt(txtPotencia1.getText().trim());

            // Derivada del primer término: a·n·x^(n-1)
            double derCoef1 = coef1 * pot1;
            int derPot1 = pot1 - 1;

            //Segunda derivada primer término
            double segDerCoef1 = derCoef1 * derPot1;
            int segDerPot1 = derPot1 - 1;

            // Segundo término
            String termino2Str = txtTermino2.getText().trim(); // ej: "+3x" o "-2x"
            double coef2 = Double.parseDouble(termino2Str.replaceAll("[^\\d\\-\\.]", ""));
            int pot2 = Integer.parseInt(txtPotencia2.getText().trim());

            double derCoef2 = coef2 * pot2;
            int derPot2 = pot2 - 1;

            //Segunda derivada
            double segDerCoef2 = derCoef2 * derPot2;
            int segDerPot2 = derPot2 - 1;

            //Construcción de derivada
            StringBuilder primeraDerivada = new StringBuilder();
            StringBuilder segundaDerivada = new StringBuilder();

            // f'(x)
            if (derCoef1 != 0) {
                primeraDerivada.append(formatearDerivado(derCoef1, derPot1));
            }
            if (derCoef2 != 0) {
                if (derCoef2 > 0 && primeraDerivada.length() > 0) {
                    primeraDerivada.append("+");
                }
                primeraDerivada.append(formatearDerivado(derCoef2, derPot2));
            }

            // f''(x)
            if (segDerCoef1 != 0) {
                segundaDerivada.append(formatearDerivado(segDerCoef1, segDerPot1));
            }
            if (segDerCoef2 != 0) {
                if (segDerCoef2 > 0 && segundaDerivada.length() > 0) {
                    segundaDerivada.append("+");
                }
                segundaDerivada.append(formatearDerivado(segDerCoef2, segDerPot2));
            }

            // Mostrar resultados
            txtFuncionDerivada.setText(primeraDerivada.toString());
            txtSegundaDerivada.setText(segundaDerivada.toString());

        } catch (Exception ex) {
            txtFuncionDerivada.setText("Error");
            txtSegundaDerivada.setText("Error");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtSegundaDerivadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegundaDerivadaActionPerformed
    }//GEN-LAST:event_txtSegundaDerivadaActionPerformed

    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed

        try {
            double[] intervalos = new double[4]; //Declara un arreglo de 4 elementos
            JTextField[] campos = {txtIntervalo1, txtIntervalo2, txtIntervalo3, txtIntervalo4};
            DefaultTableModel[] modelos = new DefaultTableModel[4];
            StringBuilder resumenXr = new StringBuilder();

            for (int j = 0; j < 4; j++) { //Inicia un ciclo que va de 0 a 3
                if (!campos[j].getText().trim().isEmpty()) { //Verifica que el campo de texto del intervalo j no esté vacío
                    double xi = Double.parseDouble(campos[j].getText().trim()); //Convierte a decimal 
                    DefaultTableModel modeloTabla = new DefaultTableModel(); //Crea un nuevo modelo de tabla vacío que se usará para mostrar filas y columnas con los resultados.
                    modeloTabla.addColumn("i");
                    modeloTabla.addColumn("Xi");
                    modeloTabla.addColumn("f(Xi)");
                    modeloTabla.addColumn("f'(Xi)");
                    modeloTabla.addColumn("f''(Xi)");
                    modeloTabla.addColumn("Xr");
                    modeloTabla.addColumn("Tolerancia");

                    int i = 1; //Contador de iteraciones, inicia en 1
                    double xrAnterior = xi;
                    double tolerancia = 1;
                    DecimalFormat formato = new DecimalFormat("0.0000");

                    while (tolerancia > 0.0001) { //Se ejecuta mientras la diferencia entre aproximaciones sea mayor a 0.0001
                        double fx = evaluarFuncion(xi);
                        double f1x = evaluarPrimeraDerivada(xi);
                        double f2x = evaluarSegundaDerivada(xi);

                        //Formula
                        double xr = xi - ((fx * f1x) / ((Math.pow(f1x, 2)) - (fx * f2x)));

                        String tolTexto = (i == 0) ? "------" : formato.format(Math.abs(xr - xrAnterior)); //Primera tolerancia

                        modeloTabla.addRow(new Object[]{ //Añade una fila con estos datos:
                            i,
                            formato.format(xi),
                            formato.format(fx),
                            formato.format(f1x),
                            formato.format(f2x),
                            formato.format(xr),
                            tolTexto
                        });

                        //Actualizaciones 
                        tolerancia = Math.abs(xr - xrAnterior);
                        xrAnterior = xr;
                        xi = xr;
                        i++; //Incrementa el contador de iteraciones i.
                    }

                    modelos[j] = modeloTabla; //Guarda el modelo de tabla lleno con las iteraciones y resultados para el intervalo j dentro del arreglo modelos.
                    resumenXr.append("Intervalo ").append(j + 1).append(": ").append(formato.format(xrAnterior)).append("\n");
                }
            }

            // Guardar modelos
            modeloIntervalo1 = modelos[0];
            modeloIntervalo2 = modelos[1];
            modeloIntervalo3 = modelos[2];
            modeloIntervalo4 = modelos[3];

            // Mostrar última recurrencia
            txtRecurrencia.setText(resumenXr.toString());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al resolver: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnResolverActionPerformed

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

    private void txtIntervalo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIntervalo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIntervalo4ActionPerformed

    private void txtFuncionDerivadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFuncionDerivadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFuncionDerivadaActionPerformed

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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrarTablas;
    private javax.swing.JButton btnRegresar;
    public javax.swing.JButton btnResolver;
    private javax.swing.JPanel fondoPanel;
    private javax.swing.JLabel funcion;
    private javax.swing.JLabel funcionDerivada;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel recurrencia;
    private javax.swing.JLabel segundaFuncion;
    private javax.swing.JSeparator separador;
    private javax.swing.JTable tblIntervalos;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtFuncionDerivada;
    private javax.swing.JTextField txtIntervalo1;
    private javax.swing.JTextField txtIntervalo2;
    private javax.swing.JTextField txtIntervalo3;
    private javax.swing.JTextField txtIntervalo4;
    private javax.swing.JTextArea txtIntervalos;
    private javax.swing.JTextField txtPotencia1;
    private javax.swing.JTextField txtPotencia2;
    public javax.swing.JTextArea txtRecurrencia;
    private javax.swing.JTextField txtSegundaDerivada;
    private javax.swing.JTextField txtSimPotencia1;
    private javax.swing.JTextField txtSimPotencia2;
    private javax.swing.JTextField txtTermino1;
    private javax.swing.JTextField txtTermino2;
    private javax.swing.JTextField txtTermino3;
    private javax.swing.JTextField txtVariable1;
    private javax.swing.JTextField txtVariable2;
    // End of variables declaration//GEN-END:variables
}
