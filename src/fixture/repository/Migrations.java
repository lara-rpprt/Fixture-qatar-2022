package fixture.repository;

public class Migrations {
    public static void main(String[] args) {
        EquiposMigrations equiposMigrations = new EquiposMigrations();
        GruposMigrations gruposMigrations = new GruposMigrations();
        EstadiosMigrations estadiosMigrations = new EstadiosMigrations();
        PartidosMigrations partidosMigrations = new PartidosMigrations();
        
        equiposMigrations.up();
        gruposMigrations.up();
        estadiosMigrations.up();
        partidosMigrations.up();
    }
    
}
