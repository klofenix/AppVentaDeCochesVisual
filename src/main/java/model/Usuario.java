package model;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String fechaNac;
    protected String provincia;
    protected Vehiculo miCoche;
    protected ArrayList<Vehiculo> favoritos;


    /*Constructor*/
    public Usuario() {
        favoritos = new ArrayList<>();
    }

    public Usuario(String nombre, String apellido, String fechaNac, String provincia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.provincia = provincia;
        this.favoritos = new ArrayList<>();
    }

    public Usuario(Usuario usuario) {
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.fechaNac = usuario.getFechaNac();
        this.provincia = usuario.getProvincia();
        this.miCoche = usuario.getMiCoche();
        this.favoritos = new ArrayList<>(usuario.getFavoritos());
    }

    /*getters y setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Vehiculo getMiCoche() {
        return miCoche;
    }

    public void setMiCoche(Vehiculo miCoche) {
        this.miCoche = miCoche;
    }

    public ArrayList<Vehiculo> getFavoritos() {
        return favoritos;
    }

    public void agregarCocheFavorito(Vehiculo vehiculo) {
        favoritos.add(vehiculo);
    }
    public void eliminarFavorito(Vehiculo vehiculo) {
        favoritos.remove(vehiculo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(apellido, usuario.apellido) &&
                Objects.equals(fechaNac, usuario.fechaNac) &&
                Objects.equals(provincia, usuario.provincia) &&
                Objects.equals(miCoche, usuario.miCoche) &&
                Objects.equals(favoritos, usuario.favoritos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getNombre(), getApellido(), getFechaNac(), getProvincia(), getMiCoche());
        result = 31 * result + Objects.hashCode(getFavoritos());
        return result;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", provincia='" + provincia + '\'' +
                ", miCoche=" + miCoche +
                ", favoritos=" + favoritos +
                '}';
    }
}