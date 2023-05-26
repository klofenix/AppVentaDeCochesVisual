package model;

import java.util.Objects;

public abstract  class Vehiculo {
    protected String marca, modelo;
    protected int aFabricacion, kms, potenciaCV;
    protected double precio;
    protected Medidas medidas;


    public enum TipoCombustible{
        Diesel,
        Gasolina,
        Hibrido,
        Electrico,
        GLP
    }
    protected TipoCombustible combustible;
    /*Constructor*/
    public Vehiculo(String marca, String modelo, int aFabricacion, int kms, int potenciaCV, double precio, TipoCombustible combustible, Medidas medidas) {
        this.marca = marca;
        this.modelo = modelo;
        this.aFabricacion = aFabricacion;
        this.kms = kms;
        this.potenciaCV = potenciaCV;
        this.precio = precio;
        this.combustible = combustible;
        this.medidas = medidas;
    }

/*constructor por defecto y copia*/
    public Vehiculo(){}

    public Vehiculo(Vehiculo vehiculo){
        this.marca = vehiculo.marca;
        this.modelo = vehiculo.modelo;
        this.aFabricacion = vehiculo.aFabricacion;
        this.kms = vehiculo.kms;
        this.potenciaCV = vehiculo.potenciaCV;
        this.precio = vehiculo.precio;
        this.combustible = vehiculo.combustible;
        this.medidas = new Medidas(vehiculo.getMedidas());
    }
    /*Getters y Setters*/
    public Medidas getMedidas() {
        return medidas;
    }

    public void setMedidas(Medidas medidas) {
        this.medidas = medidas;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAFabricacion() {
        return aFabricacion;
    }
    public void setAFabricacion(int aFabricacion) {
        this.aFabricacion = aFabricacion;
    }
    public int getKms() {
        return kms;
    }
    public void setKms(int kms) {
        this.kms = kms;
    }
    public int getPotenciaCV() {
        return potenciaCV;
    }
    public void setPotenciaCV(int portenciaCV) {
        this.potenciaCV = portenciaCV;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public TipoCombustible getCombustible() {
        return combustible;
    }
    public void setCombustible(TipoCombustible combustible) {
        this.combustible = combustible;
    }
    @Override
    public String toString(){
        return "Marca: " + marca + "\nModelo: " + modelo + "\nAFabricacion: " + aFabricacion + "\nKms: " + kms + "\nPortenciaCV: " + potenciaCV + "\nCombustible: " + combustible;
    }
    /*Metodos*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo vehiculo)) return false;
        return aFabricacion == vehiculo.aFabricacion && getKms() == vehiculo.getKms() && getPotenciaCV() == vehiculo.getPotenciaCV() && Double.compare(vehiculo.getPrecio(), getPrecio()) == 0 && getMarca().equals(vehiculo.getMarca()) && getModelo().equals(vehiculo.getModelo()) && getMedidas().equals(vehiculo.getMedidas()) && getCombustible() == vehiculo.getCombustible();
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, aFabricacion, kms, potenciaCV, precio, medidas, combustible);
    }

    public int getPotenciaKW(int getPotenciaCV){
        double _1KW = getPotenciaCV / 1.34;
        return (int) _1KW;
    }
}
