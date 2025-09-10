package parque;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Excursion {
    private final String codigo;
    private final LocalDate dia;
    private final LocalTime hora;

    private final Set<Alojamiento> alojamientosOrganizadores = new HashSet<>();
    private final Set<InscripcionExcursion> inscripciones = new HashSet<>();

    public Excursion(String codigo, LocalDate dia, LocalTime hora) {
        this.codigo = Objects.requireNonNull(codigo);
        this.dia = Objects.requireNonNull(dia);
        this.hora = Objects.requireNonNull(hora);
    }

    public String getCodigo() { return codigo; }
    public LocalDate getDia() { return dia; }
    public LocalTime getHora() { return hora; }

    public Set<Alojamiento> getAlojamientosOrganizadores() { return Set.copyOf(alojamientosOrganizadores); }
    public Set<InscripcionExcursion> getInscripciones() { return Set.copyOf(inscripciones); }

    public void agregarAlojamientoOrganizador(Alojamiento a) {
        alojamientosOrganizadores.add(Objects.requireNonNull(a));
    }

    public void inscribirVisitante(Visitante v) {
        inscripciones.add(new InscripcionExcursion(this, Objects.requireNonNull(v)));
    }
}
