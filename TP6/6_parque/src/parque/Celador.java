package parque;

public class Celador extends Personal {
    private Entrada entradaAsignada;

    public Celador(String dni, String nombre, String direccion, String telefono,
                   double sueldo, String nroSeguridadSocial) {
        super(dni, nombre, direccion, telefono, sueldo, nroSeguridadSocial);
    }

    public Entrada getEntradaAsignada() { return entradaAsignada; }
    public void asignarEntrada(Entrada entrada) { this.entradaAsignada = entrada; }
}
