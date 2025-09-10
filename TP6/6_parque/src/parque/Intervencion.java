package parque;

import java.util.Objects;

public class Intervencion {
    private final Investigador investigador;
    private final Proyecto proyecto;
    private final Especie especie;

    public Intervencion(Investigador investigador, Proyecto proyecto, Especie especie) {
        this.investigador = Objects.requireNonNull(investigador);
        this.proyecto = Objects.requireNonNull(proyecto);
        this.especie = Objects.requireNonNull(especie);
    }

    public Investigador getInvestigador() { return investigador; }
    public Proyecto getProyecto() { return proyecto; }
    public Especie getEspecie() { return especie; }
}
