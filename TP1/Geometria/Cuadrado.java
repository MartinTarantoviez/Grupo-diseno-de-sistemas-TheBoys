package Geometria;

public class Cuadrado extends Rectangulo {
    // Herencia: un Cuadrado ES un Rectángulo con base = altura = lado.
    public Cuadrado(Punto origen, double lado) {
        super(origen, lado, lado);
    }
}
