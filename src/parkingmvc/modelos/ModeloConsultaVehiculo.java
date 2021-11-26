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
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class ModeloConsultaVehiculo extends ModeloBD{
    
    // Prepara la DB
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean registrarVehiculo(ModeloVehiculo vehiculo) {
        
        // Objeto conexion
        Connection conexion = conectarBD();
        // Query para la DB
        String query = "INSERT INTO vehiculo(Placa, IdCliente, IdParqueadero, Marca, Color, Modelo, Estado, HoraIngreso, HoraSalida)" + "VALUES (?,?,?,?,?,?,?,?,?)";
        
        try{
            //preparar conexión  
            consultaSQL = conexion.prepareStatement(query);
            
            //ajusto la consulta
            consultaSQL.setString(1, vehiculo.getPlaca());
            consultaSQL.setInt(2, vehiculo.getIdCliente());
            consultaSQL.setInt(3, vehiculo.getIdParqueadero());
            consultaSQL.setString(4, vehiculo.getMarca());
            consultaSQL.setString(5, vehiculo.getColor());
            consultaSQL.setString(6, vehiculo.getModelo());
            consultaSQL.setInt(7, vehiculo.getEstado());
            consultaSQL.setString(8, vehiculo.getHoraIngreso());
            consultaSQL.setString(9, vehiculo.getHoraSalida());
            
            //Ejecuto la consulta
            int resultado = consultaSQL.executeUpdate();
            
            //validando el resultado
            if (resultado > 0) {
                System.out.println("Exito al registrar vehiculo");
                return true;
            } else {
                System.out.println("Error al registrar vehiculo");
                return false;
            }
        }catch(SQLException error){
            System.out.println("Error al registrar vehiculo" + error);
            return false;
        }
    }
    
    public ModeloVehiculo buscarVehiculo(String placa){
        
        // Objeto conexion
        Connection conexion = conectarBD();
        // Query para la DB
        String query = "SELECT * FROM Vehiculo WHERE Placa = ?";
        
        try{
            //preparar conexión  
            consultaSQL = conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1, placa);
            
            //Ejecutar la consulta
            resultadoSQL = consultaSQL.executeQuery();
            
            //Organizar el resultado
            ModeloVehiculo vehiculo = new ModeloVehiculo();
            
            //Llenar el Vehículo            
            if(resultadoSQL.next()){
                vehiculo.setPlaca(resultadoSQL.getString("Placa"));
                vehiculo.setIdCliente(resultadoSQL.getInt("IdCliente"));
                vehiculo.setIdParqueadero(resultadoSQL.getInt("IdParqueadero"));
                vehiculo.setMarca(resultadoSQL.getString("Marca"));
                vehiculo.setColor(resultadoSQL.getString("Color"));
                vehiculo.setModelo(resultadoSQL.getString("Modelo"));
                vehiculo.setEstado(resultadoSQL.getInt("Estado"));
                vehiculo.setHoraIngreso(resultadoSQL.getString("HoraIngreso"));
                vehiculo.setHoraSalida(resultadoSQL.getString("HoraSalida"));
                
                return vehiculo;
            }else{
                System.out.println("Error al buscar vehiculo");
                return null;
            }
        }catch(SQLException error){
            System.out.println("Error al buscar vehiculo" + error);
            return null;
        }
    }
    
    public ModeloVehiculo buscarVehiculoSalida(String placa){
        
        // Objeto conexion
        Connection conexion = conectarBD();
        // Query para la DB
        String query = "SELECT * FROM Vehiculo WHERE Placa = ? AND Estado > 0";
        
        try{
            // Preparar conexión  
            consultaSQL = conexion.prepareStatement(query);
            
            // Ajusta la consulta
            consultaSQL.setString(1, placa);
            
            // Ejecuta la consulta
            resultadoSQL = consultaSQL.executeQuery();
            
            // Organizar el resultado
            ModeloVehiculo vehiculo = new ModeloVehiculo();
            
            // Datos Cliente
            if(resultadoSQL.next()){
                vehiculo.setPlaca(resultadoSQL.getString("Placa"));
                vehiculo.setIdCliente(resultadoSQL.getInt("IdCliente"));
                vehiculo.setIdParqueadero(resultadoSQL.getInt("IdParqueadero"));
                vehiculo.setMarca(resultadoSQL.getString("Marca"));
                vehiculo.setColor(resultadoSQL.getString("Color"));
                vehiculo.setModelo(resultadoSQL.getString("Modelo"));
                vehiculo.setEstado(resultadoSQL.getInt("Estado"));
                vehiculo.setHoraIngreso(resultadoSQL.getString("HoraIngreso"));
                vehiculo.setHoraSalida(resultadoSQL.getString("HoraSalida"));
                
                return vehiculo;
            }else{
                System.out.println("Error al buscar salida de vehiculo");
                return null;
            }
        }catch(SQLException error){
            System.out.println("Error al buscar salida de vehiculo" + error);
            return null;
        }
    }
    
    public boolean actualizarVehiculo(ModeloVehiculo vehiculo){
        
        System.out.println(vehiculo.getHoraSalida());
                System.out.println(vehiculo.getEstado());
                        System.out.println(vehiculo.getPlaca());
                        
        // Objeto conexion
        Connection conexion = conectarBD();
        // Query para la DB
        String query = "UPDATE vehiculo SET Estado = ?, HoraSalida = ? WHERE placa = ?";
        
        try {
            // Prepara la consulta
            consultaSQL = conexion.prepareStatement(query);
            
            // Ajusta la consulta
            consultaSQL.setInt(1, vehiculo.getEstado());
            consultaSQL.setString(2, vehiculo.getHoraSalida());  
            consultaSQL.setString(3, vehiculo.getPlaca());
            
            // Resultado de la consulta
            int resultado = consultaSQL.executeUpdate();
            
            if(resultado > 0){
                System.out.println("Exito al actualizar vehiculo");
                return true;
            }else{
                System.out.println("Error al actualizar vehiculo");
                return false;
            }
        }catch( SQLException error){
            System.out.println("Error al actualizar vehiculo" + error);
            return false;
        }
    }
    
    public ArrayList buscarVehiculosConMatriz(){
        
        // Objeto conexion
        Connection conexion = conectarBD();
        ArrayList<ModeloVehiculo> miLista = new ArrayList();
        
        // Query para la DB              
        String query = "SELECT * FROM Vehiculo WHERE Estado = 1";
        
        try{
            //preparar conexión  
            consultaSQL = conexion.prepareStatement(query);
            
            //Ajusto la consulta
            //consultaSQL.setString(1, estado);
            
            //Ejecutar la consulta
            resultadoSQL = consultaSQL.executeQuery();
            
            //Organizar el resultado
            
            
            //Llenar el Cliente
            if(resultadoSQL.next()){
                do{
                    ModeloVehiculo vehiculo = new ModeloVehiculo();
                    vehiculo.setPlaca(resultadoSQL.getString("Placa"));                                
                    vehiculo.setMarca(resultadoSQL.getString("Marca"));
                    vehiculo.setColor(resultadoSQL.getString("Color"));
                    vehiculo.setModelo(resultadoSQL.getString("Modelo"));                
                    vehiculo.setHoraIngreso(resultadoSQL.getString("HoraIngreso"));                
                    miLista.add(vehiculo);                    
                }while(resultadoSQL.next());
                return miLista;
                
            }else{
                System.out.println("Error al buscar vehiculos");
                return null;
            }
        }catch(SQLException error){
            System.out.println("Error al buscar vehiculos" + error);
            return null;
        }       
        
    }
}
