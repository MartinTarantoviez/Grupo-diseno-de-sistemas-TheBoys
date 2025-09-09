





public class Main {
    public static void main(String[] args) {
        // Crear impuestos
        Impuestos iva = new Impuestos("IVA", 5000);
        Impuestos ganancias = new Impuestos("Ganancias", 3000);

        // Crear ciudades
        Ciudades ciudad1 = new Ciudades("Ciudad A", 100000, 10000);
        ciudad1.agregarImpuesto(iva);
        ciudad1.agregarImpuesto(ganancias);

        Ciudades ciudad2 = new Ciudades("Ciudad B", 50000, 20000);
        ciudad2.agregarImpuesto(new Impuestos("IVA", 4000));

        // Crear provincia
        Provincia prov1 = new Provincia("Provincia X");
        prov1.agregarCiudad(ciudad1);
        prov1.agregarCiudad(ciudad2);

        // Crear país
        Pais pais = new Pais("Argentina");
        pais.agregarProvincia(prov1);

        // Probar métodos
        System.out.println("Porcentaje de ciudades con déficit en " + prov1.getNombre() + ": " + prov1.porcDeCiudDeficit() + "%");
        System.out.println("Ciudades en déficit: ");
        for (Ciudades c : pais.obtDeficitCiudades()) {
            System.out.println("- " + c.getNombre());
        }
    }
}