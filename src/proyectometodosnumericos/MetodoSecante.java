/*0
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectometodosnumericos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisd
 */
public class MetodoSecante {

    // Evaluar la función (mismo método que en Newton)
    public static double evaluarFuncion(String funcion, double x) {
        double resultado = 0;
        String[] terminos = funcion.split("(?=[+-])"); // Dividir la función en términos

        for (String termino : terminos) {
            resultado += evaluarTermino(termino.trim(), x); // Evaluar cada término
        }
        return resultado;
    }

    // Evaluar un término individual (igual que en Newton)
    public static double evaluarTermino(String termino, double x) {
        if (termino.equals("x")) return x;
        if (termino.equals("-x")) return -x;
        if (termino.equals("+x")) return x;

        if (!termino.contains("x")) {
            return Double.parseDouble(termino);
        }

        String[] partes = termino.split("x\\^?");
        double coef = partes[0].isEmpty() || partes[0].equals("+") ? 1.0 : 
                     partes[0].equals("-") ? -1.0 : Double.parseDouble(partes[0]);
        
        int exponente = partes.length > 1 && !partes[1].isEmpty() ? 
                       Integer.parseInt(partes[1]) : 1;

        return coef * Math.pow(x, exponente);
    }

    // Método Secante principal
    public static double secante(String funcion, double x0, double x1, double tolerancia, int maxIteraciones) {
        double fx0 = evaluarFuncion(funcion, x0);
        double fx1 = evaluarFuncion(funcion, x1);
        double error = Double.POSITIVE_INFINITY;
        int iteracion = 0;
        double x2 = 0;

        while (error > tolerancia && iteracion < maxIteraciones) {
            if (Math.abs(fx1 - fx0) < 1e-12) {
                throw new ArithmeticException("División por cero en el método de la secante");
            }

            x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);
            error = Math.abs(x2 - x1);

            x0 = x1;
            fx0 = fx1;
            x1 = x2;
            fx1 = evaluarFuncion(funcion, x1);
            iteracion++;
        }

        if (iteracion >= maxIteraciones) {
            throw new RuntimeException("No se encontró la raíz en el número máximo de iteraciones.");
        }

        return x2;
    }

    // Método para obtener los datos del método secante en una tabla
    public static List<String[]> secanteTabla(String funcion, double x0, double x1, double tolerancia, int maxIteraciones) {
        List<String[]> tabla = new ArrayList<>();
        double fx0 = evaluarFuncion(funcion, x0);
        double fx1 = evaluarFuncion(funcion, x1);
        double error = Double.POSITIVE_INFINITY;
        int iteracion = 0;

        while (error > tolerancia && iteracion < maxIteraciones) {
            if (Math.abs(fx1 - fx0) < 1e-12) {
                throw new ArithmeticException("División por cero en iteración " + iteracion);
            }

            double x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);
            error = Math.abs(x2 - x1);

            // Formatear el error como número decimal completo
            String errorFormateado;
            if (error < 0.001) {
                // Para valores muy pequeños, mostrar más decimales
                errorFormateado = String.format("%.4f", error).replaceAll("0*$", "").replaceAll("\\.$", "");
            } else {
                errorFormateado = String.format("%.4f", error);
            }

            tabla.add(new String[]{
                String.valueOf(iteracion + 1),
                String.format("%.4f", x0),
                String.format("%.4f", x1),
                String.format("%.4f", fx0),
                String.format("%.4f", fx1),
                String.format("%.4f", x2),
                errorFormateado
            });

            x0 = x1;
            fx0 = fx1;
            x1 = x2;
            fx1 = evaluarFuncion(funcion, x1);
            iteracion++;
        }

        return tabla;
    }

    // Método para imprimir la tabla
    public static void imprimirTabla(List<String[]> tabla) {
        System.out.println("-----------------------------------------------------------------------------");
        for (String[] fila : tabla) {
            if (fila.length == 7) { // Para las filas de datos
                System.out.printf("%-10s %-12s %-12s %-12s %-12s %-12s %-12s%n", 
                    fila[0], fila[1], fila[2], fila[3], fila[4], fila[5], fila[6]);
            }
        }
    }
}