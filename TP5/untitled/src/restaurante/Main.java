package restaurante;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Platos
        Plato milanesa = new Plato("Milanesa con papas");
        Plato pastas   = new Plato("Sorrentinos 4 quesos");
        Plato pizza    = new Plato("Pizza napolitana");

        // Restaurantes y sucursales
        Restaurante laNonna = new Restaurante("La Nonna");
        Sucursal laNonnaCentro = laNonna.agregarSucursal("San Martín 123");
        laNonna.ofrecerPlato(milanesa, 6500.0);
        laNonna.ofrecerPlato(pastas,   7200.0);

        Restaurante pizzaFan = new Restaurante("PizzaFan");
        Sucursal pizzaFanCentro = pizzaFan.agregarSucursal("Belgrano 555");
        pizzaFan.ofrecerPlato(pizza, 4300.0);

        // Personas
        Persona ana = new Persona("Ana");
        ana.frecuentar(laNonna);
        ana.visitar(laNonnaCentro, LocalDate.now().minusDays(2));
        ana.meGusta(laNonna, pastas);

        Persona leo = new Persona("Leandro");
        leo.frecuentar(laNonna);
        leo.frecuentar(pizzaFan);
        leo.meGusta(laNonna, milanesa);
        leo.meGusta(pizzaFan, pizza);
        leo.visitar(pizzaFanCentro, LocalDate.now());

        // Salidas
        System.out.println("¿A Ana le gustan las pastas en La Nonna? " + ana.leGusta(laNonna, pastas));
        System.out.println("¿A Ana le gustan las milanesas en PizzaFan? " + ana.leGusta(pizzaFan, milanesa));
        System.out.println("Platos que le gustan a Leo en La Nonna: " + leo.platosQueMeGustanEn(laNonna));
        System.out.println("Restaurantes donde Leo tiene algún gusto: " + leo.restaurantesDondeTengoAlgúnGusto());
    }
}
