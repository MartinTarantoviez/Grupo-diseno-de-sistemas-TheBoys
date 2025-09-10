package parque;

import java.time.LocalDate;
import java.util.Objects;

public class RegistroVisita {
    private final LocalDate fecha;
    private final Entrada entrada;
    private final Visitante visitante;
    private final Celador celador;

    public RegistroVisita(LocalDate fecha, Entrada entrada, Visitante visitante, Celador celador) {
        this.fecha = Objects.requireNonNull(fecha);
        this.entrada = Objects.requireNonNull(entrada);
        this.visitante = Objects.requireNonNull(visitante);
        this.celador = Objects.requireNonNull(celador);
    }

    public LocalDate getFecha() { return fecha; }
    public Entrada getEntrada() { return entrada; }
    public Visitante getVisitante() { return visitante; }
    public Celador getCelador() { return celador; }
}
