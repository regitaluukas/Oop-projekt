public class Toiduaine {
    private String nimetus;
    private int kogus;
    private String ühik;

    public Toiduaine(String nimetus, int kogus) {
        this.nimetus = nimetus;
        this.kogus = kogus;
    }

    public String getNimetus() {
        return nimetus;
    }

    public int getKogus() {
        return kogus;
    }

    @Override
    public String toString() {
        return kogus + " " + nimetus;
    }
}
