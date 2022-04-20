package storage;

import modelclass.*;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Deltager> deltagere = new ArrayList<>();
    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private static ArrayList<Hotel> hoteller = new ArrayList<>();
    private static ArrayList<Konference> konferencer = new ArrayList<>();
    private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    //-----------------------------------------------------------------

    public static ArrayList<Deltager> getDeltagere(){
        return new ArrayList<>(deltagere);
    }

    public static void addDeltager(Deltager deltager){
        deltagere.add(deltager);
    }

    public static void removeDeltager(Deltager deltager){
        deltagere.remove(deltager);
    }

    //-----------------------------------------------------------------


    public static ArrayList<Arrangement> getArrangementer(){
        return new ArrayList<>(arrangementer);
    }

    public static void addArrangement(Arrangement arrangement){
        arrangementer.add(arrangement);
    }

    public static void removeArrangement(Arrangement arrangement){
        arrangementer.remove(arrangement);
    }


    //-----------------------------------------------------------------

    public static ArrayList<Hotel> getHoteller(){
        return new ArrayList<>(hoteller);
    }

    public static void addHotel(Hotel hotel){
        hoteller.add(hotel);
    }

    public static void removeHotel(Hotel hotel){
        hoteller.remove(hotel);
    }

    //-----------------------------------------------------------------

    public static ArrayList<Konference> getKonferencer(){
        return new ArrayList<>(konferencer);
    }

    public static void addKonference(Konference konference){
        konferencer.add(konference);
    }

    public static void removeKonference(Konference konference){
        konferencer.remove(konference);
    }

    //-----------------------------------------------------------------

    public static ArrayList<Tilmelding> getTilmeldinger(){
        return new ArrayList<>(tilmeldinger);
    }

}
