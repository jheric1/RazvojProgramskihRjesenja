package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String ime;
    private String prezime;
    private ArrayList<Predmet> predmeti=new ArrayList<>();
    private int brojIndeksa;
    private Fakultet fakultet;
    private HashMap<Integer, HashMap<String, Integer>> ocjene=new HashMap<>();


    public Student(String ime, String prezime, int brojIndeksa) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndeksa=brojIndeksa;
    }
    public Student(String ime, String prezime, int brojIndeksa, HashMap<Integer, HashMap<String, Integer>> ocjene) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndeksa=brojIndeksa;
        this.ocjene=ocjene;
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
    public void upisiSemestar(int semestar, int ciklus) throws IllegalArgumentException{
        ArrayList<Semestar> semestri= fakultet.getSemestri();
        for(Semestar s : semestri){
            if(s.getCiklus()==ciklus && s.getRedniBrojSemestra()==semestar){
                predmeti.addAll(s.getPredmeti());
            }
        }
        for(Predmet p : predmeti){
            p.dodajStudenta(this);
        }

        if(izracunajECTS()<30) throw new IllegalArgumentException("Broj ECTS manji od 30!");
    }

    public Fakultet getFakultet() {
        return fakultet;
    }

    public void setFakultet(Fakultet fakultet) {
        this.fakultet = fakultet;
    }

    public int izracunajECTS(){
        int rezultat=0;
        for(Predmet p:predmeti){
        rezultat+=p.getBrojECTS();
        }
        return rezultat;
    }
    public void izaberiIzborne(ArrayList<Predmet> izborniPredmeti){
        for(Predmet p : izborniPredmeti){
            int ects=izracunajECTS();
            int pom=ects+p.getBrojECTS();
            if(ects<30 && pom<=30) predmeti.add(p);
        }
    }
    public void dodajIzborni(Predmet p){
        p.dodajStudenta(this);
        this.predmeti.add(p);
    }

    public HashMap<Integer, HashMap<String, Integer>> getOcjene() {
        return ocjene;
    }

    public int getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(int brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public void setOcjene(HashMap<Integer, HashMap<String, Integer>> ocjene) {
        this.ocjene = ocjene;
    }
    public String prepisOcjena(){
        String rezultat="";
        for(Integer pom : ocjene.keySet()){
            rezultat+="Ocjene za " +pom+". semestar su:\n";
            for(String pom2 : ocjene.get(pom).keySet()){
                    rezultat+=pom2+" "+ocjene.get(pom).get(pom2)+"\n";
            }
        }
        return rezultat;
    }

    @Override
    public boolean equals(Object obj) {
        Student s=(Student)obj;
        return this.brojIndeksa==s.brojIndeksa;
    }
}
