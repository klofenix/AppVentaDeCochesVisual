package model;

import java.util.Objects;

public class Turismo extends Vehiculo {
    private TipoCarroceria carroceria;

    /*Constructor*/

    public Turismo() {
    }
    public Turismo(String marca, String modelo, int aFabricacion, int kms, int potenciaCV, double precio, Vehiculo.TipoCombustible combustible, Medidas medidas, TipoCarroceria carroceria) {
        super(marca, modelo, aFabricacion, kms, potenciaCV, precio, combustible, medidas);
        this.setCarroceria(carroceria);
    }

    public Turismo(Vehiculo vehiculo, TipoCarroceria carroceria) {
        super(vehiculo);
        this.setCarroceria(carroceria);
    }

    /*Getters y Setters*/
    public TipoCarroceria getCarroceria() {
        return carroceria;
    }
    public void setCarroceria(TipoCarroceria carroceria) {
        this.carroceria = carroceria;
    }
    @Override
    public int getPotenciaKW(int getPotenciaCV){
        double _1KW = getPotenciaCV / 1.34;
        return (int) _1KW;
    }
    /*hashCode y equals*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turismo turismo)) return false;
        if (!super.equals(o)) return false;
        return getCarroceria() == turismo.getCarroceria();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCarroceria());
    }

    @Override
    public String toString() {
        return "Turismo{" +
                "carroceria=" + carroceria +
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

