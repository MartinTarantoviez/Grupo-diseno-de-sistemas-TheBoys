package parque;

public class EspecieVegetal extends Especie {
    private final boolean tieneFloracion;
    private final String periodoFloracion; // nullable si no tiene

    public EspecieVegetal(String nombreCientifico, String nombreVulgar,
                          Boolean tieneFloracion, String periodoFloracion) {
        super(nombreCientifico, nombreVulgar);
        this.tieneFloracion = Boolean.TRUE.equals(tieneFloracion);
        this.periodoFloracion = this.tieneFloracion ? periodoFloracion : null;
    }

    public boolean isTieneFloracion() { return tieneFloracion; }
    public String getPeriodoFloracion() { return periodoFloracion; }
}
