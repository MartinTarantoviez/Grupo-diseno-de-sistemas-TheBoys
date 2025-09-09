package Modelo;

/**
 * Ejemplo de uso de las clases Continente, Pais, Provincia y Ciudad.
 */
public class Main {
    public static void main(String[] args) {
        // 1) Crear continente y países
        Continente sudamerica = new Continente("Sudamérica");

        Pais argentina = new Pais("Argentina");
        Pais chile = new Pais("Chile");

        sudamerica.addPais(argentina);
        sudamerica.addPais(chile);

        // 2) Añadir provincias a cada país
        Provincia buenosAires = new Provincia("Buenos Aires");
        Provincia cordoba = new Provincia("Córdoba");
        Provincia regionMetropolitana = new Provincia("Región Metropolitana");

        argentina.addProvincia(buenosAires);
        argentina.addProvincia(cordoba);
        chile.addProvincia(regionMetropolitana);

        // 3) Crear ciudades (usar Provincia.crearCiudad para consistencia)
        Ciudad laPlata = buenosAires.crearCiudad("La Plata");
        Ciudad ciudadDeBsAs = buenosAires.crearCiudad("Ciudad de Buenos Aires");
        Ciudad cordobaCity = cordoba.crearCiudad("Córdoba");
        Ciudad santiago = regionMetropolitana.crearCiudad("Santiago");

        // 4) Establecer capitales de provincia
        buenosAires.setCapital(ciudadDeBsAs);
        cordoba.setCapital(cordobaCity);
        regionMetropolitana.setCapital(santiago);

        // 5) Establecer capitales de país (la ciudad debe pertenecer a una provincia del país)
        argentina.setCapital(ciudadDeBsAs);
        chile.setCapital(santiago);

        // 6) Fronteras (país <-> país y provincia <-> provincia)
        argentina.addFrontera(chile);           // frontera bidireccional entre países
        buenosAires.addFrontera(cordoba);      // frontera bidireccional entre provincias (ejemplo)

        // 7) Mostrar el contenido del continente / países
        System.out.println("=== CONTINENTE ===");
        System.out.println(sudamerica);
        System.out.println();

        for (Pais p : sudamerica.getPaises()) {
            imprimirPais(p);
            System.out.println();
        }

        // 8) Intento inválido: poner como capital de Argentina una ciudad que pertenece a Chile
        try {
            System.out.println("Intentando asignar Santiago (ciudad de Chile) como capital de Argentina...");
            argentina.setCapital(santiago); // debe lanzar IllegalArgumentException
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        // 9) Comprobación de fronteras (bidireccionalidad)
        System.out.println();
        System.out.println("Fronteras de Argentina: " + nombresPaises(argentina.getLimitaCon()));
        System.out.println("Fronteras de Chile: " + nombresPaises(chile.getLimitaCon()));
    }

    private static void imprimirPais(Pais p) {
        System.out.println(p);
        System.out.println(" Provincias:");
        for (Provincia prov : p.getProvincias()) {
            String nombreCapitalProv = prov.getCapital() != null ? prov.getCapital().getNombre() : "—";
            System.out.printf("  - %s (capital provincia: %s)%n", prov.getNombre(), nombreCapitalProv);
            for (Ciudad c : prov.getCiudades()) {
                System.out.printf("     * %s  [capProvincia=%b, capPais=%b]%n",
                        c.getNombre(), c.isEsCapitalDeProvincia(), c.isEsCapitalDePais());
            }
        }
    }

    private static String nombresPaises(java.util.Set<Pais> conjunto) {
        if (conjunto.isEmpty()) return "ninguno";
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Pais p : conjunto) {
            if (!first) sb.append(", ");
            sb.append(p.getNombre());
            first = false;
        }
        return sb.toString();
    }
}
