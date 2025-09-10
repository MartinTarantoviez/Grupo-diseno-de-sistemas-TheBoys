import java.util.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Creo algunos cereales
        Cereal trigo = new Cereal(
                "Trigo",
                TipoCereal.FINA,
                Set.of(Mineral.NITROGENO)
        );

        Cereal maiz = new Cereal(
                "Maíz",
                TipoCereal.GRUESA,
                Set.of(Mineral.NITROGENO, Mineral.AZUFRE)
        );

        Cereal alfalfa = new Cereal(
                "Alfalfa",
                TipoCereal.PASTURA,
                Set.of(Mineral.FOSFORO, Mineral.CALCIO)
        );

        // Lote con minerales y sin pasturas previas
        Lote lote1 = new Lote(
                new HashSet<>(Arrays.asList(Mineral.NITROGENO, Mineral.FOSFORO, Mineral.CALCIO)),
                false
        );

        System.out.println("¿Lote1 es especial? " + Reglas.esEspecial(lote1));
        System.out.println("¿Trigo puede? " + Reglas.puedeSembrarse(lote1, trigo));
        System.out.println("¿Maíz puede? " + Reglas.puedeSembrarse(lote1, maiz));
        System.out.println("¿Alfalfa (pastura) puede? " + Reglas.puedeSembrarse(lote1, alfalfa));
    }
}