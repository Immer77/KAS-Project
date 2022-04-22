package modelclass;


public class Deltager extends Person {

    private boolean erForedragsholder;
    private String firmaNavn;
    private int firmaTlf;
    private Ledsager ledsager;

    /**
     * nedarver fra Person klassen
     * @param navn
     * @param adresse
     * @param cpr
     * @param tlfNr
     * *******
     * Deltager specifik
     * @param erForedragsholder
     * @param firmaNavn
     * @param firmaTlf
     */
    public Deltager(String navn, String adresse, int cpr, int tlfNr, boolean erForedragsholder, String firmaNavn,int firmaTlf) {
        super(navn, adresse, cpr, tlfNr);
        this.erForedragsholder = erForedragsholder;
        this.firmaNavn = firmaNavn;
        this.firmaTlf = firmaTlf;
    }


    /**
     * laver en ledsager på deltageren (overskriver ledsager)
     *
     * skal bruge navnet på ledsager
     * @param navn
     * returnere ledsageren
     * @return
     */
    public Ledsager createLedsager(String navn){
        Ledsager ledsager = new Ledsager(navn, this);
        this.ledsager = ledsager;
        return ledsager;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }


    public void removeLedsager(){
        if(ledsager != null) {
            this.ledsager = null;
        }
    }

    public boolean isErForedragsholder() {
        return erForedragsholder;
    }
    public double samletPrisUdflugter(){
        double result = 0.0;
        if(getLedsager() != null){
            result += ledsager.samletPrisForUdflugter();
        }
        return result;
    }
}
