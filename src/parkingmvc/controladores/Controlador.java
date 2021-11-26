/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parkingmvc.modelos.ModeloBD;
import parkingmvc.vistas.VistaInicio;

/**
 *
 * @author Jose
 */
public class Controlador implements ActionListener {
    
    ModeloBD modeloDB = new ModeloBD();
    VistaInicio vistaInicio = new VistaInicio();

    public Controlador(ModeloBD modeloDB, VistaInicio vistaInicio) {
        this.modeloDB = modeloDB;
        this.vistaInicio = vistaInicio;
        vistaInicio.boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        modeloDB.conectarBD();
    }
    
}
