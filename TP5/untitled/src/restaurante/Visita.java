package restaurante;

import java.time.LocalDate;
import java.util.Objects;

public class Visita {
    private final Persona persona;
    private final Sucursal sucursal;
    private final LocalDate fecha;

    public Visita(Persona persona, Sucursal sucursal, LocalDate fecha) {
        if (persona == null || sucursal == null) throw new IllegalArgumentException("Datos requeridos");
        this.persona = persona;
        this.sucursal = sucursal;
        this.fecha = (fecha == null) ? LocalDate.now() : fecha;
    }

    public Persona getPersona() { return persona; }
    public Sucursal getSucursal() { return sucursal; }
    public LocalDate getFecha() { return fecha; }

    @Override public String toString() { return persona.getNombre() + " → " + sucursal + " (" + fecha + ")"; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visita)) return false;
        Visita visita = (Visita) o;
        return persona.equals(visita.persona) && sucursal.equals(visita.sucursal) && fecha.equals(visita.fecha);
    }

    @Override public int hashCode() { return Objects.hash(persona, sucursal, fecha); }
}
