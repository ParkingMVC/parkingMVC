/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingmvc.modelos;

/**
 *
 * @author ASUS
 */
public class Cliente {
    
    private int identificacion;
    private String nombresCompletos;
    private String numeroTelefono;
    private String correoElectronico;
    private String Direccion;

    public Cliente() {
    }

    public Cliente(int identificacion, String nombresCompletos, String numeroTelefono, String correoElectronico, String Direccion) {
        this.identificacion = identificacion;
        this.nombresCompletos = nombresCompletos;
        this.numeroTelefono = numeroTelefono;
        this.correoElectronico = correoElectronico;
        this.Direccion = Direccion;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombresCompletos() {
        return nombresCompletos;
    }

    public void setNombresCompletos(String nombresCompletos) {
        this.nombresCompletos = nombresCompletos;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    } 
}
