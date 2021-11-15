/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parkingmvc.modelos.ModeloBD;
import parkingmvc.vistas.VistaRegistroCliente;
import parkingmvc.vistas.VistaRegistroVehiculo;

/**
 *
 * @author Jose
 */
public class Controlador implements ActionListener {
    
    ModeloBD modelo = new ModeloBD();

    VistaRegistroCliente vistaRegistroCliente = new VistaRegistroCliente();
    VistaRegistroVehiculo vistaRegistroVehiculo = new VistaRegistroVehiculo();
  

    public Controlador(ModeloBD modelo, VistaRegistroCliente vistaRegistroCliente) {
        this.modelo=modelo;
        this.vistaRegistroCliente=vistaRegistroCliente;
        vistaRegistroCliente.botonRegistroCliente.addActionListener(this);
       
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        modelo.conectarBD();
        
    }
    
    
    
}
