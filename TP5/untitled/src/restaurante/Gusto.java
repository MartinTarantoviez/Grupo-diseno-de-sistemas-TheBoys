package restaurante;

import java.util.Objects;

public class Gusto {
    private final Persona persona;
    private final Restaurante restaurante;
    private final Plato plato;

    public Gusto(Persona persona, Restaurante restaurante, Plato plato) {
        if (persona == null || restaurante == null || plato == null)
            throw new IllegalArgumentException("Datos requeridos");
        this.persona = persona;
        this.restaurante = restaurante;
        this.plato = plato;
    }

    public Persona getPersona() { return persona; }
    public Restaurante getRestaurante() { return restaurante; }
    public Plato getPlato() { return plato; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gusto)) return false;
        Gusto gusto = (Gusto) o;
        return persona.equals(gusto.persona)
                && restaurante.equals(gusto.restaurante)
                && plato.equals(gusto.plato);
    }

    @Override public int hashCode() { return Objects.hash(persona, restaurante, plato); }
}
