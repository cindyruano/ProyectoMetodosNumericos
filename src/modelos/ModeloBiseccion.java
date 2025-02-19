package modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import proyectometodosnumericos.metodoBiseccion;

/**
 *
 * @author cindy
 */
public class ModeloBiseccion {

    List<Double> funcion;

    //DATOS
    public ModeloBiseccion() {
        this.funcion = new ArrayList<>();
    }

    public void setFuncion(double[] nuevosDatos) {
        funcion.clear();
        for (double dato : nuevosDatos) {
            funcion.add(dato);
        }
    }
    // Método para evaluar la función en un punto x

    public double evaluarFuncion(String funcion, double x) {
        // Aquí puedes implementar la lógica para evaluar la función en x
        // Por ejemplo, usando una librería como exp4j o implementando un parser de expresiones
        return x * x - 4; // Ejemplo simple: f(x) = x^2 - 4
    }

    public List<String[]> biseccionTabla(String funcion, double a, double b, double tolerancia) {
        List<String[]> tabla = new ArrayList<>();
        // Implementa el método de bisección aquí
        // Este es un ejemplo básico, debes adaptarlo a tus necesidades
        double fa = evaluarFuncion(funcion, a);
        double fb = evaluarFuncion(funcion, b);
        double xr = (a + b) / 2;
        double fxr = evaluarFuncion(funcion, xr);

        tabla.add(new String[]{"1", String.valueOf(a), String.valueOf(b), String.valueOf(fa), String.valueOf(fb), String.valueOf(xr), String.valueOf(fxr), String.valueOf(tolerancia)});

        return tabla;
    }

    //FUNCIÓN
    /*public class Polinomio {

        private double f1, f2, f3, f4, f5;

        public Polinomio(double f1, double f2, double f3, double f4, double f5) {
            this.f1 = f1;
            this.f2 = f2;
            this.f3 = f3;
            this.f4 = f4;
            this.f5 = f5;
        }

//        public double calcularValor(double x) {
//            return f1 * Math.pow(x, 4) + f2 * Math.pow(x, 3) + f3 * Math.pow(x, 2) + f4 * x + f5;
//        }
    }

    //A
//    public double CalcularA() {
//        Collections.sort(funcion);
//    }*/
}
