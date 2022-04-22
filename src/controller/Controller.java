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

    public static Deltager createDeltager(String navn, String adresse, int cpr, int tlfNr, boolean erForedragsholder, String firmaNavn,int firmaTlf){
        Deltager deltager = new Deltager(navn, adresse, cpr, tlfNr,erForedragsholder,firmaNavn,firmaTlf);
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

    //----------------------------------------------------------------------------------------------------------------------------------

    public static Arrangement createArrangement(String titel, double pris, LocalDate dato){
        Arrangement arrangement = new Arrangement(titel, pris, dato);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static void deleteArrangement(Arrangement arrangement){
        Storage.removeArrangement(arrangement);
    }
    public static ArrayList<Arrangement> getarrangementer(){
        return Storage.getArrangementer();
    }

    //-------------------------------------------------------------------------------

    public static Tillæg createTillæg(double pris, String navn, Hotel hotel){
        Tillæg tillæg = hotel.createTillæg(pris,navn);
        return tillæg;
    }



    public static void initStorage(){
        //TODO: Laves næste gang
        createKonference("Hav og Himmel", "Sønderhøj 30", LocalDate.of(2022,4,20),LocalDate.of(2022,4,22),1500);
        Hotel h1 = createHotel("Den hvide svane","HvideSvanevej 10", 1050.0,1250.0);
        createTillæg(50,"Wifi", h1);

        Hotel h2 = createHotel("Høtel Phønix","Phønixvej 14",700.0,800.0);
        createTillæg(200,"Bad", h2);
        createTillæg(75,"Wifi", h2);


    }

    public static void init(){

        initStorage();
    }
}
