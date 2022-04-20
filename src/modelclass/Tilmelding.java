package modelclass;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {
    private String land, by;
    private LocalDate ankomstDato, afrejseDato;
    private Hotel hotel;
    private Konference konference;
    private Deltager deltager;
    private ArrayList<Tillæg> tillægslist = new ArrayList<>();

    public Tilmelding(String land, String by, LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager, Hotel hotel, Konference konference){
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
    public double beregnSamletPris() {
        return beregnHotelPris() + beregnKonferencePris() + beregnTillægsPris() + beregnUdflugtsPrisen();
    }

    public double beregnKonferencePris(){
        double result = 0.0;
        if(deltager.isErForedragsholder()){
            return result;
        }else{
            result = (konference.getAfgiftPrDag() * (ChronoUnit.DAYS.between(ankomstDato,afrejseDato) +1));
        }
        return result;
    }

    public double beregnHotelPris(){
        double result = 0.0;
        try {
            if(hotel == (null)){
                return result;
            }
            if(deltager.getLedsager() == (null)){
                result = hotel.getPrisEnkeltVærelse() * (ChronoUnit.DAYS.between(ankomstDato,afrejseDato));
            }else {
                result = hotel.getPrisDoubleVærelse() * (ChronoUnit.DAYS.between(ankomstDato,afrejseDato));

            }
        } catch (NullPointerException nullPointerException){
            // Do nothing
        }

        return result;
    }

    public double beregnTillægsPris(){
        double result = 0.0;
        for (Tillæg t : tillægslist){
            result += t.getPris();
        }
        return result * ChronoUnit.DAYS.between(ankomstDato,afrejseDato);
    }

    public double beregnUdflugtsPrisen(){
        double result = 0.0;
        if(deltager.getLedsager() != null){
            result += deltager.getLedsager().samletPrisForUdflugter();
        }
        return result;
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
