package Modelo;

import java.util.Objects;

/**
 * Representa una ciudad que pertenece a una provincia.
 * Tiene flags para indicar si es capital de su provincia o capital del país.
 */
public class Ciudad {
    private String nombre;
    private Provincia provincia;
    private boolean esCapitalDeProvincia;
    private boolean esCapitalDePais;

    public Ciudad(String nombre, Provincia provincia) {
        this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
        setProvincia(provincia);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
    }

    public Provincia getProvincia() {
        return provincia;
    }

    /** No público para forzar consistencia desde Provincia.addCiudad */
    void setProvincia(Provincia provincia) {
        // permitir null (cuando se elimina una ciudad)
        if (this.provincia == provincia) return;

        // limpiar de la provincia anterior si existe
        if (this.provincia != null) {
            this.provincia.getCiudades().remove(this); // no es mutable, pero intento mantenibilidad:
            // mejor usar provincia.removeCiudad desde quien gestione el borrado
        }
        this.provincia = provincia;
        // si la nueva provincia no tiene ya la ciudad en su lista, añadirla
        if (provincia != null && !provincia.getCiudades().contains(this)) {
            provincia.addCiudad(this);
        }
    }

    public boolean isEsCapitalDeProvincia() {
        return esCapitalDeProvincia;
    }

    void setEsCapitalDeProvincia(boolean esCapitalDeProvincia) {
        this.esCapitalDeProvincia = esCapitalDeProvincia;
    }

    public boolean isEsCapitalDePais() {
        return esCapitalDePais;
    }

    void setEsCapitalDePais(boolean esCapitalDePais) {
        this.esCapitalDePais = esCapitalDePais;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                ", provincia=" + (provincia != null ? provincia.getNombre() : "null") +
                ", esCapitalDeProvincia=" + esCapitalDeProvincia +
                ", esCapitalDePais=" + esCapitalDePais +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ciudad ciudad = (Ciudad) o;
        return Objects.equals(nombre, ciudad.nombre) &&
                Objects.equals(provincia, ciudad.provincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, provincia);
    }
}
