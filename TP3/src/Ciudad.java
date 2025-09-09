import java.util.ArrayList;
import java.util.List;

class Ciudades {
    private String nombre;
    private int habitantes;
    private double gastos;
    private List<Impuestos> impuestos; // 0..5 impuestos

    public Ciudades(String nombre, int habitantes, double gastos) {
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.gastos = gastos;
        this.impuestos = new ArrayList<>();
    }

    public void agregarImpuesto(Impuestos imp) {
        if (impuestos.size() < 5) {
            impuestos.add(imp);
        } else {
            System.out.println("No se pueden agregar más de 5 impuestos.");
        }
    }

    public double totalRecaudado() {
        return impuestos.stream().mapToDouble(Impuestos::getMonto).sum();
    }

    public boolean totalDeficit() {
        return totalRecaudado() < gastos;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public double getGastos() {
        return gastos;
    }
}
