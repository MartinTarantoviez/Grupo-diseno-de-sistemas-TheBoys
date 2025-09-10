package parque;

public class Guarda extends Personal {
    private Area areaAsignada;
    private Vehiculo vehiculo;

    public Guarda(String dni, String nombre, String direccion, String telefono,
                  double sueldo, String nroSeguridadSocial) {
        super(dni, nombre, direccion, telefono, sueldo, nroSeguridadSocial);
    }

    public Area getAreaAsignada() { return areaAsignada; }
    public Vehiculo getVehiculo() { return vehiculo; }

    public void asignarArea(Area area) { this.areaAsignada = area; }
    public void asignarVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
}
