package parque;

import java.util.Objects;

public class InscripcionExcursion {
    private final Excursion excursion;
    private final Visitante visitante;

    public InscripcionExcursion(Excursion excursion, Visitante visitante) {
        this.excursion = Objects.requireNonNull(excursion);
        this.visitante = Objects.requireNonNull(visitante);
    }

    public Excursion getExcursion() { return excursion; }
    public Visitante getVisitante() { return visitante; }
}
