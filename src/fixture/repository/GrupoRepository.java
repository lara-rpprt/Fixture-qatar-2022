package fixture.repository;

import fixture.model.Grupo;
import fixture.repository.filesystem.ObjectIO;
import java.util.ArrayList;

public class GrupoRepository {
    // Instancia de la "base de datos"
    ObjectIO objectIO = new ObjectIO();
    ArrayList<Grupo> grupos;

    // Constructor. Guardo en memoria todos los datos
    public GrupoRepository() {
        grupos = (ArrayList<Grupo>) objectIO.ReadObjectFromFile("grupos");
    }
    
    // Recupero por letra de grupo
    public Grupo get(char letraGrupo){
        return grupos.stream().filter(grupo -> grupo.getLetra() == letraGrupo).findAny().orElse(null);
    }
}
