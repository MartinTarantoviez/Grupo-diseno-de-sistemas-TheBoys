package parque;

import java.util.Objects;

public class AreaEspecie {
    private final Area area;
    private final Especie especie;
    private int numIndividuos;

    public AreaEspecie(Area area, Especie especie, int numIndividuos) {
        this.area = Objects.requireNonNull(area);
        this.especie = Objects.requireNonNull(especie);
        setNumIndividuos(numIndividuos);
    }

    public Area getArea() { return area; }
    public Especie getEspecie() { return especie; }
    public int getNumIndividuos() { return numIndividuos; }

    public final void setNumIndividuos(int n) {
        if (n < 0) throw new IllegalArgumentException("numIndividuos no puede ser negativo");
        this.numIndividuos = n;
    }
}
