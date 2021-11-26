/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alejandro
 */

// Extend con la clase ModeloDB para ejecutar el método conectarBD()
public class ModeloConsultaCliente extends ModeloBD{
    
    // Prepara base de datos
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    
    // Métodos
    public boolean registrarCliente(ModeloCliente cliente){
        
        // Objeto conexion
        Connection conexion = conectarBD();
        // Query para la DB
        String query = "INSERT INTO cliente(Identificacion, NombresCompletos, NumeroTelefono, CorreoElectronico, Direccion)" + "VALUES (?,?,?,?,?)";
        
        try{
            // preparar consulta
            consultaSQL = conexion.prepareStatement(query);
            
            // Ajustar consulta
            consultaSQL.setInt(1, cliente.getIdentificacion());
            consultaSQL.setString(2, cliente.getNombresCompletos());
            consultaSQL.setString(3, cliente.getNumeroTelefono());
            consultaSQL.setString(4, cliente.getCorreoElectronico());
            consultaSQL.setString(5, cliente.getDireccion());
            
            // Ejecutar consulta
            int resultado = consultaSQL.executeUpdate();
            
            // Validar el resulta de la ejecución
            if(resultado > 0){
                return true;
            }else{
                System.out.println("Error al ingresar al Cliente");
                return false;
            }
        }catch(SQLException error){
            System.out.println("Error al registrar al Cliente" + error);
            return false;
        }
    }
    
    public ModeloCliente buscarCliente(int identificacion){
        
        // Objeto conexion
        Connection conexion = conectarBD();
        String query = "SELECT * FROM cliente WHERE Identificacion = ?";
        
        try{
            // preparar consulta
            consultaSQL = conexion.prepareStatement(query);
            
            // Ajustar consulta
            consultaSQL.setInt(1, identificacion);
            
            // Ejecuta la consulta
            resultadoSQL = consultaSQL.executeQuery();
            
            // Organiza el resultado
            ModeloCliente modeloCliente = new ModeloCliente();
            
            // Datos del cliente
            if(resultadoSQL.next()){
                
                modeloCliente.setIdentificacion(resultadoSQL.getInt("Identificacion"));
                modeloCliente.setNombresCompletos(resultadoSQL.getString("NombresCompletos"));
                modeloCliente.setNumeroTelefono(resultadoSQL.getString("NumeroTelefono"));
                modeloCliente.setCorreoElectronico(resultadoSQL.getString("CorreoElectronico"));
                modeloCliente.setDireccion(resultadoSQL.getString("Direccion"));
                
                return modeloCliente;
            }else{
                return null;
            }
            
        }catch(SQLException error){
            System.out.println("Error al buscar al cliente" + error);
            return null;
        }
    }

}
