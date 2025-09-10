package parque;

import java.time.LocalDate;
import java.util.*;

public class Parque {
    private final String nombre;                 // único en el dominio
    private final LocalDate fechaDeclaracionPN;

    private final Set<ComunidadAutonoma> comunidades = new HashSet<>();
    private final List<Area> areas = new ArrayList<>();
    private final List<Alojamiento> alojamientos = new ArrayList<>();
    private final List<Entrada> entradas = new ArrayList<>();
    private final Set<Personal> personal = new HashSet<>();

    public Parque(String nombre, LocalDate fechaDeclaracionPN) {
        this.nombre = Objects.requireNonNull(nombre);
        this.fechaDeclaracionPN = Objects.requireNonNull(fechaDeclaracionPN);
    }

    public String getNombre() { return nombre; }
    public LocalDate getFechaDeclaracionPN() { return fechaDeclaracionPN; }

    public Set<ComunidadAutonoma> getComunidades() { return Set.copyOf(comunidades); }
    public List<Area> getAreas() { return List.copyOf(areas); }
    public List<Alojamiento> getAlojamientos() { return List.copyOf(alojamientos); }
    public List<Entrada> getEntradas() { return List.copyOf(entradas); }
    public Set<Personal> getPersonal() { return Set.copyOf(personal); }

    /* CCAA (N–N) */
    void vincularComunidad(ComunidadAutonoma ca) { comunidades.add(ca); }
    void desvincularComunidad(ComunidadAutonoma ca) { comunidades.remove(ca); }

    /* Áreas (composición) */
    public void agregarArea(Area area) {
        Objects.requireNonNull(area);
        // nombre de área único dentro del parque
        boolean repetido = areas.stream().anyMatch(a -> a.getNombre().equalsIgnoreCase(area.getNombre()));
        if (repetido) throw new IllegalArgumentException("Nombre de área repetido en este parque.");
        areas.add(area);
        area.setParque(this);
    }

    /* Alojamientos (composición) */
    public void agregarAlojamiento(Alojamiento a) {
        Objects.requireNonNull(a);
        boolean repetido = alojamientos.stream().anyMatch(x -> x.getNombre().equalsIgnoreCase(a.getNombre()));
        if (repetido) throw new IllegalArgumentException("Nombre de alojamiento repetido en este parque.");
        alojamientos.add(a);
        a.setParque(this);
    }

    /* Entradas (composición). Se numeran 1..N */
    public Entrada crearEntrada() {
        int numero = entradas.size() + 1;
        Entrada e = new Entrada(numero);
        e.setParque(this);
        entradas.add(e);
        return e;
    }

    /* Personal (asociación 1 parque) */
    void agregarPersonal(Personal p) {
        if (personal.add(p)) {
            p.setParque(this);
        }
    }
}
