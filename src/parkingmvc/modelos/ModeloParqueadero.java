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
public class ModeloParqueadero {
    
    // Atributos
    private int id;
    private int cuposTotales;
    private int cuposDisponibles;
    private int cuposReservados;
    
    // Constructor vacio
    public ModeloParqueadero() {
    }
    
    // Constructor con parámetros
    public ModeloParqueadero(int id, int cuposTotales, int cuposDisponibles, int cuposReservados) {
        this.id = id;
        this.cuposTotales = cuposTotales;
        this.cuposDisponibles = cuposDisponibles;
        this.cuposReservados = cuposReservados;
    }
    
    // Getter & setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuposTotales() {
        return cuposTotales;
    }

    public void setCuposTotales(int cuposTotales) {
        this.cuposTotales = cuposTotales;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public int getCuposReservados() {
        return cuposReservados;
    }

    public void setCuposReservados(int cuposReservados) {
        this.cuposReservados = cuposReservados;
    }
    
}
