package modelclass;

import java.util.ArrayList;

public class Hotel {

    private String navn, adresse;
    private double prisEnkeltVærelse, prisDoubleVærelse;
    private ArrayList<Tillæg> tillægslist = new ArrayList<>();
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Hotel(String navn, String adresse, double prisEnkeltVærelse, double prisDoubleVærelse){
        this.navn = navn;
        this.adresse = adresse;
        this.prisEnkeltVærelse = prisEnkeltVærelse;
        this.prisDoubleVærelse = prisDoubleVærelse;
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

    public double getPrisEnkeltVærelse() {
        return prisEnkeltVærelse;
    }

    public void setPrisEnkeltVærelse(double prisEnkeltVærelse) {
        this.prisEnkeltVærelse = prisEnkeltVærelse;
    }

    public double getPrisDoubleVærelse() {
        return prisDoubleVærelse;
    }

    public void setPrisDoubleVærelse(double prisDoubleVærelse) {
        this.prisDoubleVærelse = prisDoubleVærelse;
    }

    public String getNavn() {return navn;}

    @Override
    public String toString() {
        return navn;
    }
}
