package fixture.repository;

import fixture.model.Fase;
import fixture.model.Grupo;
import fixture.model.Partido;
import fixture.repository.filesystem.ObjectIO;
import java.util.ArrayList;
import java.util.HashSet;
import static java.util.Objects.nonNull;
import java.util.stream.Collectors;

public class PartidoRepository {

    ObjectIO objectIO = new ObjectIO();
    ArrayList<Partido> partidos;

    public PartidoRepository() {
        partidos = (ArrayList<Partido>) objectIO.ReadObjectFromFile("partidos");
    }

    public ArrayList<Partido> findAll() {
        return partidos;
    }

    public ArrayList<Partido> findBy(Fase fase) {
        return (ArrayList<Partido>) partidos.stream().filter(partido -> partido.getFase().equals(fase)).collect(Collectors.toList());
    }

    public ArrayList<Partido> findBy(Fase fase, Grupo grupo) {
        ArrayList<Partido> partidosFase = findBy(fase);
        HashSet<Partido> partidosGrupo = new HashSet();

        for (Partido partido : partidos) {
            if (nonNull(partido.getEquipo1())) {
                if (grupo.getEquiposIds().contains(partido.getEquipo1().getId())) {
                    partidosGrupo.add(partido);
                }
            }
        }
        return (ArrayList<Partido>) partidosGrupo.stream().collect(Collectors.toList());
        //return (ArrayList<Partido>) partidosFase.stream().filter(partido -> grupo.getEquipos().containsAll(grupo.getEquipos())).collect(Collectors.toList());
    }
}
