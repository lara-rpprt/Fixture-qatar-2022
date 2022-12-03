/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fixture.service;

import fixture.exceptions.FixtureException;
import fixture.exceptions.FixtureRuntimeException;
import fixture.exceptions.GolesNegativosFixtureException;
import fixture.model.Equipo;
import fixture.model.Fase;
import fixture.model.Grupo;
import fixture.model.Partido;
import fixture.repository.EquipoRepository;
import fixture.repository.GrupoRepository;
import fixture.repository.PartidoRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Windows
 */
public class FixtureServiceImpl implements FixtureService {
    //Clase Service debería utiliza patron Facade

    private GrupoRepository grupoRepository;
    private PartidoRepository partidoRepository;
    private EquipoRepository equipoRepository;

    public FixtureServiceImpl() {
        cargarRepositorios();
    }

    private void cargarRepositorios() {
        //GruposMigrations.up();
        //PartidosMigrations.up();
        grupoRepository = new GrupoRepository();
        partidoRepository = new PartidoRepository();
        equipoRepository = new EquipoRepository();
    }

    public Grupo obtenerGrupo(char caracter) {
        return grupoRepository.get(caracter);
    }

    public Grupo obtenerGrupoA() {
        return obtenerGrupo('a');
    }

    public ArrayList<Partido> obtenerPartidosDeFaseGrupo(Grupo grupoA) {
        return partidoRepository.findBy(Fase.DE_GRUPOS, grupoA);
    }

    public ArrayList<Partido> obtenerPartidosDeFaseGrupo(char caracter) {
        Grupo grupo = grupoRepository.get(caracter);
        return partidoRepository.findBy(Fase.DE_GRUPOS, grupo);
    }

    public ArrayList<Partido> obtenerPartidosDeFaseOctavos() {
        return partidoRepository.findBy(Fase.OCTAVOS);
    }

    public ArrayList<Partido> obtenerPartidosDeFaseCuartos() {
        return partidoRepository.findBy(Fase.CUARTOS);
    }

    public ArrayList<Partido> obtenerPartidosDeTercerPuesto() {
        return partidoRepository.findBy(Fase.TERCER_PUESTO);
    }

    public ArrayList<Partido> obtenerPartidosDeFaseSemifinales() {
        return partidoRepository.findBy(Fase.SEMIFINALES);
    }

    public ArrayList<Partido> obtenerPartidoFinal() {
        return partidoRepository.findBy(Fase.FINAL);
    }

    public void guardarPartidosEnArchivo() {
        partidoRepository.guardarPartidosEnArchivo();
    }

    public Equipo obtenerEquipoPorID(String id) {
        return equipoRepository.find(id);
    }

    public Partido obtenerPartidoPorID(int id) {
        return partidoRepository.find(id);
    }

    public void actualizarDatosDeEquiopoEnArchivo(Equipo equipoGrupo) {
        equipoRepository.actualizarDatosDeEquiopoEnArchivo(equipoGrupo);
    }

    public void validarGoles(ArrayList<Partido> partidos) {

        for (Partido partido : partidos) {
            if (partido.getGolesEquipo1() < 0) {
                throw new GolesNegativosFixtureException(
                        "Los goles de Local no deben ser menores que 0", partido.getEquipo1());
            }

            if (partido.getGolesEquipo2() < 0) {
                throw new GolesNegativosFixtureException(
                        "Los goles de Visitante no deben ser menores que 0", partido.getEquipo2());
            }
        }
    }

    public void metodo() {

        try {
            metodoConError();
            metodoConErrorChequeda();
        } catch (FixtureException | FixtureRuntimeException ex) {

            ex.printStackTrace();
            System.out.println("ocurrio un error FixtureException");

        } catch (Exception ex) {
            System.out.println("ocurrio un error FixtureException");
        } finally {
            System.out.println("Siempre se ejecuta");
        }
    }

    private void metodoConError() {
        throw new FixtureRuntimeException("Not supported yet.");
    }

    private void metodoConErrorChequeda() throws FixtureException {
        throw new FixtureException("Not supported yet.");
    }

    public static void main(String[] args) {
        FixtureService service = new FixtureServiceImpl();
        service.metodo();
    }

