package fixture;

import fixture.model.Fase;
import fixture.model.Partido;
import fixture.repository.GrupoRepository;
import fixture.repository.PartidoRepository;
import fixture.view.Ventana;
import java.util.ArrayList;

public class Fixture {

    public static void main(String[] args) {
        
        // Preparo todos los partidos de Fase de Grupos
        PartidoRepository partidoRepository = new PartidoRepository();
        GrupoRepository grupoRepository = new GrupoRepository();
        
        ArrayList<Partido> partidosGrupoA = partidoRepository.findBy(Fase.DE_GRUPOS, grupoRepository.get('a'));
        ArrayList<Partido> partidosGrupoB = partidoRepository.findBy(Fase.DE_GRUPOS, grupoRepository.get('b'));
        ArrayList<Partido> partidosGrupoC = partidoRepository.findBy(Fase.DE_GRUPOS, grupoRepository.get('c'));
        ArrayList<Partido> partidosGrupoD = partidoRepository.findBy(Fase.DE_GRUPOS, grupoRepository.get('d'));
        ArrayList<Partido> partidosGrupoE = partidoRepository.findBy(Fase.DE_GRUPOS, grupoRepository.get('e'));
        ArrayList<Partido> partidosGrupoF = partidoRepository.findBy(Fase.DE_GRUPOS, grupoRepository.get('f'));
        ArrayList<Partido> partidosGrupoG = partidoRepository.findBy(Fase.DE_GRUPOS, grupoRepository.get('g'));
        ArrayList<Partido> partidosGrupoH = partidoRepository.findBy(Fase.DE_GRUPOS, grupoRepository.get('h'));
        
        
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        
        ventana.setGrupoPartido('a', partidosGrupoA);
        ventana.setGrupoPartido('b', partidosGrupoB);
        ventana.setGrupoPartido('c', partidosGrupoC);
        ventana.setGrupoPartido('d', partidosGrupoD);
        ventana.setGrupoPartido('e', partidosGrupoE);
        ventana.setGrupoPartido('f', partidosGrupoF);
        ventana.setGrupoPartido('g', partidosGrupoG);
        ventana.setGrupoPartido('h', partidosGrupoH);
    }

}
