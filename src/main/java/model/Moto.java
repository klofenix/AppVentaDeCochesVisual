package model;

import java.util.Objects;

public  class Moto extends Vehiculo  {
    private int numRuedas;

    /* Constructor */
    public Moto(){}
    public Moto(int numRuedas){
        this.numRuedas = numRuedas;
    }

    public Moto(String marca, String modelo, int aFabricacion, int kms, int potenciaCV, double precio, TipoCombustible combustible, Medidas medidas, int numRuedas) {
        super(marca, modelo, aFabricacion, kms, potenciaCV, precio, combustible, medidas);
        this.numRuedas = numRuedas;
    }

    public Moto(Moto moto){
        super(moto);
        this.numRuedas = moto.numRuedas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Moto moto)) return false;
        if (!super.equals(o)) return false;
        return getNumRuedas() == moto.getNumRuedas();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumRuedas());
    }

    /*getPotencia*/
    @Override
    public int getPotenciaKW(int getPotenciaCV){
        double _1KW = getPotenciaCV / 1.34;
        return (int) _1KW;
    }
     /*getter y setter*/

    public int getNumRuedas() {
        return numRuedas;
    }
    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }


    @Override
    public String toString() {
        return "Moto{" +
                "numRuedas=" + numRuedas +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", aFabricacion=" + aFabricacion +
                ", kms=" + kms +
                ", potenciaCV=" + potenciaCV +
                ", precio=" + precio +
                ", medidas=" + medidas +
                ", combustible=" + combustible +
                '}';
    }
}
