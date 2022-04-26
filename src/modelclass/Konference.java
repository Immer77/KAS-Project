package modelclass;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    // Felt variabler
    private String navn;
    private String lokation;
    private LocalDate tilDato;
    private LocalDate fraDato;
    private Arrangør arrangør;
    private double afgiftPrDag;
    private final ArrayList<Hotel> hoteller = new ArrayList<>();
    private final ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    // Constructor
    public Konference(String navn, String lokation, LocalDate fraDato, LocalDate tilDato, double afgiftPrDag){
        this.navn = navn;
        this.lokation = lokation;
        this.fraDato = fraDato;
        this.tilDato = tilDato;
        this.afgiftPrDag = afgiftPrDag;
        
    }


    /**
     * Returnerer en kopi af hoteller til konferencen
     * @return
     */
    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    /**
     * Tilføjer et hotel til konferencen
     * @param hotel
     */
    public void addHotel(Hotel hotel){
        if(!hoteller.contains(hotel)){
            hoteller.add(hotel);
        }

    }

    /**
     * Fjerner hotel fra konference
     * @param hotel
     */
    public void removeHotel(Hotel hotel){
        if(hoteller.contains(hotel)){
            hoteller.remove(hotel);
        }
    }

    /**
     * Returnerer en liste af arrangementer
     * @return
     */
    public ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    /**
     * Laver et arrangement
     * @param titel
     * @param pris
     * @param dato
     * @return
     */
    public Arrangement createArrangement(String titel, double pris, LocalDate dato, Konference konference){
        Arrangement arrangement = new Arrangement(titel, pris, dato, this);
        arrangementer.add(arrangement);
        return arrangement;
    }

    /**
     * Tilføjer et arrangementer
     * @param arrangement
     */
    public void addArrangement(Arrangement arrangement){
        if(!arrangementer.contains(arrangement)){
            arrangementer.add(arrangement);
        }
    }

    /**
     * Fjerner et arrangement
     * @param arrangement
     */
    public void removeArrangement(Arrangement arrangement){
        if(arrangementer.contains(arrangement)){
            arrangementer.remove(arrangement);
        }
    }

    /**
     * Returnerer en liste af tilmeldinger
     * @return
     */
    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    /**
     * Komposition
     * laver en tilmelding
     * @param land
     * @param by
     * @param ankomstDato
     * @param afrejseDato
     * @param hotel
     * @return
     */


    public Tilmelding createTilmelding(String land, String by, LocalDate ankomstDato, LocalDate afrejseDato,Deltager deltager,Hotel hotel){
        Tilmelding tilmelding = new Tilmelding(land, by, ankomstDato, afrejseDato, deltager ,hotel, this);
        tilmeldinger.add(tilmelding);
        return tilmelding;
    }


    /**
     * Fjerner tilmelding
     * @param tilmelding
     */
    public void removeTilmelding(Tilmelding tilmelding){
        if(tilmeldinger.contains(tilmelding)){
            tilmeldinger.remove(tilmelding);
        }
    }

    //------------------------------------------------------------------------
    //Getter og setters

    public Arrangør getArrangør() {
        return arrangør;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getAfgiftPrDag() {
        return afgiftPrDag;
    }

    @Override
    public String toString() {
        return getNavn();
    }
}


