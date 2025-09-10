package restaurante;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Persona {
    private final String nombre;
    private final Set<Restaurante> frecuentes = new HashSet<>();
    private final Set<Gusto> gustos = new HashSet<>();
    private final List<Visita> visitas = new ArrayList<>();

    public Persona(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Nombre inválido");
        this.nombre = nombre.trim();
    }

    public String getNombre() { return nombre; }

    public void frecuentar(Restaurante r) {
        if (r == null) throw new IllegalArgumentException("Restaurante requerido");
        frecuentes.add(r);
    }

    public Set<Restaurante> getFrecuentes() {
        return Collections.unmodifiableSet(frecuentes);
    }

    public void visitar(Sucursal s, LocalDate fecha) {
        if (s == null) throw new IllegalArgumentException("Sucursal requerida");
        visitas.add(new Visita(this, s, fecha == null ? LocalDate.now() : fecha));
    }

    public List<Visita> getVisitas() { return Collections.unmodifiableList(visitas); }

    /** Me gusta el plato tal como lo sirven en el restaurante */
    public void meGusta(Restaurante r, Plato p) {
        if (r == null || p == null) throw new IllegalArgumentException("Datos requeridos");
        if (!r.ofrece(p)) throw new IllegalArgumentException("El restaurante no ofrece ese plato");
        gustos.add(new Gusto(this, r, p));
    }

    public boolean leGusta(Restaurante r, Plato p) {
        return gustos.contains(new Gusto(this, r, p));
    }

    public Set<Plato> platosQueMeGustanEn(Restaurante r) {
        return gustos.stream()
                .filter(g -> g.getRestaurante().equals(r))
                .map(Gusto::getPlato)
                .collect(Collectors.toUnmodifiableSet());
    }

    public Set<Restaurante> restaurantesDondeTengoAlgúnGusto() {
        return gustos.stream()
                .map(Gusto::getRestaurante)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override public String toString() { return nombre; }
}
