package proyectometodosnumericos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author luisd
 */
public class metodoReglaFalsa {

    // Método para evaluar una función matemática en un punto x
    public double evaluarFuncion(String funcion, double x) {
        double resultado = 0;
        String[] terminos = funcion.split("(?=[+-])"); // Divide la función en términos

        for (String termino : terminos) {
            resultado += evaluarTermino(termino, x); // Evalúa cada término
        }
        return resultado;
    }

    // Método para evaluar un término individual de la función
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

    // Método de la Regla Falsa para encontrar una raíz
    public double reglaFalsa(String funcion, double a, double b, double tolerancia) {
        if (tolerancia <= 0) {
            tolerancia = 0.0001; // Tolerancia predeterminada si no se proporciona
        }

        double fa = evaluarFuncion(funcion, a);
        double fb = evaluarFuncion(funcion, b);

        // Verificar que la función cambie de signo en el intervalo [a, b]
        if (fa * fb >= 0) {
            throw new IllegalArgumentException("La función no cambia de signo en el intervalo [" + a + ", " + b + "].");
        }

        double c = 0;
        int maxIteraciones = 1000; // Límite máximo de iteraciones
        int iteracion = 0;

        // Bucle principal del método de la Regla Falsa
        while (Math.abs(b - a) > tolerancia && iteracion < maxIteraciones) {
            c = (a * fb - b * fa) / (fb - fa); // Calcular el nuevo punto c
            double fc = evaluarFuncion(funcion, c);

            if (fc == 0) {
                break; // Si fc es cero, hemos encontrado la raíz exacta
            }

            // Actualizar el intervalo [a, b]
            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }

            iteracion++;
        }

        // Verificar si se alcanzó el límite de iteraciones
        if (iteracion >= maxIteraciones) {
            throw new RuntimeException("El método no convergió después de " + maxIteraciones + " iteraciones.");
        }

        // Redondear el resultado a 4 decimales
        return Math.round(c * 10000.0) / 10000.0;
    }

    // Método para generar una tabla de iteraciones de la Regla Falsa
    public List<String[]> reglaFalsaTabla(String funcion, double a, double b, double toleranciaFinal) {
        if (toleranciaFinal <= 0) {
            toleranciaFinal = 0.0001; // Tolerancia predeterminada si no se proporciona
        }

        List<String[]> tabla = new ArrayList<>();
        double fa = evaluarFuncion(funcion, a);
        double fb = evaluarFuncion(funcion, b);

        // Verificar que la función cambie de signo en el intervalo [a, b]
        if (fa * fb >= 0) {
            throw new IllegalArgumentException("La función no cambia de signo en el intervalo [" + a + ", " + b + "].");
        }

        int iteracion = 1;
        double Xr_anterior = 0; // Valor de Xr de la iteración anterior
        double toleranciaActual = 1.0000; // Tolerancia inicial para la primera iteración

        // Bucle principal para generar la tabla
        while (toleranciaActual > toleranciaFinal) {
            double Xr = (a * fb - b * fa) / (fb - fa); // Calcular el nuevo punto Xr
            double fc = evaluarFuncion(funcion, Xr);

            // Calcular la tolerancia como la diferencia entre Xr actual y Xr anterior
            if (iteracion > 1) {
                toleranciaActual = Math.abs(Xr - Xr_anterior);
            }

            // Redondear los valores a 4 decimales
            String faStr = String.format("%.4f", fa);
            String fbStr = String.format("%.4f", fb);
            String fcStr = String.format("%.4f", fc);
            String XrStr = String.format("%.4f", Xr);
            String toleranciaStr = String.format("%.4f", toleranciaActual);

            // Agregar fila a la tabla
            tabla.add(new String[]{
                String.valueOf(iteracion),
                String.format("%.4f", a),
                String.format("%.4f", b),
                faStr,
                fbStr,
                XrStr,
                fcStr,
                toleranciaStr
            });

            // Condición de parada adicional: |f(c)| < toleranciaFinal
            if (Math.abs(fc) < toleranciaFinal) {
                break;
            }

            // Actualizar el intervalo [a, b]
            if (fa * fc < 0) {
                b = Xr;
                fb = fc;
            } else {
                a = Xr;
                fa = fc;
            }

            // Actualizar Xr_anterior para la próxima iteración
            Xr_anterior = Xr;
            iteracion++;
        }
        return tabla;
    }

    // Método para imprimir la tabla de iteraciones
    public static void imprimirTabla(List<String[]> tabla) {
        for (String[] fila : tabla) {
            System.out.printf("%-10s %-10s%n", fila[0], fila[1]);
        }
    }
}
