/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import parkingmvc.modelos.ModeloConsultaVehiculo;
import parkingmvc.modelos.ModeloVehiculo;
import parkingmvc.vistas.VistaCliente;
import parkingmvc.vistas.VistaVehiculo;

/**
 *
 * @author jdiaz
 */
public class ControladorConsultaVehiculo implements ActionListener{
    
       
    // Objeto Vista registro cliente
    VistaVehiculo vistaVehiculo = new VistaVehiculo();
    
    // Objeto Modelo cliente
    ModeloVehiculo modeloVehiculo = new ModeloVehiculo();
    
        
    public ControladorConsultaVehiculo(VistaVehiculo vistaVehiculo, ModeloVehiculo modeloVehiculo){
        this.vistaVehiculo = vistaVehiculo;
        this.modeloVehiculo = modeloVehiculo;
        
        // Action listener al boton Buscar cliente
        vistaVehiculo.btnConsultaPlaca.addActionListener(this);        
    }  

    public ControladorConsultaVehiculo(VistaCliente abrir, ModeloVehiculo modeloVehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       // Objeto ModeloConsultaVehiculo
        ModeloConsultaVehiculo modeloConsultaVehiculo = new ModeloConsultaVehiculo();
        if(modeloConsultaVehiculo.buscarVehiculo(vistaVehiculo.fieldIngresoplaca.getText()) != null){
                        
            modeloVehiculo = modeloConsultaVehiculo.buscarVehiculo(vistaVehiculo.fieldIngresoplaca.getText());        
            String placa = modeloVehiculo.getPlaca();
            String marca = modeloVehiculo.getMarca();
            String color = modeloVehiculo.getColor();        
            String modelo = modeloVehiculo.getModelo();
            String hora = modeloVehiculo.getHoraIngreso();     
                    
            vistaVehiculo.labelResultadobusqueda.setText("Exito en la búsqueda del vehículo");
            System.out.println("Exito en la búsqueda del vehículo");           
            JOptionPane.showMessageDialog(null, "Exito en la búsqueda"); 
            vistaVehiculo.fieldIngresoplaca.setText("");
            vistaVehiculo.labelPlaca.setText(placa);            
            vistaVehiculo.labelMarca.setText(marca);
            vistaVehiculo.labelColor.setText(color);
            vistaVehiculo.labelModelo.setText(modelo);
            vistaVehiculo.labelHora.setText(hora); 
            
        }else{
            
            vistaVehiculo.labelResultadobusqueda.setText("Error en la búsqueda del cliente");
            System.out.println("Error en la búsqueda del cliente");
            JOptionPane.showMessageDialog(null, "Error en la búsqueda"); 
            
        }
    }
}
    

