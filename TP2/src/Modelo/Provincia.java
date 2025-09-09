package Modelo;

import java.util.*;

/**
 * Representa una provincia. Pertenece a un país, tiene ciudades, puede limitar con otras provincias.
 */
public class Provincia {
    private String nombre;
    private Pais pais;
    private final List<Ciudad> ciudades = new ArrayList<>();
    private final Set<Provincia> limitaCon = new HashSet<>();
    private Ciudad capital; // puede ser null

    public Provincia(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
    }

    public Pais getPais() {
        return pais;
    }

    /** Usado por Pais.addProvincia para mantener referencia bidireccional */
    void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Ciudad> getCiudades() {
        return Collections.unmodifiableList(ciudades);
    }

    public Set<Provincia> getLimitaCon() {
        return Collections.unmodifiableSet(limitaCon);
    }

    public Ciudad getCapital() {
        return capital;
    }

    /** Crea y añade una ciudad a la provincia */
    public Ciudad crearCiudad(String nombreCiudad) {
        Ciudad c = new Ciudad(nombreCiudad, this);
        addCiudad(c);
        return c;
    }

    /** Añade una ciudad (y fija la referencia de la ciudad a esta provincia) */
    public void addCiudad(Ciudad ciudad) {
        if (ciudad == null) throw new IllegalArgumentException("ciudad no puede ser null");
        if (ciudad.getProvincia() != this) {
            // Aseguramos consistencia: forzamos la provincia de la ciudad a esta
            ciudad.setProvincia(this);
        }
        if (!ciudades.contains(ciudad)) {
            ciudades.add(ciudad);
        }
    }

    public void removeCiudad(Ciudad ciudad) {
        if (ciudades.remove(ciudad)) {
            if (capital != null && capital.equals(ciudad)) {
                capital.setEsCapitalDeProvincia(false);
                capital = null;
            }
            ciudad.setProvincia(null);
        }
    }

    /** Añade una frontera entre provincias (bidireccional). Pueden ser de distinto país según el enunciado. */
    public void addFrontera(Provincia otra) {
        if (otra == null) throw new IllegalArgumentException("otra no puede ser null");
        if (otra == this) return;
        if (limitaCon.add(otra)) {
            otra.limitaCon.add(this);
        }
    }

    public void removeFrontera(Provincia otra) {
        if (otra == null) return;
        if (limitaCon.remove(otra)) {
            otra.limitaCon.remove(this);
        }
    }

    /**
     * Establece la capital de la provincia. La ciudad debe pertenecer a esta provincia.
     * @param ciudad la ciudad que será capital (puede ser null para quitar capital)
     */
    public void setCapital(Ciudad ciudad) {
        if (ciudad == null) {
            if (this.capital != null) {
                this.capital.setEsCapitalDeProvincia(false);
            }
            this.capital = null;
            return;
        }
        if (ciudad.getProvincia() != this) {
            throw new IllegalArgumentException("La ciudad debe pertenecer a esta provincia para ser su capital.");
        }
        if (this.capital != null) {
            this.capital.setEsCapitalDeProvincia(false);
        }
        this.capital = ciudad;
        ciudad.setEsCapitalDeProvincia(true);
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "nombre='" + nombre + '\'' +
                ", pais=" + (pais != null ? pais.getNombre() : "null") +
                ", numCiudades=" + ciudades.size() +
                ", numFronteras=" + limitaCon.size() +
                ", capital=" + (capital != null ? capital.getNombre() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Provincia provincia = (Provincia) o;
        return Objects.equals(nombre, provincia.nombre) &&
                Objects.equals(pais, provincia.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, pais);
    }
}
