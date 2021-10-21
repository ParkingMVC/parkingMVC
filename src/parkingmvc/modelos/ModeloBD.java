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
    private final String servidor="jdbc:mysql://localhost/parkingmvc";
    private final String usuario="root";
    private final String password="";

    public ModeloBD() {
    }
    
    public Connection conectarBD(){
    
        Connection conexion=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection(servidor, usuario, password);
            System.out.println("Exito conectándonos");
            return conexion;
            
        }catch(Exception error){
            System.out.println("UPSS.. "+error);
            return null;
        }
    }
    
}
