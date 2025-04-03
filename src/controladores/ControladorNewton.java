/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.ModeloNewton;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author cindy
 */
public class ControladorNewton {

    private ModeloNewton funcion;
    private DefaultTableModel modeloTabla;

    public ControladorNewton(ModeloNewton funcion, DefaultTableModel modeloTabla) {
        this.funcion = funcion;
        this.modeloTabla = modeloTabla;
    }

    public String calcularDerivada() {
        return funcion.obtenerDerivada();
    }

    public void llenarTabla(double xi) {
        modeloTabla.setRowCount(0); // Limpia la tabla

        for (int i = 1; i <= 10; i++) {
            double nuevoXi = xi + i;
            double resultadoFuncion = funcion.calcularResultadoFuncion(nuevoXi);
            double resultadoDerivada = funcion.calcularResultadoDerivada(nuevoXi);

            modeloTabla.addRow(new Object[]{i, nuevoXi, resultadoFuncion, resultadoDerivada});
        }
    }
}

