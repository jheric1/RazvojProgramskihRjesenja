package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Predmet {
    private String nazivPredmeta;
    private int brojECTS, godina;
    private Profesor profesor;
    private boolean izborni;
    private ArrayList<Student> studentiNaPredmetu=new ArrayList<>();

    public Predmet(String nazivPredmeta, int brojECTS, Profesor profesor, boolean izborni, int godina) {
        this.nazivPredmeta = nazivPredmeta;
        this.brojECTS = brojECTS;
        this.profesor = profesor;
        this.izborni=izborni;
        this.profesor.dodajPredmet(this);
        this.godina=godina;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public int getBrojECTS() {
        return brojECTS;
    }

    public void setBrojECTS(int brojECTS) {
        this.brojECTS = brojECTS;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public boolean isIzborni() {
        return izborni;
    }

    public void setIzborni(boolean izborni) {
        this.izborni = izborni;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public ArrayList<Student> getStudentiNaPredmetu() {
        return studentiNaPredmetu;
    }

    public void setStudentiNaPredmetu(ArrayList<Student> studentiNaPredmetu) {
        this.studentiNaPredmetu = studentiNaPredmetu;
    }
    public void dodajStudenta(Student s){
        if(!studentiNaPredmetu.contains(s))
        studentiNaPredmetu.add(s);
    }
}
