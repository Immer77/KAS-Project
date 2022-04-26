package modelclass;

public class Tillæg {
    private double pris;
    private String navn;


    public Tillæg(double pris, String navn){
        this.pris = pris;
        this.navn = navn;
    }

    public double getPris() {
        return pris;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString(){
        return navn + " " + pris +  " Kr.";
    }
}
