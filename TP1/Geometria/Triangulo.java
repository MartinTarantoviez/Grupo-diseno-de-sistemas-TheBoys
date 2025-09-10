package Geometria;

public class Triangulo implements Figura {
    private final Punto a;
    private final Punto b;
    private final Punto c;

    // Al crear un Triangulo, le pasás sus 3 vértices (composición: "tiene puntos").
    public Triangulo(Punto a, Punto b, Punto c) {
        if (a == null || b == null || c == null)
            throw new IllegalArgumentException("Los puntos no pueden ser null.");
        this.a = a; this.b = b; this.c = c;
        if (area() == 0.0)
            throw new IllegalArgumentException("Puntos colineales: no forman un triángulo.");
    }

    public Punto getA() { return a; }
    public Punto getB() { return b; }
    public Punto getC() { return c; }

    private double dist(Punto p1, Punto p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.hypot(dx, dy);
    }

    @Override
    public double perimetro() {
        return dist(a,b) + dist(b,c) + dist(c,a);
    }

    @Override
    public double area() {
        // Herón: s = (a+b+c)/2; A = sqrt(s(s-a)(s-b)(s-c))
        double ab = dist(a,b), bc = dist(b,c), ca = dist(c,a);
        double s = (ab + bc + ca) / 2.0;
        return Math.sqrt(Math.max(0, s * (s - ab) * (s - bc) * (s - ca)));
    }
}
