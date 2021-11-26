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
public class ModeloConsultaParqueadero extends ModeloBD{
    
    // Prepara base de datos
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    // Métodos
    public boolean registrarParqueadero(ModeloParqueadero parqueadero){
        
        // Objeto conexion
        Connection conexion = conectarBD();
        // Query para la DB
        String query = "INSERT INTO parqueadero(Id, CuposTotales, CuposDisponibles, CuposReservados)" + "VALUES (?,?,?,?)";
        
        try{
            // Prepara la consulta
            consultaSQL = conexion.prepareStatement(query);
            
            // Ajusta la consulta
            consultaSQL.setInt(1, parqueadero.getId());
            consultaSQL.setInt(1, parqueadero.getCuposTotales());
            consultaSQL.setInt(1, parqueadero.getCuposDisponibles());
            consultaSQL.setInt(1, parqueadero.getCuposReservados());
            
            // Ejecutar consulta
            int resultado = consultaSQL.executeUpdate();
            
            // Resultado de la ejecución
            if(resultado > 0){
                System.out.println("Exito al registrar en parqueadero");
                return true;
            }else{
                System.out.println("Error al registrar en parqueadero");
                return false;
            }
        }catch(SQLException error){
            System.out.println("Error al registrar en parqueadero" + error);
            return false;
        }
    }
    
    public ModeloParqueadero buscarParqueadero(int id){
        
        // Objeto conexion
        Connection conexion = conectarBD();
        // Query para la DB
        String query = "SELECT * FROM parqueadero WHERE Id = ?";
        
        try{
            // Prepara la consulta
            consultaSQL = conexion.prepareStatement(query);
            
            // Ajusta la consulta
            consultaSQL.setInt(1, id);
            
            // Ejecutar consulta
            resultadoSQL = consultaSQL.executeQuery();
            
            // Organiza la consulta
            ModeloParqueadero modeloParqueadero = new ModeloParqueadero();
            
            if(resultadoSQL.next()){
                modeloParqueadero.setId(resultadoSQL.getInt("Id"));
                modeloParqueadero.setCuposTotales(resultadoSQL.getInt("CuposTotales"));
                modeloParqueadero.setCuposDisponibles(resultadoSQL.getInt("CuposDisponibles"));
                modeloParqueadero.setCuposReservados(resultadoSQL.getInt("CuposReservados"));
                
                return modeloParqueadero;
            }else{
                System.out.println("Error al buscar parqueadero");
                return null;
            }
        }catch(SQLException error){
            System.out.println("Error al buscar parqueadero" + error);
            return null;
        }
    }
    
    public boolean actualizarParqueadero(int cuposDisponibles, int cuposReservados){
        
        // Objeto conexion
        Connection conexion = conectarBD();
        // Query para la DB
        String query = "UPDATE parqueadero SET CuposDisponibles = ?, CuposReservados = ? WHERE Id = 1";
        
        try{
            // Prepara la consulta
            consultaSQL = conexion.prepareStatement(query);
            
            // Ajusta la consulta
            consultaSQL.setInt(1, cuposDisponibles);
            consultaSQL.setInt(2, cuposReservados);
            
            // Ejecutar consulta
            int resultado = consultaSQL.executeUpdate();
            
            // Resultado de la ejecución
            if(resultado > 0){
                System.out.println("Exito al actualizar el parqueadero");
                return true;
            }else{
                System.out.println("Error al actualizar el parqueadero");
                return false;
            }
            
        }catch(SQLException error){
            System.out.println("Error al actualizar el parqueadero" + error);
            return false;
        }
    }
    
     public boolean incrementarParqueadero(int cuposTotales, int cuposDisponibles){
        
        // Objeto conexion
        Connection conexion = conectarBD();
        // Query para la DB
        String query = "UPDATE parqueadero SET CuposTotales = ?, CuposDisponibles = ? WHERE Id = 1";
        
        try{
            // Prepara la consulta
            consultaSQL = conexion.prepareStatement(query);
            
            // Ajusta la consulta
            consultaSQL.setInt(1, cuposTotales);
            consultaSQL.setInt(2, cuposDisponibles);
            
            // Ejecutar consulta
            int resultado = consultaSQL.executeUpdate();
            
            // Resultado de la ejecución
            if(resultado > 0){
                System.out.println("Exito al actualizar el parqueadero");
                return true;
            }else{
                System.out.println("Error al actualizar el parqueadero");
                return false;
            }
            
        }catch(SQLException error){
            System.out.println("Error al actualizar el parqueadero" + error);
            return false;
        }
    }
}
