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

public class MetodoMuller {

    public double evaluarFuncion(String funcion, double x) {
        double resultado = 0;
        String[] terminos = funcion.split("(?=[+-])");

        for (String termino : terminos) {
            resultado += evaluarTermino(termino, x);
        }
        return resultado;
    }

    public static double evaluarTermino(String termino, double x) {
        if (termino.equals("x")) {
            return x;
        }
        if (termino.equals("-x")) {
            return -x;
        }
        if (termino.equals("+x")) {
            return x;
        }
        if (!termino.contains("x")) {
            return Double.parseDouble(termino);
        }

        String[] partes = termino.split("x\\^?");
        double coef = 1.0;
        int exp = 1;

        if (partes[0].isEmpty() || partes[0].equals("+")) {
            coef = 1.0;
        } else if (partes[0].equals("-")) {
            coef = -1.0;
        } else {
            coef = Double.parseDouble(partes[0]);
        }

        if (partes.length > 1 && !partes[1].isEmpty()) {
            exp = Integer.parseInt(partes[1]);
        }

        return coef * Math.pow(x, exp);
    }

    public List<String[]> metodoMullerTabla(String funcion, double x0, double x1, double x2, double tolerancia) {
        List<String[]> tabla = new ArrayList<>();
        int iter = 0;
        double xr = x2;
        double error = Double.MAX_VALUE; // Inicializar el error a un valor grande

        while (error >= tolerancia && iter < 100) {
            double f0 = evaluarFuncion(funcion, x0);
            double f1 = evaluarFuncion(funcion, x1);
            double f2 = evaluarFuncion(funcion, x2);
            double h1 = x1 - x0;
            double h2 = x2 - x1;
            double d1 = (f1 - f0) / h1;
            double d2 = (f2 - f1) / h2;
            double a = (d2 - d1) / (h2 + h1);
            double b = a * h2 + d2;
            double c = f2;

            double discriminante = Math.sqrt(b * b - 4 * a * c);
            double denom = Math.abs(b + discriminante) > Math.abs(b - discriminante) ? b + discriminante : b - discriminante;

            if (denom == 0) {
                break;
            }

            double dx = -2 * c / denom;
            double nuevo_xr = x2 + dx;
            error = Math.abs(dx);

            tabla.add(new String[]{
                String.valueOf(iter + 1),
                String.format("%.4f", x0),
                String.format("%.4f", x1),
                String.format("%.4f", x2),
                String.format("%.4f", f0),
                String.format("%.4f", f1),
                String.format("%.4f", f2),
                String.format("%.4f", h1),
                String.format("%.4f", h2),
                String.format("%.4f", d1),
                String.format("%.4f", d2),
                String.format("%.4f", a),
                String.format("%.4f", b),
                String.format("%.4f", c),
                String.format("%.4f", nuevo_xr), // La nueva aproximación es la "Tolerancia" mostrada
                String.format("%.4f", error) // El error actual
            });

            x0 = x1;
            x1 = x2;
            x2 = nuevo_xr;
            xr = nuevo_xr; // Actualizar la raíz aproximada
            iter++;
        }

        return tabla;
    }

    public double metodoMuller(String funcion, double x0, double x1, double x2, double tolerancia) {
        double xr = x2;
        double error = Double.MAX_VALUE;
        int iter = 0;

        while (error >= tolerancia && iter < 100) {
            double f0 = evaluarFuncion(funcion, x0);
            double f1 = evaluarFuncion(funcion, x1);
            double f2 = evaluarFuncion(funcion, x2);
            double h1 = x1 - x0;
            double h2 = x2 - x1;
            double d1 = (f1 - f0) / h1;
            double d2 = (f2 - f1) / h2;
            double a = (d2 - d1) / (h2 + h1);
            double b = a * h2 + d2;
            double c = f2;

            double discriminante = Math.sqrt(b * b - 4 * a * c);
            double denom = Math.abs(b + discriminante) > Math.abs(b - discriminante) ? b + discriminante : b - discriminante;

            if (denom == 0) {
                break;
            }

            double dx = -2 * c / denom;
            double nuevo_xr = x2 + dx;
            error = Math.abs(dx);
            xr = nuevo_xr;

            x0 = x1;
            x1 = x2;
            x2 = nuevo_xr;
            iter++;
        }
        return xr;
    }
}
