import java.util.Set;

public class Lote {
    Set<Mineral> mineralesDelSuelo;
    boolean huboPasturaAntes;

    public Lote(Set<Mineral> mineralesDelSuelo, boolean huboPasturaAntes) {
        this.mineralesDelSuelo = mineralesDelSuelo;
        this.huboPasturaAntes = huboPasturaAntes;
    }
}
