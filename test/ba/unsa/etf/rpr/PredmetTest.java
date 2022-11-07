package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {
    private static ArrayList<Student> studenti=new ArrayList<>();
    private static Profesor samir;
    private static Profesor vedran;
    private static Profesor zeljko;
    private static Profesor naida;
    private static Profesor novica;
    private static Profesor haris;
    @BeforeAll
    static void setUp(){
        samir=new Profesor("Samir", "Ribić");
        vedran=new Profesor("Vedran", "Ljubovic");
        zeljko=new Profesor("Željko", "Jurić");
        naida=new Profesor("Naida", "Mujic");
        novica=new Profesor("Novica", "Nosović");
        haris=new Profesor("Haris", "Šupić");
    }
    @Test
    public void testKonstruktor1(){
        Predmet predmet=new Predmet("IM1", 7, naida, false,1);
        assertAll(
                () -> assertEquals("IM1", predmet.getNazivPredmeta()),
                () -> assertEquals(7, predmet.getBrojECTS()),
                () -> assertEquals(naida, predmet.getProfesor()),
                () -> assertFalse(predmet.isIzborni()),
                () -> assertEquals(1, predmet.getGodina()),
                () -> assertTrue(predmet.getStudentiNaPredmetu().isEmpty())

        );
    }
    @Test
    public void testSetteri(){
        Predmet predmet = new Predmet( "RPR", 5, vedran, false,2);
        predmet.setNazivPredmeta("DM");
        predmet.setBrojECTS(6);
        predmet.setProfesor(zeljko);
        predmet.setIzborni(true);
        predmet.setGodina(3);
        assertAll(
                () -> assertEquals("DM", predmet.getNazivPredmeta()),
                () -> assertEquals(6, predmet.getBrojECTS()),
                () -> assertEquals(zeljko, predmet.getProfesor()),
                () -> assertEquals(3, predmet.getGodina()),
                () -> assertTrue(predmet.isIzborni())

        );
    }
}

