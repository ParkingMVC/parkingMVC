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
public class ControladorRegistroVehiculo implements ActionListener {

    VistaRegistroVehiculo vistaRegistroVehiculo = new VistaRegistroVehiculo();
    VistaRegistroCliente vistaRegistroCliente = new VistaRegistroCliente();

    Cliente cliente = new Cliente();
    Vehiculo vehiculo = new Vehiculo();
    int identificacion;
    Parqueadero parqueadero = new Parqueadero();

    public ControladorRegistroVehiculo(VistaRegistroVehiculo vistaRegistroVehiculo,
            Cliente cliente, Vehiculo vehiculo, Parqueadero parqueadero, int identificacion) {

        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.parqueadero = parqueadero;
        this.vistaRegistroVehiculo = vistaRegistroVehiculo;
        this.identificacion = identificacion;

        vistaRegistroVehiculo.botonRegistroVehiculo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       ConsultasClientes consultasClientes = new ConsultasClientes();
        ConsultasVehiculos consultasVehiculos = new ConsultasVehiculos();
        ConsultasParqueadero consultasParqueadero = new ConsultasParqueadero();
        System.out.println(identificacion);

        //registro vehiculo
        vehiculo.setPlaca(vistaRegistroVehiculo.placa.getText());
        vehiculo.setIdCliente(identificacion);
        vehiculo.setIdParqueadero(1);
        vehiculo.setMarca(vistaRegistroVehiculo.marca.getText());
        vehiculo.setColor(vistaRegistroVehiculo.color.getText());
        vehiculo.setModelo(vistaRegistroVehiculo.modelo.getText());
        vehiculo.setEstado(1); //0 activo 1 inactivo 
    
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada = formato.format(entrada);
        vehiculo.setHoraIngreso(fechaEntrada);

        if (consultasVehiculos.registrarVehiculo(vehiculo)) {
            JOptionPane.showMessageDialog(null, "Exito en el registro");
            consultasParqueadero.
            
            //VistaRegistroVehiculo vistaRegistroVehiculo = new VistaRegistroVehiculo();
            //vistaRegistroCliente.setVisible(false);
            //vistaRegistroVehiculo.setVisible(true);
            
            //PONER VISTA DE DATOS REGISTRADO CON EXITO Y BOTÓN DE VOLVER AL HOME
        } else {
            JOptionPane.showMessageDialog(null, "Error en el registro");  
        }
    }

}

