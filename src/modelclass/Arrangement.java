package modelclass;

import java.time.LocalDate;
import java.util.ArrayList;

public class Arrangement {
    // Field variables
    private String titel;
    private double pris;
    private LocalDate dato;
    private ArrayList<Deltager> deltagere = new ArrayList<>();
    private ArrayList<Ledsager> ledsagere = new ArrayList<>();

    /**
     * Constructor der opretter et arrangement
     * @param titel
     * @param pris
     * @param dato
     */
    public Arrangement(String titel, double pris, LocalDate dato){
        this.titel = titel;
        this.pris = pris;
        this.dato = dato;
    }

    /**
     * Returnerer en kopi af deltagere til arrangementet
     * @return
     */
    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    /**
     * Tilføjer deltager til arrangement
     * @param deltager
     */
    public void addDeltager(Deltager deltager){
        if(!deltagere.contains(deltager)){
            deltagere.add(deltager);
        }
    }

    /**
     * Fjerner deltager til arrangement
     * @param deltager
     */
    public void removeDeltager(Deltager deltager){
        if(deltagere.contains(deltager)){
            deltagere.remove(deltager);
        }
    }

    /**
     * Returnerer en liste af ledsagere
     * @return
     */
    public ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<>(ledsagere);
    }

    /**
     * tilføjer ledsager til arrangement
     * @param ledsager
     */
    public void addLedsager(Ledsager ledsager){
        if(!ledsagere.contains(ledsager)){
            ledsagere.add(ledsager);
            ledsager.addArrangement(this);
        }
    }

    /**
     * Fjerner ledsager fra arrangement
     * @param ledsager
     */
    public void removeLedsager(Ledsager ledsager){
        if(ledsagere.contains(ledsager)){
            ledsagere.add(ledsager);
            ledsager.removeArrangement(this);
        }
    }

    //-----------------------------------------------------------
    // Getter og setters
    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }
}
