package fixture.exceptions;

import fixture.model.Equipo;
import fixture.model.Partido;

public class GolesNegativosFixtureException extends FixtureRuntimeException {
    
    private Equipo equipo;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    public GolesNegativosFixtureException(String mensaje){
        super(mensaje);
    }
    
    public GolesNegativosFixtureException(String mensaje, Equipo equipo){
        super(mensaje);
        this.equipo = equipo;
    }

    
}


