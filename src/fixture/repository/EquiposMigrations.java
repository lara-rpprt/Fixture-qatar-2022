package fixture.repository;

import fixture.model.Equipo;
import java.util.ArrayList;

public class EquiposMigrations {

    ArrayList<Equipo> equipos = new ArrayList<>();

    public void up() {
        equipos.add(new Equipo("HOLANDA", "Holanda"));
        equipos.add(new Equipo("SENEGAL", "Senegal"));
        equipos.add(new Equipo("ECUADOR", "Ecuador"));
        equipos.add(new Equipo("QATAR", "Qatar"));
        equipos.add(new Equipo("GALES", "Gales"));
        equipos.add(new Equipo("ESTADOS_UNIDOS", "Estados Unidos"));
        equipos.add(new Equipo("IRAN", "Irán"));
        equipos.add(new Equipo("INGLATERRA", "Inglaterra"));
        equipos.add(new Equipo("POLONIA", "Polonia"));
        equipos.add(new Equipo("MEXICO", "México"));
        equipos.add(new Equipo("ARABIA_SAUDITA", "Arabia Saudita"));
        equipos.add(new Equipo("ARGENTINA", "Argentina"));
        equipos.add(new Equipo("AUSTRALIA", "Australia"));
        equipos.add(new Equipo("TUNEZ", "Túnez"));
        equipos.add(new Equipo("DINAMARCA", "Dinamarca"));
        equipos.add(new Equipo("FRANCIA", "Francia"));
        equipos.add(new Equipo("COSTA_RICA", "Costa Rica"));
        equipos.add(new Equipo("JAPON", "Japón"));
        equipos.add(new Equipo("ALEMANIA", "Alemania"));
        equipos.add(new Equipo("ESPANA", "España"));
        equipos.add(new Equipo("CROACIA", "Croacia"));
        equipos.add(new Equipo("MARRUECOS", "Marruecos"));
        equipos.add(new Equipo("CANADA", "Canadá"));
        equipos.add(new Equipo("BELGICA", "Bélgica"));
        equipos.add(new Equipo("CAMERUN", "Camerún"));
        equipos.add(new Equipo("SUIZA", "Suiza"));
        equipos.add(new Equipo("SERBIA", "Serbia"));
        equipos.add(new Equipo("BRASIL", "Brasil"));
        equipos.add(new Equipo("COREA_DEL_SUR", "Corea del Sur"));
        equipos.add(new Equipo("URUGUAY", "Uruguay"));
        equipos.add(new Equipo("GHANA", "Ghana"));
        equipos.add(new Equipo("PORTUGAL", "Portugal"));
        
        ObjectIO objectIO = new ObjectIO();
        objectIO.WriteObjectToFile("equipos", equipos);
    }
}
