package fixture;

import fixture.model.Equipo;
import fixture.model.Estadio;
import fixture.model.Fase;
import fixture.model.Grupo;
import fixture.model.Partido;
import fixture.repository.ObjectIO;
import fixture.repository.PartidosMigrations;
import fixture.vista.Ventana;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Fixture {

    public static void main(String[] args) {
        ObjectIO objectIO = new ObjectIO();
        ArrayList<Partido> partidos;
        partidos = (ArrayList<Partido>) objectIO.ReadObjectFromFile("partidos");

        // Ventana ventana = new Ventana();
        //ventana.setVisible(true);

        for (Partido partido : partidos) {
            System.out.println(partido);
        }

    }

}
