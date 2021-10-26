/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingmvc.modelos;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class ConsultasClientes extends ModeloBD {
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean registrarCliente(Cliente cliente) {
        Connection conexion = conectarBD();
        String query = "INSERT INTO Cliente (Identificacion, NombresCompletos, NumeroTelefono, CorreoElectronico, Direccion)"
                + "VALUES (?,?,?,?,?)";
        
        try{
            //preparar conexión  
            consultaSQL = conexion.prepareStatement(query);
            
            //ajusto la consulta
            consultaSQL.setInt(1, cliente.getIdentificacion());
            consultaSQL.setString(2, cliente.getNombresCompletos());
            consultaSQL.setString(3, cliente.getNumeroTelefono());
            consultaSQL.setString(4, cliente.getCorreoElectronico());
            consultaSQL.setString(5, cliente.getDireccion());
            
            //Ejecuto la consulta
            int resultado = consultaSQL.executeUpdate();
            
            //validando el resultado
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception error){
            System.out.println("Upppss!!" + error);
            return false;
        }
    }
    
    public Cliente buscarCliente(int identificacion){
        Connection conexion = conectarBD();
        String query = "SELECT * FROM Cliente WHERE Identificacion=?";
        
        try{
            //preparar conexión  
            consultaSQL = conexion.prepareStatement(query);

            //ajusto la consulta
            consultaSQL.setInt(1, identificacion);
            
            //Ejecutar la consulta
            resultadoSQL = consultaSQL.executeQuery();
            
            //Organizar el resultado
            Cliente cliente = new Cliente();
            
            //Llenar el Cliente
            if(resultadoSQL.next()){
                cliente.setIdentificacion(resultadoSQL.getInt("Identificación"));
                cliente.setNombresCompletos(resultadoSQL.getString("Nombre Completo"));
                cliente.setNumeroTelefono(resultadoSQL.getString("Número Telefono"));
                cliente.setCorreoElectronico(resultadoSQL.getString("Correo Electrónico"));
                cliente.setDireccion(resultadoSQL.getString("Dirección"));
                
                return cliente;
            }else{
                return null;
            }
        }catch(Exception error){
            System.out.println("Upppss!!" + error);
            return null;
        }
    }
}
