package fixture;

import fixture.model.Partido;
import fixture.repository.PartidoRepository;
import fixture.view.Ventana;
import java.util.ArrayList;

public class Fixture {

    public static void main(String[] args) {

        PartidoRepository partidoRepository = new PartidoRepository();
        
        Ventana ventana = new Ventana();
        ventana.setVisible(true);

        ArrayList<Partido> partidos = partidoRepository.findAll();
        
        for (Partido partido : partidos) {
            System.out.println(partido);
        }

    }

}
