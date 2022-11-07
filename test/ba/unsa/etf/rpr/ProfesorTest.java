package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProfesorTest {
    private static Profesor vedran;
    private static Profesor zeljko;
    private static Profesor naida;
    private static Profesor novica;
    private static Profesor haris;
    private static ArrayList<Predmet> predmetiTreci=new ArrayList<>();
    private static ArrayList<Predmet> izborniZaTreci=new ArrayList<>();
    private static ArrayList<Semestar> semestri=new ArrayList<>();
    private static Fakultet fakultet;

    @BeforeAll
    static void setUp(){
       // samir=new Profesor("Samir", "Ribić");
        vedran=new Profesor("Vedran", "Ljubovic");
        zeljko=new Profesor("Željko", "Jurić");
        naida=new Profesor("Naida", "Mujic");
        novica=new Profesor("Novica", "Nosovic");
        haris=new Profesor("Haris", "Šupić");
        predmetiTreci.add(new Predmet("ASP", 5,haris, false,2));
        predmetiTreci.add(new Predmet("LD", 5, novica, false,2));
        predmetiTreci.add(new Predmet( "RPR", 5, vedran, false,2));
        predmetiTreci.add(new Predmet( "OBP", 5, new Profesor("Emir", "Buza"), false,2));
        predmetiTreci.add(new Predmet( "DM", 5, zeljko, false,2));
        predmetiTreci.add(new Predmet( "NA", 5, zeljko, true,2));
        izborniZaTreci.add(new Predmet( "SP", 5,  novica, true,2));
        Semestar semestar = new Semestar(1, 3, predmetiTreci, izborniZaTreci);
        semestri.add(semestar);
        fakultet=new Fakultet(semestri);

    }
    @Test
    public void testKonstruktor1(){
        Profesor profesor=new Profesor("Samir", "Ribić");
        assertAll(
                () -> assertEquals("Samir", profesor.getIme()),
                () -> assertEquals("Ribić", profesor.getPrezime()),
                () -> assertTrue(profesor.getPredmeti().isEmpty())

        );
    }
    @Test
    public void testSetteri(){
        Profesor profesor=new Profesor("Samir", "Ribić");
        profesor.setIme("Novica");
        profesor.setPrezime("Nosovic");
        profesor.setPredmeti(izborniZaTreci);
        assertAll(
                () -> assertEquals("Novica", profesor.getIme()),
                () -> assertEquals("Nosovic", profesor.getPrezime()),
                () -> assertEquals(1,profesor.getPredmeti().size())
        );
    }
    @Test
    public void testNorma(){
        Student s1 = new Student("ime", "prezime", 18780);
        s1.setFakultet(fakultet);
        s1.upisiSemestar(3,1);
        assertAll(
                () -> assertEquals(1, novica.brojStuendata()),
                () -> assertEquals(125, novica.izracunajNormu())


        );
    }

}

