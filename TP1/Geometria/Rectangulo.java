package Geometria;

public class Rectangulo implements Figura {
    // Usamos el vértice inferior-izquierdo como "origen" por convención.
    private final Punto origen;
    private final double base;
    private final double altura;

    public Rectangulo(Punto origen, double base, double altura) {
        if (origen == null) throw new IllegalArgumentException("Origen no puede ser null.");
        if (base <= 0 || altura <= 0) throw new IllegalArgumentException("Base y altura deben ser > 0.");
        this.origen = origen;
        this.base = base;
        this.altura = altura;
    }

    public Punto getOrigen() { return origen; }
    public double getBase() { return base; }
    public double getAltura() { return altura; }

    @Override public double area() { return base * altura; }
    @Override public double perimetro() { return 2 * (base + altura); }
}
