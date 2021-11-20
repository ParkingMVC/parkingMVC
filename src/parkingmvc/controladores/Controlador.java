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
import parkingmvc.vistas.VistaSalida;

/**
 *
 * @author Jose
 */
public class Controlador implements ActionListener {
    
    ModeloBD modelo = new ModeloBD();

    VistaRegistroCliente vistaRegistroCliente = new VistaRegistroCliente();
    //VistaRegistroVehiculo vistaRegistroVehiculo = new VistaRegistroVehiculo();
    VistaSalida vistaSalida = new VistaSalida();

    public Controlador(ModeloBD modelo, VistaSalida vistaSalida) {
        this.modelo=modelo;
//        this.vistaRegistroCliente=vistaRegistroCliente;
        this.vistaSalida = vistaSalida;
        vistaSalida.botonSalida.addActionListener(this);
           
            vistaSalida.setVisible(true);
       // vistaRegistroCliente.botonRegistroCliente.addActionListener(this);
        //vistaRegistroVehiculo.botonRegistroVehiculo.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        modelo.conectarBD();
        
    }
    
    
    
}
