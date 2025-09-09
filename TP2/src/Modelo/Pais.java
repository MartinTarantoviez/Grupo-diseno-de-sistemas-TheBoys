package Modelo;

import java.util.*;

/**
 * Representa un país. Tiene provincias, un continente, fronteras con otros países y una capital (una Ciudad).
 */
public class Pais {
    private String nombre;
    private Continente continente;
    private final List<Provincia> provincias = new ArrayList<>();
    private final Set<Pais> limitaCon = new HashSet<>();
    private Ciudad capital; // puede ser null si aún no se definió

    public Pais(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null");
    }

    public Continente getContinente() {
        return continente;
    }

    /** Usado por Continente.addPais para mantener relación bidireccional */
    void setContinente(Continente continente) {
        this.continente = continente;
    }

    public List<Provincia> getProvincias() {
        return Collections.unmodifiableList(provincias);
    }

    public Set<Pais> getLimitaCon() {
        return Collections.unmodifiableSet(limitaCon);
    }

    public Ciudad getCapital() {
        return capital;
    }

    /** Añade una provincia y fija la referencia bidireccional */
    public void addProvincia(Provincia provincia) {
        if (provincia == null) throw new IllegalArgumentException("provincia no puede ser null");
        if (!provincias.contains(provincia)) {
            provincias.add(provincia);
            provincia.setPais(this);
        }
    }

    public void removeProvincia(Provincia provincia) {
        if (provincias.remove(provincia)) {
            // Si la provincia era el origen de la capital del país, limpiar capital si necesita
            if (capital != null && capital.getProvincia() == provincia) {
                capital = null;
            }
            provincia.setPais(null);
        }
    }

    /** Añade una frontera entre este país y otro (bidireccional) */
    public void addFrontera(Pais otro) {
        if (otro == null) throw new IllegalArgumentException("otro no puede ser null");
        if (otro == this) return; // no permitir fronteras con sí mismo
        if (limitaCon.add(otro)) {
            otro.limitaCon.add(this);
        }
    }

    /** Elimina frontera (bidireccional) */
    public void removeFrontera(Pais otro) {
        if (otro == null) return;
        if (limitaCon.remove(otro)) {
            otro.limitaCon.remove(this);
        }
    }

    /**
     * Establece la capital del país. La ciudad debe pertenecer a una provincia de este país.
     * @param ciudad la ciudad que será capital (puede ser null para quitar capital)
     */
    public void setCapital(Ciudad ciudad) {
        if (ciudad == null) {
            if (this.capital != null) {
                this.capital.setEsCapitalDePais(false);
            }
            this.capital = null;
            return;
        }
        Provincia prov = ciudad.getProvincia();
        if (prov == null || prov.getPais() != this) {
            throw new IllegalArgumentException("La ciudad debe pertenecer a una provincia de este país para ser su capital.");
        }
        // limpiar capital anterior si existe
        if (this.capital != null) {
            this.capital.setEsCapitalDePais(false);
        }
        this.capital = ciudad;
        ciudad.setEsCapitalDePais(true);
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nombre='" + nombre + '\'' +
                ", continente=" + (continente != null ? continente.getNombre() : "null") +
                ", numProvincias=" + provincias.size() +
                ", numFronteras=" + limitaCon.size() +
                ", capital=" + (capital != null ? capital.getNombre() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pais pais = (Pais) o;
        return Objects.equals(nombre, pais.nombre) &&
                Objects.equals(continente, pais.continente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, continente);
    }
}
