package parque;

import java.util.Objects;

public abstract class Personal {
    private final String dni;
    private String nombre;
    private String direccion;
    private String telefono;
    private double sueldo;
    private String nroSeguridadSocial;
    private Parque parque;   // trabaja en

    protected Personal(String dni, String nombre, String direccion, String telefono,
                       double sueldo, String nroSeguridadSocial) {
        this.dni = Objects.requireNonNull(dni);
        this.nombre = Objects.requireNonNull(nombre);
        this.direccion = Objects.requireNonNull(direccion);
        this.telefono = Objects.requireNonNull(telefono);
        this.sueldo = sueldo;
        this.nroSeguridadSocial = Objects.requireNonNull(nroSeguridadSocial);
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public double getSueldo() { return sueldo; }
    public String getNroSeguridadSocial() { return nroSeguridadSocial; }
    public Parque getParque() { return parque; }

    void setParque(Parque parque) { this.parque = parque; } // package-private

    public void setNombre(String nombre) { this.nombre = Objects.requireNonNull(nombre); }
    public void setDireccion(String direccion) { this.direccion = Objects.requireNonNull(direccion); }
    public void setTelefono(String telefono) { this.telefono = Objects.requireNonNull(telefono); }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }
    public void setNroSeguridadSocial(String nss) { this.nroSeguridadSocial = Objects.requireNonNull(nss); }
}
