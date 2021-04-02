public class kloppimine extends Tegevused{

    @Override
    public void Väljasta() {

    }

    public String kloppimine(Toiduaine toit){
        return toit.getKogus() + "klopitud" + toit.getNimetus();
    }
}
