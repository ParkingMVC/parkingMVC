/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc;

import parkingmvc.controladores.Controlador;
import parkingmvc.controladores.ControladorRegistroCliente;
import parkingmvc.controladores.ControladorSalida;
import parkingmvc.modelos.Cliente;
import parkingmvc.modelos.ModeloBD;
import parkingmvc.modelos.Vehiculo;
import parkingmvc.vistas.Vista;
import parkingmvc.vistas.VistaRegistroCliente;
import parkingmvc.vistas.VistaSalida;

/**
 *
 * @author Jose
 */
public class ParkingMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        Vehiculo vehiculo = new Vehiculo();
        VistaRegistroCliente vistaCliente = new VistaRegistroCliente();
        VistaSalida vistaSalida = new VistaSalida();
        vistaCliente.setVisible(false);
        vistaSalida.setVisible(true);
        ControladorRegistroCliente controladorCliente = new ControladorRegistroCliente(vistaCliente, cliente);
        ControladorSalida controladorSalida = new ControladorSalida(vistaSalida, cliente, vehiculo);
    }
    
}
