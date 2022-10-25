package fixture.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Partido implements Serializable {

    private int id;
    private LocalDateTime fechaYHora;
    private Fase fase;
    private Equipo equipo1, equipo2;
    private int golesEquipo1, golesEquipo2, penalesEquipo1, penalesEquipo2;
    private Estadio estadio;

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Partido(int id, LocalDateTime fechaYHora, Fase fase, Estadio estadio, Equipo equipo1, Equipo equipo2) {
        this.id = id;
        this.fechaYHora = fechaYHora;
        this.fase = fase;
        this.estadio = estadio;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }
    
        public Partido(int id, LocalDateTime fechaYHora, Fase fase, Estadio estadio) {
        this.id = id;
        this.fechaYHora = fechaYHora;
        this.fase = fase;
        this.estadio = estadio;
        this.equipo1 = null;
        this.equipo2 = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public int getPenalesEquipo1() {
        return penalesEquipo1;
    }

    public void setPenalesEquipo1(int penalesEquipo1) {
        this.penalesEquipo1 = penalesEquipo1;
    }

    public int getPenalesEquipo2() {
        return penalesEquipo2;
    }

    public void setPenalesEquipo2(int penalesEquipo2) {
        this.penalesEquipo2 = penalesEquipo2;
    }

    @Override
    public String toString() {
        return getId() + " - " + getFechaYHora() + " - " + getFase() + " - " + getEquipo1() + " vs " + getEquipo2() + " - " + getEstadio();
    }

}
