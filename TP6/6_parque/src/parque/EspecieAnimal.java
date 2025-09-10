package parque;

import java.util.HashSet;
import java.util.Set;

public class EspecieAnimal extends Especie {
    private final String periodoCelo;                 // puede ser null
    private final TipoAlimentacion tipoAlimentacion;
    private final Set<Dieta> dieta = new HashSet<>();

    public EspecieAnimal(String nombreCientifico, String nombreVulgar,
                         String periodoCelo, TipoAlimentacion tipoAlimentacion) {
        super(nombreCientifico, nombreVulgar);
        this.periodoCelo = periodoCelo;
        this.tipoAlimentacion = tipoAlimentacion;
    }

    public String getPeriodoCelo() { return periodoCelo; }
    public TipoAlimentacion getTipoAlimentacion() { return tipoAlimentacion; }
    public Set<Dieta> getDieta() { return Set.copyOf(dieta); }

    public void agregarAlimento(Especie alimento) {
        dieta.add(new Dieta(this, alimento));
    }
}
