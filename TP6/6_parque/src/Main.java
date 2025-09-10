import parque.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        Parque parque = new Parque("Aconcagua", LocalDate.of(1983, 10, 28));

        Area norte = new Area("Norte", 120.5);
        parque.agregarArea(norte);

        EspecieAnimal puma = new EspecieAnimal(
                "Puma concolor", "Puma", null, TipoAlimentacion.CARNIVORA);
        AreaEspecie censo = new AreaEspecie(norte, puma, 8);
        norte.agregarAreaEspecie(censo);

        Alojamiento refugio = new Alojamiento("Refugio Base", 40, "Refugio");
        parque.agregarAlojamiento(refugio);

        Excursion exc = new Excursion("EX-001", LocalDate.now(), LocalTime.of(9, 0));
        exc.agregarAlojamientoOrganizador(refugio);

        Visitante v = new Visitante("12345678", "Joaquín", "Mendoza", "Estudiante");
        exc.inscribirVisitante(v);

        System.out.println("Parque: " + parque.getNombre());
        System.out.println("Áreas: " + parque.getAreas().size());
        System.out.println("Alojamientos: " + parque.getAlojamientos().size());
        System.out.println("Excursiones organizadas: " + exc.getAlojamientosOrganizadores().size());
        System.out.println("Visitantes inscriptos en la excursión: " + exc.getInscripciones().size());
    }
}
