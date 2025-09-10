package restaurante;

import java.util.Objects;

public class Sucursal {
    private final Restaurante restaurante;
    private final String direccion;

    public Sucursal(Restaurante restaurante, String direccion) {
        if (restaurante == null) throw new IllegalArgumentException("Restaurante requerido");
        if (direccion == null || direccion.isBlank()) throw new IllegalArgumentException("Dirección inválida");
        this.restaurante = restaurante;
        this.direccion = direccion.trim();
    }

    public Restaurante getRestaurante() { return restaurante; }
    public String getDireccion() { return direccion; }

    @Override public String toString() { return restaurante.getNombre() + " - " + direccion; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sucursal)) return false;
        Sucursal that = (Sucursal) o;
        return restaurante.equals(that.restaurante)
                && direccion.equalsIgnoreCase(that.direccion);
    }

    @Override public int hashCode() { return Objects.hash(restaurante, direccion.toLowerCase()); }
}
