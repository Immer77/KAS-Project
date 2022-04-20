package modelclass;

public class Arrangør extends Person {
    private double løn;
    private int iD;

    public Arrangør(String navn, String adresse, int cpr, int tlfNr, double løn, int iD) {
        super(navn, adresse, cpr, tlfNr);
        this.løn = løn;
        this.iD = iD;
    }


}
