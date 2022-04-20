package modelclass;

import java.util.ArrayList;

public class Hotel {

    private String navn, adresse;
    private double prisEnkeltVærelse, prisDoubleVærelse;
    private ArrayList<Tillæg> tillægslist = new ArrayList<>();
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Hotel(String navn, String adresse){
        this.navn = navn;
        this.adresse = adresse;
    }

    /**
     * laver et tillæg og tilføjer den til tillægslisten
     * prisen for tillægget
     * @param pris
     * navnet på tillægget
     * @param navn
     * @return
     */
    public Tillæg createTillæg(double pris, String navn){
        Tillæg tillæg = new Tillæg(pris, navn);
        tillægslist.add(tillæg);
        return tillæg;
    }

    public ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(tillægslist);
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    /**
     * tiløjer tilmedling til tilmeldingslisten for hotellet
     * @param tilmelding
     */
    public void addTilmelding(Tilmelding tilmelding){
        if (!tilmeldinger.contains(tilmelding)){
            tilmeldinger.add(tilmelding);}
    }

    /**
     * fjerner tilmelding fra tilmeldingslisten for hotellet
     * @param tilmelding
     */
    public void removeTilmelding(Tilmelding tilmelding){
        tilmeldinger.remove(tilmelding);
    }

}
