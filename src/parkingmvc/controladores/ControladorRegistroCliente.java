/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import parkingmvc.modelos.Cliente;
import parkingmvc.modelos.ConsultasClientes;
import parkingmvc.modelos.ConsultasParqueadero;
import parkingmvc.modelos.ConsultasVehiculos;
import parkingmvc.modelos.Parqueadero;
import parkingmvc.modelos.Vehiculo;
import parkingmvc.vistas.VistaRegistroCliente;
import parkingmvc.vistas.VistaRegistroVehiculo;

/**
 *
 * @author lau
 */
public class ControladorRegistroCliente implements ActionListener {
   
    VistaRegistroCliente vistaRegistroCliente = new VistaRegistroCliente();

    Cliente cliente = new Cliente();

    public ControladorRegistroCliente(VistaRegistroCliente vistaRegistroCliente, Cliente cliente) {

        this.cliente = cliente;
        this.vistaRegistroCliente = vistaRegistroCliente;

        vistaRegistroCliente.botonRegistroCliente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConsultasClientes consultasClientes = new ConsultasClientes();

        //registro cliente
        cliente.setIdentificacion(Integer.parseInt(vistaRegistroCliente.Identificacion.getText()));
        cliente.setNombresCompletos(vistaRegistroCliente.Nombre.getText());
        cliente.setCorreoElectronico(vistaRegistroCliente.Correo.getText());
        cliente.setDireccion(vistaRegistroCliente.direccion.getText());
        cliente.setNumeroTelefono(vistaRegistroCliente.telefono.getText());
        
     

        if (consultasClientes.registrarCliente(cliente )) {
            
            VistaRegistroVehiculo vistaRegistroVehiculo = new VistaRegistroVehiculo();
            
            System.out.println(vistaRegistroCliente.Identificacion.getText());
            vistaRegistroCliente.setVisible(false);
            vistaRegistroVehiculo.setVisible(true);
            
            Vehiculo vehiculo = new Vehiculo();
            Parqueadero parqueadero = new Parqueadero();
            
            ControladorRegistroVehiculo controladorRegistroVehiculo = new ControladorRegistroVehiculo(vistaRegistroVehiculo,
            cliente, vehiculo, parqueadero, Integer.parseInt(vistaRegistroCliente.Identificacion.getText()));
        } else {
            JOptionPane.showMessageDialog(null, "Error en el registro");  
        }
    }
}
