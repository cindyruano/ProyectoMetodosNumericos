/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ModeloNewton;
import proyectometodosnumericos.MetodoNewton;
import vista.VistaMetodoNewton;

/**
 *
 * @author cindy
 */
public class ControladorNewton {

    private VistaMetodoNewton vista;  // Vista (Interfaz gráfica) donde se encuentran los campos de entrada y la tabla
    private MetodoNewton metodoNewton;

    public ControladorNewton(VistaMetodoNewton vista) {
        this.vista = vista;
        this.metodoNewton = new MetodoNewton();
    }
    
    

    public void resolverNewton() {
        try {
            String funcion = vista.getTxtFuncion().getText().trim();
            double xi = Double.parseDouble(vista.getTxtXi().getText().replace(",", "."));
            String funcionDerivada = vista.getTxtFuncionDerivada().getText().trim();
            double tolerancia = 0.0001; // Tolerancia final deseada
            int maxIteraciones = 100; // Número máximo de iteraciones

            // Llamada al método de Newton-Raphson para obtener la tabla de iteraciones
            List<String[]> tabla = metodoNewton.newtonRaphsonTabla(funcion, xi, tolerancia, maxIteraciones);

            // Obtener el modelo de la tabla y llenarlo con los datos
            DefaultTableModel model = (DefaultTableModel) vista.getTblTablaNewton().getModel();
            model.setRowCount(0); // Limpiar la tabla

            // Llenar la tabla con los datos de Newton-Raphson
            for (String[] fila : tabla) {
                model.addRow(fila);
            }

            // Obtener la respuesta final (última fila de la tabla)
            String[] ultimaFila = tabla.get(tabla.size() - 1);
            String respuestaFinal = ultimaFila[4]; // El valor de Xr (raíz aproximada) está en la columna 4

            // Mostrar la respuesta final en txtRecurrencia
            vista.getTxtRecurrencia().setText(respuestaFinal);

            JOptionPane.showMessageDialog(vista, "Método de Newton completado.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Error: Formato de número inválido. Usa punto (.) como separador decimal.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error: " + e.getMessage());
        }
    }
}
