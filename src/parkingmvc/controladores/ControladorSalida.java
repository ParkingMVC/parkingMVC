/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import parkingmvc.modelos.Cliente;
import parkingmvc.modelos.ConsultasClientes;
import parkingmvc.modelos.ConsultasParqueadero;
import parkingmvc.modelos.ConsultasVehiculos;
import parkingmvc.modelos.Vehiculo;
import parkingmvc.vistas.VistaSalida;

/**
 *
 * @author lau
 */
public class ControladorSalida implements ActionListener {

    VistaSalida vistaSalida = new VistaSalida();
    Cliente cliente = new Cliente();
    Vehiculo vehiculo = new Vehiculo();

    public ControladorSalida(VistaSalida vistaSalida, Cliente cliente, Vehiculo vehiculo) {
        this.vistaSalida = vistaSalida;
        this.cliente = cliente;
        this.vehiculo = vehiculo;

        vistaSalida.botonSalida.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConsultasClientes consultasClientes = new ConsultasClientes();
        ConsultasVehiculos consultasVehiculos = new ConsultasVehiculos();
        ConsultasParqueadero consultasParqueadero = new ConsultasParqueadero();

        //Obtener la fecha de salida
        vehiculo = consultasVehiculos.buscarVehiculo(vistaSalida.placa.getText());
        String fechaEntrada = vehiculo.getHoraIngreso();

        try {
            Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada);
            Date salida = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaSalida = formato.format(salida);

            long tiempoDiferencia = salida.getTime() - entrada.getTime();
            TimeUnit unidadTiempo = TimeUnit.MINUTES;

            long tiempoVehiculo = unidadTiempo.convert(tiempoDiferencia, TimeUnit.MILLISECONDS);

            vehiculo.setHoraSalida(fechaSalida);

            if (consultasVehiculos.actualizarVehiculo(vehiculo)) {

                JOptionPane.showMessageDialog(null, "Exito en el salida, te demoraste: " + tiempoVehiculo);

            } else {

                JOptionPane.showMessageDialog(null, "Error en el salida");

            }

        } catch (ParseException error) {
            System.out.println("Uppps!" + error);
        }
    }

}
