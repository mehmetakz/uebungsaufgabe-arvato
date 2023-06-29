package tests;

import klassen.Automat;
import klassen.Getraenke;
import logik.AutomatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutomatServiceTest {
    AutomatService automatService;
    Automat automat;

    @BeforeEach
    void setUp(){
        automatService = new AutomatService();
        automat = automatService.erstelleAutomatMitGetraenke("Universität", 100);
    }
    @Test
    void erstelleGetraenke() {
        Getraenke getraenke = automatService.erstelleGetraenke("cola", 1.05, 4);
        assertNotNull(getraenke);
        assertEquals("cola", getraenke.getNameGetraenk());
        assertEquals(1.05, getraenke.getKosten());
        assertEquals(4, getraenke.getAnzahl());
    }
    @Test
    void erstelleAutomatMitGetraenkeTest(){
        Automat automat = automatService.erstelleAutomatMitGetraenke("Universität", 100);
        assertNotNull(automat);
        assertInstanceOf(Automat.class, automat);
        assertEquals("Wasser",
                automatService.erstelleAutomatMitGetraenke("Universität", 100).getFaecher().get('B').getNameGetraenk());
    }
    @Test
    void guthabenEinwerfenTest(){
        //Guthaben steigert sich bei einer Automateninstanz
        assertEquals(2.00, automatService.guthabenEinwerfen(2.00, automat));
        assertEquals(4.00, automatService.guthabenEinwerfen(2.00, automat));
        //Guthaben muss 6.00€ betragen
        assertNotEquals(2.00, automatService.guthabenEinwerfen(2.00, automat));
    }

    @Test
    void getrankeKaufenTest(){
        assertNotNull(automatService.getraenkKaufen(automat, 'A'));
        assertEquals("Cola", automatService.getraenkKaufen(automat, 'A').getFaecher().get('A').getNameGetraenk());
    }

}