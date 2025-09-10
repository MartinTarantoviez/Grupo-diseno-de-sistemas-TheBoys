package parque;

import java.util.Objects;

public class Vehiculo {
    private final String tipo;
    private final String matricula;

    public Vehiculo(String tipo, String matricula) {
        this.tipo = Objects.requireNonNull(tipo);
        this.matricula = Objects.requireNonNull(matricula);
    }

    public String getTipo() { return tipo; }
    public String getMatricula() { return matricula; }
}
