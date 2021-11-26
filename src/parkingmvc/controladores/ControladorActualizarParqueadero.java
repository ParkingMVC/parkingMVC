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
import parkingmvc.vistas.VistaParqueadero;

/**
 *
 * @author Jose
 */
public class ControladorActualizarParqueadero implements ActionListener{

    // Objeto vista
    VistaParqueadero vistaParqueadero = new VistaParqueadero();
    
    // Objeto modelo
    ModeloParqueadero modeloParqueadero = new ModeloParqueadero();
    
    public ControladorActualizarParqueadero(VistaParqueadero vistaParqueadero, ModeloParqueadero modeloParqueadero){
        
        this.vistaParqueadero = vistaParqueadero;
        this.modeloParqueadero = modeloParqueadero;
                
        // Evento al presionar botón Salida vehiculo
        vistaParqueadero.btnActualizarTarifa.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        // Objetos modelos Consultas
        ModeloConsultaParqueadero modeloConsultaParqueadero = new ModeloConsultaParqueadero();     
                  
        modeloParqueadero = modeloConsultaParqueadero.buscarParqueadero(1);
        int cuposTotales = modeloParqueadero.getCuposTotales();
        int cuposDisponibles = modeloParqueadero.getCuposDisponibles();
        int cuposReservados = modeloParqueadero.getCuposReservados();
        int cuposTotalesNuevos = (Integer.parseInt(vistaParqueadero.fieldTarifa.getText()));
        
        if(cuposDisponibles > 0 || cuposReservados > 0){}
        if(cuposTotales < cuposTotalesNuevos){
            
            vistaParqueadero.labelResultadotarifa.setText("Éxito en la actualización del parqueadero");
            System.out.println("Éxito en la actualización del parqueadero");
            int cuposDisponiblesNuevos = cuposTotalesNuevos - cuposReservados;            
            
            modeloConsultaParqueadero.incrementarParqueadero(cuposTotalesNuevos, cuposDisponiblesNuevos);
            JOptionPane.showMessageDialog(null, "Éxito en la actualización del parqueadero");
        }else{
            JOptionPane.showMessageDialog(null, "El tamaño ingresado debe ser mayor al actual");  
        }
    }   
    
    
}
