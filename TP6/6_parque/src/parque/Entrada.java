package parque;

import java.util.ArrayList;
import java.util.List;

public class Entrada {
    private final int numero;                 // 1..N dentro del parque
    private Parque parque;                    // backref
    private final List<RegistroVisita> registros = new ArrayList<>();

    public Entrada(int numero) {
        if (numero <= 0) throw new IllegalArgumentException("numero debe ser > 0");
        this.numero = numero;
    }

    public int getNumero() { return numero; }
    public Parque getParque() { return parque; }
    void setParque(Parque parque) { this.parque = parque; }

    public List<RegistroVisita> getRegistros() { return List.copyOf(registros); }
    public void agregarRegistro(RegistroVisita r) { registros.add(r); }
}
