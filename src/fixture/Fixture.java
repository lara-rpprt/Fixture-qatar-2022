package fixture;

import fixture.model.Fase;
import fixture.repository.GrupoRepository;
import fixture.repository.PartidoRepository;
import fixture.view.Ventana;
import java.util.ArrayList;

public class Fixture {

    public static void main(String[] args) {
        
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        
        // ventana set partidos
        PartidoRepository partidoRepository = new PartidoRepository();
        GrupoRepository grupoRepository = new GrupoRepository();
        
        ventana.setPartidos(partidoRepository.findBy(Fase.DE_GRUPOS, grupoRepository.get('a')));
    }

}
