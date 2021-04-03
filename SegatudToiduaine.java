public class SegatudToiduaine extends Toiduaine{
    private Toiduaine toit1;
    private Toiduaine toit2;

    public SegatudToiduaine(Toiduaine toit1, Toiduaine toit2){
        this.toit1 = toit1;
        this.toit2 = toit2;
    }

    public String toString(){
        return "Segatud " +toit1.toString().replace("Segatud ", "") +" ja "
                + toit2.toString().replace("Segatud ", "");
    }

} //Alamklass kahe toiduaine segamiseks
