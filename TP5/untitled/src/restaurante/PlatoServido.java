package restaurante;

import java.util.Objects;

public class PlatoServido {
    private final Restaurante restaurante;
    private final Plato plato;
    private final Double precio; // opcional

    PlatoServido(Restaurante restaurante, Plato plato, Double precio) {
        if (restaurante == null || plato == null) throw new IllegalArgumentException("Datos inválidos");
        this.restaurante = restaurante;
        this.plato = plato;
        this.precio = precio;
    }

    public Restaurante getRestaurante() { return restaurante; }
    public Plato getPlato() { return plato; }
    public Double getPrecio() { return precio; }

    @Override public String toString() {
        return plato + " @ " + restaurante.getNombre() + (precio != null ? " ($" + precio + ")" : "");
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlatoServido)) return false;
        PlatoServido that = (PlatoServido) o;
        return restaurante.equals(that.restaurante) && plato.equals(that.plato);
    }

    @Override public int hashCode() { return Objects.hash(restaurante, plato); }
}
