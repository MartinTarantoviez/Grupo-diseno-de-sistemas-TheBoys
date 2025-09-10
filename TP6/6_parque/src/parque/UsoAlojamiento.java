package parque;

import java.time.LocalDate;
import java.util.Objects;

public class UsoAlojamiento {
    private final Visitante visitante;
    private final Alojamiento alojamiento;
    private final String habitacion;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;

    public UsoAlojamiento(Visitante visitante, Alojamiento alojamiento, String habitacion,
                          LocalDate fechaInicio, LocalDate fechaFin) {
        this.visitante = Objects.requireNonNull(visitante);
        this.alojamiento = Objects.requireNonNull(alojamiento);
        this.habitacion = Objects.requireNonNull(habitacion);
        this.fechaInicio = Objects.requireNonNull(fechaInicio);
        this.fechaFin = Objects.requireNonNull(fechaFin);
        if (!fechaFin.isAfter(fechaInicio))
            throw new IllegalArgumentException("fechaFin debe ser posterior a fechaInicio");
    }

    public Visitante getVisitante() { return visitante; }
    public Alojamiento getAlojamiento() { return alojamiento; }
    public String getHabitacion() { return habitacion; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
}
