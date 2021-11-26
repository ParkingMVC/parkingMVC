/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc;

import parkingmvc.controladores.Controlador;
import parkingmvc.modelos.ModeloBD;
import parkingmvc.vistas.VistaInicio;

/**
 *
 * @author Jose
 */
public class ParkingMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ModeloBD modeloDB = new ModeloBD();
        
        VistaInicio vistaInicio = new VistaInicio();
        vistaInicio.setVisible(true);
        
        Controlador controlador = new Controlador(modeloDB, vistaInicio);
    }
    
}
