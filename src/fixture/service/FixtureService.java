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
import java.util.HashSet;
import java.util.List;

public interface FixtureService {
    
    //Facade 
    
    void metodo();
    
    Grupo obtenerGrupo(char caracter); 
    Grupo obtenerGrupoA();
    
    ArrayList<Partido> obtenerPartidosDeFaseGrupo(Grupo grupoA);
    
    //Sobrescritura
    ArrayList<Partido> obtenerPartidosDeFaseGrupo(char caracter);
    
    ArrayList<Partido> obtenerPartidosDeFaseOctavos();
    
    ArrayList<Partido> obtenerPartidosDeFaseCuartos();
    
    ArrayList<Partido> obtenerPartidosDeTercerPuesto();
    
    ArrayList<Partido> obtenerPartidosDeFaseSemifinales();
    
    ArrayList<Partido> obtenerPartidoFinal();
    
    Equipo obtenerEquipoPorID(String id);
   
    void guardarPartidosEnArchivo();
    
    void actualizarDatosDeEquiopoEnArchivo(Equipo equipoGrupo);
    
    void validarGoles (ArrayList<Partido> partidos);
}   