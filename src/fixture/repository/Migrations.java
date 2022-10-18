package fixture.repository;

public class Migrations {
    public static void main(String[] args) {
        EquiposMigrations equiposMigrations = new EquiposMigrations();
        GruposMigrations gruposMigrations = new GruposMigrations();
        EstadiosMigrations estadiosMigrations = new EstadiosMigrations();
        
        equiposMigrations.up();
        gruposMigrations.up();
        estadiosMigrations.up();
    }
    
}
