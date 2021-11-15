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
public class ConsultasParqueadero extends ModeloBD {

    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;

    public boolean registrarParqueadero(Parqueadero parqueadero) {
        Connection conexion = conectarBD();
        String query = "INSERT INTO Parqueadero(Id, CuposTotales, CuposDisponibles, CuposReservados)"
                + " VALUES (?,?,?,?)";

        try {
            //preparar conexión  
            consultaSQL = conexion.prepareStatement(query);

            //ajusto la consulta
            consultaSQL.setInt(1, parqueadero.getId());
            consultaSQL.setInt(2, parqueadero.getCuposTotales());
            consultaSQL.setInt(3, parqueadero.getCuposDisponibles());
            consultaSQL.setInt(4, parqueadero.getCuposReservados());

            //Ejecuto la consulta
            int resultado = consultaSQL.executeUpdate();

            //validando el resultado
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception error) {
            System.out.println("Upppss!!" + error);
            return false;
        }
    }

    public Parqueadero buscarParqueadero(int id) {
        Connection conexion = conectarBD();
        String query = "SELECT * FROM Parqueadero WHERE Id=?";

        try {
            //preparar conexión  
            consultaSQL = conexion.prepareStatement(query);

            //ajusto la consulta
            consultaSQL.setInt(1, id);

            //Ejecutar la consulta
            resultadoSQL = consultaSQL.executeQuery();

            //Organizar el resultado
            Parqueadero parqueadero = new Parqueadero();

            if (resultadoSQL.next()) {
                parqueadero.setId(resultadoSQL.getInt("Id"));
                parqueadero.setCuposTotales(resultadoSQL.getInt("Cupos Totales"));
                parqueadero.setCuposDisponibles(resultadoSQL.getInt("Cupos Disponibles"));
                parqueadero.setCuposReservados(resultadoSQL.getInt("Cupos Reservados"));

                return parqueadero;
            } else {
                return null;
            }

        } catch (Exception error) {
            System.out.println("Upppss!!" + error);
            return null;
        }
    }

}
