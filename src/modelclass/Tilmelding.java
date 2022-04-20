package modelclass;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding {
    private String land, by;
    private LocalDate ankomstDato, afrejseDato;
    private Hotel hotel;
    private Konference konference;
    private Deltager deltager;
    private ArrayList<Tillæg> tillægslist = new ArrayList<>();

    public Tilmelding(String land, String by, LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager, Konference konference, Hotel hotel){
        this.land = land;
        this.by = by;
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.deltager = deltager;
        this.konference = konference;
        this.hotel = hotel;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    /**
     * beregner den samlede pris for tilmeldingen
     * @return
     */
    public double beregnSamletPris(){
        return 0.0;
    }

    public Konference getKonference() {
        return konference;
    }

    public ArrayList<Tillæg> getTillægslist() {
        return new ArrayList<>(tillægslist);
    }

    /**
     * tilføjer tillæg til tillægslisten for tilmeldingen
     * @param tillæg
     */
    public void addTillæg(Tillæg tillæg){
        if(!tillægslist.contains(tillæg)){
            tillægslist.add(tillæg);
        }
    }

    /**
     *fjerner tillæg fra tillægslisten for tilmeldingen
     * @param tillæg
     */
    public void removeTillæg(Tillæg tillæg){
        tillægslist.remove(tillæg);
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
