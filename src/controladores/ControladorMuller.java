/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import proyectometodosnumericos.MetodoMuller;
import vista.VistaMetodoMuller;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ControladorMuller {

    private final VistaMetodoMuller vista;
    private final MetodoMuller modelo;
    private final double toleranciaFija = 0.001; // Definimos la tolerancia fija

    // Constructor that receives the view
    public ControladorMuller(VistaMetodoMuller vista) {
        this.vista = vista;
        this.modelo = new MetodoMuller();
    }

    public void resolverMetodoMuller() {
        try {
            // Validate that all fields have data (except recurrencia, ya que lo vamos a usar para mostrar el resultado)
            if (vista.getTxtFuncion().getText().isEmpty() ||
                vista.getTxtX0().getText().isEmpty() ||
                vista.getTxtX1().getText().isEmpty() ||
                vista.getTxtX2().getText().isEmpty()) {

                JOptionPane.showMessageDialog(vista,
                        "Los campos de función, X0, X1 y X2 son requeridos",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Get values from the view
            String funcion = vista.getTxtFuncion().getText().trim();
            double x0 = Double.parseDouble(vista.getTxtX0().getText());
            double x1 = Double.parseDouble(vista.getTxtX1().getText());
            double x2 = Double.parseDouble(vista.getTxtX2().getText());

            // Execute the Muller method and get the table data
            List<String[]> resultadosTabla = modelo.metodoMullerTabla(funcion, x0, x1, x2, toleranciaFija);
            mostrarResultados(resultadosTabla);

            // Execute the Muller method to get the final root
            double raiz = modelo.metodoMuller(funcion, x0, x1, x2, toleranciaFija);

            // Mostrar la raíz en el campo de recurrencia
            vista.getTxtRecurrencia().setText(String.format("%.4f", raiz));

            JOptionPane.showMessageDialog(vista,
                    "La raíz aproximada es: " + String.format("%.4f", raiz),
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista,
                    "Error en formato numérico: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(vista,
                    "Error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(vista,
                    "Error aritmético: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista,
                    "Error inesperado: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void mostrarResultados(List<String[]> datos) {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"i", "x0", "x1", "x2", "f(x0)", "f(x1)", "f(x2)", "h0", "h1", "d0", "d1", "a", "b", "c", "x3", "Tolerancia"}, 0);

        for (String[] fila : datos) {
            // Modificamos la última columna para que siempre muestre la tolerancia fija
            fila[15] = String.format("%.4f", toleranciaFija);
            model.addRow(fila);
        }

        vista.getTableResultados().setModel(model);
    }
}