/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingmvc.modelos;

/**
 *
 * @author ASUS
 */
public class ClientesCab {
    
    private String idRows;
    private String NombresCompletos;
    private int    Identificacion;
    private String CorreoElectronico;
    private String Direccion;
    private int    FechaCreacion;

    public ClientesCab() {
    }

    public ClientesCab(String idRows, String NombresCompletos, int Identificacion, String CorreoElectronico, String Direccion, int FechaCreacion) {
        this.idRows = idRows;
        this.NombresCompletos = NombresCompletos;
        this.Identificacion = Identificacion;
        this.CorreoElectronico = CorreoElectronico;
        this.Direccion = Direccion;
        this.FechaCreacion = FechaCreacion;
    }

    public String getIdRows() {
        return idRows;
    }

    public void setIdRows(String idRows) {
        this.idRows = idRows;
    }

    public String getNombresCompletos() {
        return NombresCompletos;
    }

    public void setNombresCompletos(String NombresCompletos) {
        this.NombresCompletos = NombresCompletos;
    }

    public int getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(int Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(int FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }
    
    
    
}
