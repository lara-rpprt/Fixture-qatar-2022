package fixture.service;

import fixture.exceptions.FixtureException;
import fixture.exceptions.FixtureRuntimeException;
import fixture.exceptions.GolesNegativosFixtureException;
import fixture.model.Partido;
import java.util.ArrayList;
import java.util.List;

public class FixtureService {

    public  void validarGoles(ArrayList<Partido> partidos) throws GolesNegativosFixtureException {
        //Recorrer los partidos y validar si hay números negativos; si alguna tiene un gol mal, tiro una excepción
        for (Partido partido : partidos) {
            if(partido.getGolesEquipo1() < 0) {
                throw new GolesNegativosFixtureException ("Los goles de local no deben ser menores a cero", partido); 
            }
            
            if(partido.getGolesEquipo2() < 0) {
                throw new GolesNegativosFixtureException ("Los goles de visitante no deben ser menores a cero", partido); 
            }
        }
    }
    
    
    public void metodo() {

        //Bloque que nos da la posibilidad de tratar la excepción
        try {
            metodoConError();
            metodoConErrorChequeado();
        } catch (FixtureException | FixtureRuntimeException ex) {
            ex.printStackTrace();
            
            System.out.println("Ocurrió un error FixtureRunetimeException");

        } catch (Exception ex) {
            System.out.println("Ocurrió un error Exception");
        }finally{
            System.out.println("Siempre se ejecuta");
        }
    }

    private void metodoConError() {

        throw new FixtureRuntimeException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //Cuando invoque el metodoConError va a tirar una excepción. 
        //Hereda de RunTime Exception
        
        //if(true)
        //    throw new FixtureRuntimeException("Not supported yet");
    }
    
    private void metodoConErrorChequeado() throws FixtureException {
        throw new FixtureException("Not supported yet");
    }

    public static void main(String[] args) {
        FixtureService service = new FixtureService();
        service.metodo();
    }
}
