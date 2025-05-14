/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author cindy
 */
public class ModeloLagrange {

    String num;
    String valorX;
    String valorY;
    String valorInicio;
    String resultado;

    public ModeloLagrange() {
    }

    public ModeloLagrange(String num, String valorX, String valorY, String valorInicio, String resultado) {
        this.num = num;
        this.valorX = valorX;
        this.valorY = valorY;
        this.valorInicio = valorInicio;
        this.resultado = resultado;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getValorX() {
        return valorX;
    }

    public void setValorX(String valorX) {
        this.valorX = valorX;
    }

    public String getValorY() {
        return valorY;
    }

    public void setValorY(String valorY) {
        this.valorY = valorY;
    }

    public String getValorInicio() {
        return valorInicio;
    }

    public void setValorInicio(String valorInicio) {
        this.valorInicio = valorInicio;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    

    @Override
    public String toString() {
        return "ModeloLagrange{" + "num=" + num + ", valorX=" + valorX + ", valorY=" + valorY + ", valorInicio=" + valorInicio + ", resultado=" + resultado + '}';
    }

    
}
