package parque;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Area {
    private final String nombre;  // único dentro del parque
    private final double km2;
    private Parque parque;        // backref
    private final List<AreaEspecie> especies = new ArrayList<>();

    public Area(String nombre, double km2) {
        if (km2 <= 0) throw new IllegalArgumentException("km2 debe ser > 0");
        this.nombre = Objects.requireNonNull(nombre);
        this.km2 = km2;
    }

    public String getNombre() { return nombre; }
    public double getKm2() { return km2; }
    public Parque getParque() { return parque; }
    void setParque(Parque parque) { this.parque = parque; }

    public List<AreaEspecie> getEspeciesCensadas() { return List.copyOf(especies); }

    public void agregarAreaEspecie(AreaEspecie ae) {
        Objects.requireNonNull(ae);
        especies.add(ae);
    }
}
