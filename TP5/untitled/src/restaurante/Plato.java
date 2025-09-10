package restaurante;

import java.util.Objects;

public class Plato {
    private final String nombre;

    public Plato(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Nombre de plato inválido");
        this.nombre = nombre.trim();
    }

    public String getNombre() { return nombre; }

    @Override public String toString() { return nombre; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plato)) return false;
        Plato plato = (Plato) o;
        return nombre.equalsIgnoreCase(plato.nombre);
    }

    @Override public int hashCode() { return Objects.hash(nombre.toLowerCase()); }
}
