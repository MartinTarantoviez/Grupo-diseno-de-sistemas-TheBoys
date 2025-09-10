package parque;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ComunidadAutonoma {
    private final String nombre;
    private final String organismoResponsable;
    private final Set<Parque> parques = new HashSet<>();

    public ComunidadAutonoma(String nombre, String organismoResponsable) {
        this.nombre = Objects.requireNonNull(nombre);
        this.organismoResponsable = Objects.requireNonNull(organismoResponsable);
    }

    public String getNombre() { return nombre; }
    public String getOrganismoResponsable() { return organismoResponsable; }
    public Set<Parque> getParques() { return Set.copyOf(parques); }

    public void vincularParque(Parque p) {
        if (parques.add(p)) {
            p.vincularComunidad(this);
        }
    }

    public void desvincularParque(Parque p) {
        if (parques.remove(p)) {
            p.desvincularComunidad(this);
        }
    }
}
