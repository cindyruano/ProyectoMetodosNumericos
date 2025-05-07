/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectometodosnumericos.MetodoSecante;
import vista.VistaMetodoSecante;

/**
 *
 * @author luisd
 */
public class ControladorSecante {

    private VistaMetodoSecante vista;  // Vista (Interfaz gráfica) donde se encuentran los campos de entrada y la tabla
    private MetodoSecante secante;

    public ControladorSecante(VistaMetodoSecante vista) {
        this.vista = vista;
        this.secante = new MetodoSecante();
    }

    public void resolverSecante() {
        try {
            String funcion = vista.getTxtFuncion().getText().trim();
            double x0 = Double.parseDouble(vista.getTxtXi_1().getText().replace(",", "."));
            double x1 = Double.parseDouble(vista.getTxtXi().getText().replace(",", "."));

            double toleranciaFinal = 0.0001; // Tolerancia final deseada
            int maxIteraciones = 100; // Número máximo de iteraciones

            // Llamada al método de secante para obtener la tabla de iteraciones
            List<String[]> tabla = secante.secanteTabla(funcion, x0, x1, toleranciaFinal, maxIteraciones);

            // Obtener el modelo de la tabla y llenarlo con los datos
            DefaultTableModel model = (DefaultTableModel) vista.getTblTablaSecante().getModel();
            model.setRowCount(0); // Limpiar la tabla

            // Llenar la tabla con los datos del método secante
            for (String[] fila : tabla) {
                model.addRow(fila);
            }

            // Obtener la respuesta final (última fila de la tabla)
            String[] ultimaFila = tabla.get(tabla.size() - 1);
            String respuestaFinal = ultimaFila[5]; // El valor de X2 (raíz aproximada) está en la columna 5

            // Mostrar la respuesta final en txtRecurrencia
            vista.getTxtRecurrencia().setText(respuestaFinal);

            JOptionPane.showMessageDialog(vista, "Método Secante completado.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Error: Formato de número inválido. Usa punto (.) como separador decimal.");
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(vista, "Error: " + e.getMessage());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(vista, "Error: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error inesperado: " + e.getMessage());
        }
    }
}