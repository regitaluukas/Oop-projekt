import java.util.concurrent.TimeUnit;

public class Toiduaine {
    private String nimetus;
    private int kogus;
    private String ühik;
    private String olek; //Näitab, kas toiduainega on mingi tegevus tehtud

    public Toiduaine(String nimetus, int kogus, String ühik) {
        this.nimetus = nimetus;
        this.kogus = kogus;
        this.ühik = ühik;
        this.olek = null;
    }

    public Toiduaine() {
    }

    public String getNimetus() {
        return nimetus;
    }

    public int getKogus() {
        return kogus;
    }

    public void setOlek(String uus) {
        this.olek = uus;
    }

    @Override
    public String toString() {
        if (olek == null)
            return kogus + " " + ühik + " " + nimetus;
        else
            return kogus + " " + ühik + " " + olek + " " + nimetus;
    }
    //Igal järgneval tegevusel on juhuslikult valitud ooteaeg
    public void kloppimine() {
        int aeg = (int) (Math.random() * (4)) + 1;
        System.out.println("Nüüd klopin, oota...");
        try {
            for (int i = 0; i < aeg; i++) {
                System.out.println(aeg - i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Klopitud!");
        this.olek = "klopitud";
    }

    public void praadimine() {
        int aeg = (int) (Math.random() * (9)) + 1;
        System.out.println("Nüüd praen, oota...");
        try {
            for (int i = 0; i < aeg; i++) {
                System.out.println(aeg - i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Praetud!");
        this.olek = "praetud";
    }

    public void sulatamine() {
        int aeg = (int) (Math.random() * (8)) + 1;
        System.out.println("Nüüd sulatan, oota...");
        try {
            for (int i = 0; i < aeg; i++) {
                System.out.println(aeg - i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sulatatud!");
        this.olek = "sulatatud";
    }

    public void segamine() {
        int aeg = (int) (Math.random() * (5)) + 1;
        System.out.println("Nüüd segan, oota...");
        try {
            for (int i = 0; i < aeg; i++) {
                System.out.println(aeg - i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Segatud!");
    }
}
