package klassen;

import java.util.HashMap;

public class Automat {
    private String automatName;
    private HashMap<Character, Getraenke > faecher = new HashMap<Character, Getraenke>();

    private double guthabenDesAutomaten;
    private double guthabenDesKunden;

    public Automat(String automatName, HashMap<Character, Getraenke> faecher, double guthabenDesAutomaten) {
        this.automatName = automatName;
        this.faecher = faecher;
        this.guthabenDesAutomaten = guthabenDesAutomaten;
    }

    public double getGuthabenDesAutomaten() {
        return guthabenDesAutomaten;
    }

    public void setGuthabenDesAutomaten(double guthabenDesAutomaten) {
        this.guthabenDesAutomaten = guthabenDesAutomaten;
    }

    public double getGuthabenDesKunden() {
        return guthabenDesKunden;
    }

    public void setGuthabenDesKunden(double guthabenDesKunden) {
        this.guthabenDesKunden = guthabenDesKunden;
    }

    public String getAutomatName() {
        return automatName;
    }

    public void setAutomatName(String automatName) {
        this.automatName = automatName;
    }

    public HashMap<Character, Getraenke> getFaecher() {
        return faecher;
    }

    public void setFaecher(HashMap<Character, Getraenke> faecher) {
        this.faecher = faecher;
    }
}
