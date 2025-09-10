package restaurante;

import java.util.*;

public class Restaurante {
    private static final int MAX_PLATOS = 20;

    private final String nombre;
    private final Set<Sucursal> sucursales = new HashSet<>();
    private final Map<Plato, PlatoServido> menu = new HashMap<>();

    public Restaurante(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Nombre de restaurante inválido");
        this.nombre = nombre.trim();
    }

    public String getNombre() { return nombre; }

    public Sucursal agregarSucursal(String direccion) {
        Sucursal s = new Sucursal(this, direccion);
        sucursales.add(s);
        return s;
    }

    public Collection<Sucursal> getSucursales() {
        return Collections.unmodifiableCollection(sucursales);
    }

    /** Ofrece un plato en este restaurante (no más de 20 distintos) */
    public PlatoServido ofrecerPlato(Plato plato, Double precioOpcional) {
        if (plato == null) throw new IllegalArgumentException("Plato no puede ser null");
        if (menu.size() >= MAX_PLATOS && !menu.containsKey(plato))
            throw new IllegalStateException("Un restaurante no puede ofrecer más de " + MAX_PLATOS + " platos");

        return menu.computeIfAbsent(plato, p -> new PlatoServido(this, p, precioOpcional));
    }

    public boolean ofrece(Plato plato) { return menu.containsKey(plato); }

    public Collection<PlatoServido> platosServidos() {
        return Collections.unmodifiableCollection(menu.values());
    }

    @Override public String toString() { return nombre; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurante)) return false;
        Restaurante that = (Restaurante) o;
        return nombre.equalsIgnoreCase(that.nombre);
    }

    @Override public int hashCode() { return Objects.hash(nombre.toLowerCase()); }
}
