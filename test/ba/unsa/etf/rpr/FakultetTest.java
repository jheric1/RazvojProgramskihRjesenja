package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FakultetTest {
    private static Fakultet fakultet;
    private static ArrayList<Semestar> semestri = new ArrayList<>();
    private static ArrayList<Predmet> predmetiPrvi = new ArrayList<>();
    private static ArrayList<Predmet> predmetiDrugi = new ArrayList<>();
    private static ArrayList<Predmet> predmetiZaTreci = new ArrayList<>();
    private static ArrayList<Predmet> predmetiZaCetvrti = new ArrayList<>();
    private static ArrayList<Predmet> izborniZaTreci = new ArrayList<>();
    private static ArrayList<Predmet> izborniZaCetvrti = new ArrayList<>();
    private static Profesor samir = new Profesor("Samir", "Ribić");
    private static Profesor vedran = new Profesor("Vedran", "Ljubovic");
    private static Profesor zeljko = new Profesor("Željko", "Jurić");
    private static Profesor naida = new Profesor("Naida", "Mujic");
    private static Profesor novica = new Profesor("Novica", "Nosović");
    private static Profesor haris = new Profesor("Haris", "Šupić");
    private static Semestar prviSemestar = new Semestar(1, 1, predmetiPrvi, new ArrayList<>());
    private static Semestar drugiSemestar = new Semestar(1, 2, predmetiDrugi, new ArrayList<>());
    private static Semestar treciSemestar = new Semestar(1, 3, predmetiZaTreci, izborniZaTreci);
    private static Semestar cetvrtiSemestar = new Semestar(1, 4, predmetiZaCetvrti, izborniZaCetvrti);
    private static HashMap<String, Integer> ocjenaPredmet = new HashMap<>();
    private static HashMap<String, Integer> ocjenaPredmet2 = new HashMap<>();
    private static HashMap<Integer, HashMap<String, Integer>> saSemestrom = new HashMap<>();

    @BeforeAll
    static void setUp() {
        predmetiPrvi.add(new Predmet("IM1", 7, naida, false, 1));
        predmetiPrvi.add(new Predmet("IF1", 5, new Profesor("Dijana", "Dujak"), false, 1));
        predmetiPrvi.add(new Predmet("UUP", 6, vedran, false, 1));
        predmetiPrvi.add(new Predmet("OE", 7, new Profesor("Mirza", "Hamza"), false, 1));
        predmetiPrvi.add(new Predmet("LAG", 5, new Profesor("Jusuf", "Ramic"), false, 1));

        predmetiDrugi.add(new Predmet("IM2", 7, naida, false, 1));
        predmetiDrugi.add(new Predmet("TP", 6, zeljko, false, 1));
        predmetiDrugi.add(new Predmet("MLTI", 7, new Profesor("Dinko", "Osmanković"), false, 1));
        predmetiDrugi.add(new Predmet("VIS", 5, new Profesor("Amela", "Ribić"), false, 1));
        predmetiDrugi.add(new Predmet("OS", 5, samir, false, 1));

        predmetiZaTreci.add(new Predmet("ASP", 5, haris, false, 2));
        predmetiZaTreci.add(new Predmet("LD", 5, novica, false, 2));
        predmetiZaTreci.add(new Predmet("RPR", 5, vedran, false, 2));
        predmetiZaTreci.add(new Predmet("OBP", 5, new Profesor("Emir", "Buza"), false, 2));
        predmetiZaTreci.add(new Predmet("DM", 5, zeljko, false, 2));
        izborniZaTreci.add(new Predmet("NA", 5, zeljko, true, 2));
        izborniZaTreci.add(new Predmet("SP", 5, samir, true, 2));

        predmetiZaCetvrti.add(new Predmet("RA", 5, novica, false, 2));
        predmetiZaCetvrti.add(new Predmet("ORM", 5, new Profesor("hamo", "hamic"), false, 2));
        predmetiZaCetvrti.add(new Predmet("OOAD", 5, new Profesor("hana", "hanic"), false, 2));
        predmetiZaCetvrti.add(new Predmet("AFJ", 5, haris, false, 2));
        izborniZaCetvrti.add(new Predmet("RMA", 5, new Profesor("jure", "juric"), true, 2));
        izborniZaCetvrti.add(new Predmet("CCI", 5, new Profesor("ludo", "ludic"), true, 2));
        izborniZaCetvrti.add(new Predmet("US", 5, new Profesor("ramo", "ramic"), true, 2));
        izborniZaCetvrti.add(new Predmet("DPS", 5, new Profesor("meho", "mehic"), true, 2));
        semestri.add(prviSemestar);
        semestri.add(drugiSemestar);
        semestri.add(treciSemestar);
        semestri.add(cetvrtiSemestar);
        fakultet = new Fakultet(semestri);
        ocjenaPredmet.put("IM", 7);
        ocjenaPredmet.put("OE", 9);
        ocjenaPredmet2.put("DM", 8);
        ocjenaPredmet2.put("RPR", 9);
        saSemestrom.put(1, ocjenaPredmet);
        saSemestrom.put(3, ocjenaPredmet2);
    }

    @Test
    public void testKonstruktor1() {
        fakultet = new Fakultet(semestri);
        assertAll(
                () -> assertEquals(semestri, fakultet.getSemestri()),
                () -> assertTrue(fakultet.getStudenti().isEmpty())
        );
    }

    @Test
    public void testSetteri() {
        ArrayList<Semestar> semestri2 = new ArrayList<>();
        semestri2 = semestri;
        semestri2.remove(0);
        fakultet.setSemestri(semestri2);
        final ArrayList<Semestar> finalSemestri = semestri2;
        assertAll(
                () -> assertEquals(finalSemestri, fakultet.getSemestri()),
                () -> assertTrue(fakultet.getStudenti().isEmpty())
        );
    }

    @Test
    public void testStudenti() {
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
        final ArrayList<Profesor> bezNorme=fakultet.nemajuNormu();
        final ArrayList<Profesor> prekoNorme=fakultet.prekoNorme();
        final ArrayList<Profesor> poBrojuStudenata=fakultet.sortirajPoBrojuStudenata();
        final ArrayList<Profesor> poNormi=fakultet.sortirajPoNormi();
        assertAll(
                () -> assertEquals(bezNorme.get(0), fakultet.nemajuNormu().get(0)),
                () -> assertEquals(prekoNorme.get(2), fakultet.prekoNorme().get(2)),
                () -> assertEquals(poBrojuStudenata.get(7), fakultet.sortirajPoBrojuStudenata().get(7)),
                () -> assertEquals(poNormi.get(10), fakultet.sortirajPoNormi().get(10))
        );
    }
}
