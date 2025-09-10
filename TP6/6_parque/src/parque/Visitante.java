package parque;

import java.util.Objects;

public class Visitante {
    private final String dni;
    private String nombre;
    private String direccion;
    private String profesion;

    public Visitante(String dni, String nombre, String direccion, String profesion) {
        this.dni = Objects.requireNonNull(dni);
        this.nombre = Objects.requireNonNull(nombre);
        this.direccion = Objects.requireNonNull(direccion);
        this.profesion = Objects.requireNonNull(profesion);
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getProfesion() { return profesion; }

    public void setNombre(String nombre) { this.nombre = Objects.requireNonNull(nombre); }
    public void setDireccion(String direccion) { this.direccion = Objects.requireNonNull(direccion); }
    public void setProfesion(String profesion) { this.profesion = Objects.requireNonNull(profesion); }
}
