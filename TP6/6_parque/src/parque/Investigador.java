package parque;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Investigador extends Personal {
    private String titulacion;
    private final Set<Intervencion> intervenciones = new HashSet<>();

    public Investigador(String dni, String nombre, String direccion, String telefono,
                        double sueldo, String nroSeguridadSocial, String titulacion) {
        super(dni, nombre, direccion, telefono, sueldo, nroSeguridadSocial);
        this.titulacion = Objects.requireNonNull(titulacion);
    }

    public String getTitulacion() { return titulacion; }
    public void setTitulacion(String titulacion) { this.titulacion = Objects.requireNonNull(titulacion); }

    public Set<Intervencion> getIntervenciones() { return Set.copyOf(intervenciones); }

    public void registrarIntervencion(Proyecto proyecto, Especie especie) {
        intervenciones.add(new Intervencion(this, proyecto, especie));
    }
}
