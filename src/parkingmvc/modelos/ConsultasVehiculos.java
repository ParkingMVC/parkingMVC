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
public class ConsultasVehiculos extends ModeloBD {
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean registrarVehiculo(Vehiculo vehiculo) {
        Connection conexion = conectarBD();
        String query = "INSERT INTO Vehiculo(Placa, IdCliente, IdParqueadero, Marca, Color, Modelo, Estado, HoraIngreso, HoraSalida) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        
        try{
            //preparar conexión  
            consultaSQL = conexion.prepareStatement(query);
            
            //ajusto la consulta
            consultaSQL.setString(1, vehiculo.getPlaca());
            consultaSQL.setInt(2, vehiculo.getIdCliente());
            consultaSQL.setInt(3, vehiculo.getIdParqueadero());
            consultaSQL.setString(4, vehiculo.getMarca());
            consultaSQL.setString(5, vehiculo.getColor());
            consultaSQL.setString(5, vehiculo.getModelo());
            consultaSQL.setString(5, vehiculo.getEstado());
            consultaSQL.setString(5, vehiculo.getHoraIngreso());
            consultaSQL.setString(5, vehiculo.getHoraSalida());
            
            //Ejecuto la consulta
            int resultado = consultaSQL.executeUpdate();
            
            //validando el resultado
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }
        }catch(Exception error){
            System.out.println("Upppss!!" + error);
            return false;
        }
    }
    
    public Vehiculo buscarVehiculo(String placa){
        Connection conexion = conectarBD();
        String query = "SELECT * FROM Vehiculo WHERE Placa=?";
        
        try{
            //preparar conexión  
            consultaSQL = conexion.prepareStatement(query);
            
            //ajusto la consulta
            consultaSQL.setString(1, placa);
            
            //Ejecutar la consulta
            resultadoSQL = consultaSQL.executeQuery();
            
            //Organizar el resultado
            Vehiculo vehiculo = new Vehiculo();
            
            //Llenar el Cliente
            if(resultadoSQL.next()){
                vehiculo.setPlaca(resultadoSQL.getString("Placa"));
                vehiculo.setIdCliente(resultadoSQL.getInt("IdCliente"));
                vehiculo.setIdParqueadero(resultadoSQL.getInt("IdParqueadero"));
                vehiculo.setMarca(resultadoSQL.getString("Marca"));
                vehiculo.setColor(resultadoSQL.getString("Color"));
                vehiculo.setModelo(resultadoSQL.getString("Modelo"));
                vehiculo.setEstado(resultadoSQL.getString("Estado"));
                vehiculo.setHoraIngreso(resultadoSQL.getString("Hora Ingreso"));
                vehiculo.setHoraSalida(resultadoSQL.getString("Hora Salida"));
                
                return vehiculo;
            }else{
                return null;
            }
        }catch(Exception error){
            System.out.println("Upppss!!" + error);
            return null;
        }
    }
}
