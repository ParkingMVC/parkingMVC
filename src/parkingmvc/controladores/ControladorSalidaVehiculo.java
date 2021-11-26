/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.controladores;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import parkingmvc.modelos.ModeloCliente;
import parkingmvc.modelos.ModeloConsultaCliente;
import parkingmvc.modelos.ModeloConsultaParqueadero;
import parkingmvc.modelos.ModeloConsultaVehiculo;
import parkingmvc.modelos.ModeloParqueadero;
import parkingmvc.modelos.ModeloVehiculo;
import parkingmvc.vistas.VistaHome;

/**
 *
 * @author Alejandro
 */
public class ControladorSalidaVehiculo implements ActionListener{
    
    // Atributos
    int tarifa = 150;
    
    // Objeto vista
    VistaHome vistaHome = new VistaHome();
    
    // Objetos modelos
    ModeloCliente modeloCliente = new ModeloCliente();
    ModeloVehiculo modeloVehiculo = new ModeloVehiculo();
    ModeloParqueadero modeloParqueadero = new ModeloParqueadero();
    
    public ControladorSalidaVehiculo(VistaHome vistaHome, ModeloCliente modeloCliente, ModeloVehiculo modeloVehiculo){
        this.vistaHome = vistaHome;
        this.modeloCliente = modeloCliente;
        this.modeloVehiculo = modeloVehiculo;
        
        // Evento al presionar botón Salida vehiculo
        vistaHome.btnSalidaPlaca.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Objetos modelo
        //ModeloConsultaCliente modeloConsultaCliente = new ModeloConsultaCliente();
        ModeloConsultaVehiculo modeloConsultaVehiculo = new ModeloConsultaVehiculo();
        ModeloConsultaParqueadero modeloConsultaParqueadero = new ModeloConsultaParqueadero();
        
        if(modeloConsultaVehiculo.buscarVehiculoSalida(vistaHome.fieldSalida.getText()) != null){
            
            // Obtener placa para salida
            modeloVehiculo = modeloConsultaVehiculo.buscarVehiculoSalida(vistaHome.fieldSalida.getText());
            // Obtener Hora Ingreso
            String fechaEntrada = modeloVehiculo.getHoraIngreso();
            
            try{
                // Captura y formateo fecha
                Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada);
                Date salida = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaSalida = formato.format(salida);

                long tiempoDiferencia = salida.getTime() - entrada.getTime();
                TimeUnit unidadTiempo = TimeUnit.MINUTES;
                
                // Este calculo es provisional y se debe revisar
                long tiempoVehiculo = unidadTiempo.convert(tiempoDiferencia, TimeUnit.MILLISECONDS);
                vistaHome.labelTiempo.setText(Long.toString(tiempoVehiculo) + " min");
                int total = (int)tiempoVehiculo * tarifa;
                vistaHome.labelTotal.setText(Integer.toString(total));
                
                // guarda fecha salida y estado
                modeloVehiculo.setHoraSalida(fechaSalida);
                modeloVehiculo.setEstado(0);
                
                if(modeloConsultaVehiculo.actualizarVehiculo(modeloVehiculo)){
                    // Datos del vehículo y parqueadero
                    modeloParqueadero = modeloConsultaParqueadero.buscarParqueadero(1);
                    int cuposDisponiblesNuevos = modeloParqueadero.getCuposDisponibles() + 1;
                    int cuposReservadosNuevos = modeloParqueadero.getCuposReservados() - 1;
                    String placa = modeloVehiculo.getPlaca();
                    String horaIngreso = modeloVehiculo.getHoraIngreso();
                    
                    System.out.println(modeloParqueadero);
                    System.out.println(cuposDisponiblesNuevos);
                    System.err.println(cuposReservadosNuevos);
                    
                    // Almacena en BD cupos parqueadero
                    modeloConsultaParqueadero.actualizarParqueadero(cuposDisponiblesNuevos, cuposReservadosNuevos);

                    vistaHome.fieldSalida.setText("");
                    vistaHome.labelPlaca.setText(placa);
                    vistaHome.labelHora.setText(horaIngreso);
                    vistaHome.labelResultado.setText("Exito en la salida del vehículo");
                    System.out.println("Exito en la salida del vehículo");
                    JOptionPane.showMessageDialog(null, "Exito en la salida del vehículo");
                }else{
                    vistaHome.fieldSalida.setText("");
                    vistaHome.labelResultado.setText("Error en la salida del vehículo");
                    System.out.println("Error en la salida del vehículo");
                    //JOptionPane.showMessageDialog(null, "Error en la salida del vehículo");
                }
            }catch(HeadlessException | ParseException error){
                vistaHome.fieldSalida.setText("");
                vistaHome.labelResultado.setText("Error guardando la salida del vehículo" + error);
                System.out.println("Error guardando la salida del vehículo" + error);
                //JOptionPane.showMessageDialog(null, "Error guardando la salida del vehículo" + error);
            }
        }else{
            vistaHome.fieldSalida.setText("");
            vistaHome.labelResultado.setText("El vehículo no existe");
            System.out.println("El vehículo no existe");
            //JOptionPane.showMessageDialog(null, "El vehículo no existe");
        }
    }
}
