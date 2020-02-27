package mx.mudbit.petagram.models;

public class Mascota {
    private int foto;
    private String nombre;
    private String popularidad;

    public Mascota(int foto, String nombre, String popularidad) {
        this.foto = foto;
        this.nombre = nombre;
        this.popularidad = popularidad;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(String popularidad) {
        this.popularidad = popularidad;
    }
}
