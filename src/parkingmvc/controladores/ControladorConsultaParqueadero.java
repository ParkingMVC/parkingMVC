/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import parkingmvc.modelos.ModeloConsultaParqueadero;
import parkingmvc.modelos.ModeloParqueadero;
import parkingmvc.vistas.VistaHome;

/**
 *
 * @author Alejandro
 */
public class ControladorConsultaParqueadero implements ActionListener{
    
    // Objeto Vista registro cliente
    VistaHome vistaHome = new VistaHome();
    
    // Objetos Modelo parqueadero
    ModeloParqueadero modeloParqueadero = new ModeloParqueadero();
    ModeloConsultaParqueadero modeloConsultaParqueadero = new ModeloConsultaParqueadero();

    public ControladorConsultaParqueadero(VistaHome vistaHome, ModeloParqueadero modeloParqueadero){
        this.vistaHome = vistaHome;
        this.modeloParqueadero = modeloParqueadero;
        
        // 
        vistaHome.btnDisponibilidad.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        int id = 1;
        
        modeloParqueadero = modeloConsultaParqueadero.buscarParqueadero(id);
        int cuposDisponibles = modeloParqueadero.getCuposDisponibles();
        int cuposReservados = modeloParqueadero.getCuposReservados();
        
        System.out.println(modeloParqueadero);
        System.out.println(cuposDisponibles);
        System.out.println(cuposReservados);
        
        if(cuposDisponibles > 0 || cuposReservados > 0){
            vistaHome.labelDisponibles.setText(Integer.toString(cuposDisponibles));
            vistaHome.labelOcupados.setText(Integer.toString(cuposReservados));
            
            vistaHome.labelResultado.setText("Búsqueda exitosa");
            
            System.out.println("Exito en la búsqueda de disponibilidad");
            //JOptionPane.showMessageDialog(null, "Exito en la búsqueda de disponibilidad");
        }else{
            vistaHome.labelDisponibles.setText("");
            vistaHome.labelResultado.setText("Error en la búsqueda");
            
            System.out.println("Error en la búsqueda de disponibilidad");
            //JOptionPane.showMessageDialog(null, "Error en la búsqueda de disponibilidad");     
        }
    }
}
