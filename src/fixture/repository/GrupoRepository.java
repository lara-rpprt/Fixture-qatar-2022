package fixture.repository;

import fixture.model.Grupo;
import fixture.repository.filesystem.ObjectIO;
import java.util.ArrayList;

public class GrupoRepository {
    ObjectIO objectIO = new ObjectIO();
    ArrayList<Grupo> grupos;

    public GrupoRepository() {
        grupos = (ArrayList<Grupo>) objectIO.ReadObjectFromFile("grupos");
    }
    
    public Grupo get(char letraGrupo){
        return grupos.stream().filter(grupo -> grupo.getLetra() == letraGrupo).findAny().orElse(null);
    }
}
