package modelclass;

import java.util.ArrayList;

public class Ledsager {
    // Felt variabler
    private String navn;
    private ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private Deltager deltager;

    /**
     * Constructor
     * @param navn
     * @param deltager
     */
    public Ledsager(String navn, Deltager deltager){
        this.navn = navn;
        this.deltager = deltager;
    }

    /**
     * Returnerer en liste af arrangementer ledsageren er på
     * @return
     */
    public ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    /**
     * Tilføjer arrangementer til ledsageren og vice versa
     * @param arrangement
     */
    public void addArrangement(Arrangement arrangement){
        if(!arrangementer.contains(arrangement)){
            arrangementer.add(arrangement);
            arrangement.addLedsager(this);
        }
    }

    /**
     * Fjerner
     * @param arrangement
     */
    public void removeArrangement(Arrangement arrangement){
        if(arrangementer.contains(arrangement)){
            arrangementer.remove(arrangement);
            arrangement.removeLedsager(this);
        }
    }


    public Deltager getDeltager() {
        return deltager;
    }

    public double samletPrisForUdflugter(){
        double result = 0.0;
        for(Arrangement a : arrangementer){
            result += a.getPris();
        }
        return result;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}
