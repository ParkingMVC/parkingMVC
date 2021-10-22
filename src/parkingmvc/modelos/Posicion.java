/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingmvc.modelos;

/**
 *
 * @author ASUS
 */
public class Posicion {
    
    private String idRows;
    private int    Posicion;
    private String Estado;

    public Posicion() {
    }

    public Posicion(String idRows, int Posicion, String Estado) {
        this.idRows = idRows;
        this.Posicion = Posicion;
        this.Estado = Estado;
    }

    public String getIdRows() {
        return idRows;
    }

    public void setIdRows(String idRows) {
        this.idRows = idRows;
    }

    public int getPosicion() {
        return Posicion;
    }

    public void setPosicion(int Posicion) {
        this.Posicion = Posicion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}
