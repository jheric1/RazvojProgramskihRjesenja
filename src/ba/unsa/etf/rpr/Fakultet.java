package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Comparator;

public class Fakultet {
    private ArrayList<Semestar> semestri=new ArrayList<>();
    private ArrayList<Student> studenti=new ArrayList<>();

    public Fakultet(ArrayList<Semestar> semestri) {
        this.semestri = semestri;
    }

    public Fakultet() {
    }

    public ArrayList<Predmet> nadjiPredmete(){
        ArrayList<Predmet> predmeti=new ArrayList<>();
        for(Semestar s : semestri) {
            predmeti.addAll(s.getPredmeti());
            predmeti.addAll(s.getIzborniPredmeti());
        }
        return predmeti;
    }
    public ArrayList<Profesor> nadjiProfesore(){
       ArrayList<Profesor> profesori=new ArrayList<>();
        for(Predmet p : nadjiPredmete()){
            if(!profesori.contains(p.getProfesor())) profesori.add(p.getProfesor());
        }
        return profesori;
    }

    public ArrayList<Semestar> getSemestri() {
        return semestri;
    }

    public ArrayList<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(ArrayList<Student> studenti) {
        this.studenti = studenti;
    }

    public void setSemestri(ArrayList<Semestar> semestri) {
        this.semestri = semestri;
    }
    public ArrayList<Profesor> nemajuNormu(){
        ArrayList<Profesor> profesori=nadjiProfesore();
        ArrayList<Profesor> rezultat=new ArrayList<>();
        for(Profesor p : profesori){
            if(p.izracunajNormu()<120) rezultat.add(p);
        }
       return rezultat;
    }
    public ArrayList<Profesor> prekoNorme(){
        ArrayList<Profesor> profesori=nadjiProfesore();
        ArrayList<Profesor> rezultat=new ArrayList<>();
        for(Profesor p : profesori){
            if(p.izracunajNormu()>150) rezultat.add(p);
        }
        return rezultat;
    }
    public ArrayList<Profesor> sortirajPoNormi(){
        ArrayList<Profesor> profesori=nadjiProfesore();
        profesori.sort(Comparator.comparing(p-> p.izracunajNormu()));
        return profesori;
    }
    public ArrayList<Profesor> sortirajPoBrojuStudenata(){
        ArrayList<Profesor> profesori=nadjiProfesore();
        profesori.sort(Comparator.comparing(Profesor::brojStuendata));
        return profesori;
    }
    public void dodajStudenta(Student student){
        studenti.add(student);
    }



}
