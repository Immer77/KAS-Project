package modelclass;

import java.util.ArrayList;

public class Person {
    private String navn, adresse;
    private int cpr, tlfNr;
    private ArrayList<Deltager> deltagere = new ArrayList<>();
    private ArrayList<Arrangør> arrangøre = new ArrayList<>();

    public Person(String navn, String adresse, int cpr, int tlfNr){
        this.navn = navn;
        this.adresse = adresse;
        this.cpr = cpr;
        this.tlfNr = tlfNr;
    }

    public ArrayList<Arrangør> getArrangøre() {
        return new ArrayList<>(arrangøre);
    }

    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public String getNavn() {
        return navn;
    }

    public int getTlfNr() {
        return tlfNr;
    }
}
