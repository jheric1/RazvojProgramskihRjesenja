package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Comparator;

public class Profesor {
    private String ime, prezime;
    private ArrayList<Predmet> predmeti=new ArrayList<>();

    public Profesor(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    public ArrayList<Predmet> getPredmeti() {
        return predmeti;
    }
    public void setPredmeti(ArrayList<Predmet> predmeti) {
        this.predmeti = predmeti;
    }
    public void dodajPredmet(Predmet predmet){
        this.predmeti.add(predmet);
    }
    public Integer izracunajNormu(){
        Integer rezultat=0;
        //pod pretpostavkom da je 1 ECTS == 25 casova
        for(Predmet p : predmeti){
            if(p.isIzborni()) {
                if (p.getStudentiNaPredmetu().size() != 0)
                    rezultat += p.getBrojECTS() * 25;
            }
            else rezultat+=p.getBrojECTS()*25;
        }
       return rezultat;
    }
    public Integer brojStuendata(){
        final ArrayList<Student> studenti=new ArrayList<>();
        for(Predmet p : predmeti) {
            for (Student s : p.getStudentiNaPredmetu()) {
                if(!studenti.contains(s)){ studenti.add(s);}
            }
        }
        return studenti.size();
    }

}
