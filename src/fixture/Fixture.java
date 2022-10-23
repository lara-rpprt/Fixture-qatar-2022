package fixture;

import fixture.model.Partido;
import fixture.repository.migrations.ObjectIO;
import fixture.view.Ventana;
import java.util.ArrayList;

public class Fixture {

    public static void main(String[] args) {
        ObjectIO objectIO = new ObjectIO();
        ArrayList<Partido> partidos;
        partidos = (ArrayList<Partido>) objectIO.ReadObjectFromFile("partidos");

        Ventana ventana = new Ventana();
        ventana.setVisible(true);

        for (Partido partido : partidos) {
            System.out.println(partido);
        }

    }

}
