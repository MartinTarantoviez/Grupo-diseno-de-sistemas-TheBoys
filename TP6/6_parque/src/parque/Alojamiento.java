package parque;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alojamiento {
    private final String nombre;     // único dentro del parque
    private final int capacidad;
    private final String categoria;
    private Parque parque;           // backref
    private final List<UsoAlojamiento> usos = new ArrayList<>();

    public Alojamiento(String nombre, int capacidad, String categoria) {
        if (capacidad <= 0) throw new IllegalArgumentException("capacidad debe ser > 0");
        this.nombre = Objects.requireNonNull(nombre);
        this.capacidad = capacidad;
        this.categoria = Objects.requireNonNull(categoria);
    }

    public String getNombre() { return nombre; }
    public int getCapacidad() { return capacidad; }
    public String getCategoria() { return categoria; }
    public Parque getParque() { return parque; }
    void setParque(Parque parque) { this.parque = parque; }

    public List<UsoAlojamiento> getUsos() { return List.copyOf(usos); }

    public void registrarUso(UsoAlojamiento uso) {
        usos.add(Objects.requireNonNull(uso));
    }
}
