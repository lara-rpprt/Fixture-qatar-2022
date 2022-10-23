package fixture.repository.migrations;

import fixture.model.Estadio;
import java.util.ArrayList;

public class EstadiosMigrations {

    ArrayList<Estadio> estadios = new ArrayList<>();

    public void up() {
        estadios.add(new Estadio("AL_BAIT", "Al Bait"));
        estadios.add(new Estadio("AL_ZUMAMA", "Al Zumama"));
        estadios.add(new Estadio("INTERNACIONAL_JALIFA", "Internacional Jalifa"));
        estadios.add(new Estadio("AHMAD_BIN_ALI", "Ahmad Bin Ali"));
        estadios.add(new Estadio("DE_LUSAIL", "De Lusail"));
        estadios.add(new Estadio("974", "974"));
        estadios.add(new Estadio("DE_LA_CIUDAD_DE_LA_EDUCACIÓN", "de la Ciudad de la Educación"));
        estadios.add(new Estadio("AL_YANUB", "Al Yanub"));

        ObjectIO objectIO = new ObjectIO();
        objectIO.WriteObjectToFile("estadios", estadios);
    }
}
