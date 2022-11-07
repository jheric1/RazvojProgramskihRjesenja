package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SemestarTest {
    private static Fakultet fakultet;
    private static ArrayList<Predmet> predmetiPrvi=new ArrayList<>();
    private static ArrayList<Predmet> predmetiDrugi=new ArrayList<>();
    private static ArrayList<Predmet> predmetiTreci=new ArrayList<>();
    private static ArrayList<Predmet> izborniZaTreci=new ArrayList<>();
    private static ArrayList<Predmet> izborniZaCetvrti=new ArrayList<>();
    @BeforeAll
    static void setUp(){
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

        predmetiTreci.add(new Predmet("ASP", 5,haris, false,2));
        predmetiTreci.add(new Predmet("LD", 5, novica, false,2));
        predmetiTreci.add(new Predmet( "RPR", 5, vedran, false,2));
        predmetiTreci.add(new Predmet( "OBP", 5, new Profesor("Emir", "Buza"), false,2));
        predmetiTreci.add(new Predmet( "DM", 5, zeljko, false,2));
        izborniZaTreci.add(new Predmet( "NA", 5, zeljko, true,2));
        izborniZaTreci.add(new Predmet( "SP", 5,  samir, true,2));
    }
    @Test
    public void testKonstruktor1(){
        Semestar semestar = new Semestar(1, 3, predmetiTreci, izborniZaTreci);
        assertAll(
                () -> assertEquals(1, semestar.getCiklus()),
                () -> assertEquals(3, semestar.getRedniBrojSemestra()),
                () -> assertEquals(predmetiTreci, semestar.getPredmeti()),
                () -> assertEquals(izborniZaTreci, semestar.getIzborniPredmeti()),
                () -> assertEquals(2, semestar.getGodina())

        );
    }
    @Test
    public void testSetteri(){
        Semestar semestar = new Semestar(1, 2, predmetiDrugi, new ArrayList<>());
        semestar.setRedniBrojSemestra(3);
        semestar.setPredmeti(predmetiTreci);
        semestar.setIzborniPredmeti(izborniZaTreci);
        semestar.setGodina(2);
        assertAll(
                () -> assertEquals(3, semestar.getRedniBrojSemestra()),
                () -> assertEquals(predmetiTreci, semestar.getPredmeti()),
                () -> assertEquals(izborniZaTreci, semestar.getIzborniPredmeti()),
                () -> assertEquals(2, semestar.getGodina())
        );
    }
}

