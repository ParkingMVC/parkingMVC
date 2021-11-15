/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingmvc.modelos;

/**
 *
 * @author ASUS
 */
public class Parqueadero {
    
    private int id;
    private int cuposTotales;
    private int cuposDisponibles;
    private int cuposReservados;

    public Parqueadero() {
    }

    public Parqueadero(int id, int cuposTotales, int cuposDisponibles, int cuposReservados) {
        this.id = id;
        this.cuposTotales = cuposTotales;
        this.cuposDisponibles = cuposDisponibles;
        this.cuposReservados = cuposReservados;
    }

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
