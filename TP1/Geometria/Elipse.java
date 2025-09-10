package Geometria;

public class Elipse implements Figura {
    private final Punto centro;
    private final double a; // semieje mayor
    private final double b; // semieje menor

    public Elipse(Punto centro, double a, double b) {
        if (centro == null) throw new IllegalArgumentException("Centro no puede ser null.");
        if (a <= 0 || b <= 0) throw new IllegalArgumentException("Semiejes deben ser > 0.");
        this.centro = centro;
        this.a = a; this.b = b;
    }

    public Punto getCentro() { return centro; }
    public double getA() { return a; }
    public double getB() { return b; }

    @Override public double area() { return Math.PI * a * b; }

    // Perímetro (aprox. Ramanujan) — lo usamos para no meternos con integrales.
    @Override
    public double perimetro() {
        double h = Math.pow(a - b, 2) / Math.pow(a + b, 2);
        return Math.PI * (a + b) * (1 + (3*h) / (10 + Math.sqrt(4 - 3*h)));
    }
}
