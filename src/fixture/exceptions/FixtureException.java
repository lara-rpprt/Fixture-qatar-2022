package fixture.exceptions;

public class FixtureException extends Exception {
    public FixtureException(String mensaje){
        super(mensaje);
        
        //Creo una excepción propia y porque extiende de exception tiene este tratamiento particular
        //Todos los errores van a ser del tipo Fixture Exception
    }
}
