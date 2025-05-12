/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.ModeloDosIncognitas;
import vista.VistaDosIncognitas;

/**
 *
 * @author cindy
 */
public class ControladorDosIncognitas {
//    private VistaDosIncognitas vista;
//    private ModeloDosIncognitas modelo;
//
//    public ControladorDosIncognitas(VistaDosIncognitas vista) {
//        this.vista = vista;
//        this.modelo = new ModeloDosIncognitas();
//
//        // Agregar listener al botón de resolver
//        this.vista.btnResolver.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                resolverSistema();
//            }
//        });
//    }
//
//    private void resolverSistema() {
//        try {
//            // Obtener los coeficientes de la vista (convertir a double)
//            double a = Double.parseDouble(vista.getTxtA());
//            double b = Double.parseDouble(vista.getTxtB());
//            double c = Double.parseDouble(vista.getTxtC());
//            double d = Double.parseDouble(vista.getTxtD());
//            double e = Double.parseDouble(vista.getTxtE());
//            double f = Double.parseDouble(vista.getTxtF());
//            
//            // Resolver el sistema usando el modelo
//            String[] resultados = modelo.resolverSistema(a, b, c, d, e, f);
//            
//            // Actualizar la vista con los resultados
//            vista.setTxtResultadoX(resultados[0]);
//            vista.setTxtResultadoY(resultados[1]);
//        } catch (NumberFormatException ex) {
//            vista.setTxtResultadoX("Error");
//            vista.setTxtResultadoY("Error");
//        }
//    }
}