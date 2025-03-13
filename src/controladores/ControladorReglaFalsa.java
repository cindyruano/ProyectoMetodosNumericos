/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import proyectometodosnumericos.metodoReglaFalsa;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.VistaMetodoReglaFalsa;

public class ControladorReglaFalsa {

    private metodoReglaFalsa reglaFalsa;
    private VistaMetodoReglaFalsa vista;

    public ControladorReglaFalsa(VistaMetodoReglaFalsa vista) {
        this.vista = vista;
        this.reglaFalsa = new metodoReglaFalsa(); // Inicializar la instancia de metodoReglaFalsa
    }

    public void resolverFalsa() {
        try {
            String funcion = vista.getTxtFuncion().getText().trim();
            double a = Double.parseDouble(vista.getTxtIntervaloA().getText().replace(",", "."));
            double b = Double.parseDouble(vista.getTxtIntervaloB().getText().replace(",", "."));

            if (a >= b) {
                JOptionPane.showMessageDialog(vista, "Error: El intervalo A debe ser menor que el intervalo B.");
                return;
            }

            double toleranciaFinal = 0.0001; // Tolerancia final deseada

            // Llamada al método de regla falsa para obtener la tabla de iteraciones
            List<String[]> tabla = reglaFalsa.reglaFalsaTabla(funcion, a, b, toleranciaFinal);

            // Obtener la JTable desde el JScrollPane
            JTable table = (JTable) vista.getTblTablaReglaFalsa().getViewport().getView();

            // Obtener el modelo de la tabla y limpiarlo
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Limpiar la tabla

            // Llenar la tabla con los datos de la regla falsa
            for (String[] fila : tabla) {
                model.addRow(fila);
            }

            // Obtener la respuesta final (última fila de la tabla)
            String[] ultimaFila = tabla.get(tabla.size() - 1);
            String respuestaFinal = ultimaFila[5]; // El valor de Xr (raíz aproximada) está en la columna 5

            // Mostrar la respuesta final en txtRecurrencia
            vista.getTxtRecurrencia().setText(respuestaFinal);

            JOptionPane.showMessageDialog(vista, "Método de Regla Falsa completado.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Error: Formato de número inválido. Usa punto (.) como separador decimal.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(vista, "Error: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error inesperado: " + e.getMessage());
        }
    }
}
