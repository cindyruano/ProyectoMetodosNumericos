package controladores;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ModeloBiseccion;
import proyectometodosnumericos.metodoBiseccion;
import vista.VistaMetodoBiseccion;

/**
 *
 * @author cindy
 */
public class ControladorBiseccion {

    private VistaMetodoBiseccion vista;  // Vista (Interfaz gráfica) donde se encuentran los campos de entrada y la tabla
    private metodoBiseccion biseccion;

    public ControladorBiseccion(VistaMetodoBiseccion vista) {
        this.vista = vista;

    }

    public void resolverBiseccion() {
        try {
            String funcion = vista.getTxtFuncion().getText().trim();
            double a = Double.parseDouble(vista.getTxtIntervaloA().getText().replace(",", "."));
            double b = Double.parseDouble(vista.getTxtIntervaloB().getText().replace(",", "."));

            if (a >= b) {
                JOptionPane.showMessageDialog(vista, "Error: El intervalo A debe ser menor que el intervalo B.");
                return;
            }

            double toleranciaFinal = 0.0001; // Tolerancia final deseada

            // Llamada al método de bisección para obtener la tabla de iteraciones
            List<String[]> tabla = metodoBiseccion.biseccionTabla(funcion, a, b, toleranciaFinal);

            // Obtener el modelo de la tabla y llenarlo con los datos
            DefaultTableModel model = (DefaultTableModel) vista.getTblBiseccion().getModel();
            model.setRowCount(0); // Limpiar la tabla

            // Llenar la tabla con los datos de la bisección
            for (String[] fila : tabla) {
                model.addRow(fila);
            }

            // Obtener la respuesta final (última fila de la tabla)
            String[] ultimaFila = tabla.get(tabla.size() - 1);
            String respuestaFinal = ultimaFila[5]; // El valor de Xr (raíz aproximada) está en la columna 5

            // Mostrar la respuesta final en txtRecurrencia
            vista.getTxtRecurrencia().setText(respuestaFinal);

            JOptionPane.showMessageDialog(vista, "Bisección completada.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Error: Formato de número inválido. Usa punto (.) como separador decimal.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error: " + e.getMessage());
        }
    }
}
//
//    public class PolinomioCalculadora {
//
//        private static JTextField campoF1, campoF2, campoF3, campoF4, campoF5;
//        private static JTextField campoX;
//        private static JLabel resultadoLabel;
//
//        public static void main(String[] args) {
//            JFrame frame = new JFrame("Calculadora de Polinomios");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(400, 300);
//            frame.setLayout(null);
//
//            JLabel labelF1 = new JLabel("Coeficiente 1:");
//            labelF1.setBounds(10, 10, 100, 25);
//            frame.add(labelF1);
//
//            campoF1 = new JTextField();
//            campoF1.setBounds(120, 10, 250, 25);
//            frame.add(campoF1);
//
//            JLabel labelF2 = new JLabel("Coeficiente 2:");
//            labelF2.setBounds(10, 50, 100, 25);
//            frame.add(labelF2);
//
//            campoF2 = new JTextField();
//            campoF2.setBounds(120, 50, 250, 25);
//            frame.add(campoF2);
//
//            JLabel labelF3 = new JLabel("Coeficiente 3:");
//            labelF3.setBounds(10, 90, 100, 25);
//            frame.add(labelF3);
//
//            campoF3 = new JTextField();
//            campoF3.setBounds(120, 90, 250, 25);
//            frame.add(campoF3);
//
//            JLabel labelF4 = new JLabel("Coeficiente 4:");
//            labelF4.setBounds(10, 130, 100, 25);
//            frame.add(labelF4);
//
//            campoF4 = new JTextField();
//            campoF4.setBounds(120, 130, 250, 25);
//            frame.add(campoF4);
//
//            JLabel labelF5 = new JLabel("Coeficiente 5:");
//            labelF5.setBounds(10, 170, 100, 25);
//            frame.add(labelF5);
//
//            campoF5 = new JTextField();
//            campoF5.setBounds(120, 170, 250, 25);
//            frame.add(campoF5);
//
//            JLabel labelX = new JLabel("Valor de x:");
//            labelX.setBounds(10, 210, 100, 25);
//            frame.add(labelX);
//
//            campoX = new JTextField();
//            campoX.setBounds(120, 210, 250, 25);
//            frame.add(campoX);
//
//            JButton botonResolver = new JButton("Resolver");
//            botonResolver.setBounds(150, 250, 100, 30);
//            frame.add(botonResolver);
//
//            resultadoLabel = new JLabel("Resultado: ");
//            resultadoLabel.setBounds(10, 290, 360, 25);
//            frame.add(resultadoLabel);
//
//            botonResolver.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    resolverPolinomio();
//                }
//            });
//
//            frame.setVisible(true);
//        }
//
//        private static void resolverPolinomio() {
//            try {
//                double f1 = Double.parseDouble(campoF1.getText());
//                double f2 = Double.parseDouble(campoF2.getText());
//                double f3 = Double.parseDouble(campoF3.getText());
//                double f4 = Double.parseDouble(campoF4.getText());
//                double f5 = Double.parseDouble(campoF5.getText());
//                double x = Double.parseDouble(campoX.getText());
//
//                Polinomio polinomio = new Polinomio(f1, f2, f3, f4, f5);
//                double resultado = polinomio.calcularValor(x);
//                resultadoLabel.setText("Resultado: " + resultado);
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(null, "Por favor, ingresa valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//    public void resolver() {
//
//        try {
//
//            String[] funcionTexto = vista.txtFuncion.getText().split(", ");
//            double[] funcion = new double[funcionTexto.length];
//            for (int i = 0; i < funcionTexto.length; i++) {
//                funcion[i] = Double.parseDouble(funcionTexto[i]);
//            }
//
//            modelo.setFuncion(funcion);
//
//            double A = modelo.CalcularRango();
//            double B = modelo.CalculoDesviacionTipica();
//            double f(a
//            ) = modelo.CalculoDesviacionMedias();
//            double f(b) = modelo.;
//            double Xr
//                    = double f(Xr)
//                    = double tolerancia
//                    = vista.tblNoAgrupados.setValueAt(rango, 0, 0);
//            vista.tblNoAgrupados.setValueAt(desviacionMedia, 0, 1);
//            vista.tblNoAgrupados.setValueAt(desviacionTipica, 0, 2);
//        } catch (Exception ex) {
//
//            JOptionPane.showMessageDialog(vista, "No puede estar ningun campo vacio ni agregar letras solo numeros");
//        }
//    }
//
//    
//        try {
//            String funcion = txtFuncion.getText().trim();
//        double a = Double.parseDouble(txtIntervaloA.getText().replace(",", ".")); // Reemplazar coma por punto
//        double b = Double.parseDouble(txtIntervaloB.getText().replace(",", ".")); // Reemplazar coma por punto
//
//        if (a >= b) {
//            JOptionPane.showMessageDialog(this, "Error: El intervalo A debe ser menor que el intervalo B.");
//            return;
//        }
//
//        double toleranciaFinal = 0.0001; // Tolerancia final deseada
//
//        // Obtener los datos de la bisección en una tabla
//        List<String[]> tabla = metodoBiseccion.biseccionTabla(funcion, a, b, toleranciaFinal);
//
//        // Obtener el modelo de la tabla
//        DefaultTableModel model = (DefaultTableModel) tblBiseccion.getModel();
//        model.setRowCount(0); // Limpiar la tabla
//
//        // Llenar la tabla con los datos obtenidos
//        for (String[] fila : tabla) {
//            model.addRow(fila);
//        }
//
//        // Generar la tabla de valores de Y
//        generarTabla(funcion, a, b, 0.5); // Paso de 0.5 para la tabla de valores
//
//        JOptionPane.showMessageDialog(this, "Bisección completada.");
//    }
//    catch (NumberFormatException e
//
//    
//        ) {
//            JOptionPane.showMessageDialog(this, "Error: Formato de número inválido. Usa punto (.) como separador decimal.");
//    }
//    catch (Exception e
//
//    
//        ) {
//            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
//    }
//}
//}
