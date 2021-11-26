/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.controladores;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import parkingmvc.modelos.ModeloConsultaVehiculo;
import parkingmvc.modelos.ModeloVehiculo;
import parkingmvc.vistas.VistaConsulta;

/**
 *
 * @author Jose
 */
public class ControladorConsultaVehiculos implements ActionListener{
 
    // Objeto Vista registro cliente
    VistaConsulta vistaConsulta = new VistaConsulta();
   
    // Objeto Modelo cliente
    
    
     public ControladorConsultaVehiculos(VistaConsulta vistaConsulta){
        this.vistaConsulta = vistaConsulta;
        
        
        // Action listener al boton Buscar cliente
        vistaConsulta.btnConsultarVehiculos.addActionListener(this);        
    }  
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        ModeloConsultaVehiculo modeloConsultaVehiculo = new ModeloConsultaVehiculo();              
        
        if(modeloConsultaVehiculo.buscarVehiculosConMatriz() != null){
            ArrayList<ModeloVehiculo> miLista = modeloConsultaVehiculo.buscarVehiculosConMatriz();
            for (int i = 0; i < miLista.size(); i++) {
               vistaConsulta.tableConsulta.setValueAt((miLista.get(i).getPlaca()), i, 0);
               vistaConsulta.tableConsulta.setValueAt((miLista.get(i).getMarca()), i, 1);
               vistaConsulta.tableConsulta.setValueAt((miLista.get(i).getModelo()), i, 2);
               vistaConsulta.tableConsulta.setValueAt((miLista.get(i).getColor()), i, 3);
               vistaConsulta.tableConsulta.setValueAt((miLista.get(i).getHoraIngreso()), i, 4);          
            }        
           JOptionPane.showMessageDialog(null, "Exito en la búsqueda");
        }else{
            JOptionPane.showMessageDialog(null, "Error en la búsqueda");
        }
    }
    
}
