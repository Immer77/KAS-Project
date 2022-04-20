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

    public static void initStorage(){
        //TODO: Laves næste gang
    }

    public static void init(){

        initStorage();
    }
}
