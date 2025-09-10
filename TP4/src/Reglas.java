import java.util.Set;

public class Reglas {
    // Definimos qué minerales consideramos "primarios"
    private static final Set<Mineral> PRIMARIOS = Set.of(
            Mineral.NITROGENO, Mineral.FOSFORO, Mineral.AZUFRE
    );

    // Lote especial si tiene al menos un mineral primario
    public static boolean esEspecial(Lote lote) {
        for (Mineral m : lote.mineralesDelSuelo) {
            if (PRIMARIOS.contains(m)) return true;
        }
        return false;
    }

    // ¿El lote satisface TODOS los minerales que pide el cereal?
    private static boolean contieneTodos(Lote lote, Cereal cereal) {
        return lote.mineralesDelSuelo.containsAll(cereal.mineralesRequeridos);
    }

    // Regla completa: minerales + restricción de pasturas
    public static boolean puedeSembrarse(Lote lote, Cereal cereal) {
        boolean mineralesOk = contieneTodos(lote, cereal);
        boolean pasturaOk = !(cereal.tipo == TipoCereal.PASTURA && lote.huboPasturaAntes);
        return mineralesOk && pasturaOk;
    }
}
