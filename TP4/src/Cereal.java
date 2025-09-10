import java.util.Set;




public class Cereal {
    String nombre;
    TipoCereal tipo;
    Set<Mineral> mineralesRequeridos;

    public Cereal(String nombre, TipoCereal tipo, Set<Mineral> mineralesRequeridos) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.mineralesRequeridos = mineralesRequeridos;
    }
}
