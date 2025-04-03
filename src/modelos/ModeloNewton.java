/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author cindy
 */
public class ModeloNewton {

    private double coeficiente;
    private double exponente;

    public ModeloNewton(double coeficiente, double exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }

    public double getCoeficiente() {
        return coeficiente;
    }

    public double getExponente() {
        return exponente;
    }

    public double calcularResultadoFuncion(double xi) {
        return coeficiente * Math.pow(xi, exponente);
    }

    public double calcularResultadoDerivada(double xi) {
        double derivadaCoeficiente = coeficiente * exponente;
        double derivadaExponente = exponente - 1;
        return derivadaCoeficiente * Math.pow(xi, derivadaExponente);
    }

    public String obtenerDerivada() {
        double derivadaCoeficiente = coeficiente * exponente;
        double derivadaExponente = exponente - 1;
        return derivadaCoeficiente + "x^" + derivadaExponente;
    }
}

