package fixture;

import fixture.model.Equipo;
import fixture.model.Estadio;
import fixture.model.Grupo;
import fixture.repository.ObjectIO;
import fixture.vista.Ventana;
import java.util.ArrayList;

public class Fixture {

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);

        ObjectIO objectIO = new ObjectIO();
        ArrayList<Equipo> equipos;
        ArrayList<Estadio> estadios;
        Grupo[] grupos;

        equipos = (ArrayList<Equipo>) objectIO.ReadObjectFromFile("equipos");
        estadios = (ArrayList<Estadio>) objectIO.ReadObjectFromFile("estadios");

    }

}
