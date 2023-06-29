package klassen;

public class Getraenke {

    private String nameGetraenk;
    private double kosten;
    private int anzahl;


    public Getraenke(String nameGetraenk, double kosten, int anzahl) {
        this.nameGetraenk = nameGetraenk;
        this.kosten = kosten;
        this.anzahl = anzahl;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public String getNameGetraenk() {
        return nameGetraenk;
    }

    public void setNameGetraenk(String nameGetraenk) {
        this.nameGetraenk = nameGetraenk;
    }

    public double getKosten() {
        return kosten;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }
}
