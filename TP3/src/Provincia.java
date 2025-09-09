import java.util.ArrayList;
import java.util.List;

class Provincia {
    private String nombre;
    private List<Ciudades> ciudades;

    public Provincia(String nombre) {
        this.nombre = nombre;
        this.ciudades = new ArrayList<>();
    }

    public void agregarCiudad(Ciudades ciudad) {
        ciudades.add(ciudad);
    }

    // Porcentaje de ciudades con déficit
    public double porcDeCiudDeficit() {
        if (ciudades.isEmpty()) return 0;
        long enDeficit = ciudades.stream().filter(Ciudades::totalDeficit).count();
        return (enDeficit * 100.0) / ciudades.size();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public List<Ciudades> getCiudades() {
        return ciudades;
    }
}