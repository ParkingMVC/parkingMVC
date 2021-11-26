/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmvc.modelos;

/**
 *
 * @author Alejandro
 */
public class ModeloCliente {
    
    // Atributos
    private int identificacion;
    private String nombresCompletos;
    private String numeroTelefono;
    private String correoElectronico;
    private String direccion;

    // Constructor vacio
    public ModeloCliente() {
    }
    
    // Constructor con parámetros
    public ModeloCliente(int identificacion, String nombresCompletos, String numeroTelefono, String correoElectronico, String direccion) {
        this.identificacion = identificacion;
        this.nombresCompletos = nombresCompletos;
        this.numeroTelefono = numeroTelefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
    }

    // Getter & setter
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
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
