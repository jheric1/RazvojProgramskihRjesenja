package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Semestar {
    private int ciklus, redniBrojSemestra, godina;
    private ArrayList<Predmet> predmeti=new ArrayList<>();
    private ArrayList<Predmet> izborniPredmeti=new ArrayList<>();


    public Semestar(int ciklus, int redniBrojSemestra, ArrayList<Predmet> predmeti, ArrayList<Predmet> izborniPredmeti) {
        this.ciklus = ciklus;
        this.redniBrojSemestra = redniBrojSemestra;
        this.predmeti = predmeti;
        this.izborniPredmeti = izborniPredmeti;
        if(ciklus ==1 && (redniBrojSemestra==1 || redniBrojSemestra==2)) godina=1;
        if(ciklus ==1 && (redniBrojSemestra==3 || redniBrojSemestra==4)) godina=2;
        if(ciklus ==1 && (redniBrojSemestra==5 || redniBrojSemestra==6)) godina=3;
        if(ciklus ==2 && (redniBrojSemestra==1 || redniBrojSemestra==2)) godina=4;
        if(ciklus ==2 && (redniBrojSemestra==3 || redniBrojSemestra==4)) godina=5;
        if(ciklus ==3 && (redniBrojSemestra==1 || redniBrojSemestra==2)) godina=6;
        if(ciklus ==3 && (redniBrojSemestra==3 || redniBrojSemestra==4)) godina=7;

    }

    public ArrayList<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(ArrayList<Predmet> predmeti) {
        this.predmeti = predmeti;
    }

    public int getCiklus() {
        return ciklus;
    }

    public void setCiklus(int ciklus) {
        this.ciklus = ciklus;
    }

    public int getRedniBrojSemestra() {
        return redniBrojSemestra;
    }

    public void setRedniBrojSemestra(int redniBrojSemestra) {
        this.redniBrojSemestra = redniBrojSemestra;
    }

    public ArrayList<Predmet> getIzborniPredmeti() {
        return izborniPredmeti;
    }

    public void setIzborniPredmeti(ArrayList<Predmet> izborniPredmeti) {
        this.izborniPredmeti = izborniPredmeti;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }
}
