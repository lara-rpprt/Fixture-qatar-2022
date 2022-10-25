package fixture.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Grupo implements Serializable{
    private int id;
    private char letra;
    private ArrayList<Equipo> equipos;

    public Grupo(int id, char letra) {
        this.id = id;
        this.letra = letra;
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

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo>equipos) {
        this.equipos = equipos;
    }
    
    public ArrayList<String> getEquiposIds(){
        ArrayList<String> equiposIds = new ArrayList();
        for(Equipo equipo: equipos){
            equiposIds.add(equipo.getId());
        }
        return equiposIds;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return getId() + "-" + getLetra() + " - " + getEquipos() ;
    }
}
