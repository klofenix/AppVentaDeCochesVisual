package model;

import java.util.Objects;

public class Medidas {
    private int alto;
    private int ancho;
    private int largo;


    /* constructor */
    public Medidas(){
    }
    public Medidas(Medidas medidas) {
        this.alto = medidas.alto;
        this.ancho = medidas.ancho;
        this.largo = medidas.largo;
    }



    public  Medidas(int alto, int ancho, int largo) {
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
    }

    /* getters y setters */
    public int getAlto() {
        return alto;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }
    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public int getLargo() {
        return largo;
    }
    public void setLargo(int largo) {
        this.largo = largo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alto, ancho, largo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass()!= obj.getClass()) {
            return false;
        }
        final Medidas other = (Medidas) obj;
        if (this.alto!= other.alto) {
            return false;
        }
        if (this.ancho!= other.ancho) {
            return false;
        }
        if (this.largo!= other.largo) {
            return false;
        }
        return true;
    }
    /*ToString */
    @Override
    public String toString() {
        return "Medidas{" + "alto=" + alto + ", ancho=" + ancho + ", largo=" + largo + '}';
    }
}