    @Override
    public HashSet<Equipo> recuperarDatosDeEquipoDeEquipoRepository(Grupo grupo) {
        HashSet<Equipo> equiposGrupoActualizados = new HashSet();
        // Para guardar correctamente el dato tengo que trabajar sobre EquipoRepository
        for (Equipo equipoGrupo : grupo.getEquipos()) {
            Equipo equipoEncontrado = this.obtenerEquipoPorID(equipoGrupo.getId());

            // esta lista (HashSet) va a ser la encargada que gestionar los datos de Equipos en el repositorio correspondiente
            equiposGrupoActualizados.add(equipoEncontrado);
        }

        return equiposGrupoActualizados;
    }

    @Override
    public ArrayList<Equipo> ordenarEquiposYCompletarOctavos(HashSet<Equipo> e, Grupo grupo, boolean guardandoCambios) {
        ArrayList<Equipo> equipos = new ArrayList(e);

        // Criterios de ordenamiento:
        //  1) Mayor puntaje
        //  2) Mayor diferencia de goles
        //  3) Mayor cantidad de goles totales
        // Dispongo de dos booleanos para informar al usuario si se requiere selección manual
        Collections.sort(equipos, new Comparator<Equipo>() {
            @Override
            public int compare(Equipo e1, Equipo e2) {
                return e1.getPuntos() > e2.getPuntos() ? -1 : 1;
            }
        });

        // 2) Ordena por mayor diferencia de goles
        // Es necesario reordenar por el segundo criterio?
        boolean hayPuntajesIguales = false;
        int auxPuntaje = -1;

        for (Equipo equipo : equipos) {
            if (equipo.getPuntos() == auxPuntaje) {
                hayPuntajesIguales = true;
            }
            auxPuntaje = equipo.getPuntos();
        }

        // Si hay más de un equipo con igual puntaje
        // es necesario reordenar por el segundo criterio
        if (hayPuntajesIguales) {
            Collections.sort(equipos, new Comparator<Equipo>() {
                @Override
                public int compare(Equipo e1, Equipo e2) {
                    int diferenciaDeGolesE1 = e1.getGolesHechos() - e1.getGolesEnContra();
                    int diferenciaDeGolesE2 = e2.getGolesHechos() - e2.getGolesEnContra();

                    if (e1.getPuntos() == e2.getPuntos()) {
//                        if (diferenciaDeGolesE1 > diferenciaDeGolesE2) {
//                            return -1;
//                        } else {
//                            return 1;
//                        }
                        return diferenciaDeGolesE1 > diferenciaDeGolesE2 ? -1 : 1;
                    }
                    return 0;
                }
            });

            // Es necesario reordenar por el tercer criterio?
            boolean hayDiferenciaDeGolesIguales = false;
            int auxDiferenciaDeGoles = equipos.get(0).getGolesHechos() - equipos.get(0).getGolesEnContra();
            for (int i = 1; i < equipos.size(); i++) {
                int diferenciaDeGoles = equipos.get(i).getGolesHechos() - equipos.get(i).getGolesEnContra();

                if (diferenciaDeGoles == auxDiferenciaDeGoles) {
                    hayDiferenciaDeGolesIguales = true;
                }

                auxDiferenciaDeGoles = diferenciaDeGoles;
            }

            // Si es necesario los reordeno por el tercer criterio
            if (hayDiferenciaDeGolesIguales) {
                Collections.sort(equipos, new Comparator<Equipo>() {
                    @Override
                    public int compare(Equipo e1, Equipo e2) {
                        int diferenciaDeGolesE1 = e1.getGolesHechos() - e1.getGolesEnContra();
                        int diferenciaDeGolesE2 = e2.getGolesHechos() - e2.getGolesEnContra();

                        if (diferenciaDeGolesE1 == diferenciaDeGolesE2) {
                            return e1.getGolesHechos() > e2.getGolesHechos() ? -1 : 1;
                        }
                        return 0;
                    }
                });
            }
        }

        //Completar equipos de fase de Octavos
        HashMap<Character, Equipo[]> grupoEquiposPrimerosPuestos = new HashMap<>();
        Equipo[] equiposParaOctavos = {equipos.get(0), equipos.get(1)};
        grupoEquiposPrimerosPuestos.put(grupo.getLetra(), equiposParaOctavos);

        escribirEquiposEnOctavos(grupoEquiposPrimerosPuestos);

        return equipos;
    }

