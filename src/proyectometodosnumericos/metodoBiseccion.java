package proyectometodosnumericos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author luisd
 */
public class metodoBiseccion {

    // Evaluar la función
    public static double evaluarFuncion(String funcion, double x) {
        double resultado = 0;
        String[] terminos = funcion.split("(?=[+-])"); // Dividir la función en términos

        for (String termino : terminos) {
            resultado += evaluarTermino(termino, x); // Evaluar cada término
        }
        return resultado;
    }

    // Evaluar un término individual (ejemplo: 5x, -2x^3, 7x^2, etc.)
    public static double evaluarTermino(String termino, double x) {
        // Manejar términos como "x", "-x", "+x"
        if (termino.equals("x")) {
            return x;
        } else if (termino.equals("-x")) {
            return -x;
        } else if (termino.equals("+x")) {
            return x;
        }

        // Si no contiene "x", es una constante
        if (!termino.contains("x")) {
            return Double.parseDouble(termino);
        }

        // Dividir el término en coeficiente y exponente
        String[] partes = termino.split("x\\^?");
        double coeficiente = 1.0;
        int exponente = 1;

        // Manejar el coeficiente
        if (partes[0].isEmpty() || partes[0].equals("+")) {
            coeficiente = 1.0;
        } else if (partes[0].equals("-")) {
            coeficiente = -1.0;
        } else {
            coeficiente = Double.parseDouble(partes[0]);
        }

        // Manejar el exponente
        if (partes.length > 1 && !partes[1].isEmpty()) {
            exponente = Integer.parseInt(partes[1]);
        }
        return coeficiente * Math.pow(x, exponente);
    }

    // Método de bisección con tolerancia predeterminada
    public static double biseccion(String funcion, double a, double b, double tolerancia) {
        if (tolerancia <= 0) {
            tolerancia = 0.0001; // Establecer tolerancia predeterminada si no se proporciona
        }

        double fa = evaluarFuncion(funcion, a);
        double fb = evaluarFuncion(funcion, b);
        double c = 0;

        if (fa * fb >= 0) {
            throw new IllegalArgumentException("La función no cambia de signo en el intervalo [" + a + ", " + b + "].");
        }

        while (Math.abs(b - a) > tolerancia) {
            c = (a + b) / 2;
            double fc = evaluarFuncion(funcion, c);

            if (fc == 0) {
                break;
            }

            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
        }
        return c;
    }

    // Método para obtener los datos de la bisección en una tabla con tolerancia predeterminada
    public static List<String[]> biseccionTabla(String funcion, double a, double b, double toleranciaFinal) {
        if (toleranciaFinal <= 0) {
            toleranciaFinal = 0.0001; // Establecer tolerancia final predeterminada si no se proporciona
        }

        List<String[]> tabla = new ArrayList<>();
        double fa = evaluarFuncion(funcion, a);
        double fb = evaluarFuncion(funcion, b);

        if (fa * fb >= 0) {
            throw new IllegalArgumentException("La función no cambia de signo en el intervalo [" + a + ", " + b + "].");
        }

        int iteracion = 1;
        double toleranciaActual = Math.abs(b - a); // Tolerancia inicial

        while (toleranciaActual > toleranciaFinal) {
            double c = (a + b) / 2;
            double fc = evaluarFuncion(funcion, c);

            // Redondear a 4 decimales
            String faStr = String.format("%.4f", fa);
            String fbStr = String.format("%.4f", fb);
            String fcStr = String.format("%.4f", fc);
            String cStr = String.format("%.4f", c);
            String toleranciaStr = String.format("%.4f", toleranciaActual);

            // Agregar fila a la tabla
            tabla.add(new String[]{
                String.valueOf(iteracion),
                String.format("%.4f", a),
                String.format("%.4f", b),
                faStr,
                fbStr,
                cStr,
                fcStr,
                toleranciaStr
            });

            if (fc == 0) {
                break;
            }

            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }

            // Actualizar la tolerancia actual
            toleranciaActual = Math.abs(b - a);
            iteracion++;
        }
        return tabla;
    }

    // Método para generar una tabla de valores de Y
    public static List<String[]> generarTabla(String funcion, double inicio, double fin, double paso) {
        List<String[]> tabla = new ArrayList<>();

        // Encabezado de la tabla
        tabla.add(new String[]{"x", "Y"});

        // Generar valores de x y Y
        for (double x = inicio; x <= fin; x += paso) {
            double y = evaluarFuncion(funcion, x);
            tabla.add(new String[]{
                String.format("%.4f", x),
                String.format("%.4f", y)
            });
        }
        return tabla;
    }

    // Método para imprimir la tabla
    public static void imprimirTabla(List<String[]> tabla) {
        for (String[] fila : tabla) {
            System.out.printf("%-10s %-10s%n", fila[0], fila[1]);
        }
    }
}
