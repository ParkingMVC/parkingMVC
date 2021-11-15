/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.modelos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parkingmvc.vistas.VistaHome;

/**
 *
 * @author Asus
 */
public class ControladorHomePaquingMvc implements ActionListener {
    
    VistaHome vistaHome = new VistaHome();
    Parqueadero parqueadero = new Parqueadero();
    Vehiculo vehiculo = new Vehiculo();

    public ControladorHomePaquingMvc(VistaHome vistaHome,Parqueadero parqueadero,Vehiculo vehiculo) {
        
        this.vistaHome=vistaHome;
        this.parqueadero=parqueadero;
        this.vehiculo=vehiculo;
        
        vistaHome.botonAgregar.addActionListener(this);
    }

        
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        ConsultasParqueadero consultasParqueadero = new ConsultasParqueadero();
        String placa = vistaHome.cajaIdPlaca.getText();
        
       
        
    }
    
    
    
    
}
