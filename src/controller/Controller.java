package controller;

import modelclass.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    public static Konference createKonference(String navn, String lokation, LocalDate fraDato, LocalDate tilDato, double afgiftPrDag){
        Konference konference = new Konference(navn,lokation,fraDato,tilDato,afgiftPrDag);
        Storage.addKonference(konference);
        return konference;
    }
    public static void deleteKonference(Konference konference){
        Storage.removeKonference(konference);
    }

    public static ArrayList<Konference> getKonferencer(){
        return Storage.getKonferencer();
    }

    //----------------------------------------------------------------------------------------------------------------------------------

    public static Deltager createDeltager(String navn, String adresse, int tlfNr, boolean erForedragsholder, String firmaNavn,int firmaTlf){
        Deltager deltager = new Deltager(navn, adresse, tlfNr,erForedragsholder,firmaNavn,firmaTlf);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static void deleteDeltager(Deltager deltager){
        Storage.removeDeltager(deltager);
    }

    public static ArrayList<Deltager> getdeltagere(){
        return Storage.getDeltagere();
    }


    //----------------------------------------------------------------------------------------------------------------------------------

    public static Hotel createHotel(String navn, String adresse, double prisEnkeltVærelse, double prisDoubleVærelse){
        Hotel hotel = new Hotel(navn,adresse,prisEnkeltVærelse,prisDoubleVærelse);
        Storage.addHotel(hotel);
        return hotel;
    }


    public static void deleteHotel(Hotel hotel){
        Storage.removeHotel(hotel);
    }

    public static ArrayList<Hotel> gethoteller(){
        return Storage.getHoteller();
    }

    public static void addHotelToKonference(Konference konference, Hotel hotel){
        try {
            if(!konference.getHoteller().contains(hotel)){
                konference.addHotel(hotel);
            }
        }catch (NullPointerException ex){
            // Do nothing
        }
    }

    public static void removeHotelFromKonference(Konference konference, Hotel hotel){
        konference.removeHotel(hotel);
    }

    public static void addHotelToTilmelding(Hotel hotel, Tilmelding tilmelding){
        if(!hotel.getTilmeldinger().contains(tilmelding)){
            hotel.addTilmelding(tilmelding);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------

    public static Arrangement createArrangement(String titel, double pris, LocalDate dato, Konference konference){
        Arrangement arrangement = new Arrangement(titel, pris, dato, konference);
        konference.addArrangement(arrangement);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static void deleteArrangement(Arrangement arrangement){
        Storage.removeArrangement(arrangement);
    }
    public static ArrayList<Arrangement> getArrangementer(){
        return Storage.getArrangementer();
    }



    //-------------------------------------------------------------------------------

    public static Tillæg createTillæg(double pris, String navn, Hotel hotel){
        Tillæg tillæg = hotel.createTillæg(pris,navn);
        return tillæg;
    }

    public static void addTillægToTilmelding(Tilmelding tilmelding, Tillæg tillæg){
        tilmelding.addTillæg(tillæg);
    }

    public static void addTillægToHotel(Tillæg tillæg, Hotel hotel){
        hotel.addTillæg(tillæg);
    }

    public static void removeTillægFromHotel(Tillæg tillæg, Hotel hotel){
        hotel.removeTillæg(tillæg);
    }

    public static ArrayList<Tillæg> getTillæg(Hotel hotel){
        return new ArrayList<>(hotel.getTillæg());
    }

    //-------------------------------------------------------------------------------

    public static Tilmelding createTilmelding(String land, String by, LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager,Hotel hotel, Konference konference){
        Tilmelding tilmelding = konference.createTilmelding(land,by,ankomstDato,afrejseDato,deltager,hotel);
        if(hotel != null){
            addHotelToTilmelding(hotel, tilmelding);
        }
        return tilmelding;
    }

    public static double beregnSamledeTilmeldingsPris(Tilmelding tilmelding){
        return tilmelding.beregnSamletPris();
    }

    //-------------------------------------------------------------------------------

    public static Ledsager createLedsager(String navn, Deltager deltager){
        Ledsager ledsager = deltager.createLedsager(navn);
        return ledsager;
    }

    public static void addArrangementToLedsager(Arrangement arrangement, Ledsager ledsager){
        arrangement.addLedsager(ledsager);
    }
    //-------------------------------------------------------------------------------

    public static void initStorage(){
        Konference konference = createKonference("Hav og Himmel", "Sønderhøj 30", LocalDate.of(2022,4,20),LocalDate.of(2022,4,22),1500);
        Hotel h1 = createHotel("Den hvide svane","HvideSvanevej 10", 1050.0,1250.0);
        Tillæg tillæg1 = createTillæg(50,"Wifi", h1);

        Hotel h2 = createHotel("Høtel Phønix","Phønixvej 14",700.0,800.0);
        Tillæg tillæg2 = createTillæg(200,"Bad", h2);
        Tillæg tillæg3 = createTillæg(75,"Wifi", h2);

        Hotel h3 = createHotel("Pension Tusindfryd", "Tusindfrydsvej 10", 500.0,600.0);
        Tillæg tillæg4 = createTillæg(100,"Morgenmad",h3);

        Arrangement a1 = createArrangement("Byrundtur Odense", 125,LocalDate.of(2022,4,21), konference);
        Arrangement a2 = createArrangement("Egeskov",75,LocalDate.of(2022,4,20),konference);
        Arrangement a3 = createArrangement("Trapholt Museum", 200, LocalDate.of(2022,4,22),konference);

        Deltager d1 = createDeltager("Finn Madsen", "Vejen 10", 88888888, false, "Intet firma", 0);
        createTilmelding("Danmark", "Bedsted", LocalDate.of(2022,4,20), LocalDate.of(2022,4,22), d1, null,konference);

        Deltager d2 = createDeltager("Niels Petersen", "Vejen 11", 12323123,false,"Prutskid",123910);
        createTilmelding("Uruguay", "Krasnivkaovosa", LocalDate.of(2022,4,20), LocalDate.of(2022,4,22), d2,h1,konference);

        Deltager d3 = createDeltager("Peter Sommer", "Skanderborgvej",88888888,false,"Ptur",12930102);
        Ledsager l1 = createLedsager("Mie Sommer",d3);

        Tilmelding t3 = createTilmelding("Danmark", "Bedsted", LocalDate.of(2022,4,20),LocalDate.of(2022,4,22), d3, h1, konference);
        addTillægToTilmelding(t3,tillæg1);

        Deltager d4 = createDeltager("Lone Jensen", "Prutvej 2", 2341312,true,"2sdafasd",1234121);
        Tilmelding t4 = createTilmelding("Afghanistan", "Jerusalem", LocalDate.of(2022,4,20),LocalDate.of(2022,4,22), d4,h1,konference);
        Ledsager l2 = createLedsager("Finn Madsen", d4);
        addTillægToTilmelding(t4,tillæg1);
        addArrangementToLedsager(a1,l2);
        addArrangementToLedsager(a2,l2);
        addHotelToKonference(konference,h1);
        addHotelToKonference(konference,h2);
        addHotelToKonference(konference,h3);

    }

    public static void init(){

        initStorage();
    }
}
