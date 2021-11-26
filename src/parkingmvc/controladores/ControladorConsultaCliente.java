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
import parkingmvc.vistas.VistaCliente;

/**
 *
 * @author Alejandro
 */
public class ControladorConsultaCliente implements ActionListener{
    
    // Objeto Vista registro cliente
    VistaCliente vistaCliente = new VistaCliente();
    
    // Objeto Modelo cliente
    ModeloCliente modeloCliente = new ModeloCliente();
    
    
    
    public ControladorConsultaCliente(VistaCliente vistaCliente, ModeloCliente modeloCliente){
        this.vistaCliente = vistaCliente;
        this.modeloCliente = modeloCliente;
        
        // Action listener al boton Buscar cliente
        vistaCliente.btnConsultarCliente.addActionListener(this);        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        // Objeto ModeloConsultaCliente
        ModeloConsultaCliente modeloConsultaCliente = new ModeloConsultaCliente();
        
        if(modeloConsultaCliente.buscarCliente(Integer.parseInt(vistaCliente.fieldIngresocedula.getText())) != null){
            
            modeloCliente = modeloConsultaCliente.buscarCliente(Integer.parseInt(vistaCliente.fieldIngresocedula.getText()));
            String nombre = modeloCliente.getNombresCompletos();
            int identificacion = modeloCliente.getIdentificacion();
            String ident=Integer.toString(identificacion);
            String telefono = modeloCliente.getNumeroTelefono();
            String correo = modeloCliente.getCorreoElectronico();
            String direccion = modeloCliente.getDireccion();        
        
            vistaCliente.labelResultadobusqueda.setText("Exito en la búsqueda del cliente");
            System.out.println("Exito en la búsqueda del cliente");
            System.out.println(nombre);
            JOptionPane.showMessageDialog(null, "Exito en la búsqueda"); 
            vistaCliente.fieldIngresocedula.setText("");
            vistaCliente.labelDocumento.setText(ident);            
            vistaCliente.labelNombre.setText(nombre);
            vistaCliente.labelTelefono.setText(telefono);
            vistaCliente.labelCorreo.setText(correo);
            vistaCliente.labelDireccion.setText(direccion);            
        }else{
            vistaCliente.labelResultadobusqueda.setText("Error en la búsqueda del cliente");
            System.out.println("Error en la búsqueda del cliente");
            JOptionPane.showMessageDialog(null, "Error en la búsqueda"); 
        }
    }
}
 