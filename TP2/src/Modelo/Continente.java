package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Representa un continente que contiene países.
 */
public class Continente {
    private String nombre;
    private final List<Pais> paises = new ArrayList<>();

    public Continente(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
    }

    public List<Pais> getPaises() {
        return Collections.unmodifiableList(paises);
    }

    /** Añade un país y fija la referencia bidireccional */
    public void addPais(Pais pais) {
        if (pais == null) throw new IllegalArgumentException("pais no puede ser null");
        if (!paises.contains(pais)) {
            paises.add(pais);
            pais.setContinente(this);
        }
    }

    /** Quita un país (y limpia su referencia al continente) */
    public void removePais(Pais pais) {
        if (paises.remove(pais)) {
            pais.setContinente(null);
        }
    }

    @Override
    public String toString() {
        return "Continente{" +
                "nombre='" + nombre + '\'' +
                ", numPaises=" + paises.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continente that = (Continente) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
