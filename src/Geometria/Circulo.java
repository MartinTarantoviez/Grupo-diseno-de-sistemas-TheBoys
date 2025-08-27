package Geometria;

public class Circulo extends Elipse {
    public Circulo(Punto centro, double radio) {
        super(centro, radio, radio); // a = b = r
    }
}
