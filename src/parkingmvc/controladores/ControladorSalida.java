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
import parkingmvc.modelos.Parqueadero;
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
    Parqueadero parqueadero = new Parqueadero();

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

        if (consultasVehiculos.buscarVehiculoSalida(vistaSalida.placa.getText()) != null) {
            //Obtener la fecha de salida
            vehiculo = consultasVehiculos.buscarVehiculoSalida(vistaSalida.placa.getText());

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
                vehiculo.setEstado(0);

                if (consultasVehiculos.actualizarVehiculo(vehiculo)) {

                    JOptionPane.showMessageDialog(null, "Exito en el salida, te demoraste: " + tiempoVehiculo);
                    System.out.println("El valor a pagar es: $" + tiempoVehiculo * 150);

                    parqueadero = consultasParqueadero.buscarParqueadero(1);
                    int cuposDisponiblesNuevos = parqueadero.getCuposDisponibles() + 1;
                    int cuposReservadosNuevos = parqueadero.getCuposReservados() - 1;
                    consultasParqueadero.actualizarParqueadero(cuposDisponiblesNuevos, cuposReservadosNuevos);

                } else {

                    JOptionPane.showMessageDialog(null, "Error en el salida");

                }

            } catch (ParseException error) {
                System.out.println("Uppps!" + error);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vehiculo No existe");
        }

    }

}
