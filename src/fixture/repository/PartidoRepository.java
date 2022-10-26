package fixture.repository;

import fixture.model.Fase;
import fixture.model.Grupo;
import fixture.model.Partido;
import fixture.repository.filesystem.ObjectIO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import static java.util.Objects.nonNull;
import java.util.stream.Collectors;

public class PartidoRepository {
    // Instancia de "base de datos"
    ObjectIO objectIO = new ObjectIO();
    ArrayList<Partido> partidos;

    // Constructor. Guarda en memoria todos los datos
    public PartidoRepository() {
        partidos = (ArrayList<Partido>) objectIO.ReadObjectFromFile("partidos");
    }

    // Recupero todos los datos
    public ArrayList<Partido> findAll() {
        return partidos;
    }

    // Busco por Fase
    public ArrayList<Partido> findBy(Fase fase) {
        return (ArrayList<Partido>) partidos.stream().filter(partido -> partido.getFase().equals(fase)).collect(Collectors.toList());
    }

    // Busco por Fase y Grupo
    public ArrayList<Partido> findBy(Fase fase, Grupo grupo) {
        ArrayList<Partido> partidosFase = findBy(fase);
        HashSet<Partido> partidosGrupo = new HashSet();

        for (Partido partido : partidosFase) {
            if (nonNull(partido.getEquipo1())) {
                if (grupo.getEquiposIds().contains(partido.getEquipo1().getId())) {
                    partidosGrupo.add(partido);
                }
            }
        }
        
        ArrayList<Partido> partidosGrupoList = (ArrayList<Partido>) partidosGrupo.stream().collect(Collectors.toList());
        
        Collections.sort(partidosGrupoList, new Comparator<Partido>() {
            public int compare(Partido o1, Partido o2) {
                if (o1.getFechaYHora()== null || o2.getFechaYHora() == null)
                  return 0;
                return o1.getFechaYHora().compareTo(o2.getFechaYHora());
            }
          });
        
        return partidosGrupoList;
        
        //return (ArrayList<Partido>) partidosFase.stream().filter(partido -> grupo.getEquipos().containsAll(grupo.getEquipos())).collect(Collectors.toList());
    }
    
    
}
