package fixture.exceptions;

import fixture.model.Partido;

public class GolesNegativosFixtureException extends FixtureException {
    private Partido partido;
    public GolesNegativosFixtureException(String mensaje){
        super(mensaje);
    }
    
    public GolesNegativosFixtureException (String mensaje, Partido p) {
        super(mensaje);
        this.partido = partido;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
    
}


