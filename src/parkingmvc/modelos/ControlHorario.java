/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingmvc.modelos;

/**
 *
 * @author ASUS
 */
public class ControlHorario {
    
    private String idRows;
    private String idRowClientesLin;
    private String idRowPosicion;
    private int    FechaIngreso;
    private int    FechaSalida;

    public ControlHorario() {
    }

    public ControlHorario(String idRows, String idRowClientesLin, String idRowPosicion, int FechaIngreso, int FechaSalida) {
        this.idRows = idRows;
        this.idRowClientesLin = idRowClientesLin;
        this.idRowPosicion = idRowPosicion;
        this.FechaIngreso = FechaIngreso;
        this.FechaSalida = FechaSalida;
    }

    public String getIdRows() {
        return idRows;
    }

    public void setIdRows(String idRows) {
        this.idRows = idRows;
    }

    public String getIdRowClientesLin() {
        return idRowClientesLin;
    }

    public void setIdRowClientesLin(String idRowClientesLin) {
        this.idRowClientesLin = idRowClientesLin;
    }

    public String getIdRowPosicion() {
        return idRowPosicion;
    }

    public void setIdRowPosicion(String idRowPosicion) {
        this.idRowPosicion = idRowPosicion;
    }

    public int getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(int FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public int getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(int FechaSalida) {
        this.FechaSalida = FechaSalida;
    }
    
    
            
    
}
