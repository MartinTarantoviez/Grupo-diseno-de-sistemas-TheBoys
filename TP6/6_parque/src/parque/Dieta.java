package parque;

import java.util.Objects;

public class Dieta {
    private final EspecieAnimal consumidor;
    private final Especie alimento;

    public Dieta(EspecieAnimal consumidor, Especie alimento) {
        this.consumidor = Objects.requireNonNull(consumidor);
        this.alimento = Objects.requireNonNull(alimento);
    }

    public EspecieAnimal getConsumidor() { return consumidor; }
    public Especie getAlimento() { return alimento; }
}
