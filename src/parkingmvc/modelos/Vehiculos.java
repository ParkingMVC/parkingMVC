/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingmvc.modelos;

/**
 *
 * @author ASUS
 */
public class Vehiculos {
    
    private String idRows;
    private String TipoVehiculo;

    public Vehiculos() {
    }

    public Vehiculos(String idRows, String TipoVehiculo) {
        this.idRows = idRows;
        this.TipoVehiculo = TipoVehiculo;
    }

    public String getIdRows() {
        return idRows;
    }

    public void setIdRows(String idRows) {
        this.idRows = idRows;
    }

    public String getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(String TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }
    
    
    
}
