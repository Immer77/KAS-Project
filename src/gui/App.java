package gui;

import javafx.application.Application;
import modelclass.*;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Application.launch(Gui.class);
//        Konference konference = new Konference("Hav og Himmel", "Sønderhøj 30", LocalDate.of(2022,4,20),LocalDate.of(2022,4,22),1500);
//        Hotel h1 = new Hotel("Den hvide svane","HvideSvanevej 10", 1050.0,1250.0);
//        Tillæg tillæg = h1.createTillæg(50,"Wifi");
//
//        Hotel h2 = new Hotel("Høtel Phønix","Phønixvej 14",700.0,800.0);
//        h2.createTillæg(200,"Bad");
//        h2.createTillæg(75,"Wifi");
//
//        Hotel h3 = new Hotel("Pension Tusindfryd", "Tusindfrydsvej 10", 500.0,600.0);
//        h3.createTillæg(100,"Morgenmad");
//
//        Arrangement a1 = new Arrangement("Byrundtur Odense", 125,LocalDate.of(2022,4,21));
//        Arrangement a2 = new Arrangement("Egeskov",75,LocalDate.of(2022,4,20));
//        Arrangement a3 = new Arrangement("Trapholt Museum", 200, LocalDate.of(2022,4,22));
//
//        Deltager d1 = new Deltager("Finn Madsen", "Vejen 10", 2011680025, 88888888, false, "Intet firma", 0);
//        Tilmelding t1 = new Tilmelding("Danmark", "Bedsted", LocalDate.of(2022,4,20), LocalDate.of(2022,4,22), d1, null,konference);
//        System.out.println(t1.beregnSamletPris());
//
//        Deltager d2 = new Deltager("Niels Petersen", "Vejen 11", 2103912094, 12323123,false,"Prutskid",123910);
//        Tilmelding t2 = new Tilmelding("Uruguay", "Krasnivkaovosa", LocalDate.of(2022,4,20), LocalDate.of(2022,4,22), d2,h1,konference);
//        System.out.println(t2.beregnSamletPris());
//
//        Deltager d3 = new Deltager("Peter Sommer", "Skanderborgvej",2131290,88888888,false,"Ptur",12930102);
//        Ledsager l1 = d3.createLedsager("Mie Sommer");
//        l1.addArrangement(a2);
//        l1.addArrangement(a3);
//        Tilmelding t3 = new Tilmelding("Danmark", "Bedsted", LocalDate.of(2022,4,20),LocalDate.of(2022,4,22), d3, h1, konference);
//        t3.addTillæg(tillæg);
//        System.out.println(t3.beregnSamletPris());
//
//        Deltager d4 = new Deltager("Lone Jensen", "Prutvej 2", 20321412,2341312,true,"2sdafasd",1234121);
//        Tilmelding t4 = new Tilmelding("Afghanistan", "Jerusalem", LocalDate.of(2022,4,20),LocalDate.of(2022,4,22), d4,h1,konference);
//        Ledsager l2 = d4.createLedsager("Finn Madsen");
//        t4.addTillæg(tillæg);
//        l2.addArrangement(a1);
//        l2.addArrangement(a2);
//        System.out.println(t4.beregnSamletPris());
//

    }

}
