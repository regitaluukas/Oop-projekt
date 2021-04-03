import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class PannkookPeaklass {

    public static void main(String[] args) {
        List<Toiduaine> valitudToidud = new ArrayList<>();
        List<String> toiduained = new ArrayList<>();
        toiduained.addAll(Arrays.asList("muna", "keefir", "suhkur", "tärklis", "nisujahu", "sool", "piim", "või", "rõõsk koor"));
        Hashtable<String, String> ühikud = new Hashtable<>(); //Sõnastik, kus on kirjas toiduainete mõõtühikud
        ühikud.put("muna", "tk");
        ühikud.put("keefir", "dl");
        ühikud.put("suhkur", "g");
        ühikud.put("tärklis", "g");
        ühikud.put("nisujahu","g");
        ühikud.put("sool", "g");
        ühikud.put("piim", "dl");
        ühikud.put("või", "g");
        ühikud.put("rõõsk koor", "dl");

        Scanner scan = new Scanner(System.in);
        System.out.println("Tere tulemast kokkamise mängu!\n" +
                "Selles mängus pead sa etteantud retsepti järgi valmistama pannkooke. " +
                "Esmalt pead valima ära kõik toiduained ja nende kogused, mis sul pannkookide tegemiseks vaja läheb. " +
                "Seejärel saad hakata valitud toituainetega tegevusi tegema.\n" +
                "Kui arvad, et said retseptis " +
                "kõik tehtud, siis kirjuta peale vastavat küsimust 'jah.'\n\n" +
                "Retsept:\n" +
                "4 muna\n" +
                "60 g suhkur\n" +
                "200 g nisujahu\n" +
                "1 g soola\n" +
                "5 dl piima\n" +
                "50 g sulatatud võid\n\n" +
                "Klopi munad, sega suhkruga, sega juurde jahu, piim ja sool.\n" +
                "Viimasena lisa juurde sulatatud või ja sega läbi. Prae tainas pannil.\n");

        System.out.println("Kas alustada mänguga? (jah/ei)");
        String alusta = scan.next();
        if (alusta.equalsIgnoreCase("jah")) { //Mäng algab
            while (true) {
                System.out.println("Toiduainete valik:");
                for (int i = 0; i < toiduained.size(); i++) {
                    System.out.println(i + 1 + "." + toiduained.get(i));
                }
                //Toiduaine
                System.out.println("Vali toiduaine (numbriga):");
                int valik = scan.nextInt();
                if (valik < 1 || valik > toiduained.size() - 1){
                    System.out.println("Valitud numbriga toiduainet pole, proovi uuesti");
                    continue;
                }
                String toiduNimetus = toiduained.get(valik - 1);
                toiduained.remove(valik - 1);
                //Kogus
                System.out.println("Siseta kogus (täisarv, "+ühikud.get(toiduNimetus)+"):"); //siia mingit ühiku asja vaja
                int kogus = scan.nextInt();
                //Toiduaine
                Toiduaine toiduaine = new Toiduaine(toiduNimetus, kogus,ühikud.get(toiduNimetus));

                valitudToidud.add(toiduaine);
                //Kui toiduainete list on juba tühi
                if (toiduained.size() == 0)
                    break;
                System.out.println("Kas soovid veel toiduaineid lisada?(jah/ei)");
                String veel = scan.next();
                if (veel.equalsIgnoreCase("ei")){
                    break;
                }
            //Kui toiduained lisatud, liigub tegevuste juurde
            }
            while(true){
                String[] tegevused = {"klopi", "prae", "sulata", "sega"};
                //Väljastab valitud toiduained
                System.out.println("Toiduainete valik:");
                for (int i = 0; i < valitudToidud.size(); i++) {
                    System.out.println(i + 1 + ". " + valitudToidud.get(i));
                }
                //Tegevus
                System.out.println("\nMida valikust järgmisena teha?");
                for (int i = 0; i < tegevused.length; i++) {
                    System.out.println(i + 1 + "." + tegevused[i]);
                }
                int tegevus = scan.nextInt()-1;

                System.out.println();
                if(tegevus ==3){
                    System.out.println("Vali esimene toiduaine (numbriga):");
                    int valik1 = scan.nextInt();
                    Toiduaine valitud1 = valitudToidud.get(valik1-1);
                    valitudToidud.remove(valik1-1);
                    System.out.println("Toiduainete valik:");
                    for (int i = 0; i < valitudToidud.size(); i++) {
                        System.out.println(i + 1 + ". " + valitudToidud.get(i));
                    }
                    System.out.println("Vali teine toiduaine (numbriga):");
                    int valik2 = scan.nextInt();
                    Toiduaine valitud2 = valitudToidud.get(valik2-1);
                    valitudToidud.remove(valik2-1);
                    SegatudToiduaine segatud = new SegatudToiduaine(valitud1,valitud2);
                    valitud1.segamine();
                    valitudToidud.add(segatud);
                }

                else {
                    System.out.println("Vali toiduaine (numbriga):");
                    int valik = scan.nextInt();
                    Toiduaine valitud = valitudToidud.get(valik - 1);
                    //valitudToidud.remove(valik-1);

                    switch (tegevus) {
                        case 0 -> valitud.kloppimine();
                        case 1 -> valitud.praadimine();
                        case 2 -> valitud.sulatamine();
                        default -> System.out.println("Valisid tegevuse, mida valikus pole!");
                    }
                }

                System.out.println("Kas pannkoogid on valmis (jah/ei)?");
                String valmis = scan.next();
                if (valmis.equalsIgnoreCase("jah")){
                    break;
                }
            }
            //lõpu kontrollimine
            String lõpp = valitudToidud.get(0).toString();
            if (lõpp.contains("60 g suhkur")&&lõpp.contains("200 g nisujahu")&&lõpp.contains("4 tk klopitud muna")&&
                    lõpp.contains("50 g sulatatud või")&&lõpp.contains("5 dl piim")&&lõpp.contains("Segatud")&&
            !lõpp.contains("tärklis")&&!lõpp.contains("keefir")&&!lõpp.contains("rõõsk koor")){
                System.out.println("Valmistasid super pannkoogid, head isu!");
            }
            else {
                System.out.println("Pead veel veidi harjutama, aga head isu sellegipoolest!");
            }

        }
        //mängu ei alustata
        else {
            System.out.println("Seekord jäid pannkoogid tegemata! :(");
        }
    }
}

