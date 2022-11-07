package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final ArrayList<Predmet> predmetiPrvi=new ArrayList<>();
        final ArrayList<Predmet> predmetiDrugi=new ArrayList<>();
        final ArrayList<Predmet> predmetiZaTreci=new ArrayList<>();
        final ArrayList<Predmet> predmetiZaCetvrti=new ArrayList<>();
        final ArrayList<Predmet> izborniZaTreci=new ArrayList<>();
        final ArrayList<Predmet> izborniZaCetvrti=new ArrayList<>();
        final Profesor samir=new Profesor("Samir", "Ribić");
        final Profesor vedran=new Profesor("Vedran", "Ljubovic");
        final Profesor zeljko=new Profesor("Željko", "Jurić");
        final Profesor naida=new Profesor("Naida", "Mujic");
        final Profesor novica=new Profesor("Novica", "Nosović");
        final Profesor haris=new Profesor("Haris", "Šupić");
        predmetiPrvi.add(new Predmet("IM1", 7, naida, false,1));
        predmetiPrvi.add(new Predmet("IF1", 5, new Profesor("Dijana", "Dujak"), false,1));
        predmetiPrvi.add(new Predmet( "UUP", 6, vedran, false,1));
        predmetiPrvi.add(new Predmet( "OE", 7, new Profesor("Mirza", "Hamza"), false,1));
        predmetiPrvi.add(new Predmet( "LAG", 5,  new Profesor("Jusuf", "Ramic"), false,1));

        predmetiDrugi.add(new Predmet("IM2", 7,naida, false,1));
        predmetiDrugi.add(new Predmet("TP", 6, zeljko, false,1));
        predmetiDrugi.add(new Predmet( "MLTI", 7, new Profesor("Dinko", "Osmanković"), false,1));
        predmetiDrugi.add(new Predmet( "VIS", 5, new Profesor("Amela", "Ribić"), false,1));
        predmetiDrugi.add(new Predmet( "OS", 5,  samir, false,1));

        predmetiZaTreci.add(new Predmet("ASP", 5,haris, false,2));
        predmetiZaTreci.add(new Predmet("LD", 5, novica, false,2));
        predmetiZaTreci.add(new Predmet( "RPR", 5, vedran, false,2));
        predmetiZaTreci.add(new Predmet( "OBP", 5, new Profesor("Emir", "Buza"), false,2));
        predmetiZaTreci.add(new Predmet( "DM", 5, zeljko, false,2));
        izborniZaTreci.add(new Predmet( "NA", 5, zeljko, true,2));
        izborniZaTreci.add(new Predmet( "SP", 5,  samir, true,2));

        predmetiZaCetvrti.add(new Predmet("RA", 5,novica, false,2));
        predmetiZaCetvrti.add(new Predmet("ORM", 5, new Profesor("hamo", "hamic"), false, 2 ));
        predmetiZaCetvrti.add(new Predmet("OOAD", 5, new Profesor("hana", "hanic"), false, 2));
        predmetiZaCetvrti.add(new Predmet("AFJ", 5, haris, false, 2));
        izborniZaCetvrti.add(new Predmet("RMA", 5, new Profesor("jure", "juric"), true, 2));
        izborniZaCetvrti.add(new Predmet("CCI", 5, new Profesor("ludo", "ludic"),true, 2));
        izborniZaCetvrti.add(new Predmet( "US", 5, new Profesor("ramo", "ramic"), true,2));
        izborniZaCetvrti.add(new Predmet("DPS", 5, new Profesor("meho", "mehic"), true,2));

        final Semestar prviSemestar=new Semestar(1,1, predmetiPrvi, new ArrayList<>());
        final Semestar drugiSemestar=new Semestar(1,2, predmetiDrugi, new ArrayList<>());
        final Semestar treciSemestar=new Semestar(1,3, predmetiZaTreci, izborniZaTreci);
        final Semestar cetvrtiSemestar=new Semestar(1,4, predmetiZaCetvrti, izborniZaCetvrti);
        final ArrayList<Semestar> semestri=new ArrayList<>();
        semestri.add(prviSemestar);
        semestri.add(drugiSemestar);
        semestri.add(treciSemestar);
        semestri.add(cetvrtiSemestar);
        Fakultet fakultet=new Fakultet(semestri);

        final Scanner readme = new Scanner(System.in);
        int ciklus, redniBrojSemestra, brojIndeksa, brojStudenata;
        String ime, prezime, predmet;
        System.out.print("Unesite broj studenata koje zelite upisati: ");
        brojStudenata=readme.nextInt();
        for(int j=0; j< brojStudenata; j++) {
            readme.nextLine();
            System.out.print("Unesite ime: ");
            ime = readme.nextLine();
            System.out.print("Unesite prezime: ");
            prezime = readme.nextLine();
            System.out.print("Unesite broj indeksa: ");
            brojIndeksa = readme.nextInt();
            final Student s1 = new Student(ime, prezime, brojIndeksa);
            s1.setFakultet(fakultet);
            System.out.print("Unesite ciklus: ");
            ciklus = readme.nextInt();
            System.out.print("Unesite redni broj semestra: ");
            redniBrojSemestra = readme.nextInt();
            try {
                s1.upisiSemestar(redniBrojSemestra, ciklus);
            } catch (IllegalArgumentException e){
                System.out.println(e.toString().substring(e.toString().indexOf(':')+2));
                final int broj = (30 - s1.izracunajECTS()) / semestri.get(redniBrojSemestra - 1).getIzborniPredmeti().get(0).getBrojECTS();
                System.out.println("Izaberite " + broj + " izborni(a) predmet(a): ");
                for (Predmet p : semestri.get(redniBrojSemestra - 1).getIzborniPredmeti()) {
                    System.out.println(p.getNazivPredmeta());
                }
                for (int i = 0; i < broj; i++) {
                    readme.nextLine();
                    System.out.print("Unesite vaš " + (i + 1) + ". izborni predmet: ");
                    predmet = readme.nextLine();
                    for (Predmet p : semestri.get(redniBrojSemestra - 1).getIzborniPredmeti()) {
                        if (predmet.equals(p.getNazivPredmeta())) s1.dodajIzborni(p);
                    }
                }
            }
        }
        final ArrayList<Profesor> profesors=fakultet.sortirajPoBrojuStudenata();
        for(Profesor p : profesors){
            System.out.println("Sortirano po broju studenata: " + p.getIme() + " " + p.brojStuendata());
        }
        final HashMap<String, Integer> ocjenaPredmet=new HashMap<>();
        ocjenaPredmet.put("IM", 7);
        ocjenaPredmet.put("OE", 9);
        HashMap<String, Integer> ocjenaPredmet2=new HashMap<>();
        ocjenaPredmet2.put("DM", 8);
        ocjenaPredmet2.put("RPR", 9);
        HashMap<Integer, HashMap<String,Integer>> saSemestrom=new HashMap<>();
        saSemestrom.put(1, ocjenaPredmet);
        saSemestrom.put(3, ocjenaPredmet2);
        final Student jalo=new Student("Jasmina", "Heric", 18780,saSemestrom);
        System.out.println(jalo.prepisOcjena());

        final Student student1 = new Student("ime", "prezime", 19999);
        final Student student2 = new Student("ime", "prezime", 19998);
        final Student student3 = new Student("ime", "prezime", 19997);
        final Student student4 = new Student("ime", "prezime", 19996);
        student1.setFakultet(fakultet);
        student2.setFakultet(fakultet);
        student3.setFakultet(fakultet);
        student4.setFakultet(fakultet);
        try {
            student1.upisiSemestar(1, 1);
            student2.upisiSemestar(2, 1);
            student3.upisiSemestar(3, 1);
            student4.upisiSemestar(2, 1);
        } catch (IllegalArgumentException e){
            student3.izaberiIzborne(izborniZaTreci);
        }
        System.out.println("po normi");
        final ArrayList<Profesor> bezNorme=new ArrayList<>();
        final ArrayList<Profesor> prekoNorme=new ArrayList<>();
        final ArrayList<Profesor> poBrojuStudenata=new ArrayList<>();
        final ArrayList<Profesor> poNormi=new ArrayList<>();
        for(Profesor p : fakultet.sortirajPoNormi()){
            System.out.println(p.getIme()+" "+p.izracunajNormu()+"\n");
        }
        System.out.println("po broju-------------------------------");
        for(Profesor p : fakultet.sortirajPoBrojuStudenata()){
            System.out.println(p.getIme()+" "+p.brojStuendata()+"\n");
        }
        System.out.println("nema-------------------------------");
        for(Profesor p : fakultet.nemajuNormu()){
            System.out.println(p.getIme()+" "+p.izracunajNormu()+"\n");
        }
        System.out.println("preko-------------------------------");
        for(Profesor p : fakultet.prekoNorme()){
            System.out.println(p.getIme()+" "+p.izracunajNormu()+"\n");
        }


    }
}
