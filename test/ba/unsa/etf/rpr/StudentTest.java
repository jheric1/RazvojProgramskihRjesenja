package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private static HashMap<String, Integer> ocjenaPredmet = new HashMap<>();
    private static HashMap<String, Integer> ocjenaPredmet2 = new HashMap<>();
    private static HashMap<Integer, HashMap<String, Integer>> saSemestrom = new HashMap<>();


    @BeforeAll
    static void setUp() {

        ocjenaPredmet.put("IM", 7);
        ocjenaPredmet.put("OE", 9);
        ocjenaPredmet2.put("DM", 8);
        ocjenaPredmet2.put("RPR", 9);
        saSemestrom.put(1, ocjenaPredmet);
        saSemestrom.put(3, ocjenaPredmet2);
    }


    @Test
    public void testKonstruktor1() {
        Student student = new Student("ime", "prezime", 19999);
        assertAll(
                () -> assertEquals("ime", student.getIme()),
                () -> assertEquals("prezime", student.getPrezime()),
                () -> assertEquals(19999, student.getBrojIndeksa()),
                () -> assertTrue(student.getPredmeti().isEmpty())

        );
    }

    @Test
    public void testKonstruktor2() {
        Student student = new Student("Jasmina", "Heric", 18780, saSemestrom);
        assertAll(
                () -> assertEquals("Jasmina", student.getIme()),
                () -> assertEquals("Heric", student.getPrezime()),
                () -> assertEquals(18780, student.getBrojIndeksa()),
                () -> assertEquals(saSemestrom, student.getOcjene())

        );

    }
    @Test
    public void testSetteri(){
        Student student = new Student("ime", "prezime", 19999);
        student.setIme("Jasmina");
        student.setPrezime("Heric");
        student.setOcjene(saSemestrom);
        student.setBrojIndeksa(18780);
        assertAll(
                () -> assertEquals("Jasmina", student.getIme()),
                () -> assertEquals("Heric", student.getPrezime()),
                () -> assertEquals(18780, student.getBrojIndeksa()),
                () -> assertEquals(saSemestrom, student.getOcjene())

        );
    }
    @Test
    public void testPrepisOcjena(){
        Student student = new Student("Jasmina", "Heric", 18780, saSemestrom);
        String tacno = "Ocjene za 1. semestar su:\n" +
                "IM 7\n" +
                "OE 9\n" +
                "Ocjene za 3. semestar su:\n" +
                "RPR 9\n" +
                "DM 8\n";
        assertEquals(tacno, student.prepisOcjena());
    }
}
