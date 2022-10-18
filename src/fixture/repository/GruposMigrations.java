package fixture.repository;

import fixture.model.Equipo;
import fixture.model.Grupo;
import java.util.ArrayList;

public class GruposMigrations {

    Grupo[] grupos = {
        new Grupo(0, 'a'),
        new Grupo(1, 'b'),
        new Grupo(2, 'c'),
        new Grupo(3, 'd'),
        new Grupo(4, 'e'),
        new Grupo(5, 'f'),
        new Grupo(6, 'g'),
        new Grupo(7, 'h'),};

    public void up() {
        ObjectIO objectIO = new ObjectIO();

        ArrayList<Equipo> equipos = (ArrayList<Equipo>) objectIO.ReadObjectFromFile("equipos");

        Equipo[] equiposGrupoA = {
            equipos.stream().filter(equipo -> equipo.getId().equals("HOLANDA")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("SENEGAL")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("ECUADOR")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("QATAR")).findAny().orElse(null)
        };
        
        Equipo[] equiposGrupoB = {
            equipos.stream().filter(equipo -> equipo.getId().equals("GALES")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("ESTADOS_UNIDOS")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("IRAN")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("INGLATERRA")).findAny().orElse(null)
        };
        
        Equipo[] equiposGrupoC = {
            equipos.stream().filter(equipo -> equipo.getId().equals("POLONIA")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("MEXICO")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("ARABIA_SAUDITA")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("ARGENTINA")).findAny().orElse(null)
        };
        
        Equipo[] equiposGrupoD = {
            equipos.stream().filter(equipo -> equipo.getId().equals("AUSTRALIA")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("TUNEZ")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("DINAMARCA")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("FRANCIA")).findAny().orElse(null)
        };
        
        Equipo[] equiposGrupoE = {
            equipos.stream().filter(equipo -> equipo.getId().equals("COSTA_RICA")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("JAPON")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("ALEMANIA")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("ESPANA")).findAny().orElse(null)
        };
        
        Equipo[] equiposGrupoF = {
            equipos.stream().filter(equipo -> equipo.getId().equals("CROACIA")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("MARRUECOS")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("CANADA")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("BELGICA")).findAny().orElse(null)
        };
        
        Equipo[] equiposGrupoG = {
            equipos.stream().filter(equipo -> equipo.getId().equals("CAMERUN")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("SUIZA")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("SERBIA")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("BRASIL")).findAny().orElse(null)
        };
        
        Equipo[] equiposGrupoH = {
            equipos.stream().filter(equipo -> equipo.getId().equals("COREA_DEL_SUR")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("URUGUAY")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("GHANA")).findAny().orElse(null),
            equipos.stream().filter(equipo -> equipo.getId().equals("PORTUGAL")).findAny().orElse(null)
        };
        
        grupos[0].setEquipos(equiposGrupoA);
        grupos[1].setEquipos(equiposGrupoB);
        grupos[2].setEquipos(equiposGrupoC);
        grupos[3].setEquipos(equiposGrupoD);
        grupos[4].setEquipos(equiposGrupoE);
        grupos[5].setEquipos(equiposGrupoF);
        grupos[6].setEquipos(equiposGrupoG);
        grupos[7].setEquipos(equiposGrupoH);
        
        objectIO.WriteObjectToFile("grupos", grupos);
    }
}