    private void escribirEquiposEnOctavos(HashMap<Character, Equipo[]> grupoEquiposPrimerosPuestos) {
        //Primer puesto de tabla de posiciones
        //Segundo puesto de tabla de posiciones

        //Dónde ubicar 1er puesto
        //Dónde ubicar 2do puesto
        Character letra = (Character) grupoEquiposPrimerosPuestos.keySet().toArray()[0];
        Partido partidoPrimerPuesto;
        Partido partidoSegundoPuesto;

        switch (letra) {
            case 'a':
                //Buscar partido de ID 49
                partidoPrimerPuesto = obtenerPartidoPorID(49);
                partidoSegundoPuesto = obtenerPartidoPorID(51);

                partidoPrimerPuesto.setEquipo1(grupoEquiposPrimerosPuestos.get('a')[0]);
                partidoSegundoPuesto.setEquipo2(grupoEquiposPrimerosPuestos.get('a')[1]);

                break;
                
            case 'b':
                //Buscar partido de ID 49
                partidoPrimerPuesto = obtenerPartidoPorID(51);
                partidoSegundoPuesto = obtenerPartidoPorID(49);

                partidoPrimerPuesto.setEquipo1(grupoEquiposPrimerosPuestos.get('b')[0]);
                partidoSegundoPuesto.setEquipo2(grupoEquiposPrimerosPuestos.get('b')[1]);
                break;

            case 'c':
                partidoPrimerPuesto = obtenerPartidoPorID(50);
                partidoSegundoPuesto = obtenerPartidoPorID(52);

                partidoPrimerPuesto.setEquipo1(grupoEquiposPrimerosPuestos.get('c')[0]);
                partidoSegundoPuesto.setEquipo2(grupoEquiposPrimerosPuestos.get('c')[1]);
                break;
            
            case 'd':
                partidoPrimerPuesto = obtenerPartidoPorID(52);
                partidoSegundoPuesto = obtenerPartidoPorID(50);

                partidoPrimerPuesto.setEquipo1(grupoEquiposPrimerosPuestos.get('d')[0]);
                partidoSegundoPuesto.setEquipo2(grupoEquiposPrimerosPuestos.get('d')[1]);
                break;
                
            case 'e':
                partidoPrimerPuesto = obtenerPartidoPorID(53);
                partidoSegundoPuesto = obtenerPartidoPorID(55);

                partidoPrimerPuesto.setEquipo1(grupoEquiposPrimerosPuestos.get('e')[0]);
                partidoSegundoPuesto.setEquipo2(grupoEquiposPrimerosPuestos.get('e')[1]);
                break;
                
            case 'f':
                partidoPrimerPuesto = obtenerPartidoPorID(55);
                partidoSegundoPuesto = obtenerPartidoPorID(53);

                partidoPrimerPuesto.setEquipo1(grupoEquiposPrimerosPuestos.get('f')[0]);
                partidoSegundoPuesto.setEquipo2(grupoEquiposPrimerosPuestos.get('f')[1]);
                break;
                
            case 'g':
                partidoPrimerPuesto = obtenerPartidoPorID(54);
                partidoSegundoPuesto = obtenerPartidoPorID(56);

                partidoPrimerPuesto.setEquipo1(grupoEquiposPrimerosPuestos.get('g')[0]);
                partidoSegundoPuesto.setEquipo2(grupoEquiposPrimerosPuestos.get('g')[1]);
                break;
            
            case 'h':
                partidoPrimerPuesto = obtenerPartidoPorID(56);
                partidoSegundoPuesto = obtenerPartidoPorID(54);

                partidoPrimerPuesto.setEquipo1(grupoEquiposPrimerosPuestos.get('h')[0]);
                partidoSegundoPuesto.setEquipo2(grupoEquiposPrimerosPuestos.get('h')[1]);
                break;

        }
    }

    //1ero Grupo A -> equipo1 de id 49 [Id del Partido]
    //2do Grupo B -> equipo2 de id 49 [Id del Partido]
    //1ero Grupo A -> equipo1 de id 52 [Id del Partido]
    //2do Grupo B -> equipo2 de id 52 [Id del Partido]
}
