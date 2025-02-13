/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocandy;

import java.util.Scanner;

/**
 *
 * @author luisd
 */
public class metodoReglaFalsa {

    Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        System.out.print("Ingrese la función (ejemplo: 5x + 4x^3 - x^4 + 3x^2): ");
        String funcion = scanner.nextLine().replace(" ", "");

        System.out.print("Ingrese el valor de a (inicio del intervalo): ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el valor de b (fin del intervalo): ");
        double b = scanner.nextDouble();

        System.out.print("Ingrese la tolerancia (ejemplo: 0.0001): ");
        double tolerancia = scanner.nextDouble();

        double fa = evaluarFuncion(funcion, a);
        double fb = evaluarFuncion(funcion, b);

        if (fa * fb >= 0) {
            System.out.println("Error: La función no cambia de signo en el intervalo [" + a + ", " + b + "].");
            return;
        }

        double raiz = reglaFalsa(funcion, a, b, tolerancia);
        System.out.println("La raíz aproximada es: " + raiz);
    }

    public double evaluarFuncion(String funcion, double x) {
        double resultado = 0;
        String[] terminos = funcion.split("(?=[+-])");

        for (String termino : terminos) {
            resultado += evaluarTermino(termino, x);
        }
        return resultado;
    }

    public double evaluarTermino(String termino, double x) {
        if (!termino.contains("x")) {
            return Double.parseDouble(termino);
        }

        String[] partes = termino.split("x\\^?");
        double coeficiente = partes[0].isEmpty() || partes[0].equals("+") ? 1
                : partes[0].equals("-") ? -1 : Double.parseDouble(partes[0]);

        int exponente = partes.length > 1 ? Integer.parseInt(partes[1]) : 1;
        return coeficiente * Math.pow(x, exponente);
    }

    public double reglaFalsa(String funcion, double a, double b, double tolerancia) {
        double fa = evaluarFuncion(funcion, a);
        double fb = evaluarFuncion(funcion, b);
        double c = a;

        while (Math.abs(b - a) > tolerancia) {
            c = (a * fb - b * fa) / (fb - fa);
            double fc = evaluarFuncion(funcion, c);

            if (Math.abs(fc) < tolerancia) {
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
}