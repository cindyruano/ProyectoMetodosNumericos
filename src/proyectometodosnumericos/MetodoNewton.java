/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectometodosnumericos;

/**
 *
 * @author luisd
 */
import java.util.ArrayList;
import java.util.List;
import static proyectometodosnumericos.metodoBiseccion.evaluarTermino;

public class MetodoNewton {
    // Evaluar la función

      // Evaluar la función
    public static double evaluarFuncion(String funcion, double x) {
        double resultado = 0;
        String[] terminos = funcion.split("(?=[+-])"); // Dividir la función en términos

        for (String termino : terminos) {
            resultado += evaluarTermino(termino, x); // Evaluar cada término
        }
        return resultado;
    }

    // Evaluar la derivada de la función
    public static double evaluarDerivada(String funcion, double x) {
        double resultado = 0;
        String[] terminos = funcion.split("(?=[+-])"); // Dividir la función en términos

        for (String termino : terminos) {
            resultado += evaluarDerivadaTermino(termino, x); // Evaluar cada término
        }
        return resultado;
    }

    // Evaluar un término individual (función)
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

    // Evaluar un término individual para la derivada
    public static double evaluarDerivadaTermino(String termino, double x) {
        // Manejar términos como "x", "-x", "+x"
        if (termino.equals("x") || termino.equals("+x")) {
            return 1.0;
        } else if (termino.equals("-x")) {
            return -1.0;
        }

        // Si no contiene "x", es una constante
        if (!termino.contains("x")) {
            return 0.0; // La derivada de una constante es 0
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

        // La derivada de ax^n es a*n*x^(n-1)
        return coeficiente * exponente * Math.pow(x, exponente - 1);
    }

    // Método para derivar simbólicamente la función
    public static String derivarFuncion(String funcion) {
        StringBuilder derivada = new StringBuilder();
        String[] terminos = funcion.split("(?=[+-])"); // Dividir manteniendo signos

        for (String termino : terminos) {
            String terminoDerivado = derivarTermino(termino);
            if (!terminoDerivado.isEmpty()) {
                if (derivada.length() > 0 && !terminoDerivado.startsWith("-")) {
                    derivada.append("+");
                }
                derivada.append(terminoDerivado);
            }
        }
        if (derivada.length() == 0) {
            return "0";
        }
        return derivada.toString();
    }

    // Derivar término individual
    private static String derivarTermino(String termino) {
        termino = termino.trim();

        // Casos especiales "x", "-x", "+x"
        if (termino.equals("x")) {
            return "1";
        } else if (termino.equals("+x")) {
            return "1";
        } else if (termino.equals("-x")) {
            return "-1";
        }

        // Si no contiene 'x', es constante y su derivada es 0
        if (!termino.contains("x")) {
            return "";
        }

        // Dividir coeficiente y exponente
        String[] partes = termino.split("x\\^?");
        String coefStr = partes[0];
        if (coefStr.isEmpty()) coefStr = "1";
        else if (coefStr.equals("+")) coefStr = "1";
        else if (coefStr.equals("-")) coefStr = "-1";
        double coeficiente = Double.parseDouble(coefStr);

        int exponente = 1;
        if (partes.length > 1 && !partes[1].isEmpty()) {
            exponente = Integer.parseInt(partes[1]);
        }

        // Derivada coeficiente * exponente
        double nuevoCoef = coeficiente * exponente;
        int nuevoExp = exponente - 1;

        StringBuilder resultado = new StringBuilder();
        // Formatear signo
        if (nuevoCoef > 0) {
            resultado.append("+");
        }
        if (nuevoCoef == 1 && nuevoExp != 0) {
            // Omitir coef 1
        } else if (nuevoCoef == -1 && nuevoExp != 0) {
            resultado.append("-");
        } else {
            // Para evitar que muestre como -0.0 o 0.0
            if(nuevoCoef == (int)nuevoCoef) {
                resultado.append((int)nuevoCoef);
            } else {
                resultado.append(nuevoCoef);
            }
        }

        if (nuevoExp == 0) {
            // Exponente 0 significa que es constante (x^0=1)
            if (nuevoCoef == 1 || nuevoCoef == -1) {
                resultado.append("1");
            }
        } else if (nuevoExp == 1) {
            resultado.append("x");
        } else {
            resultado.append("x^").append(nuevoExp);
        }

        String derivTerm = resultado.toString();
        // If derivTerm starts with + remove it if it's the first term
        if (derivTerm.startsWith("+")) {
            derivTerm = derivTerm.substring(1);
        }

        return derivTerm;
    }

    // Método de Newton-Raphson
    public static double newtonRaphson(String funcion, double x0, double tolerancia, int maxIteraciones) {
        double x = x0;
        for (int i = 0; i < maxIteraciones; i++) {
            double fx = evaluarFuncion(funcion, x);
            double dfx = evaluarDerivada(funcion, x);

            if (Math.abs(dfx) < 1e-10) {
                throw new ArithmeticException("La derivada es cero. No se puede continuar.");
            }

            double xNuevo = x - fx / dfx;

            if (Math.abs(xNuevo - x) < tolerancia) {
                return xNuevo; // Se ha encontrado la raíz
            }

            x = xNuevo;
        }
        throw new RuntimeException("No se encontró la raíz en el número máximo de iteraciones.");
    }

    // Método para obtener los datos de Newton-Raphson en una tabla
    public static List<String[]> newtonRaphsonTabla(String funcion, double x0, double tolerancia, int maxIteraciones) {
        List<String[]> tabla = new ArrayList<>();
        double x = x0;

        for (int i = 0; i < maxIteraciones; i++) {
            double fx = evaluarFuncion(funcion, x);
            double dfx = evaluarDerivada(funcion, x);

            if (Math.abs(dfx) < 1e-10) {
                throw new ArithmeticException("La derivada es cero. No se puede continuar.");
            }

            double xNuevo = x - fx / dfx;

            // Redondear a 4 decimales
            String fxStr = String.format("%.4f", fx);
            String dfxStr = String.format("%.4f", dfx);
            String xNuevoStr = String.format("%.4f", xNuevo);
            String toleranciaStr = String.format("%.4f", Math.abs(xNuevo - x));

            // Agregar fila a la tabla
            tabla.add(new String[]{
                String.valueOf(i + 1),
                String.format("%.4f", x),
                fxStr,
                dfxStr,
                xNuevoStr,
                toleranciaStr
            });

            if (Math.abs(xNuevo - x) < tolerancia) {
                break; // Se ha encontrado la raíz
            }

            x = xNuevo;
        }
        return tabla;
    }

    // Método para imprimir la tabla
    public static void imprimirTabla(List<String[]> tabla) {
        for (String[] fila : tabla) {
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s%n", fila[0], fila[1], fila[2], fila[3], fila[4], fila[5]);
        }
    }
}