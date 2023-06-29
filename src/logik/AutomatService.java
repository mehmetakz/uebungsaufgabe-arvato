package logik;

import klassen.Automat;
import klassen.Getraenke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AutomatService {
    /*
     Hier werden die Getränke erstellt mit der Anzahl an verfügbaren Gertränken die später in den Automaten sollen.
     Mit simplen Überprüfungen sodass keine "leeren" Getränke erfasst werden.
     */
    public Getraenke erstelleGetraenke(String name, double preis, int anzahl){
        if (name.equals("")|| preis<= 0.05 || anzahl<= 0){
            return null;
        }
        return new Getraenke(name, preis, anzahl);
    }

    /*
        Hier wird der Automat angelegt und der Standort festgesetzt.
        Zusätzlich werden die Getränke hinzugefügt samt name, preis und anzahl.
        Am Ende wird eine Instanz von einem Automaten erzeugt.
     */
    public Automat erstelleAutomatMitGetraenke(String automatName, double guthabenDesAutomaten){
        HashMap<Character, Getraenke> getraenkeListe = new HashMap<Character, Getraenke>();
        getraenkeListe.put('A', erstelleGetraenke("Cola", 1.80, 10));
        getraenkeListe.put('B', erstelleGetraenke("Wasser", 1.10, 9));
        getraenkeListe.put('C', erstelleGetraenke("Fanta", 1.80, 8));
        getraenkeListe.put('D', erstelleGetraenke("Sprite", 1.80, 4));
        getraenkeListe.put('E', erstelleGetraenke("Capri Sonne", 0.5, 11));
        getraenkeListe.put('F', erstelleGetraenke("Limonade", 2.20, 2));
        return new Automat(automatName, getraenkeListe, guthabenDesAutomaten);
    }

    // Guthaben wird eingeworfen und nur Münzen aus validem Bereich werden entgegengenommen.
    public double guthabenEinwerfen(double geldInMuenzen, Automat automat){
        if (geldInMuenzen == 0.10 || geldInMuenzen == 0.20 || geldInMuenzen == 0.50 || geldInMuenzen == 1.00 || geldInMuenzen == 2.00){
            automat.setGuthabenDesKunden(geldInMuenzen + automat.getGuthabenDesKunden());
        };
        return automat.getGuthabenDesKunden();
    }

    public double getraenkKaufen(Automat automat, char auswahl){
        double guthabenKunde = automat.getGuthabenDesKunden();
        double guthabenAutomat = automat.getGuthabenDesAutomaten();

        System.out.println("Welches Getränk willst du haben? Wähle ein Fach aus!");

        for (Map.Entry<Character, Getraenke> entry : automat.getFaecher().entrySet()){
            System.out.println("Fach: " +entry.getKey() + " " + entry.getValue().getNameGetraenk() + " kostet " + entry.getValue().getKosten());
        }
        // Automat überprüft, ob es einen Fehler gibt beim Guthaben des Automaten oder dem Kunden und prüft ob im Fach genügend Getränke da sind
        if (automat.getFaecher().get(auswahl).getAnzahl()<=0){
            System.out.println("Dieses Fach ist leider leer.");
        } else if(automat.getGuthabenDesAutomaten()<automat.getFaecher().get(auswahl).getKosten()){
            System.out.println("Leider nicht genug Wechselgeld im Automaten vorhanden");
        } else if(automat.getGuthabenDesKunden()>=automat.getFaecher().get(auswahl).getKosten()){
            System.out.println("Leider reicht ihr Guthaben nicht aus. Bitte laden sie mehr Geld auf.");
        } else {
            System.out.println("Ausgabe vom Getränk: " + automat.getFaecher().get(auswahl).getNameGetraenk());
            //Um eine Einheit reduzieren
            automat.getFaecher().get(auswahl).setAnzahl(automat.getFaecher().get(auswahl).getAnzahl() - 1);
            guthabenKunde = guthabenKunde - automat.getFaecher().get(auswahl).getKosten();


        }




        return 0.00;
    }



    public static void main(String[] args){


    }
}
