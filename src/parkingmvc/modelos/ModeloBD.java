/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jose
 */
public class ModeloBD {
    
    // Atributos
    private final String servidor="jdbc:mysql://localhost/parking_mvc";
    private final String usuario="root";
    private final String password="";
    
    // Constructor vacio
    public ModeloBD() {
    }
    
    // Métodos
    public Connection conectarBD(){
    
        Connection conexion=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(servidor, usuario, password);
            System.out.println("Exito conectándonos");
            return conexion;
            
        }catch(Exception error){
            System.out.println("UPSS.. Error al conectarse a la BD: " + error);
            return null;
        }
    }
    
}
