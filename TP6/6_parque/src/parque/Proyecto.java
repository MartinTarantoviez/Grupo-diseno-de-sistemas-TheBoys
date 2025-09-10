package parque;

import java.time.LocalDate;
import java.util.Objects;

public class Proyecto {
    private final String nombre;
    private final double presupuesto;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;

    public Proyecto(String nombre, double presupuesto, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = Objects.requireNonNull(nombre);
        this.presupuesto = presupuesto;
        this.fechaInicio = Objects.requireNonNull(fechaInicio);
        this.fechaFin = Objects.requireNonNull(fechaFin);
        if (!fechaFin.isAfter(fechaInicio))
            throw new IllegalArgumentException("fechaFin debe ser posterior a fechaInicio");
    }

    public String getNombre() { return nombre; }
    public double getPresupuesto() { return presupuesto; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
}
