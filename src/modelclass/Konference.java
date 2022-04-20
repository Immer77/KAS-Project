package modelclass;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String lokation;
    private LocalDate tilDato;
    private LocalDate fraDato;
    private ArrayList<Deltager> deltagere = new ArrayList<>();
    private Arrangør arrangør;
    private ArrayList<Hotel> hoteller = new ArrayList<>();
    private ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private double afgiftPrDag;


}
