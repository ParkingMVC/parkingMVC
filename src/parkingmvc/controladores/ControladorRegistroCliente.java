/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import parkingmvc.modelos.ModeloCliente;
import parkingmvc.modelos.ModeloConsultaCliente;
import parkingmvc.modelos.ModeloParqueadero;
import parkingmvc.modelos.ModeloVehiculo;
import parkingmvc.vistas.VistaRegistroCliente;
import parkingmvc.vistas.VistaRegistroVehiculo;

/**
 *
 * @author Alejandro
 */
public class ControladorRegistroCliente implements ActionListener{
    
    // Objeto Vista registro cliente
    VistaRegistroCliente vistaRegistroCliente = new VistaRegistroCliente();
    
    // Objeto Modelo cliente
    ModeloCliente modeloCliente = new ModeloCliente();
    
    public ControladorRegistroCliente(VistaRegistroCliente vistaRegistroCliente, ModeloCliente modeloCliente){
        this.vistaRegistroCliente = vistaRegistroCliente;
        this.modeloCliente = modeloCliente;
        
        // Action listener al boton Registrar cliente
        vistaRegistroCliente.btnRegistrarCliente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Objeto ModeloConsultaCliente
        ModeloConsultaCliente modeloConsultaCliente = new ModeloConsultaCliente();
        
        // Registro del cliente
        modeloCliente.setIdentificacion(Integer.parseInt(vistaRegistroCliente.fieldIngresodocumento.getText()));
        modeloCliente.setNombresCompletos(vistaRegistroCliente.fieldIngresonombre.getText());
        modeloCliente.setNumeroTelefono(vistaRegistroCliente.fieldIngresotelefono.getText());
        modeloCliente.setCorreoElectronico(vistaRegistroCliente.fieldIngresocorreo.getText());
        modeloCliente.setDireccion(vistaRegistroCliente.fieldIngresodireccion.getText());
        
        // Verifica resultado del método registrarCliente cuando le entrega los datos modeloCliente
        if(modeloConsultaCliente.registrarCliente(modeloCliente)){
            
            // Objeto vista
            VistaRegistroVehiculo vistaRegistroVehiculo = new VistaRegistroVehiculo();
            
            // Set vista visible
            vistaRegistroCliente.setVisible(false);
            vistaRegistroVehiculo.setVisible(true);
            
            // Objetos modelo
            ModeloVehiculo modeloVehiculo = new ModeloVehiculo();
            ModeloParqueadero modeloParqueadero = new ModeloParqueadero();
            
            // LLeva los datos
            ControladorRegistroVehiculo controladorRegistroVehiculo = new ControladorRegistroVehiculo(vistaRegistroVehiculo,modeloCliente, modeloVehiculo, modeloParqueadero, Integer.parseInt(vistaRegistroCliente.fieldIngresodocumento.getText()));
            
            vistaRegistroCliente.labelResultadocliente.setText("Exito en el registro del cliente");
            System.out.println("Exito en el registro del cliente");
            JOptionPane.showMessageDialog(null, "Exito en el registro"); 
        }else{
            vistaRegistroCliente.labelResultadocliente.setText("Error en el registro del cliente");
            System.out.println("Error en el registro del cliente");
            JOptionPane.showMessageDialog(null, "Error en el registro"); 
        }
    }
    
}
