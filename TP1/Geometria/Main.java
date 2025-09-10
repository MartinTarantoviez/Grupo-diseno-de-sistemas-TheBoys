package Geometria;

public class Main {
    public static void main(String[] args) {
        // 🔹 Crear puntos (los vamos a reusar en varias figuras)
        Punto p1 = new Punto(0, 0);
        Punto p2 = new Punto(4, 0);
        Punto p3 = new Punto(0, 3);

        // 🔹 Triángulo (definido por 3 puntos)
        Triangulo t = new Triangulo(p1, p2, p3);
        System.out.println("Perímetro triángulo = " + t.perimetro());
        System.out.println("Área triángulo = " + t.area());

        // 🔹 Rectángulo (origen + base + altura)
        Rectangulo r = new Rectangulo(new Punto(0,0), 5, 2);
        System.out.println("Área rectángulo = " + r.area());
        System.out.println("Perímetro rectángulo = " + r.perimetro());

        // 🔹 Cuadrado (es un rectángulo especial)
        Cuadrado q = new Cuadrado(new Punto(1,1), 3);
        System.out.println("Área cuadrado = " + q.area());
        System.out.println("Perímetro cuadrado = " + q.perimetro());

        // 🔹 Círculo (caso particular de la elipse)
        Circulo c = new Circulo(new Punto(2,2), 3);
        System.out.println("Área círculo = " + c.area());
        System.out.println("Perímetro círculo ≈ " + c.perimetro());
    }
}
