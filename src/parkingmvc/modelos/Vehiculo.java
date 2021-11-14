/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingmvc.modelos;

/**
 *
 * @author ASUS
 */
public class Vehiculo {
    
    private String placa;
    private int idCliente;
    private int idParqueadero;
    private String marca;
    private String color;
    private String modelo;
    private int estado;
    private String horaIngreso;
    private String horaSalida;

    public Vehiculo() {
    }

    public Vehiculo(String placa, int idCliente, int idParqueadero, String marca, String color, String modelo, int estado, String horaIngreso, String horaSalida) {
        this.placa = placa;
        this.idCliente = idCliente;
        this.idParqueadero = idParqueadero;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.estado = estado;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(int idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
}
