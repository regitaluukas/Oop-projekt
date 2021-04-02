import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class PannkookPeaklass {

    public static void main(String[] args) {
        List<String> toiduained = Arrays.asList("muna", "suhkur", "nisujahu", "sool", "piim", "või");
        String[] tegevused = {"klopi", "lisa", "prae", "sega", "sulata"};
        Hashtable<String, String> ühikud = new Hashtable<>();
        ühikud.put("muna", "tk");
        ühikud.put("suhkur", "g");
        ühikud.put("nisujahu","g");
        ühikud.put("sool", "g");
        ühikud.put("või", "g");
        ühikud.put("piim", "dl");

        Scanner scan = new Scanner(System.in);
        System.out.println("Mängu tutvustus, retsept");

        System.out.println("Kas alustada mänguga? (jah/ei)");
        String alusta = scan.next();
        if (alusta.equalsIgnoreCase("jah")) {
            while (true) {
                System.out.println("Toiduainete valik:");
                for (int i = 0; i < toiduained.size(); i++) {
                    System.out.println(i + 1 + "." + toiduained.get(i));
                }
                //Toiduaine
                System.out.println("Vali toiduaine (numbriga):");
                int valik = scan.nextInt();
                String toiduNimetus = toiduained.get(valik - 1);
                toiduained.remove(valik - 1);
                //Kogus
                System.out.println("Siseta kogus (täisarv):"); //siia mingit ühiku asja vaja
                int kogus = scan.nextInt();
                //Toiduaine
                Toiduaine toiduaine = new Toiduaine(toiduNimetus,kogus);
                //Tegevus
                System.out.println("Mida valikust järgmisena teha?");
                for (int i = 0; i < tegevused.length; i++) {
                    System.out.println(i + 1 + "." + tegevused[i]);
                }
                int tegevus = scan.nextInt();
                switch (tegevus) {
                    case 1:
                        kloppimine(toiduaine);
                        break;
                    case 2:
                        lisamine(toiduaine);
                        break;
                    case 3:
                        praadimine(toiduaine);
                        break;
                    case 4:
                        segamine(toiduaine);
                        break;
                    case 5:
                        sulatamine(toiduaine);
                        break;
                    default:
                        System.out.println("Valisid numbri, mida valikus pole!");
                }
            }
        }
        else {
            System.out.println("Seekord jäid pannkoogid tegemata! :(");
        }
    }
}
