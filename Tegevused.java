import java.util.concurrent.TimeUnit;

public abstract class Tegevused {

    public void Aeg(){
        int aeg = (int) (Math.random()*(9)) + 1;
        try {
            TimeUnit.SECONDS.sleep(aeg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void Väljasta();
}
