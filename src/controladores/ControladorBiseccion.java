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

            JOptionPane.showMessageDialog(vista, "Método de Bisección completado.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Error: Formato de número inválido. Usa punto (.) como separador decimal.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error: " + e.getMessage());
        }
    }
}
