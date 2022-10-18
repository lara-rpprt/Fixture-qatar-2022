package fixture.model;

import java.io.Serializable;
import java.util.Arrays;

public class Grupo implements Serializable{
    private int id;
    private char letra;
    private Equipo[] equipos;

    public Grupo(int id, char letra) {
        this.id = id;
        this.letra = letra;
        this.equipos = new Equipo[4];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public Equipo[] getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipo[] equipos) {
        this.equipos = equipos;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return getId() + "-" + getLetra() + " - " + Arrays.toString(getEquipos()) ;
    }
}
