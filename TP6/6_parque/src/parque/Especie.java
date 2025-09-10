package parque;

import java.util.Objects;

public abstract class Especie {
    private final String nombreCientifico;
    private final String nombreVulgar;

    protected Especie(String nombreCientifico, String nombreVulgar) {
        this.nombreCientifico = Objects.requireNonNull(nombreCientifico);
        this.nombreVulgar = Objects.requireNonNull(nombreVulgar);
    }

    public String getNombreCientifico() { return nombreCientifico; }
    public String getNombreVulgar() { return nombreVulgar; }
}
