/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingmvc.modelos;

/**
 *
 * @author ASUS
 */
public class ClientesLin {
    
    private String  idRows;
    private String  idRowCab;
    private String  idRowVehiculos;
    private String  Marca;
    private String  Color;
    private int     Modelo;
    private int     Placa;
    private String  FechaCreacion;

    public ClientesLin() {
    }

    public ClientesLin(String idRows, String idRowCab, String Marca, String Color, int Modelo, int Placa, String FechaCreacion) {
        this.idRows = idRows;
        this.idRowCab = idRowCab;
        this.Marca = Marca;
        this.Color = Color;
        this.Modelo = Modelo;
        this.Placa = Placa;
        this.FechaCreacion = FechaCreacion;
    }

    public String getIdRows() {
        return idRows;
    }

    public void setIdRows(String idRows) {
        this.idRows = idRows;
    }

    public String getIdRowCab() {
        return idRowCab;
    }

    public void setIdRowCab(String idRowCab) {
        this.idRowCab = idRowCab;
    }

    public String getIdRowVehiculos() {
        return idRowVehiculos;
    }

    public void setIdRowVehiculos(String idRowVehiculos) {
        this.idRowVehiculos = idRowVehiculos;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int Modelo) {
        this.Modelo = Modelo;
    }

    public int getPlaca() {
        return Placa;
    }

    public void setPlaca(int Placa) {
        this.Placa = Placa;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }
    
    
    
}
