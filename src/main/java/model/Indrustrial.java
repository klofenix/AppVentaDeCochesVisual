package model;

import java.util.Objects;

public class Indrustrial extends Vehiculo implements Camperizable {
    private float tamCaja;

    /*constructor*/
    public Indrustrial() {
    }
    public Indrustrial(String marca, String modelo, float tamCaja) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.tamCaja = tamCaja;
    }
    public Indrustrial(Vehiculo vehiculo, float tamCaja) {
        super(vehiculo);
        this.tamCaja = tamCaja;
    }

    /*getters y setters*/
    public float getTamCaja() {
        return tamCaja;
    }
    public void setTamCaja(float tamCaja) {
        this.tamCaja = tamCaja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Indrustrial that)) return false;
        if (!super.equals(o)) return false;
        return Float.compare(that.tamCaja, tamCaja) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tamCaja);
    }

    /*toString*/
    @Override
    public String toString() {
        return "Industrial{" + "marca=" + getMarca() + ", modelo=" + getModelo() + ", tamCaja=" + getTamCaja() + '}';
    }
    // Implementación de métodos de la interfaz Camperizable
    @Override
    public void añadirCama() {
        System.out.println("Cama añadida");

    }

    @Override
    public void añadirDucha() {
        System.out.println("Ducha añadida");

    }

    @Override
    public void añadirCocina() {
        System.out.println("Cocina añadida");

    }
    @Override
    public int getPotenciaKW(int getPotenciaCV){
        double _1KW = getPotenciaCV / 1.34;
        return (int) _1KW;
    }
}
