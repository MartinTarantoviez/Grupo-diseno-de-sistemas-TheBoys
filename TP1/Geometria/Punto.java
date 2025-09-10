package Geometria;

public class Punto {
    private final double x;
    private final double y;

    // Constructor: al crear un Punto, guardás sus coordenadas.
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters: exponen las coordenadas (pero el punto es inmutable).
    public double getX() { return x; }
    public double getY() { return y; }
}