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
import parkingmvc.modelos.ModeloCliente;
import parkingmvc.modelos.ModeloConsultaCliente;
import parkingmvc.modelos.ModeloConsultaParqueadero;
import parkingmvc.modelos.ModeloConsultaVehiculo;
import parkingmvc.modelos.ModeloParqueadero;
import parkingmvc.modelos.ModeloVehiculo;
import parkingmvc.vistas.VistaRegistroCliente;
import parkingmvc.vistas.VistaRegistroVehiculo;

/**
 *
 * @author Alejandro
 */
public class ControladorRegistroVehiculo implements ActionListener{
    
    // Atributos
    int identificacion;
    
    // Objetos Vistas
    VistaRegistroVehiculo vistaRegistroVehiculo = new VistaRegistroVehiculo();
    VistaRegistroCliente vistaRegistroCliente = new VistaRegistroCliente();
    
    // Objetos Modelos
    ModeloCliente modeloCliente = new ModeloCliente();
    ModeloVehiculo modeloVehiculo = new ModeloVehiculo();
    ModeloParqueadero modeloParqueadero = new ModeloParqueadero();
    
    // Métodos
    public ControladorRegistroVehiculo(VistaRegistroVehiculo vistaRegistroVehiculo,ModeloCliente modeloCliente, ModeloVehiculo modeloVehiculo, ModeloParqueadero modeloParqueadero, int identificacion){
        this.modeloCliente = modeloCliente;
        this.modeloVehiculo = modeloVehiculo;
        this.modeloParqueadero = modeloParqueadero;
        
        this.vistaRegistroVehiculo = vistaRegistroVehiculo;
        this.identificacion = identificacion;
        
        vistaRegistroVehiculo.btnRegistrarVehiculo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Objetos modelos Consultas
        ModeloConsultaCliente modeloConsultaCliente = new ModeloConsultaCliente();
        ModeloConsultaVehiculo modeloConsultaVehiculo = new ModeloConsultaVehiculo();
        ModeloConsultaParqueadero modeloConsultaParqueadero = new ModeloConsultaParqueadero();
        
        System.out.println(identificacion);
        
        // Registro de vehículo
        modeloVehiculo.setPlaca(vistaRegistroVehiculo.fieldIngresoplaca.getText());
        modeloVehiculo.setIdCliente(identificacion);
        modeloVehiculo.setIdParqueadero(1);
        modeloVehiculo.setMarca(vistaRegistroVehiculo.fieldIngresomarca.getText());
        modeloVehiculo.setColor(vistaRegistroVehiculo.fieldIngresocolor.getText());
        modeloVehiculo.setModelo(vistaRegistroVehiculo.fieldIngresomodelo.getText());
        modeloVehiculo.setEstado(1);    // 0 activo 1 inactivo
        
        // Captura de fecha
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada = formato.format(entrada);
        modeloVehiculo.setHoraIngreso(fechaEntrada);
        
        // Almacenamiento y resultado del registro
        if(modeloConsultaVehiculo.registrarVehiculo(modeloVehiculo)){
            
            modeloParqueadero = modeloConsultaParqueadero.buscarParqueadero(1);
            int cuposDisponiblesNuevos = modeloParqueadero.getCuposDisponibles()-1;
            int cuposReservadosNuevos = modeloParqueadero.getCuposReservados()+1;             
             
            vistaRegistroVehiculo.labelResultadovehiculo.setText("Exito al registrar el vehículo");
            System.out.println("Exito al registrar el vehículo" + modeloParqueadero.getCuposDisponibles());            
            System.out.println("cd "+ cuposDisponiblesNuevos+" cr "+ cuposReservadosNuevos);
            modeloConsultaParqueadero.actualizarParqueadero(cuposDisponiblesNuevos, cuposReservadosNuevos);
            JOptionPane.showMessageDialog(null, "Exito al registrar el vehículo");
        }else{
            vistaRegistroVehiculo.labelResultadovehiculo.setText("Error en el registro del vehículo");
            System.out.println("Error en el registro del vehículo");
            JOptionPane.showMessageDialog(null, "Error en el registro del vehículo"); 
        }
    }
}
