import java.util.ArrayList;
import java.util.List;

class Pais {
    private String nombre;
    private List<Provincia> provincias;

    public Pais(String nombre) {
        this.nombre = nombre;
        this.provincias = new ArrayList<>();
    }

    public void agregarProvincia(Provincia provincia) {
        provincias.add(provincia);
    }

    // Retorna lista de ciudades en déficit
    public List<Ciudades> obtDeficitCiudades() {
        List<Ciudades> deficit = new ArrayList<>();
        for (Provincia p : provincias) {
            for (Ciudades c : p.getCiudades()) {
                if (c.totalDeficit()) {
                    deficit.add(c);
                }
            }
        }
        return deficit;
    }

    // Retorna lista de provincias con ciudades en déficit
    public List<Provincia> obtDeficitProvincias() {
        List<Provincia> deficit = new ArrayList<>();
        for (Provincia p : provincias) {
            if (p.porcDeCiudDeficit() > 0) {
                deficit.add(p);
            }
        }
        return deficit;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }
}