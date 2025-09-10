package Geometria;

import java.util.List;

public interface Figura {
    double area();
    double perimetro();

    // Para las figuras que definamos con vértices, podrán sobreescribir esto.
    default List<Punto> puntos() {
        return List.of();
    }
}